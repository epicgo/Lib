package io.github.jamestamer.lib.repository.impl;

import io.github.jamestamer.lib.repository.Lib;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.net.MalformedURLException;
import java.net.URL;

@Getter
@RequiredArgsConstructor
public class LibURLRepository extends Lib {

    private final String artifactId;
    private final String repoUrl;

    @Override
    public String getJarName() {
        return this.artifactId;
    }

    @Override
    public URL getDownloadURL() {
        try {
            return new URL(this.repoUrl);
        } catch (final MalformedURLException e) {
            throw new RuntimeException("Unable to download " + this.artifactId, e);
        }
    }
}
