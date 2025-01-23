package Assignment_3.task13;


public class task13 {
    interface DBObject {
        DBObject initializeIdAndName(long id, String name);
    }

    static class Matrix {
        public static DBObject NEO = new User().initializeIdAndName(1, "Neo");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Matrix.NEO);
    }
}
