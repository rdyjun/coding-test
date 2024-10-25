SELECT 
    HISTORY_ID, 
    FLOOR(
        (DAILY_FEE - (DAILY_FEE * IF(ISNULL(DISCOUNT_RATE), 0, MAX(DISCOUNT_RATE))) / 100)
        * (DATEDIFF(END_DATE, START_DATE) + 1)
    ) AS FEE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY a
INNER JOIN CAR_RENTAL_COMPANY_CAR b
ON a.CAR_ID = b.CAR_ID
LEFT JOIN (
    SELECT CAR_TYPE, SUBSTRING(DURATION_TYPE, 1, INSTR(DURATION_TYPE, '일') - 1) AS DURATION, DISCOUNT_RATE
    FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
    WHERE CAR_TYPE = '트럭'
) c
ON b.CAR_TYPE = c.CAR_TYPE AND DATEDIFF(END_DATE, START_DATE) + 1 >= DURATION
WHERE b.CAR_TYPE = '트럭'
GROUP BY HISTORY_ID
ORDER BY FEE DESC, HISTORY_ID DESC;