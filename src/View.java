import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private JFrame mainFrame;
    protected JTextField firstPoli;
    protected JTextField secondPoli;
    protected JTextField resultPoli;
    protected JButton additionButton;
    protected JButton subtractionButton;
    protected JButton multiplicationButton;
    protected JButton divisionButton;
    protected JButton derivativeButton;


    private JLabel label0;
    private JLabel label1;
    private JLabel label2;


    private JPanel panel0;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel;


    public View(){
        mainFrame=new JFrame("Polynomial Calculator");
        firstPoli=new JTextField(55);
        secondPoli=new JTextField(55);
        resultPoli=new JTextField(55);
        resultPoli.setEditable(false);
        additionButton=new JButton("Addition");
        subtractionButton=new JButton("Subtraction");
        multiplicationButton=new JButton("Multiplication");
        divisionButton=new JButton("Division");
        derivativeButton=new JButton("Derivative");
        label0=new JLabel("Primul polinom : ");
        label1=new JLabel("Al doilea polinom : ");
        label2=new JLabel("Rezultat : ");
        panel0=new JPanel();
        panel1=new JPanel();
        panel2=new JPanel();
        panel3=new JPanel();
        panel=new JPanel();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1000,600);
        panel0.add(label0);
        panel0.add(firstPoli);
        panel0.setLayout(new FlowLayout());
        panel1.add(label1);
        panel1.add(secondPoli);
        panel1.setLayout(new FlowLayout());
        panel2.add(additionButton);
        panel2.add(subtractionButton);
        panel2.add(multiplicationButton);
        panel2.add(divisionButton);
        panel2.add(derivativeButton);
        panel2.setLayout(new FlowLayout());
        panel3.add(label2);
        panel3.add(resultPoli);
        panel3.setLayout(new FlowLayout());
        panel.add(new JLabel("Introduceti polinoamele :"));
        panel.add(panel0);
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel0.setBackground(Color.magenta);
        panel1.setBackground(Color.magenta);
        panel2.setBackground(Color.magenta);
        panel3.setBackground(Color.magenta);
        mainFrame.setContentPane(panel);
        mainFrame.setVisible(true);

    }


    void additionListener(ActionListener actionListener)
    {
        additionButton.addActionListener(actionListener);
    }
    void subtractionListener(ActionListener actionListener){
        subtractionButton.addActionListener(actionListener);
    }
    void divisionListener(ActionListener actionListener){ divisionButton.addActionListener(actionListener); }
    void derivativeListener(ActionListener actionListener){ derivativeButton.addActionListener(actionListener); }
    void multiplicationListener(ActionListener actionListener){ multiplicationButton.addActionListener(actionListener); }
}
