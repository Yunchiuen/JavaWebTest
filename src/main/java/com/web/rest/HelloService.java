package com.web.rest;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/hello")
public class HelloService {

    // Client: /JavaWebTest/rest/hello/yun
    @Path("/yun")
    @GET
    //回傳的格式純文字型態
    @Produces("text/plain")
    public String helloYun() {
        return "Hello Yun !";
    }

    // Client: /JavaWebTest/rest/hello/1
    // Client: /JavaWebTest/rest/hello/2?score=100
    @Path("/{id}")//動態支援參數 /後面可以是任何id值
    @GET
    //回傳的格式純文字型態
    @Produces("text/plain")
    //@PathParam("id") 他會去抓到路徑參數
    //@DefaultValue("0") 這個score預設沒有資料就給0
    public String helloId(  @PathParam("id") Integer id, 
                            @DefaultValue("0") @QueryParam("score") Integer score) {
        return "id=" + id + " score=" + score;
    }

}
