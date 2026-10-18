import java.awt.Color;
import java.awt.Graphics2D;

public class Back {
    private final int w;
    private final int h;

    public Back(int w, int h) {
        this.w = w;
        this.h = h;
    }

    public void draw(Graphics2D g) {
        g.setColor(new Color(215, 235, 250));
        g.fillRect(0, 0, w, 290);

        g.setColor(new Color(110, 185, 95));
        g.fillRect(0, 290, w, h - 290);

        g.setColor(new Color(65, 65, 70));
        g.fillRect(0, 305, w, 80);
    }
}