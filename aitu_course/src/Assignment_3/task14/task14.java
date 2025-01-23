package Assignment_3.task14;

public class task14 {
    public static void main(String[] args) {
        System.out.println(Dream.HOBBY.toString());
        System.out.println(Hobby.INDEX);
    }

    interface Desire {
    }

    interface Dream {
        Hobby HOBBY = new Hobby(); //declare
    }

    static class Hobby implements Desire, Dream { //implment
        static int INDEX = 1;

        @Override
        public String toString() {
            INDEX++;
            return "" + INDEX;
        }
    }
}
