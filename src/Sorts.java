import java.util.Arrays;
import java.util.OptionalInt;

public class Sorts {

    public static void Merge(int[] a, int l, int r){

        if(l<r){

            int mid= l+(r-l)/2;
            Merge(a,l,mid);
            Merge(a,mid+1,r);
            MergeSort(a,l,mid,r);
        }

    }

    public static void MergeSort(int[] a, int l, int mid,int r){

        int n1 = mid-l+1;
        int n2 = r-mid;
        int[] left = new int[n1];
        int[] right = new int[n2];

        for(int i=0;i<n1;i++)
            left[i] = a[l + i];

        for(int j=0;j<n2;j++)
            right[j] = a[mid + 1 + j];

        int i=0,j=0;
        int k=l;
        while(i<n1&&j<n2){
            if(left[i]<right[j]){
                a[k]=left[i];
                i++;
            }
            else{
                a[k]=right[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            a[k]=left[i];
            i++;
            k++;
        }
        while(j<n2){
            a[k]=right[j];
            j++;
            k++;
        }
    }

    public static void quicksort(int[] a, int l, int r){

        if(l<r){
            int p = partition(a, l, r);
            quicksort(a,l,p-1);
            quicksort(a,p+1,r) ;
        }
    }

    public static int partition(int[] a,int l, int r){

        int pivot=a[r];
        int low=l-1;

        for(int i=l;i<r;i++){
            if(a[i]<pivot){
                low++;
                swap(a,low,i);
            }
        }
        swap(a,low+1,r);
        return low+1;
    }

    public static void swap(int[] a,int one, int two){
        int temp= a[one];
        a[one]=a[two];
        a[two]=temp;
    }

    public static void counting(int[] a){
        int max = max(a);
        int[] output = new int[a.length];

            int[] count = new int[max+1];
            for(int i=0;i<a.length;i++){
                count[a[i]]++;
            }
            for(int i=1;i<=max;i++){
                count[i]+=count[i-1];
            }
//            for(int i=max;i>0;i--){
//                count[i]=count[i-1];
//            }
//            count[0]=0;
            for(int i=a.length-1;i>=0;i--){
                output[count[a[i]]-1]=a[i];
                count[a[i]]--;
            }
            int j=0;
            for(int i: output)
                a[j++]=i;

    }

    public static int max(int[] a){
        int max = Integer.MIN_VALUE;
        for(int i:a)
            if(i>max)
                max=i;
        return max;
    }

    public static void main(String[] args) {
        int[] a = {3,6,8,2,1,9,5};
//        Merge(a,0,a.length-1);
        counting(a);
        System.out.println(Arrays.toString(a));
    }

}
