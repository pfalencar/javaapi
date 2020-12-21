CREATE DATABASE scc4;
USE scc4;

CREATE TABLE goals_scored (
	serial INT,
    player varchar (50),
    matches_played INT,
    gols_scored_left_foot INT,
	gols_scored_right_foot INT
);
DROP TABLE goals_scored;

CREATE TABLE player_shots (
	player varchar (50),
    matches_played INT,
	shots INT
);
DROP TABLE player_shots;

INSERT INTO goals_scored (serial, player, matches_played, gols_scored_left_foot, gols_scored_right_foot) VALUES (1, 'Pelé', 100, 50, 40);
INSERT INTO goals_scored (serial, player, matches_played, gols_scored_left_foot, gols_scored_right_foot) VALUES (2, 'Bebeto', 30, 20, 10);
INSERT INTO goals_scored (serial, player, matches_played, gols_scored_left_foot, gols_scored_right_foot) VALUES (1, 'Romário', 15 , 5, 3);
INSERT INTO goals_scored (serial, player, matches_played, gols_scored_left_foot, gols_scored_right_foot) VALUES (1, 'Zé', 10, 0, 2);
SELECT * FROM goals_scored;

INSERT INTO player_shots (player, matches_played, shots) VALUES ('Pelé', 100, 80);
INSERT INTO player_shots (player, matches_played, shots) VALUES ('Bebeto', 30, 15);
INSERT INTO player_shots (player, matches_played, shots) VALUES ('Romário', 15, 4);
INSERT INTO player_shots (player, matches_played, shots) VALUES ('Zé', 10, 4);
SELECT * FROM player_shots;

SELECT gs.player, gs.matches_played, gs.gols_scored_left_foot + gs.gols_scored_right_foot as gols, ps.shots FROM goals_scored AS gs INNER JOIN player_shots AS ps ON gs.player = ps.player;

SELECT gs.player, gs.matches_played, gs.gols_scored_left_foot, gs.gols_scored_right_foot FROM goals_scored AS gs UNION SELECT ps.shots FROM player_shots AS ps;

SELECT gols_scored_right_foot + gols_scored_left_foot FROM goals_scored; 

select 
  coalesce(gs.player, ps.player) as player, 
  gs.matches_played,
  coalesce(gs.gols_scored_left_foot + gols_scored_right_foot) as goals,
  ps.shots
from player_shots ps, goals_scored gs
where gs.player = ps.player 
order by matches_played ASC


