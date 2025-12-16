/* Ashton Chavez
 * Project 4
 * March 5, 2024
 * 
 * The Interval class represents a generic interval with a start
 * and end point of a generic type.
 */

    //A generic class representing a time interval.
    public class Interval<T extends Comparable<T>> {
        private final T start;
        private final T end;

    //Constructor to create an Interval object with specified start and end points.
    public Interval(T start, T end) {
        this.start = start;
        this.end = end;
    }

    //Checks if a point is within the interval, including the endpoints.
    public boolean within(T point) {
        return start.compareTo(point) <= 0 && end.compareTo(point) >= 0;
    }

    //Checks if another interval is a subinterval of this interval.
    public boolean subinterval(Interval<T> other) {
        return start.compareTo(other.start) <= 0 && end.compareTo(other.end) >= 0;
    }

    //Checks if another interval overlaps with this interval.
    public boolean overlaps(Interval<T> other) {
        return start.compareTo(other.end) <= 0 && end.compareTo(other.start) >= 0;
    }
}