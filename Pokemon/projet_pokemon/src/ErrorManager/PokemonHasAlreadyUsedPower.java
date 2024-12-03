package ErrorManager;

public class PokemonHasAlreadyUsedPower extends Exception {

    public PokemonHasAlreadyUsedPower() {
        super("Le Pokémon sélectionné a déjà attaqué utilisé son pouvoir durant ce tour.");
    }
}