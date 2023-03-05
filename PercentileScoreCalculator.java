public class PercentileScoreCalculator {
  public static void main(String[] args) throws Exception {
    int totalStudents = 7;
    int[] marks = {800, 300, 950, 760, 680, 490, 640};
    int yourScore = 760;

    float percentileScore = PercentileScoreCalculator.calculatePercentileScore(totalStudents, marks, yourScore);
    System.out.printf("Your percentile score is : %.2f", percentileScore);
  }

  public static float calculatePercentileScore(int totalStudents, int[] marks, int yourScore) throws Exception {
    //TODO: Implement this function and remove below line, which throws exception
    int count = 0;
    for(int i=0;i<totalStudents;i++){
      if(yourScore > marks[i]) count++;
    }

    return (float)count/totalStudents*100;
  }
}
