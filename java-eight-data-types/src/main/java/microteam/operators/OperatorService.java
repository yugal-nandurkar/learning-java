package microteam.operators;

import org.springframework.stereotype.Service;

@Service
public class OperatorService {

    public int performArithmeticOperation(int a, int b) {
        return a + b; // Example of arithmetic operator
    }

    public boolean performRelationalOperation(int a, int b) {
        return a > b; // Example of relational operator
    }

    public boolean performLogicalOperation(boolean x, boolean y) {
        return x && y; // Example of logical operator
    }

    public int performBitwiseOperation(int a, int b) {
        return a & b; // Example of bitwise operator
    }
}

