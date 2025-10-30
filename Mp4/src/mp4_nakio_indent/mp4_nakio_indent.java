package mp4_nakio_indent;


import java.util.Scanner;
import java.util.Stack;

/**
 * Indentation checker that reads and validates files located in the same package
 * as this source code. It prints a numbered listing of each line and reports
 * whether indentation is proper according to stack-based indentation rules.
 */
public class mp4_nakio_indent {
    private final Stack<Integer> indentStack = new Stack<>();

    static class BadIndentationException extends RuntimeException {
        private static final long serialVersionUID = 1L; // Eclipse: RuntimeException is Serializable
        BadIndentationException(String message) { super(message); }
    }

    private int findFirstNonBlank(String line) {
        if (line == null || line.isEmpty()) return -1;
        for (int i = 0; i < line.length(); i++) {
            if (!Character.isWhitespace(line.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    private void processLine(String line, int lineNumber) {
        int index = findFirstNonBlank(line);
        if (index == -1) return; // blank line

        if (indentStack.isEmpty()) {
            indentStack.push(index);
            return;
        }

        int top = indentStack.peek();
        if (index > top) {
            indentStack.push(index);
            return;
        }

        while (!indentStack.isEmpty() && indentStack.peek() > index) {
            indentStack.pop();
        }

        if (indentStack.isEmpty() || indentStack.peek() != index) {
            throw new BadIndentationException("bad indentation at line #:" + lineNumber);
        }
    }

    /**
     * Check indentation for a file located in the same package as this class.
     */
    public void checkIndentation(String fileName) {
        indentStack.clear();

        // Load from the same package as this class. Place the .txt files in the
        // same package folder as IndentChecker.java under a source folder (e.g., src/).
        java.io.InputStream in = mp4_nakio_indent.class.getResourceAsStream(fileName);
        if (in == null) {
            System.out.println("File not found in package: " + fileName);
            return;
        }

        try (Scanner input = new Scanner(in)) {
            int lineNumber = 1;
            while (input.hasNextLine()) {
                String line = input.nextLine();
                System.out.println(lineNumber + ":" + line);
                processLine(line, lineNumber);
                lineNumber++;
            }
            System.out.println("****** " + fileName + " must be properly indented.");
        } catch (BadIndentationException err) {
            System.out.println(err);
        }
    }

    public static void main(String[] args) {
        mp4_nakio_indent checker = new mp4_nakio_indent();

        String[] files = {
            "CPS261_JH6_ProperlyIndented.txt",
            "CPS261_JH6_ProperlyIndented2.txt",
            "CPS261_JH6_NotIndentedProperly.txt",
            "CPS261_JH6_NotIndentedProperly2.txt",
            "CPS261_JH6_NotIndentedProperly3.txt"
        };

        for (String file : files) {
            System.out.println("\nProcessing file: " + file);
            checker.checkIndentation(file);
        }
    }}
