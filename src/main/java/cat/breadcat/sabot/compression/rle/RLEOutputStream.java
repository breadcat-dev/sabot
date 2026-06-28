package cat.breadcat.sabot.compression.rle;

import cat.breadcat.sabot.Encoder;
import cat.breadcat.sabot.compression.CompressorOutputStream;

import java.io.IOException;
import java.io.OutputStream;

public final class RLEOutputStream extends CompressorOutputStream
{
    private final Encoder encoder;

    public RLEOutputStream(OutputStream out)
    {
       super(out);

       this.encoder = new RLEEncoder();
    }


    @Override
    public void write(int inputByte) throws IOException
    {
        encoder.write(inputByte, out);
    }

    @Override
    public void close() throws IOException
    {
        if(closed)
            throw new IllegalStateException("Stream is already closed");

        closed = true;
        encoder.finish(out);
        out.close();
    }
}
