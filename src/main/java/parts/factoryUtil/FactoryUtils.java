package parts.factoryUtil;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

@SuppressWarnings("unchecked")
public class FactoryUtils {
    public static Object build(String factoryName, String archivePath, String className) {
        Object port = null;

        try {
            URL[] urls = {new File(archivePath).toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, FactoryUtils.class.getClassLoader());
            Class archiveClass = Class.forName(className, true, urlClassLoader);

            Object archiveInstance = archiveClass.getMethod("getInstance").invoke(null);

            port = archiveClass.getDeclaredField("port").get(archiveInstance);
        } catch (Exception e) {
            System.out.println("archivePath '" + archivePath + "' not found!");
            e.printStackTrace();
        }

        return port;
    }
}
