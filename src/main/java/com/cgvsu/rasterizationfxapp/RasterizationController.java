package com.cgvsu.rasterizationfxapp;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import com.cgvsu.rasterization.*;

public class RasterizationController {

    @FXML
    AnchorPane anchorPane;
    @FXML
    private Canvas canvas;

    @FXML
    private void initialize() {
        anchorPane.prefWidthProperty().addListener((ov, oldValue, newValue) -> canvas.setWidth(newValue.doubleValue()));
        anchorPane.prefHeightProperty().addListener((ov, oldValue, newValue) -> canvas.setHeight(newValue.doubleValue()));

        var gc = canvas.getGraphicsContext2D();

        //Наклонные отрезки
        Rasterization.drawLine(gc, 100, 80, Color.RED, 450, 180, Color.BLUE);
        Rasterization.drawLine(gc, 450, 220, Color.GREEN, 100, 120, Color.YELLOW);
        Rasterization.drawLine(gc, 150, 80, Color.MAGENTA, 250, 480, Color.CYAN);
        Rasterization.drawLine(gc, 300, 480, Color.ORANGE, 200, 80, Color.PURPLE);

        //Строго вертикальные линии
        Rasterization.drawLine(gc, 40, 50, Color.BLACK, 40, 400, Color.RED);
        Rasterization.drawLine(gc, 70, 400, Color.RED, 70, 50, Color.BLACK);

        //Строго горизонтальные линии
        Rasterization.drawLine(gc, 100, 520, Color.BLUE, 500, 520, Color.GREEN);
        Rasterization.drawLine(gc, 500, 550, Color.GREEN, 100, 550, Color.BLUE);

        //отрезок в одну точку
        Rasterization.drawLine(gc, 20, 20, Color.RED, 20, 20, Color.BLUE);

        //Тест
        for (int i = 0; i < 360; i += 15) {
            double rad = Math.toRadians(i);
            int x2 = 620 + (int) (140 * Math.cos(rad));
            int y2 = 300 + (int) (140 * Math.sin(rad));
            Rasterization.drawLine(gc, 620, 300, Color.RED, x2, y2, Color.BLUE);
        }
    }
}