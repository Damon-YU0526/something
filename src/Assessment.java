/**
 * Assessment class, include assignments, tests and exam
 */
public class Assessment {

  private int type;

  //The weight of each assessment
  private double weight;

  //assessment name
  private String name;

  public Assessment(int type, double weight, String name) {
    this.type = type;
    this.weight = weight;
    this.name = name;
  }

  //getter and setter method
  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
