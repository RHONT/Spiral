import converter.ConvertersList;
import converter.GenerateArray;

public class RunProgramm {
    public static void main(String[] args) {
        GenerateArray generateArray=new GenerateArray(10,5, ConvertersList.DEFAULT);
        generateArray.printArray();
    }
}
