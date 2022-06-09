package com.example.study.linkedList;

/**
 * @Author: yuanchenglong
 * @Description: 单向链表
 * @Date: 2022/6/9 11:21
 */
public class OneWayLinkedList implements LinkedList {
    /**
     * 头指针
     */
    Node head;
    /**
     * 节点个数
     */
    Integer size;
    /**
     * 当前节点
     */
    Node current;

    /**
     * 初始化数据
     */
    public OneWayLinkedList(){
        this.head = null;
        this.size = 0;
    }


    @Override
    public void addToHead(Integer element) {
        if(head == null){
            this.head = new Node(element,null);
        }
        Node tmpNode = head.next;
        head.next = new Node(element,tmpNode);
        size++;
    }

    @Override
    public void addToTail(Integer element) {
        if(head == null){
            this.head = new Node(element,null);
        }
        Node tailNode = getTailNode();
        tailNode.next = new Node(element,null);
        size++;
    }

    @Override
    public void addByIndex(int index) {

    }

    @Override
    public Node get(int index) {

        if(index<1){
            throw new RuntimeException("索引应该大于等于1");
        }

        if(index > size){
            throw new RuntimeException("索引超出链表长度");
        }

        int count = 0;
        Node cur = null;
        while (count <= index){

            if(count == 0){
                cur = this.head;
            }else {
                cur = cur.next;
            }
            count++;

        }
        return cur;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Node remove(int index) {


        size--;
        return null;
    }


    /**
     * 获取尾部节点
     * @return
     */
    private Node getTailNode(){
        if(head == null){
            return null;
        }

        Node curNode = this.head;
        while (curNode.next != null){
            curNode = current.next;
        }
        return curNode;
    }
}
