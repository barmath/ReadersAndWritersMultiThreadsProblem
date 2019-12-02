package ep2so;
import java.text.BreakIterator;
import java.util.ArrayList;

class t{
    // array dos indices ja usados pelo array de threads
    public static ArrayList<Integer> usedIndexes = new ArrayList<>();

    // insere string "vazio" em todo o array e o retorna
    public static String []  inicializa(String [] arr){
        for(int i = 0; i < arr.length; i++){
            arr[i] = "vazio";
        }
        return arr;
    }

    // retorna pseudorandom inteiro para indices de 0 a 99
    public static int numeroAleatorio(){
        int numero = (int) (Math.random() * 100);
        return numero;
    }

    // retorna um inteiro aleatorio que nao consta no array de indices usados
    public static int validIndex(ArrayList<Integer> used){
        int index = numeroAleatorio();
        if((used.contains(index))){
            index = validIndex(used);
        }else{
            used.add(index);
        }
        return index;
    }

    // retorna arranjo de strings "readers" ou "writers" em posicoes aleatorias
    public static String [] distribuiWR(String [] arr, int nReaders){

        for(int i = 0; i < nReaders; i++){
            int index = validIndex(usedIndexes);
            arr[index] = "Reader";
        }

        int nWriters = (arr.length - nReaders);

        for(int i = 0; i < nWriters; i++){
            int index = validIndex(usedIndexes);
            arr[index] = "Writer";
        }
        return arr;

    }

    public static void main(String [] args){
        // array de threads
        String [] arr = new String [100];

        // atribui vazio as 100 threads
        inicializa(arr);

        // atribui reader ou writer de forma aleatoria no arranjo
        distribuiWR(arr,38);

        //System.out.println(used);
        System.out.println(usedIndexes);

        // contador de reader e writer
        int j = 0 ;
        int k = 0 ;
        for(int i = 0; i < arr.length; i++){
            if(arr[i].equals("Reader"))
                j++;
            if(arr[i].equals("Writer"))
                k++;
            System.out.println(arr[i]);
        }
        System.out.println("numero de readers " + j);
        System.out.println("numero de writers " + k);

    }
}