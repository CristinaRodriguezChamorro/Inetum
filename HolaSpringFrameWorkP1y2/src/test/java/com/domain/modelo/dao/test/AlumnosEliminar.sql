DELETE FROM alumnos where alu_nombre ='Monsef_test'
-- suponiendo que funciono
DELETE FROM alumnos where alu_nombre ='MarinaModif_test'
-- pero si no funciono debo eliminar a la original
DELETE FROM alumnos where alu_nombre ='Marina_test'

DELETE FROM alumnos where alu_nombre ='Aarón_test'
DELETE FROM alumnos where alu_nombre ='Iván_test'
-- ademas tengo que eliminar que quse se agrego con el metodo agregar
DELETE FROM alumnos where alu_nombre ='Gabriel_test'