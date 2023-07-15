public class Main {

    public static void main(String[] args) {
//        myArrayListTest();
//        myLinkedListTest();
//        myQueueTest();
//        myStackTest();
        myHashMapTest();


    }
    public static void myArrayListTest(){
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(44);
        list.add(55);
        list.add(46);
        list.add(86);
        list.add(65);
        list.add(6);
        list.add(56);
        list.add(34);
        list.add(54);


        for (int i = 0; i < list.size(); i++){
            System.out.println(list.getValue(i));
        }

        list.remove(3);
        list.remove(6);
        list.remove(4);

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.getValue(i));
        }

        list.clear();

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.getValue(i));
        }
    }
    public static void myLinkedListTest(){
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("fwofn");
        list.add("fgegersd");
        list.add("sfdgen");
        list.add("sdn");
        list.add("fwes");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        list.remove(3);
        list.remove(2);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println(list.size());

        list.clear();

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
    public static void myQueueTest(){
        MyQueue<String> queue = new MyQueue<>();

        queue.add("elvis");
        queue.add("Tom");
        queue.add("Jack");
        queue.add("peter");
        queue.add("MAX");
        queue.add("Dmitro");
        queue.add("dasha");
        queue.add("Sasha");

        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());

        System.out.println(queue.size());

        queue.clear();

        System.out.println(queue.size());
    }
    public static void myStackTest(){
        MyStack<String> stack = new MyStack<>();
        stack.push("fgd");
        stack.push("gsgdffgd");
        stack.push("sgrgfgd");
        stack.push("grsgfgbgdfgd");
        stack.push("gsgrfgd");
        stack.push("gsfsssrsggd");
        stack.push("fgsrgsd");
        stack.push("fgdsgg");
        stack.push("fregwd");

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());

        stack.remove(1);
        stack.remove(4);
        stack.remove(3);

        System.out.println(stack.size());

        stack.clear();

        System.out.println(stack.size());

    }
    public static void myHashMapTest(){
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
        myHashMap.put(1,"dima");
        myHashMap.put(2, "dasha");
        myHashMap.put(3,"sasha");
        myHashMap.put(5,"denisfds");
        myHashMap.put(6,"denisdfs");
        myHashMap.put(7,"denisdfsfrs");
        myHashMap.put(8,"deniefsss");
        myHashMap.put(9,"denisdfes");
        myHashMap.put(10,"denisefseffbd");
        myHashMap.put(11,"denisfefwsad");
        myHashMap.put(12,"denisefthrt");

        myHashMap.remove(4);

        for (int i = 1; i < myHashMap.size() + 1; i++) {
            System.out.println(myHashMap.get(i));
        }

        myHashMap.clear();

        for (int i = 1; i < myHashMap.size() + 1; i++) {
            System.out.println(myHashMap.get(i));
        }

    }
}
