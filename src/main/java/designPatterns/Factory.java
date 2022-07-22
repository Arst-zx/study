package designPatterns;

/**
 * @author: 章鑫
 * @Project_name：study
 * @Name: Factory
 * @date: 2019-09-25 11:19
 * @Description: 工厂方法模式
 **/
public class Factory {

    /**
     * 1. 模式的结构
     *
     * 工厂方法模式的主要角色如下。
     * 抽象工厂（Abstract Factory）：提供了创建产品的接口，调用者通过它访问具体工厂的工厂方法 newProduct() 来创建产品。
     * 具体工厂（ConcreteFactory）：主要是实现抽象工厂中的抽象方法，完成具体产品的创建。
     * 抽象产品（Product）：定义了产品的规范，描述了产品的主要特性和功能。
     * 具体产品（ConcreteProduct）：实现了抽象产品角色所定义的接口，由具体工厂来创建，它同具体工厂之间一一对应。
     */
    public static void main(String[] args) {

        ConcreteFactory concreteFactory = new ConcreteFactory();
        concreteFactory.newAnimal().show();
        concreteFactory.newProduct().show();
    }

}

/**
 * 抽象产品
 */

interface Product {
    public void show();
}

interface Animal {
    public void show();
}

/**
 * 具体产品
 */

class ConcreteProduct implements Product {

    @Override
    public void show() {

        System.out.println("这是一个具体产品！");
    }
}

class ConcreteAnimal implements Animal {

    @Override
    public void show() {
        System.out.println("这是一个具体产品，动物！");
    }
}

/**
 * 抽象工厂
 */

interface AbstractFactory {

    /**
     * 生成产品的方法
     * @return
     */
    public Product newProduct();

    public Animal newAnimal();
}

/**
 * 具体工厂
 */

class ConcreteFactory implements AbstractFactory {

    @Override
    public Product newProduct() {

        return new ConcreteProduct();
    }

    @Override
    public Animal newAnimal() {
        return new ConcreteAnimal();
    }
}

/**
 * 抽象工厂（AbstractFactory）模式的定义：是一种为访问类提供一个创建一组相关或相互依赖对象的接口，
 *
 * 且访问类无须指定所要产品的具体类就能得到同族的不同等级的产品的模式结构。
 *
 * 抽象工厂模式是工厂方法模式的升级版本，工厂方法模式只生产一个等级的产品，而抽象工厂模式可生产多个等级的产品。
 *
 * 使用抽象工厂模式一般要满足以下条件。
 * 系统中有多个产品族，每个具体工厂创建同一族但属于不同等级结构的产品。
 * 系统一次只可能消费其中某一族产品，即同族的产品一起使用。
 *
 * 抽象工厂模式除了具有工厂方法模式的优点外，其他主要优点如下。
 * 可以在类的内部对产品族中相关联的多等级产品共同管理，而不必专门引入多个新的类来进行管理。
 * 当增加一个新的产品族时不需要修改原代码，满足开闭原则。
 *
 * 其缺点是：当产品族中需要增加一个新的产品时，所有的工厂类都需要进行修改。
 */
