import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Start the class, first construct the test data, and then print task1-8
 */
public class SchoolStart {

  /**
   * This class represents the starting point of the application. It initializes test data and
   * prints tasks 1 to 8.
   */
  private static void displayInfo() {
    System.out.println("**************************************");
    System.out.println("Assignment 1, 159.234, Semester 1 2023");
    System.out.println("Submitted by: Damon YU 23012098");
    System.out.println("My Major at Massey: Computer Science");
    System.out.println("**************************************");
    System.out.println();
  }//This is the constructor for the SchoolStart class. It does not perform any operations.//

  /**
   * main method
   *
   * @param args
   */
  public static void main(String[] args) {
    School school = new School("School of Mathematical and Computational Sciences");
    //build test data
    school.setMajors(buildMajors());
    school.setLecturers(buildLecturers());
    school.setPapers(buildPapers());
    displayInfo();
    //task 1 - 8
    printTask1(school);
    printTask2(school);
    printTask3(school, "CS");
    printTask4(school, "exam");
    printTask5(school, "assignments", 0.5);
    printTask6(school);
    printTask7(school, "Damon", "YU");
    printTask8(school, "Auckland", "159234");
  }//This method displays information about the assignment, including the course code, semester, and student's name and major.//

  /**
   * This method prints Task 1, which displays the full name of the school.
   */
  private static void printTask1(School school) {
    System.out.println("-------------- Task 1 ----------------------");
    System.out.println("School Full Name: " + school.getFullName());
    System.out.println();
  }

  /**
   * This method prints Task 2, which displays all paper details.
   */
  private static void printTask2(School school) {
    System.out.println("-------------- Task 2 ----------------------");
    System.out.println("All paper details: ");
    for (Paper paper : school.getPapers()) {
      System.out.println(paper.getPaperAndMajorDetail());
    }
    System.out.println();
  }

  /**
   * This method prints Task 3, which displays papers that belong to the specified major.
   */
  private static void printTask3(School school, String major) {
    System.out.println("-------------- Task 3 ----------------------");
    System.out.println("Papers that belong to Major " + major + ": ");
    int num = 0;
    for (Paper paper : school.getPapers()) {
      if (paper.belongToMajor(major)) {
        System.out.println("Paper -  " + paper.getPaperDetail());
        num++;
      }
    }
    System.out.println("Total matching papers in special Major - " + major + " :" + num);
    System.out.println();
  }

  /**
   * This method prints Task 4, which displays papers that have the specified assessment type.
   */
  private static void printTask4(School school, String assessment) {
    System.out.println("-------------- Task 4 ----------------------");
    System.out.println("Papers that have " + assessment + ": ");
    int num = 0;
    for (Paper paper : school.getPapers()) {
      if (paper.hasAssessment(assessment)) {
        System.out.println("Paper -  " + paper.getPaperDetail());
        num++;
      }
    }
    System.out.println("Total number of papers that have " + assessment + ": " + num);
    System.out.println();
  }

  /**
   * This method prints Task 5, which displays papers with the given assessment type whose weight is
   * higher than the specified threshold.
   */
  private static void printTask5(School school, String assessment, double weight) {
    System.out.println("-------------- Task 5 ----------------------");
    System.out.println(
        "Papers that their " + assessment + " weigh higher than " + weight * 100 + "%%:");
    int num = 0;
    for (Paper paper : school.getPapers()) {
      if (paper.weightThan(assessment, weight)) {
        System.out.println("Paper -  " + paper.getPaperDetail());
        num++;
      }
    }
    System.out.println("Total number of papers that have " + assessment
        + " weighted more than " + weight * 100 + "%%: " + num);
    System.out.println();
  }

  /**
   * This method prints Task 6, which generates random paper offering details for lecturers and
   * prints them.
   */
  private static void printTask6(School school) {
    System.out.println("-------------- Task 6 ----------------------");
    System.out.println("Paper offering details:");
    Random random = new Random();
    int randomNum = 0;
    for (Lecturer lecturer : school.getLecturers()) {
      //get random number between [0-4]
      randomNum = random.nextInt(4);
      if (randomNum == 0) {
        continue;
      }
      String campus = lecturer.getCampus();
      //random set campus paper
      Paper paper = school.getPapers().get(random.nextInt(school.getPapers().size() - 1));
      lecturer.addOffering(new PaperOffering(paper, campus));
      randomNum--;
      if (randomNum == 0) {
        continue;
      }
      //random set distance paper
      for (int i = 0; i < randomNum; i++) {
        Paper paperDistance = school.getPapers().get(random.nextInt(school.getPapers().size() - 1));
        lecturer.addOffering(new PaperOffering(paperDistance, "distance"));
      }
    }
    //print paper offering detail
    for (Lecturer lecturer : school.getLecturers()) {
      String offeringStr = lecturer.getPaperOfferingDetail();
      if (offeringStr.isEmpty()) {
        continue;
      }
      System.out.println(offeringStr);
    }
    System.out.println();
  }

  /**
   * This method prints Task 7, which displays the paper offerings taught by a lecturer with the
   * given first and last name.
   */
  private static void printTask7(School school, String firstName, String lastName) {
    System.out.println("-------------- Task 7 ----------------------");
    System.out.println("The paper offerings that I teach:");
    //get lecturer by first name and last name
    Lecturer lecturer = school.getLecturerByName(firstName, lastName);
    if (lecturer != null) {
      List<PaperOffering> paperOfferings = lecturer.getOfferings();
      if (paperOfferings.isEmpty()) {
        System.out.println("I teach nothing");
      } else {
        for (PaperOffering offering : paperOfferings) {
          System.out.println("Paper Offering - " + offering.getPaper().getNumber() +
              "  " + offering.getMode() + "  Lecturer: " + lecturer.getFirstName() +
              " " + lecturer.getLastName());
        }
      }
    }
    System.out.println();
  }

  /**
   * This method prints Task 8, which finds and displays the lecturer of a specific paper offering
   * on a specific campus.
   */
  private static void printTask8(School school, String mode, String number) {
    System.out.println("-------------- Task 8 ----------------------");
    System.out.println("The lecturer of " + mode + " offering of " + number);
    for (Lecturer lecturer : school.getLecturers()) {
      if (!lecturer.getCampus().equals(mode)) {
        continue;
      }
      for (PaperOffering offering : lecturer.getOfferings()) {
        if (offering.getPaper().getNumber().equals(number)) {
          System.out.println(
              "Lecturer's Name: " + lecturer.getFirstName() + lecturer.getLastName());
          System.out.println(
              "This lecturer is teaching " + lecturer.getOfferings().size() + " Paper(s)");
          System.out.println();
          return;
        }
      }
    }

  }

  /**
   * build test data for majors
   *
   * @return
   */
  private static List<Major> buildMajors() {
    List<Major> majors = new ArrayList<>();
    majors.add(new Major("CS", "Computer Science"));
    majors.add(new Major("IT", "Information Technology"));
    majors.add(new Major("IS", "Information Systems"));
    majors.add(new Major("SE", "Software Engineering"));
    majors.add(new Major("DS", "Data Science"));
    return majors;
  }

  /**
   * build test data for lecturers
   *
   * @return
   */
  private static List<Lecturer> buildLecturers() {
    List<Lecturer> lecturers = new ArrayList<>();
    lecturers.add(new Lecturer("1105236", "Amy", "Sheffield", "PN"));
    lecturers.add(new Lecturer("1235894", "Victoria", "Jensen", "PN"));
    lecturers.add(new Lecturer("7225669", "James", "Lee", "PN"));
    lecturers.add(new Lecturer("1328991", "Colin", "Delmont", "PN"));
    lecturers.add(new Lecturer("1562347", "Thomas", "Becker", "Auckland"));
    lecturers.add(new Lecturer("5664789", "Steven", "Hobbs", "Auckland"));
    lecturers.add(new Lecturer("3658947", "Andrew", "Jackson", "Auckland"));
    lecturers.add(new Lecturer("6332698", "Jonathon", "Wood", "Auckland"));
    lecturers.add(new Lecturer("12345678", "Mickey", "Mouse", "Auckland"));
    lecturers.add(new Lecturer("23012098", "Damon", "YU", "PN"));
    return lecturers;
  }

  /**
   * build test data for paper There is duplicate code here, but it is mock test data
   *
   * @return
   */
  private static List<Paper> buildPapers() {
    List<Paper> papers = new ArrayList<>();
    Paper paper1 = new Paper("158100", "Information Technology Principles");
    List<Major> majors1 = new ArrayList<>();
    majors1.add(new Major("IT", "Information Technology"));
    majors1.add(new Major("IS", "Information Systems"));
    paper1.setMajors(majors1);
    List<Assessment> assessments1 = new ArrayList<>();
    assessments1.add(new Assessment(1, 0.7, "assignments"));
    assessments1.add(new Assessment(2, 0.3, "tests"));
    paper1.setAssessments(assessments1);
    papers.add(paper1);

    Paper paper2 = new Paper("158120", "Web-based IT Fundamentals");
    List<Major> majors2 = new ArrayList<>();
    majors2.add(new Major("IT", "Information Technology"));
    majors2.add(new Major("IS", "Information Systems"));
    paper2.setMajors(majors2);
    List<Assessment> assessments2 = new ArrayList<>();
    assessments2.add(new Assessment(1, 0.6, "assignments"));
    assessments2.add(new Assessment(2, 0.4, "tests"));
    paper2.setAssessments(assessments2);
    papers.add(paper2);

    Paper paper3 = new Paper("159101", "Applied Programming");
    List<Major> majors3 = new ArrayList<>();
    majors3.add(new Major("IT", "Information Technology"));
    majors3.add(new Major("IS", "Information Systems"));
    majors3.add(new Major("CS", "Computer Science"));
    majors3.add(new Major("DS", "Data Science"));
    majors3.add(new Major("SE", "Software Engineering"));
    paper3.setMajors(majors3);
    List<Assessment> assessments3 = new ArrayList<>();
    assessments3.add(new Assessment(1, 0.5, "assignments"));
    assessments3.add(new Assessment(2, 0.5, "tests"));
    paper3.setAssessments(assessments3);
    papers.add(paper3);

    Paper paper4 = new Paper("159201", "Algorithms and Data Structures");
    List<Major> majors4 = new ArrayList<>();
    majors4.add(new Major("CS", "Computer Science"));
    majors4.add(new Major("DS", "Data Science"));
    majors4.add(new Major("SE", "Software Engineering"));
    majors4.add(new Major("IS", "Information Systems"));
    paper4.setMajors(majors4);
    List<Assessment> assessments4 = new ArrayList<>();
    assessments4.add(new Assessment(1, 0.4, "assignments"));
    assessments4.add(new Assessment(2, 0.2, "tests"));
    assessments4.add(new Assessment(3, 0.4, "exam"));
    paper4.setAssessments(assessments4);
    papers.add(paper4);

    Paper paper5 = new Paper("159234", "Object-Oriented Programming");
    List<Major> majors5 = new ArrayList<>();
    majors5.add(new Major("CS", "Computer Science"));
    majors5.add(new Major("SE", "Software Engineering"));
    paper5.setMajors(majors5);
    List<Assessment> assessments5 = new ArrayList<>();
    assessments5.add(new Assessment(1, 0.5, "assignments"));
    assessments5.add(new Assessment(2, 0.1, "tests"));
    assessments5.add(new Assessment(3, 0.4, "exam"));
    paper5.setAssessments(assessments5);
    papers.add(paper5);

    Paper paper6 = new Paper("158337", "Database Development");
    List<Major> majors6 = new ArrayList<>();
    majors6.add(new Major("IT", "Information Technology"));
    majors6.add(new Major("SE", "Software Engineering"));
    majors6.add(new Major("DS", "Data Science"));
    paper6.setMajors(majors6);
    List<Assessment> assessments6 = new ArrayList<>();
    assessments6.add(new Assessment(1, 0.6, "assignments"));
    assessments6.add(new Assessment(3, 0.4, "exam"));
    paper6.setAssessments(assessments6);
    papers.add(paper6);

    Paper paper7 = new Paper("158345", "Professionalism in the Information Sciences");
    List<Major> majors7 = new ArrayList<>();
    majors7.add(new Major("IT", "Information Technology"));
    majors7.add(new Major("IS", "Information Systems"));
    majors7.add(new Major("CS", "Computer Science"));
    majors7.add(new Major("DS", "Data Science"));
    majors7.add(new Major("SE", "Software Engineering"));
    paper7.setMajors(majors7);
    List<Assessment> assessments7 = new ArrayList<>();
    assessments7.add(new Assessment(1, 1, "assignments"));
    paper7.setAssessments(assessments7);
    papers.add(paper7);
    return papers;
  }


}
