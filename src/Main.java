import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static String sampleText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
            "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut " +
            "enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut " +
            "liquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in" +
            " voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur " +
            "sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt " +
            "mollit anim id est laborum.";

    public static void main(String[] args) {
        Map<Character, Integer> hashMapLetters = new HashMap<>(); // map для букв
        Map<String, Integer> hashMapWords = new HashMap<>(); // map для слов
        WordsChecker findWord = new WordsChecker(sampleText);
        Scanner input = new Scanner(System.in);
        transferTheMapAndCalculateWords(hashMapWords, findWord.sampleText.split("\\P{IsAlphabetic}+"));
        while (true) {
            System.out.println("\n☐ Введите слово для его поиска или введите `end` ");
            String inputWord = input.nextLine().trim();
            if ("end".equals(inputWord)) break; // проверка на выход
            if (!WordsChecker.hasWord(hashMapWords, inputWord)) {
                System.out.println("Слово '" + inputWord + "' не найдено.");
            }
        }
        transferTheMapAndCalculateLetters(hashMapLetters, sampleText.replaceAll("[^\\p{L}]", "").toLowerCase());// перемещаем в структуру мап, вычисляем частоту встречи букв
        minimumAndMaximumLetters(hashMapLetters); // выводим частоту (минимальную, максимальную) встреч букв из текста
    }

    public static void transferTheMapAndCalculateLetters(Map<Character, Integer> hashMapLetters, String letters) { // перенос строки в мапу
        for (char letter : letters.toCharArray()) {
            if (hashMapLetters.containsKey(letter)) { // если буква онаружена больше одного раза
                hashMapLetters.put(letter, hashMapLetters.get(letter) + 1); //Он есть в мапе. Значит он нам уже встречался. Вынимаем текущее значение для ключа (нашего символа), увеличиваем это число на 1 и вставляем обратно в мапу.
            } else { //если буква обнаружена первый раз
                hashMapLetters.put(letter, 1); //Его нет в мапе. Значит, мы встретили его в первый раз и вставляем в мапу пару где ключ это наш символ, а значение это 1 (тк встретили его всего один раз).
            }
        }
    }

    public static void transferTheMapAndCalculateWords(Map<String, Integer> hashMapWords, String[] words) { // перенос строки в мапу
        for (String word : words) {
            if (hashMapWords.containsKey(word)) { // если слово обнаружено больше одного раза
                hashMapWords.put(word, hashMapWords.get(word) + 1);
            } else { //если слово обнаружено первый раз
                hashMapWords.put(word, 1);
            }
        }
    }

    public static void minimumAndMaximumLetters(Map<Character, Integer> hashMapLetters) { // вычисляем минимальное присутствие одной буквы
        int minInteger = Integer.MAX_VALUE; // Поиск минимума абсолютно аналогичен (только вместо -1 возьмите Integer.MAX_VALUE - максимальное значение которое может быть у int)
        minInteger = Collections.min(hashMapLetters.values());
        int maxInteger = Collections.max(hashMapLetters.values());

        for (Map.Entry<Character, Integer> entry : hashMapLetters.entrySet()) {
            if (entry.getValue().equals(minInteger)) {
                System.out.println("Частота встречи буквы " + entry.getKey() + " в тексте минимально, всего " + entry.getValue());
            }
            if (entry.getValue().equals(maxInteger)) {
                System.out.println("Частота встречи буквы " + entry.getKey() + " в тексте максимально, всего " + entry.getValue());
            }
        }
    }
}