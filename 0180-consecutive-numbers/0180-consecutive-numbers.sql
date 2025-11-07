# Write your MySQL query statement below
WITH NumberedLogs AS (
    SELECT 
        num,
        LAG(num, 1) OVER (ORDER BY id) as prev_num,
        LEAD(num, 1) OVER (ORDER BY id) as next_num
    FROM logs
)
SELECT DISTINCT num ConsecutiveNums
FROM NumberedLogs
WHERE num = prev_num AND num = next_num