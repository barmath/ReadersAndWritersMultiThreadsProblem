/* 
Parte de imput de texto do EP1 SO
*/
/*
import java.io.*;
import java.util.*;

class Preparador {

    private static String valorInicialX = "Y=0";
    private static String valorInicialY = "X=0";

    //private static LinkedList<String> BCP = new LinkedList();
    public static ArrayList<String> agrupadorDeCodigo(String endereco) throws Exception  {

        File file = new File(endereco);
        Scanner sc = new Scanner(file);
        ArrayList<String> codigo = new ArrayList<String>();
        //int j = 0;
        while (sc.hasNextLine()){
            //System.out.println(sc.nextLine());
            codigo.add(sc.nextLine());
        //    j++;
        }
        sc.close();
        return codigo;
    } 

    public static void imputProcessos()  throws Exception {
        String numeroDoProcesso = "01";
        String enderoA = "../processos/"+numeroDoProcesso+".txt" ;
        ArrayList<String> subrotina = new ArrayList<String>();
        Processo processA = new Processo();
        subrotina = agrupadorDeCodigo(enderoA);  
        processA.mudaValores(valorInicialY);
        processA.mudaValores(valorInicialX);
        System.out.println(processA.x);
        System.out.println(processA.y);
    }
	public static void main(String [] args) throws Exception {
        imputProcessos();
	}
}
*/