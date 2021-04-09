import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by shaker on 04/01/2021.
 */
public class AddCustomer {
    private JButton Button;
    private JTextField id;
    private JTextField f;
    private JTextField l;
    private JTextField age;
    private JTextField sex;
    private JTextField ph;
    private JTextField email;
    public JPanel add;
    Collection c = new Collection();

    public AddCustomer() {
        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i= Integer.parseInt(id.getText());
                int p= Integer.parseInt(ph.getText());
                int a= Integer.parseInt(age.getText());
                c.addcustomer(f.getText(),l.getText(),i,sex.getText(),a,email.getText(),p);
            }
        });
    }
}
