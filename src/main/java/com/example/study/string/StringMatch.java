package com.example.study.string;


import org.junit.Test;

/**
 * 朴素匹配算法
 */
public class StringMatch {

    @Test
    public void testBF() {
        String mStr = "abcdef";
        String pStr = "bcdef";
        System.out.println(BF(mStr, pStr));
    }


    /**
     * @param mStr 主串
     * @param pStr 模式串
     * @return
     */
    public boolean BF(String mStr, String pStr) {
        int n = mStr.length();
        int m = pStr.length();
        int i = 0;
        int j = 0;
        int k = 0;// 用于记住遍历到主串的哪个子串了

        // 注意这里的循环条件
        while (i < n && j < m && k < n - m + 1) {
            // 检测该子串是否和模式串相等
            if (mStr.charAt(i) == pStr.charAt(j)) {
                i++;
                j++;
            } else {
                // 如果该子串不匹配，则继续比较下个子串
                k++;
                j = 0;
                i = k;
            }
        }
        // 说明存在该子串
        if (j == m) return true;

        // 说明不存在
        return false;
    }
}
