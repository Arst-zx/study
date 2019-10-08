package designPatterns;

/**
 * @author: 章鑫
 * @Email: zhangx511@chinaunicom.cn
 * @Project_name：study
 * @Name: Singleton
 * @date: 2019-09-25 10:27
 * @Description: 单例模式
 *
 **/

public class Singleton {

    /**
     * 1.懒汉模式
     *
     * 该模式的特点是类加载时没有生成单例，只有当第一次调用 getlnstance 方法时才去创建这个单例。
     *
     * 注意：如果编写的是多线程程序，则不要删除上例代码中的关键字 volatile 和 synchronized，
     * 否则将存在线程非安全的问题。如果不删除这两个关键字就能保证线程安全，但是每次访问时都要同步，
     * 会影响性能，且消耗更多的资源，这是懒汉式单例的缺点。
     */
    private static volatile Singleton singleton = null;

    /**
     * 构造方法私有化
     */
    private Singleton(){}

    public static synchronized Singleton getInstance(){

        if (singleton == null) {
            singleton = new Singleton();
        }

        return singleton;
    }
}

class Hungrysingleton {

    /**
     * 2.饿汉模式
     *
     * 该模式的特点是类一旦加载就创建一个单例，保证在调用 getInstance 方法之前单例已经存在了。
     *
     * 饿汉式单例在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变，
     * 所以是线程安全的，可以直接用于多线程而不会出现问题。
     */
    private static final Hungrysingleton HUNGRYSINGLETON = new Hungrysingleton();

    /**
     * 构造方法私有化
     */
    private Hungrysingleton(){}

    public static Hungrysingleton getInstance() {

        return HUNGRYSINGLETON;
    }

}

