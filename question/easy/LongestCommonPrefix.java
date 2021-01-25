package question.easy;

/**
 * 最长公共前缀
 *
 * @author ZhaoAnkang
 */
public class LongestCommonPrefix {
    public String solution(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        // 找出长度最短的字符串
        int minLength = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (minLength > strs[i].length()) {
                minLength = strs[i].length();
            }
        }
        char[] result = new char[minLength];
        tag:
        for (int i = 0; i < minLength; i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != ch) {
                    break tag;
                }
                if (j == strs.length - 1 && strs[j].charAt(i) == ch) {
                    result[i] = ch;
                }
            }
        }
        return new String(result).trim();
    }

    /**
     * 横向扫描
     */
    public String solution1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++) {
            pre = longestPrefix(pre, strs[i]);
            if (pre.length() == 0) {
                break;
            }
        }
        return pre;
    }

    public String longestPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    /**
     * 分治法
     */
    public String solution2(String[] strs){
        if(strs == null || strs.length == 0){
            return "";
        }else{
            return longestCommonPrefix(strs,0,strs.length - 1);
        }
    }

    public String longestCommonPrefix(String[] strs, int start, int end){
        if(start == end){
            return strs[start];
        }else{
            int mid = (end - start) / 2 + start;
            String lcpLeft = longestCommonPrefix(strs,start,mid);
            String lcpRight = longestCommonPrefix(strs,mid + 1,end);
            return commonPrefix(lcpLeft,lcpRight);
        }
    }

    public String commonPrefix(String lcpLeft, String lcpRight){
        int minLength = Math.min(lcpLeft.length(), lcpRight.length());
        for (int i = 0; i < minLength; i ++){
            if(lcpLeft.charAt(i) != lcpRight.charAt(i)){
                return lcpLeft.substring(0,i);
            }
        }
        return lcpLeft.substring(0,minLength);
    }

    /**
     * 二分查找法
     */
    public String solution3(String[] strs){
        if(strs == null || strs.length == 0){
            return "";
        }
        int minLength = Integer.MAX_VALUE;
        for(String str : strs){
            minLength = Math.min(minLength, str.length());
        }
        int low = 0, high = minLength;
        while(low < high){
            int mid = (high - low + 1) / 2 + low;
            if (isCommonPrefix(strs,mid)){
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, low);
    }

    public boolean isCommonPrefix(String[] strs, int length){
        String str0 = strs[0].substring(0,length);
        int count = strs.length;
        for (int i = 1; i < count; i ++){
            String str = strs[i];
            for(int j = 0; j < length; j ++){
                if(str0.charAt(j) != str.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strs = {"dog", "racecar", "car"};
        System.out.println(new LongestCommonPrefix().solution(strs));
    }
}
