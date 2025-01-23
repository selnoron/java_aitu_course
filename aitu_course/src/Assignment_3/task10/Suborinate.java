package Assignment_3.task10;

import Assignment_3.task10.task10.Person;
import Assignment_3.task10.task10.Secretary;

public class Suborinate implements Secretary {
    @Override
    public void use(Person person) {
        person.startToWork();
    }

    @Override
    public void startToWork() {
        System.out.println("Suborinate worl");
    }
}