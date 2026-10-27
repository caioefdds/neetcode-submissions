class MyCalendar {

    private List<int[]> calendar;
    public MyCalendar() {
        this.calendar = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        for (int[] event : this.calendar) {
            if (endTime > event[0] && startTime < event[1]) return false;
        }

        this.calendar.add(new int[]{startTime, endTime});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */