package io.github.jamestamer.lib.repository.impl;

import io.github.jamestamer.lib.repository.Lib;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.net.MalformedURLException;
import java.net.URL;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class LibMavenRepository extends Lib {

    private final String artifactId;
    private final String groupId;
    private final String version;
    private String repoUrl;

    @Override
    public String getJarName() {
        return this.artifactId + '-' + this.version;
    }

    @Override
    public URL getDownloadURL() {
        try {
            String repo = (this.repoUrl == null ? "https://repo1.maven.org/maven2" : this.repoUrl);
            if (!repo.endsWith("/")) repo += "/";

            repo += "%s/%s/%s/%s-%s.jar";

            return new URL(String.format(repo, this.groupId.replace(".", "/"), this.artifactId, this.version, this.artifactId, this.version));
        } catch (final MalformedURLException e) {
            throw new RuntimeException("Unable to download " + this.artifactId, e);
        }
    }
}
