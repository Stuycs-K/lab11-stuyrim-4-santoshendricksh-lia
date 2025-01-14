import java.util.*;
public class GaiaArcher extends Adventurer{
  int energy, energyMax;
  public GaiaArcher(String name, int HP){
    super(name, hp);
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
      energy = rageMax;
    }
  }

}
