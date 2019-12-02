

class ObjectArray{
  
  public static Processo [] inicializaArrayDeThreads(){
    Processo obj [] = new Processo[100] ;

    for(int i=0; i <100; i ++){
      obj[i] = new Processo();
      obj[i].setData("vazio");
    }
    return obj;

  }

  public static void mostrarClasses(Processo [] objDeThreads){
    for(int i=0; i <100; i ++){
      objDeThreads[i].showData();
    }
  }
  public static void main(String args[]){
    Processo objDeThreads [] = inicializaArrayDeThreads();

    //insereReaderEWriter(objDeThreads);
    mostrarClasses(objDeThreads);

  }
}

