public class ElectroBoss extends Adventurer {
  int charge;

  public String getSpecialName() {
    return "Charge";
  }
  //accessor methods
  public abstract int getSpecial() {
    return charge;
  }
  public abstract int getSpecialMax() {
    return 20;
  }
  public abstract void setSpecial(int n);
}
