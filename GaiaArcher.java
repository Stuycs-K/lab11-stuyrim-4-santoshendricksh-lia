import java.util.*;
public class GaiaArcher extends Adventurer{
  int energy, energyMax;
  public GaiaArcher(String name, int HP){
    super(name, HP);
    energyMax = 12;
    energy = 0;
  }

  public GaiaArcher(String name){
    this(name, 24);
  }

  public GaiaArcher(){
    this("Decidueye");
  }

  public String getSpecialName(){
    return "Energy";
  }

  public int getSpecial(){
    return energy;
  }

  public int getSpecialMax(){
    return energyMax;
  }

  public void setSpecial(int n){
    if (n < energyMax){
      energy = n;
    }
    else{
      energy = n;
    }
  }

  public String attack(ArrayList<Adventurer> enemies, int target){
    Adventurer other = enemies.get(target);
    int damage = (int) (Math.random() * 4) + 2;
    int realDamage = this.realDamage(damage);
    this.restoreSpecial(2);
    other.applyDamage(realDamage);
    double randomEffect = Math.random();
    String status = "";
    if (randomEffect <= 0.33){
      other.setParalyzed(1);
      status = other + " is paralyzed!";
    }
    else if (randomEffect <= 0.66){
      other.setPoison(2);
      status = other + " is poisoned!";
    }
    else{
      other.setBurned(2);
      status = other + " is burned!";
    }
    return this + " shoots an arrow at " + other + ", dealing " + realDamage + " damage." + " " + status + " In addition, " + this + " gains 2 Energy.";
  }

  public String specialAttack(ArrayList<Adventurer> enemies, int target){
    Adventurer other = enemies.get(target);
    if (this.getSpecial() >= 10){
      this.setSpecial(this.getSpecial() - 10);
      int damage = 5;
      int realDamage = this.realDamage(damage);
      enemies.get(target).applyDamage(realDamage);
      enemies.get(target).setParalyzed(1);
      enemies.get(target).setPoison(2);
      enemies.get(target).setBurned(2);
      return this + " launches a barrage of arrows, dealing " + realDamage + " DMG to all enemies, and poisoning, burning, and paralyzing " + other +"!";
    }
    else{
      return "Not enough energy to launch a barrage of arrows. Instead, " + this.attack(enemies, target);
    }
  }
  public int getSpecialReq() {
    return 10;
  }

  public String support(){
    this.setHOT(3);
    return this + " is bestowed with the gift of nature, healing for 1 or 2 HP for the next three turns.";
  }

  public String support(ArrayList<Adventurer> party, int target){
    Adventurer other = party.get(target);
    other.setHP(other.getHP() + 1);
    other.setHOT(0);
    other.setBurned(0);
    other.setPoison(0);
    other.setDmgAmp(1.0);
    other.setDmgDebuff(0);
    other.setDmgBuff(0);
    other.setParalyzed(0);
    return this + "'s teammates feel the warmth of the sunlight's afterglow, gaining 1 HP and having all status effects cleared.";
  }

}
