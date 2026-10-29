package interfaces;
import java.security.*;
import java.util.*;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

// Each question is its own class/interface. Compile: javac -d . interfaces.java   Run: java interfaces.ShapeInterface

// Program: Create an interface Shape with getArea(). Rectangle, Circle, Triangle implement it.
// file name should be ShapeInterface.java
class ShapeInterface {
    interface Shape { double getArea(); }
    static class Rectangle implements Shape {
        double l, w;
        Rectangle(double l, double w) { this.l = l; this.w = w; }
        public double getArea() { return l * w; }
    }
    static class Circle implements Shape {
        double r;
        Circle(double r) { this.r = r; }
        public double getArea() { return Math.PI * r * r; }
    }
    static class Triangle implements Shape {
        double b, h;
        Triangle(double b, double h) { this.b = b; this.h = h; }
        public double getArea() { return 0.5 * b * h; }
    }
    public static void main(String[] args) {
        Shape[] shapes = { new Rectangle(4, 5), new Circle(3), new Triangle(6, 4) };
        for (Shape s : shapes)
            System.out.printf("%s area = %.2f%n", s.getClass().getSimpleName(), s.getArea());
    }
}

// Program: Animal interface with bark(); Dog implements it and prints "Dog is barking"
// (the question text says speak() but the interface method is bark(), so bark() is overridden)
// file name should be AnimalBark.java
class AnimalBark {
    interface Animal { void bark(); }
    static class Dog implements Animal {
        public void bark() { System.out.println("Dog is barking"); }
    }
    public static void main(String[] args) {
        Animal a = new Dog();
        a.bark();
    }
}

// Program: Interface Flyable with fly_obj(); Spacecraft, Airplane, Helicopter implement it
// file name should be Flyable.java
interface Flyable {
    void fly_obj();
    class Spacecraft implements Flyable { public void fly_obj() { System.out.println("Spacecraft launches into orbit"); } }
    class Airplane implements Flyable { public void fly_obj() { System.out.println("Airplane flies at 10,000 m using jet engines"); } }
    class Helicopter implements Flyable { public void fly_obj() { System.out.println("Helicopter lifts off using rotor blades"); } }
    public static void main(String[] args) {
        Flyable[] f = { new Spacecraft(), new Airplane(), new Helicopter() };
        for (Flyable x : f) x.fly_obj();
    }
}

// Program: Banking system with Bank, Account (interface), SavingsAccount, CurrentAccount
// file name should be BankingSystem.java
class BankingSystem {
    interface Account {
        void deposit(double amt);
        void withdraw(double amt);
        double calculateInterest();
        void viewBalance();
    }
    static class SavingsAccount implements Account {
        private double balance; private final double rate;
        SavingsAccount(double balance, double rate) { this.balance = balance; this.rate = rate; }
        public void deposit(double amt) { balance += amt; }
        public void withdraw(double amt) {
            if (amt > balance) System.out.println("Savings: insufficient funds");
            else balance -= amt;
        }
        public double calculateInterest() { return balance * rate / 100; }
        public void viewBalance() { System.out.println("Savings balance = " + balance); }
        void addInterest() { balance += calculateInterest(); }   // unique method
    }
    static class CurrentAccount implements Account {
        private double balance; private final double overdraftLimit;
        CurrentAccount(double balance, double overdraftLimit) { this.balance = balance; this.overdraftLimit = overdraftLimit; }
        public void deposit(double amt) { balance += amt; }
        public void withdraw(double amt) {
            if (balance - amt < -overdraftLimit) System.out.println("Current: overdraft limit exceeded");
            else balance -= amt;
        }
        public double calculateInterest() { return 0; }          // no interest on current accounts
        public void viewBalance() { System.out.println("Current balance = " + balance); }
        double getOverdraftLimit() { return overdraftLimit; }    // unique method
    }
    static class Bank {
        private final List<Account> accounts = new ArrayList<>();
        void addAccount(Account a) { accounts.add(a); }
        void showAll() { for (Account a : accounts) a.viewBalance(); }
    }
    public static void main(String[] args) {
        Bank bank = new Bank();
        SavingsAccount sa = new SavingsAccount(10000, 4);
        CurrentAccount ca = new CurrentAccount(2000, 1000);
        bank.addAccount(sa); bank.addAccount(ca);
        sa.deposit(500); sa.withdraw(1500); sa.addInterest();
        ca.withdraw(2800); ca.withdraw(500);
        bank.showAll();
    }
}

// Program: Interface Resizable with resizeWidth(int) and resizeHeight(int); Rectangle implements it
// file name should be Resizable.java
interface Resizable {
    void resizeWidth(int width);
    void resizeHeight(int height);
    class Rectangle implements Resizable {
        int width, height;
        Rectangle(int w, int h) { width = w; height = h; }
        public void resizeWidth(int w) { width = w; }
        public void resizeHeight(int h) { height = h; }
        public String toString() { return "Rectangle[" + width + " x " + height + "]"; }
    }
    public static void main(String[] args) {
        Rectangle r = new Rectangle(10, 20);
        System.out.println("Before: " + r);
        r.resizeWidth(30); r.resizeHeight(40);
        System.out.println("After : " + r);
    }
}

// Program: Interface Drawable with draw(); Circle, Rectangle, Triangle implement it
// file name should be Drawable.java
interface Drawable {
    void draw();
    class Circle implements Drawable { public void draw() { System.out.println("Drawing a Circle"); } }
    class Rectangle implements Drawable { public void draw() { System.out.println("Drawing a Rectangle"); } }
    class Triangle implements Drawable { public void draw() { System.out.println("Drawing a Triangle"); } }
    public static void main(String[] args) {
        Drawable[] d = { new Circle(), new Rectangle(), new Triangle() };
        for (Drawable x : d) x.draw();
    }
}

// Program: Interface Sortable with sort() (ascending); BubbleSort and SelectionSort implement it
// file name should be SortableAscending.java
class SortableAscending {
    interface Sortable { void sort(int[] a); }
    static class BubbleSort implements Sortable {
        public void sort(int[] a) {
            for (int i = 0; i < a.length - 1; i++)
                for (int j = 0; j < a.length - 1 - i; j++)
                    if (a[j] > a[j + 1]) { int t = a[j]; a[j] = a[j + 1]; a[j + 1] = t; }
        }
    }
    static class SelectionSort implements Sortable {
        public void sort(int[] a) {
            for (int i = 0; i < a.length - 1; i++) {
                int min = i;
                for (int j = i + 1; j < a.length; j++) if (a[j] < a[min]) min = j;
                int t = a[i]; a[i] = a[min]; a[min] = t;
            }
        }
    }
    public static void main(String[] args) {
        int[] a = {64, 25, 12, 22, 11}, b = a.clone();
        new BubbleSort().sort(a);
        new SelectionSort().sort(b);
        System.out.println("Bubble   : " + Arrays.toString(a));
        System.out.println("Selection: " + Arrays.toString(b));
    }
}

// Program: Interface Playable with play(); Football, Volleyball, Basketball implement it
// file name should be Playable.java
interface Playable {
    void play();
    class Football implements Playable { public void play() { System.out.println("Playing Football"); } }
    class Volleyball implements Playable { public void play() { System.out.println("Playing Volleyball"); } }
    class Basketball implements Playable { public void play() { System.out.println("Playing Basketball"); } }
    public static void main(String[] args) {
        Playable[] p = { new Football(), new Volleyball(), new Basketball() };
        for (Playable x : p) x.play();
    }
}

// Program: Interface Searchable with search(String keyword); Document and WebPage implement it
// file name should be Searchable.java
interface Searchable {
    void search(String keyword);
    class Document implements Searchable {
        private final String text;
        Document(String text) { this.text = text; }
        public void search(String keyword) {
            int count = 0, idx = 0;
            String t = text.toLowerCase(), k = keyword.toLowerCase();
            while ((idx = t.indexOf(k, idx)) != -1) { count++; idx += k.length(); }
            System.out.println("Document: \"" + keyword + "\" found " + count + " time(s)");
        }
    }
    class WebPage implements Searchable {
        private final String url, content;
        WebPage(String url, String content) { this.url = url; this.content = content; }
        public void search(String keyword) {
            System.out.println("WebPage " + url + ": " + (content.toLowerCase().contains(keyword.toLowerCase()) ? "keyword found" : "keyword NOT found"));
        }
    }
    public static void main(String[] args) {
        Searchable d = new Document("Java is fun. Learning Java is easy with practice.");
        Searchable w = new WebPage("http://example.com", "Welcome to the Java tutorial page");
        d.search("java");
        w.search("tutorial");
        w.search("python");
    }
}

// Program: Interface Encryptable with encrypt/decrypt; AES and RSA implement it
// file name should be Encryptable.java
interface Encryptable {
    String encrypt(String data) throws Exception;
    String decrypt(String encryptedData) throws Exception;
    class AES implements Encryptable {
        private final SecretKeySpec key = new SecretKeySpec("0123456789abcdef".getBytes(), "AES"); // 128-bit demo key
        public String encrypt(String data) throws Exception {
            Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");
            c.init(Cipher.ENCRYPT_MODE, key);
            return Base64.getEncoder().encodeToString(c.doFinal(data.getBytes("UTF-8")));
        }
        public String decrypt(String enc) throws Exception {
            Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");
            c.init(Cipher.DECRYPT_MODE, key);
            return new String(c.doFinal(Base64.getDecoder().decode(enc)), "UTF-8");
        }
    }
    class RSA implements Encryptable {
        private final KeyPair pair;
        RSA() throws Exception {
            KeyPairGenerator g = KeyPairGenerator.getInstance("RSA");
            g.initialize(2048);
            pair = g.generateKeyPair();
        }
        public String encrypt(String data) throws Exception {
            Cipher c = Cipher.getInstance("RSA");
            c.init(Cipher.ENCRYPT_MODE, pair.getPublic());
            return Base64.getEncoder().encodeToString(c.doFinal(data.getBytes("UTF-8")));
        }
        public String decrypt(String enc) throws Exception {
            Cipher c = Cipher.getInstance("RSA");
            c.init(Cipher.DECRYPT_MODE, pair.getPrivate());
            return new String(c.doFinal(Base64.getDecoder().decode(enc)), "UTF-8");
        }
    }
    public static void main(String[] args) throws Exception {
        String msg = "Hello Java";
        Encryptable[] algos = { new AES(), new RSA() };
        for (Encryptable e : algos) {
            String enc = e.encrypt(msg);
            System.out.println(e.getClass().getSimpleName() + " encrypted: " + enc.substring(0, Math.min(30, enc.length())) + "...");
            System.out.println(e.getClass().getSimpleName() + " decrypted: " + e.decrypt(enc));
        }
    }
}

// Program: Interface Sortable with sort(int[] array) (descending); QuickSort and MergeSort implement it
// file name should be SortableDescending.java
class SortableDescending {
    interface Sortable { void sort(int[] array); }
    static class QuickSort implements Sortable {
        public void sort(int[] a) { quick(a, 0, a.length - 1); }
        private void quick(int[] a, int lo, int hi) {
            if (lo >= hi) return;
            int pivot = a[hi], i = lo;
            for (int j = lo; j < hi; j++)
                if (a[j] > pivot) { int t = a[i]; a[i] = a[j]; a[j] = t; i++; }
            int t = a[i]; a[i] = a[hi]; a[hi] = t;
            quick(a, lo, i - 1); quick(a, i + 1, hi);
        }
    }
    static class MergeSort implements Sortable {
        public void sort(int[] a) { if (a.length > 1) merge(a, 0, a.length - 1); }
        private void merge(int[] a, int lo, int hi) {
            if (lo >= hi) return;
            int mid = (lo + hi) / 2;
            merge(a, lo, mid); merge(a, mid + 1, hi);
            int[] tmp = new int[hi - lo + 1];
            int i = lo, j = mid + 1, k = 0;
            while (i <= mid && j <= hi) tmp[k++] = a[i] >= a[j] ? a[i++] : a[j++];
            while (i <= mid) tmp[k++] = a[i++];
            while (j <= hi) tmp[k++] = a[j++];
            System.arraycopy(tmp, 0, a, lo, tmp.length);
        }
    }
    public static void main(String[] args) {
        int[] a = {38, 27, 43, 3, 9, 82, 10}, b = a.clone();
        new QuickSort().sort(a);
        new MergeSort().sort(b);
        System.out.println("QuickSort : " + Arrays.toString(a));
        System.out.println("MergeSort : " + Arrays.toString(b));
    }
}