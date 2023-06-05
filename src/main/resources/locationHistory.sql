create table locationHistory
(
    id          INTEGER not null
        primary key autoincrement,
    lnt         REAL    not null,
    lat         REAL    not null,
    search_date TEXT    not null
);