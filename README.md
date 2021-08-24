# Battleship 8x8

Implement methods in [Battleship8x8](src/main/java/com/epam/rd/autotasks/Battleship8x8.java) class.

Battleship8x8 represents a 8x8 map for [Battleship game](https://en.wikipedia.org/wiki/Battleship_(game)). An important
detail is that Battleship8x8 uses a `ships` field of long type to store ships locations 
and a `shots` field of long type to register shots.

Fields of long type value store 64 bits each. Consider them as 8 rows per 8 cells.
'0' bits represent empty cells, '1' bits represent cells seized by ships or registered shots.

- `public boolean shoot(String shot)` - Registers a shot and returns `true` if the shot hits a ship. 
- `public String state()` - Returns a string representing state of the map.
Map string is 8 lines per 8 characters separated by "\n". Use following symbols: 
  - '.' - an empty cell
  - '×' - an empty cell that has been shot
  - '☐' - a cell seized by a ship
  - '☒'- a cell seized by a ship that has been shot

You must not add or change new fields.
Consider using static methods of wrapper classes.