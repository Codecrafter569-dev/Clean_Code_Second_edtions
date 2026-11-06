public class RecordProcessorTest_3 {
    public void handle(Record r) {
        if (shouldDeleteRecord(r)) {
            deleteRecord(r);
        }
    }

    private boolean shouldDeleteRecord(Record r) {
        return r.getType().equals("OLD") && r.getYear() < 2000;
    }

    private void deleteRecord(Record r) {
        System.out.println("Record deleted: " + r.getYear());
    }

    public static void main(String[] args) {
        RecordProcessorTest_3 rp = new RecordProcessorTest_3();
        rp.handle(new Record("OLD", 1995));
    }
}

class Record {
    private String type;
    private int year;
    Record(String type, int year) { this.type = type; this.year = year; }
    String getType() { return type; }
    int getYear() { return year; }
}
