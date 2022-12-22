import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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


        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rbCustomer.isSelected()){
                    String name = tfName.getText();
                    int age = Integer.parseInt(tfAge.getText());
                    Person p = new Customer(name,age);
                    persons.add(p);
                    taPersons.append(String.valueOf(persons.indexOf(p)+1)+". Customer - "+ name + "(" + age + ")"+"\n");

                }
                if(rbClerk.isSelected()){
                    String name = tfName.getText();
                    int age = Integer.parseInt(tfAge.getText());
                    double salary = Double.parseDouble(tfSalary.getText());
                    int monthsWorked = Integer.parseInt(tfMonths.getText());
                    Person p = new Clerk(name,age,monthsWorked,salary);
                    persons.add(p);
                    taPersons.append(String.valueOf(persons.indexOf(p)+1)+". Clerk - "+ name + "(" + age + ")"+"\n");

                }

                if(rbManager.isSelected()){
                    String name = tfName.getText();
                    int age = Integer.parseInt(tfAge.getText());
                    double salary = Double.parseDouble(tfSalary.getText());
                    int monthsWorked = Integer.parseInt(tfMonths.getText());
                    Person p = new Manager(name,age,monthsWorked,salary);
                    persons.add(p);
                    taPersons.append(String.valueOf(persons.indexOf(p)+1)+". Manager - "+ name + "(" + age + ")"+"\n");

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
