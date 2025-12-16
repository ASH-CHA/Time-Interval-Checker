/* Ashton Chavez
 * Project 4
 * March 5, 2024
 * 
 * The Time class represents a time with hours, minutes, and meridian (AM/PM)
 */

import java.util.Objects;

public class Time implements Comparable<Time> {
    private final int hours;
    private final int minutes;
    private final String meridian;

    //Constructor that accepts hours, minutes, and meridian to create a Time object.
    public Time(int hours, int minutes, String meridian) throws InvalidTime {
        if (!isValidTime(hours, minutes, meridian)) {
            throw new InvalidTime("Invalid time input");
        }
        this.hours = hours;
        this.minutes = minutes;
        this.meridian = meridian;
    }

    //Constructor that accepts a string representation of time in the format "HH:MM AM/PM".
    public Time(String timeString) throws InvalidTime {
        String[] parts = timeString.split(":|\\s");
        if (parts.length != 3) {
            throw new InvalidTime("Invalid time format");
        }

        int hours, minutes;
        String meridian;
        try {
            hours = Integer.parseInt(parts[0]);
            minutes = Integer.parseInt(parts[1]);
            meridian = parts[2].toUpperCase();
        } catch (NumberFormatException e) {
            throw new InvalidTime("Invalid numeric values for hours or minutes");
        }

        if (!isValidTime(hours, minutes, meridian)) {
            throw new InvalidTime("Invalid time input");
        }

        this.hours = hours;
        this.minutes = minutes;
        this.meridian = meridian;
    }

    //Checks if the given values represent a valid time.
    private boolean isValidTime(int hours, int minutes, String meridian) {
        return (hours >= 1 && hours <= 12) &&
                (minutes >= 0 && minutes <= 59) &&
                (meridian.equalsIgnoreCase("AM") || meridian.equalsIgnoreCase("PM"));
    }

    //Compares two Time objects.
    @Override
    public int compareTo(Time other) {
        int result = Integer.compare(this.hours, other.hours);
        if (result == 0) {
            result = Integer.compare(this.minutes, other.minutes);
        }
        return result;
    }

    //Returns the string representation of the time in the format "HH:MM AM/PM".
    @Override
    public String toString() {
        return String.format("%02d:%02d %s", hours, minutes, meridian);
    }

    //Checks if two Time objects are equal.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Time time = (Time) obj;
        return hours == time.hours && minutes == time.minutes && meridian.equals(time.meridian);
    }

    //Generates the hash code for the Time object.
    @Override
    public int hashCode() {
        return Objects.hash(hours, minutes, meridian);
    }
}