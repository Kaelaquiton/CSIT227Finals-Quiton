public abstract class Person {
    // TODO implement Person and its subclasses in other Java files

    String name;
    int age;
    public Person(String name, int age){
        this.name = name;
        this.age =age;
    }

    public String getName(String name){
       return name;
    }


    public int getAge(int age){
        return age;
    }


    @Override
    public String toString() {
        return "Hello, my name is " + name;
    }

    public class Employee extends Person{
        int months_worked;
        int salary;

        public Employee(String name, int age) {
            super(name, age);
        }

        public String toString() {
            return super.toString();
        }
        public double thirteenthMonth(){
            salary = salary / (12 / months_worked);
            return salary;
        }
    }

    public class Customer extends Person{
        public Customer(String name, int age) {
            super(name, age);
        }
        public String toString() {
            return super.toString();
        }
    }

    public class Clerk extends Employee{
        public Clerk(String name, int age) {
            super(name, age);
        }
        @Override
        public String toString() {
            return super.toString() + " How may I help you?";
        }
    }

    public class Manager extends Employee{
        public Manager(String name, int age) {
            super(name, age);
        }
        public String toString() {
            return super.toString();
        }
    }


}
