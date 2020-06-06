public class Pipeline {
    public static void main(String[] args) {
        try {
            ContrastBrightness.process("cells.jpg", 1.4f, 1.8f);
            GaussianFilter.process("output.JPG");
            Sharpen.process("output.JPG");
            MedianFilter.process("output.JPG");
            Threshold.process("output.JPG", 60);
        }
        catch (Exception e){
            System.err.println(e);
        }
    }
}
