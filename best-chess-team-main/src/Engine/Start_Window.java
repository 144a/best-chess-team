package Engine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start_Window extends JFrame implements ActionListener
{
    static  int WIDTH = 640;
    static  int HEIGHT = 640;
    Start_Window start;
    JButton Player1;
    JButton Player2;
    JFrame frame = new JFrame();
    Graphics g;
    Start_Window()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH,HEIGHT);
        frame.setLayout(null);

        Player1 = new JButton();
        Player1.setText("Player1");
        Player1.setSize(100,50);
        Player1.setFocusable(false);
        Player1.setLocation(100, 200);
        Player1.addActionListener(this);

        Player2 = new JButton();
        Player2.setText("Player2");
        Player2.setSize(100,50);
        Player2.setFocusable(false);
        Player2.setLocation(400, 200);
        Player2.addActionListener(this);

        frame.add(Player1);
        frame.add(Player2);
        frame.setVisible(true);

    }

    /*
    void chessGame() {


        GUI Panel = new GUI();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH,HEIGHT);
        ImageIcon image = new ImageIcon("images/67.png");
        //this.addMouseListener(this);
        this.add(Panel);
        this.setIconImage(image.getImage());

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == Player1)
        {
            frame.dispose();
            //Start_Window win = new Start_Window();


            chessGame game = new chessGame("Human", "Human");
            GUI G = new GUI();
            G.chessGame();


            game.runGame();
            //chessGame();


        }
    }
}
