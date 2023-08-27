package PokemonsData;

import java.util.Random;

public class calcDamage {
    public static double calculateDamage(double baseDamage, double defense) {
        
        Random random = new Random();

        double randomFactor = 0.8 + (0.2 * random.nextDouble());

        double totalDamage = (double) (baseDamage * randomFactor) - defense;
        
        if (totalDamage < 0) {
            totalDamage = 0;
        }
        
        return totalDamage;
    }
}
