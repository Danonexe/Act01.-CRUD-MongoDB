# Teoría
**Daniel Hernández Gómez**

### a) ¿Qué ventajas e inconvenientes encuentras al usar una base de datos documental con MongoDB?

Una de las características más destacadas de MongoDB, que puede considerarse tanto una ventaja como un inconveniente, es su flexibilidad: permite almacenar cualquier tipo de dato sin necesidad de adherirse a estructuras rígidas como las de SQL. Esto ofrece gran libertad, pero también implica que somos responsables de controlar y organizar adecuadamente cómo enviamos y gestionamos los datos.

Otra ventaja muy importante que ofrece MongoDB es su capacidad de almacenamiento en la nube y su facilidad a la hora de conectarse a esta.

### b) ¿Cuáles han sido los principales problemas que has tenido al desarrollar la aplicación?

El principal problema que he tenido ha sido la falta de validación automática al insertar campos. Esto me ha obligado a comprobar manualmente en cada operación que los campos clave estuvieran correctamente definidos. Era esencial para garantizar que, al realizar búsquedas, todos los campos clave coincidieran y no surgieran inconsistencias.

### c) ¿Cómo solucionarías el problema de la inconsistencia de datos en una base de datos documental?

Como la base de datos no nos va a controlar las inconsistencias, debemos establecer controles estrictos en las operaciones de inserción y actualización para evitar errores. Esto incluye implementar validaciones automáticas a nivel de aplicación y definir reglas claras de negocio.
