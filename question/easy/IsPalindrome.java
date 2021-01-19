package question.easy;

/**
 * 整数反转
 *
 * @author ZhaoAnkang
 */
public class IsPalindrome {
    public boolean solution(int x) {
        if (x < 0) return false;
        if (x % 10 == 0 && x != 0) return false;
        int y = 0;
        while (x > y) {
            int pop = x % 10;
            x = x / 10;
            y = y * 10 + pop;
        }
        return x == y || x == y / 10;
    }

    public static void main(String[] args){
        System.out.println(new IsPalindrome().solution(1221));
    }
}
