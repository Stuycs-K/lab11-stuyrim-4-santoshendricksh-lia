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
    other.applyDamage(damage);
    int randomEffect = (int) (Math.random() * 3);
    String status = "";
    if (randomEffect == 0){
      other.setParalyzed(1);
      status = other + " is paralyzed!";
    }
    else if (randomEffect == 1){
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
    return "";
  }

  public String support(){
    return "";
  }

  public String support(Adventurer other){
    return "";
  }

}
