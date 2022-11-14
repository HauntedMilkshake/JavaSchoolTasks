import java.util.*;
  
public class main {
    public static Scanner sc = new Scanner(System.in);
       
    public static void menu(ColorCube[] cubeArray){
        System.out.println("///////////////////////////////////////////////////////////////////////////////////");
        System.out.println("     MENU     ");
        System.out.println("1 Search by color");
        System.out.println("2 Search by volume ");
        System.out.println("3 Exit");
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                searchByColor (cubeArray);
                menu (cubeArray);
                break;
            case 2:
                searchByVolume (cubeArray);
                menu (cubeArray);
                break;
            case 3:
                break;
        }
    }

    public static void searchByColor(ColorCube[] cubeArray){
        System.out.println("Color: ");
        String input = sc.next();
        int occurance = 0;
        for(int i = 0; i < cubeArray.length; i++){
            if(cubeArray[i].color.equals(input)){
                System.out.println("Cube with the same color found at: " + (i + 1));
                cubeArray[i].printInfo();
                occurance++;
            }
        }
        System.out.println("Number of occurances: " + occurance);
    }
    
    public static void searchByVolume(ColorCube[] cubeArray){
        System.out.println("Volume: ");
        double input = sc.nextDouble();
        int occurance = 0;
        for(int i = 0; i < cubeArray.length; i++){
            if(input == cubeArray[i].volume()){
                System.out.println("Found cube with the same volume at: " + (i + 1));
                cubeArray[i].printInfo();
                occurance++;
            }
        }
        System.out.println("Number of occurances: " + occurance);
    }

    public static double initD(){
        double n; 
        do{           
            n = sc.nextDouble();
        }while(n < 0);
        return n;
    }

    public static int initI(){
        int n;
        do{   
            n = sc.nextInt();
        }while(n < 0);
        return n;
    }
    public static void main(String[] args) {
        //init 
        int size;
        System.out.println("Number of cubes: ");
        size = initI();

        ColorCube cubeArray[] = new ColorCube[size];
        for(int i = 0; i < cubeArray.length; i++){
         cubeArray[i] = new ColorCube();
        }
 
        for(int i = 0; i < cubeArray.length; i++){
            System.out.println("Cube " + (i + 1) + ": ");
            System.out.println("x: " + " ");
            cubeArray[i].x = initD();
            System.out.println("y: " + " ");
            cubeArray[i].y = initD();
            System.out.println("z: " + " ");
            cubeArray[i].z = initD();
            System.out.println("color " + " ");
            cubeArray[i].color = sc.next();
            }
        menu(cubeArray);
        }
    }