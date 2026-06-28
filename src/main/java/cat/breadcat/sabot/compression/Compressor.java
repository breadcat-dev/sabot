package cat.breadcat.sabot.compression;

import java.io.*;

public interface Compressor
{
    void compress(InputStream in, OutputStream out) throws IOException;
    default byte[] compress(byte[] data)
    {
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try
        {
            compress(in, out);
        }
        catch(IOException e)
        {
            throw new RuntimeException(e);
        }

        return out.toByteArray();
    }

    void decompress(InputStream in, OutputStream out) throws IOException;
    default byte[] decompress(byte[] data)
    {
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try
        {
            decompress(in, out);
        }
        catch(IOException e)
        {
            throw new RuntimeException(e);
        }

        return out.toByteArray();
    }
}
