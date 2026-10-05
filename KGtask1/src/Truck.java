import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.QuadCurve2D;

public class Truck {
    private final int x;
    private final int y;
    public Truck(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.translate(x, y);

        g2.setColor(new Color(60, 120, 180));
        g2.fillRect(0, 0, 260, 140);
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(2.0f));
        g2.drawRect(0, 0, 260, 140);

        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Times New Roman", Font.BOLD, 22));
        g2.drawString("ОЗОН", 65, 80);

        g2.setColor(new Color(210, 50, 40));
        g2.fillRect(260, 50, 110, 90);
        g2.setColor(Color.BLACK);
        g2.drawRect(260, 50, 110, 90);

        g2.setStroke(new BasicStroke(3.0f));
        QuadCurve2D roofCurve = new QuadCurve2D.Float(260, 50, 315, 20, 370, 50);
        g2.draw(roofCurve);

        g2.setStroke(new BasicStroke(2.0f));
        g2.drawLine(315, 35, 325, 10);

        g2.setColor(new Color(180, 220, 240));
        g2.fillRect(280, 65, 60, 35);
        g2.setColor(Color.BLACK);
        g2.drawRect(280, 65, 60, 35);
        g2.drawLine(310, 65, 310, 100);

        g2.setColor(Color.YELLOW);
        g2.fillRect(362, 105, 8, 15);

        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(3.0f));
        g2.drawArc(35, 115, 60, 60, 0, 180);
        g2.drawArc(280, 115, 60, 60, 0, 180);

        drawWheel(g2, 65, 145);
        drawWheel(g2, 310, 145);

        g2.dispose();
    }

    private void drawWheel(Graphics2D g, int centerX, int centerY) {
        int radius = 24;

        g.setColor(new Color(30, 30, 30));
        g.fillOval(centerX - radius, centerY - radius, radius * 2, radius * 2);

        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(centerX - radius + 7, centerY - radius + 7, (radius - 7) * 2, (radius - 7) * 2);

        g.setColor(Color.BLACK);
        g.fillOval(centerX - 4, centerY - 4, 8, 8);
    }
}