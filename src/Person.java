public abstract class Person {
    // TODO implement Person and its subclasses in other Java files

    String name;
    int age;
    public Person(String name, int age){
        this.name = name;
        this.age =age;
    }

    public String getName(){
       return name;
    }

    public int getAge(){
        return age;
    }

    @Override
    public String toString() {
        return "Hello, my name is " + name;
    }


}

    abstract class Employee extends Person{
    int months_worked;
    double salary;

    public Employee(String name, int age, int months_worked, double salary) {
        super(name, age);
        this.months_worked = months_worked;
        this.salary = salary;
    }
        public int getMonths_worked(){
            return months_worked;
        }
        public double getSalary(){
            return salary;
        }
        public double thirteenthMonth(){
            return (double) salary/(double) (12.0/months_worked);
        }
        public String toString() {
            return super.toString();
        }

}



class Customer extends Person{
    public Customer(String name, int age) {
        super(name, age);
    }
    public String toString() {
        return super.toString();
    }
}

class Clerk extends Employee {

    public Clerk(String name, int age, int months_worked, double salary) {
        super(name, age, months_worked,salary);
    }
    @Override
    public String toString() {
        return super.toString() + " How may I help you?";
    }
}

class Manager extends Employee {
    public Manager(String name, int age, int months_worked, double salary) {
        super(name, age, months_worked, salary);
    }
    public String toString() {
        return super.toString();
    }
}
