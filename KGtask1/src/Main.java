import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Main extends JFrame {
    private static final int WINDOW_WIDTH = 700;
    private static final int WINDOW_HEIGHT = 450;

    public Main() {
        setTitle("Крутой грузовик");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        add(new DrawPanel());
        pack();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private static class DrawPanel extends JPanel {
        private final Truck truck = new Truck(150, 140);

        public DrawPanel() {
            setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        }

        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            Graphics2D g2d = (Graphics2D) graphics;

            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

            g2d.setColor(new Color(215, 235, 250));
            g2d.fillRect(0, 0, WINDOW_WIDTH, 290);

            g2d.setColor(new Color(110, 185, 95));
            g2d.fillRect(0, 290, WINDOW_WIDTH, 160);

            g2d.setColor(new Color(65, 65, 70));
            g2d.fillRect(0, 305, WINDOW_WIDTH, 80);

            truck.draw(g2d);
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}