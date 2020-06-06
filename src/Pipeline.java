public class Pipeline {
    public static void main(String[] args) {
        try {
            GaussianFilter.process("cells.jpg");
            sharpen.process("output.JPG");
            MedianFilter.process("output.JPG");
            Threshold.process("output.JPG");
        }
        catch (Exception e){
            System.err.println(e);
        }
    }
}
