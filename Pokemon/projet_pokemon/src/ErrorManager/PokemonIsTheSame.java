package ErrorManager;

public class PokemonIsTheSame extends Exception{
    public PokemonIsTheSame() {
        super("Vous ne pouvez pas utiliser ce pouvoir sur votre propre Pokémon.");

    }
}
