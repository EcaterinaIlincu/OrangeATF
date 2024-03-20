package orange.tasks;

import orange.exceptions.NoDuplicatesException;

import java.util.HashMap;
import java.util.Map;

public class FindDuplicatedWords {

    public void getAllDuplicates(String inputText) throws NoDuplicatesException {

        String remainingText = "";
        Map<String, Integer> wordMap = new HashMap<>();
        Map<String, Integer> wordMapUnique = new HashMap<>();

        int firstDot = inputText.indexOf('.'); // find first occurrence of dot

        if (firstDot != -1) {
            remainingText = inputText.substring(firstDot + 1).trim().replaceAll("[,.]", "").toLowerCase();  // extract the substring after first dot
        }

        String[] words = remainingText.split(" ");    // create an array of strings separated by space

        for (String word : words) {
            if (wordMap.containsKey(word)) {
                int count = wordMap.get(word);
                wordMap.put(word, count + 1);
                // ["Lorem": 1 ]
            } else {
                wordMap.put(word, 1);
            }
        }

        for (String word : wordMap.keySet()) {
            if (wordMap.get(word) > 1) {
                wordMapUnique.put(word, wordMap.get(word));
            }
        }
        for (String word: wordMapUnique.keySet()) {
            System.out.println("Word:" + "'" + word + "'" + " is found: " + wordMapUnique.get(word) + " times");
        }

        if (wordMapUnique.isEmpty()){
            throw new NoDuplicatesException("No Duplicates Found");
        }
    }

}

