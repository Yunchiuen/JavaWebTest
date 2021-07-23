--價格一律加10%
--update book set price=price*1.1; 

--價格一律1元
--update book set price=1;

--修改id=1的資料 name=java8 price=200
update book b set b."NAME"='java8', b.PRICE=200 where b.id=1