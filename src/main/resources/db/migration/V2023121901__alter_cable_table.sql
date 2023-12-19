ALTER TABLE cable
    ADD COLUMN is_default TEXT DEFAULT '1';
ALTER TABLE cable
    ADD COLUMN version_number TEXT DEFAULT 'v1';