package CellSim;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JPanel {
    ArrayList<Cell> cells = new ArrayList<>();
    Rectangle borders = new Rectangle(0,0,750,750);


    Random rnd = new Random();

    ActionListener cellMovement = new ActionListener() {
        public void actionPerformed(ActionEvent evt){
            moveCell();
        }
    };

    public GamePanel() {
        for (int i =0; i<10; i++) {
            cells.add(new Cell(borders));
        }
        new Timer(1, cellMovement).start();

        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                cells.add(new Cell(e.getX(), e.getY(), borders));
            }
        });
    }



    private void moveCell(){
        for (Cell cell:cells) {
            repaint(cell.getRect());
            cell.moveCell(rnd.nextInt(9) - 4, rnd.nextInt(9) - 4);
            repaint(cell.getRect());
        }
    }

    public Dimension getPreferredSize() {
        return borders.getSize();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(Cell cell: cells){
            cell.paintCell(g);
        }

    }
}
