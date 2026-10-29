package inheritance;
import java.util.*;

// Each question is its own class. Compile: javac -d . inheritance.java   Run: java inheritance.AnimalCat

// Program: Animal with makeSound(); Cat overrides makeSound() to bark
// file name should be AnimalCat.java
class AnimalCat {
    static class Animal { void makeSound() { System.out.println("Animal makes a sound"); } }
    static class Cat extends Animal { @Override void makeSound() { System.out.println("Cat barks"); } }
    public static void main(String[] args) {
        new Animal().makeSound();
        new Cat().makeSound();
    }
}

// Program: Vehicle with drive(); Car overrides drive() to print "Repairing a car"
// file name should be VehicleCar.java
class VehicleCar {
    static class Vehicle { void drive() { System.out.println("Driving a vehicle"); } }
    static class Car extends Vehicle { @Override void drive() { System.out.println("Repairing a car"); } }
    public static void main(String[] args) {
        Vehicle v = new Car();
        v.drive();
    }
}

// Program: Shape with getArea(); Rectangle overrides getArea()
// file name should be ShapeRectangle.java
class ShapeRectangle {
    static class Shape { double getArea() { return 0; } }
    static class Rectangle extends Shape {
        double l, w;
        Rectangle(double l, double w) { this.l = l; this.w = w; }
        @Override double getArea() { return l * w; }
    }
    public static void main(String[] args) {
        Shape s = new Rectangle(5, 8);
        System.out.println("Area of rectangle = " + s.getArea());
    }
}

// Program: Employee with work() and getSalary(); HRManager overrides work() and adds addEmployee()
// file name should be EmployeeHRManager.java
class EmployeeHRManager {
    static class Employee {
        String name; double salary;
        Employee(String name, double salary) { this.name = name; this.salary = salary; }
        void work() { System.out.println(name + " is working"); }
        double getSalary() { return salary; }
    }
    static class HRManager extends Employee {
        List<Employee> team = new ArrayList<>();
        HRManager(String name, double salary) { super(name, salary); }
        @Override void work() { System.out.println(name + " is managing HR activities"); }
        void addEmployee(Employee e) { team.add(e); System.out.println(e.name + " added to HR team"); }
    }
    public static void main(String[] args) {
        HRManager hr = new HRManager("Asha", 75000);
        hr.work();
        hr.addEmployee(new Employee("Ravi", 40000));
        System.out.println("HR salary = " + hr.getSalary() + ", team size = " + hr.team.size());
    }
}

// Program: BankAccount with deposit()/withdraw(); SavingsAccount blocks withdrawals if balance falls below 100
// file name should be BankSavings.java
class BankSavings {
    static class BankAccount {
        protected double balance;
        BankAccount(double b) { balance = b; }
        void deposit(double amt) { balance += amt; }
        void withdraw(double amt) {
            if (amt <= balance) balance -= amt; else System.out.println("Insufficient funds");
        }
    }
    static class SavingsAccount extends BankAccount {
        SavingsAccount(double b) { super(b); }
        @Override void withdraw(double amt) {
            if (balance - amt < 100) System.out.println("Withdrawal denied: balance would fall below 100");
            else balance -= amt;
        }
    }
    public static void main(String[] args) {
        SavingsAccount s = new SavingsAccount(500);
        s.withdraw(300);
        System.out.println("Balance = " + s.balance);
        s.withdraw(150);
        System.out.println("Balance = " + s.balance);
    }
}

// Program: Animal with move(); Cheetah overrides move() to run
// file name should be AnimalCheetah.java
class AnimalCheetah {
    static class Animal { void move() { System.out.println("Animal moves"); } }
    static class Cheetah extends Animal { @Override void move() { System.out.println("Cheetah runs very fast"); } }
    public static void main(String[] args) {
        Animal a = new Cheetah();
        a.move();
    }
}

// Program: Person with getFirstName()/getLastName(); Employee adds getEmployeeId() and overrides getLastName() to include job title
// file name should be PersonEmployee.java
class PersonEmployee {
    static class Person {
        String first, last;
        Person(String f, String l) { first = f; last = l; }
        String getFirstName() { return first; }
        String getLastName() { return last; }
    }
    static class Employee extends Person {
        int id; String jobTitle;
        Employee(String f, String l, int id, String jobTitle) { super(f, l); this.id = id; this.jobTitle = jobTitle; }
        int getEmployeeId() { return id; }
        @Override String getLastName() { return super.getLastName() + " (" + jobTitle + ")"; }
    }
    public static void main(String[] args) {
        Employee e = new Employee("Neha", "Sharma", 101, "Software Engineer");
        System.out.println(e.getFirstName() + " " + e.getLastName() + ", ID = " + e.getEmployeeId());
    }
}

// Program: Shape with getPerimeter()/getArea(); Circle overrides both
// file name should be ShapeCircle.java
class ShapeCircle {
    static class Shape { double getPerimeter() { return 0; } double getArea() { return 0; } }
    static class Circle extends Shape {
        double r;
        Circle(double r) { this.r = r; }
        @Override double getPerimeter() { return 2 * Math.PI * r; }
        @Override double getArea() { return Math.PI * r * r; }
    }
    public static void main(String[] args) {
        Shape c = new Circle(7);
        System.out.printf("Area = %.2f, Perimeter = %.2f%n", c.getArea(), c.getPerimeter());
    }
}

// Program: Vehicle class hierarchy: Truck, Car, Motorcycle (make, model, year, fuel type; efficiency, distance, max speed)
// file name should be VehicleHierarchy.java
class VehicleHierarchy {
    static abstract class Vehicle {
        String make, model, fuelType; int year;
        Vehicle(String make, String model, int year, String fuelType) {
            this.make = make; this.model = model; this.year = year; this.fuelType = fuelType;
        }
        double fuelEfficiency(double km, double litres) { return km / litres; }        // km per litre
        double distanceTraveled(double avgSpeed, double hours) { return avgSpeed * hours; }
        abstract double maxSpeed();
        void info() { System.out.println(year + " " + make + " " + model + " (" + fuelType + "), max speed " + maxSpeed() + " km/h"); }
    }
    static class Truck extends Vehicle {
        Truck(String mk, String md, int y, String f) { super(mk, md, y, f); }
        double maxSpeed() { return 110; }
    }
    static class Car extends Vehicle {
        Car(String mk, String md, int y, String f) { super(mk, md, y, f); }
        double maxSpeed() { return 180; }
    }
    static class Motorcycle extends Vehicle {
        Motorcycle(String mk, String md, int y, String f) { super(mk, md, y, f); }
        double maxSpeed() { return 160; }
    }
    public static void main(String[] args) {
        Vehicle[] v = { new Truck("Tata", "Prima", 2021, "Diesel"), new Car("Honda", "City", 2022, "Petrol"), new Motorcycle("Yamaha", "R15", 2023, "Petrol") };
        for (Vehicle x : v) {
            x.info();
            System.out.println("  Efficiency (300 km, 20 L): " + x.fuelEfficiency(300, 20) + " km/L");
            System.out.println("  Distance (60 km/h, 2.5 h): " + x.distanceTraveled(60, 2.5) + " km");
        }
    }
}

// Program: Employee class hierarchy: Manager, Developer, Programmer (bonus, performance report, manage projects)
// file name should be EmployeeHierarchy.java
class EmployeeHierarchy {
    static class Employee {
        String name, address, jobTitle; double salary;
        List<String> projects = new ArrayList<>();
        Employee(String name, String address, double salary, String jobTitle) {
            this.name = name; this.address = address; this.salary = salary; this.jobTitle = jobTitle;
        }
        double calculateBonus() { return salary * 0.05; }
        void generatePerformanceReport() { System.out.println("Report: " + name + " (" + jobTitle + ") performed satisfactorily. Bonus = " + calculateBonus()); }
        void manageProjects() { System.out.println(name + " handles projects: " + projects); }
        void addProject(String p) { projects.add(p); }
    }
    static class Manager extends Employee {
        Manager(String n, String a, double s) { super(n, a, s, "Manager"); }
        @Override double calculateBonus() { return salary * 0.20; }
        @Override void manageProjects() { System.out.println(name + " plans, assigns and tracks projects: " + projects); }
    }
    static class Developer extends Employee {
        Developer(String n, String a, double s) { super(n, a, s, "Developer"); }
        @Override double calculateBonus() { return salary * 0.10; }
    }
    static class Programmer extends Employee {
        Programmer(String n, String a, double s) { super(n, a, s, "Programmer"); }
        @Override double calculateBonus() { return salary * 0.08; }
        @Override void manageProjects() { System.out.println(name + " codes modules of projects: " + projects); }
    }
    public static void main(String[] args) {
        Employee[] list = {
            new Manager("Amit", "Delhi", 100000), new Developer("Sara", "Pune", 70000), new Programmer("John", "Mumbai", 50000)
        };
        for (Employee e : list) { e.addProject("Project-X"); e.generatePerformanceReport(); e.manageProjects(); }
    }
}

// Program: Example of super keyword (access parent's variable, call parent's constructor)
// file name should be SuperKeyword.java
class SuperKeyword {
    static class Parent {
        String color = "White";
        Parent() { System.out.println("Parent constructor"); }
    }
    static class Child extends Parent {
        String color = "Black";
        Child() { super(); System.out.println("Child constructor"); }
        void show() {
            System.out.println("Child color  = " + color);
            System.out.println("Parent color = " + super.color);
        }
    }
    public static void main(String[] args) { new Child().show(); }
}

// Program: Example of super function (calling parent's method with super.method())
// file name should be SuperFunction.java
class SuperFunction {
    static class Parent { void display() { System.out.println("Display from Parent"); } }
    static class Child extends Parent {
        @Override void display() {
            super.display();
            System.out.println("Display from Child");
        }
    }
    public static void main(String[] args) { new Child().display(); }
}

// Program: Example of method overriding
// file name should be MethodOverriding.java
class MethodOverriding {
    static class Bank { double getRateOfInterest() { return 0; } }
    static class SBI extends Bank { @Override double getRateOfInterest() { return 8.0; } }
    static class ICICI extends Bank { @Override double getRateOfInterest() { return 7.5; } }
    public static void main(String[] args) {
        System.out.println("SBI rate   : " + new SBI().getRateOfInterest());
        System.out.println("ICICI rate : " + new ICICI().getRateOfInterest());
    }
}

// Program: Example of dynamic method dispatch (runtime polymorphism)
// file name should be DynamicMethodDispatch.java
class DynamicMethodDispatch {
    static class A { void callMe() { System.out.println("Inside A"); } }
    static class B extends A { @Override void callMe() { System.out.println("Inside B"); } }
    static class C extends A { @Override void callMe() { System.out.println("Inside C"); } }
    public static void main(String[] args) {
        A ref = new A(); ref.callMe();
        ref = new B();   ref.callMe();   // decided at runtime
        ref = new C();   ref.callMe();
    }
}

// Program: Abstract class Animal with abstract sound(); Lion and Tiger implement it
// file name should be AbstractAnimalSound.java
class AbstractAnimalSound {
    static abstract class Animal { abstract void sound(); }
    static class Lion extends Animal { void sound() { System.out.println("Lion roars: Roarrr!"); } }
    static class Tiger extends Animal { void sound() { System.out.println("Tiger growls: Grrr!"); } }
    public static void main(String[] args) {
        new Lion().sound();
        new Tiger().sound();
    }
}

// Program: Abstract class Shape with calculateArea()/calculatePerimeter(); Circle and Triangle extend it
// file name should be AbstractShape.java
class AbstractShape {
    static abstract class Shape { abstract double calculateArea(); abstract double calculatePerimeter(); }
    static class Circle extends Shape {
        double r; Circle(double r) { this.r = r; }
        double calculateArea() { return Math.PI * r * r; }
        double calculatePerimeter() { return 2 * Math.PI * r; }
    }
    static class Triangle extends Shape {
        double a, b, c; Triangle(double a, double b, double c) { this.a = a; this.b = b; this.c = c; }
        double calculateArea() { double s = (a + b + c) / 2; return Math.sqrt(s * (s - a) * (s - b) * (s - c)); }
        double calculatePerimeter() { return a + b + c; }
    }
    public static void main(String[] args) {
        Shape[] s = { new Circle(5), new Triangle(3, 4, 5) };
        for (Shape x : s)
            System.out.printf("%s: area = %.2f, perimeter = %.2f%n", x.getClass().getSimpleName(), x.calculateArea(), x.calculatePerimeter());
    }
}

// Program: Abstract class BankAccount with deposit()/withdraw(); SavingsAccount and CurrentAccount extend it
// file name should be AbstractBankAccount.java
class AbstractBankAccount {
    static abstract class BankAccount {
        protected double balance;
        BankAccount(double b) { balance = b; }
        abstract void deposit(double amt);
        abstract void withdraw(double amt);
    }
    static class SavingsAccount extends BankAccount {
        SavingsAccount(double b) { super(b); }
        void deposit(double amt) { balance += amt; System.out.println("Savings deposit " + amt + " -> " + balance); }
        void withdraw(double amt) {
            if (amt > balance) System.out.println("Savings: insufficient balance");
            else { balance -= amt; System.out.println("Savings withdraw " + amt + " -> " + balance); }
        }
    }
    static class CurrentAccount extends BankAccount {
        double overdraft = 5000;
        CurrentAccount(double b) { super(b); }
        void deposit(double amt) { balance += amt; System.out.println("Current deposit " + amt + " -> " + balance); }
        void withdraw(double amt) {
            if (amt > balance + overdraft) System.out.println("Current: overdraft limit exceeded");
            else { balance -= amt; System.out.println("Current withdraw " + amt + " -> " + balance); }
        }
    }
    public static void main(String[] args) {
        BankAccount s = new SavingsAccount(1000), c = new CurrentAccount(1000);
        s.deposit(500); s.withdraw(2000);
        c.deposit(500); c.withdraw(3000);
    }
}

// Program: Abstract class Animal with eat() and sleep(); Lion, Tiger, Deer extend it
// file name should be AbstractAnimalEatSleep.java
class AbstractAnimalEatSleep {
    static abstract class Animal { abstract void eat(); abstract void sleep(); }
    static class Lion extends Animal {
        void eat() { System.out.println("Lion eats meat"); }
        void sleep() { System.out.println("Lion sleeps 20 hours a day"); }
    }
    static class Tiger extends Animal {
        void eat() { System.out.println("Tiger hunts and eats deer"); }
        void sleep() { System.out.println("Tiger sleeps in dense forest"); }
    }
    static class Deer extends Animal {
        void eat() { System.out.println("Deer eats grass"); }
        void sleep() { System.out.println("Deer sleeps lightly, always alert"); }
    }
    public static void main(String[] args) {
        Animal[] a = { new Lion(), new Tiger(), new Deer() };
        for (Animal x : a) { x.eat(); x.sleep(); }
    }
}

// Program: Abstract class Employee with calculateSalary()/displayInfo(); Manager and Programmer extend it
// file name should be AbstractEmployee.java
class AbstractEmployee {
    static abstract class Employee {
        String name;
        Employee(String name) { this.name = name; }
        abstract double calculateSalary();
        abstract void displayInfo();
    }
    static class Manager extends Employee {
        double basic, bonus;
        Manager(String n, double basic, double bonus) { super(n); this.basic = basic; this.bonus = bonus; }
        double calculateSalary() { return basic + bonus; }
        void displayInfo() { System.out.println("Manager    : " + name + ", salary = " + calculateSalary()); }
    }
    static class Programmer extends Employee {
        double hourlyRate; int hours;
        Programmer(String n, double rate, int hours) { super(n); hourlyRate = rate; this.hours = hours; }
        double calculateSalary() { return hourlyRate * hours; }
        void displayInfo() { System.out.println("Programmer : " + name + ", salary = " + calculateSalary()); }
    }
    public static void main(String[] args) {
        Employee[] e = { new Manager("Amit", 80000, 20000), new Programmer("Sara", 500, 160) };
        for (Employee x : e) x.displayInfo();
    }
}

// Program: Abstract class Shape3D with calculateVolume()/calculateSurfaceArea(); Sphere and Cube extend it
// file name should be AbstractShape3D.java
class AbstractShape3D {
    static abstract class Shape3D { abstract double calculateVolume(); abstract double calculateSurfaceArea(); }
    static class Sphere extends Shape3D {
        double r; Sphere(double r) { this.r = r; }
        double calculateVolume() { return 4.0 / 3 * Math.PI * r * r * r; }
        double calculateSurfaceArea() { return 4 * Math.PI * r * r; }
    }
    static class Cube extends Shape3D {
        double s; Cube(double s) { this.s = s; }
        double calculateVolume() { return s * s * s; }
        double calculateSurfaceArea() { return 6 * s * s; }
    }
    public static void main(String[] args) {
        Shape3D[] a = { new Sphere(3), new Cube(4) };
        for (Shape3D x : a)
            System.out.printf("%s: volume = %.2f, surface area = %.2f%n", x.getClass().getSimpleName(), x.calculateVolume(), x.calculateSurfaceArea());
    }
}

// Program: Abstract class Vehicle with startEngine()/stopEngine(); Car and Motorcycle extend it
// file name should be AbstractVehicleEngine.java
class AbstractVehicleEngine {
    static abstract class Vehicle { abstract void startEngine(); abstract void stopEngine(); }
    static class Car extends Vehicle {
        void startEngine() { System.out.println("Car engine started with push button"); }
        void stopEngine() { System.out.println("Car engine stopped"); }
    }
    static class Motorcycle extends Vehicle {
        void startEngine() { System.out.println("Motorcycle engine started with kick/self start"); }
        void stopEngine() { System.out.println("Motorcycle engine stopped"); }
    }
    public static void main(String[] args) {
        Vehicle[] v = { new Car(), new Motorcycle() };
        for (Vehicle x : v) { x.startEngine(); x.stopEngine(); }
    }
}

// Program: Abstract class Person with eat()/exercise(); Athlete and LazyPerson extend it
// file name should be AbstractPerson.java
class AbstractPerson {
    static abstract class Person { abstract void eat(); abstract void exercise(); }
    static class Athlete extends Person {
        void eat() { System.out.println("Athlete eats a high-protein balanced diet"); }
        void exercise() { System.out.println("Athlete trains for 3 hours daily"); }
    }
    static class LazyPerson extends Person {
        void eat() { System.out.println("LazyPerson eats junk food on the couch"); }
        void exercise() { System.out.println("LazyPerson exercises only the remote control"); }
    }
    public static void main(String[] args) {
        Person[] p = { new Athlete(), new LazyPerson() };
        for (Person x : p) { x.eat(); x.exercise(); }
    }
}

// Program: Abstract class Instrument with play()/tune(); Glockenspiel and Violin extend it
// file name should be AbstractInstrument.java
class AbstractInstrument {
    static abstract class Instrument { abstract void play(); abstract void tune(); }
    static class Glockenspiel extends Instrument {
        void play() { System.out.println("Glockenspiel: striking bars with mallets"); }
        void tune() { System.out.println("Glockenspiel: adjusting the metal bars' pitch"); }
    }
    static class Violin extends Instrument {
        void play() { System.out.println("Violin: drawing the bow across the strings"); }
        void tune() { System.out.println("Violin: turning the pegs to tune strings"); }
    }
    public static void main(String[] args) {
        Instrument[] i = { new Glockenspiel(), new Violin() };
        for (Instrument x : i) { x.tune(); x.play(); }
    }
}

// Program: Abstract class Shape2D with draw()/resize(); Rectangle and Circle extend it
// file name should be AbstractShape2D.java
class AbstractShape2D {
    static abstract class Shape2D { abstract void draw(); abstract void resize(double factor); }
    static class Rectangle extends Shape2D {
        double w = 10, h = 5;
        void draw() { System.out.println("Drawing Rectangle " + w + " x " + h); }
        void resize(double f) { w *= f; h *= f; }
    }
    static class Circle extends Shape2D {
        double r = 4;
        void draw() { System.out.println("Drawing Circle of radius " + r); }
        void resize(double f) { r *= f; }
    }
    public static void main(String[] args) {
        Shape2D[] s = { new Rectangle(), new Circle() };
        for (Shape2D x : s) { x.draw(); x.resize(2); x.draw(); }
    }
}

// Program: Abstract class Bird with fly()/makeSound(); Eagle and Hawk extend it
// file name should be AbstractBird.java
class AbstractBird {
    static abstract class Bird { abstract void fly(); abstract void makeSound(); }
    static class Eagle extends Bird {
        void fly() { System.out.println("Eagle soars at high altitude"); }
        void makeSound() { System.out.println("Eagle screeches"); }
    }
    static class Hawk extends Bird {
        void fly() { System.out.println("Hawk glides and dives swiftly on prey"); }
        void makeSound() { System.out.println("Hawk makes a sharp 'kee-kee' call"); }
    }
    public static void main(String[] args) {
        Bird[] b = { new Eagle(), new Hawk() };
        for (Bird x : b) { x.fly(); x.makeSound(); }
    }
}

// Program: Abstract class GeometricShape with area()/perimeter(); Triangle and Square extend it
// file name should be AbstractGeometricShape.java
class AbstractGeometricShape {
    static abstract class GeometricShape { abstract double area(); abstract double perimeter(); }
    static class Triangle extends GeometricShape {
        double a, b, c;
        Triangle(double a, double b, double c) { this.a = a; this.b = b; this.c = c; }
        double area() { double s = (a + b + c) / 2; return Math.sqrt(s * (s - a) * (s - b) * (s - c)); }
        double perimeter() { return a + b + c; }
    }
    static class Square extends GeometricShape {
        double side; Square(double s) { side = s; }
        double area() { return side * side; }
        double perimeter() { return 4 * side; }
    }
    public static void main(String[] args) {
        GeometricShape[] g = { new Triangle(6, 8, 10), new Square(5) };
        for (GeometricShape x : g)
            System.out.printf("%s: area = %.2f, perimeter = %.2f%n", x.getClass().getSimpleName(), x.area(), x.perimeter());
    }
}
