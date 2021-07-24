import java.util.Arrays;
import java.util.Hashtable;
import java.util.OptionalInt;
import java.util.Stack;

public class Sorts extends Exception{

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

    public static void MergeSorty(int[] a, int l, int r){
        if(l<r){
            int mid=l+(r-l)/2;
            MergeSorty(a,l,mid);
            MergeSorty(a,mid+1,r);
            Mergey(a,l,mid,r);
        }
    }

    public static void Mergey(int[] a, int l, int mid, int r){
        int lefty= mid-l+1;
        int righty= r-mid;
        int[] Lside = new int[lefty];
        int[] Rside = new int[righty];
        for(int i=0;i<lefty;i++)
            Lside[i]=a[l+i];
        for(int i=0;i<righty;i++)
            Rside[i]=a[mid+1+i];
        int i=0,j=0,k=l;
        while(i<lefty&&j<righty){
            if(Lside[i]<Rside[j])
                a[k++]=Lside[i++];
            else
                a[k++]=Rside[++j];
        }
        while(i<lefty)
            a[k++]=Lside[i++];
        while(j<righty)
            a[k++]=Rside[j++];

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


    public static void counter(int[] a){
        int max =max(a);
        int[] count = new int[max+1];
        for(int i=0;i<a.length;i++){
            count[a[i]]++;
        }
        System.out.println(Arrays.toString(count));
        for(int i=0;i<count.length-1;i++)
            count[i+1]+=count[i];
        int[] out = new int[a.length];
        System.out.println(Arrays.toString(count));
        for(int i=0;i<a.length;i++){
            out[count[a[i]]-1]=a[i];
            count[a[i]]--;
        }
        for(int i=0;i<a.length;i++)
            a[i]=out[i];
    }

    public static boolean check(int[] a, int k){
        Hashtable<Integer,Integer> hash = new Hashtable<>(a.length);
        for(int i=0;i<a.length;i++){
            if(hash.containsKey(a[i])) {
                int count =hash.get(a[i]);
                hash.put(a[i],count+1);
            }
            else
                hash.put(a[i],1);
        }
        System.out.println(hash.toString());
        for(Integer i : hash.values()){
            if(i==k) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a={5,5,3,7,5,1,8,3,2};
        System.out.println(check(a,3));
    }


//    public static void InOrder(Node root) {
//        Stack<Node> s = new Stack<>();
//        Node cur=root;
//        while(cur != null || !s.isEmpty()){
//            while(cur != null) {
//                s.push(cur);
//                cur = cur.getLeft();
//            }
//
//            cur = s.pop();
//            System.out.print(cur.data + " ");
//            cur = cur.getRight();
//        }
//    }




}
