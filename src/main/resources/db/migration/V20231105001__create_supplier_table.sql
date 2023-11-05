CREATE TABLE supplier_product (
                                  id INTEGER PRIMARY KEY AUTOINCREMENT,
                                  product_model TEXT NOT NULL,
                                  delivery_time TEXT, -- SQLite does not have a Date type, so it's common to store dates as TEXT, REAL, or INTEGER
                                  product_price REAL,
                                  deliverable_quantity INTEGER,
                                  trading_counterparty TEXT,
                                  advance_payment_ratio REAL
);