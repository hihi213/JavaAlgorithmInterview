## 0. 두가지를 생각해냈다

### 방식 1. 자신과 자신의 뒤의 수만 비교(n^2)
### 방식 2. target-자신==num[i]

------

## 1. 방식 1를 그냥 해봤다
### 코드가 너무 더러워 생략한다


-----
## 2. 방식 1를 덜 반복하도록 해봤다
### 코드가 더러워 생략한다

-----
## 3. 2번에서 한가지를 추가했다.
### 배열길이가 2일때 무조건 [0,1]이 답인걸 추가했다.
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = -1;
        int[] output= new int[]{5,5};
        boolean istrue = false;
        while (true) {
            i++;
            if(nums.length==2){
                output[0]=0;
                output[1]=1;
                istrue=true;
                break;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target &&i!=j)  {
                    istrue = true;
                    output[0]=j;
                    output[1]=i;
                    break;}

            }
            if (istrue) {
                break;
            }
        }
        return output;
    }
}
```
-----
## 4. 답이 없는것 같아 방식 2로 바꾸엇다
### 1) 배열로 저장하려다가 10^9까지 돌아야해서 시간이 오래걸릴것 같아서 바꿨다
### 2) 책을 보니 map이 있었고 순식간에 다 읽어버려 책을 베끼게 됐다
```java
public class TwoSome1 {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length==2){
            return new int[]{0,1};
        }
        Map<Integer, Integer> map= new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])&& map.get(target-nums[i])!=i){
                return new int []{i,map.get(target-nums[i])};
            }
        }
return null;
    }
}
```
map.containsKey(target-nums[i])이거 안넣었을때 문제가 생긴다.
왜인지 이해가 안갔는데 target-nums[i]가 map에 없을 경우를 고려하지 않았다
그러면 map.get(target-nums[i])!=i만 만족해서 If문이 실행되어 null을 반환하게 되어있다.
그래서 map.containsKey(target-nums[i])를 넣어줘야한다.

-----
### 5. 4번을 다시 짜보았다
한개의 for문으로 만들 수 없을까
생각해보면 [3,2,4,6] 합 10 일때
마지막 요소일때 검사를 진행해도 값이 나오니까 그냥 합쳐도 문제 없다.
```java
public class TwoSome1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map= new HashMap<>();
        if(nums.length==2){
            return new int[]{0,1};
        }

        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])&& map.get(target-nums[i])!=i){
                return new int []{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
return null;
    }
}

```

이것보다 더 빨리 할수있다고..? 괴물들...



