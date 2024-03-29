package designPatterns;

/**
 * @author: 章鑫
 * @Project_name：IdeaProjects
 * @Name: Decorator
 * @date: 2019-10-09 10:21
 * @Description: 装饰模式
 *
 * 装饰（Decorator）模式的定义：
 *
 * 指在不改变现有对象结构的情况下，动态地给该对象增加一些职责（即增加其额外功能）的模式，
 * 它属于对象结构型模式。
 *
 * 1. 模式的结构
 *
 * 装饰模式主要包含以下角色。
 * 抽象构件（Component）角色：定义一个抽象接口以规范准备接收附加责任的对象。
 * 具体构件（Concrete    Component）角色：实现抽象构件，通过装饰角色为其添加一些职责。
 * 抽象装饰（Decorator）角色：继承抽象构件，并包含具体构件的实例，可以通过其子类扩展具体构件的功能。
 * 具体装饰（ConcreteDecorator）角色：实现抽象装饰的相关方法，并给具体构件对象添加附加的责任。
 *
 **/

public class Decorator {

}
