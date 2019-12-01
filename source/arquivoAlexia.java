
class ObjectArray{
  
  public static Processo[] inicializaArrayDeThreads(){
    Processo obj [] = new Processo[100] ;
    return obj;  
  }
  
  // gera um numero aleatorio
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

  public static void mostrarClasses(Processo [] objDeThreads){
    for(int i=0; i <100; i ++){
      objDeThreads[i].showData();
    }
  }

   public static void main(final String args[]){
      final Processo objDeThreads [] = inicializaArrayDeThreads();
      // Processo[] objDeThreads, int nReaders, int nWriters
      insereReaderEWriter(objDeThreads, 100, 0);
      mostrarClasses(objDeThreads);

  }

}





