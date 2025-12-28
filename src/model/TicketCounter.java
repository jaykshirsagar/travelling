package model;

public class TicketCounter {

    private int bileteDisponibile = 100;

    public TicketCounter() {
    }

    //TODO: punctul 2
//    public void vindeBilet(String numeCalator) {
//        if (bileteDisponibile > 0) {
//            System.out.println(numeCalator + " cumpără bilet. Bilete rămase: "
//                    + (bileteDisponibile - 1));
//            bileteDisponibile--;
//        } else {
//            System.out.println(numeCalator + " NU a putut cumpăra bilet (sold epuizat).");
//        }
//    }

    //TODO: punctul 3
//    public synchronized void vindeBilet(String numeCalator) {
//        if (bileteDisponibile > 0) {
//            System.out.println(numeCalator + " cumpără bilet. Bilete rămase: "
//                    + (bileteDisponibile - 1));
//            bileteDisponibile--;
//        } else {
//            System.out.println(numeCalator + " NU a putut cumpăra bilet (sold epuizat).");
//        }
//    }

    //TODO: punctul 4
    public synchronized void vindeBilet(String numeCalator) {
        while (bileteDisponibile == 0) {
            try {
                System.out.println(numeCalator + " așteaptă. Stoc epuizat...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        bileteDisponibile--;
        System.out.println(numeCalator + " a cumpărat bilet. Rămase: "
                + bileteDisponibile);
    }

    public synchronized void alimenteazaStoc(int cantitate) {
        bileteDisponibile += cantitate;
        System.out.println("ManagerStoc a adăugat " + cantitate +
                " bilete. Total: " + bileteDisponibile);

        notifyAll();
    }

}
