package healinn.model;

public enum RoomType {
    
    STANDARD("Standard", 500_000, "Kamar nyaman dengan fasilitas lengkap"),
    DELUXE("Deluxe", 750_000, "Kamar luas dengan pemandangan kota"),
    SUITE("Suite", 1_500_000, "Kamar mewah dengan ruang tamu terpisah");

    private final String displayName;
    private final long pricePerNight;
    private final String description;

    RoomType(String displayName, long pricePerNight, String description) {
        this.displayName = displayName;
        this.pricePerNight = pricePerNight;
        this.description = description;
    }

    public String getDisplayName() {
        return displayName;
    }
    public long getPricePerNight() {
        return pricePerNight;
    }
    public String getDescription() {
        return description;
    }

    public String getFormattedPrice() {
        return formatRupiah(pricePerNight) + "/malam";
    }

    public static String formatRupiah(long amount) {
        String s = String.valueOf(amount);
        StringBuilder sb = new StringBuilder();
        int count = 0;  // TAMBAH INI
        for (int i = s.length() - 1; i >= 0; i--) {
            if (count > 0 && count % 3 == 0) sb.insert(0, '.');
            sb.insert(0, s.charAt(i));
            count++;
        }
        return "Rp " + sb;
    }
}