import java.io.*;
import java.util.*;

class Obj{
    private static int index;

    public Obj(int index){
        this.index = index;
    }
    public void set(int n){
        this.index = n;
    }
    public void get(){
        System.out.println(this.index);
    }
}