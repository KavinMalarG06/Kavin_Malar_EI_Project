package documents;
import exporters.FormatExporter;

public abstract class Document {
    protected FormatExporter exporter;
    protected String title;
    protected String content;

    protected Document(FormatExporter exporter, String title, String content) {
        this.exporter = exporter;
        this.title = title;
        this.content = content;
    }

    public void export() {
        exporter.export(title, content);
    }
}
