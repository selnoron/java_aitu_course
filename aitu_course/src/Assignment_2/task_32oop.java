package Assignment_2;


class Entity {
    public void move(){
        System.out.println("I'm moving.");
    }
    public void eat(){
        System.out.println("I'm eating.");
    }
}

class Humann extends Entity {
    public void speak() {
        System.out.println("I can communicate.");
    }
}

class JavaDeveloper extends Humann {
    public void code() {
        System.out.println("I know how to communicate in Java.");
    }
}

public class task_32oop {

}
