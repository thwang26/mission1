create table bookmark
(
    id      Integer
        primary key autoincrement,
    groupId Integer
        references bookmarkGroup,
    mgrNo   TEXT
        references wifiInfo,
    registerDate TEXT
);