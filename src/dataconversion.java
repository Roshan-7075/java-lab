package dataconversion;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

// Each question is its own class. Compile: javac -d . dataconversion.java   Run: java dataconversion.StringToInt

// Program: How to convert String to int
// file name should be StringToInt.java
class StringToInt {
    public static void main(String[] args) {
        String s = "123";
        int a = Integer.parseInt(s);
        int b = Integer.valueOf(s);
        System.out.println(a + 1);
        System.out.println(b + 2);
    }
}

// Program: How to convert int to String
// file name should be IntToString.java
class IntToString {
    public static void main(String[] args) {
        int n = 456;
        String a = String.valueOf(n);
        String b = Integer.toString(n);
        String c = "" + n;
        System.out.println(a + b + c);          // string concatenation, not addition
    }
}

// Program: How to convert String to long
// file name should be StringToLong.java
class StringToLong {
    public static void main(String[] args) {
        String s = "9876543210";
        long a = Long.parseLong(s);
        long b = Long.valueOf(s);
        System.out.println(a + b);
    }
}

// Program: How to convert long to String
// file name should be LongToString.java
class LongToString {
    public static void main(String[] args) {
        long n = 9876543210L;
        System.out.println(String.valueOf(n) + " | " + Long.toString(n) + " | " + ("" + n));
    }
}

// Program: How to convert String to float
// file name should be StringToFloat.java
class StringToFloat {
    public static void main(String[] args) {
        String s = "12.75";
        float f = Float.parseFloat(s);
        System.out.println(f * 2);
    }
}

// Program: How to convert float to String
// file name should be FloatToString.java
class FloatToString {
    public static void main(String[] args) {
        float f = 3.14f;
        System.out.println(String.valueOf(f) + " | " + Float.toString(f));
    }
}

// Program: How to convert String to double
// file name should be StringToDouble.java
class StringToDouble {
    public static void main(String[] args) {
        String s = "99.995";
        double d = Double.parseDouble(s);
        System.out.println(d + 0.005);
    }
}

// Program: How to convert double to String
// file name should be DoubleToString.java
class DoubleToString {
    public static void main(String[] args) {
        double d = 2.71828;
        System.out.println(String.valueOf(d) + " | " + Double.toString(d) + " | " + String.format("%.2f", d));
    }
}

// Program: How to convert String to Date
// file name should be StringToDate.java
class StringToDate {
    public static void main(String[] args) throws Exception {
        String s = "25/12/2024";
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        Date d = f.parse(s);
        System.out.println(d);
    }
}

// Program: How to convert Date to String
// file name should be DateToString.java
class DateToString {
    public static void main(String[] args) {
        Date d = new Date();
        SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        System.out.println(f.format(d));
    }
}

// Program: How to convert String to char
// file name should be StringToChar.java
class StringToChar {
    public static void main(String[] args) {
        String s = "Java";
        char first = s.charAt(0);
        char[] all = s.toCharArray();
        System.out.println(first + " | " + all.length + " chars");
    }
}

// Program: How to convert char to String
// file name should be CharToString.java
class CharToString {
    public static void main(String[] args) {
        char c = 'J';
        String a = String.valueOf(c);
        String b = Character.toString(c);
        String d = "" + c;
        System.out.println(a + b + d);
    }
}

// Program: How to convert String to Object
// file name should be StringToObject.java
class StringToObject {
    public static void main(String[] args) {
        String s = "Hello";
        Object o = s;                           // upcasting, no conversion method needed
        System.out.println(o + " | is String? " + (o instanceof String));
    }
}

// Program: How to convert Object to String
// file name should be ObjectToString.java
class ObjectToString {
    public static void main(String[] args) {
        Object o = Integer.valueOf(100);
        String a = o.toString();
        String b = String.valueOf(o);
        String c = "" + o;
        Object o2 = "text";
        String d = (String) o2;                 // cast when the object really is a String
        System.out.println(a + b + c + " " + d);
    }
}

// Program: How to convert int to long
// file name should be IntToLong.java
class IntToLong {
    public static void main(String[] args) {
        int i = 2000000000;
        long l = i;                             // widening: automatic
        long big = (long) i * 2;                // avoids int overflow
        System.out.println(l + " | " + big);
    }
}

// Program: How to convert long to int
// file name should be LongToInt.java
class LongToInt {
    public static void main(String[] args) {
        long l = 12345L;
        int i = (int) l;                        // narrowing: explicit cast
        int safe = Math.toIntExact(l);          // throws ArithmeticException if it does not fit
        System.out.println(i + " | " + safe);
        System.out.println("Overflow cast: " + (int) 5000000000L);
    }
}

// Program: How to convert int to double
// file name should be IntToDouble.java
class IntToDouble {
    public static void main(String[] args) {
        int i = 7;
        double d = i;                           // widening: automatic
        System.out.println(d + " | " + (double) i / 2);
    }
}

// Program: How to convert double to int
// file name should be DoubleToInt.java
class DoubleToInt {
    public static void main(String[] args) {
        double d = 9.78;
        System.out.println("Cast (truncate): " + (int) d);
        System.out.println("Math.round     : " + Math.round(d));
        System.out.println("Math.floor     : " + (int) Math.floor(d));
        System.out.println("Math.ceil      : " + (int) Math.ceil(d));
    }
}

// Program: How to convert char to int
// file name should be CharToInt.java
class CharToInt {
    public static void main(String[] args) {
        char c = '7';
        System.out.println("ASCII value      : " + (int) c);
        System.out.println("Digit value      : " + (c - '0'));
        System.out.println("getNumericValue  : " + Character.getNumericValue(c));
    }
}

// Program: How to convert int to char
// file name should be IntToChar.java
class IntToChar {
    public static void main(String[] args) {
        int n = 65;
        System.out.println("ASCII to char : " + (char) n);
        int digit = 5;
        System.out.println("Digit to char : " + (char) (digit + '0'));
        System.out.println("forDigit      : " + Character.forDigit(digit, 10));
    }
}

// Program: How to convert String to boolean
// file name should be StringToBoolean.java
class StringToBoolean {
    public static void main(String[] args) {
        System.out.println(Boolean.parseBoolean("true"));
        System.out.println(Boolean.parseBoolean("TRUE"));    // case-insensitive
        System.out.println(Boolean.parseBoolean("yes"));     // anything else is false
        System.out.println(Boolean.valueOf("false"));
    }
}

// Program: How to convert boolean to String
// file name should be BooleanToString.java
class BooleanToString {
    public static void main(String[] args) {
        boolean b = true;
        System.out.println(String.valueOf(b) + " | " + Boolean.toString(b) + " | " + ("" + b));
    }
}

// Program: How to convert Date to Timestamp
// file name should be DateToTimestamp.java
class DateToTimestamp {
    public static void main(String[] args) {
        Date d = new Date();
        Timestamp t = new Timestamp(d.getTime());
        System.out.println("Date      : " + d);
        System.out.println("Timestamp : " + t);
    }
}

// Program: How to convert Timestamp to Date
// file name should be TimestampToDate.java
class TimestampToDate {
    public static void main(String[] args) {
        Timestamp t = new Timestamp(System.currentTimeMillis());
        Date d = new Date(t.getTime());
        System.out.println("Timestamp : " + t);
        System.out.println("Date      : " + d);
    }
}

// Program: How to convert Binary to Decimal
// file name should be BinaryToDecimal.java
class BinaryToDecimal {
    public static void main(String[] args) {
        String bin = "101101";
        System.out.println(bin + " (binary) = " + Integer.parseInt(bin, 2) + " (decimal)");
    }
}

// Program: How to convert Decimal to Binary
// file name should be DecimalToBinary.java
class DecimalToBinary {
    public static void main(String[] args) {
        int n = 45;
        System.out.println(n + " (decimal) = " + Integer.toBinaryString(n) + " (binary)");
    }
}

// Program: How to convert Hex to Decimal
// file name should be HexToDecimal.java
class HexToDecimal {
    public static void main(String[] args) {
        String hex = "1A3F";
        System.out.println(hex + " (hex) = " + Integer.parseInt(hex, 16) + " (decimal)");
    }
}

// Program: How to convert Decimal to Hex
// file name should be DecimalToHex.java
class DecimalToHex {
    public static void main(String[] args) {
        int n = 6719;
        System.out.println(n + " (decimal) = " + Integer.toHexString(n).toUpperCase() + " (hex)");
    }
}

// Program: How to convert Octal to Decimal
// file name should be OctalToDecimal.java
class OctalToDecimal {
    public static void main(String[] args) {
        String oct = "755";
        System.out.println(oct + " (octal) = " + Integer.parseInt(oct, 8) + " (decimal)");
    }
}

// Program: How to convert Decimal to Octal
// file name should be DecimalToOctal.java
class DecimalToOctal {
    public static void main(String[] args) {
        int n = 493;
        System.out.println(n + " (decimal) = " + Integer.toOctalString(n) + " (octal)");
    }
}
