WITH NumberedLogs AS (
    SELECT 
        num,
        LAG(num, 1) OVER (ORDER BY id) prev_num,
        LEAD(num, 1) OVER (ORDER BY id) next_num 
    FROM Logs
)
SELECT num ConsecutiveNums
FROM NumberedLogs
WHERE num = prev_num AND num = next_num