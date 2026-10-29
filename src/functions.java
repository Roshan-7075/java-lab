package functions;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

// Program: Write a Java method to find the smallest number among three numbers.

// file name should be SmallestOfThree.java
class SmallestOfThree {
    static int smallest(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
    public static void main(String[] args) {
        System.out.println("Smallest of 25, 9, 17 = " + smallest(25, 9, 17));
    }
}

// Program: Write a Java method to compute the average of three numbers.

// file name should be AverageOfThree.java
class AverageOfThree {
    static double average(double a, double b, double c) {
        return (a + b + c) / 3;
    }
    public static void main(String[] args) {
        System.out.println("Average of 10, 20, 35 = " + average(10, 20, 35));
    }
}

// Program: Write a Java method to display the middle character of a string. Note: a) If the length of the string is odd there will be two middle characters. b) If the length of the string is even there will be one middle character.

// file name should be MiddleCharacter.java
class MiddleCharacter {
    // Odd length -> one middle character, even length -> two middle characters
    static String middle(String s) {
        int len = s.length();
        int mid = len / 2;
        return (len % 2 == 0) ? s.substring(mid - 1, mid + 1) : s.substring(mid, mid + 1);
    }
    public static void main(String[] args) {
        System.out.println("Middle of \"Java\"  : " + middle("Java"));
        System.out.println("Middle of \"Hello\" : " + middle("Hello"));
    }
}

// Program: Write a Java method to count all the words in a string.

// file name should be CountWords.java
class CountWords {
    static int countWords(String s) {
        s = s.trim();
        return s.isEmpty() ? 0 : s.split("\\s+").length;
    }
    public static void main(String[] args) {
        String text = "Java is a popular programming language";
        System.out.println("Text  : " + text);
        System.out.println("Words : " + countWords(text));
    }
}

// Program: Write a Java method to compute the future investment value at a given interest rate for a specified number of years.

// file name should be FutureInvestment.java
class FutureInvestment {
    // annualRate in percent, compounded monthly
    static double futureValue(double investment, double annualRate, int years) {
        double monthlyRate = annualRate / 1200;
        return investment * Math.pow(1 + monthlyRate, years * 12);
    }
    public static void main(String[] args) {
        double result = futureValue(1000, 5.0, 10);
        System.out.printf("Future value after 10 years: %.2f%n", result);
    }
}

// Program: Write a Java method to print characters between two characters (i.e. A to P).

// file name should be CharsBetween.java
class CharsBetween {
    static void printBetween(char from, char to) {
        for (char c = from; c <= to; c++) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        printBetween('A', 'P');
    }
}

// Program: Write a Java method to check whether a string is a valid password.

// file name should be ValidPassword.java
class ValidPassword {
    // Rules: at least 8 characters, only letters and digits, at least 2 digits
    static boolean isValid(String pwd) {
        if (pwd.length() < 8) return false;
        int digits = 0;
        for (char c : pwd.toCharArray()) {
            if (Character.isDigit(c)) digits++;
            else if (!Character.isLetter(c)) return false;
        }
        return digits >= 2;
    }
    public static void main(String[] args) {
        String[] tests = {"abc12345", "short1", "NoDigitsHere", "has space12"};
        for (String t : tests) {
            System.out.println(t + " -> " + (isValid(t) ? "valid" : "invalid"));
        }
    }
}

// Program: Write a Java method to display the current date and time.

// file name should be CurrentDateTime.java
class CurrentDateTime {
    static void showNow() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("Current date and time: " + LocalDateTime.now().format(f));
    }
    public static void main(String[] args) {
        showNow();
    }
}

// Program: Write a Java method to find all twin prime numbers less than 100. Java Programming Question Bank Page 6

// file name should be TwinPrimes.java
class TwinPrimes {
    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) if (n % i == 0) return false;
        return true;
    }
    static void printTwinPrimes(int limit) {
        for (int i = 2; i + 2 < limit; i++) {
            if (isPrime(i) && isPrime(i + 2)) System.out.println("(" + i + ", " + (i + 2) + ")");
        }
    }
    public static void main(String[] args) {
        System.out.println("Twin primes below 100:");
        printTwinPrimes(100);
    }
}

// Program: Write a Java method to count the number of digits in an integer with the value 2. The integer may be assumed to be non-negative.

// file name should be CountDigitTwo.java
class CountDigitTwo {
    static int countTwos(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 10 == 2) count++;
            n /= 10;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println("Number of 2s in 22422 = " + countTwos(22422));
        System.out.println("Number of 2s in 1357  = " + countTwos(1357));
    }
}

// Program: Write a Java method that accepts three integers and checks whether they are consecutive or not. Returns true or false.

// file name should be ConsecutiveCheck.java
class ConsecutiveCheck {
    static boolean areConsecutive(int a, int b, int c) {
        int[] x = {a, b, c};
        Arrays.sort(x);
        return x[1] - x[0] == 1 && x[2] - x[1] == 1;
    }
    public static void main(String[] args) {
        System.out.println("(5, 4, 6)  -> " + areConsecutive(5, 4, 6));
        System.out.println("(1, 3, 5)  -> " + areConsecutive(1, 3, 5));
    }
}

// Program: Write a Java method that accepts three integers and returns true if one is the middle point between the other two integers, otherwise false

// file name should be MiddlePoint.java
class MiddlePoint {
    // true if one number is exactly halfway between the other two
    static boolean hasMiddlePoint(int a, int b, int c) {
        return 2 * a == b + c || 2 * b == a + c || 2 * c == a + b;
    }
    public static void main(String[] args) {
        System.out.println("(2, 4, 6)  -> " + hasMiddlePoint(2, 4, 6));
        System.out.println("(1, 2, 9)  -> " + hasMiddlePoint(1, 2, 9));
    }
}

// Program: Write a Java method that checks whether all the characters in a given string are vowels (a, e,i,o,u) or not. Return true if each character in the string is a vowel, otherwise return false.

// file name should be AllVowels.java
class AllVowels {
    static boolean allVowels(String s) {
        if (s.isEmpty()) return false;
        for (char c : s.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) < 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println("\"aeiou\" -> " + allVowels("aeiou"));
        System.out.println("\"Java\"  -> " + allVowels("Java"));
    }
}
