import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.Locale;
 
import javax.tools.Diagnostic;
import javax.tools.DiagnosticListener;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

 
/**
 * Dynamic java class compiler and executer  <br>
 * Demonstrate how to compile dynamic java source code, <br>
 * instantiate instance of the class, and finally call method of the class <br>
 *
 * http://www.beyondlinux.com
 *
 *
 */
public class DynamicCompiler
{
    /** where shall the compiled class be saved to (should exist already) */
    private static String classOutputFolder = "./build/classes";
    public static class MyDiagnosticListener implements DiagnosticListener<JavaFileObject>
    {
        public void report(Diagnostic<? extends JavaFileObject> diagnostic)
        {
 
            System.out.println("Line Number->" + diagnostic.getLineNumber());
            System.out.println("code->" + diagnostic.getCode());
            System.out.println("Message->"
                               + diagnostic.getMessage(Locale.ENGLISH));
            System.out.println("Source->" + diagnostic.getSource());
            System.out.println(" ");
        }
    }
 
    /** java File Object represents an in-memory java source file <br>
     * so there is no need to put the source file on hard disk  **/
    public static class InMemoryJavaFileObject extends SimpleJavaFileObject
    {
        private String contents = null;
 
        public InMemoryJavaFileObject(String className, String contents) throws Exception
        {
            super(URI.create("string:///" + className.replace('.', '/')
                             + Kind.SOURCE.extension), Kind.SOURCE);
            this.contents = contents;
        }
 
        public CharSequence getCharContent(boolean ignoreEncodingErrors)
                throws IOException
        {
            return contents;
        }
    }
 
    /** Get a simple Java File Object ,<br>
     * It is just for demo, content of the source code is dynamic in real use case */
    private static JavaFileObject getJavaFileObject()
    {
        StringBuilder contents = new StringBuilder(
                                                   "/*package math;*/"+
                                                            "public class Tabla1 { "
                                                           +"public int id,edad;"
                                                           +"public String nombre;"
                                                           + "  public int getId(){ "
                                                           + "    return this.id; }"
                                                           + "  public String getNombre(){ "
                                                           + "    return this.nombre; }"
                                                           + "  public int getEdad(){ "
                                                           + "    return this.edad; }"
                                                           + "  void setId(int id){ "
                                                           + "    this.id=id; }"
                                                           + "  public void setNombre(String nombre){ "
                                                           + "    this.nombre=nombre; }"
                                                           + "  public void setEdad(int edad){ "
                                                           + "    this.edad=edad; }"
                                                           + "  public static void main(String[] args) { "
                                                           + "    Tabla1 t = new Tabla1(); "
                                                           + "    t.setId(1); t.setNombre(\"Pepe\"); t.setEdad(40); "
                                                           +"   System.out.println(\"Termina codigo en memoria\");"
                                                           + "  } " + "} ");
        JavaFileObject jfo = null;
        try
        {
            jfo = new InMemoryJavaFileObject("/*math.Tabla1*/Tabla1", contents.toString());
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return jfo;
    }
 
    /** compile your files by JavaCompiler */
    public static void compile(Iterable<? extends JavaFileObject> files)
    {
        //get system compiler:
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
 
        // for compilation diagnostic message processing on compilation WARNING/ERROR
        MyDiagnosticListener c = new MyDiagnosticListener();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(c,
                                                                              Locale.ENGLISH,
                                                                              null);
        //specify classes output folder
        Iterable options = Arrays.asList("-d", classOutputFolder);
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager,
                                                             c, options, null,
                                                             files);
        Boolean result = task.call();
        if (result == true)
        {
            System.out.println("Succeeded");
        }
    }

    /**setData
     * This method set a data in a class previouslly created
     * Arguments: An object which is the instance of a class that
     * dinamycally we created. A String which contains the name
     * of the class that belongs to our object and 
     **/
    public void setDataObject(Object object, String name_class, String name_data){  
        System.out.println("DynamicCompiler.setDataObject()");
        //We create a File object on the root of the directory
        //containing the calss file
        File file = new File(classOutputFolder);
        try{
            /*As we know we have setter methods so we concat the word set and the
            name of the data that we need */
            String setter = "set" + name_data;
            /*Here we create an object type Method and get the setter method
            that we need using the variable setter.
            
            getMethod(name_method, );*/
            //Method setSomething = object.getClass().getMethod(setter, types);
            
        } catch(Exception e){
            
        }
    }
    
    public void setDataPrimitive(Object object, String name_class, String name_data){
        
    }
    
    /**public String getDataObject(Object object, String name_class, Object){
        
    }**/
    
    /** run class from the compiled byte code file by URLClassloader */
    public static void runIt()
    {
        // Create a File object on the root of the directory
        // containing the class file
        File file = new File(classOutputFolder);
 
        try
        {
            // Convert File to a URL
            URL url = file.toURL(); // file:/classes/demo
            URL[] urls = new URL[] { url };
            System.out.println("dentro del metodo invoke..");
            // Create a new class loader with the directory
            ClassLoader loader = new URLClassLoader(urls);
            System.out.println("crea cargador de clase");
            // Load in the class; Class.childclass should be located in
            // the directory file:/class/demo/
            Class thisClass = loader.loadClass("Tabla1");
            Class params[] = {};
            System.out.println("Cargo bien la clase");
            //Object paramsObj[] = {};
            /*Object o = (Object)new String("Juancho");
            Object[] param = new Object[]{o};
            Object[] paramsObj = new Object[]{param};
            Object instance = thisClass.newInstance();
            Method thisMethod = thisClass.getDeclaredMethod("setNombre", params);
            */
            /*******************/
        String ClassName = "Tabla1";
        Class<?> tClass = Class.forName(ClassName); // convert string classname to class
        Object tabla = tClass.newInstance(); // invoke empty constructor
            System.out.println("Genero bien instancia "+tabla.getClass().getName());
        String methodName = "";

        // with single parameter, return void
        methodName = "setNombre";
        Method setNameMethod = tabla.getClass().getMethod(methodName, String.class);
        setNameMethod.invoke(tabla, "Pepe"); // pass arg

        // without parameters, return string
        methodName = "getNombre";
        Method getNameMethod = tabla.getClass().getMethod(methodName);
        String name = (String) getNameMethod.invoke(tabla); // explicit cast
            System.out.println("Valor devuelto por metodo:"+name);
//            String p = "Juancho";
//            Method thisMethod = thisClass.getDeclaredMethod("setNombre", params)
            /*********************/
            // run the testAdd() method on the instance:
//            thisMethod.invoke(instance, paramsObj);
//            Method m1 = thisClass.getMethod("getNombre", null);
//            Object ob = m1.invoke(instance, null);
//            System.out.println("Dato devuelto: "+ob);
        }
        catch (MalformedURLException e)
        {
        }
        catch (ClassNotFoundException e)
        {
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
 
    public static void main(String[] args) throws Exception
    {
        //1.Construct an in-memory java source file from your dynamic code
        JavaFileObject file = getJavaFileObject();
        Iterable<? extends JavaFileObject> files = Arrays.asList(file);
 
        //2.Compile your files by JavaCompiler
        compile(files);
 
        //3.Load your class by URLClassLoader, then instantiate the instance, and call method by reflection
        runIt();
        System.out.println("fin del programa..");
      }
}