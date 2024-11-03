CREATE TABLE game (
    game_id BIGINT PRIMARY KEY,
    start_date TIMESTAMP NOT NULL,
    title VARCHAR(10) NOT NULL,
    player_move VARCHAR(8) NOT NULL,
    computer_move VARCHAR(8) NOT NULL,
    winner VARCHAR(50)
);