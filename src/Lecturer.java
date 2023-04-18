import java.util.ArrayList;
import java.util.List;

/**
 * Lecturer class, used to describe the lecturer class, each lecturer may deliver a minimum of zero
 * offerings and a maximum of four offerings
 */
public class Lecturer {

  private String id;

  private String firstName;

  private String lastName;

  /**
   * located at one of two campuses (Auckland or PN
   */
  private String campus;

  /**
   * Each lecturer may deliver a minimum of zero offerings and a maximum of four offerings
   */
  private List<PaperOffering> offerings;

  public Lecturer(String id, String firstName, String lastName, String campus) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.campus = campus;
    this.offerings = new ArrayList<>();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getCampus() {
    return campus;
  }

  public void setCampus(String campus) {
    this.campus = campus;
  }

  /**
   * @return {@link List}<{@link PaperOffering}>
   */
  public List<PaperOffering> getOfferings() {
    return offerings;
  }

  public void setOfferings(List<PaperOffering> offerings) {
    this.offerings = offerings;
  }

  public void addOffering(PaperOffering offering) {
    offerings.add(offering);
  }

  /**
   * Print Lecturer's paper offering information
   *
   * @return
   */
  public String getPaperOfferingDetail() {
    String result = "";
    if (offerings.isEmpty()) {
      return result;
    }

    for (int i = 0; i < offerings.size(); i++) {
      PaperOffering offering = offerings.get(i);
      if (i == offerings.size() - 1) {
        result += String.format("%-8s%-12s%-30s", offering.getPaper().getNumber(),
            offering.getMode(), getFirstName() + " " + getLastName());
      } else {
        result += String.format("%-8s%-12s%-30s\n", offering.getPaper().getNumber(),
            offering.getMode(), getFirstName() + " " + getLastName());
      }
    }
    return result;
  }

}
