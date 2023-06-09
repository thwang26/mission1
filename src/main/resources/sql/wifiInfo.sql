create table wifiInfo
(
    X_SWIFI_MGR_NO      TEXT not null
        primary key,
    X_SWIFI_WRDOFC      TEXT,
    X_SWIFI_MAIN_NM     TEXT,
    X_SWIFI_ADRES1      TEXT,
    X_SWIFI_ADRES2      TEXT,
    X_SWIFI_INSTL_FLOOR TEXT,
    X_SWIFI_INSTL_TY    TEXT,
    X_SWIFI_INSTL_MBY   TEXT,
    X_SWIFI_SVC_SE      TEXT,
    X_SWIFI_CMCWR       TEXT,
    X_SWIFI_CNSTC_YEAR  INTEGER,
    X_SWIFI_INOUT_DOOR  TEXT,
    X_SWIFI_REMARS3     TEXT,
    LAT                 REAL,
    LNT                 REAL,
    WORK_DTTM           TEXT
);