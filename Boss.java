
import java.util.ArrayList;
import java.util.Random;

public class Boss extends Adventurer {
  int photons, photonMax;

  public Boss(String name, int hp){
    super(name, hp);
    photonMax = 3;
    photons = 0;
  }

  public Boss(String name){
    this(name, 150);
  }

  public Boss(){
    this("Potentious");
  }

  public String getSpecialName() {
    return "Tainted Photons";
  }
  //accessor methods
  public int getSpecial() {
    return photons;
  }
  public int getSpecialMax() {
    return photonMax;
  }
  public void setSpecial(int n) {
    photons = n;
  }
  public int getSpecialReq() {
    return 3;
  }

  public String attack(ArrayList<Adventurer> enemies, int target) {
    if (this.getSpecial() >= 3){
      return specialAttack(enemies, target);
    }
    Adventurer other = enemies.get(target);
    int rand = target;
    int damage = 6;
    int damageAOE = 4;
    int realDamage = this.realDamage(damage);
    int realDamageAOE = this.realDamage(damageAOE);
    String ret = getName() + " used Thunder Pulse, dealing " + realDamage + " DMG to " + enemies.get(rand).getName() + " and " + realDamageAOE + " DMG to all other enemies.";
    for (int count = 0; count < enemies.size(); count++){
      if (!enemies.get(count).equals(other)){
        enemies.get(count).applyDamage(realDamageAOE);
      }
      else{
        enemies.get(count).applyDamage(realDamage);
        int random = (int) (Math.random() * 100);
        if (random < 50){
          other.setBurned(2);
        }
        if (random < 25){
          other.setParalyzed(1);
        }
      }
    }
    if (this.getSpecial() < this.getSpecialMax()){
      this.setSpecial(this.getSpecial() + 1);
    }
    return ret;
  }

  /*This is an example of an improvement that you can make to allow
   * for more flexible targetting.
   */
  //heal or buff the party
  //public abstract String support(ArrayList<Adventurer> others);

  //heal or buff the target adventurer
  public String support(ArrayList<Adventurer> party, int target) {
    return this.support();
  }

  //heal or buff self
  public String support() {
    if (this.getSpecial() < this.getSpecialMax()){
      this.setSpecial(this.getSpecial() + 1);
    }
    int rand = (int)(Math.random() * 2);
    if (rand == 0) {
      setDmgBuff((int) (Math.random() * 4) + 2);
    } else {
      Random rng = new Random();
      setDmgAmp(rng.nextDouble() + 1.5);
    }
    return this.getName() + " used Flash Forward, gaining a Tainted Photon and giving himself a DMG Amp!";
  }

  //hurt or hinder the target adventurer, consume some special resource
  public String specialAttack(ArrayList<Adventurer> enemies, int target) {
    if (photons < 3) {
      String earlyRet = attack (enemies, target);
      return "Did not have enough Tainted Photons to use Lightning's Roar. Instead, " + earlyRet;
    }

    photons = 0;
    int rand = (int) (Math.random() * 10);
    if (rand < 3) {
      enemies.get(target).applyDamage(enemies.get(target).getHP());
      return getName() + " used Lightning's Roar to kill " + enemies.get(target) + " instantly.";
    }
    return getName() + " used Lightning's Roar, but failed to kill " + enemies.get(target).getName() + ".";
  }
}
