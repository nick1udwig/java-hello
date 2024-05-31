# java-hello

Investigation of Java-based Kinode processes.

The actual thing that gets run in Kinode is the [`init` method of the ProcessV0Impl.java](https://github.com/nick1udwig/java-hello/blob/master/src/main/java/wit/worlds/ProcessV0Impl.java).

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
git clone git@github.com:nick1udwig/teavm.git
cd teavm
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

Add the Impl:
```
cp src/main/java/wit/worlds/ProcessV0Impl.java wit/worlds/ProcessV0Impl.java
```

Put in the proper place:
```
rm -r src/main/java/wit
cp -r wit src/main/java
```

Compile WASM:
```
mvn compile
```

Turn it into a component:
```
cd target/generated/wasm/teavm-wasm

# Build a package (to wrap the Java process):
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
