
public class RunProgramm {
    public static void main(String[] args) {
        SpiralConverter sp = new SpiralConverter(5,5);
        sp.printSpriralArray();

        System.out.println("--".repeat(60));

        sp = new SpiralConverter(10,5);
        sp.printSpriralArray();
    }
}
