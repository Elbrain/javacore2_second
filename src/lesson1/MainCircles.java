package lesson1;

import javax.swing.*;
import java.awt.*;


public class MainCircles extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    protected int spriteCount = 10;
    protected Sprite[] sprites = new Sprite[1000];

    public static void main(String[] args) {
        new MainCircles();
    }

    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");
        GameCanvas canvas = new GameCanvas(this);
        add(canvas);
        initApplication();
        canvas.addMouseListener(new AddAndRemoveBalls(this));
        setVisible(true);
    }

    private void initApplication() {
        for (int i = 0; i < spriteCount; i++) {
            sprites[i] = new Ball();
        }
    }

    protected void addBall() {
        sprites[spriteCount] = new Ball();
        spriteCount++;
    }

    protected void removeBall() {
        spriteCount--;
    }

    public void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(GameCanvas canvas, float deltaTime) {
        for (int i = 0; i < spriteCount; i++) {
            sprites[i].update(canvas, deltaTime);
        }

    }

    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < spriteCount; i++) {
            sprites[i].render(canvas, g);
        }

    }
}
