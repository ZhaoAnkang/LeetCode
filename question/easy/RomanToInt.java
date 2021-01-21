package question.easy;

/**
 * 罗马数字转整数
 *
 * @author ZhaoAnkang
 */
public class RomanToInt {
    public int solution(String s) {
        int result = 0;
        int c1;
        int c2;
        for (int i = 0; i < s.length(); i++) {
            c1 = s.charAt(i);
            switch (c1) {
                case 'I':
                    if (i == s.length() - 1) {
                        result += 1;
                    } else {
                        c2 = s.charAt(i + 1);
                        switch (c2) {
                            case 'V':
                                result += 4;
                                i++;
                                break;
                            case 'X':
                                result += 9;
                                i++;
                                break;
                            default:
                                result += 1;
                        }
                    }
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'X':
                    if (i == s.length() - 1) {
                        result += 10;
                    } else {
                        c2 = s.charAt(i + 1);
                        switch (c2) {
                            case 'L':
                                result += 40;
                                i++;
                                break;
                            case 'C':
                                result += 90;
                                i++;
                                break;
                            default:
                                result += 10;
                        }
                    }
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'C':
                    if (i == s.length() - 1) {
                        result += 100;
                    } else {
                        c2 = s.charAt(i + 1);
                        switch (c2) {
                            case 'D':
                                result += 400;
                                i++;
                                break;
                            case 'M':
                                result += 900;
                                i++;
                                break;
                            default:
                                result += 100;
                        }
                    }
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'M':
                    result += 1000;
            }
        }
        return result;
    }

    /**
     * 题解2
     */
    private int solution1(String s) {
        int sum = 0;
        int preNum = getVal(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getVal(s.charAt(i));
            if (preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private int getVal(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new RomanToInt().solution1("III"));
    }
}
