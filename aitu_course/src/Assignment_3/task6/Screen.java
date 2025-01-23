package Assignment_3.task6;

public class Screen implements Selectable, Updatable{
    @Override
    public void refresh () {
        System.out.println("Screen refreshed");
    }

    @Override
    public void select() {
        System.out.println("Screen selected");
    }
}
