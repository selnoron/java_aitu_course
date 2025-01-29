package Assignment_3.interfaces.task2;

import Assignment_3.interfaces.task2.task2.CanFly;
import Assignment_3.interfaces.task2.task2.CanMove;

public class Airplane implements CanMove, CanFly{
    @Override
    public void move() {
        System.out.print("airplane moving");
    }

    @Override
    public void fly() {
        System.out.print("airplane flying");
    }
}
