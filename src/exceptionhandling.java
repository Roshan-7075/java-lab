package exceptionhandling;
import java.io.*;
import java.nio.file.*;
import java.sql.*;
import java.util.*;

// Each question is its own class. Compile: javac -d . exceptionhandling.java   Run: java exceptionhandling.TryCatch

// Program: Write a Java program that throws an exception and catch it using a try-catch block.
// file name should be TryCatch.java
class TryCatch {
    public static void main(String[] args) {
        try {
            int result = 10 / 0;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
        System.out.println("Program continues normally");
    }
}

// Program: Method that takes an integer and throws an exception if the number is odd
// file name should be ThrowIfOdd.java
class ThrowIfOdd {
    static void check(int n) {
        if (n % 2 != 0) throw new IllegalArgumentException(n + " is odd");
        System.out.println(n + " is even");
    }
    public static void main(String[] args) {
        for (int n : new int[]{4, 7}) {
            try { check(n); } catch (IllegalArgumentException e) { System.out.println("Exception: " + e.getMessage()); }
        }
    }
}

// Program: Method that reads a file and throws an exception if the file is not found
// file name should be FileNotFound.java
class FileNotFound {
    static void readFile(String name) throws FileNotFoundException {
        File f = new File(name);
        if (!f.exists()) throw new FileNotFoundException("File not found: " + name);
        try (Scanner sc = new Scanner(f)) { while (sc.hasNextLine()) System.out.println(sc.nextLine()); }
    }
    public static void main(String[] args) {
        try { readFile("does_not_exist.txt"); }
        catch (FileNotFoundException e) { System.out.println("Exception: " + e.getMessage()); }
    }
}

// Program: Read a list of numbers from a file and throw an exception if any number is positive
// file name should be PositiveNumberInFile.java
class PositiveNumberInFile {
    static class PositiveNumberException extends Exception {
        PositiveNumberException(String m) { super(m); }
    }
    public static void main(String[] args) throws IOException {
        Path p = Paths.get("numbers.txt");
        Files.write(p, Arrays.asList("-5", "-12", "7", "-3"));          // sample data (7 is positive)
        try (Scanner sc = new Scanner(p)) {
            while (sc.hasNextInt()) {
                int n = sc.nextInt();
                if (n > 0) throw new PositiveNumberException("Positive number found in file: " + n);
                System.out.println("OK: " + n);
            }
        } catch (PositiveNumberException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}

// Program: Read a file and throw an exception if the file is empty
// file name should be EmptyFile.java
class EmptyFile {
    static void read(String name) throws IOException {
        File f = new File(name);
        if (f.length() == 0) throw new IOException("File is empty: " + name);
        System.out.println(new String(Files.readAllBytes(f.toPath())));
    }
    public static void main(String[] args) throws IOException {
        File empty = new File("empty.txt");
        empty.createNewFile();                                           // creates a zero-length file
        try { read("empty.txt"); }
        catch (IOException e) { System.out.println("Exception: " + e.getMessage()); }
    }
}

// Program: Read a list of integers from the user and throw an exception if any number is duplicate
// file name should be DuplicateNumbers.java
class DuplicateNumbers {
    static class DuplicateException extends Exception {
        DuplicateException(String m) { super(m); }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many integers? ");
        int n = sc.nextInt();
        Set<Integer> seen = new HashSet<>();
        try {
            for (int i = 1; i <= n; i++) {
                System.out.print("Enter number " + i + ": ");
                int x = sc.nextInt();
                if (!seen.add(x)) throw new DuplicateException("Duplicate number entered: " + x);
            }
            System.out.println("All numbers are unique: " + seen);
        } catch (DuplicateException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}

// Program: Method that takes a string and throws an exception if it does not contain vowels
// file name should be NoVowels.java
class NoVowels {
    static void check(String s) {
        if (!s.toLowerCase().matches(".*[aeiou].*")) throw new IllegalArgumentException("\"" + s + "\" does not contain any vowel");
        System.out.println("\"" + s + "\" contains vowel(s)");
    }
    public static void main(String[] args) {
        for (String s : new String[]{"hello", "rhythm"}) {
            try { check(s); } catch (IllegalArgumentException e) { System.out.println("Exception: " + e.getMessage()); }
        }
    }
}

// Program: Connect the Java API to a Database; if the connection is not successful then throw an exception
// (needs the JDBC driver jar of your database on the classpath; without it the exception branch runs)
// file name should be DatabaseConnection.java
class DatabaseConnection {
    static Connection connect(String url, String user, String pass) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, pass);
        if (con == null) throw new SQLException("Connection is null");
        return con;
    }
    public static void main(String[] args) {
        try (Connection con = connect("jdbc:mysql://localhost:3306/testdb", "root", "password")) {
            System.out.println("Connected to database successfully");
        } catch (SQLException e) {
            System.out.println("Exception: database connection not successful -> " + e.getMessage());
        }
    }
}

// Program: Manage the driver with path, username and password; if not successful then throw an exception
// file name should be DriverManagement.java
class DriverManagement {
    static Connection load(String driver, String url, String user, String pass) throws Exception {
        try {
            Class.forName(driver);                                       // load the driver class
        } catch (ClassNotFoundException e) {
            throw new Exception("Driver class not found: " + driver);
        }
        try {
            return DriverManager.getConnection(url, user, pass);         // path (url), username, password
        } catch (SQLException e) {
            throw new Exception("Could not connect using given path/username/password: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        try {
            Connection c = load("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/testdb", "root", "password");
            System.out.println("Driver loaded and connected");
            c.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}

// Program: Execute SQL queries insert, delete, update; if not successful then throw an exception
// file name should be SqlQueries.java
class SqlQueries {
    static void run(Connection con, String sql) throws SQLException {
        try (Statement st = con.createStatement()) {
            int rows = st.executeUpdate(sql);
            System.out.println(sql + "  ->  " + rows + " row(s) affected");
        } catch (SQLException e) {
            throw new SQLException("Query failed: " + sql + " (" + e.getMessage() + ")", e);
        }
    }
    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password")) {
            run(con, "INSERT INTO student(id, name) VALUES (1, 'Rahul')");
            run(con, "UPDATE student SET name = 'Rohan' WHERE id = 1");
            run(con, "DELETE FROM student WHERE id = 1");
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}

// Program: Example of throws keyword
// file name should be ThrowsKeyword.java
class ThrowsKeyword {
    static void riskyMethod() throws IOException {
        throw new IOException("Problem inside riskyMethod()");
    }
    public static void main(String[] args) {
        try { riskyMethod(); }
        catch (IOException e) { System.out.println("Handled in main: " + e.getMessage()); }
    }
}

// Program: Example of multiple catch
// file name should be MultipleCatch.java
class MultipleCatch {
    public static void main(String[] args) {
        String[] tests = {"10", "abc", "20", null};
        int[] arr = new int[3];
        for (int i = 0; i < tests.length; i++) {
            try {
                int n = Integer.parseInt(tests[i]);
                arr[i + 1] = n;                                          // i=0 ok, i=2 -> index 3 is out of bounds
                System.out.println("Stored " + n);
            } catch (NumberFormatException e) {
                System.out.println("NumberFormatException: " + e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("General Exception: " + e);
            }
        }
    }
}

// Program: Example of nested try block
// file name should be NestedTry.java
class NestedTry {
    public static void main(String[] args) {
        try {
            System.out.println("Outer try started");
            try {
                int[] a = new int[3];
                a[5] = 10;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Inner catch: " + e.getMessage());
            }
            int x = 10 / 0;                                              // handled by the outer catch
        } catch (ArithmeticException e) {
            System.out.println("Outer catch: " + e.getMessage());
        } finally {
            System.out.println("Finally block always runs");
        }
    }
}
