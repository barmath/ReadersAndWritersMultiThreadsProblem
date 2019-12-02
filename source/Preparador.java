
import java.io.*;
import java.util.*;

class Preparador {
    // inicializa array para estrutura de dados
    public static ArrayList<String> base = new ArrayList<String>();

    // insere array com as palavras de bd.txt 
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
        System.out.println("Estrutura de base instanciada");
        //System.out.println(base.size());
    }
	public static void main(String [] args) throws Exception {
        //WriterReadersFirst wr = new WriterReadersFirst();
        //imputBD();
        //inicializadorThreads();
        WriterReadersFirst.inicializador();
	}
}
