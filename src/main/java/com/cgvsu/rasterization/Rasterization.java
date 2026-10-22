package com.cgvsu.rasterization;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

public class Rasterization {

    public static void drawRectangle(
            final GraphicsContext graphicsContext,
            final int x, final int y,
            final int width, final int height,
            final Color color)
    {
        final PixelWriter pixelWriter = graphicsContext.getPixelWriter();

        for (int row = y; row < y + height; ++row)
            for (int col = x; col < x + width; ++col)
                pixelWriter.setColor(col, row, color);
    }

    public static void drawLine(
            final GraphicsContext graphicsContext,
            final int x0, final int y0, final Color c0,
            final int x1, final int y1, final Color c1)
    {
        final PixelWriter pixelWriter = graphicsContext.getPixelWriter();

        int deltax = Math.abs(x1 - x0);
        int deltay = Math.abs(y1 - y0);

        if (deltax == 0 && deltay == 0) {
            pixelWriter.setColor(x0, y0, c0);
            return;
        }

        int dirx = (x1 - x0) > 0 ? 1 : -1;
        int diry = (y1 - y0) > 0 ? 1 : -1;

        int x = x0;
        int y = y0;
        int error = 0;

        if (deltax >= deltay) {
            int deltaerr = deltay + 1;
            for (int i = 0; i <= deltax; i++) {
                pixelWriter.setColor(x, y, getColor(x0, y0, x1, y1, x, y, c0, c1));
                error = error + deltaerr;
                if (error >= deltax + 1) {
                    y = y + diry;
                    error = error - (deltax + 1);
                }
                x = x + dirx;
            }
        } else {
            int deltaerr = deltax + 1;
            for (int i = 0; i <= deltay; i++) {
                pixelWriter.setColor(x, y, getColor(x0, y0, x1, y1, x, y, c0, c1));
                error = error + deltaerr;
                if (error >= deltay + 1) {
                    x = x + dirx;
                    error = error - (deltay + 1);
                }
                y = y + diry;
            }
        }
    }

    private static Color getColor(int x0, int y0, int x1, int y1, int x, int y, Color c0, Color c1) {
        double distFull = Math.sqrt(Math.pow(x1 - x0, 2) + Math.pow(y1 - y0, 2));
        double distCurr = Math.sqrt(Math.pow(x - x0, 2) + Math.pow(y - y0, 2));
        double ratio = distCurr / distFull;

        if (ratio > 1.0) ratio = 1.0;
        if (ratio < 0.0) ratio = 0.0;

        double r = c0.getRed() + ratio * (c1.getRed() - c0.getRed());
        double g = c0.getGreen() + ratio * (c1.getGreen() - c0.getGreen());
        double b = c0.getBlue() + ratio * (c1.getBlue() - c0.getBlue());

        return new Color(r, g, b, 1.0);
    }
}