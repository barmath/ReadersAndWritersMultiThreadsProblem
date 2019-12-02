import java.util.concurrent.Semaphore;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/*
Classe para acesso dos readers e writers
*/

class WriterReadersFirst {

    static Preparador accessToBase = new Preparador();
    public static ArrayList<Integer> usedIndexes = new ArrayList<>();
    public static ArrayList<Integer> usedAcessDB = new ArrayList<>();
	static int readerCount = 0;
    static Semaphore x = new Semaphore(1);
    static Semaphore wsem = new Semaphore(1);

    // Classe de Read
    static class Read implements Runnable {
        @Override
        public void run() {
            try {
                x.acquire(); // thread x fazer leitura
                readerCount++;
                if (readerCount == 1) wsem.acquire(); // thread wsem fazer leitura
                x.release(); // thread x liberada

                // 
                for(int i = 0; i<100 ; i++){
                    //System.out.println("Thread "+Thread.currentThread().getName() + " is READING");
                    int indexToRead =  validAccess(usedAcessDB);
                    //System.out.println(accessToBase.base.get(indexToRead));//<----Le valor na base
                    accessToBase.base.get(indexToRead);
                    //System.out.println("Thread "+Thread.currentThread().getName() + " has FINISHED READING");"
                }
                x.acquire();
                readerCount--;
                if (readerCount == 0) wsem.release();
                x.release();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    // Classe Write
    static class Write implements Runnable {
        @Override
        public void run() {
            try {
                wsem.acquire(); //<--Trava regiao critica antes 100 acessos
                for(int i=1; i<100 ; i++){
                    // try {
                        //System.out.println("Thread "+Thread.currentThread().getName() + " is WRITING");
                        int indexToWrite =  validAccess(usedAcessDB);
                        //System.out.println(accessToBase.base.get(indexToWrite));
                        accessToBase.base.set(indexToWrite,"MODIFICADO") ;//<----Escreve valor na base
                        //System.out.println(accessToBase.base.get(indexToWrite));
                       // System.out.println("Thread "+Thread.currentThread().getName() + " has finished WRITING at index "+indexToWrite);
                    // } catch (InterruptedException e) {
                    //     System.out.println(e.getMessage());
                    // }
                }  
                Thread.sleep(1);
                wsem.release(); //<--Liberando regiao critica depois 100 acessos
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
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

    // numero pseudoramdomico
    public static int numeroAleatorio(){
        int numero = (int) (Math.random() * 100);
        return numero;
    }

    // random para thread
    public static int numeroAleatorioB(){
        //RandomNumberGenerator ramd = new RandomNumberGenerator();
        int tamanhoDaBase = accessToBase.base.size();
        int index = RandomNumberGenerator.usingThreadLocalClass(tamanhoDaBase);
        return index;
    }

    // 
    public static int validAccess(ArrayList<Integer> useds){
        int index = numeroAleatorioB();
        if((useds.contains(index))){
            index = validAccess(useds);
        }else{
            useds.add(index);
        }
        return index;
    }

    public static int validIndex(ArrayList<Integer> useds){
        int index = numeroAleatorio();
        if((useds.contains(index))){
            index = validIndex(useds);
        }else{
            useds.add(index);
        }
        return index;
    }

    //Distribuicao das threads de acordo com aleatoriedade 
    public static Thread [] distribuiThreads(Thread [] threads, int nReaders){
        Read read = new Read();
        Write write = new Write();
        for(int i = 0; i < nReaders; i++){
            int index = validIndex(usedIndexes);
            threads[index] = new Thread(read);
            threads[index].setName("reader "+i);
        }

        int nWriters = (threads.length-nReaders);
        for(int i = 0; i < nWriters; i++){
            int index = validIndex(usedIndexes);
            threads[index] = new Thread(write);
            threads[index].setName("writer "+i);
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
        for(int i = 0;i<100;i++){
            t[i].start();
        }
    }

    // Inicializacao geral do programa 
    public static void inicializador(){
        inicializaDB();
        Thread [] objDeThreads  = inicializaArrayDeThreads();
        long startTime = System.currentTimeMillis();
        runReadersAndWriters(objDeThreads);
        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;
        System.out.println("tempo de execução total = "+timeElapsed);
    }
 
}