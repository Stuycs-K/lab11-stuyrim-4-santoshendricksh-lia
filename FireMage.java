import java.util.*;
public class FireMage extends Adventurer{
  public FireMage(String name, int hp, String language){
    super(name, hp);
    rageMax = 12;
    rage = 0;
    preferredLanguage = language;
  }
}
