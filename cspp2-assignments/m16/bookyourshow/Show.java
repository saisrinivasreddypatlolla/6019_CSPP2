/**
 * Class for show.
 */
class Show {
    /**
     * movie to add.
     */
    private String movie;
    /**
     * time of the show.
     */
    private String time;
    /**
     * seats available for movie.
     */
    private String[] seats;
    /**
     * Constructs the object.
     *
     * @param      movie     The movie
     * @param      time  The show time
     * @param      seats     The seats
     */
    Show(final String movie, final String time, final String[] seats) {
        this.movie = movie;
        this.time = time;
        this.seats = seats;
    }
    /**
     * Gets the movie.
     *
     * @return     The movie.
     */
    String getMovie() {
        return movie;
    }
    /**
     * Gets the show time.
     *
     * @return     The show time.
     */
    String getShowTime() {
        return time;
    }
    /**
     * Gets the seats.
     *
     * @return     The seats.
     */
    String[] getSeats() {
        return seats;
    }
    /**
     * Sets the seat na.
     *
     * @param      index  The index
     */
    void setSeatNA(final int index) {
        seats[index] = "N/A";
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return movie + "," + time;
    }
}