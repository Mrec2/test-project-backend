select * from respuestas;
select * from preguntas;

select cuerpoPregunta, cuerpo from respuestas natural join preguntas where correcta = true;