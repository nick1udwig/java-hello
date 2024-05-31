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

### Setup wasm-tools

Get & build wit-bindgen:
```
git clone git@github.com:nick1udwig/wit-bindgen.git
cd wit-bindgen
git checkout fully-qualify-java-address
cargo install --path .
```

### Build to WASM WASI

Get & build it:
```
git clone git@github.com:nick1udwig/java-hello.git
cd java-hello
git checkout hf/to-component
```

Codegen from WIT file & make important edit (only necessary if `kinode.wit` is updated):
```
wit-bindgen teavm-java kinode.wit -w process-v0
```

Edit:
```
diff --git a/wit/worlds/ProcessV0.java b/wit/worlds/ProcessV0.java
17,18c17,18
-     private static void wasmExportInit(int p0, int p1) {
+     public static void wasmExportInit(int p0, int p1) {
```

```
cp -r wit src/main/java
```

Compile WASM:
```
mvn compile
```

Turn it into a component:
```
cd target/generated/wasm/teavm-wasm

# Build a package (we will put it into the package):
kit n foo
kit b foo

# Turn Java module into a component: a Kinode process
wasm-tools component embed ../../../../kinode.wit --world process-v0 classes.wasm -o foo0.wasm
wasm-tools component new foo0.wasm -o foo.wasm --adapt foo/foo/wasi_snapshot_preview1.wasm

# Put it into package
cp foo.wasm foo/pkg/foo.wasm
```

Start a fake node (use another terminal):
```
kit f
```

Run the Java-based Kinode process
```
kit s foo
```
