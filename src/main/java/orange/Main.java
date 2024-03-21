package orange;

import orange.exceptions.NoDuplicatesException;
import orange.tasks.FindDuplicatedWords;

public class Main {
    public static void main(String[] args) {

        String inputText = "Lorem ipsum dolor sit amet. Rem impedit nihil quo labore perspiciatis sed " +
                "ducimus error et nihil iste aut dolores aliquid non fuga perspiciatis. Et consequatur quia" +
                " quo voluptatem quia cum facilis voluptatem quo autem dolores ut quis deserunt ea laudantium" +
                " temporibus ut sit eius. Sed distinctio accusamus eum autem beatae nam illum neque aut " +
                "tempore voluptates sed iure dolores eos deleniti galisum non expedita amet.";

        FindDuplicatedWords findDuplicatedWords = new FindDuplicatedWords();

        try {
            findDuplicatedWords.getAllDuplicates(inputText);
        } catch (NoDuplicatesException e) {
            System.out.println(e.getMessage());
        }
    }
}