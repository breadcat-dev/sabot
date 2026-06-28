package cat.breadcat.sabot.compression.rle;

import cat.breadcat.sabot.compression.CompressorInputStream;

import java.io.IOException;
import java.io.InputStream;

public final class RLEInputStream extends CompressorInputStream
{
    private final RLEDecoder decoder;

    public RLEInputStream(InputStream in)
    {
        super(in);

        this.decoder = new RLEDecoder();
    }

    @Override
    public int read() throws IOException
    {
        return decoder.read(in);
    }
}
