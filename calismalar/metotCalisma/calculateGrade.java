import java.util.Scanner;

class calculateGrade{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double physics;
        double math;
        double chemistry;
        System.out.println("Enter Math grade >> ");    
        math=scanner.nextDouble();
        System.out.println("Enter physics grade >>  ");
        physics=scanner.nextDouble();
        System.out.println("Enter chemistry");
        chemistry=scanner.nextDouble();
        double average = averageGrade(math, physics, chemistry);
        System.out.println(average);
        System.out.println(gradeLetter(average));
        
    }
    static double averageGrade(double math, double physics, double chemistry){
        double average = (math+physics+chemistry)/3;
        return average;
    }
    static String gradeLetter(double average){
        String letter;
        if(average<=59.5){
            letter="F";
        }else if(average<=69.5){
            letter="D";
        }else if(average<=79.5){
            letter="C";
        }else if(average<=89.5){
            letter="B";
        }else{
            letter="A";
        }
        return letter;
    }
    
}