/*
 *AttackDown class: decoration for pokemon
 * @author Jessica Le
 */

public class AttackDown extends PokemonDecorator {
  /** 
   * AttackDown Constructor
   * Debuffs a pokemon to decrease attack damage
   * @param p Pokemon to be debuffed
   */
  public AttackDown(Pokemon p) {
    super(p, "-ATK", 0);
  }

  /**
   * Getting the attack bonus for the pokemon
   * @param atkType pokemon's atkType, not used
   * @return -1 debuff
   */
  @Override
  public int getAttackBonus(int atkType) {
    return -1;
  }
}