import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App extends JFrame{
    private JPanel pnlMain;
    private JRadioButton rbCustomer;
    private JRadioButton rbClerk;
    private JRadioButton rbManager;
    private JTextField tfName;
    private JTextArea taPersons;
    private JButton btnSave;
    private JTextField tfAge;
    private JTextField tfMonths;
    private JTextField tfSalary;
    private JButton btnClear;
    private JTextField tfLoad;
    private JButton btnLoad;
    private JButton btnSayHi;
    private JButton btnSavePerson;
    private JButton btnLoadPerson;
    private JButton btnReward;

    private List<Person> persons;

    public App() {
        persons = new ArrayList<>();
        // TODO add implementations for all milestones here
        taPersons.setEditable(false);

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    boolean selected = false;
                    if(rbCustomer.isSelected()) {
                        selected = true;
                        String name = tfName.getText();
                        int age = Integer.parseInt(tfAge.getText());
                        Person p = new Customer(name, age);
                        persons.add(p);
                        taPersons.append(String.valueOf(persons.indexOf(p) + 1) + ". Customer - " + name + "(" + age + ")" + "\n");
                        if (age < 0) {
                            throw new IllegalArgumentException("Age cannot be less than 0");
                        }
                            if(name.equals("")) {
                                throw new IllegalArgumentException("Please input the name");
                            }
                        }

                    if(rbClerk.isSelected()) {
                        selected = true;
                        String name = tfName.getText();
                        int age = Integer.parseInt(tfAge.getText());
                        double salary = Double.parseDouble(tfSalary.getText());
                        int monthsWorked = Integer.parseInt(tfMonths.getText());
                        Person p = new Clerk(name, age, monthsWorked, salary);
                        persons.add(p);
                        taPersons.append(String.valueOf(persons.indexOf(p) + 1) + ". Clerk - " + name + "(" + age + ")" + "\n");
                        if (age < 0 || monthsWorked < 0 || salary < 0) {
                            throw new IllegalArgumentException("Please enter valid input");
                        }
                        if (name.equals("")) {
                            throw new IllegalArgumentException("Please input the name");
                        }

                    }
                    if(rbManager.isSelected()){
                        selected = true;
                        String name = tfName.getText();
                        int age = Integer.parseInt(tfAge.getText());
                        double salary = Double.parseDouble(tfSalary.getText());
                        int monthsWorked = Integer.parseInt(tfMonths.getText());
                        Person p = new Manager(name,age,monthsWorked,salary);
                        persons.add(p);
                        taPersons.append(String.valueOf(persons.indexOf(p)+1)+". Manager - "+ name + "(" + age + ")"+"\n");
                        if (age < 0 || monthsWorked < 0 || salary < 0) {
                            throw new IllegalArgumentException("Please enter valid input");
                        }
                        if (name.equals("")) {
                            throw new IllegalArgumentException("Please input the name");
                        }
                    }
                    if(selected == false){
                        throw new IOException("Please select a person");
                    }
                    tfName.setText("");
                    tfLoad.setText("");
                    tfAge.setText("");
                    tfMonths.setText("");
                    tfSalary.setText("");

                }catch (NumberFormatException except){
                    JOptionPane.showMessageDialog(pnlMain,"Please enter valid input");
                }catch(IllegalArgumentException except) {
                    JOptionPane.showMessageDialog(pnlMain, except);
                }catch(IOException except){
                    JOptionPane.showMessageDialog(pnlMain,except);
                }
            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfName.setText("");
                tfAge.setText("");
                tfMonths.setText("");
                tfSalary.setText("");
                tfLoad.setText("");
            }
        });

        btnLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int number = Integer.parseInt(tfLoad.getText());
                    int counter = 0;
                    if(number < 1 || number > persons.size()) {
                        throw new ArrayIndexOutOfBoundsException("The list is empty or out of bounds");
                    }
                    for (Person p : persons) {
                        counter++;
                        if (counter == number) {
                            tfName.setText(p.getName());
                            tfAge.setText(Integer.toString(p.getAge()));
                            if (p instanceof Customer) {
                                rbCustomer.setSelected(true);
                                tfMonths.setText("");
                                tfSalary.setText("");
                            }
                            if (p instanceof Employee) {
                                Employee person = (Employee) p;
                                tfMonths.setText(Integer.toString(person.getMonths_worked()));
                                tfSalary.setText(Double.toString(person.getSalary()));
                                if (p instanceof Clerk) {
                                    rbClerk.setSelected(true);
                                }
                                if (p instanceof Manager) {
                                    rbManager.setSelected(true);
                                }
                            }
                        }
                    }
                }catch(IndexOutOfBoundsException except) {
                    JOptionPane.showMessageDialog(pnlMain, except.getMessage());
                }
                catch(NumberFormatException except) {
                    JOptionPane.showMessageDialog(pnlMain, "Please enter a number");
                }
            }
        });

        btnSayHi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Person p : persons) {
                    if (p instanceof Customer) {
                        System.out.print(p.toString()+"\n");
                    }
                    if (p instanceof Clerk) {
                        System.out.print(p.toString()+"\n");
                    }
                    if (p instanceof Manager) {
                        System.out.print(p.toString()+"\n");
                    }
                }
            }
        });

        btnReward.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(persons.size()==0){
                        throw new IllegalArgumentException("The list is empty");
                    }
                    int number = Integer.parseInt(tfLoad.getText());
                    if(number < 1 || number > persons.size()) {
                        throw new ArrayIndexOutOfBoundsException("The list is empty or out of bounds");
                    }
                    Person p = persons.get(number-1);
                    if(p instanceof Employee) {
                        Employee person = (Employee) p;
                        if(person.getMonths_worked() == 0) {
                            throw new ArithmeticException("Should work more than a month");
                        }
                        JOptionPane.showMessageDialog(pnlMain,  person.getName() + "'s reward is " + "₱" + String.format("%.2f", person.thirteenthMonth()));

                    } else {
                        throw new IllegalArgumentException("Is a customer");
                    }
                } catch(NumberFormatException except) {
                    JOptionPane.showMessageDialog(pnlMain, "Please enter valid input");
                } catch (ArithmeticException | IllegalArgumentException except) {
                    JOptionPane.showMessageDialog(pnlMain, except.getMessage());
                }catch (ArrayIndexOutOfBoundsException except){
                    JOptionPane.showMessageDialog(pnlMain,except.getMessage());
                }
            }
        });

    }


    public static void main(String[] args) {
        // add here how to make GUI visible
        App app = new App();
        app.setContentPane(app.pnlMain);
        app.setVisible(true);
        app.setSize(600,400);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    static void giveReward(int n) {

    }
}
