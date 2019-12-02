class Processo{
  private static String a;
  public void setData(String b){
    a = b;
  }

  public static String getData(){
  	return a;
  }

  public void showData(){
    System.out.println("Tipo da classe : " + a);
  }
}
