
public class myClass {
    public static void main(String[] args) {
        int m = 60;
        int n = 24;
        GcdMachine(m,n);
    }
   //checkstyle error typeName isnt correct not pascalCase
   public static void GcdMachine(int m, int n){
     int r = 0;
     int timeComplex = 0;

     while (n != 0) {
            r = m % n;
            m = n;
            n = r;
            timeComplex++;
        }
     System.out.println("The GCD is " + m + " and the program ran for " + timeComplex + " iterations.");

   }
}
