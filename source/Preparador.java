
import java.io.*;
import java.util.*;



class Preparador {

    public static ArrayList<String> base = new ArrayList<String>();

    //Imput BD 

    public static ArrayList<String> agrupadorDePalavra(String endereco) throws Exception  {


        File file = new File(endereco);
        Scanner sc = new Scanner(file);
        ArrayList<String> codigo = new ArrayList<String>();

        int j = 0;
        while (sc.hasNextLine()){
            //System.out.println(sc.nextLine());
            codigo.add(sc.nextLine());
            j++;
        }

        return codigo;

    } 
    public static void imputBD()  throws Exception {

        String enderoA = "../base/bd.txt" ;

        //ArrayList<String> base = new ArrayList<String>();

        base = agrupadorDePalavra(enderoA);  

        //System.out.println(base);
        System.out.println("base instanciada");

        
       
    }

    //InicializadorThreads 

    // public static Processo [] inicializaArrayDeThreads(){
      
    //   Processo obj [] = new Processo[100] ;

    //   for(int i=0; i <100; i ++){

    //     obj[i] = new Processo();
    //     obj[i].setData("vazio");

    //   }

    //   return obj;

    // }

    // public static int numeroAleatorio(){
    //     int numero = (int) (Math.random() * 100);
    //     return numero;
    // }

    // public static Processo[] insereReaderEWriter(Processo[] objDeThreads,int nReaders){
        
        

    //     return objDeThreads;
    // }


    // public static void mostrarClasses(Processo [] objDeThreads){

    //    for(int i=0; i <100; i ++){
    //       objDeThreads[i].showData();
    //    }
    // }

    // public static void inicializadorThreads() throws Exception {

    //     Processo objDeThreads [] = inicializaArrayDeThreads();

    //     insereReaderEWriter(objDeThreads,50);

    //     //mostrarClasses(objDeThreads);

    // }

	public static void main(String [] args) throws Exception {

        //WriterReadersFirst wr = new WriterReadersFirst();

        //imputBD();
        //inicializadorThreads();

        WriterReadersFirst.inicializador();

        

	}
}
