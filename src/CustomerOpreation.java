import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by shaker on 04/01/2021.
 */
public class CustomerOpreation {
    private JButton removeButton;
    private JButton addButton;
    private JButton modifyButton;
    private JButton searchButton;
    private JPanel chose;


    public CustomerOpreation() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("AddCustomer");
                frame.setContentPane(new AddCustomer().add);
                frame.setSize(600,500);
                frame.setLocation(400,100);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);

            }
        });

        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("CustomerOpreation");
                frame.setContentPane(new Modfiy().modfiy);
                frame.setSize(600,500);
                frame.setLocation(400,100);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("CustomerOpreation");
                frame.setContentPane(new CustomerInformation().infromation);
                frame.setSize(600,500);
                frame.setLocation(400,100);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }});

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("CustomerOpreation");
                frame.setContentPane(new RemoveCustomer().remove);
                frame.setSize(600,500);
                frame.setLocation(400,100);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("CustomerOpreation");
        frame.setContentPane(new CustomerOpreation().chose);
        frame.setSize(600,500);
        frame.setLocation(400,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
