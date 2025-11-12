package scrabbler;
import java.util.*;
import java.util.stream.*;

public class ScrabbleStats {

    private static int scrabbleScore(String word, Map<Character, Integer> values) {
        return word.toLowerCase()
                   .chars()
                   .map(c -> values.getOrDefault((char) c, 0))
                   .sum();
    }

    public static void main(String[] args) {
        Map<Character, Integer> letterValues = new HashMap<>();
        letterValues.put('a', 1);
        letterValues.put('b', 3);
        letterValues.put('c', 3);
        letterValues.put('d', 2);
        letterValues.put('e', 1);
        letterValues.put('f', 4);
        letterValues.put('g', 2);
        letterValues.put('h', 4);
        letterValues.put('i', 1);
        letterValues.put('j', 8);
        letterValues.put('k', 5);
        letterValues.put('l', 1);
        letterValues.put('m', 3);
        letterValues.put('n', 1);
        letterValues.put('o', 1);
        letterValues.put('p', 3);
        letterValues.put('q', 10);
        letterValues.put('r', 1);
        letterValues.put('s', 1);
        letterValues.put('t', 1);
        letterValues.put('u', 1);
        letterValues.put('v', 8);   
        letterValues.put('w', 4);
        letterValues.put('x', 8);
        letterValues.put('y', 4);
        letterValues.put('z', 10);

        List<String> words = Arrays.asList("Java", "program", "list", "string", "unix", "hours", "syntax", "error");

        double average = words.stream()
                .mapToInt(w -> scrabbleScore(w, letterValues))
                .average()
                .orElse(0.0);

        List<String> topThree = words.stream()
                .sorted(Comparator.comparingInt((String w) -> scrabbleScore(w, letterValues)).reversed())
                .limit(3)
                .collect(Collectors.toList());

        List<String> belowAvg = words.stream()
                .filter(w -> scrabbleScore(w, letterValues) < average)
                .collect(Collectors.toList());

        List<String> aboveAvg = words.stream()
                .filter(w -> scrabbleScore(w, letterValues) > average)
                .collect(Collectors.toList());

        System.out.println("Top three words are:");
        topThree.forEach(w ->
                System.out.println(w + ":" + scrabbleScore(w, letterValues))
        );

        System.out.println(String.format("Average scrabble value is: %.3f", average));
        System.out.println("words below average:" + belowAvg);
        System.out.println("words above average:" + aboveAvg);
    }
}
/*
 * AI USED: CHAT GPT, PROMPT: when using a hash map, what is best practice to parse against a character, from a string in an array?
 * RESPONSE: 
 * 
 * If your map uses characters as keys, loop through char[] or use String.chars().

Example:
 * Map<Character, Integer> letterValues = new HashMap<>();
letterValues.put('a', 1);
// ...

String word = "Java";
int score = word.toLowerCase()
                .chars()
                .map(c -> letterValues.getOrDefault((char) c, 0))
                .sum();

 * 
 * AI USED: CHAT GPT, PROMPT: why isnt this working
 * 
 *             double average = words.stream()
                .mapToInt(scrabbleScore(w, letterValues))
                .average()
                
 * RESPONSE: 
 * Excellent question — you’re very close, but there’s just a small syntax mistake in how you’re using the mapToInt() method.

Let’s break it down carefully
 * 
 * double average = words.stream()
    .mapToInt(w -> scrabbleScore(w, letterValues))
    .average()
    .orElse(0.0);

 * 
 * w -> scrabbleScore(w, letterValues)	a lambda expression that calls your method for each word
.mapToInt(...)	converts each word into an int score
.average()	computes the mean of those int values
.orElse(0.0)	ensures you don’t get a NoSuchElementException if the list is empty
 * 
 * 
 * AI USED: CHAT GPT, PROMPT: why is this broken?:
int score = 0;
for (char c : word.toCharArray()) {
    score += letterValues.get(c); 
}

 * RESPONSE: You’re looping through each character in word.

You look up that character in the HashMap<Character, Integer> letterValues.
The proper, safe version
int score = 0;
for (char c : word.toLowerCase().toCharArray()) {
    score += letterValues.getOrDefault(c, 0);
}
return score;

 * 
 * 
 */
