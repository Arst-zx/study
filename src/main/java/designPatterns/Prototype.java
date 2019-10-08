package designPatterns;

/**
 * @author: 章鑫
 * @Email: zhangx511@chinaunicom.cn
 * @Project_name：study
 * @Name: Prototype
 * @date: 2019-09-25 10:59
 * @Description: 原型模式
 **/

public class Prototype implements Cloneable {

    /**
     * 原型类具体实现
     */
    public Prototype() {

        System.out.println("创建原型类成功！");
    }

    /**
     * 克隆原型类，重写clone()
     *
     * 1. 模式的结构
     *
     * 原型模式包含以下主要角色。
     * 抽象原型类：规定了具体原型对象必须实现的接口。
     * 具体原型类：实现抽象原型类的 clone() 方法，它是可被复制的对象。
     * 访问类：使用具体原型类中的 clone() 方法来复制新的对象。
     *
     * 2.模式实现
     *
     * 原型模式的克隆分为浅克隆和深克隆，Java 中的 Object 类提供了浅克隆的 clone() 方法，
     * 具体原型类只要实现 Cloneable 接口就可实现对象的浅克隆，这里的 Cloneable 接口就是抽象原型类。
     *
     * @return Prototype
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {

        System.out.println("原型类复制成功！");
        return (Prototype) super.clone();
    }
}
