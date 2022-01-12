/**
* creates the class object Grass for pokemon
* @author Brandon Jue
*/

public class Grass extends Pokemon{
    
    /**
     * Grass constructor create fire instance with the name n
     * @param n
     * @param h
     * @param m
     */    
    public Grass(String n, int h, int m){
        super(n, h, m);
    }

    /**
     * getAttackMenu Method overrides getAttackMenu method in Pokemon.
     * @param atkType
     * @return menu for fire special attack or basic attack
     */
    @Override
    public String getAttackMenu(int atkType){
        if (atkType == 2){
            return "1. Vinewhip\n2. Razor Leaf\n3. Solar Beam";
        }
        else if (atkType == 3){
          return super.getAttackMenu(atkType);
        }
        return null;
    }

    /**
     * getNumAttackMenuItems Method
     * @return 3
     */
    @Override
    public int getNumAttackMenuItems(int atkType){
        return 3;
    }

    /**
     * getAttackString Method overrides getAttackString method in Pokemon.
     * @param atkType
     * @param move
     * @return menu for fire special attack or basic attack
     */
    @Override
    public String getAttackString(int atkType, int move){
        if (atkType == 2){
          if (move == 1){
            return "VINEWHIP";
          }
          else if (move == 2){
            return "RAZOR LEAF";
          }
          else if (move == 3){
            return "SOLAR BEAM";
          }
        }
        else if (atkType == 3){
          return super.getAttackString(atkType, move);
        }
        return null;
    }

    /**
     * getAttackDamage Method overrides getAttackDamage method in Pokemon.
     * @param atkType
     * @param move
     * @return random damage
     */
    @Override
    public int getAttackDamage(int atkType, int move){
        if (atkType == 2){
          if (move == 1){
            return ((int) (Math.random() * 3) + 1);
          }
          else if (move == 2){
            return (int)(Math.random() * 3) + 2;
          }
          else if (move == 3){
            return (int)(Math.random() * 6);
          }
        }
        else if (atkType == 3){
          return super.getAttackDamage(atkType, move);
        }

        return -1;
    }

    /**
     * getAttackMultiplier Method overrides getAttackMultiplier method in Pokemon.
     * @param p
     * @param atkType
     * @return multiplier number
     */
    @Override
    public double getAttackMultiplier(Pokemon p, int atkType){
      if (atkType == 2){
        return battleTable[atkType][p.getType()];
      }  
      else if (atkType == 3){
        return super.getAttackMultiplier(p, atkType);
      }
      return 1;
    }
}
