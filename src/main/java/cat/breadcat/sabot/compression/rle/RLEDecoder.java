package cat.breadcat.sabot.compression.rle;

import cat.breadcat.sabot.Decoder;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public final class RLEDecoder implements Decoder
{
    private int value;
    private int remaining;

    public RLEDecoder()
    {
        this.value = -1;
        this.remaining = 0;
    }

    @Override
    public int read(InputStream in) throws IOException
    {
        if(remaining <= 0)
        {
            remaining = in.read();
            if(remaining == -1)
                return -1;

            value = in.read();
            if (value == -1)
                throw new EOFException("Unexpected EOF");
        }

        remaining--;
        return value;
    }
}
