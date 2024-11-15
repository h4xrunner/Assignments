import java.util.ArrayList;
import java.util.Arrays;
class second{
    public static ArrayList<Integer> dividerInts = new ArrayList<Integer>();
        public static void main(String[] args) {
            int seconds = 187;
            int minutes = seconds/60;
            if (seconds%60>0){
                minutes++;
            }
            System.out.println(minutes);
            System.out.println(factorial(5));
            System.out.println(isPrime(227));
            isPrimeDividers(2038);
            System.out.println(1.5+2.0);
            int i =0;
            int j = 0;
            if(i++>2){

            }   
            System.out.println(i);         
    
            
        }
        static int factorial(int n){
            int sum=1;
            for (int i = 1; i<=n;i++) {
                sum=sum*i;
    
            }
            return sum;
        }
        static boolean isLeapYear(int n){
           boolean a=false;
            if(n%400==0){
                a=true;
                
            }
            else if(n%100==0){
                a=false;
            }else if(n%4==0){
                a=true;
            } 
            return a;
            
            
        }
        static void isPrimeDividers(int n){
            
            if(isPrime(n)==true){
                System.out.println(dividerInts);
            }
        }
        public static boolean isPrime(int n){
            
            boolean isPrime=false;
            if(n==2){
                isPrime=true;
            }else if(n==1){
                isPrime=false;
            }else{
                for (int i = 2; i < n; i++) {
                    if(n%i==0){
                        isPrime=false;
                        dividerInts.add(i);

                    
                }else{
                    isPrime = true;
                }
            }
        }


        return isPrime;
        
        }
    
}