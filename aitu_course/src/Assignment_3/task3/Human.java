package Assignment_3.task3;

public class Human implements task3.CanSwim, task3.CanRun{
    @Override
    public void run() {
        System.out.println("Person running");
    }
    @Override
    public void swim() {
        System.out.println("Person swimming");
    }
}
