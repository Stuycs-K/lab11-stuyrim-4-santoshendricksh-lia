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
    if (n < rageMax){
      rage = n;
    }
    else{
      rage = rageMax;
    }
  }

  public String attack(Adventurer other){
    int damage = (int)(Math.random() * 5) + 3;
    other.isBurned = 2;
    other.applyDamage(damage);
    restoreSpecial(2);
    return this + " launched a barrage of fireballs at " + other + " and dealt " + damage + " DMG!" + other + " is now burned.";
  }

}
