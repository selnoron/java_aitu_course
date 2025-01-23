package Assignment_3.task3;


public class task3 {
    public interface CanFly {
        void fly();
    }

    public interface CanRun {
        void run();
    }

    public interface CanSwim {
        void swim();
    }

    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.swim();
        duck.fly();
        duck.run();
    }
}
