public class Driver{
  public static void main(String[] args){
    FireMage playerOne = new FireMage();
    FireMage playerTwo = new FireMage("Fire Spirit");
    FireMage playerThree = new FireMage("Flame Golem", 25);
    if (!playerOne.getName().equals("Roku")){
      System.out.println("getName failed: default");
    }
    if (!playerTwo.getName().equals("Fire Spirit")){
      System.out.println("getName failed: Name constructor");
    }
    if (!playerThree.getName().equals("Flame Golem")){
      System.out.println("getName failed: Name and hp constructor");
    }
    if (!playerTwo.getSpecialName().equals("rage")){
      System.out.println("getSpecialName failed");
    }
    if (playerThree.getSpecialMax() != 12){
      System.out.println("getSpecialMax failed");
    }
    if (playerThree.dmgBuffValue() != 0){
      System.out.println("default dmg buff value failed");
    }
    if (playerThree.getSpecial() != 0){
      System.out.println("default rage value failed");
    }
    System.out.println(playerThree.support());
    if (playerThree.getSpecial() != 4){
      System.out.println("support rage boost failed");
    }
    if (playerThree.dmgBuffValue() != 2){
      System.out.println("support dmg buff failed");
    }
    System.out.println(playerThree.dmgBuffValue());
    System.out.println(playerTwo.support(playerThree));
    System.out.println(playerThree.dmgBuffValue());
  }
}
