# Clipack

这是一个用于类似Paperclip打包工具，该工具通过基于的Zip4J快速将某一些文件打入Zip包，API调用极其简单，只有两个接口以及一个Builder。

## 如何使用

```java
try(Clipack zip = Clipack.create(new File("你要处理的Zip包的路径"))) {
    zip.addFolder(new File("你要添加的文件夹"))
        .addFile(new File("你要添加的文件"));
}
```
