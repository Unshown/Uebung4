package htlklu;

import java.util.ArrayList;

public class SportsTest {
    //ATTENTION! THIS PROJECT WAS CODED IN OPENJDK-23
    public static void main(String[] args) {
        createInstances();

        var list = createArray();

        //Beispiel 8
        for (Sports sport: list){
            if (sport.getCountryOfOrigin() == null)
                sport.setCountryOfOrigin("Undef.");
        }
    }

    public static void createInstances() {
        //Valid instances
        //All Attributes
        var sport1 = new Sports(1, "Soccer", "Team Sport", true, true, "England");
        var sport2 = new Sports(2, "Basketball", "Team Sport", true, true, "England");
        //Required Attributes
        var sport3 = new Sports(1, "Tennis", "Individual Sport");
        var sport4 = new Sports(2, "Baseball", "Team Sport");
        //Required Attributes + olympic
        var sport5 = new Sports(1, "Rugby", "Team Sport", true);
        var sport6 = new Sports(2, "Swimming", "Individual Sport", true);
        //Invalid instances
        var sportI1 = new Sports(1, null, "Team Sport", true, true, "England");
        var sportI2 = new Sports(2, "Basketball", null, true, true, "England");
        var sportI3 = new Sports(2, "Basketball", "Team Sport", true, true, "I");
        var sportI4 = new Sports(2, "Basketball", "Team Sport", true, true, "ÜberZwanzigBuchstaben");
    }

    public static ArrayList<Sports> createArray() {
        //All Attributes
        var sport1 = new Sports(1, "Soccer", "Team Sport", true, true, "England");
        var sport2 = new Sports(2, "Basketball", "Team Sport", true, true, "England");
        //Required Attributes
        var sport3 = new Sports(1, "Tennis", "Individual Sport");
        var sport4 = new Sports(2, "Baseball", "Team Sport");
        //Required Attributes + olympic
        var sport5 = new Sports(1, "Rugby", "Team Sport", true);
        var sport6 = new Sports(2, "Swimming", "Individual Sport", true);

        var list = new ArrayList<Sports>();
        list.add(sport1);
        list.add(sport2);
        list.add(sport3);
        list.add(sport4);
        list.add(sport5);
        list.add(sport6);

        return list;
    }

    public static void printArray(ArrayList<Sports> array) {
        for (Sports sports : array) {
            System.out.println(sports);
        }
    }

    public static boolean contains(ArrayList<Sports> array, Sports sport) {
        var result = false;
        for (Sports sport1: array) {
            if (sport1.equals(sport)){
                result = true;
                break;
            }
        }
        return result;
    }
}
