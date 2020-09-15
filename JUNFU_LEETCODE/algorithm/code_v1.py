
# Definition for singly-linked list.


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode):
        # 简单实现  #21. 合并两个有序链表
        if l1 is None:
            return l2
        elif l2 is None:
            return l1
        else:
            if l1.val <= l2.val:
                ans = ListNode(l1.val)
                l1 = l1.next
            else:
                ans = ListNode(l2.val)
                l2 = l2.next
            tem = ans
            while l1 is not None:
                if l2 is not None:
                    if l1.val <= l2.val:
                        tem.next = ListNode(l1.val)
                        tem = tem.next
                        l1 = l1.next
                    else:
                        tem.next = ListNode(l2.val)
                        tem = tem.next
                        l2 = l2.next
                else:
                    tem.next = l1
                    break
            if l2 is not None:
                tem.next = l2
            return ans

    def mergeTwoLists_digui(self, l1: ListNode, l2: ListNode):
        # 递归
        if l1 is None:
            return l2
        elif l2 is None:
            return l1
        else:
            if l1.val <= l2.val:
                l1.next = mergeTwoLists(l1.next, l2)
                return l1
            else:
                l2.next = mergeTwoLists(l1, l2.next)
                return l2


class Alg_168:
    def convertToTitle(n):
        print(n)


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def sortedArrayToBST(self, nums):
        pass


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode):
        if l1 is None:
            return l2
        elif l2 is None:
            return l1
        else:










            
