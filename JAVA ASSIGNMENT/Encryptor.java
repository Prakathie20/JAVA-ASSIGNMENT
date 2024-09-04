import java.util.Scanner;

public class Encryptor {
    public static String encryptString(String input1, int keyValue) {
        StringBuilder encryptedString = new StringBuilder();
        
        for (char ch : input1.toCharArray()) {
            if (Character.isLetter(ch)) {
                boolean isUpperCase = Character.isUpperCase(ch);
                int baseValue = isUpperCase ? ch - 'A' : ch - 'a';
                int encryptedValue = (baseValue + keyValue) % 26;
                char encryptedChar = (char) (encryptedValue + (isUpperCase ? 'a' : 'A'));
                encryptedChar = isUpperCase ? Character.toLowerCase(encryptedChar) : Character.toUpperCase(encryptedChar);
                
                encryptedString.append(encryptedChar);
            } else {
                encryptedString.append(ch);
            }
        }

        return encryptedString.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string to encrypt:");
        String input1 = scanner.nextLine();
        System.out.println("Enter the encryption key (integer value):");
        int keyValue = scanner.nextInt();
        String encryptedResult = encryptString(input1, keyValue);
        System.out.println("Encrypted words: " + encryptedResult);
        scanner.close();
    }
}

