package class_and_object;

import java.time.LocalTime;

public class StopWatch {
    private LocalTime startTime, endTime;
    public StopWatch() {
        startTime = LocalTime.now();
    }
    public StopWatch(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public LocalTime getStartTime() {
        return this.startTime;
    }
    public LocalTime getEndTime() {
        return this.endTime;
    }
    public void start() {
        startTime = LocalTime.now();
    }
    public void end() {
        endTime = LocalTime.now();
    }
    public int getElapsedTime() {
        int milliSeconds = ((this.endTime.getHour() - this.startTime.getHour()) * 3600 +
                            (this.endTime.getMinute() - this.startTime.getMinute()) * 60 +
                            (this.endTime.getSecond() - this.startTime.getSecond()) * 1000);
        return milliSeconds;
    }
}
