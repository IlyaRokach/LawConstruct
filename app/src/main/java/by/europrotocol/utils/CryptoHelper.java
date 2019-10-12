package by.europrotocol.utils;

import java.security.MessageDigest;

public class CryptoHelper {
    public static String getSHA256(final byte[] data){
        StringBuilder sb = new StringBuilder();
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            md.update(data);
            byte byteData[] = md.digest();

            for (byte aByteData : byteData) {
                sb.append(Integer.toString((aByteData & 0xff) + 0x100, 16).substring(1));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return sb.toString();
    }
}
