public class Numberof1bits191 {
    public static int hammingWeight(int n) {
        int count=0;
        while (n!=0){
            System.out.println(Integer.toBinaryString(n));
            n&= n -1;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(0b1000011));
    }
}
