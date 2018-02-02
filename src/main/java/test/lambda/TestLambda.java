package test.lambda;

import scala.UserScala;
import yechao.model.User;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestLambda {

    public static void main(String[] args) {
        //使用lambda表达式对列表进行迭代
        System.out.println("例子1：使用lambda表达式对列表进行迭代");
        List list = Arrays.asList("demo", "test", "depth");
        System.out.println("---1---");
        list.forEach(x -> System.out.println(x));
        System.out.println("---2---");
        list.forEach(System.out::println);
        //使用Java 8 lambda表达式进行事件处理
        System.out.println("例子2：用Java 8 lambda表达式进行事件处理");
        JButton userScala = new JButton("userscala");
        userScala.addActionListener((e) -> {
            System.out.println("lambda表达式增加事件监听器");
        });
        //用lambda表达式实现Runnable
        System.out.println("例子3：用lambda表达式实现Runnable");
        System.out.println(Thread.currentThread().getName());
        new Thread(() -> {
            System.out.println("Runnable的实现");
            System.out.println(Thread.currentThread().getName());
        }).start();


    }
}
