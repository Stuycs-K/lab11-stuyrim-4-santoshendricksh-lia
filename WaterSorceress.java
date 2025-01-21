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
    return "Dewdrops";
  }

  public int getSpecial(){
    return dewdrops;
  }

  public int getSpecialMax(){
    return dewdropsMax;
  }

  public void setSpecial(int n){
    if (n < dewdropsMax){
      dewdrops = n;
    }
    else{
      dewdrops = dewdropsMax;
    }
  }

  public String attack(ArrayList<Adventurer> enemies, int target){
    Adventurer other = enemies.get(target);
    int damage = 2;
    int realDamage = this.realDamage(damage);
    other.applyDamage(realDamage);
    this.restoreSpecial(3);
    other.setDmgDebuff(2); //change documentation in github to reflect this nerf
    return this + " calls forth an acid waterfall upon " + other + ", dealing " + realDamage + " DMG! " + other + " deals 2 less DMG the next round. Furthermore, " + this + " gains 3 dewdrops!";
  }

  public String specialAttack(ArrayList<Adventurer> enemies, int target){
    Adventurer other = enemies.get(target);
    if (this.getSpecial() >= 8){
      this.setSpecial(this.getSpecial() - 8);
      int damage = 6;
      int realDamage = this.realDamage(damage);
      for (int count = 0; count < enemies.size(); count++){
          enemies.get(count).applyDamage(realDamage);
      }
      return this + " summons a drowning vortex, dealing " + realDamage + " DMG to all enemies!";
    }
    else{
      return "Not enough dewdrops to summon a drowning vortex. Instead, " + this.attack(enemies, target);
    }
  }
  public int getSpecialReq() {
    return 8;
  }

  public String support(){
    int prevHP = this.getHP();
    int prevMaxHP = this.getmaxHP();
    int healing = (int) (Math.random() * 2) + 1;
    this.setHP(prevHP + healing);
    this.setmaxHP(prevMaxHP + 2);
    return this + " gains the blessing of the lake, healing herself for " + (this.getHP() - prevHP) + " HP and increasing her max health by 2HP.";
  }

  public String support(ArrayList<Adventurer> party, int target){
    Adventurer other = party.get(target);
    if (this.getHP() > 4){
      this.applyDamage(4);
      int prevHP = other.getHP();
      other.setHP(prevHP + 2);
      int prevSpecial = other.getSpecial();
      other.restoreSpecial(2);
      return this + " performs the Ocean's Sacrifice, losing 4 HP in exchange for " + other + " gaining " + (other.getHP() - prevHP) + " HP and " + (other.getSpecial() - prevSpecial) + " " + other.getSpecialName() +"!";
    }
    else{
      return this + " does not have enough HP to perform the Ocean's Sacrifice. Instead " + this.support();
    }
  }

}
