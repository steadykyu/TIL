# what is Comparable interface? 

This interface imposes a total ordering on the objects of each class that implements it. This ordering is referred to as the class's natural ordering, and the class's compareTo method is referred to as its natural comparison method.

Lists (and arrays) of objects that implement this interface can be sorted automatically by Collections.sort (and Arrays.sort)

클래스 객체들에게 순서를 부과하는 인터페이스이다. 이떄 순서는 해당 클래스만의 natural ordering(순서)를 참조하고, 클래스속의 compareTo() 메서드는 natural comparison method를 참조한다.

이 인터페이스를 구현한 객체들은 가진 List나 Array들은 Collections.sort (and Arrays.sort)로 sorted 될수 있다.

***
x.compareTo(y)

위의 설명대로 compareTo()는 객체와 객체의 순서를 비교하는 데 사용된다. 이때 대부분은 자기자신의 객체와 다른 객체의 순서를 비교하는데 사용된다.

그러므로 this.compareTo(p)라고 해보겠다. 

+ this > p  : return 1
+ this == p : return 0 
+ this < p  : return -1 

이는 이렇게도 표현할 수 있을 것이다. 

그리고 compareTo의 return 값에 따라 두 객체의 위치를 바꾸거나 유지해준다.
+ 정확한 원리는 모르겠다... 기본적으로 오름차순 상태를 유지하는 것 같다.

+ this-p > 0    return 1(자리 바꿈)
+ this-p == 0   return 0(자리 유지)
+ this-p < 0    return-1(자리 유지)

> 예시
```
ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ>
 * this          p           this - p           구조
 * 10           20              <0    : 정렬 순서 유지 -> 오름차순 유지됨
 * 20           10              >0    : 두 값의 위치를 바꿈 -> 오름차순 유지됨
 *
 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
 * this          p           p - this : 내림차순
```
# how to use?

> 예제 코드

```java
class Point implements Comparable<Point>{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y =y;
    }
    // Point p 에 들어오는 Point가 비교하는 점이다.
    @Override
    public int compareTo(Point p){
        if(this.x==p.x) return this.y-p.y;  // 오름차순
        else return this.x - p.x;           // 오름차순
    }
}

class Main {

    public static void main(String[] args){
        Main T = new Main();
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Point> arr = new ArrayList<>();

        for(int i=0 ; i<n; i++){
           int x=in.nextInt();
           int y=in.nextInt();

           arr.add(new Point(x,y));
        }
        Collections.sort(arr);
        for(Point p : arr) System.out.println(p.x + " "+ p.y);
    }
}
```