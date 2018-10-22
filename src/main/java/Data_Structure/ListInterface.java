package Data_Structure;

/**
 * Created by Abdusalam on 17/10/26.
 */
public interface ListInterface<T> {
    boolean add(T newEntry);/*在表尾填入新元素，成功返回true*/
    boolean add(int newposition, T newEntry);/*在目标位置插入新元素，插入成功返回true，后面的元素位置+1*/
    boolean remove(int givenPosition);/*删除指定位置的元素*/
    void Clear();/*表清空*/
    boolean replace(int givenPosition, T newEntry);/*置换指定未指定的元素*/
    T getEntry(int givenPosition);/*检索线性表指定位置的元素*/
    boolean contains(T anEntry);/*查看是否有该元素，有的话返回true*/
    int getLength();/*取得线性表长度*/
    boolean isEmpty();/*检查表是否为空，是的话返回true*/
    boolean isFull();/*检查线性表是否满，是的话返回true*/
    void display();/*按照在线性表的顺序显示元素*/
}
