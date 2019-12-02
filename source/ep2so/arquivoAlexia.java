/*
gera um numero aleatorio para indice aleatorio do array de threads
a partir do numero aleatorio, popula primeiro os readers e depois os writers
numero de readers e writers eh determinado pelos parametos no main
*/

class ObjectArray{
  // gera um numero aleatorio de 0 a 99. Trata-se de um pseudorandom
  public static int numeroAleatorio(){
    int numero = (int) (Math.random() * 100);
    return numero;
  }

  public static insereReaderEWriter(Processo[] objDeThreads,int nReaders,int nWriters){
    // insere readers aleatoriamente na array de 100 threads
    for(int i=0; nReaders!=0 && i<nReaders; i++){
        int indiceR = numeroAleatorio();
        obj[indeceR] = new Reader();
        objDeThreads[indice] = reader;
    }

    // insere writers na array de 100 threads
    for(int i=0; nWriters!=0 && i<nWriters; i++){
        obj[i] = new Processo();
        int indiceW = numeroAleatorio();
        objDeThreads[indice] = reader;
    }
  }

}