import java.util.Scanner;

import PokemonsData.Pokemons;
import PokemonsData.Pikachu;
import PokemonsData.Squirtle;
import Utilities.clearScreen;
import Utilities.numberFormatter;

import java.util.concurrent.ThreadLocalRandom;

class PokemonBattle {
    private Scanner scanner;

    Pikachu pikachu = new Pikachu();
    Squirtle squirtle = new Squirtle();

    public PokemonBattle() {
        scanner = new Scanner(System.in);
    }

    public void mainMenu() {
        boolean isRunning = true;

        while (isRunning) {

            System.out.println("1. Choose Pokemon");
            System.out.println("2. Exit");
            System.out.printf("> ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    clearScreen.cls();

                    System.out.println("Choose Pokemon: ");
                    System.out.println("1. Pikachu         |  2. Squirtle    ");
                    System.out.println("-Name: " + pikachu.getName() + "     |  " + "-Name: " + squirtle.getName());
                    System.out.println("-Type: " + pikachu.getType() + "    |  " + "-Type: " + squirtle.getType());
                    System.out.println("-Level: " + pikachu.getLevel() + "         |  " + "-Level: " + squirtle.getLevel());
                    System.out.println("-Health: " + pikachu.getHealth() + "   |  " + "-Health: " + squirtle.getHealth());
                    System.out.println("-Defense: " + numberFormatter.format(pikachu.getDefense()) + "   |  " + "-Defense: " + numberFormatter.format(squirtle.getDefense()));
                    System.out.printf("> ");

                    int chosenPokemon = scanner.nextInt();
                    scanner.nextLine();
                    subMenu(chosenPokemon);
                    break;
                case 2:
                    isRunning = false;
                    System.out.println("Exiting PokemonBattle.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }

    public void subMenu(int choice) {
        clearScreen.cls();

        Pokemons userPokemon = null;
        Pokemons comPokemon = null;

        switch (choice) {
            case 1:
                userPokemon = new Pikachu();
                comPokemon = new Squirtle();
                break;
            case 2:
                userPokemon = new Squirtle();
                comPokemon = new Pikachu();
                break;
        }

        System.out.println("\nYour chose " + userPokemon.getName() + "!");
        System.out.println("-Your Health: " + userPokemon.getHealth() + "!\n");

        System.out.println("Your opponent is " + comPokemon.getName() + ".");
        System.out.println("-Your opponent Health: " + comPokemon.getHealth() + "!\n");

        System.out.println("\nBattle Start!\n");

        while (userPokemon.isAlive() && comPokemon.isAlive()) {
            System.out.println("\n" + userPokemon.getName() + " - Your Health: " + numberFormatter.format(userPokemon.getHealth()) + "!");
            System.out.println(comPokemon.getName() + " - Your Opponent Health: " + numberFormatter.format(comPokemon.getHealth()) + "!\n");

            System.out.println("Choose your attack:");
            System.out.println("1. Use Basic Attack");
            System.out.println("2. Use Skill");
            System.out.printf("> ");

            int userAction = scanner.nextInt();
            double userAttack = 0;

            clearScreen.cls();

            if (userAction == 1) {
                userAttack = userPokemon.useBasicAttack(comPokemon);
            } else if (userAction == 2) {
                userAttack = userPokemon.useSKills(comPokemon);
            } else {
                System.out.println("Invalid choice. Skipping your turn.");
            }

            comPokemon.takeDamage(userAttack);
            System.out.println(userPokemon.getName() + " deals " + numberFormatter.format(userAttack) + " damage to " + comPokemon.getName() + "\n");



            // Opponent turn
            int OpponentAction = ThreadLocalRandom.current().nextInt(1, 3);
            double opponentAttack = 0;
            
            if (OpponentAction == 1) {
                opponentAttack = comPokemon.useBasicAttack(userPokemon);
            } else if (OpponentAction == 2) {
                opponentAttack = comPokemon.useSKills(userPokemon);
            } else {
                System.out.println("Invalid choice. Skipping your turn.");
            }

            userPokemon.takeDamage(opponentAttack);
            System.out.print(comPokemon.getName() + " deals " + numberFormatter.format(opponentAttack) + " damage to " + userPokemon.getName() + "\n");

            if (!userPokemon.isAlive()) {
                clearScreen.cls();
                
                System.out.println(userPokemon.getName() + " has been defeated!");
                System.out.println("------------------------------\n\n");
                break;  
            } else if (!comPokemon.isAlive()) {
                clearScreen.cls();
                
                System.out.println(comPokemon.getName() + " has been defeated!");
                System.out.println("------------------------------\n\n");
                break;
            }
        }
    }  
}

public class Main {
    public static void main(String[] args) {
        System.out.println("\nWelcome to Pokemon Battle!\n");

        PokemonBattle pokemonBattle = new PokemonBattle();
        pokemonBattle.mainMenu(); 
    }
}
