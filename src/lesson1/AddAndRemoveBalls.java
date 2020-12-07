package lesson1;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddAndRemoveBalls extends MouseAdapter {
    MainCircles controller;

    public AddAndRemoveBalls(MainCircles controller) {
        this.controller = controller;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        if (e.getButton() == MouseEvent.BUTTON1) {
            System.out.println("Ball is added");
            controller.addBall();
        } else if ((e.getButton() == MouseEvent.BUTTON3)) {
            System.out.println("Ball is removed");
            controller.removeBall();
        }

    }


}

