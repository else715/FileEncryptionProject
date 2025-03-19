import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("1. Generate AES Key");
            System.out.println("2. Encrypt File");
            System.out.println("3. Decrypt File");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    String generatedKey = AESUtil.generateKey();
                    System.out.println("Generated AES Key: " + generatedKey);
                    break;

                case 2:
                    System.out.print("Enter file to encrypt: ");
                    String inputEncrypt = scanner.nextLine();
                    System.out.print("Enter output encrypted file: ");
                    String outputEncrypt = scanner.nextLine();
                    System.out.print("Enter AES key: ");
                    String keyEncrypt = scanner.nextLine();

                    FileEncryptor.encryptFile(inputEncrypt, outputEncrypt, keyEncrypt);
                    break;

                case 3:
                    System.out.print("Enter file to decrypt: ");
                    String inputDecrypt = scanner.nextLine();
                    System.out.print("Enter output decrypted file: ");
                    String outputDecrypt = scanner.nextLine();
                    System.out.print("Enter AES key: ");
                    String keyDecrypt = scanner.nextLine();

                    FileDecryptor.decryptFile(inputDecrypt, outputDecrypt, keyDecrypt);
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
