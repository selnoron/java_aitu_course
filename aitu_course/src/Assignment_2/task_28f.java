package Assignment_2;

public class task_28f {
    public static String city = "Tokyo";
    public static double population = 34.5;
    public static void main(String[] args) {
        printCityPopulation("Jakarta", 25.3);
        printCityPopulation("Seoul", 25.2);
        printCityPopulation("Delhi", 23.1);
        printCityPopulation("New York", 21.6);
    }
    public static void printCityPopulation(String city_loc, double population_loc){
        System.out.println("The population of the city " + city_loc + " is " + population_loc + " million people.");
        System.out.println("While the most populous city " + city + " has a population of " + population + " million people.");
    }
}
