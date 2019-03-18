public class InsertionSort {
    public void insertionSort(int [] a){
        for(int j=1;j<a.length;j++){
            int key=a[j];
            int i=j-1;
            while(i>=0&&a[i]>key){
                a[i+1]=a[i];
                i=i-1;
            }
            a[i+1]=key;
        }
        for(int k=0;k<a.length;k++){
            System.out.println(a[k]);
        }
    }
    public static void main(String[] args){
        int a[]={4,343,432,21,34,545,65,32};
        InsertionSort b =new InsertionSort();
        b.insertionSort(a);
    }
}
