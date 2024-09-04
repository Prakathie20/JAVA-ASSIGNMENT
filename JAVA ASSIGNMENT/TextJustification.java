import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextJustification {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> currentLine = new ArrayList<>();
        int numOfLetters = 0;
        
        for (String word : words) {
            if (numOfLetters + word.length() + currentLine.size() > maxWidth) {
                result.add(justifyLine(currentLine, numOfLetters, maxWidth, false));
                currentLine = new ArrayList<>();
                numOfLetters = 0;
            }
            currentLine.add(word);
            numOfLetters += word.length();
        }
        StringBuilder lastLine = new StringBuilder();
        for (String word : currentLine) {
            if (lastLine.length() > 0) lastLine.append(" ");
            lastLine.append(word);
        }
        while (lastLine.length() < maxWidth) lastLine.append(" ");
        result.add(lastLine.toString());
        
        return result;
    }
    private static String justifyLine(List<String> words, int numOfLetters, int maxWidth, boolean isLastLine) {
        if (words.size() == 1) {
            return words.get(0) + " ".repeat(maxWidth - words.get(0).length());
        }
        
        int totalSpaces = maxWidth - numOfLetters;
        int spaceBetweenWords = totalSpaces / (words.size() - 1);
        int extraSpaces = totalSpaces % (words.size() - 1);
        
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            if (i > 0) {
                int spaces = spaceBetweenWords + (i <= extraSpaces ? 1 : 0);
                line.append(" ".repeat(spaces));
            }
            line.append(words.get(i));
        }
        
        if (isLastLine) {
            return line.toString() + " ".repeat(maxWidth - line.length());
        }
        
        return line.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    
        System.out.println("Enter the maximum width:");
        int maxWidth = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Enter the words separated by spaces:");
        String input = scanner.nextLine();
        String[] words = input.split(" ");
        List<String> justifiedText = fullJustify(words, maxWidth);
        for (String line : justifiedText) {
            System.out.println(line);
        }

        scanner.close();
    }
}
