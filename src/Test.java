
public class Test{
  public static void main(String args[]){
      int m = 60324234;
      int n = 24123412;
      gcdMachine(m,n);
  } 
  // checkstyle error typeName error G should be lowercase
  public static void gcdMachine(int m, int n){
        int r = 0;
        int timeComplex = 0;
        
        while (n != 0){
            r = m % n;
            m = n;
            n = r; 
            timeComplex++;
        }
        System.out.print("the GCD is " + m + " the program ran for " + timeComplex);

    }
}
