public class PaperOffering {

  private Paper paper;

  private String mode;

  public PaperOffering(Paper paper, String mode) {
    this.paper = paper;
    this.mode = mode;
  }

  public Paper getPaper() {
    return paper;
  }

  public void setPaper(Paper paper) {
    this.paper = paper;
  }

  public String getMode() {
    return mode;
  }

  public void setMode(String mode) {
    this.mode = mode;
  }
}
