/**
 * Class for patron.
 */
class Patron {
    /**
     * name of the person who booked ticket.
     */
    private String name;
    /**
     * mobile number of the patron.
     */
    private String mobileNumber;
    /**
     * Constructs the object.
     *
     * @param      name    The name
     * @param      mobileNumber  The mobile number
     */
    Patron(final String name, final String mobileNumber) {
        this.name = name;
        this.mobileNumber = mobileNumber;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    String getName() {
        return name;
    }
    /**
     * Gets the mobile.
     *
     * @return     The mobile number.
     */
    String getMobile() {
        return mobileNumber;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return name + " " + mobileNumber;
    }
}