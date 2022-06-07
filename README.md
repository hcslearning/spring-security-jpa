# Spring Security + JPA 

Example project Spring Security + JPA.
h2-console rules in Spring Security configuration are added.

## ROLES and Authorities 

Si usamos el prefijo ROLE_ podemos usar posteriormente hasRole('ADMIN') u otro.
Si NO usamos el prefijo ROLE_ podremos usar el método hasAuthority('ADMIN').
ROLE está pensado para representar un grupo de permisos.
AUTHORITY está pensado para representar un permiso muy granulado ej. READ, WRITE, etc.
Spring Security no tiene métodos ni clases diferentes para soportar roles y authorities.
Solo hace la distinción a través del prefijo.
