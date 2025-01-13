import java.util.*;
public class WaterSorceress extends Adventurer{
  int dewdrops, dewdropsMax;
  public WaterSorceress(String name, int hp){
    super(name, hp);
    dewdropsMax = 12;
    dewdrops = 0;
  }

  public WaterSorceress(String name){
    this(name, 30);
  }

  public WaterSorceress(){
    this("Primarina");
  }

  public String getSpecialName(){
    return "dewdrops";
  }

  public int getSpecial(){
    return dewdrops;
  }

  public int getSpecialMax(){
    return dewdropsMax;
  }

  public void setSpecial(int n){
    if (n < rageMax){
      dewdrops = n;
    }
    else{
      dewdrops = rageMax;
    }
  }

}
