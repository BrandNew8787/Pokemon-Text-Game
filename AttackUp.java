/**
 * AttackUp class: decoration for Pokemon
 * @author Jessica Le
 */
public class AttackUp extends PokemonDecorator {
    /** 
    * AttackUp Constructor
    * Buffs a pokemon to increase attack damage
    * @param p Pokemon to be buffed
    */
  public AttackUp(Pokemon p) {
    super(p, "+ATK", 0);
  }

  /*
   * getAttackBonus Method
   * @param atkType int
   * @return random bonus
   */
  @Override
  public int getAttackBonus(int atkType) { 
    int randBonus = (int)(Math.random() * 2) + 1;
    return randBonus;
  }
}