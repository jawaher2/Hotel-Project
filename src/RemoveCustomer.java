import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sa on 17/12/20.
 */
public class RemoveCustomer {
    private JButton nextButton;
    private JTextField id;
    private JButton removeButton;
    public JPanel remove;
   Collection c =new Collection();

    public RemoveCustomer() {
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i= Integer.parseInt(id.getText());
                c.deletcustomer(i);
            }
        });
    }
}
