import java.util.*;
public class Game{
  private static final int WIDTH = 80;
  private static final int HEIGHT = 30;
  private static final int BORDER_COLOR = Text.BLACK;
  private static final int BORDER_BACKGROUND = Text.WHITE + Text.BACKGROUND;

  public static void main(String[] args) {
    Text.clear();

    // drawBackground();
    // ArrayList<Adventurer> party = new ArrayList<>();
    // /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    // //YOUR CODE HERE
    // FireMage p1 = new FireMage("henry");
    // p1.applyDamage(17);
    // WaterSorceress p2 = new WaterSorceress("Santos");
    // party.add(p1);
    // party.add(p2);
    // drawParty(party, 25);
    // wait(7000);
    // Text.clear();
    // Text.reset();

    run();
  }

  public static void wait(int millis){
    try {
      Thread.sleep(millis);
    }
      catch (InterruptedException e) {
    }
  }

  //Display the borders of your screen that will not change. 80x31
  //Do not write over the blank areas where text will appear or parties will appear.
  public static void drawBackground(){
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    for (int count = 1; count <= 31; count++){
      if (count == 1 || count == 31){
        for (int innerCount = 1; innerCount < 81; innerCount++){
          Text.go(count, innerCount);
          Text.color(Text.WHITE, Text.background(Text.WHITE));
          System.out.print(".");
          Text.reset();
        }
      }
      else{
        Text.go(count, 1);
        Text.color(Text.WHITE, Text.background(Text.WHITE));
        System.out.print(".");
        //System.out.print(Text.WHITE);
        Text.go(count, 80);
        Text.color(Text.WHITE, Text.background(Text.WHITE));
        System.out.print(".");
        Text.reset();
      }
    }

    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }

  //Display a line of text starting at
  //(columns and rows start at 1 (not zero) in the terminal)
  //use this method in your other text drawing methods to make things simpler.
  public static void drawText(String s,int startRow, int startCol){
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    Text.go(startRow, startCol);
    System.out.print(s);
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }

  /*Use this method to place text on the screen at a particular location.
  *When the length of the text exceeds width, continue on the next line
  *for up to height lines.
  *All remaining locations in the text box should be written with spaces to
  *clear previously written text.
  *@param row the row to start the top left corner of the text box.
  *@param col the column to start the top left corner of the text box.
  *@param width the number of characters per row
  *@param height the number of rows
  */
  public static void TextBox(int row, int col, int width, int height, String text){
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    //int index = 0;
    String padding = new String("");
    for (int i = 0; i < width*height - text.length(); i++) {
      padding += " ";
    }
    String boxText = text + padding;

    //Text.go(row, col);

    for (int i = 0; i < height; i++) {
      //System.out.print(boxText.substring(i * width, (i + 1) * width));
      drawText(boxText.substring(i * width, (i + 1) * width), row + i, col);
    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }




    //return a random adventurer (choose between all available subclasses)
    //feel free to overload this method to allow specific names/stats.
    public static Adventurer createRandomAdventurer(){
      return new CodeWarrior("Bob"+(int)(Math.random()*100));
    }

    /*Display a List of 2-4 adventurers on the rows row through row+3 (4 rows max)
    *Should include Name HP and Special on 3 separate lines.
    *Note there is one blank row reserved for your use if you choose.
    *Format:
    *Bob          Amy        Jun
    *HP: 10       HP: 15     HP:19
    *Caffeine: 20 Mana: 10   Snark: 1
    * ***THIS ROW INTENTIONALLY LEFT BLANK***
    */
    public static void drawParty(ArrayList<Adventurer> party,int startRow){

      /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
      //YOUR CODE HERE
      for(int i = 0; i < party.size(); i++) {
        // x coord is i * 78 / party.length
        drawText(party.get(i).getName(), startRow, i * (78 / party.size()) + 3);
        drawText("HP: " + colorByPercent(party.get(i).getHP(), party.get(i).getmaxHP()), startRow + 1, i * (78 / party.size()) + 3);
        drawText(party.get(i).getSpecialName() + ": " + party.get(i).getSpecial(), startRow + 2, i * (78 / party.size()) + 3);
      }
      /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
    }


  //Use this to create a colorized number string based on the % compared to the max value.
  public static String colorByPercent(int hp, int maxHP){
    String output = String.format("%2s", hp+"")+"/"+String.format("%2s", maxHP+"");
    //COLORIZE THE OUTPUT IF HIGH/LOW:
    // under 25% : red
    if ((double) hp / maxHP < 0.25) {
      output = Text.colorize(output, Text.RED);
    } else if ((double) hp / maxHP < 0.75) {
      output = Text.colorize(output, Text.YELLOW);
    } else {
      output = Text.colorize(output, Text.WHITE);
    }
    // under 75% : yellow
    // otherwise : white
    return output;
  }





  //Display the party and enemies
  //Do not write over the blank areas where text will appear.
  //Place the cursor at the place where the user will by typing their input at the end of this method.
  public static void drawScreen(ArrayList<Adventurer>enemies, ArrayList<Adventurer> party){

    drawBackground();

    //draw enemy party
    TextBox(2, 2, 78, 4, " ");
    drawParty(enemies, 2);

    //draw player party
    TextBox(25, 2, 78, 4, " ");
    drawParty(party, 25);

    Text.go(2, 30);

  }

  public static String userInput(Scanner in){
      //Move cursor to prompt location
      Text.go(30,2);
      //show cursor
      Text.showCursor();
      String input = in.nextLine();
      while (!checkInputValid(input)) {
        String errMsg = "Thats not a choice! Enter command: attack/special/quit";

        TextBox(29, 2, 74, 1, errMsg);
        TextBox(30,2,78,1," ");
        Text.go(30,2);
        input = in.nextLine();

      }

      //clear the text that was written
      TextBox(30,2,78,1," ");

      Text.go(30,2);

      return input;
  }

  public static void quit(){
    Text.reset();
    Text.showCursor();
    Text.go(32,1);
  }

  public static void killDead(ArrayList<Adventurer> party) {
    for (int i = 0; i < party.size(); i++) {
      if (party.get(i).getHP() <= 0) {
        // announce death
        // DO THISSSSSSSSSSSSSSSSSSS
        party.remove(i);
        i--;
      }
    }
  }

  public static boolean checkInputValid(String input) {
    String[] actionList = {"attack ", "a ", "special ", "sp ", "support ", "su", "q", "quit"};
    for (String choice : actionList) {
      if (input.startsWith(choice)) {
        return true;
      }
    }
    return false;
  }

  public static boolean winOrLose(ArrayList<Adventurer> players, ArrayList<Adventurer> enemies) {
    if (players.size() == 0) {
      TextBox(2,2,78, 29, " ");
      drawText("Tough luck -- you lost. Better luck next time", 14, 4);
      return true;
    } else if (enemies.size() == 0) {
      TextBox(2,2,78, 29, " ");
      drawText("Congrats! You won! Good job.", 14, 27);
      return true;
    }
    return false;
  }

  public static void run(){
    //Clear and initialize
    Text.hideCursor();
    Text.clear();


    //Things to attack:
    //Make an ArrayList of Adventurers and add 1-3 enemies to it.
    //If only 1 enemy is added it should be the boss class.
    //start with 1 boss and modify the code to allow 2-3 adventurers later.
    ArrayList<Adventurer>enemies = new ArrayList<Adventurer>();
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    int random = (int) (Math.random() * 4);
    if (random == 0){
      Boss boss = new Boss();
      enemies.add(boss);
    }
    else if (random == 1){
      FireMage enemyOne = new FireMage();
      enemies.add(enemyOne);
      WaterSorceress enemyTwo = new WaterSorceress();
      enemies.add(enemyTwo);
    }
    else{
      FireMage enemyOne = new FireMage();
      enemies.add(enemyOne);
      WaterSorceress enemyTwo = new WaterSorceress();
      enemies.add(enemyTwo);
      GaiaArcher enemyThree = new GaiaArcher();
      enemies.add(enemyThree);
    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    //Adventurers you control:
    //Make an ArrayList of Adventurers and add 2-4 Adventurers to it.
    ArrayList<Adventurer> party = new ArrayList<>();
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    Scanner in = new Scanner(System.in);
    FireMage p1 = new FireMage("Fire Mage");
    WaterSorceress p2 = new WaterSorceress("Water Sorceress");
    GaiaArcher p3 = new GaiaArcher("Gaia's Archer");
    party.add(p1);
    party.add(p2);
    party.add(p3);
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    boolean partyTurn = true;
    int whichPlayer = 0;
    int whichOpponent = 0;
    int turn = 0;
    String input = "";//blank to get into the main loop.
    //Draw the window border

    //You can add parameters to draw screen!
    drawScreen(enemies, party);//initial state.

    //Main loop

    //display this prompt at the start of the game.
    String preprompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";

    TextBox(29, 2, 74, 1, preprompt);

    while(! (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit"))){
      //Read user input




      String action = new String();

      //example debug statment
      //TextBox(2,24,78,1,"input: "+input+" partyTurn:"+partyTurn+ " whichPlayer="+whichPlayer+ " whichOpp="+whichOpponent );

      //display event based on last turn's input
      if(partyTurn){
        input = userInput(in);

        //Process user input for the last Adventurer:
        if(input.startsWith("attack ") || input.startsWith("a ")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          //YOUR CODE HERE
          String[] inputArray = input.split(" ");
          action = party.get(whichPlayer).attack(enemies, Integer.parseInt(inputArray[1]) - 1);
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else if(input.startsWith("special ") || input.startsWith("sp ")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          //YOUR CODE HERE
          String[] inputArray = input.split(" ");
          action = party.get(whichPlayer).specialAttack(enemies, Integer.parseInt(inputArray[1]) - 1);
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else if (input.equals("support")){
          action = party.get(whichPlayer).support();
        }
        else if(input.startsWith("su ") || input.startsWith("support ")){
          //"support 0" or "su 0" or "su 2" etc.
          //assume the value that follows su  is an integer.
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          //YOUR CODE HERE
          String[] inputArray = input.split(" ");
          if (party.get(whichPlayer).equals(party.get(Integer.parseInt(inputArray[1]) - 1))){
            action = party.get(whichPlayer).support();
          }
          else{
            action = party.get(whichPlayer).support(party, Integer.parseInt(inputArray[1]) - 1);
          }
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }

        // check for deaths
        killDead(party);
        killDead(enemies);

        // THIS IS WHERE IT WAS
        TextBox(8, 3, 76, 12, action);
        drawScreen(enemies, party);
        if (winOrLose(party, enemies)) {
          quit();
          return;
        }

        //You should decide when you want to re-ask for user input
        //If no errors:
        whichPlayer++;


        if(whichPlayer < party.size()){
          //This is a player turn.
          //Decide where to draw the following prompt:
          String prompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";
          //drawText(prompt, 29, 2);
          TextBox(29, 2, 78, 1, prompt);


        }else{
          //This is after the player's turn, and allows the user to see the enemy turn
          //Decide where to draw the following prompt:

          // checking for status effects
          for (int i = 0; i < party.size(); i++) {
            if (party.get(i).poisonedValue() > 0) {
              party.get(i).applyDamage(1);
              party.get(i).setPoison(party.get(i).poisonedValue() - 1);
            }
            if (party.get(i).burnedValue() > 0) {
              party.get(i).applyDamage(2);
              party.get(i).setBurned(party.get(i).burnedValue() - 1);
            }
          }

          String prompt = "press enter to see monster's turn";
          TextBox(29, 2, 78, 1, prompt);
          in.nextLine();

          partyTurn = false;
          whichOpponent = 0;
        }
        //done with one party member
      }else{
        //not the party turn!


        //enemy attacks a randomly chosen person with a randomly chosen attack.z`
        //Enemy action choices go here!
        /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
        //YOUR CODE HERE
        int target = (int) (Math.random() * (party.size()));
        int move = (int) (Math.random() * 2);

        if (move == 0) { // attack

          if (enemies.get(whichOpponent).getSpecial() >= enemies.get(whichOpponent).getSpecialReq()) {
            action = enemies.get(whichOpponent).specialAttack(party, target);
          } else {
            action = enemies.get(whichOpponent).attack(party, target);
          }
        }  else if (move == 1) {
          int supportTarget = (int) (Math.random() * enemies.size());
          if (supportTarget == whichOpponent) {
            action = enemies.get(whichOpponent).support();
          } else {
            action = enemies.get(whichOpponent).support(enemies, supportTarget);
          }
        }

        killDead(party);
        killDead(enemies);
        /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        TextBox(8, 3, 76, 12, action);
        drawScreen(enemies, party);
        if (winOrLose(party, enemies)) {
          quit();
          return;
        }


        //Decide where to draw the following prompt:
        String prompt = "press enter to see next turn";
        TextBox(29, 2, 78, 1, prompt);
        in.nextLine();

        whichOpponent++;

      }//end of one enemy.

      //modify this if statement.
      if(!partyTurn && whichOpponent >= enemies.size()){
        //THIS BLOCK IS TO END THE ENEMY TURN
        //It only triggers after the last enemy goes.
        for (int i = 0; i < enemies.size(); i++) {
          if (enemies.get(i).poisonedValue() > 0) {
            enemies.get(i).applyDamage(1);
            enemies.get(i).setPoison(enemies.get(i).poisonedValue() - 1);
          }
          if (enemies.get(i).burnedValue() > 0) {
            enemies.get(i).applyDamage(2);
            enemies.get(i).setBurned(enemies.get(i).burnedValue() - 1);
          }
        }
        whichPlayer = 0;
        turn++;
        partyTurn=true;
        //display this prompt before player's turn
        String prompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";
        TextBox(29, 2, 78, 1, prompt);
      }

      //display the updated screen after input has been processed.
      TextBox(8, 3, 76, 12, action);
      drawScreen(enemies, party);


    }//end of main game loop

    //After quit reset things:
    quit();
  }
}
