# J Hasher
[![J hasher text logo](https://raw.githubusercontent.com/iharshpathak/J_Hasher/main/JHasher/src/main/Images/jhshicon.png)](https://github.com/iharshpathak/J_Hasher)
## A FOSS JavaFX Application For All Your Hashing Needs !

[![J Hasher icon Logo](https://raw.githubusercontent.com/iharshpathak/J_Hasher/main/JHasher/src/main/Images/jhsherIcon.png)](https://github.com/iharshpathak/J_Hasher)


J Hasher is a hashing application build entirely using 
java (Open JDK 17.0 & OpenJFX SDK)

[![Open Jfx](https://raw.githubusercontent.com/openjfx/openjfx.github.io/develop/static/images/javafx-shadow.png)](https://openjfx.io/)

## Features

- Hash Texts/Strings
- Hash Files
- Check Hashes For Intergrity Of Files
- Algorithms Available
  - MD2
  - MD5
  - SHA-1
  - SHA-224
  - SHA-256
  - SHA-384
  - SHA-512

J Hasher is An Open - Source Project, And is Liscened under [GNU GPL V3](https://www.gnu.org/licenses/gpl-3.0.en.html) licensce. 
J hasher is currently in Beta State and is actively being developed.



## Downloads

Currently we offer an executable [.jar build of J Hasher.](https://github.com/iharshpathak/J_Hasher/tree/main/JHasher/out/artifacts/JHasher_jar) Which requires JRE v17.0 and Above.
You can build the native executable using [launch4j](http://launch4j.sourceforge.net/) and [JDK v17](https://openjdk.java.net/)


## Build & Dependencies

J Hasher requires
- [Java](https://openjdk.java.net/) v17
- [Java Fx SDK](https://openjfx.io/)v17

## Dependency
J Hash uses the Jakarta API's for some processing parts. Hence, please do add the following dependecy to your -
##### Maven's Pom.xml file

```
<dependency>
    <groupId>jakarta.xml.bind</groupId>
    <artifactId>jakarta.xml.bind-api</artifactId>
    <version>3.0.0</version>
</dependency>

```
##### For Gradle's build.gradle file


```
implementation group: 'jakarta.xml.bind', name: 'jakarta.xml.bind-api-parent', version: '3.0.0', ext: 'pom'

```
> Note : Maven was used for Building This Project.



## License

[![GNU GPL V3](https://www.gnu.org/graphics/gplv3-with-text-136x68.png)](https://www.gnu.org/licenses/gpl-3.0.en.html)
