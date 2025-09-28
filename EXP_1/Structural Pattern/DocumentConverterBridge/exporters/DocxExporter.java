package exporters;

public class DocxExporter implements FormatExporter {
    @Override
    public void export(String title, String content) {
        System.out.println("\n[DOCX Export]");
        System.out.println("Title : " + title);
        System.out.println("Content:\n" + content);
    }
}
