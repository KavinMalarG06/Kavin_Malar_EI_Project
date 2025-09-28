package exporters;

public class PdfExporter implements FormatExporter {
    @Override
    public void export(String title, String content) {
        System.out.println("\n[PDF Export]");
        System.out.println("Title : " + title);
        System.out.println("Content:\n" + content);
    }
}
