package sort;

import abstractClass.Stopwatch;

public class Quick3way extends SortExample {

    public static void sort(Comparable[] a){
        sort(a,0,a.length-1);
    }

     private static void sort(Comparable[] a,int lo,int hi){
         if(hi <= lo) return;
         int lt = lo,i = lo + 1,gt = hi;
         Comparable v = a[lo];
         while(i <= gt){
             //通过与切分元素比较
             int cmp = a[i].compareTo(v);
             if(cmp < 0) exch(a,lt++,i++);
             else if(cmp > 0) exch(a,i,gt--);
             else i++;
         }
         //a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi]
         sort(a,lo,lt-1);
         sort(a,gt+1,hi);
     }

    public static void main(String[] args){
        Integer[] a = RandomUtil.getRandomIndex(10000);
        Stopwatch stopwatch = new Stopwatch();
        sort(a);
        System.out.println(stopwatch.elapseTime());
        show(a);
    }
}
