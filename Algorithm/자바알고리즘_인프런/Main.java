import java.util.*;
class Time implements Comparable<Time>{
    public int s,e;
    Time(int s, int e){
        this.s = s;
        this.e = e;
    }
    @Override
    public int compareTo(Time o){
        // 오름차순 형식
        if(this.e == o.e){return this.s - o.s;
        }else{return this.e - o.e;}
    }
}
class Main {
    // 조합구하기
    public int solution(ArrayList<Time> arr, int n){
        int cnt=0;
        Collections.sort(arr);
        int endTime = Integer.MIN_VALUE;
        for(Time ob : arr){
            if(endTime <= ob.s){
                cnt++;
                endTime = ob.e;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Time> arr = new ArrayList<Time>();
        for(int i=0; i<n; i++){
            int s=kb.nextInt();
            int e=kb.nextInt();
            arr.add(new Time(s,e));
        }
        System.out.println(T.solution(arr, n));
    }
}
