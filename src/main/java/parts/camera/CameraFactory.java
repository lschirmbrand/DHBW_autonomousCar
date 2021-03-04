package parts.camera;

import configuration.Configuration;
import parts.factoryUtil.FactoryUtils;

public class CameraFactory {

    public static Object build() {
        return FactoryUtils.build("CameraFactory", Configuration.instance.pathToCameraJavaArchive, "Camera");
    }
}
