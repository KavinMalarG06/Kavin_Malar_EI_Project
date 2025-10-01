
package exporters;

import java.io.IOException;
import utils.LoggerUtil;

public class OdtExporter implements FormatExporter {
    @Override
    public void export(String title, String content) throws IOException {
        try {
            LoggerUtil.logInfo("Exporting document as ODT...");
            System.out.println("\n[ODT Export]");
            System.out.println("Title : " + title);
            System.out.println("Content:\n" + content);
        } catch (Exception e) {
            throw new IOException("ODT export failed", e);
        }
    }
}
