
/*
 * PokemonGenerator: read pokemon file and create pokemon
 * @author Jessica Le
 */
import java.util.HashMap;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class PokemonGenerator {
  private HashMap<String, String> pokemonMap = new HashMap<String, String>();
  private static PokemonGenerator instance = null;

    /** 
     * PokemonGenerator Constructor
     * Reads from PokemonList.txt and stores into hashmap
     */
  private PokemonGenerator() {
    try {
      Scanner pokeScan = new Scanner(new File("PokemonList.txt"));
      int idx;
      String key;
      String value;
      while(pokeScan.hasNextLine()) {
        String line = pokeScan.nextLine();
        idx = line.indexOf(",");
        key = line.substring(0, idx);
        value = line.substring(idx+1);
        pokemonMap.put(key, value);
      }
    }
    catch (FileNotFoundException e) {
      System.out.println("File Not Found");
    }
  }

    /**
     * Get the singleton instance of PokemonGenerator if null
     * @return instance of PokemonGenerator
     */
  public static PokemonGenerator getInstance() {
    if (instance == null) {
      instance = new PokemonGenerator();
    }
    return instance;
  }

    /**
     * Creates a random pokemon from hash HashMap
     * Chooses a random type (Fire, grass, etc.) and assigns it a random name of corresponding type
     * @param level the player's current level
     * @return newPoke a random, constructed pokemon
     */
  public Pokemon generateRandomPokemon(int level) {
    PokemonGenerator.getInstance(); 
    String name = ""; 
    Pokemon newPoke = null;
    int randType = (int)(Math.random() * 3); //choose random type: F, G, W
    int randHp = (int)(Math.random() * 5) + 20; 
    if (randType == 0) {
      ArrayList<String> fireList = new ArrayList<String>();
      for (String i: pokemonMap.keySet()) { 
        if (pokemonMap.get(i).equals("Fire")) { //if the pokemon is Fire type
          fireList.add(i);
        }
      }
      int randNameIdx = (int)(Math.random() * fireList.size());
      name = fireList.get(randNameIdx);
      newPoke = new Fire(name, randHp, randHp); 
    }
    else if (randType == 1) {
      ArrayList<String> grassList = new ArrayList<String>();
      for (String i: pokemonMap.keySet()) { 
        if (pokemonMap.get(i).equals("Grass")) { //if the pokemon is Grass type
          grassList.add(i);
        }
      }
      int randNameIdx = (int)(Math.random() * grassList.size());
      name = grassList.get(randNameIdx);
      newPoke = new Grass(name, randHp, randHp); 
    }
    else if (randType == 2) {
      ArrayList<String> waterList = new ArrayList<String>();
      for (String i: pokemonMap.keySet()) { 
        if (pokemonMap.get(i).equals("Water")) { //if the pokemon is Water type
          waterList.add(i);
        }
      }
      int randNameIdx = (int)(Math.random() * waterList.size());
      name = waterList.get(randNameIdx);
      newPoke = new Water(name, randHp, randHp); 
    }
    while (level > 1) { 
      newPoke = addRandomBuff(newPoke);
      level--;
    }
    return newPoke;
  }

    /**
     * Takes the name of a pokemon and constructs it
     * @param name name of the pokemon to constructed
     * @return pokemon of corresponding type
     */
  public Pokemon getPokemon(String name) {
    String pokeType = pokemonMap.get(name);
    if (pokeType.equals("Fire")) {
      int hp = (int)(Math.random() * 5) + 20;
      return new Fire(name, hp, hp);
    }
    else if (pokeType.equals("Grass")) {
      int hp = (int)(Math.random() * 5) + 20;
      return new Grass(name, hp, hp);
    }
    else if (pokeType.equals("Water")) {
      int hp = (int)(Math.random() * 5) + 20;
      return new Water(name, hp, hp);
    }
    return null;
  }

    /**
     * Adding a random buff to a pokemon
     * @param p Pokemon to be buffed
     * @return p Pokemon with a buff
     */
  public Pokemon addRandomBuff(Pokemon p) {
    int randBuff = (int)(Math.random() * 2);
    if (randBuff == 0) {
      p = new AttackUp(p);
    }
    else if (randBuff == 1) {
      p = new HpUp(p);
    }
    return p;
  }

    /**
     * Adding a random debuff to a pokemon
     * @param p Pokemon to be debuffed
     * @return p Pokemon with a debuff
     */
  public Pokemon addRandomDebuff(Pokemon p) {
    int randDebuff = (int)(Math.random() * 2);
    if (randDebuff == 0) {
      p = new AttackDown(p);
    }
    else if (randDebuff == 1) {
      p = new HpDown(p);
    }
    return p;
  }
}