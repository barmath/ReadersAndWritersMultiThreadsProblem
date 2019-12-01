import java.util.concurrent.Semaphore;

class WriterReadersFirst {

	static int readerCount = 0;
    static Semaphore x = new Semaphore(1);
    static Semaphore wsem = new Semaphore(1);

    static class Read implements Runnable {
        @Override
        public void run() {
            try {
                x.acquire();
                readerCount++;
                if (readerCount == 1) wsem.acquire();
                x.release();

                System.out.println("Thread "+Thread.currentThread().getName() + " is READING");
                Thread.sleep(1500);
                System.out.println("Thread "+Thread.currentThread().getName() + " has FINISHED READING");
                
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
            try {
                wsem.acquire();
                System.out.println("Thread "+Thread.currentThread().getName() + " is WRITING");
                Thread.sleep(2500);
                System.out.println("Thread "+Thread.currentThread().getName() + " has finished WRITING");
                wsem.release();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static Thread [] inicializaArrayDeThreads(){

        Read read = new Read();
        Write write = new Write();

        Thread [] obj  = new Thread[100] ;

        for(int i=0; i <100; i ++){

            obj[i] = new Thread(write);
            obj[i].setName("thread"+i);

        }

        return obj;

    }

    

    public static void runReadersAndWriters(Thread [] t){

        for(int i = 0;i<100;i++){

            t[i].start();
            join(0);
        }

    }
    

    public static void inicializadorThreads(){
        Thread [] objDeThreads  = inicializaArrayDeThreads();
        insereReaderEWriter(objDeThreads, 100, 0);
        runReadersAndWriters(objDeThreads);

    }
    

    public static void main(String[] args) throws Exception {

        
        inicializadorThreads();
        
        
    }
}
