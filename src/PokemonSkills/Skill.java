package PokemonSkills;

import PokemonsData.Defense;

public interface Skill {
    double use(Defense opponentDefense);
}
