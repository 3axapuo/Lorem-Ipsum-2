import java.util.HashSet;

import static java.util.List.of;

public class WordsChecker { //ЗАДАЧА №2, Создайте класс WordsChecker (англ. проверятель слов).
    private final HashSet<String> hashSetWords;

    public WordsChecker(String sampleText) {
        //ЗАДАЧА №2, Пусть у него будет конструктор, в который передаётся текст, в котором мы будем проверять наличие слов.
        //Вам предлагается разбить текст на слова (воспользуйтесь text.split("\\P{IsAlphabetic}+"); для этого) и
        //положить их в коллекцию для быстрой проверки наличия в ней слов через специальный метод коллекции.
        this.hashSetWords = new HashSet<>(of(sampleText.split("\\P{IsAlphabetic}+")));//ArrayList<>(Arrays.asList(arrListWords.split("\\P{IsAlphabetic}+")));
    }

    //ЗАДАЧА №2, Кроме конструктора у него должен быть метод hasWord,
    // куда передаётся слово и который возвращает ответ на вопрос (boolean) о том, есть ли это слово в тексте или нет.
    public boolean hasWord(Object inputWord) { // поиск слова
        return hashSetWords.contains(inputWord); //для быстрой проверки наличия в ней слов через специальный метод коллекции.
    }
}
