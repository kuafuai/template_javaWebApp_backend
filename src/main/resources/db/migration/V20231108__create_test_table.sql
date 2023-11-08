create table alm_table
(
    id   integer primary key autoincrement,
    unique_key TEXT,
    due_date TEXT,
    export_time TEXT,
    message TEXT,
    status integer
);