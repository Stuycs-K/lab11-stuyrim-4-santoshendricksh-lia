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

  public String attack(Adventurer other){
    int damage = (int)(Math.random() * 5) + 3;
    other.setBurned(2);
    other.applyDamage(realDamage(damage));
    this.restoreSpecial(2);
    return this + " launches a barrage of fireballs at " + other + " and deals " + damage + " DMG! " + other + " is burned. In addition, " + this + " gains 2 rage.";
  }

  public String specialAttack(Adventurer other){
    if (getSpecial() >= 9){
      this.setSpecial(this.getSpecial() - 9);
      int damage = 10;
      other.applyDamage(realDamage(damage));
      // IMPLEMENT 3 DMG TO OTHER ALIVE ENEMIES
      return this + " calls forth a flame pillar, dealing 10 DMG to " + other + " and 3 DMG to "; //alive enemies;
    }
    else{
      return "Not enough rage to call forth a flame pillar. Instead " + attack(other);
    }
  }

  public String support(){
    int previousSpecial = this.getSpecial();
    this.restoreSpecial(4);
    this.setDmgBuff(this.dmgBuffValue() + 2);
    return this + " blazingly empowers himself, accumulating " + (this.getSpecial() - previousSpecial) + " rage and gaining an ATK buff of 2 DMG the next round!";
  }

  public String support(Adventurer other){
    int dmgBuffInstance = (int) (Math.random() * 2) + 2;
    other.setDmgBuff(other.dmgBuffValue() + dmgBuffInstance);
    return this + " grants " + other + " the blessing of the sun, boosting their damage the next round by " + dmgBuffInstance + " DMG!";
  }
}
