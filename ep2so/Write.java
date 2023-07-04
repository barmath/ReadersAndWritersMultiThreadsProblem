/*
static class Write implements Runnable {
        public void run() {
            try {
                wsem.acquire();//<--Travando regiao critica antes 100 acessos
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
*/