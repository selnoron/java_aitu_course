package Assignment_3.interfaces.task10;


import Assignment_3.interfaces.task10.task10.Boss;
import Assignment_3.interfaces.task10.task10.Secretary;
import Assignment_3.interfaces.task10.task10.Person;

public class Manager implements Secretary, Boss {
    @Override
    public void use(Person person) {
        person.startToWork();
    }

    @Override
    public void startToWork() {
        System.out.println("Manager working");
    }

    @Override
    public boolean inspiresOthersToWork() {
        System.out.println("Manager inspires");
        return true;
    }
}