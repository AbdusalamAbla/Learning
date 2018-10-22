package Data_Structure;


/**
 * Created by Abdusalam on 17/10/26.
 */
public class LList<T> implements ListInterface<T> {

    private Node firstNode;  //头结点
    private int length;      //线性表中的元素数目

    LList() {
        Clear();
    }

    /**
     * 清除方法，置firstnode为空
     */
    @Override
    public boolean add(T newEntry) {      //新元素
        Node newNode = new Node(newEntry);
        if (isEmpty()) {
            firstNode = newNode;
        } else {
            Node lastNode = getNodeAt(length);
            lastNode.next = newNode;
        }
        length++;
        return true;
    }

    @Override
    public boolean add(int newPosition, T newEntry) {  //输入位置和新元素
        boolean isSuccessful = true;
        if ((newPosition >= 1) && newPosition <= length + 1) {
            Node newNode = new Node(newEntry);
            if (isEmpty() || (newPosition == 1)) {//若表空或新位置为头结点，设置到头结点
                newNode.next = firstNode;
                firstNode = newNode;
            } else {
                Node nodeBefore = getNodeAt(newPosition - 1);  //将原该位置的元素定为新元素的下一位，将新元素定为上一个元素的下一位
                newNode.next = nodeBefore.next;
                nodeBefore.next = newNode;
            }
            length++;
        } else {
            isSuccessful = false;
        }
        return isSuccessful;
    }

    /**
     *
     * @param givenPosition   给定地址
     * @return
     */
    @Override
    public boolean remove(int givenPosition) {
        boolean isSuccessful = true;
        if (givenPosition == 1 && length > 1) {
            firstNode = firstNode.next;
            length--;
        } else if (givenPosition < length) {
            Node nodeBefore = getNodeAt(givenPosition - 1);
            Node nodeAfter = getNodeAt(givenPosition + 1);
            nodeBefore.next = nodeAfter;
            length--;
        } else if (givenPosition == length) {
            Node lastNodeBefore = getNodeAt(givenPosition - 1);
            lastNodeBefore.next = null;
            length--;
        } else {
            System.out.println("超出了长度");
            isSuccessful = false;
        }
        return isSuccessful;
    }

    @Override
    public void Clear() {
        firstNode = null;
        length = 0;
    }

    /**
     *
     * @param givenPosition  地址
     * @param newEntry      新元素
     * @return     成功返回true，失败返回false
     */
    @Override
    public boolean replace(int givenPosition, T newEntry) {
        boolean isSuccessful = true;
        if (!isEmpty() && (givenPosition >= 1) && (givenPosition <= length)) {
            Node theNode = getNodeAt(givenPosition);
            theNode.data = newEntry;
        } else {
            isSuccessful = false;
        }
        return isSuccessful;
    }

    @Override
    public T getEntry(int givenPosition) {
        T result = null;
        if (!isEmpty() && (givenPosition >= 1) && (givenPosition <= length)) {
            result = getNodeAt(givenPosition).data;
        }
        return result;
    }

    /**
     *
     * @param anEntry  查询该元素是否被包含
     * @return
     */
    @Override
    public boolean contains(T anEntry) {
        boolean isItContains = false;
        Node currentNode = firstNode;
        while (!isItContains && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                isItContains = true;
            } else {
                currentNode = currentNode.next;
            }
        }
        return isItContains;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        boolean result;
        if (length == 0) {
            assert firstNode == null;
            result = true;
        } else {
            assert firstNode != null;
            result = false;
        }

        return result;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override

    public void display() {

        Node currentNode = firstNode;
        for (int i = 0; i < length; i++) {
            System.out.println("这是第" + (i + 1) + "个 " + currentNode.data);
            currentNode = currentNode.next;
        }

    }

    /**
     * 以下为私有方法
     * task:返回指向给定位置上的节点的引用
     * 条件:线性表不空，且1<=givenPosition<=length
     */
    private Node getNodeAt(int givenPosition) {
        assert !isEmpty() && (1 <= givenPosition) && (givenPosition <= length);
        Node currentNode = firstNode;
        for (int counter = 1; counter < givenPosition; counter++) {
            currentNode = currentNode.next;
        }
        assert currentNode != null;
        return currentNode;
    }

    private class Node {
        /**
         * 私有类Node（结点），内部类Node的数值域无需访问和修改方法。
         */
        private T data;
        private Node next;

        private Node(T dataPortion) {
            data = dataPortion;
            next = null;
        }

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }

        private T getData() {
            return data;
        }

        private void setData(T newData) {
            data = newData;
        }

        private Node getNextNode() {
            return next;
        }

        private void setNextNode(Node nextNode) {
            next = nextNode;
        }
    }

}
