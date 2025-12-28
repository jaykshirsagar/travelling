import model.StockManager;
import model.TicketCounter;
import model.Traveller;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        TicketCounter ticketCounter = new TicketCounter();

        Thread t1 = new Thread(new Traveller(ticketCounter, "Calator-1"));
        Thread t2 = new Thread(new Traveller(ticketCounter, "Calator-2"));
        Thread t3 = new Thread(new Traveller(ticketCounter, "Calator-3"));

        Thread managerStoc = new Thread(new StockManager(ticketCounter));


        t1.start();
        t2.start();
        t3.start();

        //TODO: punctul 4+5
        managerStoc.start();

        System.out.println("Înainte de join:");
        System.out.println("Calator-1 alive: " + t1.isAlive());

        t1.join();
        t2.join();
        t3.join();

        System.out.println("După join:");
        System.out.println("Calator-1 alive: " + t1.isAlive());

        managerStoc.interrupt();
    }
}