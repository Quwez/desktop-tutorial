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

        Rasterization.drawLine(canvas.getGraphicsContext2D(), 100, 100, Color.RED, 450, 200, Color.BLUE);
        Rasterization.drawLine(canvas.getGraphicsContext2D(), 450, 250, Color.GREEN, 100, 150, Color.YELLOW);
    }
}