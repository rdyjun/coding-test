SELECT ROUND(AVG(IF(LENGTH IS null, 10, LENGTH)), 2) AS AVERAGE_LENGTH
FROM FISH_INFO;