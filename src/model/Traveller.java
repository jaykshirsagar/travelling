package model;

public class Traveller implements Runnable{

    private String name;
    private TicketCounter ticketCounter;

    public Traveller(TicketCounter ticketCounter, String name)
    {
        this.ticketCounter = ticketCounter;
        this.name = name;
    }

    @Override
    public void run() {
        ticketCounter.vindeBilet(name);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
                e.printStackTrace();
        }
    }
}
