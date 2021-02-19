package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class CameraFactory {

    private static Object build(){

        Object cameraPort = null;

        try{
            URL[] urls = {new File(Configuration.instance.pathToCameraJavaArchive).toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, CameraFactory.class.getClassLoader());
            Class cameraClass = Class.forName("Camera", true, urlClassLoader);

            Object cameraInstance = cameraClass.getMethod("getInstance").invoke(null);

            cameraPort = cameraClass.getDeclaredField("port").get(cameraInstance);

        }catch(Exception e){
            e.printStackTrace();
        }

        return cameraPort;
    }
}
