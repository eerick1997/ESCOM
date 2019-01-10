import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
public class Hm {

   public static void main(String args[]) {

      /* This is how to declare HashMap */
      HashMap<Integer, String> hmap = new HashMap<Integer, String>();

      /*Adding elements to HashMap*/
      hmap.put(12, "Juan");
      hmap.put(2, "Pedro");
      hmap.put(7, "Laura");
      hmap.put(49, "Nicolas");
      hmap.put(3, "Maria");

      /* Despliega el contenido usando un Iterador*/
      Set set = hmap.entrySet();
      Iterator iterator = set.iterator();
      while(iterator.hasNext()) {
         Map.Entry mentry = (Map.Entry)iterator.next();
         System.out.print("La llave es: "+ mentry.getKey() + " & Su valor es: ");
         System.out.println(mentry.getValue());
      }

      /* Obtiene los valores basado en su llave*/
      String var= hmap.get(2);
      System.out.println("El valor en el indice 2 es: "+var);

      /* Remueve valores basado en la llave*/
      hmap.remove(3);
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