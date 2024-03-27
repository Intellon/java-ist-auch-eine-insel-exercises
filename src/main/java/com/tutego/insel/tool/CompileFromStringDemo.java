package com.tutego.insel.tool;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.ToolProvider;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Paths;
import java.util.Arrays;

public class CompileFromStringDemo {
  public static void main( String[] args ) throws Exception {
    String src = "class A { static { System.out.println(\"Java Compiler API 2\"); } }";
    StringJavaFileObject javaFile = new StringJavaFileObject( "A", src );
    
    //

    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
    try ( JavaFileManager fileManager = compiler.getStandardFileManager( null, null, null ) ) {
      Iterable<? extends JavaFileObject> files = Arrays.asList( javaFile );
      CompilationTask task = compiler.getTask( null, fileManager, null, null, null, files );
      task.call();
    }
    URL[] urls = new URL[] { Paths.get( "." ).toUri().toURL() };
    try ( URLClassLoader classLoader = new URLClassLoader( urls ) ) {
      Class.forName( "A", true, classLoader );    // Java Compiler API 2
    }
  }
}