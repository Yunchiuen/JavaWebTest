create table book(
 -- id int 不允許null 自動產生 
    id int not null generated always as identity,
    --  name藍色代表保留字有些資料表不行用保留字 
    --  varchar 字串
    name varchar(50) not null,
    price int not null,
    --ts時戳
    ts timestamp default current_timestamp,
    --主鍵唯一值
    primary key(id)
)