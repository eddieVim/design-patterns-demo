package pers.eddievim;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eddie
 * @create 2021/4/1 16:27
 */
public class Solution {

    public static void main(String[] args) {
        List<String> fun = fun(1, 1);

        for (String string : fun) {
            System.out.println(string);
        }
    }

    private static List<String> ans;

    public static List<String> fun(int n, int m) {
        ans = new ArrayList<>();
        dfs(n, m, 0, 0, 0, 0, new StringBuilder());
        return ans;
    }

    private static void dfs(int n, int m, int nl, int nr, int ml, int mr, StringBuilder currStr) {
        // 左括号过多 or 左括号数量少于右括号
        int gapN = nl - nr;
        int gapM = ml - mr;
        if (nl > n || ml > m || nl < nr || ml < mr) {
            return;
        }

        // 当前字符串是一种情况
        if (nl == n && nr == n && ml == m && mr == m) {
            StringBuilder stringBuilder = new StringBuilder(currStr);
            ans.add(stringBuilder.toString());
            return;
        }

        currStr.append("(");
        dfs(n, m, nl + 1, nr, ml, mr, currStr);
        currStr.deleteCharAt(currStr.length() - 1);

        if (currStr.length() > 0 && currStr.charAt(currStr.length() - 1) != '{') {
            currStr.append(")");
            dfs(n, m, nl, nr + 1, ml, mr, currStr);
            currStr.deleteCharAt(currStr.length() - 1);
        }


        currStr.append("{");
        dfs(n, m, nl, nr, ml + 1, mr, currStr);
        currStr.deleteCharAt(currStr.length() - 1);

        if (currStr.length() > 0 && currStr.charAt(currStr.length() - 1) != '(') {
            currStr.append("}");
            dfs(n, m, nl, nr, ml, mr + 1, currStr);
            currStr.deleteCharAt(currStr.length() - 1);
        }
    }
}
