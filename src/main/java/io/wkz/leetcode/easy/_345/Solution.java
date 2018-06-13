package io.wkz.leetcode.easy._345;

/**
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/description/
 * 本题不难，使用两个指针即可完成。但是需要注意的是，在指针交换后，需要将指针位置修改。不然会造成死循环
 * @author 王可尊
 * @since 1.0
 */
public class Solution {
	public String reverseVowels(String s) {
		if (s == null || s.length() == 1) {
			return s;
		}

		char[] chars = s.toCharArray();
		int length = chars.length;
		int i = 0, j = length - 1;
		while (i < j) {
			while (i < j && !isVowels(chars[i])) {
				i++;
			}
			while (j > i && !isVowels(chars[j])) {
				j--;
			}
			if (i < j) {
				char temp = chars[i];
				chars[i] = chars[j];
				chars[j] = temp;
				//难点在于这里需要将两个指针更新位置，否则将会造成一直验证成功，死循环在此处
				i++;
				j--;
			} else {
				break;
			}
		}

		return String.valueOf(chars);
	}

	private boolean isVowels(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c ==
				'O' || c == 'U';
	}
}
