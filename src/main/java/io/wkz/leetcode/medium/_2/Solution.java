package io.wkz.leetcode.medium._2;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/description/
 * 需要注意的点为两个链表可能不一样长，处理时需要分别判断。
 * 还有就是首节点为无用节点，主要是防止前面多一位0.
 *
 * @author 王可尊
 * @since 1.0
 */
public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		//10进位的余数
		int carry = 0;
		ListNode head = new ListNode(0);
		ListNode curr = head;
		while (l1 != null || l2 != null) {
			int val = carry + (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
			carry = val / 10;
			curr.next = new ListNode(val % 10);
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
			curr = curr.next;
		}
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return head.next;
	}
}
