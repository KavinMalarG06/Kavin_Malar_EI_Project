package documents;

import exporters.FormatExporter;

public class GenericDocument extends Document {
    public GenericDocument(FormatExporter exporter, String title, String content) {
        super(exporter, title, content);
    }
}
