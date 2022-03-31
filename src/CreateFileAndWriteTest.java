import services.files.write.WriteFileService;

public class CreateFileAndWriteTest {
    public static void main(String[] args) {

        long startTime = System.nanoTime();
//        String path = CreateFileService.createFile("Calculos/2022-03-30");
        WriteFileService.write("Circulo (medidas en metros)\n" +
            "Radio: 5 \n" +
            "Perimetro: 31.416\n" +
            "Area: 78.54\n", "Calculos/2022-03-30/prueba.txt");
        long endTime = System.nanoTime();
        System.out.println("Total execution time is "+(endTime - startTime));

//        long start = System.nanoTime();
//        Writer w = new Writer("Circulo (medidas en metros)\n" +
//            "Radio: 5 \n" +
//            "Perimetro: 31.416\n" +
//            "Area: 78.54\n", "Calculos/2022-03-30/prueba.txt");
//        w.writeToFile();
//        long endTime = System.nanoTime();
//        System.out.println("Total execution time is "+(endTime - start));
    }
}
