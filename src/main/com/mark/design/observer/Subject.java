package main.com.mark.design.observer;

public interface Subject {
    // 注册和删除，需要传入一个观察者变量
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    // 当主题改变时，这个方法会被调用，以通知所有的观察者
    public void notifyObservers();
}