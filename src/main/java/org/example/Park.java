package org.example;

public class Park {

    String name;
    Attraction[] attractions;

    public Park(String _name) {
        name = _name;
    }

    public static class Attraction {
        String name;
        String openingHours;
        int cost;

        public Attraction (String _name, String _openingHours, int _cost) {
            name = _name;
            openingHours = _openingHours;
            cost = _cost;
        }
    }

    public void parkInfo() {
        System.out.println("Парк: " + name + ", атракционы: ");
        for (int i = 0; i < attractions.length; i++) {
            System.out.println("Атрацион: " + attractions[i].name + ", время работы: "
                    + attractions[i].openingHours + ", стоимость: " + attractions[i].cost);
        }
    }
}
