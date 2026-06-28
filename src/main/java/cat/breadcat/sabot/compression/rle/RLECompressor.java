package cat.breadcat.sabot.compression.rle;

import cat.breadcat.sabot.compression.Compressor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class RLECompressor implements Compressor
{
    private final RLEEncoder encoder;
    private final RLEDecoder decoder;

    public RLECompressor()
    {
        this.encoder = new RLEEncoder();
        this.decoder = new RLEDecoder();
    }


    @Override
    public void compress(InputStream in, OutputStream out) throws IOException
    {
        int inputByte;
        while((inputByte = in.read()) != -1)
            encoder.write(inputByte, out);

        encoder.finish(out);
    }

    @Override
    public void decompress(InputStream in, OutputStream out) throws IOException
    {
        int inputByte;
        while((inputByte = decoder.read(in)) != -1)
            out.write(inputByte);
    }
}

