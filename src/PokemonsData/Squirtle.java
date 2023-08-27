package PokemonsData;

import Utilities.numberFormatter;

import java.util.concurrent.ThreadLocalRandom;

import PokemonSkills.Attack;
import PokemonSkills.Skill;

public class Squirtle extends Pokemons {
    private static double health = ThreadLocalRandom.current().nextDouble(93, 106);
    private static double defense = ThreadLocalRandom.current().nextDouble(109, 121);
    

    public Squirtle() {
        super("Squirtle", "Water", 15, Double.valueOf(numberFormatter.format(health)), Double.valueOf(numberFormatter.format(defense)), new basicAttack(), new Bubble());
    }

    @Override
    public double getDefense() {
        return defense;
    }
}

// Basic Attack Squirtle
class basicAttack implements Attack {
    private static double baseDamage = ThreadLocalRandom.current().nextDouble(85, 100);

    @Override
    public double use(Defense opponentDefense) {
        double totalDamage = calcDamage.calculateDamage(baseDamage, opponentDefense.getDefense());
        
        System.out.println("Basic Attack Used! It dealt " + Double.valueOf(numberFormatter.format(totalDamage)) + " damage.");
        
        return totalDamage;
    }
}

// Pikachu Skills
class Bubble implements Skill {
    private static double baseDamage = ThreadLocalRandom.current().nextDouble(125, 140);
    
    @Override
    public double use(Defense opponentDefense) {
        double totalDamage = calcDamage.calculateDamage(baseDamage, opponentDefense.getDefense());
        
        System.out.println("Bubble Skill Used! It dealt " + Double.valueOf(numberFormatter.format(totalDamage)) + " damage.");
        
        return totalDamage;
    }
}
