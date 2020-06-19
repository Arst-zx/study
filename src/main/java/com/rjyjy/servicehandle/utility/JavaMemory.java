package com.rjyjy.servicehandle.utility;

/**
 * @author: 章鑫
 * @Email: zhangx511@chinaunicom.cn
 * @Project_name：Study
 * @Name: JavaMemory
 * @date: 2020-06-18 15:36
 * @Description:
 **/

public class JavaMemory {

    /**
     * 虚拟机方法栈溢出：-Xss160k
     */
    private int stackLength = 1;

    public void stackLeak () {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {

        JavaMemory javaMemory = new JavaMemory();
        try {
            javaMemory.stackLeak();
        } catch (Throwable throwable) {
            System.out.println(javaMemory.stackLength);
            throw throwable;
        }
    }

//    /**
//     * java堆内存溢出：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
//     */
//    static class OomObject {}
//
//    public static void main(String[] args) {
//
//        List<OomObject> list = new ArrayList<OomObject>();
//
//        while (true) {
//            list.add(new OomObject());
//        }
//    }
}

