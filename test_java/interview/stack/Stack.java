package stack;

/**
 * Java模拟栈操作
 *
 * @author hupan
 * @date 2018/09/27
 */
class stack {
    /**
     * 定义栈的存储结构，数组后期会进行扩容
     */
    int[] array = new int[20];
    /**
     * 栈中存放数据的个数
     */
    int size = 0;

    /**
     * push()函数用来进行入栈操作 无返回值
     */
    public void push(int num) {
        //判断入栈个数是否超过存储结构的最大值
        if (size >= array.length) {
            //进行数组扩充
            int[] array_new = new int[array.length * 2];
            //array中的数据全部copy到array_mew中
            System.arraycopy(array, 0, array_new, 0, array.length);
            array = array_new;
        } else {
            array[size++] = num;
        }
    }

    /**
     * pop()函数用来进行出栈操作 返回的出栈之前的栈顶元素
     */
    public int pop() {
        //判断出栈是否越界
        try {
            return array[--size];
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }

    public static void main(String[] args) {
        stack st = new stack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        st.push(5);
        System.out.println(st.pop());
    }

}