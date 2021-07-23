select b."NAME",b.PRICE,b.AMOUNT,(b.PRICE*b.AMOUNT)as subtotal
from book b
order by b.PRICE desc;
--asc 小到大, desc 大到小

--計算平均成本
select 
b."NAME",sum(b.AMOUNT) as amount,
sum(b.PRICE * b.AMOUNT)as subtotal ,
(sum(b.PRICE * b.AMOUNT)/sum(b.AMOUNT)) as average
from book b
group by b."NAME";
--group針對名子分群主 一樣sum會累加