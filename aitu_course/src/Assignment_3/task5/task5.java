package Assignment_3.task5;


public class task5 {
    public static void main(String[] args) {
        BeerLover drinker = new BeerLover();
        drinker.askForMore("more two cups");
        if(drinker.isReadyToGoHome() == false) {
            drinker.askForMore("more five cups");
            drinker.sleepOnTheFloor();
        } else {
            drinker.sayThankYou();
        }
    }
}
