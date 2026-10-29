package basic;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

// Each question is its own class. Every class has a main() so it can be run separately.
// Compile: javac basic.java   Run: java basic.HelloWorld

// Program: Write a Java program to print 'Hello World!' on screen
// file name should be HelloWorld.java
class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

// Program: Write a Java program to print the sum of two numbers
// file name should be SumOfTwo.java
class SumOfTwo {
    public static void main(String[] args) {
        int a = 15, b = 27;
        System.out.println("Sum = " + (a + b));
    }
}

// Program: Write a Java program that takes two numbers and display the product of two numbers
// file name should be ProductOfTwo.java
class ProductOfTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two numbers: ");
        double a = sc.nextDouble(), b = sc.nextDouble();
        System.out.println("Product = " + (a * b));
    }
}

// Program: Write a Java program to print the sum, multiply, subtract, divide and remainder of two numbers
// file name should be ArithmeticOps.java
class ArithmeticOps {
    public static void main(String[] args) {
        int a = 20, b = 6;
        System.out.println("Sum       = " + (a + b));
        System.out.println("Multiply  = " + (a * b));
        System.out.println("Subtract  = " + (a - b));
        System.out.println("Divide    = " + ((double) a / b));
        System.out.println("Remainder = " + (a % b));
    }
}

// Program: Write a Java program that takes five numbers as input to calculate and print the average of the numbers
// file name should be AverageOfFive.java
class AverageOfFive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double sum = 0;
        System.out.println("Enter five numbers:");
        for (int i = 0; i < 5; i++) sum += sc.nextDouble();
        System.out.println("Average = " + sum / 5);
    }
}

// Program: Write a Java program to swap two variables
// file name should be SwapVariables.java
class SwapVariables {
    public static void main(String[] args) {
        int a = 10, b = 25;
        System.out.println("Before: a=" + a + " b=" + b);
        int temp = a; a = b; b = temp;
        System.out.println("After : a=" + a + " b=" + b);
    }
}

// Program: Write a Java program to convert a decimal number to binary numbers
// file name should be DecimalToBinary.java
class DecimalToBinary {
    public static void main(String[] args) {
        int n = 45;
        int num = n;
        StringBuilder sb = new StringBuilder();
        if (num == 0) sb.append(0);
        while (num > 0) { sb.insert(0, num % 2); num /= 2; }
        System.out.println(n + " in binary = " + sb);
    }
}

// Program: Write a Java program to convert a binary number to decimal number
// file name should be BinaryToDecimal.java
class BinaryToDecimal {
    public static void main(String[] args) {
        String bin = "101101";
        int dec = 0;
        for (char c : bin.toCharArray()) dec = dec * 2 + (c - '0');
        System.out.println(bin + " in decimal = " + dec);
    }
}

// Program: Write a Java program to check whether Java is installed on your computer or not
// file name should be CheckJavaInstalled.java
class CheckJavaInstalled {
    public static void main(String[] args) {
        // If this program runs, Java is installed.
        System.out.println("Java is installed.");
        System.out.println("Version : " + System.getProperty("java.version"));
        System.out.println("Vendor  : " + System.getProperty("java.vendor"));
        System.out.println("Home    : " + System.getProperty("java.home"));
    }
}

// Program: Write a Java program and compute the sum of the digits of an integer
// file name should be SumOfDigits.java
class SumOfDigits {
    public static void main(String[] args) {
        int n = 9876, sum = 0, t = n;
        while (t > 0) { sum += t % 10; t /= 10; }
        System.out.println("Sum of digits of " + n + " = " + sum);
    }
}

// Program: Write a Java program to compare two numbers
// file name should be CompareTwoNumbers.java
class CompareTwoNumbers {
    public static void main(String[] args) {
        int a = 40, b = 25;
        if (a > b) System.out.println(a + " is greater than " + b);
        else if (a < b) System.out.println(a + " is less than " + b);
        else System.out.println(a + " is equal to " + b);
    }
}

// Program: Write a Java program to count the letters, spaces, numbers and other characters of an input string
// file name should be CountCharTypes.java
class CountCharTypes {
    public static void main(String[] args) {
        String s = "Java 17 is great! #2024";
        int letters = 0, spaces = 0, numbers = 0, others = 0;
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) letters++;
            else if (c == ' ') spaces++;
            else if (Character.isDigit(c)) numbers++;
            else others++;
        }
        System.out.println("Letters=" + letters + " Spaces=" + spaces + " Numbers=" + numbers + " Others=" + others);
    }
}

// Program: Write a Java program to print the ascii value of a given character
// file name should be AsciiValue.java
class AsciiValue {
    public static void main(String[] args) {
        char ch = 'A';
        System.out.println("ASCII value of '" + ch + "' = " + (int) ch);
    }
}

// Program: Write a Java program that accepts an integer (n) and computes the value of n+nn+nnn
// file name should be NPlusNNPlusNNN.java
class NPlusNNPlusNNN {
    public static void main(String[] args) {
        int n = 5;
        String s = String.valueOf(n);
        int result = n + Integer.parseInt(s + s) + Integer.parseInt(s + s + s);
        System.out.println(n + " + " + s + s + " + " + s + s + s + " = " + result);
    }
}

// Program: Write a Java program to display the system time
// file name should be SystemTime.java
class SystemTime {
    public static void main(String[] args) {
        System.out.println("System time: " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }
}

// Program: Write a Java program to print the odd numbers from 1 to 20
// file name should be OddNumbers.java
class OddNumbers {
    public static void main(String[] args) {
        for (int i = 1; i <= 20; i += 2) System.out.print(i + " ");
        System.out.println();
    }
}

// Program: Write a Java program to print the even numbers from 1 to 20
// file name should be EvenNumbers.java
class EvenNumbers {
    public static void main(String[] args) {
        for (int i = 2; i <= 20; i += 2) System.out.print(i + " ");
        System.out.println();
    }
}

// Program: Write a Java program to convert a string to an integer
// file name should be StringToInt.java
class StringToInt {
    public static void main(String[] args) {
        String s = "2468";
        int n = Integer.parseInt(s);
        System.out.println("Integer value + 1 = " + (n + 1));
    }
}

// Program: Write a Java program to convert seconds to hour, minute and seconds
// file name should be SecondsToHMS.java
class SecondsToHMS {
    public static void main(String[] args) {
        int total = 7384;
        int h = total / 3600, m = (total % 3600) / 60, s = total % 60;
        System.out.println(total + " seconds = " + h + " hour(s), " + m + " minute(s), " + s + " second(s)");
    }
}

// Program: Write a Java program to compute the sum of the first 100 prime numbers
// file name should be SumFirst100Primes.java
class SumFirst100Primes {
    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) if (n % i == 0) return false;
        return true;
    }
    public static void main(String[] args) {
        int count = 0, num = 2;
        long sum = 0;
        while (count < 100) {
            if (isPrime(num)) { sum += num; count++; }
            num++;
        }
        System.out.println("Sum of first 100 primes = " + sum);
    }
}

// Program: Write a Java program to swap the first and last elements of an array and create a new array
// file name should be SwapFirstLast.java
class SwapFirstLast {
    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40, 50};
        int[] b = a.clone();
        int t = b[0]; b[0] = b[b.length - 1]; b[b.length - 1] = t;
        System.out.println("Original: " + Arrays.toString(a));
        System.out.println("New     : " + Arrays.toString(b));
    }
}

// Program: Write a Java program to count the number of even and odd elements in a given array
// file name should be CountEvenOdd.java
class CountEvenOdd {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        int even = 0, odd = 0;
        for (int x : a) { if (x % 2 == 0) even++; else odd++; }
        System.out.println("Even = " + even + ", Odd = " + odd);
    }
}

// Program: Write a Java program to compute the square root of an given integer
// file name should be SquareRoot.java
class SquareRoot {
    public static void main(String[] args) {
        int n = 144;
        System.out.println("Square root of " + n + " = " + Math.sqrt(n));
    }
}

// Program: Write a Java program to check if a positive number is a palindrome or not
// file name should be PalindromeNumber.java
class PalindromeNumber {
    public static void main(String[] args) {
        int n = 12321, rev = 0, t = n;
        while (t > 0) { rev = rev * 10 + t % 10; t /= 10; }
        System.out.println(n + (rev == n ? " is a palindrome" : " is not a palindrome"));
    }
}

// Program: Write a Java program to add two numbers without using any arithmetic operators
// file name should be AddWithoutArithmetic.java
class AddWithoutArithmetic {
    static int add(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
    public static void main(String[] args) {
        System.out.println("15 + 27 = " + add(15, 27));
    }
}

// Program: Write a Java program to add all the digits of a given positive integer
// file name should be AddDigits.java
class AddDigits {
    public static void main(String[] args) {
        int n = 50432, sum = 0;
        for (char c : String.valueOf(n).toCharArray()) sum += c - '0';
        System.out.println("Sum of digits of " + n + " = " + sum);
    }
}

// Program: Java program to find area of circle
// file name should be AreaOfCircle.java
class AreaOfCircle {
    public static void main(String[] args) {
        double r = 7;
        System.out.printf("Area of circle = %.2f%n", Math.PI * r * r);
    }
}

// Program: Java Program to find area of rectangle
// file name should be AreaOfRectangle.java
class AreaOfRectangle {
    public static void main(String[] args) {
        double l = 12, w = 5;
        System.out.println("Area of rectangle = " + l * w);
    }
}

// Program: Java Program to find area of triangle
// file name should be AreaOfTriangle.java
class AreaOfTriangle {
    public static void main(String[] args) {
        double b = 10, h = 6;
        System.out.println("Area of triangle = " + 0.5 * b * h);
    }
}

// Program: Java Program to find area of equilateral triangle
// file name should be AreaOfEquilateralTriangle.java
class AreaOfEquilateralTriangle {
    public static void main(String[] args) {
        double a = 8;
        System.out.printf("Area of equilateral triangle = %.2f%n", Math.sqrt(3) / 4 * a * a);
    }
}

// Program: Java Program to find area of rhombus
// file name should be AreaOfRhombus.java
class AreaOfRhombus {
    public static void main(String[] args) {
        double d1 = 10, d2 = 7;
        System.out.println("Area of rhombus = " + 0.5 * d1 * d2);
    }
}

// Program: Java Program to find area of parallelogram
// file name should be AreaOfParallelogram.java
class AreaOfParallelogram {
    public static void main(String[] args) {
        double base = 9, height = 4;
        System.out.println("Area of parallelogram = " + base * height);
    }
}

// Program: Java Program to find area of Prism (total surface area of a rectangular prism)
// file name should be AreaOfPrism.java
class AreaOfPrism {
    public static void main(String[] args) {
        double l = 5, w = 3, h = 4;
        System.out.println("Surface area of prism = " + 2 * (l * w + w * h + h * l));
    }
}

// Program: Java Program to find volume of sphere
// file name should be VolumeOfSphere.java
class VolumeOfSphere {
    public static void main(String[] args) {
        double r = 5;
        System.out.printf("Volume of sphere = %.2f%n", 4.0 / 3 * Math.PI * Math.pow(r, 3));
    }
}

// Program: Java Program to find volume of cylinder
// file name should be VolumeOfCylinder.java
class VolumeOfCylinder {
    public static void main(String[] args) {
        double r = 3, h = 10;
        System.out.printf("Volume of cylinder = %.2f%n", Math.PI * r * r * h);
    }
}

// Program: Java Program to find volume of cuboid
// file name should be VolumeOfCuboid.java
class VolumeOfCuboid {
    public static void main(String[] args) {
        double l = 6, w = 4, h = 3;
        System.out.println("Volume of cuboid = " + l * w * h);
    }
}

// Program: Java Program to find volume of cone
// file name should be VolumeOfCone.java
class VolumeOfCone {
    public static void main(String[] args) {
        double r = 3, h = 7;
        System.out.printf("Volume of cone = %.2f%n", Math.PI * r * r * h / 3);
    }
}

// Program: Java program to find surface area of cuboid
// file name should be SurfaceAreaCuboid.java
class SurfaceAreaCuboid {
    public static void main(String[] args) {
        double l = 6, w = 4, h = 3;
        System.out.println("Surface area of cuboid = " + 2 * (l * w + w * h + l * h));
    }
}

// Program: Java program to find surface area of cylinder
// file name should be SurfaceAreaCylinder.java
class SurfaceAreaCylinder {
    public static void main(String[] args) {
        double r = 3, h = 10;
        System.out.printf("Surface area of cylinder = %.2f%n", 2 * Math.PI * r * (r + h));
    }
}

// Program: Java program to find surface area of cube
// file name should be SurfaceAreaCube.java
class SurfaceAreaCube {
    public static void main(String[] args) {
        double a = 4;
        System.out.println("Surface area of cube = " + 6 * a * a);
    }
}

// Program: Java program to calculate average marks
// file name should be AverageMarks.java
class AverageMarks {
    public static void main(String[] args) {
        int[] marks = {78, 85, 92, 66, 74};
        int total = 0;
        for (int m : marks) total += m;
        System.out.println("Total = " + total + ", Average = " + (double) total / marks.length);
    }
}

// Program: Java program to check vowel or consonant
// file name should be VowelOrConsonant.java
class VowelOrConsonant {
    public static void main(String[] args) {
        char ch = 'e';
        char c = Character.toLowerCase(ch);
        if (!Character.isLetter(c)) System.out.println(ch + " is not an alphabet");
        else if ("aeiou".indexOf(c) >= 0) System.out.println(ch + " is a vowel");
        else System.out.println(ch + " is a consonant");
    }
}

// Program: Java program to sum of N numbers
// file name should be SumOfNNumbers.java
class SumOfNNumbers {
    public static void main(String[] args) {
        int n = 10, sum = 0;
        for (int i = 1; i <= n; i++) sum += i;
        System.out.println("Sum of first " + n + " numbers = " + sum);
    }
}

// Program: Java program to find factorial of any number
// file name should be Factorial.java
class Factorial {
    public static void main(String[] args) {
        int n = 10;
        long fact = 1;
        for (int i = 2; i <= n; i++) fact *= i;
        System.out.println(n + "! = " + fact);
    }
}

// Program: Java Program to calculate electricity bill
// file name should be ElectricityBill.java
class ElectricityBill {
    public static void main(String[] args) {
        int units = 350;
        double bill;
        if (units <= 100) bill = units * 1.5;
        else if (units <= 200) bill = 100 * 1.5 + (units - 100) * 2.5;
        else if (units <= 300) bill = 100 * 1.5 + 100 * 2.5 + (units - 200) * 4;
        else bill = 100 * 1.5 + 100 * 2.5 + 100 * 4 + (units - 300) * 6;
        System.out.println("Units = " + units + ", Bill = " + bill);
    }
}

// Program: Java Program To Calculate CGPA Percentage
// file name should be CgpaPercentage.java
class CgpaPercentage {
    public static void main(String[] args) {
        double cgpa = 8.4;
        System.out.printf("Percentage = %.2f%%%n", cgpa * 9.5);
    }
}

// Program: Java program to calculate compound interest
// file name should be CompoundInterest.java
class CompoundInterest {
    public static void main(String[] args) {
        double p = 10000, r = 7.5, t = 3;
        double amount = p * Math.pow(1 + r / 100, t);
        System.out.printf("Compound interest = %.2f (Amount = %.2f)%n", amount - p, amount);
    }
}

// Program: Java Program To Calculate Batting Average
// file name should be BattingAverage.java
class BattingAverage {
    public static void main(String[] args) {
        int runs = 2500, innings = 60, notOuts = 8;
        System.out.printf("Batting average = %.2f%n", (double) runs / (innings - notOuts));
    }
}

// Program: Java Program to Calculate Commission Percentage
// file name should be CommissionPercentage.java
class CommissionPercentage {
    public static void main(String[] args) {
        double sales = 50000, rate = 5;
        double commission = sales * rate / 100;
        System.out.println("Commission = " + commission);
        System.out.println("Commission percentage = " + (commission / sales * 100) + "%");
    }
}

// Program: Java Program To Find Distance Between Two Points
// file name should be DistanceBetweenPoints.java
class DistanceBetweenPoints {
    public static void main(String[] args) {
        double x1 = 1, y1 = 2, x2 = 4, y2 = 6;
        double d = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        System.out.println("Distance = " + d);
    }
}

// Program: Java Program To Calculate Power Of Number
// file name should be PowerOfNumber.java
class PowerOfNumber {
    public static void main(String[] args) {
        int base = 3, exp = 5;
        long result = 1;
        for (int i = 0; i < exp; i++) result *= base;
        System.out.println(base + "^" + exp + " = " + result + " (Math.pow: " + Math.pow(base, exp) + ")");
    }
}

// Program: Write a Java program to take three numbers from the user and print the greatest number
// file name should be GreatestOfThree.java
class GreatestOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter three numbers: ");
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
        int max = (a > b) ? (a > c ? a : c) : (b > c ? b : c);
        System.out.println("Greatest = " + max);
    }
}

// Program: Write a Java program to find the number of days in a month
// file name should be DaysInMonth.java
class DaysInMonth {
    public static void main(String[] args) {
        int month = 2, year = 2024, days;
        switch (month) {
            case 4: case 6: case 9: case 11: days = 30; break;
            case 2: days = ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ? 29 : 28; break;
            default: days = 31;
        }
        System.out.println("Month " + month + " of " + year + " has " + days + " days");
    }
}

// Program: Write a Java program to test a number is positive or negative
// file name should be PositiveOrNegative.java
class PositiveOrNegative {
    public static void main(String[] args) {
        int n = -12;
        System.out.println(n + (n >= 0 ? " is positive" : " is negative"));
    }
}

// Program: Write a Java Program to accept number of week's day (1-7) and print name of the day
// file name should be WeekDayName.java
class WeekDayName {
    public static void main(String[] args) {
        int d = 4;
        String name;
        switch (d) {
            case 1: name = "Monday"; break;
            case 2: name = "Tuesday"; break;
            case 3: name = "Wednesday"; break;
            case 4: name = "Thursday"; break;
            case 5: name = "Friday"; break;
            case 6: name = "Saturday"; break;
            case 7: name = "Sunday"; break;
            default: name = "Invalid day number";
        }
        System.out.println("Day " + d + " = " + name);
    }
}

// Program: Write a Java program that takes a year from user and print whether that year is a leap year or not
// file name should be LeapYear.java
class LeapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter year: ");
        int y = sc.nextInt();
        boolean leap = (y % 4 == 0 && y % 100 != 0) || y % 400 == 0;
        System.out.println(y + (leap ? " is a leap year" : " is not a leap year"));
    }
}

// Program: Write a Java program to input 5 numbers from keyboard and find their sum and average
// file name should be SumAverageFive.java
class SumAverageFive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double sum = 0;
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < 5; i++) sum += sc.nextDouble();
        System.out.println("Sum = " + sum + ", Average = " + sum / 5);
    }
}

// Program: Write a program in Java to display the first 5 natural numbers
// file name should be First5Natural.java
class First5Natural {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) System.out.print(i + " ");
        System.out.println();
    }
}

// Program: Write a java program to check vowel or consonant
// file name should be VowelConsonantSwitch.java
class VowelConsonantSwitch {
    public static void main(String[] args) {
        char ch = 'K';
        switch (Character.toLowerCase(ch)) {
            case 'a': case 'e': case 'i': case 'o': case 'u':
                System.out.println(ch + " is a vowel"); break;
            default:
                System.out.println(Character.isLetter(ch) ? ch + " is a consonant" : ch + " is not an alphabet");
        }
    }
}

// Program: Write a Java program to display the cube of the number upto given an integer
// file name should be CubeUptoN.java
class CubeUptoN {
    public static void main(String[] args) {
        int n = 6;
        for (int i = 1; i <= n; i++) System.out.println("Cube of " + i + " = " + i * i * i);
    }
}

// Program: Write a Java program to display the n terms of odd natural number and their sum
// file name should be OddTermsAndSum.java
class OddTermsAndSum {
    public static void main(String[] args) {
        int n = 7, sum = 0;
        System.out.print("First " + n + " odd numbers: ");
        for (int i = 1; i <= n; i++) {
            int odd = 2 * i - 1;
            System.out.print(odd + " ");
            sum += odd;
        }
        System.out.println("\nSum = " + sum);
    }
}

// Program: Write a Java program to display the multiplication table of a given integer
// file name should be MultiplicationTable.java
class MultiplicationTable {
    public static void main(String[] args) {
        int n = 7;
        for (int i = 1; i <= 10; i++) System.out.println(n + " x " + i + " = " + n * i);
    }
}

// Program: Write a Java program that reads an integer and check whether it is negative, zero, or positive
// file name should be NegativeZeroPositive.java
class NegativeZeroPositive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = sc.nextInt();
        if (n < 0) System.out.println("Negative");
        else if (n == 0) System.out.println("Zero");
        else System.out.println("Positive");
    }
}

// Program: Write a Java program that reads an positive integer and count the number of digits
// file name should be CountDigits.java
class CountDigits {
    public static void main(String[] args) {
        int n = 987654, count = 0, t = n;
        if (t == 0) count = 1;
        while (t > 0) { count++; t /= 10; }
        System.out.println("Number of digits in " + n + " = " + count);
    }
}

// Program: Write a Java program that accepts three numbers and check All numbers are equal or not
// file name should be AllEqual.java
class AllEqual {
    public static void main(String[] args) {
        int a = 5, b = 5, c = 5;
        System.out.println((a == b && b == c) ? "All numbers are equal" : "Numbers are not all equal");
    }
}

// Program: Write a java program that accepts three numbers from the user and check if numbers are in "increasing" or "decreasing" order.
// file name should be IncreasingDecreasing.java
class IncreasingDecreasing {
    public static void main(String[] args) {
        int a = 3, b = 7, c = 12;
        if (a < b && b < c) System.out.println("Increasing order");
        else if (a > b && b > c) System.out.println("Decreasing order");
        else System.out.println("Neither increasing nor decreasing");
    }
}

// Program: Write a Java program that determines a student's grade
// file name should be StudentGrade.java
class StudentGrade {
    public static void main(String[] args) {
        int marks = 83;
        char grade;
        if (marks >= 90) grade = 'A';
        else if (marks >= 80) grade = 'B';
        else if (marks >= 70) grade = 'C';
        else if (marks >= 60) grade = 'D';
        else if (marks >= 40) grade = 'E';
        else grade = 'F';
        System.out.println("Marks = " + marks + ", Grade = " + grade);
    }
}

// Program: Write a Java program to create a simple calculator
// file name should be SimpleCalculator.java
class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number, operator (+ - * / %), second number: ");
        double a = sc.nextDouble();
        char op = sc.next().charAt(0);
        double b = sc.nextDouble();
        switch (op) {
            case '+': System.out.println(a + b); break;
            case '-': System.out.println(a - b); break;
            case '*': System.out.println(a * b); break;
            case '/': System.out.println(b != 0 ? String.valueOf(a / b) : "Cannot divide by zero"); break;
            case '%': System.out.println(a % b); break;
            default: System.out.println("Invalid operator");
        }
    }
}

// Program: Write a Java program to concatenate two string
// file name should be ConcatStrings.java
class ConcatStrings {
    public static void main(String[] args) {
        String a = "Hello, ", b = "Java!";
        System.out.println(a.concat(b));
    }
}

// Program: Write a Java program to convert all characters in a string to lowercase
// file name should be ToLowerCase.java
class ToLowerCase {
    public static void main(String[] args) {
        System.out.println("JAVA Programming".toLowerCase());
    }
}

// Program: Write a Java program to convert all characters in a string to uppercase
// file name should be ToUpperCase.java
class ToUpperCase {
    public static void main(String[] args) {
        System.out.println("java Programming".toUpperCase());
    }
}

// Program: Write a Java program to trim a string(remove whitespaces)
// file name should be TrimString.java
class TrimString {
    public static void main(String[] args) {
        String s = "   Hello Java   ";
        System.out.println("[" + s.trim() + "]");
    }
}

// Program: Write a Java program to get a substring of a given string between two specified positions
// file name should be Substring.java
class Substring {
    public static void main(String[] args) {
        String s = "Programming";
        System.out.println(s.substring(3, 8));
    }
}

// Program: Write a Java program to replace all the 'd' characters with 'f' characters
// file name should be ReplaceDWithF.java
class ReplaceDWithF {
    public static void main(String[] args) {
        System.out.println("dad did a good deed".replace('d', 'f'));
    }
}

// Program: Write a java program to get the length of a given string
// file name should be StringLength.java
class StringLength {
    public static void main(String[] args) {
        String s = "Java Programming";
        System.out.println("Length = " + s.length());
    }
}

// Program: Write a java program to print current date and time in the specified format
// file name should be CurrentDateTimeFormat.java
class CurrentDateTimeFormat {
    public static void main(String[] args) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy hh:mm:ss a");
        System.out.println(LocalDateTime.now().format(f));
    }
}

// Program: Write a Java program to get the character at the given index within the String
// file name should be CharAtIndex.java
class CharAtIndex {
    public static void main(String[] args) {
        String s = "Programming";
        int idx = 4;
        System.out.println("Character at index " + idx + " = " + s.charAt(idx));
    }
}

// Program: Write a java program to remove a particular character from a string
// file name should be RemoveCharacter.java
class RemoveCharacter {
    public static void main(String[] args) {
        String s = "Programming";
        char remove = 'm';
        System.out.println(s.replace(String.valueOf(remove), ""));
    }
}

// Program: Write a java program to reverse a String
// file name should be ReverseString.java
class ReverseString {
    public static void main(String[] args) {
        String s = "Java";
        System.out.println(new StringBuilder(s).reverse());
    }
}

// Program: Write a java program to remove html tags from a string
// file name should be RemoveHtmlTags.java
class RemoveHtmlTags {
    public static void main(String[] args) {
        String html = "<html><body><h1>Hello</h1><p>Java <b>rocks</b></p></body></html>";
        System.out.println(html.replaceAll("<[^>]*>", ""));
    }
}

// Program: Write a java program to count total number of lines from a string
// file name should be CountLines.java
class CountLines {
    public static void main(String[] args) {
        String text = "line one\nline two\nline three\nline four";
        System.out.println("Total lines = " + text.split("\\R").length);
    }
}

// Program: Write a Java program to sum values of an array
// file name should be SumArray.java
class SumArray {
    public static void main(String[] args) {
        int[] a = {4, 8, 15, 16, 23, 42};
        int sum = 0;
        for (int x : a) sum += x;
        System.out.println("Sum = " + sum);
    }
}

// Program: Write a Java program to find the index of an array element
// file name should be IndexOfElement.java
class IndexOfElement {
    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40, 50};
        int key = 40, index = -1;
        for (int i = 0; i < a.length; i++) if (a[i] == key) { index = i; break; }
        System.out.println(index >= 0 ? key + " found at index " + index : key + " not found");
    }
}

// Program: Write a Java program to calculate the average value of array elements
// file name should be AverageOfArray.java
class AverageOfArray {
    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40, 55};
        double sum = 0;
        for (int x : a) sum += x;
        System.out.println("Average = " + sum / a.length);
    }
}

// Program: Write a Java program to test if an array contains a specific value
// file name should be ArrayContains.java
class ArrayContains {
    public static void main(String[] args) {
        int[] a = {3, 9, 27, 81};
        int key = 27;
        boolean found = false;
        for (int x : a) if (x == key) { found = true; break; }
        System.out.println("Array contains " + key + " ? " + found);
    }
}

// Program: Write a Java program to find the maximum and minimum value of an array
// file name should be MaxMinArray.java
class MaxMinArray {
    public static void main(String[] args) {
        int[] a = {34, 7, 91, 15, 62};
        int max = a[0], min = a[0];
        for (int x : a) { if (x > max) max = x; if (x < min) min = x; }
        System.out.println("Max = " + max + ", Min = " + min);
    }
}

// Program: Write a Java program to insert an element (specific position) into an array
// file name should be InsertIntoArray.java
class InsertIntoArray {
    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40, 50};
        int pos = 2, value = 99;
        int[] b = new int[a.length + 1];
        for (int i = 0, j = 0; i < b.length; i++) b[i] = (i == pos) ? value : a[j++];
        System.out.println("Before: " + Arrays.toString(a));
        System.out.println("After : " + Arrays.toString(b));
    }
}

// Program: Write a Java program to reverse an array of integer values
// file name should be ReverseArray.java
class ReverseArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        for (int i = 0, j = a.length - 1; i < j; i++, j--) { int t = a[i]; a[i] = a[j]; a[j] = t; }
        System.out.println(Arrays.toString(a));
    }
}

// Program: Write a Java program to find the common elements between two arrays
// file name should be CommonElements.java
class CommonElements {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        int[] b = {4, 5, 6, 7, 8};
        System.out.print("Common elements: ");
        for (int x : a) for (int y : b) if (x == y) System.out.print(x + " ");
        System.out.println();
    }
}

// Program: Write a Java program to find the duplicate values of an array of integer values
// file name should be DuplicateValues.java
class DuplicateValues {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 4, 5, 1, 6, 1};
        Set<Integer> seen = new HashSet<>(), dups = new LinkedHashSet<>();
        for (int x : a) if (!seen.add(x)) dups.add(x);
        System.out.println("Duplicate values: " + dups);
    }
}

// Program: Write a Java program to convert an array to ArrayList
// file name should be ArrayToArrayList.java
class ArrayToArrayList {
    public static void main(String[] args) {
        String[] arr = {"Red", "Green", "Blue"};
        ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
        list.add("Yellow");
        System.out.println("ArrayList: " + list);
    }
}

// Program: Write a Java program to add two matrices of the same size
// file name should be AddMatrices.java
class AddMatrices {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}};
        int[][] b = {{7, 8, 9}, {1, 2, 3}};
        int[][] c = new int[2][3];
        for (int i = 0; i < 2; i++) for (int j = 0; j < 3; j++) c[i][j] = a[i][j] + b[i][j];
        for (int[] row : c) System.out.println(Arrays.toString(row));
    }
}

// Program: Write a Java program to find second largest number from the array
// file name should be SecondLargest.java
class SecondLargest {
    public static void main(String[] args) {
        int[] a = {12, 35, 1, 10, 34, 1};
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int x : a) {
            if (x > first) { second = first; first = x; }
            else if (x > second && x != first) second = x;
        }
        System.out.println("Second largest = " + second);
    }
}

// Program: Write a Java program to find second lowest number from the array
// file name should be SecondLowest.java
class SecondLowest {
    public static void main(String[] args) {
        int[] a = {12, 35, 1, 10, 34, 1};
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int x : a) {
            if (x < first) { second = first; first = x; }
            else if (x < second && x != first) second = x;
        }
        System.out.println("Second lowest = " + second);
    }
}

// Program: Write a Java program to find the number of even and odd integers in a given array of integers
// file name should be EvenOddInArray.java
class EvenOddInArray {
    public static void main(String[] args) {
        int[] a = {5, 7, 2, 4, 9, 10, 12, 3};
        int even = 0, odd = 0;
        for (int x : a) if (x % 2 == 0) even++; else odd++;
        System.out.println("Number of even integers: " + even);
        System.out.println("Number of odd integers : " + odd);
    }
}

// Program: Write a Java program to get the difference between the largest and smallest values in an array of integers
// file name should be MaxMinDifference.java
class MaxMinDifference {
    public static void main(String[] args) {
        int[] a = {10, 3, 5, 6, 90, 22};
        int max = a[0], min = a[0];
        for (int x : a) { max = Math.max(max, x); min = Math.min(min, x); }
        System.out.println("Difference = " + (max - min));
    }
}

// Program: Write a Java program to segregate all 0s on left side and all 1s on right side of a given array of 0s and 1s
// file name should be Segregate0s1s.java
class Segregate0s1s {
    public static void main(String[] args) {
        int[] a = {0, 1, 0, 1, 1, 0, 1, 0};
        int zeros = 0;
        for (int x : a) if (x == 0) zeros++;
        for (int i = 0; i < a.length; i++) a[i] = (i < zeros) ? 0 : 1;
        System.out.println(Arrays.toString(a));
    }
}

// Program: Write a Java program to cyclically rotate a given array clockwise by one
// file name should be RotateClockwiseByOne.java
class RotateClockwiseByOne {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int last = a[a.length - 1];
        for (int i = a.length - 1; i > 0; i--) a[i] = a[i - 1];
        a[0] = last;
        System.out.println(Arrays.toString(a));
    }
}

// Program: java program to print all unique element in an array
// file name should be UniqueElements.java
class UniqueElements {
    public static void main(String[] args) {
        int[] a = {4, 7, 4, 9, 7, 1, 2, 2};
        Set<Integer> unique = new LinkedHashSet<>();
        for (int x : a) unique.add(x);
        System.out.println("Unique elements: " + unique);
    }
}

// Program: Write a Java Program to Sort the Array in an Ascending Order
// file name should be SortAscending.java
class SortAscending {
    public static void main(String[] args) {
        int[] a = {64, 25, 12, 22, 11};
        for (int i = 0; i < a.length - 1; i++)
            for (int j = 0; j < a.length - 1 - i; j++)
                if (a[j] > a[j + 1]) { int t = a[j]; a[j] = a[j + 1]; a[j + 1] = t; }
        System.out.println(Arrays.toString(a));
    }
}
