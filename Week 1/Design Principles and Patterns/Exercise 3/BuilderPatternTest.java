public class BuilderPatternTest {
    public static void main(String[] args) {

        Computer basicComputer = new Computer.Builder("Intel i5", "8GB")
                                        .build();
        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB")
                                        .setStorage("1TB SSD")
                                        .setGraphicsCard("NVIDIA RTX 4080")
                                        .setMotherboard("ASUS ROG")
                                        .setPowerSupply("850W")
                                        .build();

        System.out.println("Basic Computer Configuration:");
        System.out.println(basicComputer);

        System.out.println("\nGaming Computer Configuration:");
        System.out.println(gamingComputer);
    }
}
