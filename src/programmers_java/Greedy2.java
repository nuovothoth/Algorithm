package programmers_java;

public class Greedy2 {
    public String solution(String number, int k) {
        char[] numberChArr = number.toCharArray();
        String filledStr = "";
        return getfilledNum(numberChArr, 0, filledStr, 0, number.length()-k)+"";
    }

    private int getfilledNum(char[] numberChArr, int nIdx, String filledStr, int fIdx, int length){
        if(fIdx > length-1) return Integer.parseInt(filledStr);
        if(nIdx > numberChArr.length-1) return 0;

        return Math.max(getfilledNum(numberChArr, nIdx+1, filledStr, fIdx, length), getfilledNum(numberChArr, nIdx + 1, filledStr+numberChArr[nIdx], fIdx + 1, length));
    }
}
