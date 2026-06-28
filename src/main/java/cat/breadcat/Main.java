package cat.breadcat;

import cat.breadcat.breech.bytes.BinaryEndianness;
import cat.breadcat.breech.bytes.BinaryOutput;
import cat.breadcat.sabot.compression.rle.RLECompressor;
import cat.breadcat.sabot.compression.rle.RLEOutputStream;

import java.io.*;

public class Main
{
    public static void main(String[] args)
    {
        final String encoded = "./encoded.rle";
        final String decoded = "./decoded.rle";

        RLECompressor compressor = new RLECompressor();

        try(OutputStream out = new FileOutputStream(encoded))
        {
            BinaryOutput binOut = new BinaryOutput(BinaryEndianness.LittleEndian, new RLEOutputStream(out));

            binOut.writeString("TTTTTTTTTTTTTTTTTTTTTTTTTTTEEEEEEEEEEEEEEEEEEEEEEEEEEESSSSSSSSSSSSSSSSTTTTTTTTTTTTTTTTTTT");
            binOut.writeInt(1000002);

            binOut.close();

            /*BinaryInput binIn = new BinaryInput(BinaryEndianness.LittleEndian, new RLEInputStream(in));

            String message = binIn.readString();
            int number = binIn.readInt();

            binIn.close();

            System.out.println("msg = " + message + "\nnumber = " + number);*/
        }
        catch(IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}