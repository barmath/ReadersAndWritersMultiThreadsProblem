import java.util.*;

class Processo{

    String x;
    String y;

    public String [] separador(String comando){


       String [] arr = comando.split("=",2);


       return arr;

    }

    public void mudaValores(String comando){

        String [] valores = separador(comando);

        // System.out.println(valores[0]);
        // System.out.println(valores[1]);

        if ( valores[0].equals("X")){
            
            this.x = valores[1];

        }else
        {
            this.y = valores[1];
        }
        

    }
}