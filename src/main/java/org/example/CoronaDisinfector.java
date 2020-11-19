package org.example;

public class CoronaDisinfector {
    private Announcer annoncer = new ConsoleAnnouncer();
    private Policeman policeman = new PolicemanImpl();

    public void start(Room room) {
        //TODO inform all about begining desinfection
        annoncer.announce("Disinfection start, all out =) ");
        //TODO Ask everyone get out of the room
        policeman.makePeopleLeaveRoom();
        disinfect(room);

        //TODO inform everyone that they can return to the room
        annoncer.announce("Disinfection completed, try returning to the room.");

    }

    private void disinfect(Room room) {
        System.out.println("Cleaning from coronavirus");
    }
}
