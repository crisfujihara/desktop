CREATE TABLE public.instrumentos (

);

CREATE TABLE public.clientes (

);

CREATE TABLE public.compras (

);

ALTER TABLE public.instrumentos ADD id int NULL;
ALTER TABLE public.instrumentos ADD nome varchar NULL;
ALTER TABLE public.instrumentos ADD descricao varchar NULL;
ALTER TABLE public.instrumentos ADD preco double precision NULL;

ALTER TABLE public.clientes ADD id int NULL;
ALTER TABLE public.clientes ADD nome varchar NULL;
ALTER TABLE public.clientes ADD idade int NULL;
ALTER TABLE public.clientes ADD email varchar NULL;

ALTER TABLE public.compras ADD id int NULL;
ALTER TABLE public.compras ADD produto varchar NULL;
ALTER TABLE public.compras ADD cliente varchar NULL;
ALTER TABLE public.compras ADD preco double precision NULL;