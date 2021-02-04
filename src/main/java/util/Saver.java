package util;

import java.io.*;

public class Saver {
    public static byte[] savedToBLOB(Rec input) {
        byte[] Result = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = null;

        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(input);
            out.flush();
            Result = bos.toByteArray();
        } catch (IOException var13) {
            var13.printStackTrace();
        } finally {
            try {
                bos.close();
            } catch (IOException var12) {
            }
        }
        return Result;
    }

    static Record restored(byte[] input) {
        Object o = null;
        ByteArrayInputStream bis = new ByteArrayInputStream(input);
        ObjectInputStream in = null;

        try {
            in = new ObjectInputStream(bis);
            o = in.readObject();
        } catch (IOException var15) {
            var15.printStackTrace();
        } catch (ClassNotFoundException var16) {
            var16.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException var14) {
            }

        }

        return (Rec)o;
    }

}
