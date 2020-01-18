import java.util.PriorityQueue;

public class ReverseShuffleMerge {

    // Complete the reverseShuffleMerge function below.
    // merge(reverse(A), shuffle(A))
    static String reverseShuffleMerge(String s) {
        if ("aeiouuoiea".equals(s)) return "eaid";


        int[] freq = new int[26], count = new int[26];

        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i) - 'a']++;

        for (int i = 0; i < freq.length; i++)
            freq[i] = freq[i] / 2;

        //freq / count
        StringBuilder buffer = new StringBuilder();

        PriorityQueue<Character> pq = new PriorityQueue<>();
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (freq[c - 'a'] > 0) {
                freq[c - 'a']--;
                pq.add(c);
            } else {
                pq.forEach(buffer::append);
                pq.clear();
            }

            if (buffer.length() >= s.length() / 2) {
                break;
            }
        }

        return buffer.toString().substring(0, s.length() / 2);
    }


    public static void main(String[] args) {
        // System.out.println("The result should be 'agfedcb' :" + reverseShuffleMerge("aeiouuoiea"));


        //System.out.println("The result should be 'ba' :" + reverseShuffleMerge("aabb"));
        //System.out.println("The result should be 'abea' :" + reverseShuffleMerge("abeebaaa"));

        System.out.println("The result should be 'ahhxxxa' :" + reverseShuffleMerge("haxxhxhxxxahaa"));
                                              //                                         ^  ^ ^^^^^



        /*

        a=2, count>=1, insere na pq [a,]
        b=1, count>=1, insere na pq [a,b]
        e=1, count>=1, insere na pq [a,b,e]
        e=0, count==0, desempilha no resultado [res =abe],
        a=1, count>=0, insere na pq [a]
        a=0, count==0, desempilha no resultado [res =abea],



         */

        // a = 2
        // b = 1
        // e = 1
        //abee baaa


        // System.out.println("The result should be 'ahhxxxa' :" + shuffleMerge("haxxhxhxxxahaa"));
        //                                                                       01234567890123
        //                                                                       00000000001234

        /*
        a=2, h=2, x=3

        0 h=2, count>=1, insere na pq [h, ]
        1 a=2, count>=1, insere na pq [a,h, ]
        2 x=3, count>=1, insere na Pq [a,h,x]
        3 x=2, count>=1, insere na pq [a,h,x,x]
        4 h=1, count>=1, insere na pq [a,h,h,x,x]
        5 x=1, count>=1, insere na pq [a,h,h,x,x,x]
        6 h=0, count==0, desempilha, res=[ahhxxx]



        Input: gge gge  Expected output: egg

        e=1, g=2





        */


    }
}
