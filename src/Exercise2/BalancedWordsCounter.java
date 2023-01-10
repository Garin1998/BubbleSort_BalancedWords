package Exercise2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Class which contains a public method to count all balanced words in every possible sub-word of provided String input.
 * @author Krzysztof Kubiś
 * @since JDK 17
 */
public class BalancedWordsCounter {

    public BalancedWordsCounter() {

    }

    /**
     * @param input provided word to be separated to every possible sub-word
     * @return count of every balanced words as Integer Class.
     * @throws RuntimeException when provided word contains numbers or is a null.
     */
    public Integer count(String input) throws RuntimeException {
        if (input.chars().anyMatch(Character::isDigit)) {
            throw new RuntimeException();
        }

        int count = 0;
        for (int i = 0; i <= input.length() - 1; i++) {
            for (int j = i + 1; j <= input.length(); j++) {
                String extractedWord = input.substring(i, j);
                if (isItBalancedWord(extractedWord)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isItBalancedWord(String input) {
        HashSet<Character> distinctCharacters = createHashSetWithCharsInWord(input);
        List<Long> occurrenceOfChars = createArrayListWithCountedOccurrenceOfCharsInWord(distinctCharacters, input);
        return Collections.frequency(occurrenceOfChars, occurrenceOfChars.get(0)) == occurrenceOfChars.size();
    }

    private HashSet<Character> createHashSetWithCharsInWord(String input) {
        HashSet<Character> distinctCharacters = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            distinctCharacters.add(input.charAt(i));
        }
        return distinctCharacters;
    }

    private ArrayList<Long> createArrayListWithCountedOccurrenceOfCharsInWord(HashSet<Character> distinctCharacters, String word) {
        ArrayList<Long> occurrenceOfChars = new ArrayList<>();
        for (Character currentCharacter : distinctCharacters) {
            occurrenceOfChars.add(word.chars().filter((character) -> character == currentCharacter).count());
        }
        return occurrenceOfChars;
    }
}
