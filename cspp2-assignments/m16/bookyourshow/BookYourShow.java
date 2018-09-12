import java.util.ArrayList;
import java.util.Arrays;
/**
 * Class for book your show.
 */
class BookYourShow {
    /**
     * list of shows.
     */
    private ArrayList<Show> showList;
    /**
     * list of tickets.
     */
    private ArrayList<String> ticketList;
    /**
     * Constructs the object.
     */
    BookYourShow() {
        showList = new ArrayList<>();
        ticketList = new ArrayList<>();
    }
    /**
     * Adds a show.
     *
     * @param      show  The show
     */
    void addAShow(final Show show) {
        showList.add(show);
    }
    /**
     * Gets a show.
     *
     * @param      movie     The movie
     * @param      showTime  The show time
     *
     * @return     A show.
     */
    Show getAShow(final String movie, final String showTime) {
        for (Show show: showList) {
            if (show.getMovie().equals(movie)
            && show.getShowTime().equals(showTime)) {
                return show;
            }
        }
        return null;
    }
    /**
     * { function_description }.
     *
     * @param      movie     The movie
     * @param      showTime  The show time
     * @param      obj    The patron
     * @param      seats     The seats
     */
    void bookAShow(final String movie, final String showTime,
    final Patron obj, final String[] seats) {
        Show show = getAShow(movie, showTime);
        if (show == null) {
            System.out.println("No show");
            return;
        }
        boolean flag = false;
        String[] sseats = show.getSeats();
        for (String seat: seats) {
            for (int i = 0; i < sseats.length; i++) {
                if (seat.equals(sseats[i])) {
                show.setSeatNA(i);
                flag = true;
                }
            }
        }
        if (flag) {
            ticketList.add(obj.getMobile()
                + " " + movie + " " + showTime);
        }
    }
    /**
     * { function_description }.
     *
     * @param      movie     The movie
     * @param      showTime  The show time
     * @param      mobileNumber    The mobile number
     */
    void printTicket(final String movie, final String showTime,
    final String mobileNumber) {
        String t = mobileNumber + " " + movie + " " + showTime;
        if (ticketList.contains(t)) {
            System.out.println(t);
        } else {
            System.out.println("Invalid");
        }
    }
    /**
     * Shows all.
     */
    void showAll() {
        for (Show show: showList) {
            System.out.println(show.toString() + ","
            + Arrays.toString(show.getSeats()).replace(" ", ""));
        }
    }
}