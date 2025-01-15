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
}
