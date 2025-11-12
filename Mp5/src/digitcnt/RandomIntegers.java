package digitcnt;

import java.util.Random;
import java.util.stream.IntStream;

public class RandomIntegers {
    public static void main(String[] args) {
        Random random = new Random();
        int[] counts = new int[10];  

        IntStream randomNumbers = random.ints(100, 0, 10);

        randomNumbers.forEach(n -> {
            System.out.println(n);
            counts[n]++;  
        });

        System.out.println("\nNumber Frequency\n");
        for (int i = 0; i < counts.length; i++) {
            System.out.printf("Number %d: %d%n", i, counts[i]);
        }
    }
}

/*
 * AI USED 
 * 
 * 
 * package digitcnt;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomIntegers {
    public static void main(String[] args) {
        Random random = new Random();
        IntStream randomNumbers = random.ints(100, 0, 1000);
        randomNumbers.forEach(System.out::println);
    }
}

AI USED: CHAT GPT, PROMPT: what is the syntax to limit .ints to 0-9?
RESPONSE: 
        IntStream randomNumbers = random.ints(100, 0, 10);

 * AI USED: CHAT GPT, PROMPT: what is the best way to read an integer from an intstream?
 * 
 *RESPONSE: 
    ✅ 1. Process directly in the stream (best practice for streams)

✅ 1. Process directly in the stream (best practice for streams)

Process directly in the stream (best practice for streams)

If you just want to use each integer once — print it, count it, transform it — 
the best approach is to consume it inside a terminal operation like forEach,
 sum, average, collect, etc. * 
 * 
 * IntStream randomNumbers = new Random().ints(100, 0, 10);

randomNumbers.forEach(n -> System.out.println("Read: " + n));

 * 2. Convert to an array (if you need random access or reuse)

If you need to read specific integers later or multiple times, 
the most practical approach is to store them in an array.

int[] numbers = new Random().ints(100, 0, 10).toArray();

// Example of reading
System.out.println("First number: " + numbers[0]);
System.out.println("Tenth number: " + numbers[9]);

prompt: so its just like reading any variable, you just need to call it specially?
int n = randomNumbers.get(0);  // ❌ doesn’t work

randomNumbers.forEach(n -> System.out.println("Got: " + n)); // works

 */
