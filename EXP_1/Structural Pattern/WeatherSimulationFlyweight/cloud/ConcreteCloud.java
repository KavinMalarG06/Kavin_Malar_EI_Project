package cloud;

import utils.LoggerUtil;

public class ConcreteCloud implements Cloud {
    private final CloudType type; 
    private final String texture;   

    public ConcreteCloud(CloudType type, String texture) {
        this.type = type;
        this.texture = texture;
    }

    @Override
    public void render(int x, int y) throws Exception {
        LoggerUtil.getLogger().info(() -> 
            "Rendering cloud of type " + type + " with texture " + texture +
            " at coordinates (" + x + ", " + y + ")"
        );
    }
}
