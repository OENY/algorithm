package com.example.study.linkedList;

/**
 * 单链表
 */
public class SinglyLinkedList {

    private Node head = null;

    public Node findByValue(int value) {
        Node p = head;

        // 一举多得
        while (p != null && p.data != value) {
            p = p.next;
        }

        return p;
    }

    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0;
        while (p != null & pos != index) {
            p = p.next;
            ++pos;
        }
        return p;
    }


    /**
     * 无头结点
     * 表头插入
     * 这种操作将于输入的顺序想法，逆序
     *
     * @param value
     */
    public void insertToHead(int value) {
        Node node = new Node(value, null);

        insertToHead(node);
    }

    public void insertToHead(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            // 将头指针移动到头部
            head = newNode;
        }
    }

    /**
     * 顺序插入
     * 链表尾部插入
     *
     * @param value
     */
    public void insertTail(int value) {
        Node newNode = new Node(value, null);
        if (head == null) {
            head = newNode;
        } else {
            Node q = head;
            while (q.next != null) {
                q = q.next;
            }

            newNode.next = q.next;
            q.next = newNode;
        }
    }


    public void insertAfter(Node p, int value) {
        Node newNode = new Node(value, null);
        insertAfter(p, newNode);
    }

    public void insertAfter(Node p, Node newNode) {
        if (p == null) return;
        newNode.next = p.next;
        p.next = newNode;
    }

    public void insertBefore(Node p, int value) {
        Node newNode = new Node(value, null);
        insertBefore(p, newNode);
    }


    public void insertBefore(Node p, Node newNode) {
        if (p == null) return;
        if (head == p) {
            insertToHead(newNode);
            return;
        }

        // 通过位置定位p
        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }
        if (q == null) {
            return;
        }

        newNode.next = p;
        q.next = newNode;
    }

    public void deleteByNode(Node p) {

        if (p == null || head == null) return;

        if (p == head) {
            head = head.next;
            return;
        }

        Node q = head;
        // 注意这里的q.next != p ，循环截止时，q 相当于 p的前驱节点
        while (q != null && q.next != p) {
            q = q.next;
        }
        if (q == null) return;

        q.next = q.next.next;
    }

    /**
     * 注意  需要记录器前驱指针
     *
     * @param value
     */
    public void deleteByValue(int value) {
        if (head == null) return;
        Node p = head;
        Node q = null;

        while (p != null && p.data != value) {
            // 记录前驱节点
            q = p;
            p = p.next;
        }

        if (p == null) return;


        if (q == null) {
            head = head.next; // 删除的是头结点
        } else {
            q.next = q.next.next;
        }

    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    /**
     * 判断两个链表的值是否一致
     *
     * @param left
     * @param right
     * @return
     */
    public boolean TFResult(Node left, Node right) {
        Node l = left;
        Node r = right;

        boolean flag = true;
        System.out.println("left_:" + l.data);
        System.out.println("right_:" + r.data);

        while (l != null && r != null) {
            if (l.data == r.data) {
                l = l.next;
                r = r.next;
                continue;
            } else {
                flag = false;
                break;
            }
        }

        System.out.println("什么结果");
        return flag;
    }


    /**
     * 判断是否是回文
     *
     * @return
     */
    public boolean palindrome() {
        if (head == null) {
            return false;
        } else {
            System.out.println("开始执行找到中间节点");
            Node p = head;
            Node q = head;
            if (p.next == null) {
                System.out.println("只有一个元素");
                return true;
            }

            // 快慢指针,定位中间节点 p
            while (q.next != null && q.next.next != null) {
                p = p.next;
                q = q.next.next;
            }

            System.out.println("中间节点" + p.data);
            System.out.println("开始执行奇数节点的回文判断");

            Node leftLink = null;
            Node rightLink = null;

            if (q.next == null) {
                // p 一定为整个链表的中点，且节点数为奇数
                rightLink = p.next;
                leftLink = inverseLinkList(p).next;
                System.out.println("左边第一个节点" + leftLink.data);
                System.out.println("右边第一个节点" + rightLink.data);
            } else {
                rightLink = p.next;
                leftLink = inverseLinkList(p);
            }

            return TFResult(leftLink, rightLink);


        }
    }


    /**
     * 带头链表的翻转
     *
     * @param p
     * @return
     */
    public Node inverseLinkList_head(Node p) {
        Node Head = new Node(9999, null);
        Head.next = p;

        // 带头节点的链表翻转等价于 从第二个元素开始重新头插法建立链表
        Node Cur = p.next;
        p.next = null;
        Node next = null;

        while (Cur != null) {
            next = Cur.next;
            Cur.next = Head.next;
            Head.next = Cur;
            System.out.println("first" + Head.data);

            Cur = next;
        }

        return Head;


    }

    /**
     * 无头节点的链表翻转
     *
     * @param p
     * @return
     */
    public Node inverseLinkList(Node p) {
        Node pre = null;
        Node r = head;

        System.out.println("z-----" + r.data);

        Node next = null;

        while (r != p) {
            next = r.next;

            r.next = pre;
            pre = r;
            r = next;
        }

        r.next = pre;

        return r;
    }


    /**
     * 创建一个节点
     *
     * @param value
     * @return
     */
    public static Node createNode(int value) {
        return new Node(value, null);
    }


    /**
     * 定义一个节点
     */
    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }
}
