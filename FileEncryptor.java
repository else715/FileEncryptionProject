import java.io.*;
import java.nio.file.Files;

public class FileEncryptor {
    public static void encryptFile(String inputFilePath, String outputFilePath, String key) throws Exception {
        File inputFile = new File(inputFilePath);
        byte[] fileData = Files.readAllBytes(inputFile.toPath());
        byte[] encryptedData = AESUtil.encrypt(fileData, key);

        try (FileOutputStream fos = new FileOutputStream(outputFilePath)) {
            fos.write(encryptedData);
        }
        System.out.println("File encrypted successfully: " + outputFilePath);
    }
}
