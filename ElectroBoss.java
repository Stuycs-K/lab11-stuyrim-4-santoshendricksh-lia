public class ElectroBoss extends Adventurer {
  int photons, photonMax;
  int dmgBuff;
  double dmgAmp;

  public ElectroBoss(String name, int hp){
    super(name, hp);
    photonMax = 3;
    photons = 0;
    dmgBuff = 0;
    dmgAmp = 1.0;
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

  public String attack(Adventurer other) {
    System.out.println("also remember to ask about continuous amp valuesremember to edit codewarrior to support extar effects likeburning/poison");

  }

  /*This is an example of an improvement that you can make to allow
   * for more flexible targetting.
   */
  //heal or buff the party
  //public abstract String support(ArrayList<Adventurer> others);

  //heal or buff the target adventurer
  public abstract String support(Adventurer other) {
    this.support();
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
  public abstract String specialAttack(Adventurer other);
}
