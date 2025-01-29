package Assignment_3.interfaces.task15;

public class Screen implements task15.Updatable {
    @Override
    public void onSelect() {
        System.out.println("Selectable: onSelect method executed.");
    }

    @Override
    public void refresh() {
        System.out.println("Updatable: refresh method executed.");
    }
}
