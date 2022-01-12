/*
*  @author Yisacor
* Creates the class Entity.
*/
public abstract class Entity {
    
    private String name;
    private int hp;
    private int maxHp;

    /** Overloaded Constructor – makes rectangle w/ parameters 
    *  @param n sets the n value
    *  @param mHp sets the  mhp value
    */ 
    public Entity(String n, int h, int m){
        name = n;
        maxHp = m;
        hp = h;
    }
    /**gets the hp.
     * @return the hp. 
     */
    public int getHp(){
        return hp;
    }
     /**gets the max hp. 
      * @return the max hp. 
      */
    public int getMaxHp(){
        return maxHp;
    }
    
    /**gets the hp.
     * @param d amount of damage the hp is taking. 
     * @return the hp. 
     */
    public void takeDamage(int d){   
      hp -= d;
      if (hp < 0){
        hp = 0;
      }
    }
    
    /**sets the hp to max.  
     */
    public void heal(){ 
        hp = maxHp;
    }
    /**gets the hp.
     * @param d amount of damage the hp is taking. 
     * @return the hp. 
     */
    public String getName(){
        return name;
    }
    /** String representation of the Hp with the name
    * @return string representation of the name with the hp 
    */
    @Override
    public String toString(){return (name + " HP: " + hp + "/" + maxHp);} 

}
