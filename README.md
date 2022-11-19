<h1 align="center">Lib</h1>
<p align="center">Lib is a resource for downloading libraries from maven repository or urls.</p>

###### What is Lib?
> Lib is an open source project that downloads external Maven Repo libraries or URLs. 
Easy and flexible to use with efficient API Developer.

###### What can do?
###### Here are a couple of things Lib can do:
- Easy download of libraries via URL
- Easy download of libraries via Maven Repository

##### What requires?
###### Here are a couple of things that Lib requires:
- Java 8
- Spigot API 1.8

##### Compatibility?
###### Here are a couple of things that Lib is compatible with:
- Spigot (1.5.x - 1.19.x)

##### Next Updates:
###### Some upcoming updates
- Add BungeeCord compatibility (1.5.x - 1.19.x).
- Add Modifiable Menu in Game.

### Usage:
```java
package io.github.epicgo.lib;

import io.github.jamestamer.lib.repository.impl.*;
import org.bukkit.plugin.java.JavaPlugin;

public class Lib {

    public void loadLibraries() {
        final JavaPlugin plugin = JavaPlugin.getPlugin(ExamplePlugin.class);
        final LibHandler libHandler = new LibHandler(this);
        libHandler.load(new LibURLRepository("gson-2.2.1", "https://repo1.maven.org/maven2/com/google/code/gson/gson/2.2.1/gson-2.2.1.jar"));
        libHandler.load(new LibMavenRepository("gson", "com.google.code.gson", "2.2.2"));
    }
}
```
