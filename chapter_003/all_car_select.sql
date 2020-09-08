select
car.name as car,
e.name as engine,
tr.name as transmission,
cc.name as carcase
from car
left outer join engine as e on car.engine_id = e.id
left outer join transmission as tr on car.transmission_id = tr.id
left outer join carcase as cc on car.carcase_id = cc.id