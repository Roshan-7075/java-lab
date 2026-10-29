package inputoutput;
import java.io.*;
import java.nio.file.*;
import java.util.*;

// Each question is its own class. Compile: javac -d . inputoutput.java   Run: java inputoutput.CharInputStreamReader

// Helper used by Q9 and Q10: makes a sample text file if the file does not exist yet.
class IOHelper {
    static String sampleFile() throws IOException {
        Path p = Paths.get("sample.txt");
        if (!Files.exists(p))
            Files.write(p, Arrays.asList("Java is a popular language.", "File handling is easy in Java.", "This is line three."));
        return p.toString();
    }
}

// Program: Enter the character from user using InputStreamReader
// file name should be CharInputStreamReader.java
class CharInputStreamReader {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        System.out.print("Enter a character: ");
        char c = (char) isr.read();
        System.out.println("You entered: " + c);
    }
}

// Program: Enter the string from user using BufferedReader (InputStreamReader wrapped)
// file name should be StringBufferedReader.java
class StringBufferedReader {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a string: ");
        String s = br.readLine();
        System.out.println("You entered: " + s);
    }
}

// Program: Enter the integer from user using Scanner class
// file name should be ScannerInt.java
class ScannerInt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = sc.nextInt();
        System.out.println("You entered: " + n);
    }
}

// Program: Enter the float from user using Scanner class
// file name should be ScannerFloat.java
class ScannerFloat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a float: ");
        float f = sc.nextFloat();
        System.out.println("You entered: " + f);
    }
}

// Program: Enter the double from user using Scanner class
// file name should be ScannerDouble.java
class ScannerDouble {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a double: ");
        double d = sc.nextDouble();
        System.out.println("You entered: " + d);
    }
}

// Program: Enter the boolean from user using Scanner class
// file name should be ScannerBoolean.java
class ScannerBoolean {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a boolean (true/false): ");
        boolean b = sc.nextBoolean();
        System.out.println("You entered: " + b);
    }
}

// Program: Enter the short integer from user using Scanner class
// file name should be ScannerShort.java
class ScannerShort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a short integer: ");
        short s = sc.nextShort();
        System.out.println("You entered: " + s);
    }
}

// Program: Enter the long integer from user using Scanner class
// file name should be ScannerLong.java
class ScannerLong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a long integer: ");
        long l = sc.nextLong();
        System.out.println("You entered: " + l);
    }
}

// Program: Get all characters from the file and display on the screen
// (pass a file name as argument, otherwise sample.txt is created and used)
// file name should be ReadFileCharacters.java
class ReadFileCharacters {
    public static void main(String[] args) throws IOException {
        String file = args.length > 0 ? args[0] : IOHelper.sampleFile();
        try (FileReader fr = new FileReader(file)) {
            int ch;
            while ((ch = fr.read()) != -1) System.out.print((char) ch);
        }
        System.out.println();
    }
}

// Program: Get all characters from the file, count number of lines, words, characters and display on the screen
// file name should be FileLineWordCharCount.java
class FileLineWordCharCount {
    public static void main(String[] args) throws IOException {
        String file = args.length > 0 ? args[0] : IOHelper.sampleFile();
        int lines = 0, words = 0, chars = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                lines++;
                chars += line.length();
                if (!line.trim().isEmpty()) words += line.trim().split("\\s+").length;
            }
        }
        System.out.println("Lines = " + lines + ", Words = " + words + ", Characters = " + chars);
    }
}
