package singlearray;
import java.util.*;

// Each question is its own class. Compile: javac singlearray.java   Run: java singlearray.CopyArray

// Program: Program to copy all elements of one array into another array
// file name should be CopyArray.java
class CopyArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) b[i] = a[i];
        System.out.println("Original: " + Arrays.toString(a));
        System.out.println("Copy    : " + Arrays.toString(b));
    }
}

// Program: Program to find the frequency of each element in the array
// file name should be FrequencyOfElements.java
class FrequencyOfElements {
    public static void main(String[] args) {
        int[] a = {1, 2, 8, 3, 2, 2, 2, 5, 1};
        Map<Integer, Integer> freq = new LinkedHashMap<>();
        for (int x : a) freq.merge(x, 1, Integer::sum);
        for (Map.Entry<Integer, Integer> e : freq.entrySet())
            System.out.println(e.getKey() + " occurs " + e.getValue() + " time(s)");
    }
}

// Program: Program to left rotate the elements of an array
// file name should be LeftRotate.java
class LeftRotate {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int n = 2;
        for (int r = 0; r < n; r++) {
            int first = a[0];
            for (int i = 0; i < a.length - 1; i++) a[i] = a[i + 1];
            a[a.length - 1] = first;
        }
        System.out.println("Left rotated by " + n + ": " + Arrays.toString(a));
    }
}

// Program: Program to print the duplicate elements of an array
// file name should be DuplicateElements.java
class DuplicateElements {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 2, 7, 8, 8, 3};
        System.out.print("Duplicate elements: ");
        for (int i = 0; i < a.length; i++)
            for (int j = i + 1; j < a.length; j++)
                if (a[i] == a[j]) { System.out.print(a[j] + " "); break; }
        System.out.println();
    }
}

// Program: Program to print the elements of an array
// file name should be PrintArray.java
class PrintArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        for (int x : a) System.out.print(x + " ");
        System.out.println();
    }
}

// Program: Program to print the elements of an array in reverse order
// file name should be PrintReverse.java
class PrintReverse {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        for (int i = a.length - 1; i >= 0; i--) System.out.print(a[i] + " ");
        System.out.println();
    }
}

// Program: Program to print the elements of an array present on even position
// file name should be EvenPositionElements.java
class EvenPositionElements {
    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40, 50, 60};
        // positions are counted from 1, so even positions are indexes 1, 3, 5...
        for (int i = 1; i < a.length; i += 2) System.out.print(a[i] + " ");
        System.out.println();
    }
}

// Program: Program to print the elements of an array present on odd position
// file name should be OddPositionElements.java
class OddPositionElements {
    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40, 50, 60};
        // positions are counted from 1, so odd positions are indexes 0, 2, 4...
        for (int i = 0; i < a.length; i += 2) System.out.print(a[i] + " ");
        System.out.println();
    }
}

// Program: Program to print the largest element in an array
// file name should be LargestElement.java
class LargestElement {
    public static void main(String[] args) {
        int[] a = {25, 11, 7, 75, 56};
        int max = a[0];
        for (int x : a) if (x > max) max = x;
        System.out.println("Largest = " + max);
    }
}

// Program: Program to print the smallest element in an array
// file name should be SmallestElement.java
class SmallestElement {
    public static void main(String[] args) {
        int[] a = {25, 11, 7, 75, 56};
        int min = a[0];
        for (int x : a) if (x < min) min = x;
        System.out.println("Smallest = " + min);
    }
}

// Program: Program to print the number of elements present in an array
// file name should be NumberOfElements.java
class NumberOfElements {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        System.out.println("Number of elements = " + a.length);
    }
}

// Program: Program to print the sum of all the items of the array
// file name should be SumOfItems.java
class SumOfItems {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int sum = 0;
        for (int x : a) sum += x;
        System.out.println("Sum = " + sum);
    }
}

// Program: Program to right rotate the elements of an array
// file name should be RightRotate.java
class RightRotate {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int n = 3;
        for (int r = 0; r < n; r++) {
            int last = a[a.length - 1];
            for (int i = a.length - 1; i > 0; i--) a[i] = a[i - 1];
            a[0] = last;
        }
        System.out.println("Right rotated by " + n + ": " + Arrays.toString(a));
    }
}

// Program: Program to sort the elements of an array in ascending order
// file name should be SortAscending.java
class SortAscending {
    public static void main(String[] args) {
        int[] a = {5, 2, 8, 7, 1};
        for (int i = 0; i < a.length; i++)
            for (int j = i + 1; j < a.length; j++)
                if (a[i] > a[j]) { int t = a[i]; a[i] = a[j]; a[j] = t; }
        System.out.println(Arrays.toString(a));
    }
}

// Program: Program to sort the elements of an array in descending order
// file name should be SortDescending.java
class SortDescending {
    public static void main(String[] args) {
        int[] a = {5, 2, 8, 7, 1};
        for (int i = 0; i < a.length; i++)
            for (int j = i + 1; j < a.length; j++)
                if (a[i] < a[j]) { int t = a[i]; a[i] = a[j]; a[j] = t; }
        System.out.println(Arrays.toString(a));
    }
}

// Program: Program to Find 3rd Largest Number in an array
// file name should be ThirdLargest.java
class ThirdLargest {
    public static void main(String[] args) {
        int[] a = {12, 45, 7, 89, 23, 45, 67};
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for (int x : a) set.add(x);
        if (set.size() < 3) System.out.println("Array has fewer than 3 distinct elements");
        else System.out.println("3rd largest = " + new ArrayList<>(set).get(2));
    }
}

// Program: Program to Find 2nd Largest Number in an array
// file name should be SecondLargest.java
class SecondLargest {
    public static void main(String[] args) {
        int[] a = {12, 45, 7, 89, 23, 45, 67};
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int x : a) {
            if (x > first) { second = first; first = x; }
            else if (x > second && x != first) second = x;
        }
        System.out.println("2nd largest = " + second);
    }
}

// Program: Program to Find Largest Number in an array
// file name should be LargestNumber.java
class LargestNumber {
    public static void main(String[] args) {
        int[] a = {12, 45, 7, 89, 23};
        int max = a[0];
        for (int i = 1; i < a.length; i++) if (a[i] > max) max = a[i];
        System.out.println("Largest = " + max);
    }
}

// Program: Program to Find 2nd Smallest Number in an array
// file name should be SecondSmallest.java
class SecondSmallest {
    public static void main(String[] args) {
        int[] a = {12, 45, 7, 89, 23, 7};
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int x : a) {
            if (x < first) { second = first; first = x; }
            else if (x < second && x != first) second = x;
        }
        System.out.println("2nd smallest = " + second);
    }
}

// Program: Program to Find Smallest Number in an array
// file name should be SmallestNumber.java
class SmallestNumber {
    public static void main(String[] args) {
        int[] a = {12, 45, 7, 89, 23};
        int min = a[0];
        for (int i = 1; i < a.length; i++) if (a[i] < min) min = a[i];
        System.out.println("Smallest = " + min);
    }
}
