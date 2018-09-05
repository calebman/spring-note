package com.spring.ioc;

import com.spring.ioc.book.BookInterface;
import com.spring.ioc.shop.BookShop;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author calebman
 * @date 2018/9/5
 * @description
 */
public class WithSpringMain {
    public static void main(String[] args) {
        // 启动spring容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:bookshop.xml");
        context.start();

        BookShop shop = new BookShop();
        // 从容器中获取所有的书籍
        Map<String, BookInterface> bookInterfaceMap = context.getBeansOfType(BookInterface.class);
        for (Map.Entry<String, BookInterface> entry : bookInterfaceMap.entrySet()) {
            // 将容器中的书本对象录入商店
            shop.addBook(entry.getValue());
        }
        // 售卖图书价格
        System.out.println(shop.sellBook("读者"));

        // 销毁spring容器
        context.destroy();
    }
}
