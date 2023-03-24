import java.util.ArrayList;
import java.util.Scanner;
class Heap{
    private int n;
    private ArrayList<Integer> array;
    private final int Heapsize;




    public Heap (ArrayList<Integer> array,int n){
        this.array = array;
        Heapsize = n;
        this.n = n;
    }
    /*
    1. От середины массива идет сравнение  элемента с листьями(больший лист встает на место корня).
    Далее новый лист(здесь как корень) сравнивается с его листьями и также меняется
     */
    protected void Heapify(int i){
        int parent = (i-1)/2;
        int l  = 2*i+1;
        int r = 2*i+2;
        int biggest = i;
        if (l<Heapsize && (array.get(l)-array.get(i)>0))
            biggest = l;
        if (r<Heapsize && (array.get(r)-array.get(biggest))>0)
            biggest = r;
        if (biggest != i)
        {
            int temp = array.get(i);
            array.set(i, array.get(biggest));
            array.set(biggest,temp);

            Heapify(biggest);
        }
    }
    // создается куча
    protected void CreateMaxHeapHeap(int n){
        int i = ((n-1)/2);
        while(i>=0){
            Heapify(i);
            i--;
        }
    }


}
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> array = new ArrayList<>();
        int n = Integer.parseInt(in.nextLine());
        String[] str = in.nextLine().split(" ");
        int a = Integer.parseInt(str[1]);
        array.add(a);
        var heap = new Heap(array,array.size());
        for(int i = 1; i < n; i++){
            String[] str1 = in.nextLine().split(" ");
            switch (str1[0]){
                case "0":{
                    array.add(Integer.parseInt(str1[1]));
                    heap.Heapify(array.size());
                    continue;
                }
                case"1":{

                    int max = array.get(0);
                    int imax =0;
                    for(int ii = 0; ii < array.size();ii++){
                        if (array.get(ii)>max) {
                            max = array.get(ii);
                            imax = ii;
                        }
                    }
                    array.remove(imax);
                    System.out.println(max);
                    heap.Heapify(array.size());
                    continue;
                }
                default:break;
            }
        }
    }
}
