package Engine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;




public class GUI extends JPanel implements  ActionListener
{
    Player p1 = new humanPlayer(Color.WHITE);
    Player p2 = new humanPlayer(Color.BLACK);

    //chessGame game = new chessGame(p1.toString(), p2.toString());

    Board bo = new Board(p1, p2);
    //String p1 = "Human";
    //String p2 = "Human";


    static  int WIDTH = 640;
    static  int HEIGHT = 640;
    static  int DIMENTION = 8;
    static  int    TILE_SIZE = 30;//HEIGHT /DIMENTION ;
    static  int   MAX_FPS = 150;
    static String [] pieces = {"wr","wb","wn","wQ","wK","wp","br","bn","bb","bQ","bK","bp"};
    static Graphics2D g2D;
    Timer timer;
    Graphics g;

    ImageIcon image;
    JFrame frame = new JFrame();
    JTextField textField = new JTextField();
    private JTextField Input = new JTextField();
    GUI()
    {

        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
    }
    void chessGame() {



        GUI Panel = new GUI();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH,HEIGHT);
        ImageIcon image = new ImageIcon("images/67.png");
        //this.addMouseListener(this);
        frame.add(Panel);
        frame.setIconImage(image.getImage());

        textField.setPreferredSize( new Dimension(100,20));
        textField.setLocation(40,400);
        //frame.add(textField);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);




    }




    public void paint(Graphics g)
    {
        /*
        g.fillRect(0,0,30,30);
        g.setColor(java.awt.Color.RED);
        g.setFont(Font.getFont(Font.SANS_SERIF));
        Font cuur = g.getFont();
        Font newF = cuur.deriveFont((cuur.getSize())*2F);

        chessGame ch = new chessGame();
        g.drawString(ch.getTurn(),40 , 40);

         */
        super.paintComponents(g);
        g2D = (Graphics2D) g;


        for (int row = 0;  row < 9;  row++ ) {
            for (int col = 0;  col < 10;  col++ ) {
                int x = 30*col;
                int y = 30*row;
                if ( (row % 2) == (col % 2) )
                    g2D.setPaint(java.awt.Color.red);
                else
                    g2D.setPaint(java.awt.Color.CYAN);
                g.fillRect(x+150,y+150,30,30);
            }
        }


        drawImages();


    }


    private void drawImages()
    {

        int p = 0;
        String ptoS ;
        String[][] b = Board.arr;
        for (int r = 0 ; r <9;r++)
        {
            for (int c = 0; c <10; c++)
            {
                //String [][] b = chessEngine.board();
                String piece = b[r][c];

                if (piece != "w" || piece != "-" )

                {
                    for (String p2 : pieces)
                    {
                        ptoS = String.valueOf(piece);
                        p += 1;
                        image = new ImageIcon("images/" + ptoS + ".png");
                        g2D.drawImage(image.getImage(), 150+c * TILE_SIZE, 150+r * TILE_SIZE, TILE_SIZE, TILE_SIZE, null);
                        repaint();
                    }
                }
            }
        }

    }


    @Override
    public void actionPerformed(ActionEvent e)
    {


        int p = 0;
        String ptoS ;
        String[][] b = Board.arr;
        for (int r = 0 ; r <9;r++)
        {
            for (int c = 0; c <10; c++)
            {
                //String [][] b = chessEngine.board();
                String piece = b[r][c];

                if (piece != "w" || piece != "-" )

                {
                    for (String p2 : pieces)
                    {
                        ptoS = String.valueOf(piece);
                        p += 1;
                        image = new ImageIcon("images/" + ptoS + ".png");
                        g2D.drawImage(image.getImage(), c * TILE_SIZE, r * TILE_SIZE, TILE_SIZE, TILE_SIZE, null);
                        repaint();
                    }
                }
            }
        }



    }


}
