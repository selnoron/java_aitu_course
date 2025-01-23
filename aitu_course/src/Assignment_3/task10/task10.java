package Assignment_3.task10;


public class task10 {
    interface Person {
        void use(Person person);
        void startToWork();
    }

    interface HasManagementPotential {
        boolean inspiresOthersToWork();
    }

    interface Secretary extends Person {
    }

    interface Boss extends Person, HasManagementPotential {
    }
    public static void main(String[] args) {
        Person secretary = new Manager();
        Person boss = new Manager();
        Person subordinate = new Suborinate();

        secretary.use(subordinate);
        boss.startToWork();
    }
}
