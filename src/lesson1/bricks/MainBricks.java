package lesson1.bricks;

import lesson1.common.Background;
import lesson1.common.GameCanvas;
import lesson1.common.GameCanvasListener;
import lesson1.common.GameObjects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MainBricks extends JFrame implements GameObjects, GameCanvasListener {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    protected int gameObjectsCount;
    protected GameObjects[] gameObjects = new GameObjects[1];

    public static void main(String[] args) {
        new MainBricks();
    }

    private MainBricks() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");
        GameCanvas canvas = new GameCanvas(this);
        add(canvas);
        initApplication();
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    System.out.println("Ball is added");
                    addGameObject(new Bricks());
                } else if ((e.getButton() == MouseEvent.BUTTON3)) {
                    System.out.println("Ball is removed");
                    removeGameObject();
                }
            }
        });
        setVisible(true);
    }

    private void initApplication() {
        addGameObject(new Background());
    }

    protected void addGameObject(GameObjects s) {
        if (gameObjectsCount == gameObjects.length){
            GameObjects[] temp = new GameObjects[gameObjects.length + 10];
            System.arraycopy(gameObjects,0,temp,0,gameObjects.length);
            gameObjects = temp;
        }
        gameObjects[gameObjectsCount++] = s;
    }

    protected void removeGameObject() {
        if (gameObjectsCount> 1) gameObjectsCount--;
    }

    public void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    public void update(GameCanvas canvas, float deltaTime) {
        for (int i = 0; i < gameObjectsCount; i++) {
            gameObjects[i].update(canvas, deltaTime);
        }

    }

    public void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < gameObjectsCount; i++) {
            gameObjects[i].render(canvas, g);
        }

    }
}
