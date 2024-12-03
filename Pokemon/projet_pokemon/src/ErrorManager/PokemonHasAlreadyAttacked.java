package ErrorManager;

public class PokemonHasAlreadyAttacked extends Exception {

    public PokemonHasAlreadyAttacked() {
        super("Le Pokémon sélectionné a déjà attaqué durant ce tour.");
    }
}
