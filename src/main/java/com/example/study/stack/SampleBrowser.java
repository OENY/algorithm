package com.example.study.stack;

/**
 * 使用前后栈实现浏览器的前进后退
 */
public class SampleBrowser {


    public static void main(String[] args) {
        SampleBrowser browser = new SampleBrowser();
        browser.open("http://www.baidu.com");
        browser.open("http://news.baidu.com/");
        browser.open("http://news.baidu.com/ent");
        browser.goBack();
        browser.goBack();
        browser.goForward();
        browser.open("http://www.qq.com");
        browser.goForward();
        browser.goBack();
        browser.goForward();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.checkCurrentPage();
    }

    /**
     * 当前页
     */
    private String currentPage;
    /**
     * 后退栈
     */
    private LinkedListBasedStack backStack;
    /**
     * 前进栈
     */
    private LinkedListBasedStack forwardStack;

    public SampleBrowser() {
        this.backStack = new LinkedListBasedStack();
        this.forwardStack = new LinkedListBasedStack();
    }


    /**
     * 模拟打开一个网站
     *
     * @param url
     */
    public void open(String url) {
        if (this.currentPage != null) {
            this.backStack.push(this.currentPage);
            // todo:重点注意：打开一个新的网站之后，会清空前进栈
            this.forwardStack.clear();
        }
        showUrl(url, "Open");
    }

    public boolean canGoBack() {
        return this.backStack.size() > 0;
    }

    public boolean canGoForward() {
        return this.forwardStack.size() > 0;
    }

    /**
     * 后退
     *
     * @return
     */
    public String goBack() {
        // 判断能否后退
        if (this.canGoBack()) {
            // 把当前页放入前进栈
            this.forwardStack.push(this.currentPage);

            String backUrl = this.backStack.pop();
            // 更新当前页
            showUrl(backUrl, "Back");
            return backUrl;

        }
        System.out.println("cannot go back,no pages behind.");
        return null;
    }

    /**
     * 前进
     *
     * @return
     */
    public String goForward() {
        // 判断能否前进
        if (this.canGoForward()) {
            // 把当前页放入后退栈
            this.backStack.push(this.currentPage);
            // 更新当前页
            String forwardUrl = this.forwardStack.pop();
            showUrl(forwardUrl, "Forward");
            return forwardUrl;

        }
        System.out.println("cannot go forward,no pages ahead");
        return null;
    }


    public void showUrl(String url, String prefix) {
        this.currentPage = url;
        System.out.println(prefix + " page == " + url);
    }

    public void checkCurrentPage() {
        System.out.println("Current page is:" + this.currentPage);
    }


    /**
     * 基于链表的栈
     */
    public static class LinkedListBasedStack {
        private int size;
        private Node top;


        static Node createNode(String data, Node next) {
            return new Node(data, next);
        }

        public void clear() {
            this.top = null;
            this.size = 0;
        }

        /**
         * 入栈
         *
         * @param data
         */
        public void push(String data) {
            Node node = createNode(data, this.top);
            this.top = node;
            this.size++;
        }

        /**
         * 出栈
         *
         * @return
         */
        public String pop() {
            Node popNode = this.top;
            if (popNode == null) {
                System.out.println("Stack is empty");
                return null;
            }
            this.top = popNode.next;

            if (this.size > 0) {
                this.size--;
            }

            return popNode.data;
        }

        /**
         * 获取栈顶元素
         *
         * @return
         */
        public String getTopData() {
            if (this.top == null) {
                return null;
            }
            return this.top.data;
        }

        public int size() {
            return this.size;
        }


        /**
         * 从栈顶依次打印元素
         */
        public void print() {
            System.out.println("Print stack:");
            Node currentNode = this.top;
            while (currentNode != null) {
                String data = currentNode.getData();
                System.out.println(data + "\t");
                currentNode = currentNode.next;
            }
            System.out.println();
        }


        /**
         * 定义的节点
         */
        public static class Node {
            private String data;
            private Node next;

            public Node(String data) {
                this(data, null);
            }

            public Node(String data, Node next) {
                this.data = data;
                this.next = next;
            }

            public void setData(String data) {
                this.data = data;
            }

            public String getData() {
                return this.data;
            }

            public void setNext(Node next) {
                this.next = next;
            }

            public Node getNext() {
                return this.next;
            }
        }

    }
}
