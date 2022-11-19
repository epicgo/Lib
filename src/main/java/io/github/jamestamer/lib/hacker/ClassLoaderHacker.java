package io.github.jamestamer.lib.hacker;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoaderHacker {

    /**
     * Parameters of the method to add a URL to the System classes.
     */
    private static final Class<?>[] parameters = new Class[]{URL.class};

    /**
     * Adds a file to the classpath
     *
     * @param jarFile the file to be added
     * @throws IOException Unable to add URL
     */
    public void addFile(final File jarFile) throws IOException {
        addURL(jarFile.toURI().toURL());
    }

    /**
     * Adds the content pointed by the URL to the classpath.
     *
     * @param url the URL pointing to the content to be added
     * @throws IOException Unable to add URL
     */
    public void addURL(final URL url) throws IOException {
        final URLClassLoader systemClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        final Class<?> systemClass = URLClassLoader.class;
        try {
            final Method method = systemClass.getDeclaredMethod("addURL", parameters);
            method.setAccessible(true);
            method.invoke(systemClassLoader, url);
        } catch (final Throwable throwable) {
            throw new IOException("Unable to add URL to system classloader", throwable);
        }
    }
}
