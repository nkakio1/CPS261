package mp4_nakio_dict;


import java.io.*;
import java.util.*;


public class mp4_nakio_dict {
    private final HashSet<String> dictionary = new HashSet<>();
    private final TreeSet<String> missSpelled = new TreeSet<>();
    private final Scanner input; 

    public mp4_nakio_dict() {
        this.input = new Scanner(System.in);
        File dict = resolveFile(
                "dictionary.txt",
                "src/mp4_nakio_dict/dictionary.txt",
                "src/dictionary.txt"
        );
        if (dict == null) {
            System.out.println("[Error] dictionary.txt not found. Working directory: "
                    + new File(".").getAbsolutePath());
        } else {
            try {
                loadDictionary(dict.getPath());
            } catch (FileNotFoundException e) {
                System.out.println("[Error] Failed to open dictionary at: " + dict.getPath());
            }
        }
    }

    private File resolveFile(String... candidates) {
        for (String p : candidates) {
            File f = new File(p);
            if (f.exists() && f.isFile()) return f;
        }
        return null;
    }

    private void loadDictionary(String path) throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File(path))) {
            while (sc.hasNextLine()) {
                String w = sc.nextLine().trim();
                if (w.isEmpty()) continue;
                dictionary.add(w.toLowerCase(Locale.ROOT));
            }
        }
        System.out.println("[Loaded] " + dictionary.size() + " words from: " + path);
    }

    public void checkSpelling(String fileNameOrPath) {
        File inputFile = resolveFile(
                fileNameOrPath,
                "src/mp4_nakio_dict/" + fileNameOrPath,
                "src/" + fileNameOrPath
        );
        if (inputFile == null) {
            System.out.println("[Error] Input file not found: " + fileNameOrPath);
            return;
        }

        String filePath = inputFile.getPath();
        System.out.println("======== Spell checking " + filePath + " =========");
        try (Scanner fileScanner = new Scanner(inputFile)) {
            int lineNo = 0;
            while (fileScanner.hasNextLine()) {
                lineNo++;
                String line = fileScanner.nextLine();

               
                String[] raw = line.split("[^\\p{L}\\p{Nd}-–]+");

                boolean printedLineNumber = false;

                for (String token : raw) {
                    if (token == null || token.isEmpty()) continue;

                    String word = token.toLowerCase(Locale.ROOT);
                    if (!Character.isLetter(word.codePointAt(0))) continue;
                    if (dictionary.contains(word) || missSpelled.contains(word)) continue;

                    if (!printedLineNumber) {
                        System.out.println("line number:" + lineNo);
                        printedLineNumber = true;
                    }

                    while (true) {
                        System.out.print(word + " add to dictionary? y or n\n");
                        String ans = input.nextLine().trim().toLowerCase(Locale.ROOT);
                        if (ans.startsWith("y")) {
                            dictionary.add(word);
                            break;
                        } else if (ans.startsWith("n")) {
                            missSpelled.add(word);
                            break;
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("[Error] " + e.getMessage());
            return;
        }

     
        System.out.println("======miss spelled words======");
        for (String w : missSpelled) {
            System.out.println(w);
        }
    }

    public static void main(String[] args) {
        mp4_nakio_dict sc = new mp4_nakio_dict();
        if (args.length == 0) {
            sc.checkSpelling("Mexico.txt");
        } else {
            for (String f : args) sc.checkSpelling(f);
        }
    }
}

    
    /*
     * ERROR HERE
     *     public SpellCheck() throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File("dictionary.txt"))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                    if (w.isEmpty()) continue;
                    w = w.toLowerCase(Locale.ROOT);
                    if (w.charAt(0) =< 'a' & w.charAt(0) >= 'z') continue; 
                    dictionary.add(w);
                }
            }
        }
    }
chat gpt SOULUTION
    public mp4_nakio_dict() throws FileNotFoundException {
        // Add all of the words from "dictionary.txt" to the dictionary HashSet
        try (Scanner sc = new Scanner(new File("dictionary.txt"))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                // dictionary file already one word per line, but be safe and split
                for (String w : line.split("\\s+|\\p{Punct}+")) {
                    if (w.isEmpty()) continue;
                    w = w.toLowerCase(Locale.ROOT);
                    if (w.charAt(0) < 'a' || w.charAt(0) > 'z') continue; // skip numbers
                    dictionary.add(w);
                }
            }
        }
    }








ERROR HERE     private void handleUnknownWord(String word) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Unknown word ' + word + '. (y) add to Dictionary, (n) mark miss-spelled: ");
            String resp = in.nextLine().toLowerCase;
            if (resp.startsWith("y")) {
                dictionary.add(word);
                break;
            } else if (resp.startsWith("n")) {
                miss_spelled_words.add(word);
                break;
            } else {
                System.out.println("Please enter D or M.");
            }
        }
    }
chat gpt SOULUTION private void handleUnknownWord(String word) {
        try (Scanner in = new Scanner(System.in)) {
			while (true) {
			    System.out.print("Unknown word '" + word + "'. (D) add to Dictionary, (M) mark miss-spelled: ");
			    String resp = in.nextLine().trim().toLowerCase(Locale.ROOT);
			    if (resp.startsWith("y")) {
			        dictionary.add(word);
			        break;
			    } else if (resp.startsWith("n")) {
			        miss_spelled_words.add(word);
			        break;
			    } else {
			        System.out.println("Please enter y or n.");
			    }
			}
		}
    }
    
    
    ERROR HERE     public mp4_nakio_dict() throws FileNotFoundException {
        this.input = new Scanner(System.in);
        loadDictionary("dictionary.txt");
    }
chat gpt SOULUTION public mp4_nakio_dict() {
        this.input = new Scanner(System.in);
        // Try multiple likely locations for dictionary.txt
        File dict = resolveFile(
                "dictionary.txt",
                "src/mp4_nakio_dict/dictionary.txt",
                "src/dictionary.txt"
        );
        if (dict == null) {
            System.out.println("[Error] dictionary.txt not found. Working directory: "
                    + new File(".").getAbsolutePath());
            System.out.println("Place dictionary.txt in the project root or src/mp4_nakio_dict/ and run again.\n");
        } else {
            try {
                loadDictionary(dict.getPath());
            } catch (FileNotFoundException e) {
                System.out.println("[Error] Failed to open dictionary at: " + dict.getPath());
            }
        }
    }
    
    
    prompt: why isnt myfile finding the text files?
    public class mp4_nakio_dict {
    final HashSet<Str> dictionary = new HashSet<>();
    final TreeSet<Str> missSpelled = new TreeSet<>();
    final Scanner input; 

    public mp4_nakio_dict() {
        this.input = new Scanner(System.in);
        File dict = resolveFile(
                "dictionary.txt",
                "src/mp4_nakio_dict/dictionary.txt",
                "src/dictionary.txt"
        );
       
            }
        }
    }
    
    SOULUTION + other fixes
    public class mp4_nakio_dict {
    private final HashSet<String> dictionary = new HashSet<>();
    private final TreeSet<String> missSpelled = new TreeSet<>();
    private final Scanner input; 

    public mp4_nakio_dict() {
        this.input = new Scanner(System.in);
        File dict = resolveFile(
                "dictionary.txt",
                "src/mp4_nakio_dict/dictionary.txt",
                "src/dictionary.txt"
        );
        if (dict == null) {
            System.out.println("[Error] dictionary.txt not found. Working directory: "
                    + new File(".").getAbsolutePath());
        } else {
            try {
                loadDictionary(dict.getPath());
            } catch (FileNotFoundException e) {
                System.out.println("[Error] Failed to open dictionary at: " + dict.getPath());
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     */

