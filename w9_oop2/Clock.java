/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.util.function.Predicate;

public class Clock {

    private static final int HOURS_PER_DAY = 24;
    private static final int MINUTES_PER_HOUR = 60;

    private int hours, minutes;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        validateClockComponents(h, m);
        this.hours = h;
        this.minutes = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        validate(s, input -> input.matches("\\d{2}:\\d{2}"), "Time must be in the format HH:MM");
        String[] timeComponents = s.split(":");
        int h = Integer.parseInt(timeComponents[0]);
        int m = Integer.parseInt(timeComponents[1]);
        validateClockComponents(h, m);
        this.hours = h;
        this.minutes = m;
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        toc(1);
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        validate(delta, v -> v >= 0, "Δ must be non-negative.");
        int totalMinutes = (this.hours * MINUTES_PER_HOUR + this.minutes + delta) % (HOURS_PER_DAY
                * MINUTES_PER_HOUR);
        this.hours = totalMinutes / MINUTES_PER_HOUR;
        this.minutes = totalMinutes % MINUTES_PER_HOUR;
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        return this.hours < that.hours || (this.hours == that.hours && this.minutes < that.minutes);
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        return String.format("%02d:%02d", hours, minutes);
    }

    private static void validateClockComponents(int h, int m) {
        validate(h, v -> v >= 0 && v < HOURS_PER_DAY, "Hours must be between 0 and 23");
        validate(m, v -> v >= 0 && v < MINUTES_PER_HOUR, "Minutes must be between 0 and 59");
    }

    private static <T> void validate(T value, Predicate<T> condition, String errorMessage) {
        if (!condition.test(value)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void main(String[] args) {
        Clock clock = new Clock(22, 59);
        System.out.println(clock);
        clock.toc(1);
        System.out.println(clock);
    }

}
