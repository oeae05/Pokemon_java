package console;

import ErrorManager.InputIsEmpty;
import ErrorManager.InputIsNotInt;
import ErrorManager.InputIsNotString;

import java.util.Scanner;

public class Input {

    private Scanner m_scanner;

    public Input() {
        m_scanner = new Scanner(System.in);
    }

    public int getInt() throws InputIsNotInt, InputIsEmpty {
        String prompt = m_scanner.nextLine();
        if (prompt.isEmpty()) throw new InputIsEmpty();
        try {
            int number = Integer.parseInt(prompt);
            return number;
        } catch (NumberFormatException e) {
            throw new InputIsNotInt();
        }
    }

    public String getString() throws InputIsEmpty {
        String prompt = m_scanner.nextLine();
        return prompt;
    }
}
