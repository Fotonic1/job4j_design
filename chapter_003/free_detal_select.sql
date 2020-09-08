select
'engine' as type,
e.name as details
from car
right outer join engine as e on car.engine_id = e.id
where car.id is null

union all

select
'transmission',
tr.name
from car
right outer join transmission as tr on car.transmission_id = tr.id
where car.id is null

union all

select
'carcase',
cc.name
from car
right outer join carcase as cc on car.carcase_id = cc.id
where car.id is null