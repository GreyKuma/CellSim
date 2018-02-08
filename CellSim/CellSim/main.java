package CellSim;

import javax.swing.*;

public class main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        System.out.println("Created GUI on EDT? "+
                SwingUtilities.isEventDispatchThread());
        JFrame f = new JFrame("CellSim");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new GamePanel());
        f.pack();
        f.setVisible(true);
    }
}
