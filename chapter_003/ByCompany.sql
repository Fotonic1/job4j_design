select 
p.name
from person as p
where p.company_id <> 5;

select 
p.name as name_person,
c.name as name_company
from person as p
inner join company as c on p.company_id = c.id;

with per as (select 
	  		count(per.name) as cname,
			per.company_id
	  		from person as per
	  		group by company_id)	 
select 
per.cname,
c.name as namecompany
from per
left join company as c on per.company_id = c.id
where per.cname = (Select max(per.cname) from per)