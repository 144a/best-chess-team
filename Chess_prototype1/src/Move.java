import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
// WHEN THE  "mouseClicked" METHOD CALLS THE map method...
// in  THIS CLASS  THE STRING IN THE FIRST CLICK LOCATION WILL...
// BE REPLACED WITH THE "--" AND THE SECOND CLICK LOCATION WILL...
// BE REPLACED WITH WHAT WAS  ORIGINALLY IN  THE FIRST CLICK LOCATION
// THE

public class Move
{

    static HashMap<String, Integer> ranksToRows = new HashMap<>();
    static HashMap<Integer, String> RowsToranks = new HashMap<>();

    static HashMap<String, Integer> filesToCols = new HashMap<>();
    static HashMap<Integer, String> ColsTofiles = new HashMap<>();
    static  int startRow; static  int startCol;
    static  int endRow;  static  int endCol;

    static int count = 0;


    static chessEngine cE = new chessEngine();
    public  static String[][] map(int[] startSq, int[] endSq )

    {

        count++;
        List<int[]> reSq = new ArrayList<int[]>(); // add parameters into a list
        reSq.add(startSq); reSq.add(endSq);
        int startRow = startSq[0]; int startCol = startSq[1];
        int endRow = endSq[0]; int endCol = endSq[1];

       // where board instance is created
        String[][] newborad = new String[cE.board().length][];
        for (int i = 0; i < cE.board().length; i++)
        {
            newborad[i] = cE.board()[i].clone();
        }

        String pieceMoved = newborad[startRow][startCol];
        String pieceCaptured =newborad[endRow][endCol];


// where the string replacing happens
        System.out.println("THE piece moved was "+ pieceMoved);
         String s = newborad[startSq[0]][startSq[1]];
         s= "--";
        newborad[startSq[0]][startSq[1]] = s;
         String e =newborad[endSq[0]][endSq[1]];
          e = pieceMoved;
        newborad[endSq[0]][endSq[1]] = e;


        //return board;
        return newborad;
    }

}



