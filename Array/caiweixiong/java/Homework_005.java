public class Homework_005 {

    // 相交链表，LeetCode第160题
    public void homework_005_160() {
        ListNode list1, list2, temp, node;
        list1 = new ListNode(0);
        list1.listInsert(list1, 9);
        list1.listInsert(list1, 1);
        list1.listInsert(list1, 2);
        list1.listInsert(list1, 4);
        list2 = new ListNode(3);
        temp = list1;
        while (temp != null && temp.val != 2) {
            temp = temp.next;
        }
        if (temp != null)
            list2.next = temp;
        // 获取相交节点
        node = getIntersectionNode(list1, list2);
        if (node == null)
            System.out.println("链表 list1 与 list2 无相交点");
        else
            System.out.println(String.format("相交节点的值域为：%d", node.val));
    }

    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode listA = headA, listB = headB, lastNode = null;
        if (headA == null || headB == null)
            return null;
        if (listA == listB)
            return listA;
        while (listA != listB) {
            // 过滤链表A
            if (listA.next != null)
                listA = listA.next;
            else {
                if (lastNode != null) {
                    // 链表A到达链尾了，而且链尾不空，也就是链表B比较短，先到达了链表尾，并将链尾存了起来，如果它们地址值不一样，则肯定不相交
                    if (lastNode != listA)
                        return null;
                    else
                        // 证明有相交节点，将listA指向链表B
                        listA = headB;
                } else {
                    // 链表A已经到达链尾，将链尾节点存起来
                    lastNode = listA;
                    // 将listA指向链表B
                    listA = headB;
                }
            }
            // 过滤链表B
            if (listB.next != null)
                listB = listB.next;
            else {
                if (lastNode != null) {
                    // 链表B到达链尾了，而且链尾不空，也就是链表A比较短，先到达了链表尾，并将链尾存了起来，如果它们地址值不一样，则肯定不相交
                    if (lastNode != listB)
                        return null;
                    else
                        // 证明有相交节点，将listB指向链表A
                        listB = headA;
                } else {
                    // 链表B已经到达链尾，将链尾节点存起来
                    lastNode = listB;
                    // 将listB指向链表A
                    listB = headA;
                }
            }
            // 经过了上面的过滤，指向最后判断它们的地址值一样，返回它们的其中一个即可
            if (listA == listB)
                return listA;
        }
        return null;
    }
}
