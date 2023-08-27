package PokemonsData;

import Utilities.numberFormatter;

import java.util.concurrent.ThreadLocalRandom;

import PokemonSkills.Attack;
import PokemonSkills.Skill;

public class Pikachu extends Pokemons {
    private static double health = ThreadLocalRandom.current().nextDouble(107, 119);
    private static double defense = ThreadLocalRandom.current().nextDouble(84, 96);

    public Pikachu() {
        super("Pikachu", "Electric", 13, Double.valueOf(numberFormatter.format(health)), Double.valueOf(numberFormatter.format(defense)), new basicAttack(), new Thunderbolt());
    }
    
    @Override
    public double getDefense() {
        return defense;
    }
}

// Basic Attack Pikachu
class basicAttack implements Attack {
    private static double baseDamage = ThreadLocalRandom.current().nextDouble(90, 140);
    
    @Override
    public double use(Defense opponentDefense) {
        double totalDamage = calcDamage.calculateDamage(baseDamage, opponentDefense.getDefense());
        
        System.out.println("Basic Attack Used! It dealt " + Double.valueOf(numberFormatter.format(totalDamage)) + " damage.");
        
        return totalDamage;
    }
}

// Pikachu Skills
class Thunderbolt implements Skill {
    private static double baseDamage = ThreadLocalRandom.current().nextDouble(130, 170);

    @Override
    public double use(Defense opponentDefense) {
        double totalDamage = calcDamage.calculateDamage(baseDamage, opponentDefense.getDefense());
        
        System.out.println("Thunderbolt Skill Used! It dealt " + Double.valueOf(numberFormatter.format(totalDamage)) + " damage.");
        
        return totalDamage;
    }
}