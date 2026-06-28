package cat.breadcat.sabot;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface Decoder
{
    int read(InputStream in) throws IOException;
}
