package model;

public class StockManager implements Runnable{
    private TicketCounter ticketCounter;

    public StockManager(TicketCounter ticketCounter)
    {
        this.ticketCounter = ticketCounter;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
                ticketCounter.alimenteazaStoc(5);
            }
        } catch (InterruptedException e) {
            System.out.println("StockManager oprit.");
        }
    }
}
