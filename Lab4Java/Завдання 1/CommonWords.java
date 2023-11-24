import java.io.*;
import java.util.*;

public class CommonWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть ім'я першого файлу:");
        String fileName1 = scanner.nextLine();
        System.out.println("Введіть ім'я другого файлу:");
        String fileName2 = scanner.nextLine();

        List<String> wordsFile1 = extractWordsFromFile(fileName1);
        List<String> wordsFile2 = extractWordsFromFile(fileName2);

        wordsFile1 = convertToLowerCase(wordsFile1);
        wordsFile2 = convertToLowerCase(wordsFile2);

        List<String> commonWords = findCommonWords(wordsFile1, wordsFile2);

        Collections.sort(commonWords);

        System.out.println("Слова, що зустрічаються в обох файлах:");
        System.out.println(commonWords);
        System.out.println("\nСписок слів з першого файлу:");
        Collections.sort(wordsFile1);
        System.out.println(wordsFile1);
        System.out.println("\nСписок слів з другого файлу:");
        Collections.sort(wordsFile2);
        System.out.println(wordsFile2);

        scanner.close();
    }

    private static List<String> extractWordsFromFile(String fileName) {
        List<String> words = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            fileScanner.useDelimiter("[\\s.,:;]+");
            while (fileScanner.hasNext()) {
                words.add(fileScanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return words;
    }

    private static List<String> convertToLowerCase(List<String> words) {
        List<String> lowerCaseWords = new ArrayList<>();
        for (String word : words) {
            lowerCaseWords.add(word.toLowerCase());
        }
        return lowerCaseWords;
    }

    private static List<String> findCommonWords(List<String> words1, List<String> words2) {
        List<String> commonWords = new ArrayList<>();
        Set<String> uniqueWords1 = new HashSet<>(words1);

        for (String word : words2) {
            if (uniqueWords1.contains(word)) {
                commonWords.add(word);
            }
        }
        return commonWords;
    }
}
