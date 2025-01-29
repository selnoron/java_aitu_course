package Assignment_3.interfaces.task3;

public class Duck implements task3.CanFly, task3.CanSwim, task3.CanRun{
    @Override
    public void fly() {
        System.out.print("Duck flying"); System.out.println();
    }
    @Override
    public void run() {
        System.out.print("Duck running"); System.out.println();
    }
    @Override
    public void swim() {
        System.out.print("Duck swimming"); System.out.println();
    }
}
