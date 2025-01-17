
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
    this(name, 80);
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

  public String attack(ArrayList<Adventurer> enemies, int target) {
    int rand = target;
    String ret = getName() + "used Thunder Pulse, dealing 3 damage to " + enemies.get(rand).getName() + " and 2 to the rest.";
    for (int i = 0; i < enemies.size(); i++) {
      if (i == rand) {
        enemies.get(i).applyDamage(realDamage(3));
        int rand2 = (int) (Math.random() * 100);
        if (rand2 < 50) {
          enemies.get(i).setBurned(2);
          ret += " " + enemies.get(i).getName() + "was also burned.";
        } else if (rand2 < 75) {
          enemies.get(i).setParalyzed(1);
          ret += " " + enemies.get(i).getName() + "was also paralyzed.";
        }
      } else {
        enemies.get(i).applyDamage(realDamage(3));
      }
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
    photons++;
    int rand = (int)(Math.random() * 2);
    if (rand == 0) {
      setDmgBuff((int) (Math.random() * 4) + 2);
    } else {
      Random rng = new Random();
      setDmgAmp(rng.nextDouble() + 1.5);
    }
    return this.getName() + " used Flash Forward, gaining a Tainted Photon and buffing himself";
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
    return getName() + " used Lightning's Roar, but failed to kill " + enemies.get(target).getName(); + ".";
  }
}
