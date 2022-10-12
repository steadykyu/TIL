import java.util.*;
class Lecture implements Comparable<Lecture>{
    public int money;
    public int date;
    Lecture(int money, int date){
        this.money = money;
        this.date = date;
    }
    @Override
    public int compareTo(Lecture o){
        return o.date - this.date;
    }
}
class Main {
    static int n, max = Integer.MIN_VALUE;
    public int solution(ArrayList<Lecture> arr){
        int answer=0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(arr);
        int j=0;
        // 일자에 대한 for문
        for(int i=max; i>=1; i--){
            for( ; j<n; j++){
                if(arr.get(j).date<i) break;
                pQ.offer(arr.get(j).money);
            }
            if(!pQ.isEmpty()) answer += pQ.poll();
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        ArrayList<Lecture> arr = new ArrayList<Lecture>();
        for(int i=0; i<n; i++){
            int m = kb.nextInt();
            int d = kb.nextInt();
            arr.add(new Lecture(m,d));
            if(d>max) max = d;  // 최대 일수를 max에 넣는다.
        }
        System.out.println(T.solution(arr));
    }
}
