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
        g.translate(x, y);

        g.setColor(new Color(60, 120, 180));
        g.fillRect(0, 0, 260, 140);
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(2.0f));
        g.drawRect(0, 0, 260, 140);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Times New Roman", Font.BOLD, 22));
        g.drawString("ОЗОН", 65, 80);

        g.setColor(new Color(210, 50, 40));
        g.fillRect(260, 50, 110, 90);
        g.setColor(Color.BLACK);
        g.drawRect(260, 50, 110, 90);

        g.setStroke(new BasicStroke(3.0f));
        QuadCurve2D roofCurve = new QuadCurve2D.Float(260, 50, 315, 20, 370, 50);
        g.draw(roofCurve);

        g.setStroke(new BasicStroke(2.0f));
        g.drawLine(315, 35, 325, 10);

        g.setColor(new Color(180, 220, 240));
        g.fillRect(280, 65, 60, 35);
        g.setColor(Color.BLACK);
        g.drawRect(280, 65, 60, 35);
        g.drawLine(310, 65, 310, 100);

        g.setColor(Color.YELLOW);
        g.fillRect(362, 105, 8, 15);

        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(3.0f));
        g.drawArc(35, 115, 60, 60, 0, 180);
        g.drawArc(280, 115, 60, 60, 0, 180);

        drawWheel(g, 65, 145);
        drawWheel(g, 310, 145);

        g.translate(-x, -y);
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