package lesson1.common;

import lesson1.circle.MainCircles;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {
    long lastFrameTime;
    GameCanvasListener controller;


    public GameCanvas(GameCanvasListener controller) {
        lastFrameTime = System.nanoTime();
        this.controller = controller;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        lastFrameTime = currentTime;
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        controller.onDrawFrame(this, g, deltaTime);
        repaint();
    }

    public int getLeft() {
        return 0;
    }

    public int getRight() {
        return getWidth() - 1;
    }

    public int getTop() {
        return 0;
    }

    public int getBottom() {
        return getHeight() - 1;
    }
}
