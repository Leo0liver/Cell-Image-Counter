public class Pipeline {
    public static void main(String[] args) {
        try {
            ContrastBrightness.process("cells3.jpg", 2.3f, 1.9f);
            Sharpen.process("output.JPG");
            MedianFilter.process("output.JPG");
            GaussianFilter.process("output.JPG", 8);
            Threshold.process("output.JPG", 60);
            MedianFilter.process("output.JPG");
            Opening.process("output.JPG");
            Opening.process("output.JPG");
            Opening.process("output.JPG");
            Threshold.process("output.JPG", 120);
            Threshold.process("output.JPG", 120);
        }
        catch (Exception e){
            System.err.println(e);
        }
    }
}
