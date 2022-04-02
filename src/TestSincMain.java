import threads.MultithreadingOpenFiles;

public class TestSincMain {
    public static void main(String[] args) {
        String [] files = {
            "./Calculos/2022-03-31/alberto.txt",
            "./Calculos/2022-03-31/archivo.txt",
            "./Calculos/2022-03-31/calculo-isoceles.txt",
            "./Calculos/2022-03-31/huhuhu.txt",
            "./Calculos/2022-03-31/isocel.txt",
            "./Calculos/2022-03-31/juan.txt",
            "./Calculos/2022-03-31/nuevoarchivo.txt",
            "./Calculos/2022-03-31/ocho.txt",
            "./Calculos/2022-03-31/ysae.txt",
        };
        long start = System.nanoTime();
        for (String filePath: files) {
            try {
                Runtime.getRuntime().exec("open -a TextEdit " + filePath);
            }catch (Exception e){
                System.out.println("No");
            }
        }
        long end = System.nanoTime();
        System.out.println(end - start);
    }
}
