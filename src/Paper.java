import java.util.ArrayList;
import java.util.List;

public class Paper {

  private String number;

  private String name;

  /**
   * paper's assessments
   */
  private List<Assessment> assessments;

  /**
   * The majors to which the paper belongs
   */
  private List<Major> majors;

  public Paper(String number, String name) {
    this.number = number;
    this.name = name;
    this.assessments = new ArrayList<>();
    this.majors = new ArrayList<>();
  }

  public Paper(String number, String name, List<Assessment> assessments, List<Major> majors) {
    this.number = number;
    this.name = name;
    this.assessments = assessments;
    this.majors = majors;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Assessment> getAssessments() {
    return assessments;
  }

  public void setAssessments(List<Assessment> assessments) {
    this.assessments = assessments;
  }

  public List<Major> getMajors() {
    return majors;
  }

  public void setMajors(List<Major> majors) {
    this.majors = majors;
  }

  public String getPaperAndMajorDetail() {
    String detail = getNumber() + " " + getName() + " ";
    if (!majors.isEmpty()) {
      detail += "(";
      for (Major major : majors) {
        detail += major.getName() + " ";
      }
      detail += ")";
    }
    return detail;
  }

  public String getPaperDetail() {
    return getNumber() + " " + getName() + " ";
  }

  public boolean belongToMajor(String majorName) {
    for (Major major : majors) {
      if (major.getName().equals(majorName)) {
        return true;
      }
    }
    return false;
  }

  public boolean hasAssessment(String name) {
    for (Assessment assessment : assessments) {
      if (assessment.getName().equals(name)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Filter out the assessments that meet the conditions, and then
   * determine whether the weight is greater than a specific value
   * @param name
   * @param weight
   * @return
   */
  public boolean weightThan(String name, double weight) {
    for (Assessment assessment : assessments) {
      if (assessment.getName().equals(name)) {
        if (assessment.getWeight() > weight) {
          return true;
        }
      }
    }
    return false;
  }
}
