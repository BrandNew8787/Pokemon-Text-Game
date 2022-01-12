/**
 *
 * @author Yisacor Tenagashaw
 * PokemonDecorator abstract class.
 */
public abstract class PokemonDecorator extends Pokemon{

    private Pokemon pokemon;
    
    /*
     *PokemonDecorator constructor pass in the extraName, Hp and Pokemon.
     *@param p, extraName and extraHp
     */
    public PokemonDecorator(Pokemon p, String extraName, int extraHp) {
      super(p.getName() + extraName, p.getHp() + extraHp, extraHp + p.getMaxHp()); 
      pokemon = p;
    }
    /*
     *getAttackMenu Method: overrides getAttackMenu method in Pokemon class.
     *@param atkType
     *@return menu
     */
    @Override 
    public String getAttackMenu(int atkType){ 
        return pokemon.getAttackMenu(atkType);
    }

    /**
     * getNumAttackMenuItems Method: overrides getNumAttackMenuItems method in Pokemon class.
     * @param atkType
     * @return number of menu
     */
    @Override 
    public int getNumAttackMenuItems(int atkType){ 
        return pokemon.getNumAttackMenuItems(atkType);
    } 

    /**
     * getAttackString Method: overrides getAttackString method in Pokemon class.
     * @param atkType
     * @param move
     * @return added atkType
     */
    @Override
    public String getAttackString(int atkType, int move){
        return pokemon.getAttackString(atkType, move);
    }

    /**
     * getAttackDamage Method: overrides getAttackDamage method in Pokemon class.
     * @param atkType
     * @param move
     * @return new damage value
     */
    @Override
    public int getAttackDamage(int atkType, int move){
        return pokemon.getAttackDamage(atkType, move);
    }

    /**
     * getAttackMultiplier method: overrides getAttackMultiplier method in Pokemon class.
     * @param p
     * @param atkType
     * @return new value
     */
    @Override
    public double getAttackMultiplier(Pokemon p, int atkType){
        return pokemon.getAttackMultiplier(p, atkType);
    }

    /**
     * getAttackBonus Method: overrides the getAttackBonus method in Pokemon  class and gets overridden by the decorations (AttackUp and AttackDown) 
     * @param atkType
     * @return new value
     */
    @Override
    public int getAttackBonus(int atkType){
        return pokemon.getAttackBonus(atkType);
    }

    /**
     * getType method: overrides getType method in Pokemon class.
     * @return type 
     */
    @Override
    public int getType(){
        return pokemon.getType();
    }
    
}

