package Engine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;


public class GU2 extends JPanel implements  ActionListener {
    Button b = new Button("Sub");

    JTextField textArea = new JTextField();

    String Genter ;
    humanPlayer hp = new humanPlayer(Color.WHITE);
    GU2()
    {

        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        textArea.setText(Genter);
        textArea.setLocation(250, 250);
        textArea.setPreferredSize(new Dimension(100, 20));
        b.addActionListener(this);


    }
    public String enterS()
    {
        String re;
        re = Genter;
        return re;
    }



    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == b)
        {
         Genter = textArea.getText();
            System.out.println( textArea.getText());
            humanPlayer hp = new humanPlayer(Color.WHITE);
            //hp.userin = textArea.getText();
            //hp.enter = Genter;
        }

    }
}
