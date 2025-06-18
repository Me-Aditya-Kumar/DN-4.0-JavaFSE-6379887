public class DocumentFactory {
    public Document createDocument(String type) {
        if (type.equalsIgnoreCase("word")) {
            return new WordDocument();
        } else if (type.equalsIgnoreCase("pdf")) {
            return new PdfDocument();
        } else if (type.equalsIgnoreCase("excel")) {
            return new ExcelDocument();
        }

        System.out.println("Unknown document type. Returning default Word document.");
        return new WordDocument();
    }
}
