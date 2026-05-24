package healinn.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Ballroom implements Bookable {
    
    public enum Status {
        AVAILABLE, BOOKED
    }

    private static final String ID = "BALLROOM-01";
    private static final String NAME = "Grand Ballroom HealInn";

    private Status status;
    private BallroomPackage selectedPackage;

    public Ballroom() {
        this.status = Status.AVAILABLE;
    }

    @Override
    public String getId() {
        return ID;
    }
    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public boolean isAvailable() {
        return status == Status.AVAILABLE;
    }

    @Override
    public long calculatePrice(LocalDate checkIn, LocalDate checkOut) {
        if (selectedPackage == null) return 0;
        long days = ChronoUnit.DAYS.between(checkIn, checkOut);
        return selectedPackage.calculateTotal((int) Math.max(1, days));
    }
   

    @Override
    public String getSummary() {
        return NAME + " | Kapasitas 500 orang | Status: " + status.name();
    }

    public Status geStatus() {
        return status;
    }
    public void setStatus(Status s) {
        this.status = s;
    }
    public BallroomPackage getSelectedPackage() {
        return selectedPackage;
    }
    public void selectedPackage(BallroomPackage p) {
        this.selectedPackage = p;
    }
}
