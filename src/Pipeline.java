public class Pipeline {
    public static void main(String[] args) {
        try {
            ContrastBrightness.process("cells.jpg", 2.2f, 1f);
            //GaussianFilter.process("output.JPG");
            Sharpen.process("output.JPG");
            MedianFilter.process("output.JPG");
            GaussianFilter.process("output.JPG");
            Threshold.process("output.JPG", 75);
            MedianFilter.process("output.JPG");

        }
        catch (Exception e){
            System.err.println(e);
        }
    }
}
