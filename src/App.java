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
        taPersons.setEnabled(false);

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
                }catch (NumberFormatException e0){
                    JOptionPane.showMessageDialog(pnlMain,"Please enter valid input");
                }catch(IllegalArgumentException e1) {
                    JOptionPane.showMessageDialog(pnlMain, e1);
                }catch(IOException e2){
                    JOptionPane.showMessageDialog(pnlMain,e2);
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
