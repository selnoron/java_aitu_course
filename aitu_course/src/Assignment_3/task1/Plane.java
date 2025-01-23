package Assignment_3.task1;

public class Plane implements CanFly {
    @Override
    public void fly() {
        System.out.println("Plane flying");
    }

    @Override
    public void prizemlitsa() {
        System.out.println("Plane prizemlyaetsa");
    }
}
