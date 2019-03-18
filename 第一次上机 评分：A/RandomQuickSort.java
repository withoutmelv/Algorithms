import java.util.Random;

public class RandomQuickSort {
    public int[] randomquickSort(int []a,int p,int r){
        if(p<r){
            Random rand=new Random();
            int i=rand.nextInt(r-p)+p;
            int t=a[r];
            a[r]=a[i];
            a[i]=t;
            int q=partition(a,p,r);
            randomquickSort(a,p,q-1);
            randomquickSort(a,q+1,r);
        }
        return a;
    }

    public int partition(int []a,int p,int r){
        int x=a[r];
        int i=p-1;
        for (int j=p;j<r;j++){
            if(a[j]<=x){
                i++;
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        int t=a[i+1];
        a[i+1]=a[r];
        a[r]=t;
        return i+1;
    }
    public static void main(String[] args){
        int a[]={3,343,432,21,34,545,65,32};
        int b[];
        RandomQuickSort c=new RandomQuickSort();
        b=c.randomquickSort(a,0,7);
        for (int m=0;m<b.length;m++){
            System.out.println(b[m]);
        }
    }
}
