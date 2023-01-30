import java.util.*;

public class main{
    public static Scanner sc = new Scanner(System.in);
    public static int initInt(){
        int n;
        do{
            System.out.println("Enter a number");
            n = sc.nextInt();
        }while(n < 0);
        return n;
    }

    public static double initDouble(){
        double d;
        do{
            System.out.println("Enter a number");
            d = sc.nextDouble();
        }while(d < 0);
        return d;
    }
    public static void print(Competitor[] competitors){
        for(int i = 0; i < competitors.length; i++){
            competitors[i].printInfo();
        }
    }
    public static void rate(Competitor[] competitors){
        System.out.println("unsorted");
        print(competitors);
        int n = competitors.length;
        for (int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - i - 1; j++){
                if(competitors[j].maxPoints < competitors[j + 1].maxPoints){
                    Competitor temp =competitors[j];
                    competitors[j] = competitors[j + 1];
                    competitors[j + 1] = temp;
                }
            }
        }
        System.out.println("sorted");
        print(competitors);
    }
    /* 
    public static HashMap<String, int> sortByValue(HashMap<String, int> s){
        List<Map.Entry<String, int> > list = new LinkedList<Map.Entry<String, int> >(s.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, int> >()){
            public int compare(Map.Entry<String, int> o1, Map.Entry<String, int> o2 )
        }

    }
    */
    /* */
    public static void sortBySchool(Competitor[] c){
        
        ArrayList<String> sN = new ArrayList<String>();
        ArrayList<Double> sP = new ArrayList<Double>();
        for(int i = 0; i < c.length; i ++){
            if(sN.indexOf(c[i].getSchool()) == - 1){
                sN.add(i, c[i].getSchool());
                sP.add(i, c[i].maxPoints);
            }else{
                sP.add(sN.indexOf(c[i].getSchool()), sP.get(sN.indexOf(c[i].getSchool())) + c[i].maxPoints);
            }
        }
        /* 
        for(int i = 0; i < sP.size() - 1; i++){
            for(int j = 0; j < sP.size() - i - 1; j++){
                if(sP.get(j) < sP.get(j + 1)){
                    double temp1 = sP.get(j);
                    String temp2 = sN.get(j);
                    sP.set(j, sP.get(j + 1));
                    sN.set(j, sN.get(j + 1));
                    sP.set(j + 1, temp1); 
                    sN.set(j + 1, temp2);
                }
            }
        }
        */
        for(int i = 0; i < sP.size(); i++){
            System.out.println("School: " + sN.get(i));
            System.out.println("School points: " + sP.get(i));
        }
    }
    
    public static void main(String[] args){

        int size = initInt();
        Competitor[] competitors = new Competitor[size];
        //HashMap<String, int> schoolPoints = new HashMap<>();

        for(int i = 0; i < size; i++){
            competitors[i] = new Competitor();

            System.out.println("Competitor " + (i + 1));
            System.out.println("Name: ");
            competitors[i].setName(sc.next());
            System.out.println("School: ");
            competitors[i].setSchool(sc.next());
            System.out.println("Number of tries ");
            competitors[i].tries = initInt();
            for(int j = 0; j < competitors[i].tries; j++){
                System.out.println("X: ");
                double x = initDouble();
                System.out.println("Y: ");
                double y = initDouble();
                if(Math.hypot(x, y) > 10){
                    competitors[i].points.add(j, 0);
                }else if(Math.hypot(x, y) == 10 || Math.hypot(x, y) < 10 && Math.hypot(x, y) > 5){
                    competitors[i].points.add(j,1);
                }else if(Math.hypot(x, y) == 5 || Math.hypot(x, y) < 5 && Math.hypot(x, y) > 2.5){
                    competitors[i].points.add(j, 5);
                }else{
                    competitors[i].points.add(j, 10);
                }
            }
            /* 
            if(schoolPoints.containsKey(competitors[i].getSchool())){
                schoolPoints.replace(competitors[i].getSchool(), schoolPoints.get(competitors[i].getSchool()) + competitors[i].maxPoints); 
            }else{
                schoolPoints.put(competitors[i].getSchool(), competitors[i].maxPoints);
            }
            */
        }
        rate(competitors);
        sortBySchool(competitors);
    }
}