package project.Model;

import java.util.Comparator;

public class BookSorting implements Comparator {

   public int compare(Object o1, Object o2) {
      int other1 = ((Book) o1).getCount();
      int other2 = ((Book) o2).getCount();
      
      if(other1 > other2) {
         return -1;
      } else {
         return 1;
      }
   }
}