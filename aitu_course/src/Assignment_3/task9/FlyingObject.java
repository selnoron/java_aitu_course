package Assignment_3.task9;


import Assignment_3.task9.task9.CanFly;

public class FlyingObject implements CanFly {
    @Override
    public Double speed() {
        return 100.0;
    }

    @Override
    public Double speed(CanFly canFly) {
        return canFly.speed() + 50.0;
    }
}
