CREATE TABLE users
(
    user_id       TEXT PRIMARY KEY,
    name          TEXT NOT NULL,
    email         TEXT NOT NULL UNIQUE,
    password_hash TEXT NOT NULL
);

CREATE TABLE accounts
(
    account_id      TEXT PRIMARY KEY,
    user_id         TEXT    NOT NULL,
    name            TEXT    NOT NULL,
    initial_balance NUMERIC NOT NULL,
    currency        TEXT    NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE
);

CREATE TABLE categories
(
    category_id TEXT PRIMARY KEY,
    user_id     TEXT NOT NULL,
    name        TEXT NOT NULL,
    type        TEXT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE
);

CREATE TABLE transactions
(
    transaction_id TEXT PRIMARY KEY,
    account_id     TEXT    NOT NULL,
    category_id    TEXT    NOT NULL,
    amount         NUMERIC NOT NULL,
    type           TEXT    NOT NULL,
    date           INTEGER NOT NULL,
    description    TEXT    NOT NULL,
    FOREIGN KEY (account_id) REFERENCES accounts (account_id) ON DELETE CASCADE,
    FOREIGN KEY (category_id) REFERENCES categories (category_id) ON DELETE CASCADE
);