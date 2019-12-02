import java.util.concurrent.Semaphore;
import java.text.BreakIterator;
import java.util.ArrayList;

class WriterReadersFirst {

    static Preparador accessToBase = new Preparador();

    public static ArrayList<Integer> usedIndexes = new ArrayList<>();

	static int readerCount = 0;
    static Semaphore x = new Semaphore(1);
    static Semaphore wsem = new Semaphore(1);

    //Classes de Readers e Writers 

    static class Read implements Runnable {
        @Override
        public void run() {
            try {
                x.acquire();
                readerCount++;
                if (readerCount == 1) wsem.acquire();
                x.release();

                //System.out.println("Thread "+Thread.currentThread().getName() + " is READING");
                

                System.out.println(accessToBase.base.get(4565));//<----Le valor na base

                //System.out.println("Thread "+Thread.currentThread().getName() + " has FINISHED READING");
                
                x.acquire();
                readerCount--;
                if (readerCount == 0) wsem.release();
                x.release();

            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static class Write implements Runnable {
        @Override
        public void run() {
            // try {
            //     for(int i=1; i<100 ; i++){

            try {
                wsem.acquire();
                //System.out.println("Thread "+Thread.currentThread().getName() + " is WRITING");
                
                
                accessToBase.base.set(4565,"MODIFICADO") ;//<----Muda valor na base

                //System.out.println("Thread "+Thread.currentThread().getName() + " has finished WRITING");
                wsem.release();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
               // }    
            //     Thread.sleep(1);
            // } catch (InterruptedException e) {
            //     System.out.println(e.getMessage());
            // }
        }
    }


    //Instacia para tratar inicialização BD 
    
    public static void inicializaDB(){
        try{
            Preparador.imputBD();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static int numeroAleatorio(){
        int numero = (int) (Math.random() * 100);
        return numero;
    }

    public static int validIndex(){

        int index = numeroAleatorio();
        if((usedIndexes.contains(index))){
            index = validIndex();
        }
        usedIndexes.add(index);

        return index;

    }

    //Distribuicao das threads de acordo com aleatoriedade 

    public static Thread [] distribuiThreads(Thread [] threads, int nReaders){

        Read read = new Read();
        Write write = new Write();

        for(int i = 0; i < nReaders; i++){

            int index = validIndex();
            threads[index] = new Thread(read);
            threads[index].setName("thread reader "+i);

        }

        int nWriters = (threads.length-nReaders);

        for(int i = 0; i < nWriters; i++){

            int index = validIndex();
            threads[index] = new Thread(write);
            threads[index].setName("thread writer "+i);

        }

        return threads;
    }

    // COLOCAR NUMERO QUE O ARRAY DE THREADS TERA DE READERS 

    public static Thread [] inicializaArrayDeThreads(){

        Thread [] threads  = new Thread[100] ;

        threads = distribuiThreads(threads,35);//<--COLOCAR NUMERO DE READERS

        return threads;

    }

    // Rodas as threads instanciadas

    public static void runReadersAndWriters(Thread [] t){

        for(int i = 0;i<1;i++){

            t[i].start();
            //join(); //implementar join 
        }

    }
    
    // Inicializacao geral do programa 

    public static void inicializador(){

        inicializaDB();

        Thread [] objDeThreads  = inicializaArrayDeThreads();

        //insereReaderEWriter(objDeThreads);
        runReadersAndWriters(objDeThreads);

    }
    

    // public static void main(String[] args) throws Exception {

        
    //     inicializadorThreads();


        
        
    // }
}
