package com.spring.ioc;

import com.spring.ioc.book.Book;
import com.spring.ioc.book.BookInterface;
import com.spring.ioc.shop.BookShop;

/**
 * @author calebman
 * @date 2018/9/5
 * @description
 */
public class Main {
    public static void main(String[] args) {
        BookShop shop = new BookShop();
        BookInterface book = new Book();// 右边new的是BookA，这表示BookA是硬编码
        book.setName("读者");
        book.setPrice(9.5);
        shop.addBook(book);
        // 售卖图书价格
        System.out.println(shop.sellBook("读者"));
    }
}