SELECT DISTINCT(ID), EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPERS a
INNER JOIN SKILLCODES b
ON b.NAME IN ('Python', 'C#')
WHERE (a.SKILL_CODE & b.CODE) > 0
ORDER BY ID ASC;