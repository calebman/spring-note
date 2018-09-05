package com.spring.ioc.shop;

import com.spring.ioc.book.BookInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * @author calebman
 * @date 2018/9/5
 * @description
 */
public class BookShop {
    private List<BookInterface> books;

    public BookShop() {
        books = new ArrayList<BookInterface>();
    }

    // 将书加入售货列表
    public void addBook(BookInterface book) {
        assert (book != null) : "录入图书不能为空";
        books.add(book);
    }

    // 售卖图书
    public Double sellBook(String name) {
        assert (name != null) : "售卖图书的名称不能为空";
        for (BookInterface book : books) {
            if (name.equals(book.getName())) {
                return book.getPrice();
            }
        }
        throw new RuntimeException("书店中未找到此类图书");
    }
}