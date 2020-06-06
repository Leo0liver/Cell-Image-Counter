public class Pipeline {
    public static void main(String[] args) {
        try {
            GaussianFilter.process("cells.jpg");
            Sharpen.process("output.JPG");
            MedianFilter.process("output.JPG");
            Threshold.process("output.JPG", 80);
        }
        catch (Exception e){
            System.err.println(e);
        }
    }
}
