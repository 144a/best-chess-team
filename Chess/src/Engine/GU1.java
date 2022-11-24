package Engine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

public class GU1 extends JPanel implements  ActionListener {
    Player p1 = new humanPlayer(Color.WHITE);
    Player p2 = new humanPlayer(Color.BLACK);


    Board bo = new Board(p1, p2);


    static int WIDTH = 740;
    static int HEIGHT = 740;
    static int DIMENTION = 8;
    static int TILE_SIZE = 40;//HEIGHT /DIMENTION ;
    static int MAX_FPS = 150;
    static String[] pieces = {"wr", "wb", "wn", "wQ", "wK", "wp", "br", "bn", "bb", "bQ", "bK", "bp"};
    static Graphics2D g2D;
    Timer timer;
    Graphics g;

    ImageIcon image;
    GU1() {

        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }



    public void paint(Graphics g) {
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


        for (int row = 0; row < 9; row++)
        {
            for (int col = 0; col < 10; col++)
            {
                int x = 40 * col;
                int y = 40 * row;
                if ((row % 2) == (col % 2))
                    g2D.setPaint(java.awt.Color.red);
                else
                    g2D.setPaint(java.awt.Color.CYAN);
                g.fillRect(x + 120, y , 40, 40);
            }
        }
        //drawImages(); The method call was removed because the board instance on line 72 returned "null" during the final project test.The code for some reason runs fine locally and the instance return the string array.
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
                        image = new ImageIcon("image/" + ptoS + ".png");
                        g2D.drawImage(image.getImage(), 120+c * TILE_SIZE, r * TILE_SIZE, TILE_SIZE, TILE_SIZE, null);
                        repaint();
                    }
                }
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
