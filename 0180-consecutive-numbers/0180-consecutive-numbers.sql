# Write your MySQL query statement below

SELECT DISTINCT num ConsecutiveNums
FROM(
    SELECT num,
        LEAD(num, 1) OVER (ORDER BY id) AS num_1after,
        LEAD(num, 2) OVER (ORDER BY id) AS num_2after
    FROM logs
) AS nums
WHERE num = num_1after
    AND num_1after = num_2after