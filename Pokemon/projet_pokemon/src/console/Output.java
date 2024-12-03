package console;

import java.io.*;

public class Output {

    private final PrintWriter writer;

    public Output () {
        OutputStream out = System.out;
        this.writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)));
    }

    public void println (String s) {
        writer.println(s);
        writer.flush();
    }
}
