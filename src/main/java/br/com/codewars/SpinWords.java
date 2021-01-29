package br.com.codewars;

import java.util.Arrays;
import java.util.List;

public class SpinWords {

    public String spinWords(String sentence) {
        String[] arrayString = sentence.split(" ");
        List<String> listString = Arrays.asList(arrayString);

        StringBuilder result = new StringBuilder("");

        for (int index = 0; index < listString.size(); index++) {
            String word = listString.get(index);
            if (word.length() < 5) {
                result.append(word);
            } else {
                StringBuilder wordReverted = new StringBuilder(word).reverse();
                result.append(wordReverted);
            }

            boolean hasNext = index + 1 != listString.size();

            if (hasNext) {
                result.append(" ");
            }

        }

        return result.toString();

    }
}
