SELECT PRODUCT_CODE as CATEGORY, COUNT(PRODUCT_CODE) as PRODUCTS
FROM (SELECT SUBSTRING(PRODUCT_CODE, 1, 2) as PRODUCT_CODE
     FROM PRODUCT) as PRODUCT
GROUP BY PRODUCT_CODE
ORDER BY PRODUCT_CODE ASC;