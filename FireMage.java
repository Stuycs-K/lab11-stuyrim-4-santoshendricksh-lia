import java.util.*;
public class FireMage extends Adventurer{
  public FireMage(String name, int hp, String language){
    super(name, hp);
    rageMax = 12;
    rage = 0;
    preferredLanguage = language;
  }

  public FireMage(String name, int hp){
    this(name, hp, "english");
  }

  public FireMage(String name){
    this(name, 18);
  }

  public FireMage(){
    this("Roku");
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
    rage = n;
  }

}
