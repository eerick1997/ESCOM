import java.util.*;
public class ListaLigada {
     public static void main(String args[]) {

         /* Declaracion */
         LinkedList<String> linkedlist = new LinkedList<String>();

         /*agrega un elemento de tipo(String)  
          * the elements to the linked list*/
         linkedlist.add("Item1");
         linkedlist.add("Item2");
         linkedlist.add("Item3");
         linkedlist.add("Item4");
         linkedlist.add("Item5");

         /*Despliega contenido de la lista*/
         System.out.println("Contenido: " +linkedlist);

         /*Agrega primer y ultimo elemento*/
         linkedlist.addFirst("primer Item");
         linkedlist.addLast("ultimo Item");
         System.out.println("Contenido de la lista despues de la adicion: " +linkedlist);

         /*leer y establecer valores en lista*/
         Object firstvar = linkedlist.get(0);
         System.out.println("Primer elemento de lista: " +firstvar);
         linkedlist.set(0, "Nuevo primer item");
         Object firstvar2 = linkedlist.get(0);
         System.out.println("Nuevo primer elemento después de actualizacion: " +firstvar2);

         /*Remueve primer y ultimo elemento de la lista*/
         linkedlist.removeFirst();
         linkedlist.removeLast();
         System.out.println("Lista despues de eliminar primer y ultimo elementos: " +linkedlist);

         /* Agrega en una posicion y elimina de una posicion*/
         linkedlist.add(0, "Una nueva adicion item");
         linkedlist.remove(2);
         System.out.println("Contenido final de la lista: " +linkedlist); 
     }
}