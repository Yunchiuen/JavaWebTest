package com.web.rest;

import com.web.rest.bookstore.Book;
import com.web.rest.bookstore.BookDao;
import java.net.URI;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/book")
public class BookService {

    //取得多筆資料
    @Path("/")
    @GET
    @Produces("text/plain")
    public String getBooks() {
        return BookDao.getBooks().toString();
    }

    //取得單筆資料
    @Path("/{id}")
    @GET
    @Produces("text/plain")
    public String getBook(@PathParam("id") Integer id) {
        return BookDao.getBook(id).toString();
    }

    @Path("/")
    @POST
    //從表單內拿資料需要編碼
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces("text/plain")
    public Response createBook(@FormParam("id") Integer id,
            @FormParam("name") String name,
            @FormParam("price") Integer price) {
        Book book = new Book(id, name, price);
        if (BookDao.createBook(book)) {
            // 重導這頁面 http://localhost:8080/JavaWebTest/forms/rest_book.jsp
            URI locahost = URI.create("http://localhost:8080/JavaWebTest/forms/rest_book.jsp");
            return Response.temporaryRedirect(locahost).build();
        } else {
            //建立一個500的錯誤
            return Response.status(500).build();
        }
    }

    @Path("/")
    @PUT
    //從表單內拿資料需要編碼
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces("text/plain")
    public Response updateBook(@FormParam("id") Integer id,
            @FormParam("name") String name,
            @FormParam("price") Integer price) {
        Book book = new Book(id, name, price);
        if (BookDao.updateBook(id, book)) {
            // 重導這頁面 http://localhost:8080/JavaWebTest/forms/rest_book.jsp
            URI locahost = URI.create("http://localhost:8080/JavaWebTest/forms/rest_book.jsp");
            return Response.temporaryRedirect(locahost).build();
        } else {
            //建立一個500的錯誤
            return Response.status(500).build();
        }
    }

    @Path("/")
    @DELETE
    //從表單內拿資料需要編碼
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces("text/plain")
    public Response dateleBook(@FormParam("id") Integer id) {

        if (BookDao.dateleBook(id)) {
            // 重導這頁面 http://localhost:8080/JavaWebTest/forms/rest_book.jsp
            URI locahost = URI.create("http://localhost:8080/JavaWebTest/forms/rest_book.jsp");
            return Response.temporaryRedirect(locahost).build();
        } else {
            //建立一個500的錯誤
            return Response.status(500).build();
        }
    }

}
