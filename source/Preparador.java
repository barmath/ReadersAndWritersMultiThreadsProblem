
import java.io.*;
import java.util.*;


class Preparador {

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

        ArrayList<String> base = new ArrayList<String>();

        base = agrupadorDePalavra(enderoA);  

        //System.out.println(base);
        
           
    }

    //InicializadorThreads 

    public static Processo [] inicializaArrayDeThreads(){
      
      Processo obj [] = new Processo[100] ;

      for(int i=0; i <100; i ++){

        obj[i] = new Processo();
        obj[i].setData("vazio");

      }

      return obj;

    }

    public static int numeroAleatorio(){
        int numero = (int) (Math.random() * 100);
        return numero;
    }

    public static Processo[] insereReaderEWriter(Processo[] objDeThreads,int nReaders,int nWriters){
        // insere readers aleatoriamente na array de 100 threads
        //if (nReaders!=0){

            ArrayList<Integer> usados = new ArrayList<Integer>();
            
            for(int i=0; i<nReaders; i++){
                int indiceR = numeroAleatorio();
                if(usados.contains(indiceR)){
                    indiceR = numeroAleatorio();
                }else{
                    usados.add(indiceR,indiceR);
                    objDeThreads[indiceR].setData("Reader");
                    //System.out.println(i+" : "+indiceR+" Reader");
                }
    
            }

        // else{
            
        // }

        // insere writers na array de 100 threads
        for(int i=0; nWriters!=0 && i<nWriters; i++){
            int indiceR = numeroAleatorio();
            if(usados.contains(indiceR)){
                indiceR = numeroAleatorio();
            }else{
                usados.add(indiceR,indiceR);
                objDeThreads[indiceR].setData("Readers");
                //System.out.println(i+" : "+indiceR+" Writer");
            }
        }

        System.out.println(usados);

        return objDeThreads;
    }


    public static void mostrarClasses(Processo [] objDeThreads){

       for(int i=0; i <100; i ++){
          objDeThreads[i].showData();
       }
    }

    public static void inicializadorThreads() throws Exception {

        Processo objDeThreads [] = inicializaArrayDeThreads();

        insereReaderEWriter(objDeThreads,50,50);

        //mostrarClasses(objDeThreads);

    }

	public static void main(String [] args) throws Exception {

        imputBD();
        inicializadorThreads();

	}
}
