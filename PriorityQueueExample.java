import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueueExample {
    public static PriorityQueue ltr = new PriorityQueue();
    public static HashMap<String,Integer> map =new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Number of letters");
        int n=Integer.parseInt(in.nextLine());
        for(int i=0;i<n;i++)
        {
            insert(in.nextLine());
            System.out.println("Most Frequent Letter is:"+mostFreq());
        }
        System.out.println("How many do you want to remove?");
        int k=Integer.parseInt(in.nextLine());
        for(int i=0;i<k;i++)
        {
            remove(in.nextLine());
            System.out.println("Most Frequent Letter with freq:"+mostFreq());
        }


    }
    public static void insert(String a){
        if (map.containsKey(a))
        {

            ltr.remove(new Letter(a,map.get(a)));

            ltr.add(new Letter(a,map.get(a)+1));
            map.put(a,map.get(a)+1);
        }
        else
        {
            ltr.add(new Letter(a,1));
            map.put(a,1);
        }

    }
    public static void remove(String a)
    {
        if (map.containsKey(a))
        {
            if(map.get(a)>1) {
                //System.out.println(map.get(a));
                ltr.remove(new Letter(a,map.get(a)));
                ltr.add(new Letter(a, map.get(a) - 1));
                map.put(a,map.get(a)-1);
            }
            else
            {
                ltr.remove(new Letter(a, map.get(a)));
                map.remove(a);
            }
        }
        else
        {
            System.out.println("String does not exist");
        }

    }
    public static String mostFreq()
    {
        Letter k=(Letter)ltr.peek();
        String s=k.getLetter()+"_"+Integer.toString(k.getfreq());
        return s;
    }

}
class Letter implements Comparable<Letter> {
    public String letter;
    public int freq;

    // A parameterized student constructor
    public Letter(String letter, int freq) {

        this.letter = letter;
        this.freq = freq;
    }

    public String getLetter() {
        return letter;
    }
    public int getfreq() {
        return freq;
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Letter)) return false;

        Letter element = (Letter) o;

        if(this.freq != element.freq || !this.letter.equals(element.letter) ) return false;

        return true;
    }
    @Override
    public int compareTo(Letter s2) {
        if (this.freq < s2.freq)
            return 1;
        else if (this.freq > s2.freq)
            return -1;
        return 0;
    }
}
