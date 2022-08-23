import java.util.Map;

public class WordsChecker {
    protected String sampleText;

    public WordsChecker(String sampleText) {
        this.sampleText = sampleText;
    }

    public static boolean hasWord(Map<String, Integer> hashMapWords, String word) { // поиск слова в мапе
        for (Map.Entry<String, Integer> entry : hashMapWords.entrySet()) {
            if (entry.getKey().equals(word)) {
                System.out.println("Количество найденного '" + entry.getKey() + "' слова к тексте " + entry.getValue());
                return true;
            }
        }
        return false;
    }
}
