package healinn.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Room implements Bookable {

    public enum Status { AVAILABLE, OCCUPIED, MAINTENANCE }

    private final String roomId;
    private final int roomNumber;
    private final RoomType type;
    private final BedType bedType;
    private Status status;
    
    public Room(String roomId, int roomNumber, RoomType type, BedType bedType) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.type = type;
        this.bedType = bedType;
        this.status = Status.AVAILABLE;
    }

    @Override
    public String getId() {
        return roomId;
    }
    @Override
    public String getName() {
        return type.getDisplayName() + " #" + roomNumber;
    }

    @Override
    public boolean isAvailable() {
        return status == Status.AVAILABLE;
    }

    @Override
    public long calculatePrice(LocalDate checkIn, LocalDate CheckOut) {
        long nights = ChronoUnit.DAYS.between(checkIn, CheckOut);
        if (nights <= 0) nights = 1;
        return nights * type.getPricePerNight();
    }

    @Override
    public String getSummary() {
        return String.format("Kamar %s %s No.%d | %s | Status: %s",
            type.getDisplayName(), bedType.getDisplayName(),
            roomNumber, bedType.getFormattedPrice(type), status.name());
    }

    public String getRoomId() {
        return roomId;
    }
    public int getRoomNumber() {
        return roomNumber;
    }
    public RoomType getType() {
        return type;
    }
    public BedType getBedType() {
        return bedType;
    }
    public Status geStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
}
