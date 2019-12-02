import java.text.BreakIterator;
import java.util.ArrayList;

class t{

    public static ArrayList<Integer> usedIndexes = new ArrayList<>();

    public static String []  inicializa(String [] arr){
        
        for(int i = 0; i < arr.length; i++){
            arr[i] = "vazio";
        }

        return arr;
    }

    public static int numeroAleatorio(){
        int numero = (int) (Math.random() * 100);
        return numero;
    }

    public static int validIndex(){

        

        int index = numeroAleatorio();
        //System.out.println((usedIndexes.contains(index)));
        if((usedIndexes.contains(index))){
            index = validIndex();
        }
        usedIndexes.add(index);

        return index;

    }

    public static String [] distribuiWR(String [] arr, int nReaders){

        for(int i = 0; i < nReaders; i++){
            int index = validIndex();
            arr[index] = "Reader";
        }

        int nWriters = (arr.length-nReaders);

        for(int i = 0; i < nWriters; i++){
            int index = validIndex();
            arr[index] = "Writer";
        }
        return arr;

    }

    public static void main(String [] args){

        String [] arr = new String [100];

        inicializa(arr);

        distribuiWR(arr,38);

        int j = 0 ;
        int k = 0 ;

        for(int i = 0; i < arr.length; i++){
            if(arr[i].equals("Reader"))
                j++;
            if(arr[i].equals("Writer"))
                k++;
            System.out.println(arr[i]);
        }

        System.out.println("numero de readers "+j);
        System.out.println("numero de writers "+k);

    }
}