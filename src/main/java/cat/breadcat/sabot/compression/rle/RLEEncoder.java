package cat.breadcat.sabot.compression.rle;

import cat.breadcat.sabot.Encoder;

import java.io.IOException;
import java.io.OutputStream;

public final class RLEEncoder implements Encoder
{
    private int value;
    private int count;

    public RLEEncoder()
    {
        this.value = -1;
        this.count = 0;
    }


    private void flush(OutputStream out) throws IOException
    {
        out.write(count & 0xFF);
        out.write(value);
    }

    private void update(int inputByte)
    {
        value = inputByte;
        count = 1;
    }

    private void reset()
    {
        value = -1;
        count = 0;
    }


    @Override
    public void write(int inputByte, OutputStream out) throws IOException
    {
        if(count == 0)
        {
            update(inputByte);
            return;
        }

        if(value == inputByte)
        {
            if(count < 255)
                count++;
            else
            {
                flush(out);
                update(inputByte);
            }

            return;
        }

        flush(out);
        update(inputByte);
    }

    @Override
    public void finish(OutputStream out) throws IOException
    {
        flush(out);
        reset();
    }
}
