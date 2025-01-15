
import java.util.ArrayList;

public class ElectroBoss extends Adventurer {
  int photons, photonMax;

  public ElectroBoss(String name, int hp){
    super(name, hp);
    photonMax = 3;
    photons = 0;
  }

  public ElectroBoss(String name){
    this(name, 80);
  }

  public ElectroBoss(){
    this("Potentious");
  }

  public String getSpecialName() {
    return "Tainted Photons";
  }
  //accessor methods
  public int getSpecial() {
    return photons;
  }
  public int getSpecialMax() {
    return photonMax;
  }
  public void setSpecial(int n) {
    photons = n;
  }

  public String attack(ArrayList<Adventurer> enemies) {
    int rand = (int) (Math.random() * enemies.size());
    String ret = getName() + "used Thunder Pulse, dealing 3 damage to " + enemies.get(rand).getName() + " and 2 to the rest.";
    for (int i = 0; i < enemies.size(); i++) {
      if (i == rand) {
        enemies.get(i).applyDamage(3);
        int rand2 = (int) (Math.random() * 100);
        if (rand2 < 50) {
          enemies.get(i).setBurned(3);
          ret += " " + enemies.get(i).getName() + "was also burned.";
        } else if (rand2 < 75) {
          enemies.get(i).setParalyzed(3);
          ret += " " + enemies.get(i).getName() + "was also paralyzed.";
        }
      } else {
        enemies.get(i).applyDamage(2);
      }
    }
    return ret;
  }

  public String attack(Adventurer other) {
    System.out.println("also remember to ask about continuous amp valuesremember to edit codewarrior to support extar effects likeburning/poison");
    return "this is a placeholder func, ask mr k if you can change abstract attack parameters";
  }

  /*This is an example of an improvement that you can make to allow
   * for more flexible targetting.
   */
  //heal or buff the party
  //public abstract String support(ArrayList<Adventurer> others);

  //heal or buff the target adventurer
  public String support(Adventurer other) {
    return this.support();
  }

  //heal or buff self
  public String support() {
    photons++;
    int rand = (int)(Math.random() * 2);
    if (rand == 0) {
      dmgBuff += (int) (Math.random() * 4) + 2;
    } else {
      dmgAmp = (int) (Math.random() * 2) + 1.5;
    }
    return this.getName() + " used Flash Forward, gaining a Tainted Photon and buffing himself";
  }

  //hurt or hinder the target adventurer, consume some special resource
  public String specialAttack(Adventurer other) {
    photons = 0;
    int rand = (int) (Math.random() * 10);
    if (rand < 3) {
      other.applyDamage(other.getHP());
    }
  }
}
