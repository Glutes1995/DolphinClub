package Package;

public enum Discipline {
    BUTTERFLY("Butterfly"),
    FREESTYLE("Freestyle"),
    BACKSTROKE("Backstroke"),
    BREASTSTROKE("Breaststroke");

    private final String displayName;

    Discipline(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String toString() {
        return displayName;
    }
}
