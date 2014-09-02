package misc;

public class MaxMemory {
    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();
        long totalMem = rt.totalMemory();
        long maxMem = rt.maxMemory();
        long freeMem = rt.freeMemory();
        long availableProcessors = rt.availableProcessors();
        double mebibyte = 1048576.0;
        
        System.out.println("Total Memory: " + totalMem + " (" + (totalMem/mebibyte) + " MiB)");
        System.out.println("Max Memory:   " + maxMem + " (" + (maxMem/mebibyte) + " MiB)");
        System.out.println("Free Memory:  " + freeMem + " (" + (freeMem/mebibyte) + " MiB)");
        System.out.println("Available Processors: " + availableProcessors);
    }
}