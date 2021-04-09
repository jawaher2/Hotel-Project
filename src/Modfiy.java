import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by shaker on 04/01/2021.
 */
public class Modfiy {
    private JButton goButton;
    private JTextField id;
    public JPanel modfiy;

    public Modfiy() {
        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("CustomerOpreation");
                frame.setContentPane(new ModfiyCustomer().modfiy);
                frame.setSize(600,500);
                frame.setLocation(400,100);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
