import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
public class Hm2 {

   public static void main(String args[]) {

      /* This is how to declare HashMap */
      HashMap<String, String> hmap = new HashMap<String, String>();

      /*Adding elements to HashMap*/
      hmap.put("uno", "Juan");
      hmap.put("dos", "Pedro");
      hmap.put("tres", "Laura");
      hmap.put("cuatro", "Nicolas");
      hmap.put("cinco", "Maria");

      /* Despliega el contenido usando un Iterador*/
      Set set = hmap.entrySet();
      Iterator iterator = set.iterator();
      while(iterator.hasNext()) {
         Map.Entry mentry = (Map.Entry)iterator.next();
         System.out.print("La llave es: "+ mentry.getKey() + " & Su valor es: ");
         System.out.println(mentry.getValue());
      }

      /* Obtiene los valores basado en su llave*/
      String var= hmap.get("dos");
      System.out.println("El valor en el indice dos es: "+var);

      /* Remueve valores basado en la llave*/
      hmap.remove("tres");
      System.out.println("Llaves y valores después de remover una entrada:");
      Set set2 = hmap.entrySet();
      Iterator iterator2 = set2.iterator();
      while(iterator2.hasNext()) {
          Map.Entry mentry2 = (Map.Entry)iterator2.next();
          System.out.print("La llave es: "+mentry2.getKey() + " & y el valor es: ");
          System.out.println(mentry2.getValue());
       }

   }
}