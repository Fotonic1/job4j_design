select
car.name as car,
e.name as engine,
tr.name as transmission,
cc.name as carcase
from car
inner join engine as e on car.engine_id = e.id
inner join transmission as tr on car.transmission_id = tr.id
inner join carcase as cc on car.carcase_id = cc.id