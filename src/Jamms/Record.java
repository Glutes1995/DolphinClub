package Jamms;

public class Record {
    private int recordTimeMin;
    private int recordTimeSec;
    private String recordDate;
    private Discipline discipline;
    private int placement;
    private String location;

    public Record(int recordTimeMin, int recordTimeSec, String recordDate, Discipline discipline, int placement, String location) {
        this.recordTimeMin = recordTimeMin;
        this.recordTimeSec = recordTimeSec;
        this.recordDate = recordDate;
        this.discipline = discipline;
        this.placement = placement;
        this.location = location;
    }

    public String toString() {
        return "Record: " + recordTimeMin + ":" + recordTimeSec + " Date: " + recordDate + " Discipline: " + discipline + " placement: " + placement + " Location: " + location;
    }
}
