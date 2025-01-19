import java.util.ArrayList;

public class CodeWarrior extends Adventurer{
  int caffeine, caffeineMax;
  String preferredLanguage;

  /*the other constructors ultimately call the constructor
  *with all parameters.*/
  public CodeWarrior(String name, int hp, String language){
    super(name,hp);
    caffeineMax = 12;
    caffeine = caffeineMax/2;
    preferredLanguage = language;
  }

  public CodeWarrior(String name, int hp){
    this(name,hp,"c++");
  }

  public CodeWarrior(String name){
    this(name,24);
  }

  public CodeWarrior(){
    this("Carmack");
  }

  /*The next 8 methods are all required because they are abstract:*/
  public String getSpecialName(){
    return "caffeine";
  }

  public int getSpecial(){
    return caffeine;
  }

  public void setSpecial(int n){
    caffeine = n;
  }

  public int getSpecialMax(){
    return caffeineMax;
  }

  /*Deal 2-7 damage to opponent, restores 2 caffeine*/
  public String attack(ArrayList<Adventurer> enemies, int target){
    int damage = (int)(Math.random()*6)+2;
    enemies.get(target).applyDamage(damage);
    restoreSpecial(2);
    return this + " attacked "+ enemies.get(target) + " and dealt "+ damage +
    " DMG! They then take a sip of their coffee.";
  }

  /*Deal 3-12 damage to opponent, only if caffeine is high enough.
  *Reduces caffeine by 8.
  */
  public String specialAttack(ArrayList<Adventurer> enemies, int target){
    if(getSpecial() >= 8){
      setSpecial(getSpecial()-8);
      int damage = (int)(Math.random()*5+Math.random()*5)+3;
      enemies.get(target).applyDamage(damage);
      return this + " used their "+preferredLanguage+
      " skills to hack the matrix. "+
      " This glitched out "+enemies.get(target)+" dealing "+ damage +" points of damage.";
    }else{
      return "Not enough caffeine to use the ultimate code. Instead "+attack(enemies, target);
    }

  }
  /*Restores 5 special to other*/
  public String support(ArrayList<Adventurer> party, int target){
    return "Gives a coffee to "+party.get(target)+" and restores "
    + party.get(target).restoreSpecial(5)+" "+party.get(target).getSpecialName();
  }
  /*Restores 6 special and 1 hp to self.*/
  public String support(){
    int hp = 1;
    setHP(getHP()+hp);
    return this+" drinks a coffee to restores "+restoreSpecial(6)+" "
    + getSpecialName()+ " and "+hp+" HP";
  }
}
