# TicTacToe

An online game developed in <Academia de Código_> 14 weeks bootcamp.

## The challenge

The challenge was to create a working web project that dealt with concurrency, the theme could be anything we wanted but we only had 1 weekend to get it done.

## The idea

We thought it would be fun if we made a game, so we decided to make Tic Tac Toe. The players just need to connect to the server, wait for another player to join and play from anywhere in the world.

## How it works

We have two apps: the Server App and the Client App.
 * The Server App is responsible for managing the connections, assign players to their rooms and to send each player's move to the opponent. Can handle multiple connections.
 * The Client App is where the game logic exists (win, tie, lose conditions). When player1 makes a move, that move is sent to the server. While player2 doesn't make his move, player1 is in a waiting state and cannot make new moves.

## Development

We were pair programming most of the time with teams of 2 to 3 members.

## Technologies

Java 8, Apache Ant, Git, Simple Graphics library

## Authors

[Tiago Moreira](https://www.linkedin.com/in/tiago-rajao-moreira/)

[Miguel Morais](https://www.linkedin.com/in/miguelmorais7/)

[João Correia](https://www.linkedin.com/in/joaovilas-boascorreia/)

[Jorge Tavares](https://www.linkedin.com/in/jorgetavares-/)

[Daniel Pinho](https://www.linkedin.com/in/danielpinho994/)
