package mock.month1908;

/**
 * @author li
 * @version 1.0
 * @date 2019-08-03 19:00
 **/
public class FlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] books = new int[n];
        int l, r, s;
        for (int[] booking : bookings) {
            l = booking[0] - 1;
            r = booking[1] - 1;
            s = booking[2];
            books[l] += s;
            if (r < n - 1) {
                books[r + 1] -= s;
            }
        }
        for (int i = 1; i < n; i++) {
            books[i] += books[i - 1];
        }
        return books;
    }
}
