/**
* Pokemon class
* @author Brandon Jue
*/

public abstract class Pokemon extends Entity{

  /**
  * a list of lists retaining the fight interaction between types
  */
   static final double [][] battleTable = {{1, .5, 2}, {2, 1, .5}, {.5, 2, 1}};

  /**
  * constructor class creating Pokemon instance with the name n, current Hp h, and current maxHp m
  * @param n String
  * @param h int
  * @param m int
  */

    public Pokemon(String n, int h, int m){
        super(n, h, m);
    }

  /**
   * returns a String of the attack menu options
   * @return a list of attack types that can be used
   */

    public String getAttackTypeMenu(){
        return "1. Basic Attack\n2. Special Attack";
    }

    /**
     * returns an int of the number of attack type menu items
     * @return the int 2
     */
    public int getNumAttackTypeMenuItems(){
        return 2;
    }

    /**
     * returns a string of the basic attack menu items
     * @param atkType int
     * @return string of basic attack menu
     */
    public String getAttackMenu(int atkType){
      if (atkType == 3){
        return "1. Slam\n2. Tackle\n3. Punch";
        }
      else{
        return null;
      }
    }

    /**
    * returns an int of the number of basic attack menu items
    * @param atkType int
    * @return number of attack menu items
    */
    public int getNumAttackMenuItems(int atkType){
        return 3;
    }

    /**
     * attack Method
     * @param p
     * @param atkType
     * @param move
     * @return a string with the multiplier added.
     */
    public String attack(Pokemon p, int atkType, int move){
        int y = (getAttackDamage(atkType, move) + getAttackBonus(atkType));
        if (y <= 0){
          return p.getName() + " avoids " + getAttackString(atkType, move) + " and takes " + 0 + " damage!";
        }
        else{
          int x = (int)(( y * getAttackMultiplier(p, atkType)));
          p.takeDamage(x);
          return p.getName() + " gets hit by " + getAttackString(atkType, move) + " and takes " + x + " damage!";
        }
        
    }

  /**
  * returns a string of what move is being executed
  * @param atkType int
  * @param move int
  * @return string stating the attack
  */
    public String getAttackString(int atkType, int move){
       switch (move) {
           case 1:
               return "SLAM";
           case 2:
               return "TACKLE";
           case 3:
               return "PUNCH";
           default:
               break;
       }
        return null;
    }
    /**
     * getAttackDamage Method
     * @param atkType int
     * @param move int
     * @return random number for the damage,
     */
    public int getAttackDamage(int atkType, int move){
       switch (move) {
           case 1:
               return (int)(Math.random() * 6);
           case 2:
               return (int)(Math.random() * 2) + 2;
           case 3:
               return (int)(Math.random() * 4) + 1;
           default:
               break;
       }
        return 0;
    }

  /**
  * returns the attack multiplier
  * @param p Pokemon
  * @param atkType int
  * @return double 1
  */
    public double getAttackMultiplier(Pokemon p, int atkType){
        return 1;
    }
    
    /**
     * getAttackBonus Method
     * @param atkType int
     * @return 0
     */
    public int getAttackBonus(int atkType){
       return 0;
    }
   
   /**
   * returns an int representing the type of the Pokemon
   * @return pokemon typing int
   */ 
    public int getType(){
        int type = 3;
        if (this instanceof Fire){
            type = 0;
        }
        else if (this instanceof Water){
            type = 1;
        }
        else if(this instanceof Grass){
            type = 2;
        }
        return type;
    }

}
