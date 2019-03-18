public class QuickSort {
    public int[] quickSort(int []a,int p,int r){
        if(p<r){
            int q=partition(a,p,r);
            quickSort(a,p,q-1);
            quickSort(a,q+1,r);
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
        int a[]={2,343,432,21,34,545,65,32};
        int b[];
        QuickSort c=new QuickSort();
        b=c.quickSort(a,0,7);
        for (int m=0;m<b.length;m++){
            System.out.println(b[m]);
        }
    }
}
