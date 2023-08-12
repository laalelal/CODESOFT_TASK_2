import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class wordCOUNTER {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = "";

        System.out.println("Enter '1' to input text, or '0' to provide a file:");
        int choice = sc.nextInt();

        sc.nextLine(); // Consume the newline character

        if (choice == 1) {
            System.out.println("Input the text:");
            text = sc.nextLine();
        } else if (choice == 0) {
            System.out.println("Input the file path:");
            String filePath = sc.nextLine();
            text = readFile(filePath);
        } else {
            System.out.println("Invalid choice.");
            sc.close();
            return;
        }

        String[] words = text.split("[\\s\\p{Punct}]+");
        int wordCount = words.length;

        System.out.println("Total count of words: " + wordCount);

        sc.close();
    }

    public static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try {
            File file = new File(filePath);
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                content.append(fileScanner.nextLine());
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        return content.toString();
}
}
