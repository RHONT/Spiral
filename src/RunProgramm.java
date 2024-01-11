
public class RunProgramm {
    public static void main(String[] args) {
        int[][] testSquare = new int[5][5];
        int[][] testRectangle = new int[10][5];

        SpiralConverter sp = new SpiralConverter(testSquare);
        sp.printSpriralArray();

        System.out.println("--".repeat(60));

        sp = new SpiralConverter(testRectangle);
        sp.printSpriralArray();
    }
}
