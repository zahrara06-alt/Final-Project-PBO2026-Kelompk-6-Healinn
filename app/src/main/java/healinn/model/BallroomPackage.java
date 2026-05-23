package healinn.model;

public enum BallroomPackage {
    
    FOUR_HOURS("4 Jam", 27_000_000, 4, false),
    EIGHT_HOURS("8 Jam", 52_000_000, 8, false),
    FULL_DAY("1 Hari / Lebih", 85_000_000, 24, true);

    private final String displayName;
    private final long basePrice;
    private final int hours;
    private final boolean perDay;

    private BallroomPackage(String displayName, long basePrice, int hours, boolean perDay) {
        this.displayName = displayName;
        this.basePrice = basePrice;
        this.hours = hours;
        this.perDay = perDay;
    }

    public String getDisplayName() {
        return displayName;
    }
    public long getBasePrice() {
        return basePrice;
    }
    public int getHours() {
        return hours;
    }
    public boolean isPerDay() {
        return perDay;
    }

    public long calculateTotal(int days) {
        if (!perDay) return basePrice;
        return basePrice * Math.max(1, days);
    }

    public String getFormatedPrice() {
        return RoomType.formatRupiah(basePrice) + (perDay ? "/hari" : "");
    }
}
