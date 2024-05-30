# java-hello

Investigation of Java-based Kinode processes.

## Usage

### Get java 19.0.2

On Ubuntu:
```
sudo apt install openjdk-19-jre
```

On MacOS:
```
brew install openjdk@19
```

### Get Wasmtime

https://github.com/bytecodealliance/wasmtime?tab=readme-ov-file#installation

### Get Maven

On Ubuntu:
```
sudo apt install maven
```

On MacOS:
```
brew install maven
```

### Setup TeaVM

Get it:
```
git clone git@github.com:konsoletyper/teavm.git
cd teavm
```

Edit `settings.gradle.kts`:
```
diff --git a/settings.gradle.kts b/settings.gradle.kts
index ad4938d45..2c55ffaee 100644
--- a/settings.gradle.kts
+++ b/settings.gradle.kts
@@ -68,7 +68,8 @@ gradle.allprojects {
         options.encoding = "UTF-8"
     }
     tasks.withType<Javadoc>().configureEach {
-        options.encoding = "UTF-8"
+        enabled = false
+        //options.encoding = "UTF-8"
     }
     tasks.withType<JavaExec>().configureEach {
         if (name.endsWith("main()")) {
```

Build it:
```
./gradlew publishToMavenLocal
```

### Build to WASM WASI

Get & build it:
```
git clone git@github.com:nick1udwig/java-hello.git
cd java-hello
mvn compile
```

Run it:
```
wasmtime target/generated/wasm/teavm-wasm/classes.wasm
```
