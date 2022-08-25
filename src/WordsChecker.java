import java.util.ArrayList;
import java.util.Arrays;

public class WordsChecker { //ЗАДАЧА №2, Создайте класс WordsChecker (англ. проверятель слов).
    private final ArrayList<String> arrListWords;

    public WordsChecker(String arrListWords) {
        //ЗАДАЧА №2, Пусть у него будет конструктор, в который передаётся текст, в котором мы будем проверять наличие слов.
        //Вам предлагается разбить текст на слова (воспользуйтесь text.split("\\P{IsAlphabetic}+"); для этого) и
        //положить их в коллекцию для быстрой проверки наличия в ней слов через специальный метод коллекции.
        this.arrListWords = new ArrayList<>(Arrays.asList(arrListWords.split("\\P{IsAlphabetic}+")));
    }

    //ЗАДАЧА №2, Кроме конструктора у него должен быть метод hasWord,
    // куда передаётся слово и который возвращает ответ на вопрос (boolean) о том, есть ли это слово в тексте или нет.
    public boolean hasWord(Object inputWord) { // поиск слова
        return arrListWords.contains(inputWord); //для быстрой проверки наличия в ней слов через специальный метод коллекции.
    }
}
