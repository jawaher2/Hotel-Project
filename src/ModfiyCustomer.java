import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by shaker on 04/01/2021.
 */
public class ModfiyCustomer {
    private JButton modifyButton;
    private JTextField id;
    private JTextField l;
    private JTextField age;
    private JTextField sex;
    private JTextField ph;
    private JTextField email;
    public JPanel modfiy;
    private JTextField f;
    Collection c= new Collection();

    public ModfiyCustomer() {
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i= Integer.parseInt(id.getText());
                int p= Integer.parseInt(ph.getText());
                int a= Integer.parseInt(age.getText());
                c.editcustomer(f.getText(),l.getText(),i,sex.getText(),a,email.getText(),p);
            }
        });
    }
}
