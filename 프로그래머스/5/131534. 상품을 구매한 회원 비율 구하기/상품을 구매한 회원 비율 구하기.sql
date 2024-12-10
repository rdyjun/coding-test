SELECT
    YEAR(b.SALES_DATE) AS YEAR,
    MONTH(b.SALES_DATE) AS MONTH,
    COUNT(*) AS PURCHASED_USERS,
    FORMAT(COUNT(*) / c.TOTAL, 1) AS PUCHASED_RATIO
FROM USER_INFO a
INNER JOIN (
    SELECT USER_ID, SALES_DATE
    FROM ONLINE_SALE
    GROUP BY USER_ID, YEAR(SALES_DATE), MONTH(SALES_DATE)
) b
ON a.USER_ID = b.USER_ID
CROSS JOIN (
    SELECT COUNT(USER_ID) AS TOTAL
    FROM USER_INFO
    WHERE YEAR(JOINED) = 2021
) c
WHERE YEAR(a.JOINED) = 2021
GROUP BY YEAR(b.SALES_DATE), MONTH(b.SALES_DATE)
ORDER BY YEAR ASC, MONTH ASC
;