package exporters;

public class OdtExporter implements FormatExporter {
    @Override
    public void export(String title, String content) {
        System.out.println("\n[ODT Export]");
        System.out.println("Title : " + title);
        System.out.println("Content:\n" + content);
    }
}
