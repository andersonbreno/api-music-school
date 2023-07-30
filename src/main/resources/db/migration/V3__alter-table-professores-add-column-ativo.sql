alter table professores add ativo tinyint not null;
update professores set ativo = 1;