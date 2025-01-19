import java.util.*;
public class FireMage extends Adventurer{
  int rage, rageMax;
  public FireMage(String name, int hp){
    super(name, hp);
    rageMax = 12;
    rage = 0;
  }

  public FireMage(String name){
    this(name, 18);
  }

  public FireMage(){
    this("Delphox");
  }

  public String getSpecialName(){
    return "rage";
  }

  public int getSpecial(){
    return rage;
  }

  public int getSpecialMax(){
    return rageMax;
  }

  public void setSpecial(int n){
    if (n < rageMax){
      rage = n;
    }
    else{
      rage = rageMax;
    }
  }

  public String attack(ArrayList<Adventurer> enemies, int target){
    Adventurer other = enemies.get(target);
    int damage = (int)(Math.random() * 5) + 3;
    other.setBurned(2);
    other.applyDamage(this.realDamage(damage));
    this.restoreSpecial(2);
    return this + " launches a barrage of fireballs at " + other + " and deals " + damage + " DMG! " + other + " is burned. In addition, " + this + " gains 2 rage.";
  }

  public String specialAttack(ArrayList<Adventurer> enemies, int target){
    Adventurer other = enemies.get(target);
    if (getSpecial() >= 9){
      this.setSpecial(this.getSpecial() - 9);
      int damage = 10;
      other.applyDamage(this.realDamage(damage));
      for (int count = 0; count < enemies.size(); count++){
        if (!enemies.get(count).equals(other)){
          enemies.get(count).applyDamage(this.realDamage(3));
        }
      }
      return this + " calls forth a flame pillar, dealing 10 DMG to " + other + " and 3 DMG to "; //alive enemies;
    }
    else{
      return "Not enough rage to call forth a flame pillar. Instead " + attack(enemies, target);
    }
  }
  public int getSpecialReq() {
    return 9;
  }

  public String support(){
    int previousSpecial = this.getSpecial();
    this.restoreSpecial(4);
    this.setDmgBuff(this.dmgBuffValue() + 2);
    return this + " blazingly empowers himself, accumulating " + (this.getSpecial() - previousSpecial) + " rage and gaining an ATK buff of 2 DMG the next round!";
  }

  public String support(ArrayList<Adventurer> party, int target){
    Adventurer other = party.get(target);
    int dmgBuffInstance = (int) (Math.random() * 2) + 2;
    other.setDmgBuff(other.dmgBuffValue() + dmgBuffInstance);
    return this + " grants " + other + " the blessing of the sun, boosting their damage the next round by " + dmgBuffInstance + " DMG!";
  }
}
