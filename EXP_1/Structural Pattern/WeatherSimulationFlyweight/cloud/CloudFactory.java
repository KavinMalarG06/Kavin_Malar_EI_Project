package cloud;

import java.util.HashMap;
import java.util.Map;

public class CloudFactory {
    private static final Map<CloudType, Cloud> cloudCache = new HashMap<>();

    public static Cloud getCloud(CloudType type) {
        return cloudCache.computeIfAbsent(type, t -> {
            String texture = switch (t) {
                case CUMULUS -> "FluffyTexture";
                case CIRRUS -> "WispyTexture";
                case STRATUS -> "LayeredTexture";
            };
            return new ConcreteCloud(t, texture);
        });
    }
}
