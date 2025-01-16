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
    return "energy";
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

  public String attack(Adventurer other){
    int damage = (int) (Math.random() * 4) + 2;
    this.restoreSpecial(2);
    other.applyDamage(damage);
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
    return this + " shoots an arrow at " + other + ", dealing " + damage + " damage." + " " + status + " In addition, " + this + " gains 2 Energy.";
  }

  public String specialAttack(Adventurer other){
    if (this.getSpecial() >= 10){
      int damage = 5;
      other.applyDamage(damage);
      other.setParalyzed(1);
      other.setPoison(2);
      other.setBurned(2);
      return this + " launches a barrage of arrows, dealing 5 DMG to all enemies, and poisoning, burning, and paralyzing " + other +"!";
    }
    else{
      return "Not enough energy to launch a barrage of arrows. Instead, " + this.attack(other);
    }
  }

  public String support(){
    this.setHOT(3);
    return this + " is bestowed with the gift of nature, healing for 1 or 2 HP for the next three turns.";
  }

  public String support(Adventurer other){
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
