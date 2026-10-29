package packages;
import java.util.Date;

// Each question is its own class. Every class has a main() so it can be run separately.
// Compile: javac -d . packages.java   Run: java packages.DateImport

// Program: 1. Create a Java program to access the java.util.Date class through import keyword and print the current date of the system.
// file name should be DateImport.java
class DateImport {
    public static void main(String[] args) {
        Date currentDate = new Date();
        System.out.println("Current Date (via import): " + currentDate);
    }
}

// Program: 2. Create a Java program to access the java.util.Date class through qualified way and print the current date of the system.
// file name should be DateQualified.java
class DateQualified {
    public static void main(String[] args) {
        java.util.Date currentDate = new java.util.Date();
        System.out.println("Current Date (via qualified name): " + currentDate);
    }
}

// Program: 3. Create a Java program to access the java.util.Date class through import keyword and print the current date of the system but inherit the Date class.
// file name should be DateInheritImport.java
class DateInheritImport extends Date {
    public static void main(String[] args) {
        DateInheritImport currentDate = new DateInheritImport();
        System.out.println("Current Date (inherited via import): " + currentDate);
    }
}

// Program: 4. Create a Java program to access the java.util.Date class through qualified way and print the current date of the system but inherit the Date class.
// file name should be DateInheritQualified.java
class DateInheritQualified extends java.util.Date {
    public static void main(String[] args) {
        DateInheritQualified currentDate = new DateInheritQualified();
        System.out.println("Current Date (inherited via qualified name): " + currentDate);
    }
}

// Program: 5. Create a Java program to create a package with multiple default classes.
// file name should be MultipleDefaultClasses.java
class DefaultClassOne {
    void showOne() {
        System.out.println("Inside DefaultClassOne (package-private access)");
    }
}

class DefaultClassTwo {
    void showTwo() {
        System.out.println("Inside DefaultClassTwo (package-private access)");
    }
}

class DefaultClassThree {
    void showThree() {
        System.out.println("Inside DefaultClassThree (package-private access)");
    }
}

class MultipleDefaultClasses {
    public static void main(String[] args) {
        DefaultClassOne c1 = new DefaultClassOne();
        DefaultClassTwo c2 = new DefaultClassTwo();
        DefaultClassThree c3 = new DefaultClassThree();
        c1.showOne();
        c2.showTwo();
        c3.showThree();
    }
}

// Program: 6. Create a Java program to create a package with 4 public classes, create the object in another file and call the function created in those classes.
// file name should be FourPublicClasses.java
// Note: In separate files, ClassA.java, ClassB.java, ClassC.java, and ClassD.java are declared `public class`.
class ClassA {
    public void funcA() { System.out.println("Function called from ClassA"); }
}

class ClassB {
    public void funcB() { System.out.println("Function called from ClassB"); }
}

class ClassC {
    public void funcC() { System.out.println("Function called from ClassC"); }
}

class ClassD {
    public void funcD() { System.out.println("Function called from ClassD"); }
}

class FourPublicClasses {
    public static void main(String[] args) {
        ClassA a = new ClassA();
        ClassB b = new ClassB();
        ClassC c = new ClassC();
        ClassD d = new ClassD();
        a.funcA();
        b.funcB();
        c.funcC();
        d.funcD();
    }
}

// Program: 7. Write a Java program to perform employee payroll processing using packages. In the java file, Emp.java creates a package employee and creates a class Emp. Declare the variables name, empid, category, bpay, hra, da, npay, pf, grosspay, incometax, and allowance. Calculate the values in methods. Create another java file Emppay.java. Create an object e to call the methods to perform and print values.
// file name should be Emppay.java (alongside employee/Emp.java)
class Emp {
    public String name, category;
    public int empid;
    public double bpay, hra, da, npay, pf, grosspay, incometax, allowance;

    public Emp(String name, int empid, String category, double bpay) {
        this.name = name;
        this.empid = empid;
        this.category = category;
        this.bpay = bpay;
    }

    public void calculatePayroll() {
        hra = 0.15 * bpay;
        da = 0.10 * bpay;
        allowance = 0.05 * bpay;
        pf = 0.12 * bpay;
        grosspay = bpay + hra + da + allowance;
        incometax = 0.10 * grosspay;
        npay = grosspay - (pf + incometax);
    }

    public void printPayroll() {
        System.out.println("=== Employee Payroll Details ===");
        System.out.println("Employee ID : " + empid);
        System.out.println("Name        : " + name);
        System.out.println("Category    : " + category);
        System.out.printf("Basic Pay   : %.2f%n", bpay);
        System.out.printf("HRA (15%%)   : %.2f%n", hra);
        System.out.printf("DA (10%%)    : %.2f%n", da);
        System.out.printf("Allowance   : %.2f%n", allowance);
        System.out.printf("Gross Pay   : %.2f%n", grosspay);
        System.out.printf("PF (12%%)    : %.2f%n", pf);
        System.out.printf("Income Tax  : %.2f%n", incometax);
        System.out.printf("Net Pay     : %.2f%n", npay);
    }
}

class Emppay {
    public static void main(String[] args) {
        Emp e = new Emp("Raj", 101, "Software Engineer", 50000.0);
        e.calculatePayroll();
        e.printPayroll();
    }
}

// Program: 8. Create a Java program to create a package with public class and protected members to be accessed in another class.
// file name should be ProtectedMembers.java
class BasePublicClass {
    protected String secretMessage = "Protected member accessed via inheritance/package";
    protected void showProtected() {
        System.out.println("Message: " + secretMessage);
    }
}

class ProtectedMembers extends BasePublicClass {
    public static void main(String[] args) {
        ProtectedMembers obj = new ProtectedMembers();
        obj.showProtected();
    }
}

// Program: 9. Create a Java program to create a nested package i.e. c4.sample with public class and protected members to be accessed in another class.
// file name should be NestedPackageProtected.java (representing package c4.sample)
class C4SampleClass {
    protected int sampleCode = 404;
    protected void displaySample() {
        System.out.println("Accessed protected member from nested package (c4.sample), Code = " + sampleCode);
    }
}

class NestedPackageProtected extends C4SampleClass {
    public static void main(String[] args) {
        NestedPackageProtected obj = new NestedPackageProtected();
        obj.displaySample();
    }
}

// Program: 10. Create a Java program to create a package with public class and public members to be accessed in another class.
// file name should be PublicMembers.java
class PublicClass {
    public String info = "Public member of a public class in package";
    public void displayInfo() {
        System.out.println(info);
    }
}

class PublicMembers {
    public static void main(String[] args) {
        PublicClass obj = new PublicClass();
        System.out.println("Direct field access : " + obj.info);
        obj.displayInfo();
    }
}