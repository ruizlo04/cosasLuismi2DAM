insert into categorias (nombre, id) values ('Ole ole', nextval('categorias_seq'));
insert into productos (categoria_id, descripcion, nombre, precio, id) values (1, 'Lorem ipsum solor sit amet', 'Botellín fresquito', 1.0, nextval('productos_seq'));
