package practica4;

import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class TripleDES {
    
    public byte[] ciphe(byte[] object) throws Exception{
        final MessageDigest md = MessageDigest.getInstance("md5");
        final byte[] digestOfPassword = md.digest("HG58YZ3CR9"
                .getBytes("utf-8"));
        final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
        for(int i = 0, j = 16; i < 8;){
            keyBytes[j++] = keyBytes[i++];
        }
        
        final SecretKey key = new SecretKeySpec(keyBytes, "DESede");
        final IvParameterSpec IV = new IvParameterSpec(new byte[8]);
        return null;
    }
}
