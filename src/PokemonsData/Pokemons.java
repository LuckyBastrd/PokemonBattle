package PokemonsData;

import PokemonSkills.Attack;
import PokemonSkills.Skill;

public abstract class Pokemons implements Defense {
    private String name;
    private String type;
    private Integer level;
    private double health;
    private double defense;
    private Attack attack;
    private Skill skills;

    public Pokemons(String name, String type, Integer level, double health, double defense, Attack attack, Skill skills){
        this.name = name;
        this.type = type;
        this.level = level;
        this.health = health;
        this.defense = defense;
        this.attack = attack;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getDefense() {
        return defense;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }

    //Check Health
    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(double damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    //Attack Proccess
    public double useBasicAttack(Defense opponentDefense) {
        return attack.use(opponentDefense);
    }

    public double useSKills(Defense opponentDefense) {
        return skills.use(opponentDefense);
    }
}
