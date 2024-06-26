SELECT DISTINCT(h.CAR_ID)
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY h
INNER JOIN CAR_RENTAL_COMPANY_CAR c
ON h.CAR_ID = c.CAR_ID
WHERE MONTH(START_DATE) = 10 AND
    CAR_TYPE = '세단'
ORDER BY CAR_ID DESC;