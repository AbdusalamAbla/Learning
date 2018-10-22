package Data_Structure;


import java.util.Random;

/**
 * Created by Abdusalam on 17/10/26.
 */
public class LListTest {
    public static void main(String[] args) {
//        ArrayList names = new ArrayList();
//        names.add("Chaitanya");
//        names.add("Steve");
//        names.add("Jack");
//
//        Iterator it = names.iterator();
//
//        while (it.hasNext()) {
//            String obj = (String) it.next();
//            System.out.println(obj);



        LList<Integer> list=new LList<>();
        System.out.println(list.isEmpty());
        Random rand=new Random(47);
        for (int i = 0; i <10 ; i++) {
            list.add(rand.nextInt(10));
        }
        list.display();
//        Iterator<Integer>it=new list.SeparateIterator();
//        list.remove(2);
//        System.out.println(list.isEmpty());
//        list.display();
//        System.out.println(list.contains(13));list.add(14);
//        System.out.println("new");
//        list.display();
//        list.remove(3);
//        list.remove(5);
//        list.display();
        }
    }
