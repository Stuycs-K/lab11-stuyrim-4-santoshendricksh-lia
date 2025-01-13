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

  public String attack(Adventurer other){
    int damage = 2;
    other.applyDamage(damage);
    this.restoreSpecial(3);
    other.setDmgDebuff(2); //change documentation in github to reflect this nerf
    return this + " calls forth an acid waterfall upon " + other + ", dealing 2 DMG! " + other + " deals 2 less DMG the next round. Furthermore, " + this " gains 3 dewdrops.";
  }

  public String specialAttack(Adventurer other){
    if (this.getSpecial() >= 8){
      this.setSpecial(this.getSpecial() - 8);
      int damage = 3;
      other.applyDamage(damage); //add implementation so that it targets all ENEMIES
      return this + " summons a drowning vortex, dealing 3 DMG to all enemies and making them take 1.4x DMG the next turn!";
    }
    else{
      return "Not enough dewdrops to summon a drowning vortex. Instead, " + this.attack(Adventurer other);
    }
  }

}
