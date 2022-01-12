/** 
 * Creates the pokemon trainer that the player controls
 * @author Jessica Le, Brandon Jue
 */
 
import java.awt.Point;
import java.util.ArrayList;
import java.awt.Point;
import java.lang.Math;

public class Trainer extends Entity {

    private int money;
    private int potions;
    private int pokeballs;
    private Point loc;
    private ArrayList<Pokemon> pokemon = new ArrayList<Pokemon>();

    /** 
     * Trainer Constructor
     * @param n The name of the trainer
     * @param p The trainer's initial pokemon that they chose
     */
    public Trainer(String n, Pokemon p) {
        super(n, 25, 25);
        money = 25;
        potions = 2;
        pokeballs = 4;
        pokemon.add(p);
        loc = Map.getInstance().findStart();
    }

    /**
     * Returns how much money the player has
     * @return the player's money
     */
    public int getMoney() {
        return money;
    }

    /**
    * The player spends money for different items
    * @param amt How much the player is spending
    * @return true or false depending if the player had sufficient money to make a purchase
    */
    public boolean spendMoney(int amt) {
        if (money >= amt) {
            money -= amt;
            return true;
        } else {
            return false;
        }
    }

    /**
    * The player receives money in different encounters
    * @param amt How much money the player is receiving
    */
    public void receiveMoney(int amt) {
        money += amt;
    }

    /**
    * Checks if the player has potions in their inventory
    * @return True or false depending if the player has potions in their inventory
    */
    public boolean hasPotion() {
        if (potions > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
    * The player receives a potion
    */
    public void receivePotion() {
        potions += 1;
    }

    /**The player uses a potion on one of their Pokemon during battle
    * @param pokeIndex The chosen index in the arraylist of pokemon
    */
    public void usePotion(int pokeIndex) {
        Pokemon pokemonToHeal = pokemon.get(pokeIndex);
        pokemonToHeal.heal();
        pokemon.set(pokeIndex, PokemonGenerator.getInstance().addRandomBuff(pokemon.get(pokeIndex)));
        potions--;
    }

    /**
    * Checks if the player has pokeballs in their inventory
    * @return True or false if the player has pokeballs in their inventory
    */
    public boolean hasPokeball() {
        if (pokeballs > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
    * The player receives a pokeball
    */
    public void receivePokeball() {
        pokeballs += 1;
    }

    /**
    * Calculates the chances of catching a wild Pokekmon and catches pokemon.
    * @param p The pokemon the player is trying to catch
    * @ return True or false is the pokemon is caught
    */
    public boolean catchPokemon(Pokemon p) {
        if (pokeballs > 0) {
            double percentHp = ((double)p.getHp() / (double)p.getMaxHp()); //what percent health pokemon is at - .90
            double catchRate = 1 - percentHp; //chance for capturing pokemon - .10
            double randNum = Math.random(); //generate random value - 0 - 0.99
            if (randNum <= catchRate) { 
                System.out.println("TICK... TICK... TICK... CLICK!\nYou caught " + p.getName() + "!!!");
                if (pokemon.size() >= 6){
                  System.out.println("Your bag is full! Would you like to get rid of a pokemon?\n\n1. Yes!\n2. No!");
                  int bag = CheckInput.getIntRange(1, 2);
                  if (bag == 1){
                    System.out.println("Which pokemon would you like to remove?");
                    System.out.println(getPokemonList());
                    int rem = CheckInput.getIntRange(1, 6);
                    pokemon.remove(rem - 1);
                    pokemon.add(p);
                  }
                  else{
                    System.out.println("You decided to keep your team!");
                  }
                }
                else {
                  pokemon.add(p);
                }
                return true;
            }
        }
        pokeballs--;
        return false; //unsuccessful capture
    }

    /**Finds the player's location on the map
    * @return player's location on the map as a Point
    */
    public Point getLocation() { 
        return loc;
    }

    /**
    * The player chooses to go north. Checks if that move is valid before changing the player's location
    * @return the char at the new location on the map. Returns 'b' if the move is invalid
    */
    public char goNorth() {
        Point north = new Point(loc.x - 1, loc.y);
        if (Map.getInstance().getCharAtLoc(north) != 'b') {
            Map.getInstance().reveal(loc);           
            loc.translate(-1, 0);
            return Map.getInstance().getCharAtLoc(loc);
        } else {
            return 'b';
        }
    }

    /**
    * The player chooses to go south. Checks if that move is valid before changing the player's location
    * @return the char at the new location on the map. Returns 'b' if the move is invalid
    */
    public char goSouth() {
        Point south = new Point(loc.x + 1, loc.y);
        if (Map.getInstance().getCharAtLoc(south) != 'b') {
            Map.getInstance().reveal(loc);         
            loc.translate(1, 0);
            return Map.getInstance().getCharAtLoc(loc);
        } else {
            return 'b';
        }
    }

    /**
    * The player chooses to go east. Checks if that move is valid before changing the player's location
    * @return the char at the new location on the map. Returns 'b' if the move is invalid
    */
    public char goEast() {
        Point east = new Point(loc.x, loc.y + 1);
        if (Map.getInstance().getCharAtLoc(east) != 'b') {
            Map.getInstance().reveal(loc);         
            loc.translate(0, 1);
            return Map.getInstance().getCharAtLoc(loc);
        } else {
            return 'b';
        }
    }

    /**
    * The player chooses to go west. Checks if that move is valid before changing the player's location
    * @return the char at the new location on the map. Returns 'b' if the move is invalid
    */
    public char goWest() {
        Point west = new Point(loc.x, loc.y - 1);
        if (Map.getInstance().getCharAtLoc(west) != 'b') {
            Map.getInstance().reveal(loc);  
            loc.translate(0, -1);
            return Map.getInstance().getCharAtLoc(loc);
        } else {
            return 'b';
        }
    }

    /**
    * Get how many pokemon the player has
    * @return how many pokemon the player has
    */
    public int getNumPokemon() {
        return pokemon.size();
    }

    /**
    * Heals all of the player's pokemon
    */
    public void healAllPokemon() {
        for (Pokemon i : pokemon) {
            i.heal();
        }
    }

    /**
    * Get the Pokemon at the specified index in the pokemon arraylist
    * @param index within the pokemon arraylist
    * @return the Pokemon at index 
    */
    public Pokemon getPokemon(int index) {
        return pokemon.get(index);
    }

    /**
    * The list of the player's pokemon and their hp's
    * @return the player's list of pokemon as a String
    */
    public String getPokemonList() { 
        String pokemonList = "";
        for (int i = 0; i < pokemon.size(); i++) {
            pokemonList += ((i + 1) + ". " + pokemon.get(i).getName() + " HP: " + pokemon.get(i).getHp() + "/" + pokemon.get(i).getMaxHp() + "\n");
        }
        return pokemonList; 
    }

    /**
    * The trainer represented as a string including: name, hp, maxHp, money, potions, pokeballs, list of pokemon, and map with the current state
    * @return Trainer class as a string
    */
    @Override
    public String toString() {
        return getName() + " HP: " + getHp() + "/" + getMaxHp() + "\nMoney: " + money + "\nPotions: " + potions + "\nPoke Balls: " + pokeballs + "\nPokemon:\n" + getPokemonList() + "\nMap:\n" + Map.getInstance().mapToString(loc);
    }

  /**
  * buffs all pokemon currently in the trainer party (arraylist of pokemon)
  */
    public void buffAllPokemon(){
      int number = (int)(Math.random()*2);
      if (number == 0){
        for (int i = 0; i < pokemon.size(); i++){
          pokemon.set(i, new AttackUp(pokemon.get(i)));
        }
      }
      else if (number == 1){
        for (int i = 0; i < pokemon.size(); i++){
          pokemon.set(i, new HpUp(pokemon.get(i)));
        }
      }
    }

  /**
  * debuffs pokemon at a certain index in the arraylist
  * @param index int
  */
    public void debuffPokemon(int index){
      int number = (int)(Math.random()*2);
      if (number == 0){
        pokemon.set(index, new AttackDown(pokemon.get(index)));
      }
      else if (number == 1){
        pokemon.set(index, new HpDown(pokemon.get(index)));
      }
    }
}
