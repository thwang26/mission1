create table bookmarkGroup
(
    id           INTEGER not null
        primary key autoincrement,
    bookmarkName TEXT,
    orderNum     INTEGER,
    registerDate TEXT,
    updateDate   TEXT
);