package io.github.jamestamer.lib;

import io.github.jamestamer.lib.hacker.ClassLoaderHacker;
import io.github.jamestamer.lib.repository.Lib;
import lombok.RequiredArgsConstructor;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

@RequiredArgsConstructor
public class LibHandler {

    private final JavaPlugin plugin;

    public void load(final Lib lib) {
        final String jarName = lib.getJarName();
        final File libDirectory = new File(plugin.getDataFolder(), "/libs/");
        libDirectory.mkdirs();

        final File jarFile = new File(libDirectory, jarName + ".jar");
        if (!jarFile.exists()) {
            try (final InputStream inputStream = lib.getDownloadURL().openStream()) {
                Files.copy(inputStream, jarFile.toPath());
            } catch (final IOException e) {
                throw new RuntimeException("Unable to input copy " + jarFile.getName(), e);
            }
        }

        if (!jarFile.exists()) {
            throw new RuntimeException("Unable to download " + jarName);
        }

        try {
            final ClassLoaderHacker classLoaderHacker = new ClassLoaderHacker();
            classLoaderHacker.addFile(jarFile);
        } catch (final IOException e) {
            throw new RuntimeException("Unable to add URL " + jarName + " to system classloader", e);
        }
    }
}
