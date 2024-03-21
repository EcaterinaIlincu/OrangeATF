package orange.tasks;

import orange.exceptions.NoDuplicatesException;

import java.util.HashMap;
import java.util.Map;

public class FindDuplicatedWords {

    public void getAllDuplicates(String inputText) throws NoDuplicatesException {

        //Initialise variable to store remaining text after first sentence is ignored
        String remainingText = "";

        // create a map to store all words
        Map<String, Integer> wordMap = new HashMap<>();

        // create another map to store duplicated words
        Map<String, Integer> duplicateWordMap = new HashMap<>();

        // find first dot to identify first sentence
        int firstDot = inputText.indexOf('.');

        // delete first sentence and store it in remainingText, remove characters:,. and lowercase all letters
        if (firstDot != -1) {
            remainingText = inputText.substring(firstDot + 1).trim().replaceAll("[,.]", "").toLowerCase();
        }

        // splitting words from remaining text to array
        String[] words = remainingText.split(" ");



      // Iterate through each word from Array String, add all words to wordMap and number of time it is encountered
        for (String word : words) {
            if (wordMap.containsKey(word)) {
                int count = wordMap.get(word);
                wordMap.put(word, count + 1);
            } else {
                wordMap.put(word, 1);
            }
        }

        // iterate through each word from wordMap and store the words that are found more than once in duplicateWordMap
        for (String word : wordMap.keySet()) {
            if (wordMap.get(word) > 1) {
                duplicateWordMap.put(word, wordMap.get(word));
            }
        }
        // iterate through each word from duplicateWordMap and print each duplicated word and number of repeats
        for (String word : duplicateWordMap.keySet()) {
            System.out.println("Word:" + "'" + word + "'" + " is found: " + duplicateWordMap.get(word) + " times");
        }
        // throw exception if no duplicated words are found
        if (duplicateWordMap.isEmpty()) {
            throw new NoDuplicatesException("No Duplicates Found");
        }
    }

}

