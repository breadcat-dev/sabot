package cat.breadcat.sabot.compression;

import java.io.IOException;
import java.io.OutputStream;

public abstract class CompressorOutputStream extends OutputStream
{
    protected final OutputStream out;

    protected boolean closed;

    protected CompressorOutputStream(OutputStream out)
    {
        this.out = out;

        this.closed = false;
    }


    public abstract void write(int inputByte) throws IOException;

    public void close() throws IOException
    {
        if(closed)
            throw new IllegalStateException("Stream is already closed");

        closed = true;
        out.close();
    }
}
