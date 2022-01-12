/*
 * HpUp class : decoration for pokemon
 * @author Brandon Jue
 */
public class HpUp extends PokemonDecorator {

    /** 
     * HpUp Constructor
     * Buffs a pokemon to increase Hp
     * @param p Pokemon to be buffed
     */
  public HpUp(Pokemon p) {
    super(p, "+HP", (int)(Math.random()*2) + 1);
  }
}