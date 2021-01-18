/*
* @Author: zhaojunfu
* @Date:   2020-04-17 16: 53: 24
* @Last Modified by:   zhaojunfu
* @Last Modified time: 2020-05-11 18:07:39
*/


# Write your MySQL query statement below

select
id,
sum(Jan_Revenue) as Jan_Revenue,
sum(Feb_Revenue) as Feb_Revenue,
sum(Mar_Revenue) as Mar_Revenue,
sum(Apr_Revenue) as Apr_Revenue,
sum(May_Revenue) as May_Revenue,
sum(Jun_Revenue) as Jun_Revenue,
sum(Jul_Revenue) as Jul_Revenue,
sum(Aug_Revenue) as Aug_Revenue,
sum(Sep_Revenue) as Sep_Revenue,
sum(Oct_Revenue) as Oct_Revenue,
sum(Nov_Revenue) as Nov_Revenue,
sum(Dec_Revenue) as Dec_Revenue
from
(
	select
	id,
	case when month='Jan' then revenue else null end as Jan_Revenue,
	case when month='Feb' then revenue else null end as Feb_Revenue,
	case when month='Mar' then revenue else null end as Mar_Revenue,
	case when month='Apr' then revenue else null end as Apr_Revenue,
	case when month='May' then revenue else null end as May_Revenue,
	case when month='Jun' then revenue else null end as Jun_Revenue,
	case when month='Jul' then revenue else null end as Jul_Revenue,
	case when month='Aug' then revenue else null end as Aug_Revenue,
	case when month='Sep' then revenue else null end as Sep_Revenue,
	case when month='Oct' then revenue else null end as Oct_Revenue,
	case when month='Nov' then revenue else null end as Nov_Revenue,
	case when month='Dec' then revenue else null end as Dec_Revenue
	from
	Department
)tem
group by id

# 1205 每个月的交易
# Write your MySQL query statement below

select
`month`,
country,
sum(approved_count) as approved_count,
sum(approved_amount) as approved_amount,
sum(chargeback_count) as chargeback_count,
sum(chargeback_amount) as chargeback_amount
from

(select
	substr(trans_date, 1, 7) as `month`,
	country,
	count(1) as approved_count,
	sum(amount) as approved_amount,
	0 as chargeback_count,
	0.0 as chargeback_amount
	from
	Transactions
	where
	state='approved'
	group by 
	substr(trans_date, 1, 7) ,
	country


	union all


	select
	substr(b.trans_date, 1, 7) as `month`,
	country,
	0 as approved_count,
	0.0 as approved_amount,
	count(1) as chargeback_count,
	sum(amount) as chargeback_amount
	from
	Transactions a
	join
	Chargebacks  b
	on a.id=b.trans_id
	group by 
	substr(b.trans_date, 1, 7) ,
	country
)all_data
group by month,
country


#579. 查询员工的累计薪水


# Write your MySQL query statement below
SELECT
a.Id AS id, a.Month AS month,SUM(b.Salary) AS Salary
FROM
Employee a, Employee b
WHERE a.Id = b.Id 
AND (a.Id, a.Month) NOT IN (SELECT Id, MAX(Month) FROM Employee GROUP BY Id)
and a.Month-b.Month<=2
and a.Month-b.Month>=0
GROUP BY a.Id, a.Month
ORDER BY a.Id, a.Month DESC


#618. 学生地理信息报告





select
name,
continent,
id 
from 
student
order by name







