import java.io.*;
import java.nio.file.Files;

public class FileDecryptor {
    public static void decryptFile(String inputFilePath, String outputFilePath, String key) throws Exception {
        File inputFile = new File(inputFilePath);
        byte[] encryptedData = Files.readAllBytes(inputFile.toPath());
        byte[] decryptedData = AESUtil.decrypt(encryptedData, key);

        try (FileOutputStream fos = new FileOutputStream(outputFilePath)) {
            fos.write(decryptedData);
        }
        System.out.println("File decrypted successfully: " + outputFilePath);
    }
}
