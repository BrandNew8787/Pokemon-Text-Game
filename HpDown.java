/*
 * HpDown decoration for Pokemon.
 * @author Brandon Jue
 */
public class HpDown extends PokemonDecorator {

    /** 
     * HpDown Constructor
     * Debuffs a pokemon to decrease Hp
     * @param p Pokemon to be debuffed
     */
  public HpDown(Pokemon p) {
    super(p, "-HP", (int)(Math.random() * 2) - 2);
  }
}