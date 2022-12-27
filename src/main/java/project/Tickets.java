package project;

/**Define class Account.
* @author Favour Ojo, Kyrie Doniz, Ursi
*/

public class Tickets {
  /**instance variable.
  */
  private int ticketPrice;
  private String ticketType;

  /** constructor.
  */
  public Tickets(int price, String type) {
    ticketPrice = price;
    ticketType = type;
  }

  /** method to set price.
  */
  public void setTickets(String newTickets) {
    ticketType = newTickets;
  }

  /** method to obtain each ticket price.
  */
  public int getPrice() {
    return ticketPrice;
  }

  /** method to obtain ticket type.
  */
  public String getType() {
    return ticketType;
  }
}
