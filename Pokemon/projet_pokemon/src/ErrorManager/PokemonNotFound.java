package ErrorManager;

public class PokemonNotFound extends Exception {
    public PokemonNotFound() {
        super("Le numéro sélectionné ne correspond à aucun Pokemon, veuillez réessayer.");
    }
}
