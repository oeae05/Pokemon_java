package ErrorManager;

public class InputIsEmpty extends Exception{
    public InputIsEmpty() {
        super("Vous devez entrer quelque chose.");
    }
}
