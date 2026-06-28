package cat.breadcat.sabot.compression;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public abstract class CompressorInputStream extends InputStream implements Closeable
{
    protected final InputStream in;

    protected boolean closed;

    protected CompressorInputStream(InputStream in)
    {
        this.in = in;
    }

    @Override
    public void close() throws IOException
    {
        if(closed)
            throw new IllegalStateException("Stream is already closed");

        in.close();
    }
}