package lesson1.common;

import java.awt.*;

public class Background extends Sprite implements GameObjects {
    private float time;
    private static final float AMPLITUDE = 255f / 2f;
    private Color color;

    @Override
    public void update(GameCanvas canvas, float deltaTime) {
        time+=deltaTime;
        int red = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time * 2f));
        int green = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time * 3f));
        int blue = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time));
        color = new Color(red,green,blue);
    }

    @Override
    public void render(GameCanvas canvas, Graphics g) {
        canvas.setBackground(color);
    }
}
