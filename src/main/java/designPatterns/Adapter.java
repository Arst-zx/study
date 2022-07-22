package designPatterns;

/**
 * @author: 章鑫
 * @Project_name：study
 * @Name: Adapter
 * @date: 2019-09-26 16:38
 * @Description: 适配器模式
 *
 *      适配器模式（Adapter）的定义如下：
 *  *
 *  * 将一个类的接口转换成客户希望的另外一个接口，使得原本由于接口不兼容
 *  * 而不能一起工作的那些类能一起工作。适配器模式分为类结构型模式和对象结构型模式两种，
 *  * 前者类之间的耦合度比后者高，且要求程序员了解现有组件库中的相关组件的内部结构，
 *  * 所以应用相对较少些。
 *  *
 *  * 适配器模式（Adapter）包含以下主要角色:
 *  *
 *  * 目标（Target）接口：当前系统业务所期待的接口，它可以是抽象类或接口。
 *  * 适配者（Adaptee）类：它是被访问和适配的现存组件库中的组件接口。
 *  * 适配器（Adapter）类：它是一个转换器，通过继承或引用适配者的对象，把适配者接口转换成目标接口，让客户按目标接口的格式访问适配者。
 *  *
 **/

/**
 * 目标接口：
 *
 * 当前系统业务所期待的接口，它可以是抽象类或接口。
 */
interface Target {

    /**
     * 目标方法
     */
    public void show();
}

/**
 * 适配者类：
 *
 * 它是被访问和适配的现存组件库中的组件接口。
 */
class Adaptee {

    /**
     * 现有的方法
     */
    public void speShow() {

        System.out.println("适配者类！");
    }
}

/**
 * 适配器类：
 *
 * 它是一个转换器，通过继承或引用适配者的对象，把适配者接口转换成目标接口，让客户按目标接口的格式访问适配者。
 */
class Adapter extends Adaptee implements Target {

    @Override
    public void show() {

        speShow();
    }

    public static void main(String[] args) {

        Target target = new Adapter();
        target.show();
    }
}

/**
 * 对象适配器类：
 */
class ObjectAdapter implements Target {

    private Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee) {

        this.adaptee = adaptee;
    }

    @Override
    public void show() {

        adaptee.speShow();
    }

    public static void main(String[] args) {

        Adaptee adaptee = new Adaptee();
        Target target = new ObjectAdapter(adaptee);
        target.show();
    }
}