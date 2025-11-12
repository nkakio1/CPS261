package twoDArray;
import java.util.Arrays;

public class ArraySort {
    public static void main(String[] args) {
        int[][] numbers = {
            {34, 89},
            {56, 3},
            {27, 61},
            {45, 8},
            {45, 89}
        };

        System.out.println("Distinct numbers in increasing order:");

        Arrays.stream(numbers)           
              .flatMapToInt(Arrays::stream) 
              .distinct()                 
              .sorted()                     
              .forEach(num -> System.out.print(num + " "));
    }
}
/*
AI USED: CHAT GPT, PROMPT: give me a list of modifiers for arrays.stream 
that will parse a two dimensional array, delete duplicates, and sort going up,
 additonally, when using foreach, what is the arrow -> actually denoting? 
 
 RESPONSE:
 ✅ Common Stream Modifiers (intermediate operations) for your goal
Operation	Purpose	Example
flatMapToInt()	Flattens a stream of arrays into a stream of ints	.flatMapToInt(Arrays::stream)
distinct()	Removes duplicates	.distinct()
sorted()	Sorts ascending (default)	.sorted()
boxed()	Converts primitive IntStream to Stream<Integer> if you need to collect as a List	.boxed()
collect(Collectors.toList())	Terminal op to gather into a list	.collect(Collectors.toList())
forEach()	Terminal op to perform an action for each element	.forEach(System.out::println)

✅ Putting It Together

Here’s how to:

Flatten a 2D array

Remove duplicates

Sort ascending

Collect or print results

  List<Integer> result = Arrays.stream(numbers)
            .flatMapToInt(Arrays::stream) // flatten 2D → 1D
            .distinct()                   // remove duplicates
            .sorted()                     // sort ascending
            .boxed()                      // convert IntStream → Stream<Integer>
            .collect(Collectors.toList()); // gather results

        System.out.println(result);
    }
*/