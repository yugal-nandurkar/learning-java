package microteam;
/**
 * This is a documentation comment.
 * This is my first Java program.
 * This is an example of multi-line comments.
 * We're printing result of divison of two numbers in this program
 */

public class Comment {
    public static void main(String[] args) {
        Comment program = new Comment();
        double result = program.divide(100, 10);
        System.out.println(result);
    }

    private double divide(int dividend, int divisor) throws IllegalArgumentException {
        // if divisor is 0 throw an exception
        if (divisor == 0) {
            throw new IllegalArgumentException("divisor cannot be zero");
        }
      /* if (dividend == 0) {
         throw new IllegalArgumentException("dividend cannot be zero");
      } */
        return (double) dividend / divisor;
    }
}