package Jamms;

public enum Discipline {
    FREESTYLE("Freestyle"),
    BACKSTROKE("Backstroke"),
    BREASTSTROKE("Breaststroke"),
    BUTTERFLY("Butterfly");

    private final String displayDiscipline;

    Discipline(String displayDiscipline) {
        this.displayDiscipline = displayDiscipline;
    }
    @Override
    public String toString() {
        return displayDiscipline;
    }
}