package parts.lidar;

import configuration.Configuration;
import parts.factoryUtil.FactoryUtils;

public class LidarFactory {
    public static Object build() {
        return FactoryUtils.build("LidarFactory",
                Configuration.instance.pathToLidarJavaArchive,
                "Lidar");
    }
}
