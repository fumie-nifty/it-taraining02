select
  /*%expand*/*
from
  stock
where
  product_id = /* productId */'a'
  and
  version = /* version */1
