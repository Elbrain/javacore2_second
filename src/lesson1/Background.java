package lesson1;

import java.awt.*;
import java.util.Random;

public class Background {
    Color color;
    Random rnd = new Random();


    public void setBackground(GameCanvas canvas, float deltaTime) {
        if (deltaTime > 0.021) {
            canvas.setBackground(color = new Color(rnd.nextInt()));
        }

    }
}
