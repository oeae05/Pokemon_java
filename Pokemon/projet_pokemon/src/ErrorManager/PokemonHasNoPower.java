package ErrorManager;

public class PokemonHasNoPower extends Exception {

    public PokemonHasNoPower() {
        super("Le Pokémon sélectionné n'a aucun pouvoir.");
    }
}