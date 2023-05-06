package task;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final String PATH = "src/task/";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        System.out.println("Enter the book: ");
        String bookName = scanner.nextLine();
        List<String> words;
        try {
            words = parser.readAll(PATH + bookName + ".txt");
        } catch (IOException e){
            System.out.println("Name doesn't match the file!");
            return;
        }
        Map<String, Long> countingWords = parser.countWords(words);
        int unique = parser.countUnique(words);
        System.out.println(parser.countUnique(words));
        System.out.println(countingWords);
        try {
            parser.saveStatistic(countingWords.toString(), "\nUnique words: " + unique);
        } catch (IOException e){
            System.err.println("Can't save!");
        }
            scanner.close();
    }
}