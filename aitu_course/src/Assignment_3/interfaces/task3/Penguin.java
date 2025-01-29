package Assignment_3.interfaces.task3;

public class Penguin implements task3.CanRun, task3.CanSwim {
    @Override
    public void run() {
        System.out.println("Penguin running");
    }

    @Override
    public void swim() {
        System.out.println("Penguin swimming");
    }
}
