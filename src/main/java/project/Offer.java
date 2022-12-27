package project;

/**Define class Offer.
* @author Urszula Oszczapinska, Favour Ojo, Kyrie Doniz
*/

public class Offer {
  /** instance variable.
  */
  private int offerId;
  private String offerText;

  /** constructor.
  */
  public Offer(int id, String text) {
    offerId = id;
    offerText = text;
  }

  /** method to set offer.
  */
  public void setOffer(String newOffer) {
    offerText = newOffer;
  }

  /** method to get offer text.
  */
  public String getOfferText() {
    return offerText;
  }

  /** method to get offer id.
  */
  public int getOfferId() {
    return offerId;
  }
}
