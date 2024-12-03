package ErrorManager;

public class TerrainNotFound extends Exception{
    public TerrainNotFound() {
        super("Le terrain sélectionné n'existe pas.");
    }
}
