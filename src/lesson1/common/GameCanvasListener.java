package lesson1.common;

import java.awt.*;

public interface GameCanvasListener {
    void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime);
}
