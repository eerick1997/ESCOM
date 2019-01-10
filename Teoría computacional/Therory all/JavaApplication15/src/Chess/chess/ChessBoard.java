package Chess.chess;

import Chess.forAutomaton.Path;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ChessBoard implements Runnable{

    private JFrame jframe;
    private JButton[] square = new JButton[9];
    private ImageIcon imageIcon = new ImageIcon("king.png");
    private ArrayList<String> list;
    
    public ChessBoard(Path path){
        list = path.decode();
        
        jframe = new JFrame("Chess");
        jframe.setSize(800, 800);
        jframe.setResizable(false);
        jframe.setLayout(new GridLayout(3,3));
        
        Thread thread = new Thread(this);
        for(int i = 0; i < 9; i++){
                square[i] = new JButton();
            if((i % 2) == 0)
                square[i].setBackground(Color.BLACK);
            else
                square[i].setBackground(Color.RED);
            square[0].setIcon(imageIcon);
            jframe.add(square[i]);
        }
        
        jframe.setVisible(true);
        thread.start();
    }
    
    
    public void cleanBoard(){
        for(int i = 0; i < square.length; i++){
            square[i].setIcon(null);
        }
    }

    @Override
    public void run() {
        while(true){
            try{
                
                for(int i = 0; i<list.size(); i++){
                    Thread.sleep(1000);
                    cleanBoard();
                    if(i == list.size()-1 && ( Integer.parseInt(list.get(i))-1) == 8){
                        square[8].setBackground(Color.WHITE);
                        square[ Integer.parseInt(list.get(i))-1 ].setIcon(imageIcon);
                        Thread.sleep(500);
                        square[8].setBackground(Color.BLACK);
                    } else
                        square[ Integer.parseInt(list.get(i))-1 ].setIcon(imageIcon);
                }
            } catch(Exception e){
                System.err.println(e);
            }
        }
    }
}
