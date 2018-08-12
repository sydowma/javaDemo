package main.com.mark.design.strategy;
public class MallardDuck extends Duck {
    /**
     * 绿头鸭使用Quack类处理呱呱叫，所以当performQuack被调用时，叫的职责被委托给Quack对象
     * 而我们得到了真正的呱呱叫
     * 
     * 使用FlyWithWings作为其FlyBehavior类型
     */
    public MallardDuck() {
        /**
         * 这里相当于组合了不同的行为，指定类来实现
         */
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}