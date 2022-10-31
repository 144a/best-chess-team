import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Array;
import java.util.*;
import java.util.List;
import java.util.Timer;
/*

                THIS IS WHERE THE MOUSE CLICKING FUNCTIONALITY IS IMPLEMENTED



*/
public class chessGameFrames extends JFrame implements MouseListener
{
static  int WIDTH = 512;
static  int HEIGHT = 512;
static  int DIMENTION = 8;
static  int    TILE_SIZE =HEIGHT /DIMENTION ;
     static   String[][] Thismap;
chessPanel Panel;
//
chessGameFrames()
   {

       Panel = new chessPanel();


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setSize(WIDTH,HEIGHT);
       ImageIcon image = new ImageIcon("images/67.png");
        this.addMouseListener(this);
        this.add(Panel);
        this.setIconImage(image.getImage());

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);


   }
public int[] first (int x , int y) // FIRST CLICK COOR
{
    int [] FL ={x,y};
    return FL;
}
    public int[] sec (int x , int y) // SECOND CLICK COOR
    {
        int [] SC ={x,y};
        return SC;
    }

static int counter = 0 ;
     // THE USER USED THREE MOUSE CLICKS TO PERFORM AN ACTION
    // THE LOCATION OF THE FIRST 2 CLICKS WILL BE ENTERED INTO
    // THE LIST CALLED "playClicks"
    // the THIRD CLICK REMOVES ELEMENTS IN "playClicks" LIST
    static  List<int[]> playerClicks= new ArrayList<int[]>() ;

    @Override
    public void mouseClicked(MouseEvent e)
    {

        counter += 1; // COUNT NUMBER OF TIME THIS FUNCTIONS IS CALLED...
                    // NUMBER OF TIMES USER HAS CLICK
        int x=e.getX(); // GETS X COORDINATE OF MOUSE-CLICK
        int y=e.getY();  // GETS Y COORDINATE OF MOUSE-CLICK
        int [] Location ={x,y};
        //System.out.println(x+","+y);

        int col = Location[0]/TILE_SIZE;// TRANSLATES X -COORDINATE .....
                                        // TO BOARD (TILE)COORDINATES
        int row =Location[1]/TILE_SIZE;// TRANSLATES Y -COORDINATE ......
                                        // TO BOARD (TILE)COORDINATES

        int [] sqSelected = new int[0];
        sqSelected = new int[]{row, col};

        // WHEN THE USER FIRST CLICKS ON A TILE
        // THE "first" method on line 45 will be called.
        // THE BOARD COORDINATES OF THAT CLICK WILL BE ENTERED '
        // TO "first"'s parameters AND ADDED TO A LIST CREATED IN "first"
        if (counter == 1 )
        {

            playerClicks.add((first(row,col)))  ;


                System.out.println("CLICK 1 : YOU CLICKED "+Arrays.toString( playerClicks.get(0 )));

        }
        // WHEN THE USER SECOND CLICKS ON A TILE
        // THE "sec" method on line 50 will be called.
        // THE BOARD COORDINATES OF THAT CLICK WILL BE ENTERED '
        // TO "sec"'s parameters AND ADDED TO A ARRAY CREATED IN "sec"
        // HERE THE "map" method in the Move class is called...
        // THE FIRST CLICK Functions as the selection click
        // AND THE SECOND CLICK ACTS AS THE END DESTINATION CLICK.

        if (counter == 2)
        {

            playerClicks.add((sec(row,col)))  ;
            //System.out.println("size of list : "+playerClicks.size());
             Move move = new Move();
            move.map(playerClicks.get(0), playerClicks.get(1));
            //System.out.println(playerClicks.get(0)+""+playerClicks.get(1)+"");
            for(int i=1; i < playerClicks.size(); i++){
                System.out.println(" CLICK 2: YOU CLICKED "+Arrays.toString( playerClicks.get(i) ));
            }

            // this prints out the board to the console
            for(String prx[] :move.map(playerClicks.get(0), playerClicks.get(1))) {
                System.out.println("PRINT BOARD" + Arrays.deepToString(prx));

                //System.out.println("PRINT BOARD" + Arrays.deepToString(move.map(playerClicks.get(0), playerClicks.get(1))));
            }
            // Thismap = move.map(playerClicks.get(0), playerClicks.get(1));
             Thismap = move.map(playerClicks.get(0), playerClicks.get(1));
            System.out.println();

        }

        if (counter > 2)
        {
            //sqSelected =null;
            System.out.println("---------\t THIS IS THE THIRD CLICK ---------");
            System.out.println("---------\t THIS IS THE THIRD CLICK ---------");
            counter = 0;
            playerClicks.clear();
       }
        for(int[] array : playerClicks) {

          //  System.out.println("Player cl :"+Arrays.toString(array));
        }
        //System.out.println("sqSelected :" + Arrays.toString(sqSelected));
        System.out.println();


    }



    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
