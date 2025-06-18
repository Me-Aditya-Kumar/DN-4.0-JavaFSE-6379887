public class FactoryTest {
    public static void main(String[] args) {
        DocumentFactory factory = new DocumentFactory();

        Document word = factory.createDocument("word");
        word.open();

        Document pdf = factory.createDocument("pdf");
        pdf.open();

        Document excel = factory.createDocument("excel");
        excel.open();

        Document unknown = factory.createDocument("text");
        unknown.open();
    }
}
