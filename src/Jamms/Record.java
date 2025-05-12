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

    public int getRecordTimeMin() {
        return recordTimeMin;
    }

    public void setRecordTimeMin(int recordTimeMin) {
        this.recordTimeMin = recordTimeMin;
    }

    public int getRecordTimeSec() {
        return recordTimeSec;
    }

    public void setRecordTimeSec(int recordTimeSec) {
        this.recordTimeSec = recordTimeSec;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public int getPlacement() {
        return placement;
    }

    public void setPlacement(int placement) {
        this.placement = placement;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String toString() {
        return "Record time: " + recordTimeMin + ":" + recordTimeSec + " Date: " + recordDate + " Discipline: " + discipline + " placement: " + placement + " Location: " + location;
    }
}
