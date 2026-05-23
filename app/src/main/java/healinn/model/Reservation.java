package healinn.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reservation {
    public enum Type {
        ROOM, BALLROOM
    }
    public enum Status {
        ACTIVE, COMPLETED, CANCELLED
    }

    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("dd MMM yyyy");

    private final String reservationId;
    private final String customerUsername;
    private final Type type;
    private final String bookableId;
    private final String bookableName;
    private final LocalDate checkIn;
    private final LocalDate chekOut;
    private final long totalPrice;
    private final LocalDateTime createdAt;
    private Status status;

    private final BallroomPackage ballroomPackage;
    private final String purpose;

    public Reservation(String reservationId, String customerUsername, Type type, String bookableId, String bookableName, LocalDate checkIn, LocalDate checkOut, long totalPrice, BallroomPackage ballroomPackage, String purpose) {
        this.reservationId = reservationId;
        this.customerUsername = customerUsername;
        this.type = type;
        this.bookableId = bookableId;
        this.bookableName = bookableName;
        this.checkIn = checkIn;
        this.chekOut = checkOut;
        this.totalPrice = totalPrice;
        this.ballroomPackage = ballroomPackage;
        this.purpose = purpose;
        this.createdAt = LocalDateTime.now();
        this.status = Status.ACTIVE;
    }

    public String getReservation() {
        return reservationId;
    }
    public String getCustomerUsername() {
        return customerUsername;
    }
    public Type getType() {
        return type;
    }
    public String getBookableId() {
        return bookableId;
    }
    public String getBookableName() {
        return bookableName;
    }
    public LocalDate getCheckIn() {
        return checkIn;
    }
    public LocalDate getCheckOut() {
        return chekOut;
    }
    public long getTotalPrice() {
        return totalPrice;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status s) {
        this.status = s;
    }
    public BallroomPackage getBallroomPackage() {
        return ballroomPackage;
    }
    public String getPurpose() {
        return purpose;
    }

    public String getFormattedCheckIn() {
        return checkIn.format(DATE_FMT);
    }
    public String getFormattedCheckOut() {
        return chekOut.format(DATE_FMT);
    }
    public String getFormattedPrice() {
        return RoomType.formatRupiah(totalPrice);
    }

    public long getNights() {
        long n = chekOut.toEpochDay() - checkIn.toEpochDay();
        return n <= 0 ? 1 : n;
    }
}
