create table ansatt
(
    ansatt_id          serial not null
        constraint ansatt_pk
            primary key,
    brukernavn         varchar(4)
        constraint ansatt_brukernavn_key
            unique,
    fornavn            varchar(30),
    etternavn          varchar(30),
    dato_ansettelse    date,
    stilling           varchar(30),
    mandeslonn         integer,
    avdeling           integer
        constraint ansatt_avdeling_avdeling_id_fk
            references avdeling,
    deltatt_prosjekter integer,
    arbeidstimer       integer
);

create table avdeling
(
    avdeling_id serial not null
        constraint avdeling_pk
            primary key,
    navn        varchar(30),
    sjef        integer
);


create table prosjekt
(
    prosjekt_id serial not null
        constraint prosjekt_pkey
            primary key,
    navn        varchar(30),
    beskrivelse varchar
);

create table prosjektdeltagelse
(
    prosjektdeltagelse_id serial not null
        constraint prosjektdeltagelse_pk
            primary key,
    ansatt_id             integer
        constraint prosjektdeltagelse_ansatt_ansatt_id_fk
            references ansatt,
    prosjekt_id           integer
        constraint prosjektdeltagelse_prosjekt_prosjekt_id_fk
            references prosjekt,
    timer                 integer,
    ansatt_rolle          varchar(30)
);

create unique index prosjektdeltagelse_prosjektdeltagelse_id_uindex
    on prosjektdeltagelse (prosjektdeltagelse_id);
    
    