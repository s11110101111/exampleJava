package org.example;

public class CoronaDisinfector {
    public void start(Room room) {
        //TODO inform all about begining desinfection
       announser.annonse("Disinfection start, all out =) ");
        //TODO Ask everyone get out of the room
        disinfect(room);
        //TODO inform everyone that they can return to the room
    }

    private void disinfect(Room room) {
        System.out.println("Cleaning from coronavirus");
    }
}
