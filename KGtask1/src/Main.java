import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private static final int WIN_W = 700;
    private static final int WIN_H = 450;

    public Main() {
        super("Грузовик");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        add(new DrawPanel());
        setSize(WIN_W, WIN_H);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private static class DrawPanel extends JPanel {
        private final Back bg = new Back(WIN_W, WIN_H);
        private final Truck truck = new Truck(150, 140);

        public DrawPanel() {
            setPreferredSize(new Dimension(WIN_W, WIN_H));

            Timer timer = new Timer(16, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    truck.move();
                    repaint();
                }
            });
            timer.start();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;

            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

            bg.draw(g2);
            truck.draw(g2);
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}