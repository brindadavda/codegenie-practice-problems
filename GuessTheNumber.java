public class GuessTheNumber {
  public static void main(String[] args){
    int finalNumber = 10;
    String[] operations = {"X * 5", "X * 0", "X + 10"};

    try {
      int actualNumber = GuessTheNumber.getActualNumber(finalNumber, operations, operations.length);
      System.out.println("The actual number will be " + actualNumber + " after performing given operations.");
  } catch (Exception e) {
      e.printStackTrace();
  }
  }

  public static int getActualNumber(int finalNumber, String[] operations, int totalOperations) throws Exception{
    //TODO: Implement this function and remove below line, which throws exception
    int actualNumber = -1;
    for (int i = 0; i < 1000000; i++) { // we can limit the search space to 1000000, assuming the input constraints are within that range
      int num = i;
      boolean isValid = true;
      for (int j = 0; j < totalOperations; j++) {
        String[] parts = operations[j].split(" ");
        String op = parts[1];
        int val = Integer.parseInt(parts[2]);
        switch (op) {
          case "+":
            num += val;
            break;
          case "-":
            num -= val;
            break;
          case "*":
            num *= val;
            break;
          case "/":
            if (val == 0 || num % val != 0) {
              isValid = false;
            } else {
              num /= val;
            }
            break;
          case "%":
            if (val == 0) {
              isValid = false;
            } else {
              num %= val;
            }
            break;
          case "^":
            num = (int) Math.pow(num, val);
            break;
          default:
            isValid = false;
        }
        if (!isValid) {
          break;
        }
      }
      if (isValid && num == finalNumber) {
        if (actualNumber != -1) {
          return -2; // multiple answers found
        }
        actualNumber = i;
      }
    }
    return actualNumber;
  }
}