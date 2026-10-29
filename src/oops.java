package oops;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

// Each question is its own class. Compile: javac -d . oop.java   Run: java oop.PersonClass

// Program: Class Person with name and age; two instances set via constructor
// file name should be PersonClass.java
class PersonClass {
    static class Person {
        String name; int age;
        Person(String name, int age) { this.name = name; this.age = age; }
    }
    public static void main(String[] args) {
        Person p1 = new Person("Alice", 25), p2 = new Person("Bob", 30);
        System.out.println(p1.name + " is " + p1.age + " years old");
        System.out.println(p2.name + " is " + p2.age + " years old");
    }
}

// Program: Class Dog with name and breed; modify using setters
// file name should be DogClass.java
class DogClass {
    static class Dog {
        private String name, breed;
        Dog(String name, String breed) { this.name = name; this.breed = breed; }
        void setName(String n) { name = n; }
        void setBreed(String b) { breed = b; }
        public String toString() { return name + " (" + breed + ")"; }
    }
    public static void main(String[] args) {
        Dog d1 = new Dog("Tommy", "Labrador"), d2 = new Dog("Bruno", "Beagle");
        System.out.println("Before: " + d1 + ", " + d2);
        d1.setName("Max"); d2.setBreed("Pug");
        System.out.println("After : " + d1 + ", " + d2);
    }
}

// Program: Class Rectangle with width and height; area and perimeter
// file name should be RectangleClass.java
class RectangleClass {
    static class Rectangle {
        double width, height;
        Rectangle(double w, double h) { width = w; height = h; }
        double area() { return width * height; }
        double perimeter() { return 2 * (width + height); }
    }
    public static void main(String[] args) {
        Rectangle r = new Rectangle(5, 3);
        System.out.println("Area = " + r.area() + ", Perimeter = " + r.perimeter());
    }
}

// Program: Class Circle with radius (access and modify); area and circumference
// file name should be CircleClass.java
class CircleClass {
    static class Circle {
        private double radius;
        Circle(double r) { radius = r; }
        double getRadius() { return radius; }
        void setRadius(double r) { radius = r; }
        double area() { return Math.PI * radius * radius; }
        double circumference() { return 2 * Math.PI * radius; }
    }
    public static void main(String[] args) {
        Circle c = new Circle(4);
        System.out.printf("r=%.1f area=%.2f circumference=%.2f%n", c.getRadius(), c.area(), c.circumference());
        c.setRadius(6);
        System.out.printf("r=%.1f area=%.2f circumference=%.2f%n", c.getRadius(), c.area(), c.circumference());
    }
}

// Program: Class Book (title, author, ISBN) with methods to add and remove books from a collection
// file name should be BookCollection.java
class BookCollection {
    static class Book {
        String title, author, isbn;
        Book(String t, String a, String i) { title = t; author = a; isbn = i; }
        public String toString() { return title + " by " + author + " [" + isbn + "]"; }
    }
    List<Book> books = new ArrayList<>();
    void addBook(Book b) { books.add(b); }
    boolean removeBook(String isbn) { return books.removeIf(b -> b.isbn.equals(isbn)); }
    void show() { books.forEach(System.out::println); }

    public static void main(String[] args) {
        BookCollection c = new BookCollection();
        c.addBook(new Book("Java Basics", "Sam", "111"));
        c.addBook(new Book("OOP Concepts", "Lee", "222"));
        c.show();
        c.removeBook("111");
        System.out.println("After removing 111:");
        c.show();
    }
}

// Program: Class Employee (name, job title, salary) with methods to calculate and update salary
// file name should be EmployeeSalary.java
class EmployeeSalary {
    static class Employee {
        String name, jobTitle; double salary;
        Employee(String n, String j, double s) { name = n; jobTitle = j; salary = s; }
        double calculateAnnualSalary() { return salary * 12; }
        void updateSalary(double newSalary) { salary = newSalary; }
        void giveRaise(double percent) { salary += salary * percent / 100; }
    }
    public static void main(String[] args) {
        Employee e = new Employee("Riya", "Analyst", 40000);
        System.out.println("Annual = " + e.calculateAnnualSalary());
        e.giveRaise(10);
        System.out.println("After 10% raise, monthly = " + e.salary + ", annual = " + e.calculateAnnualSalary());
        e.updateSalary(60000);
        System.out.println("Updated monthly = " + e.salary);
    }
}

// Program: Class Bank with a collection of accounts; add/remove accounts, deposit/withdraw; class Account for customer details
// file name should be BankAccounts.java
class BankAccounts {
    static class Account {
        int accNo; String holder; double balance;
        Account(int no, String holder, double bal) { accNo = no; this.holder = holder; balance = bal; }
        public String toString() { return accNo + " | " + holder + " | " + balance; }
    }
    static class Bank {
        Map<Integer, Account> accounts = new LinkedHashMap<>();
        void addAccount(Account a) { accounts.put(a.accNo, a); }
        void removeAccount(int no) { accounts.remove(no); }
        void deposit(int no, double amt) { Account a = accounts.get(no); if (a != null) a.balance += amt; }
        void withdraw(int no, double amt) {
            Account a = accounts.get(no);
            if (a == null) System.out.println("No such account");
            else if (a.balance < amt) System.out.println("Insufficient balance");
            else a.balance -= amt;
        }
        void show() { accounts.values().forEach(System.out::println); }
    }
    public static void main(String[] args) {
        Bank b = new Bank();
        b.addAccount(new Account(1, "Anil", 5000));
        b.addAccount(new Account(2, "Sunita", 8000));
        b.deposit(1, 1500); b.withdraw(2, 9000); b.withdraw(2, 3000);
        b.show();
        b.removeAccount(1);
        System.out.println("After removing account 1:");
        b.show();
    }
}

// Program: Class TrafficLight (color, duration) with methods to change color and check for red or green
// file name should be TrafficLight.java
class TrafficLight {
    String color; int duration;
    TrafficLight(String color, int duration) { this.color = color; this.duration = duration; }
    void changeColor() {
        switch (color) {
            case "Red":    color = "Green";  duration = 30; break;
            case "Green":  color = "Yellow"; duration = 5;  break;
            default:       color = "Red";    duration = 40;
        }
    }
    boolean isRed()   { return color.equals("Red"); }
    boolean isGreen() { return color.equals("Green"); }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("Red", 40);
        for (int i = 0; i < 4; i++) {
            System.out.println(t.color + " for " + t.duration + "s | red? " + t.isRed() + " | green? " + t.isGreen());
            t.changeColor();
        }
    }
}

// Program: Class Employee (name, salary, hire date) with a method to calculate years of service
// file name should be EmployeeYearsOfService.java
class EmployeeYearsOfService {
    static class Employee {
        String name; double salary; LocalDate hireDate;
        Employee(String n, double s, LocalDate h) { name = n; salary = s; hireDate = h; }
        long yearsOfService() { return ChronoUnit.YEARS.between(hireDate, LocalDate.now()); }
    }
    public static void main(String[] args) {
        Employee e = new Employee("Kiran", 55000, LocalDate.of(2015, 6, 15));
        System.out.println(e.name + " has " + e.yearsOfService() + " years of service");
    }
}

// Program: Class Student (name, grade, courses) with methods to add and remove courses
// file name should be StudentCourses.java
class StudentCourses {
    static class Student {
        String name; char grade; List<String> courses = new ArrayList<>();
        Student(String n, char g) { name = n; grade = g; }
        void addCourse(String c) { if (!courses.contains(c)) courses.add(c); }
        void removeCourse(String c) { courses.remove(c); }
    }
    public static void main(String[] args) {
        Student s = new Student("Meera", 'A');
        s.addCourse("Maths"); s.addCourse("Physics"); s.addCourse("Java");
        System.out.println(s.name + " courses: " + s.courses);
        s.removeCourse("Physics");
        System.out.println("After removal: " + s.courses);
    }
}

// Program: Class Library with a collection of books and methods to add and remove books
// file name should be Library.java
class Library {
    List<String> books = new ArrayList<>();
    void addBook(String b) { books.add(b); System.out.println("Added: " + b); }
    void removeBook(String b) { System.out.println(books.remove(b) ? "Removed: " + b : "Not found: " + b); }

    public static void main(String[] args) {
        Library lib = new Library();
        lib.addBook("Data Structures"); lib.addBook("Algorithms");
        lib.removeBook("Algorithms"); lib.removeBook("Networks");
        System.out.println("Library now has: " + lib.books);
    }
}

// Program: Class Airplane (flight number, destination, departure time) with methods to check flight status and delay
// file name should be Airplane.java
class Airplane {
    String flightNumber, destination; LocalTime departure; boolean delayed;
    Airplane(String f, String d, LocalTime t) { flightNumber = f; destination = d; departure = t; }
    void delay(int minutes) { departure = departure.plusMinutes(minutes); delayed = true; }
    void checkStatus() {
        System.out.println("Flight " + flightNumber + " to " + destination + " departs at " + departure + (delayed ? " (DELAYED)" : " (ON TIME)"));
    }

    public static void main(String[] args) {
        Airplane a = new Airplane("AI-203", "Mumbai", LocalTime.of(14, 30));
        a.checkStatus();
        a.delay(45);
        a.checkStatus();
    }
}

// Program: Class Inventory with a collection of products; add/remove products and check for low inventory
// file name should be Inventory.java
class Inventory {
    static class Product {
        String name; int quantity;
        Product(String n, int q) { name = n; quantity = q; }
    }
    List<Product> products = new ArrayList<>();
    void addProduct(Product p) { products.add(p); }
    void removeProduct(String name) { products.removeIf(p -> p.name.equals(name)); }
    void checkLowInventory(int threshold) {
        for (Product p : products)
            if (p.quantity < threshold) System.out.println("LOW STOCK: " + p.name + " (" + p.quantity + ")");
    }

    public static void main(String[] args) {
        Inventory inv = new Inventory();
        inv.addProduct(new Product("Pen", 100)); inv.addProduct(new Product("Notebook", 8)); inv.addProduct(new Product("Marker", 3));
        inv.checkLowInventory(10);
        inv.removeProduct("Marker");
        System.out.println("Products left: " + inv.products.size());
    }
}

// Program: Class School with students, teachers and classes; add/remove students and teachers, create classes
// file name should be School.java
class School {
    List<String> students = new ArrayList<>(), teachers = new ArrayList<>();
    Map<String, List<String>> classes = new LinkedHashMap<>();
    void addStudent(String s) { students.add(s); }
    void removeStudent(String s) { students.remove(s); }
    void addTeacher(String t) { teachers.add(t); }
    void removeTeacher(String t) { teachers.remove(t); }
    void createClass(String className, String teacher) {
        classes.put(className, new ArrayList<>(Arrays.asList(teacher)));
    }

    public static void main(String[] args) {
        School sc = new School();
        sc.addStudent("Ravi"); sc.addStudent("Sita"); sc.addTeacher("Mr. Khan");
        sc.createClass("10-A", "Mr. Khan");
        sc.removeStudent("Ravi");
        System.out.println("Students: " + sc.students + ", Teachers: " + sc.teachers + ", Classes: " + sc.classes);
    }
}

// Program: Class MusicLibrary with a collection of songs; add/remove songs and play a random song
// file name should be MusicLibrary.java
class MusicLibrary {
    List<String> songs = new ArrayList<>();
    void addSong(String s) { songs.add(s); }
    void removeSong(String s) { songs.remove(s); }
    void playRandom() {
        if (songs.isEmpty()) System.out.println("No songs in library");
        else System.out.println("Now playing: " + songs.get(new Random().nextInt(songs.size())));
    }

    public static void main(String[] args) {
        MusicLibrary m = new MusicLibrary();
        m.addSong("Song A"); m.addSong("Song B"); m.addSong("Song C");
        m.removeSong("Song B");
        m.playRandom();
    }
}

// Program: Class Shape with abstract methods for area and perimeter; subclasses Rectangle, Circle, Triangle
// file name should be ShapeAbstract.java
class ShapeAbstract {
    static abstract class Shape { abstract double area(); abstract double perimeter(); }
    static class Rectangle extends Shape {
        double l, w; Rectangle(double l, double w) { this.l = l; this.w = w; }
        double area() { return l * w; } double perimeter() { return 2 * (l + w); }
    }
    static class Circle extends Shape {
        double r; Circle(double r) { this.r = r; }
        double area() { return Math.PI * r * r; } double perimeter() { return 2 * Math.PI * r; }
    }
    static class Triangle extends Shape {
        double a, b, c; Triangle(double a, double b, double c) { this.a = a; this.b = b; this.c = c; }
        double area() { double s = (a + b + c) / 2; return Math.sqrt(s * (s - a) * (s - b) * (s - c)); }
        double perimeter() { return a + b + c; }
    }
    public static void main(String[] args) {
        Shape[] s = { new Rectangle(4, 6), new Circle(3), new Triangle(3, 4, 5) };
        for (Shape x : s)
            System.out.printf("%s -> area %.2f, perimeter %.2f%n", x.getClass().getSimpleName(), x.area(), x.perimeter());
    }
}

// Program: Class Movie (title, director, actors, reviews) with methods for adding and retrieving reviews
// file name should be Movie.java
class Movie {
    String title, director; List<String> actors, reviews = new ArrayList<>();
    Movie(String t, String d, List<String> a) { title = t; director = d; actors = a; }
    void addReview(String r) { reviews.add(r); }
    List<String> getReviews() { return reviews; }

    public static void main(String[] args) {
        Movie m = new Movie("Inception", "Christopher Nolan", Arrays.asList("Leonardo DiCaprio", "Tom Hardy"));
        m.addReview("Mind-bending!"); m.addReview("Great visuals and score.");
        System.out.println(m.title + " (" + m.director + ") reviews:");
        for (String r : m.getReviews()) System.out.println(" - " + r);
    }
}

// Program: Class Restaurant (menu items, prices, ratings) with methods to add/remove items and calculate average rating
// file name should be Restaurant.java
class Restaurant {
    Map<String, Double> menu = new LinkedHashMap<>();
    List<Integer> ratings = new ArrayList<>();
    void addItem(String item, double price) { menu.put(item, price); }
    void removeItem(String item) { menu.remove(item); }
    void addRating(int r) { ratings.add(r); }
    double averageRating() {
        return ratings.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    public static void main(String[] args) {
        Restaurant r = new Restaurant();
        r.addItem("Pizza", 250); r.addItem("Pasta", 180); r.addItem("Burger", 120);
        r.removeItem("Burger");
        r.addRating(5); r.addRating(4); r.addRating(3);
        System.out.println("Menu: " + r.menu);
        System.out.println("Average rating = " + r.averageRating());
    }
}

// Program: Class with methods to search for flights and hotels, and to book and cancel reservations
// file name should be TravelBooking.java
class TravelBooking {
    static class TravelAgency {
        List<String> flights = Arrays.asList("Delhi-Mumbai", "Delhi-Goa", "Mumbai-Goa");
        List<String> hotels = Arrays.asList("Taj Goa", "Hyatt Mumbai", "Leela Delhi");
        List<String> reservations = new ArrayList<>();
        void searchFlights(String keyword) {
            for (String f : flights) if (f.toLowerCase().contains(keyword.toLowerCase())) System.out.println("Flight found: " + f);
        }
        void searchHotels(String keyword) {
            for (String h : hotels) if (h.toLowerCase().contains(keyword.toLowerCase())) System.out.println("Hotel found: " + h);
        }
        void book(String item) { reservations.add(item); System.out.println("Booked: " + item); }
        void cancel(String item) { System.out.println(reservations.remove(item) ? "Cancelled: " + item : "No such reservation"); }
    }
    public static void main(String[] args) {
        TravelAgency t = new TravelAgency();
        t.searchFlights("goa"); t.searchHotels("goa");
        t.book("Delhi-Goa"); t.book("Taj Goa");
        t.cancel("Delhi-Goa");
        System.out.println("Reservations: " + t.reservations);
    }
}

// Program: Create a class showing an example of default constructor
// file name should be DefaultConstructor.java
class DefaultConstructor {
    static class Student {
        String name; int age;
        Student() { name = "Unknown"; age = 0; System.out.println("Default constructor called"); }
    }
    public static void main(String[] args) {
        Student s = new Student();
        System.out.println(s.name + ", " + s.age);
    }
}

// Program: Create a class showing an example of parameterized constructor
// file name should be ParameterizedConstructor.java
class ParameterizedConstructor {
    static class Student {
        String name; int age;
        Student(String name, int age) { this.name = name; this.age = age; }
    }
    public static void main(String[] args) {
        Student s = new Student("Pooja", 20);
        System.out.println(s.name + ", " + s.age);
    }
}

// Program: Create a class showing an example of copy constructor
// file name should be CopyConstructor.java
class CopyConstructor {
    static class Student {
        String name; int age;
        Student(String name, int age) { this.name = name; this.age = age; }
        Student(Student other) { this.name = other.name; this.age = other.age; }   // copy constructor
    }
    public static void main(String[] args) {
        Student s1 = new Student("Pooja", 20);
        Student s2 = new Student(s1);
        s2.name = "Rahul";
        System.out.println("s1: " + s1.name + ", " + s1.age);
        System.out.println("s2: " + s2.name + ", " + s2.age);
    }
}

// Program: Enter rollno (auto generated), name and class of 10 students from the user
// file name should be AutoRollNo.java
class AutoRollNo {
    static class Student {
        static int counter = 0;                                   // shared by all objects
        int rollNo; String name, studentClass;
        Student(String name, String studentClass) { rollNo = ++counter; this.name = name; this.studentClass = studentClass; }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] st = new Student[10];
        for (int i = 0; i < 10; i++) {
            System.out.print("Student " + (i + 1) + " name : ");
            String n = sc.nextLine();
            System.out.print("Student " + (i + 1) + " class: ");
            String c = sc.nextLine();
            st[i] = new Student(n, c);
        }
        System.out.println("\nRollNo\tName\tClass");
        for (Student s : st) System.out.println(s.rollNo + "\t" + s.name + "\t" + s.studentClass);
    }
}

// Program: Area of circle and rectangle by method overloading
// file name should be AreaOverloading.java
class AreaOverloading {
    static double area(double radius) { return Math.PI * radius * radius; }             // circle
    static double area(double length, double width) { return length * width; }          // rectangle
    public static void main(String[] args) {
        System.out.printf("Area of circle (r=5)         = %.2f%n", area(5));
        System.out.printf("Area of rectangle (4 x 6)    = %.2f%n", area(4, 6));
    }
}

// Program: Command line arguments - show all the arguments as output
// Run: java oops.CommandLineArgs one two three
// file name should be CommandLineArgs.java
class CommandLineArgs {
    public static void main(String[] args) {
        if (args.length == 0) { System.out.println("No arguments given. Run: java oops.CommandLineArgs one two three"); return; }
        System.out.println("Number of arguments: " + args.length);
        for (int i = 0; i < args.length; i++) System.out.println("args[" + i + "] = " + args[i]);
    }
}

// Program: Class Person with private name, age, country and public getters/setters
// file name should be PersonEncapsulation.java
class PersonEncapsulation {
    static class Person {
        private String name, country; private int age;
        public String getName() { return name; } public void setName(String n) { name = n; }
        public int getAge() { return age; } public void setAge(int a) { age = a; }
        public String getCountry() { return country; } public void setCountry(String c) { country = c; }
    }
    public static void main(String[] args) {
        Person p = new Person();
        p.setName("Arjun"); p.setAge(28); p.setCountry("India");
        System.out.println(p.getName() + ", " + p.getAge() + ", " + p.getCountry());
    }
}

// Program: Class BankAccount with private accountNumber and balance and public getters/setters
// file name should be BankAccountEncapsulation.java
class BankAccountEncapsulation {
    static class BankAccount {
        private String accountNumber; private double balance;
        public String getAccountNumber() { return accountNumber; } public void setAccountNumber(String a) { accountNumber = a; }
        public double getBalance() { return balance; } public void setBalance(double b) { balance = b; }
    }
    public static void main(String[] args) {
        BankAccount b = new BankAccount();
        b.setAccountNumber("ACC1001"); b.setBalance(25000);
        System.out.println(b.getAccountNumber() + " -> " + b.getBalance());
    }
}

// Program: Class Rectangle with private length and width and public getters/setters
// file name should be RectangleEncapsulation.java
class RectangleEncapsulation {
    static class Rectangle {
        private double length, width;
        public double getLength() { return length; } public void setLength(double l) { length = l; }
        public double getWidth() { return width; } public void setWidth(double w) { width = w; }
    }
    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        r.setLength(12); r.setWidth(5);
        System.out.println("Length = " + r.getLength() + ", Width = " + r.getWidth() + ", Area = " + r.getLength() * r.getWidth());
    }
}

// Program: Class Employee with private id, name, salary; getters/setters for id and name; getter for salary returns formatted string
// file name should be EmployeeEncapsulation.java
class EmployeeEncapsulation {
    static class Employee {
        private int employee_id; private String employee_name; private double employee_salary;
        Employee(int id, String name, double salary) { employee_id = id; employee_name = name; employee_salary = salary; }
        public int getId() { return employee_id; } public void setId(int id) { employee_id = id; }
        public String getName() { return employee_name; } public void setName(String n) { employee_name = n; }
        public String getSalary() { return String.format("Rs. %,.2f", employee_salary); }
    }
    public static void main(String[] args) {
        Employee e = new Employee(7, "Divya", 1250000.5);
        e.setName("Divya Nair");
        System.out.println(e.getId() + " | " + e.getName() + " | " + e.getSalary());
    }
}

// Program: Class Circle with private radius; getter/setter; calculateArea() and calculatePerimeter()
// file name should be CircleEncapsulation.java
class CircleEncapsulation {
    static class Circle {
        private double radius;
        public double getRadius() { return radius; } public void setRadius(double r) { radius = r; }
        public double calculateArea() { return Math.PI * radius * radius; }
        public double calculatePerimeter() { return 2 * Math.PI * radius; }
    }
    public static void main(String[] args) {
        Circle c = new Circle();
        c.setRadius(5);
        System.out.printf("Radius %.1f -> area %.2f, perimeter %.2f%n", c.getRadius(), c.calculateArea(), c.calculatePerimeter());
        c.setRadius(10);
        System.out.printf("Radius %.1f -> area %.2f, perimeter %.2f%n", c.getRadius(), c.calculateArea(), c.calculatePerimeter());
    }
}

// Program: Class Car with private company_name, model_name, year, mileage; setters for all but mileage (getter only)
// file name should be CarEncapsulation.java
class CarEncapsulation {
    static class Car {
        private String company_name, model_name; private int year; private final double mileage;
        Car(double mileage) { this.mileage = mileage; }                       // mileage can only be set at creation
        public String getCompanyName() { return company_name; } public void setCompanyName(String c) { company_name = c; }
        public String getModelName() { return model_name; } public void setModelName(String m) { model_name = m; }
        public int getYear() { return year; } public void setYear(int y) { year = y; }
        public double getMileage() { return mileage; }                        // read-only
    }
    public static void main(String[] args) {
        Car c = new Car(18.5);
        c.setCompanyName("Maruti"); c.setModelName("Swift"); c.setYear(2022);
        System.out.println(c.getCompanyName() + " " + c.getModelName() + " (" + c.getYear() + "), mileage " + c.getMileage() + " km/l");
    }
}

// Program: Class Student with private student_id, student_name, grades; getters/setters for id and name; addGrade() with validation
// file name should be StudentEncapsulation.java
class StudentEncapsulation {
    static class Student {
        private int student_id; private String student_name; private List<Integer> grades = new ArrayList<>();
        public int getStudentId() { return student_id; } public void setStudentId(int id) { student_id = id; }
        public String getStudentName() { return student_name; } public void setStudentName(String n) { student_name = n; }
        public void addGrade(int grade) {
            if (grade < 0 || grade > 100) { System.out.println("Invalid grade rejected: " + grade); return; }   // validation
            grades.add(grade);
        }
        public List<Integer> getGrades() { return Collections.unmodifiableList(grades); }
    }
    public static void main(String[] args) {
        Student s = new Student();
        s.setStudentId(501); s.setStudentName("Naveen");
        s.addGrade(85); s.addGrade(105); s.addGrade(-4); s.addGrade(92);
        System.out.println(s.getStudentId() + " " + s.getStudentName() + " grades: " + s.getGrades());
    }
}