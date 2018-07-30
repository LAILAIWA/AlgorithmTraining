package sort;

import abstractClass.Stopwatch;

import java.util.Random;

public class Quick extends SortExample {
    public static void sort(Comparable[] a){
        //消除对输入的依赖，需要在这里把元素随机分布一下
        sort(a,0,a.length-1);

    }

    public static void sort(Comparable[] a,int lo,int hi){
        if(hi <= lo) return;
        int j = partition(a,lo,hi);//切分
        sort(a,lo,j-1);//将左半部分排序
        sort(a,j+1,hi);//将右半部分排序
    }

    private static int partition(Comparable[] a,int lo,int hi){//切分数组
        int i = lo,j = hi + 1; //左右扫描指针
        Comparable v = a[lo];  //切分元素
        while(true){
            //扫描左右，检查扫描是否结束并交换元素
            while(less(a[++i],v))
                if(i == hi) break;
            while(less(v,a[--j]))
                if(j == lo) break;
            if(i >= j) break;
            exch(a,i,j);
        }
        exch(a,lo,j); //将v=a[j]放入正确位置
        return j;    //a[lo...j-1] <= a[j] <= a[j+1...hi] 达成
    }

    public static void main(String[] args){
        Integer[] a = RandomUtil.getRandomIndex(10000);
        Stopwatch stopwatch = new Stopwatch();
        sort(a);
        System.out.println(stopwatch.elapseTime());
        show(a);
    }
}
