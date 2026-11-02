with AllProduct as (
    select distinct product_id
    from Products
)

select product_id,coalesce(price,10) as price
from (
    select product_id, new_price as price
    from (

        select product_id,
        new_price,
        rank() over (partition by product_id order by change_date desc) as rnk
        from Products
        where change_date <= timestamp("2019-08-16")

        ) tmp
        where rnk = 1

) Rnktable right join Allproduct
using (product_id);
