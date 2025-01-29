package Assignment_3.interfaces.task15;


public class task15 {
    interface Selectable {
        void onSelect();
    }

    interface Updatable extends Selectable {
        void refresh();
    }

    public static void main(String[] args) throws Exception {
        Screen screen = new Screen();
        screen.onSelect();
        screen.refresh();
    }
}
