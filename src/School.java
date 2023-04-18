import java.util.List;

public class School {

  private String fullName;

  private List<Major> majors;

  private List<Paper> papers;

  private List<Lecturer> lecturers;

  public School(String fullName) {
    this.fullName = fullName;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public List<Major> getMajors() {
    return majors;
  }

  public void setMajors(List<Major> majors) {
    this.majors = majors;
  }

  public List<Paper> getPapers() {
    return papers;
  }

  public void setPapers(List<Paper> papers) {
    this.papers = papers;
  }

  public List<Lecturer> getLecturers() {
    return lecturers;
  }

  public void setLecturers(List<Lecturer> lecturers) {
    this.lecturers = lecturers;
  }

  /**
   * get lecturer by name
   * @param firstName lecturer's first name
   * @param lastName lecturer's last name
   * @return lecturer
   */
  public Lecturer getLecturerByName(String firstName, String lastName) {
    for(Lecturer lecturer : lecturers) {
      if(lecturer.getFirstName().equals(firstName) && lecturer.getLastName().equals(lastName)) {
        return lecturer;
      }
    }
    return null;
  }

}
