package problems.task8;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MatrixValidator matrixValidator = new MatrixValidator();
        TridiagonalMatrix tridiagonalMatrix = new TridiagonalMatrix(new File("src/main/resources/matrix.txt"));
        Solver solver = new Solver(matrixValidator);
        List<Double> res = solver.solve(tridiagonalMatrix);
        if (res != null) {
            System.out.println(res);
        }
    }
}
