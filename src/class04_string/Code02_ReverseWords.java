package class04_string;

public class Code02_ReverseWords {
    //给你一个字符串 s ，请你反转字符串中 单词 的顺序。
    //单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
    //返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
    //注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格
    public static String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        // 去除开头空格
        while (left <= right && arr[left] == ' ') {
            left++;
        }
        // 去除尾巴的空格
        while (left <= right && arr[right] == ' ') {
            right--;
        }
        //全是空格
        if (left > right) {
            return "";
        }
        // left和right为去除之后的头和尾

        // 有单词 结果最长这么多元素
        char[] res = new char[right - left + 1];
        int index = 0;


        int wordEnd = right;// 单词结尾
        // 去除中间节点的空格
        while (left < right) {
            //开头
            if (arr[right] != ' ' && arr[right - 1] == ' ') {
                //反转
                int tmp = right;
                while (tmp <= wordEnd) {
                    res[index++] = arr[tmp++];
                }
                res[index++] = ' ';
            }
            //结尾
            if (arr[right] == ' ' && arr[right - 1] != ' ') {
                wordEnd = right - 1;
            }
            right--;
        }
        while (left <= wordEnd) {
            res[index++] = arr[left++];
        }
        return String.valueOf(res, 0, index);

    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        String res = reverseWords(s);
        System.out.println(res);

    }
}
