class Processo{
  private static String a;
  public void setData(String a){
    this.a = a;
  }
  public static String getData(){
  	return a;
  }
  public void showData(){
    System.out.println("Tipo da classe : "+a);
  }
}
