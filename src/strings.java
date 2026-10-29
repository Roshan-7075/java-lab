package strings;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

// Each question is its own class. Compile: javac strings.java   Run: java strings.OnlyDigits

// Program: Program to Check if a String contains only digits?
// file name should be OnlyDigits.java
class OnlyDigits {
    public static void main(String[] args) {
        String[] tests = {"123456", "12a45", ""};
        for (String s : tests)
            System.out.println("\"" + s + "\" -> " + (!s.isEmpty() && s.matches("\\d+")));
    }
}

// Program: Program to perform Deep Copy for String?
// file name should be DeepCopyString.java
class DeepCopyString {
    public static void main(String[] args) {
        String original = "Java";
        String deep = new String(original); // new object in heap
        System.out.println("Same content   : " + original.equals(deep));
        System.out.println("Same reference : " + (original == deep));
    }
}

// Program: Program to prove String is immutable programmatically?
// file name should be StringImmutable.java
class StringImmutable {
    public static void main(String[] args) {
        String s = "Hello";
        String t = s;
        s.concat(" World");            // result ignored, s is unchanged
        System.out.println("After concat without assignment: " + s);
        s = s.concat(" World");        // a NEW object is created
        System.out.println("After assignment: s = " + s + ", t = " + t);
        System.out.println("s and t same object? " + (s == t));
    }
}

// Program: Program to remove all occurrences of a given character from input String?
// file name should be RemoveAllOccurrences.java
class RemoveAllOccurrences {
    public static void main(String[] args) {
        String s = "programming language";
        char c = 'g';
        System.out.println(s.replace(String.valueOf(c), ""));
    }
}

// Program: Program to append the string using StringBuffer class
// file name should be StringBufferAppend.java
class StringBufferAppend {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Hello");
        sb.append(" World").append('!').append(2024);
        System.out.println(sb);
    }
}

// Program: Program to insert the string using StringBuffer class
// file name should be StringBufferInsert.java
class StringBufferInsert {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Hello World");
        sb.insert(5, " Java");
        System.out.println(sb);
    }
}

// Program: Program to Add Characters to a String (using StringBuilder)
// file name should be AddCharsStringBuilder.java
class AddCharsStringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Jav");
        sb.append('a');
        sb.insert(0, '>');
        System.out.println(sb);
    }
}

// Program: Program to Add Characters to a String (using + and concat)
// file name should be AddCharsConcat.java
class AddCharsConcat {
    public static void main(String[] args) {
        String s = "Jav";
        s = s + 'a';
        s = s.concat("!");
        s = '>' + s;
        System.out.println(s);
    }
}

// Program: Program to Check Anagram
// file name should be CheckAnagram.java
class CheckAnagram {
    static boolean isAnagram(String a, String b) {
        a = a.replaceAll("\\s", "").toLowerCase();
        b = b.replaceAll("\\s", "").toLowerCase();
        char[] x = a.toCharArray(), y = b.toCharArray();
        Arrays.sort(x); Arrays.sort(y);
        return Arrays.equals(x, y);
    }
    public static void main(String[] args) {
        System.out.println("listen / silent -> " + isAnagram("listen", "silent"));
        System.out.println("hello / world   -> " + isAnagram("hello", "world"));
    }
}

// Program: Program to check whether a string is a Palindrome
// file name should be StringPalindrome.java
class StringPalindrome {
    public static void main(String[] args) {
        String s = "madam";
        String rev = new StringBuilder(s).reverse().toString();
        System.out.println(s + (s.equals(rev) ? " is a palindrome" : " is not a palindrome"));
    }
}

// Program: Program to Convert Enum to String
// file name should be EnumToString.java
class EnumToString {
    enum Day { MONDAY, TUESDAY, WEDNESDAY }
    public static void main(String[] args) {
        Day d = Day.TUESDAY;
        String s1 = d.toString();
        String s2 = d.name();
        String s3 = String.valueOf(d);
        System.out.println(s1 + " " + s2 + " " + s3);
    }
}

// Program: Program to Convert String to String Array
// file name should be StringToStringArray.java
class StringToStringArray {
    public static void main(String[] args) {
        String s = "Java is fun";
        String[] words = s.split(" ");
        String[] chars = s.replace(" ", "").split("");
        System.out.println(Arrays.toString(words));
        System.out.println(Arrays.toString(chars));
    }
}

// Program: Program to count number of words in a String?
// file name should be CountWordsInString.java
class CountWordsInString {
    public static void main(String[] args) {
        String s = "  Java   is a    popular language ";
        s = s.trim();
        System.out.println("Words = " + (s.isEmpty() ? 0 : s.split("\\s+").length));
    }
}

// Program: Program to count the total number of characters in a string
// file name should be CountCharacters.java
class CountCharacters {
    public static void main(String[] args) {
        String s = "Hello World";
        int count = 0;
        for (int i = 0; i < s.length(); i++) if (s.charAt(i) != ' ') count++;
        System.out.println("Characters (excluding spaces) = " + count);
        System.out.println("Characters (including spaces) = " + s.length());
    }
}

// Program: Program to count the total number of punctuation characters exists in a String
// file name should be CountPunctuation.java
class CountPunctuation {
    public static void main(String[] args) {
        String s = "Hello, World! How's it going? Fine; thanks.";
        String punct = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
        int count = 0;
        for (char c : s.toCharArray()) if (punct.indexOf(c) >= 0) count++;
        System.out.println("Punctuation characters = " + count);
    }
}

// Program: Program to count the total number of vowels and consonants in a string
// file name should be VowelsConsonants.java
class VowelsConsonants {
    public static void main(String[] args) {
        String s = "Programming Language";
        int v = 0, c = 0;
        for (char ch : s.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(ch) >= 0) v++;
            else if (ch >= 'a' && ch <= 'z') c++;
        }
        System.out.println("Vowels = " + v + ", Consonants = " + c);
    }
}

// Program: Program to determine whether a given string is palindrome
// file name should be PalindromeTwoPointer.java
class PalindromeTwoPointer {
    public static void main(String[] args) {
        String s = "A man a plan a canal Panama";
        String t = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        boolean ok = true;
        for (int i = 0, j = t.length() - 1; i < j; i++, j--)
            if (t.charAt(i) != t.charAt(j)) { ok = false; break; }
        System.out.println("\"" + s + "\" is " + (ok ? "" : "not ") + "a palindrome");
    }
}

// Program: Program to determine whether one string is a rotation of another
// file name should be StringRotation.java
class StringRotation {
    public static void main(String[] args) {
        String a = "abcde", b = "cdeab";
        boolean rotation = a.length() == b.length() && (a + a).contains(b);
        System.out.println(b + " is " + (rotation ? "" : "not ") + "a rotation of " + a);
    }
}

// Program: Program to divide a string in 'N' equal parts.
// file name should be DivideStringNParts.java
class DivideStringNParts {
    public static void main(String[] args) {
        String s = "aaaabbbbcccc";
        int n = 3;
        if (s.length() % n != 0) { System.out.println("Cannot divide string into " + n + " equal parts"); return; }
        int size = s.length() / n;
        for (int i = 0; i < s.length(); i += size) System.out.println(s.substring(i, i + size));
    }
}

// Program: Program to find all subsets of a string
// file name should be AllSubsets.java
class AllSubsets {
    public static void main(String[] args) {
        String s = "abc";
        int n = s.length();
        for (int mask = 0; mask < (1 << n); mask++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) if ((mask & (1 << i)) != 0) sb.append(s.charAt(i));
            System.out.println("{" + sb + "}");
        }
    }
}

// Program: Program to find all the permutations of a string
// file name should be Permutations.java
class Permutations {
    static void permute(String prefix, String rest) {
        if (rest.isEmpty()) { System.out.println(prefix); return; }
        for (int i = 0; i < rest.length(); i++)
            permute(prefix + rest.charAt(i), rest.substring(0, i) + rest.substring(i + 1));
    }
    public static void main(String[] args) {
        permute("", "abc");
    }
}

// Program: Program to find maximum and minimum occurring character in a string
// file name should be MaxMinOccurringChar.java
class MaxMinOccurringChar {
    public static void main(String[] args) {
        String s = "grass is greener";
        int[] freq = new int[256];
        for (char c : s.toCharArray()) if (c != ' ') freq[c]++;
        int max = 0, min = Integer.MAX_VALUE;
        char maxCh = 0, minCh = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] == 0) continue;
            if (freq[i] > max) { max = freq[i]; maxCh = (char) i; }
            if (freq[i] < min) { min = freq[i]; minCh = (char) i; }
        }
        System.out.println("Maximum occurring: '" + maxCh + "' (" + max + " times)");
        System.out.println("Minimum occurring: '" + minCh + "' (" + min + " time)");
    }
}

// Program: Program to find Reverse of the string
// file name should be ReverseOfString.java
class ReverseOfString {
    public static void main(String[] args) {
        String s = "Programming";
        System.out.println(new StringBuilder(s).reverse());
    }
}

// Program: Program to find the duplicate characters in a string
// file name should be DuplicateChars.java
class DuplicateChars {
    public static void main(String[] args) {
        String s = "Great responsibility";
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toLowerCase().toCharArray()) if (c != ' ') map.merge(c, 1, Integer::sum);
        for (Map.Entry<Character, Integer> e : map.entrySet())
            if (e.getValue() > 1) System.out.println(e.getKey() + " -> " + e.getValue());
    }
}

// Program: Program to find the duplicate words in a string
// file name should be DuplicateWords.java
class DuplicateWords {
    public static void main(String[] args) {
        String s = "Big black bug bit a big black dog on his big black nose";
        Map<String, Integer> map = new LinkedHashMap<>();
        for (String w : s.toLowerCase().split("\\s+")) map.merge(w, 1, Integer::sum);
        for (Map.Entry<String, Integer> e : map.entrySet())
            if (e.getValue() > 1) System.out.println(e.getKey() + " -> " + e.getValue());
    }
}

// Program: Program to find the frequency of characters
// file name should be CharFrequency.java
class CharFrequency {
    public static void main(String[] args) {
        String s = "picture perfect";
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) if (c != ' ') map.merge(c, 1, Integer::sum);
        System.out.println(map);
    }
}

// Program: Program to find the largest and smallest word in a string
// file name should be LargestSmallestWord.java
class LargestSmallestWord {
    public static void main(String[] args) {
        String s = "We are learning Java programming";
        String largest = "", smallest = null;
        for (String w : s.split("\\s+")) {
            if (w.length() > largest.length()) largest = w;
            if (smallest == null || w.length() < smallest.length()) smallest = w;
        }
        System.out.println("Largest word : " + largest);
        System.out.println("Smallest word: " + smallest);
    }
}

// Program: Program to find the longest repeating sequence in a string
// file name should be LongestRepeatingSequence.java
class LongestRepeatingSequence {
    public static void main(String[] args) {
        String s = "acbdfghybdf";
        int n = s.length();
        String best = "";
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                int k = 0;
                // non-overlapping repeat: first copy must end before second begins
                while (j + k < n && i + k < j && s.charAt(i + k) == s.charAt(j + k)) k++;
                if (k > best.length()) best = s.substring(i, i + k);
            }
        System.out.println("Longest repeating sequence: " + (best.isEmpty() ? "none" : best));
    }
}

// Program: Program to find the most repeated word in a text file
// file name should be MostRepeatedWordInFile.java
class MostRepeatedWordInFile {
    public static void main(String[] args) throws IOException {
        Path p = Paths.get("textfile.txt");
        if (!Files.exists(p)) Files.write(p, "the cat and the dog and the bird\nthe end".getBytes());
        Map<String, Integer> map = new HashMap<>();
        for (String line : Files.readAllLines(p))
            for (String w : line.toLowerCase().split("\\W+"))
                if (!w.isEmpty()) map.merge(w, 1, Integer::sum);
        String best = null;
        for (Map.Entry<String, Integer> e : map.entrySet())
            if (best == null || e.getValue() > map.get(best)) best = e.getKey();
        System.out.println("Most repeated word: " + best + " (" + map.get(best) + " times)");
    }
}

// Program: Program to find the number of the words in the given text file
// file name should be WordsInTextFile.java
class WordsInTextFile {
    public static void main(String[] args) throws IOException {
        Path p = Paths.get("textfile.txt");
        if (!Files.exists(p)) Files.write(p, "the cat and the dog and the bird\nthe end".getBytes());
        int count = 0;
        for (String line : Files.readAllLines(p)) {
            line = line.trim();
            if (!line.isEmpty()) count += line.split("\\s+").length;
        }
        System.out.println("Number of words in file = " + count);
    }
}

// Program: Program to Get a Character From the Given String
// file name should be GetCharacter.java
class GetCharacter {
    public static void main(String[] args) {
        String s = "Hello Java";
        System.out.println("Character at index 4 = " + s.charAt(4));
        System.out.println("Last character       = " + s.charAt(s.length() - 1));
    }
}

// Program: Program to Insert a string into another string
// file name should be InsertStringIntoString.java
class InsertStringIntoString {
    public static void main(String[] args) {
        String a = "Hello World";
        String b = "Beautiful ";
        int pos = 6;
        String result = a.substring(0, pos) + b + a.substring(pos);
        System.out.println(result);
    }
}

// Program: Program to Iterate Over Characters in String
// file name should be IterateOverChars.java
class IterateOverChars {
    public static void main(String[] args) {
        String s = "Java";
        for (int i = 0; i < s.length(); i++) System.out.println("s[" + i + "] = " + s.charAt(i));
        for (char c : s.toCharArray()) System.out.print(c + "-");
        System.out.println();
    }
}

// Program: Program to Print a New Line in String
// file name should be NewLineInString.java
class NewLineInString {
    public static void main(String[] args) {
        String s = "Hello\nWorld";
        System.out.println(s);
        System.out.println("Using System.lineSeparator():" + System.lineSeparator() + "Next line");
        System.out.printf("Using printf:%nNext line%n");
    }
}

// Program: Program to Print even length words
// file name should be EvenLengthWords.java
class EvenLengthWords {
    public static void main(String[] args) {
        String s = "This is a sample java program";
        for (String w : s.split("\\s+")) if (w.length() % 2 == 0) System.out.println(w);
    }
}

// Program: Program to print smallest and biggest possible palindrome word in a given string
// file name should be SmallestBiggestPalindromeWord.java
class SmallestBiggestPalindromeWord {
    public static void main(String[] args) {
        String s = "Madam shows a level of radar and noon in civic duty";
        String small = null, big = null;
        for (String w : s.toLowerCase().split("\\s+")) {
            if (!new StringBuilder(w).reverse().toString().equals(w)) continue;
            if (small == null || w.length() < small.length()) small = w;
            if (big == null || w.length() > big.length()) big = w;
        }
        if (small == null) System.out.println("No palindrome word found");
        else { System.out.println("Smallest palindrome word: " + small); System.out.println("Biggest palindrome word : " + big); }
    }
}

// Program: Program to remove all the white spaces from a string
// file name should be RemoveWhiteSpaces.java
class RemoveWhiteSpaces {
    public static void main(String[] args) {
        String s = "  Java  is   fun \t ";
        System.out.println(s.replaceAll("\\s", ""));
    }
}

// Program: Program to replace lower-case characters with upper-case and vice-versa
// file name should be SwapCase.java
class SwapCase {
    public static void main(String[] args) {
        String s = "Java Programming 101";
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) sb.append(Character.toLowerCase(c));
            else if (Character.isLowerCase(c)) sb.append(Character.toUpperCase(c));
            else sb.append(c);
        }
        System.out.println(sb);
    }
}

// Program: Program to replace the spaces of a string with a specific character
// file name should be ReplaceSpaces.java
class ReplaceSpaces {
    public static void main(String[] args) {
        String s = "Java is very easy";
        System.out.println(s.replace(' ', '_'));
    }
}

// Program: Program to separate the Individual Characters from a String
// file name should be SeparateCharacters.java
class SeparateCharacters {
    public static void main(String[] args) {
        String s = "Hello";
        for (char c : s.toCharArray()) System.out.print(c + " ");
        System.out.println();
    }
}

// Program: Program to Splitting into a number of sub-strings
// file name should be SplitIntoSubstrings.java
class SplitIntoSubstrings {
    public static void main(String[] args) {
        String s = "apple,banana,cherry,date";
        String[] parts = s.split(",");
        System.out.println("Number of sub-strings: " + parts.length);
        for (String p : parts) System.out.println(p);
        String[] limited = s.split(",", 2);
        System.out.println("With limit 2: " + Arrays.toString(limited));
    }
}

// Program: Program to swap two string variables without using third or temp variable.
// file name should be SwapStringsNoTemp.java
class SwapStringsNoTemp {
    public static void main(String[] args) {
        String a = "Hello", b = "World";
        System.out.println("Before: a=" + a + ", b=" + b);
        a = a + b;
        b = a.substring(0, a.length() - b.length());
        a = a.substring(b.length());
        System.out.println("After : a=" + a + ", b=" + b);
    }
}

// Program: Program to Swapping Pair of Characters
// file name should be SwapPairOfChars.java
class SwapPairOfChars {
    public static void main(String[] args) {
        String s = "abcdefg";
        char[] c = s.toCharArray();
        for (int i = 0; i + 1 < c.length; i += 2) { char t = c[i]; c[i] = c[i + 1]; c[i + 1] = t; }
        System.out.println(new String(c));
    }
}

// Program: Read two String user input and check if first contains second?
// file name should be ContainsSecond.java
class ContainsSecond {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string : ");
        String a = sc.nextLine();
        System.out.print("Enter second string: ");
        String b = sc.nextLine();
        System.out.println(a.contains(b) ? "First string contains the second" : "First string does not contain the second");
    }
}

// Program: Reserve String without reverse() function
// file name should be ReverseWithoutReverse.java
class ReverseWithoutReverse {
    public static void main(String[] args) {
        String s = "Programming";
        String rev = "";
        for (int i = s.length() - 1; i >= 0; i--) rev += s.charAt(i);
        System.out.println(rev);
    }
}

// Program: Reverse String Word by Word
// file name should be ReverseWordByWord.java
class ReverseWordByWord {
    public static void main(String[] args) {
        String s = "Java is a great language";
        String[] w = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = w.length - 1; i >= 0; i--) sb.append(w[i]).append(i > 0 ? " " : "");
        System.out.println(sb);
    }
}

// Program: Write a program to check if two Strings are created with same characters?
// file name should be SameCharacters.java
class SameCharacters {
    static boolean sameChars(String a, String b) {
        Set<Character> x = new HashSet<>(), y = new HashSet<>();
        for (char c : a.toCharArray()) x.add(c);
        for (char c : b.toCharArray()) y.add(c);
        return x.equals(y);
    }
    public static void main(String[] args) {
        System.out.println("\"abcd\" & \"dcbaabcd\" -> " + sameChars("abcd", "dcbaabcd"));
        System.out.println("\"abcd\" & \"abce\"     -> " + sameChars("abcd", "abce"));
    }
}

// Program: Write a program to find out first non repeated character from input String?
// file name should be FirstNonRepeated.java
class FirstNonRepeated {
    public static void main(String[] args) {
        String s = "swiss cheese";
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) map.merge(c, 1, Integer::sum);
        for (Map.Entry<Character, Integer> e : map.entrySet())
            if (e.getValue() == 1) { System.out.println("First non repeated character: " + e.getKey()); return; }
        System.out.println("No non repeated character");
    }
}

// Program: Create an object StringBuffer class to reverse the string.
// file name should be StringBufferReverse.java
class StringBufferReverse {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Hello World");
        sb.reverse();
        System.out.println(sb);
    }
}

// Program: Create an object StringBuffer class to show functionality of insert, append, delete and replace functions.
// file name should be StringBufferFunctions.java
class StringBufferFunctions {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Hello");
        sb.append(" World");
        System.out.println("append  : " + sb);
        sb.insert(5, ",");
        System.out.println("insert  : " + sb);
        sb.delete(5, 6);
        System.out.println("delete  : " + sb);
        sb.replace(6, 11, "Java");
        System.out.println("replace : " + sb);
    }
}
