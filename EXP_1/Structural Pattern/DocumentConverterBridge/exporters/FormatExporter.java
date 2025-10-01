
package exporters;

import java.io.IOException;

public interface FormatExporter {
    void export(String title, String content) throws IOException;
}
