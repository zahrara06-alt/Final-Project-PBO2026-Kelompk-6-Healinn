package healinn.model;

import java.time.LocalDate;

public interface Bookable {
    String getId();
    String getName();
    boolean isAvailable();
    long calculatePrice(LocalDate checkIn, LocalDate checkOut);
    String getSummary();
}