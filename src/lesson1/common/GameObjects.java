package lesson1.common;

import lesson1.common.GameCanvas;

import java.awt.*;

public interface GameObjects {
    void update(GameCanvas canvas, float deltaTime) ;

    void render(GameCanvas canvas, Graphics g) ;
}
