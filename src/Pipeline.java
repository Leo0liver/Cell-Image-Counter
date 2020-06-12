public class Pipeline {
    public static void main(String[] args) {
        try {
            AutoContrast.process("cells.jpg");
            Sharpen.process("output.JPG");
            MedianFilter.process("output.JPG");
            GaussianFilter.process("output.JPG", 8);
            Threshold.process("output.JPG", 195);
            MedianFilter.process("output.JPG");
            Opener.process("output.JPG");
            Threshold.process("output.JPG", 150);
            Opener.process("output.JPG");

            Threshold.process("output.JPG", 150);

            Threshold.process("output.jpg",0);
            counter.process("output.jpg");
        }
        catch (Exception e){
            System.err.println(e);
        }
    }
}
