import java.util.Random;
import java.util.ArrayList;
public abstract class Adventurer{
  private String name;
  private int HP,maxHP,isBurned, dmgBuff, dmgDebuff, paralyzed, poisoned, healingOverTime;
  private double dmgAmp;


  //Abstract methods are meant to be implemented in child classes.
  /*
  all adventurers must have a custom special
  consumable resource (mana/rage/money/witts etc)
  */

  //give it a short name (fewer than 13 characters)
  public abstract String getSpecialName();
  //accessor methods
  public abstract int getSpecial();
  public abstract int getSpecialMax();
  public abstract void setSpecial(int n);
  public abstract int getSpecialReq();

  //concrete method written using abstract methods.
  //refill special resource by amount, but only up to at most getSpecialMax()
  public int restoreSpecial(int n){
    if( n > getSpecialMax() - getSpecial()){
      n = getSpecialMax() - getSpecial();
    }
    setSpecial(getSpecial()+n);
    return n;
  }

  public int realDamage(int baseDamage){
    int toReturn = baseDamage;
    toReturn += this.dmgBuffValue();
    this.setDmgBuff(0);
    toReturn -= this.dmgDebuffValue();
    this.setDmgDebuff(0);
    if (this.poisonedValue() > 0){
      toReturn = (int) (toReturn * 0.8);
    }
    return toReturn;
  }
  /*
  all adventurers must have a way to attack enemies and
  support their allys
  */
  //hurt or hinder the target adventurer
  public abstract String attack(ArrayList<Adventurer> enemies, int target);

  /*This is an example of an improvement that you can make to allow
   * for more flexible targetting.
   */
  //heal or buff the party
  //public abstract String support(ArrayList<Adventurer> others);

  //heal or buff the target adventurer
  public abstract String support(ArrayList<Adventurer> party, int target);

  //heal or buff self
  public abstract String support();

  //hurt or hinder the target adventurer, consume some special resource
  public abstract String specialAttack(ArrayList<Adventurer> enemies, int target);

  /*
  standard methods
  */

  public void applyDamage(int amount){
    this.HP -= amount;
  }

  //You did it wrong if this happens.
  public Adventurer(){
    this("Lester-the-noArg-constructor-string");
  }

  public Adventurer(String name){
    this(name, 10);
  }

  public Adventurer(String name, int hp){
    this.name = name;
    this.HP = hp;
    this.maxHP = hp;
    this.isBurned = 0;
    this.dmgBuff = 0;
    this.dmgAmp = 1.0;
    this.dmgDebuff = 0;
    this.poisoned = 0;
    this.paralyzed = 0;
    this.healingOverTime = 0;
  }

  public void setHOT(int value){
    this.healingOverTime = value;
  }

  public int getHot(){
    return this.healingOverTime;
  }

  public void setParalyzed(int value){
    this.paralyzed = value;
  }

  public int paralyzedValue(){
    return this.paralyzed;
  }

  public void setPoison(int value){
    this.poisoned = value;
  }

  public int poisonedValue(){
    return this.poisoned;
  }

  public void setBurned(int value){
    this.isBurned = value;
  }

  public int burnedValue(){
    return this.isBurned;
  }

  public void setDmgBuff(int value){
    this.dmgBuff = value;
  }

  public int dmgBuffValue(){
    return this.dmgBuff;
  }

  public void setDmgAmp(double value){
    this.dmgAmp = value;
  }

  public double dmgAmpValue(){
    return this.dmgAmp;
  }

  public void setDmgDebuff(int value){
    this.dmgDebuff = value;
  }

  public int dmgDebuffValue(){
    return this.dmgDebuff;
  }

  //toString method
  public String toString(){
    return this.getName();
  }

  //Get Methods
  public String getName(){
    return name;
  }

  public int getHP(){
    return HP;
  }

  public int getmaxHP(){
    return maxHP;
  }
  public void setmaxHP(int newMax){
    maxHP = newMax;
  }

  //Set Methods
  public void setHP(int health){
    if (health >= this.getmaxHP()){
      this.HP = this.getmaxHP();
    }
    else{
      this.HP = health;
    }
  }

  public void setName(String s){
    this.name = s;
  }
}
