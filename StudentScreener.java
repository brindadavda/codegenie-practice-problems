public class StudentScreener {
  public static void main(String[] args) throws Exception {
    int totalStudents = 7;
    int totalMarks = 1000;
    float requiredPercentile = 50f;

    int[] marks = {800, 300, 750, 760, 680, 790, 640};
    String[] students = { "Kartik", "Devang", "Pari", "Ketan", "Sheetal", "Darshana", "Mohan" };
    String[] examResults = {"Passed", "Failed", "Passed", "Failed", "Passed", "Passed", "Passed"};

    String eligiblStudents = getEligibleStudents(totalStudents, students, marks, examResults, totalMarks, requiredPercentile);
    System.out.println(eligiblStudents);
  }

  public static String getEligibleStudents(int totalStudents, String[] students, int[] marks, String[] examResults, int totalMarks, float requiredPercentile) throws Exception {
    //TODO: Implement this function and remove below line, which throws exception

    //step-1 : setting the rank according to marks
    int[] rank = new int[totalStudents];
        for (int i = 0; i < totalStudents; i++) {
            rank[i] = 1;
            for (int j = 0; j < totalStudents; j++) {
                if (marks[j] > marks[i]) {
                    rank[i]++;
                }
            }
        }
        

    //step-2: finding the eligible student by the given formula N-R/N * 100 where N is totalStudents
    String eligibleStudents = "";
    for (int i = 0; i < totalStudents; i++) {
      double studentPercentile = (double) (totalStudents - rank[i]) / totalStudents * 100;
      if (studentPercentile >= requiredPercentile && examResults[i].equals("Passed")) {
        eligibleStudents += students[i]+",";
      }
    }
        
        
    //step-3: return the eligibleStudents
    return eligibleStudents;
  }
}
