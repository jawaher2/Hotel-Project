import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by shaker on 04/01/2021.
 */
public class CustomerInformation {
    private JLabel ooo;
    public JPanel infromation;
    private JTextField id;
    private JButton serachButton;
    private JLabel f;
    private JLabel l;
    private JLabel age;
    private JLabel g;
    private JLabel ph;
    private JLabel em;
    private JPanel idText;
    Collection c=new Collection();


    public CustomerInformation() {
        serachButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customer s=c.searchcustomer(Integer.parseInt(id.getText()));
      ooo.setText(s.getIdcustomers()+"");
      f.setText(s.getFirstName()+"");
      l.setText(s.getLastName()+"");
     age.setText(s.getAge()+"");
     g.setText(s.getSex()+"");
     ph.setText(s.getPhone_number()+"");
    em.setText(s.getEmail()+"");

            }
        });

    }


}

