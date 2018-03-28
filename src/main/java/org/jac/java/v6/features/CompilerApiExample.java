package org.jac.java.v6.features;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class CompilerApiExample {

	public static void main(String[] args) {
		CompilerApiExample compileApi = new CompilerApiExample();
		String fileToCompile = "src/main/java/org/jac/pojo/Counter.java";
		compileApi.compileSingleFile(fileToCompile);
	}
	
	public void compileSingleFile(String filePath) {
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager stdJavaFileMgr = compiler.getStandardFileManager(null, null, null);
		File javaFile = new File(filePath);
		
		Iterable<? extends JavaFileObject> fileObjects = stdJavaFileMgr.getJavaFileObjects(javaFile);
		
		
	    CompilationTask task = compiler.getTask(null, null, null, null, null, fileObjects);
	    task.call();
	    try {
			Class klass = Class.forName("org.jac.pojo.Counter");
			Object instance = klass.newInstance();
			System.out.println(instance.getClass().getName());
			Class noparams[] = {};

			Method increaseMethod = klass.getDeclaredMethod("increase", noparams);
			increaseMethod.invoke(instance, noparams);
			increaseMethod.invoke(instance, noparams);
			Method printMethod = klass.getDeclaredMethod("print", noparams);
			printMethod.invoke(instance, noparams);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
}
