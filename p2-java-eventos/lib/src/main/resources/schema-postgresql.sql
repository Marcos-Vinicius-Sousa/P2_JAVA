CREATE TABLE IF NOT EXISTS evento (
	
	id serial primary key,
	nm_evento varchar(50),
	local varchar(50)	 
);

CREATE TABLE IF NOT EXISTS convidado (
	id serial primary key,
	nm_convidado varchar(50),
	rg varchar(50)	
);

CREATE TABLE IF NOT EXISTS artista (
	id serial primary key,
	nm_artista varchar(50),
	nm_estilo_musical varchar(50)
);