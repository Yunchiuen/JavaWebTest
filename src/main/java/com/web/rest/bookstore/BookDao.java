package com.web.rest.bookstore;

import java.util.LinkedHashSet;
import java.util.Set;

public class BookDao {

    public static Set<Book> books = new LinkedHashSet<>();

    //多筆查詢
    public static Set<Book> getBooks() {
        return books;
    }

    //單筆查詢
    public static Book getBook(Integer id) {
        //是否存在這筆資料
        return books.stream().
                filter(b -> b.getId() == id)
                .findFirst()
                .get();
    }

    //新增
    public static Boolean createBook(Book book) {
        boolean flag=books.stream().filter(b -> b.getId() == book.getId()).findAny().isPresent();
        if (flag == false) {
            books.add(book);

            return true;
        }
        return false;
    }

    //修改
    public static Boolean updateBook(Integer id, Book book) {

        //原始oBook的資料是否有抓到
        Book oBook = getBook(id);
        if (oBook == null) {
            return false;
        }
        //將新book的資料給  oBook
        oBook.setName(book.getName());
        oBook.setPrice(book.getPrice());

        return true;
    }

    //刪除
    public static Boolean dateleBook(Integer id) {

        //原始oBook的資料是否有抓到
        Book oBook = getBook(id);
        if (oBook == null) {
            return false;
        }
        //將這筆資料刪除
        books.remove(oBook);
        return true;
    }
}
