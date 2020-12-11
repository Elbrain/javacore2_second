package lesson1.circle;

import lesson1.common.GameCanvas;
import lesson1.common.GameObjects;
import lesson1.common.Sprite;

import java.awt.*;
import java.util.Random;

public class Ball extends Sprite implements GameObjects {
    Random rnd = new Random();
    private final Color color;
    private float vX;
    private float vY;

    public Ball() {
        halfHeight = 20 + (float) (Math.random() * 50f);
        halfWidth = halfHeight;
        color = new Color(rnd.nextInt());
        vX = (float) (100f + (Math.random() * 200f));
        vY = (float) (100f + (Math.random() * 200f));
    }


    @Override
    public void update(GameCanvas canvas, float deltaTime) {
        x += vX * deltaTime;
        y += vY * deltaTime;
        if (getLeft() < canvas.getLeft()) {
            setLeft(canvas.getLeft());
            vX = -vX;
        }
        if (getRight() > canvas.getRight()) {
            setRight(canvas.getRight());
            vX = -vX;
        }
        if (getTop() < canvas.getTop()) {
            setTop(canvas.getTop());
            vY = -vY;
        }
        if (getBottom() > canvas.getBottom()) {
            setBottom(canvas.getBottom());
            vY = -vY;
        }
    }

    @Override
    public void render(GameCanvas canvas, Graphics g) {
        g.setColor(color);
        g.fillOval((int) getLeft(), (int) getTop(), (int) getWidth(), (int) getHeight());
    }
}
