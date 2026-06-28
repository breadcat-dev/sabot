package cat.breadcat.sabot;

import java.io.IOException;
import java.io.OutputStream;

public interface Encoder
{
    void write(int inputByte, OutputStream out) throws IOException;
    void finish(OutputStream out) throws IOException;
}
