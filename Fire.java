/**
* creates the class object Fire for pokemon
* @author Yisacor Tenegashaw
*/
public class Fire extends Pokemon{
    /*
     * Fire constructor create fire instance with the name n
     * @param n
     * @param h
     * @param m
     */
    public Fire(String n, int h, int m) {
        super(n,h,m);
    }

    /**
     * getAttackMenu Method overrides getAttackMenu method in Pokemon.
     * @param atkType
     * @return menu for fire special attack or basic attack
     */
    @Override
    public String getAttackMenu(int atkType){
        if (atkType == 0){
            return "1. Ember\n2. Fire Blast\n3. Fire Punch";
        }else if (atkType == 3){
          return super.getAttackMenu(atkType);
        }
        return null;
    }

    /*
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
        if (atkType == 0){
            switch (move) {
                case 1:
                    return "EMBER";
                case 2:
                    return "FIRE BLAST";
                case 3:
                    return "FIRE PUNCH";
                default:
                    break;
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
      if (atkType == 0){  
        switch (move) {
            case 1:
                return ((int) (Math.random() * 4));
            case 2:
                return ((int)(Math.random() * 4) + 1);
            case 3:
                return ((int)(Math.random() * 3) + 1);
            default:
                break;
        }
        return 0;
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
      if (atkType == 0){
        return battleTable[atkType][p.getType()];
      }  
      else if (atkType == 3){
        return super.getAttackMultiplier(p, atkType);
      }
      return 1;
    }
}

