package com.epam.rd.autotasks;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        this.ships = ships;
    }

    public boolean shoot(String shot) {
//        throw new UnsupportedOperationException();
        long newShot = 0b10000000_00000000_00000000_00000000_00000000_00000000_00000000_00000000L;
        switch (shot.charAt(0)) {
            case 'A': break;
            case 'B': {newShot >>>= 1; break;}
            case 'C': {newShot >>>= 2; break;}
            case 'D': {newShot >>>= 3; break;}
            case 'E': {newShot >>>= 4; break;}
            case 'F': {newShot >>>= 5; break;}
            case 'G': {newShot >>>= 6; break;}
            case 'H': {newShot >>>= 7; break;}
        }
        newShot >>>= (8 * (shot.charAt(1) - 1));
//        System.out.println(newShot + "\n" + 0b00000000_00000100_00000000_00000000_00000000_00000000_00000000_00000000L);
        shots |= newShot;
        if (ships == (ships | newShot)) {
            return true;
        }
        return false;
    }

    public String state() {
//        throw new UnsupportedOperationException();
//        ships & shots  - 0 & 0  - . пустая ячейка
//        ships & shots  - 0 & 1  - × пустая стреляная ячейка
//        ships & shots  - 1 & 0  - ☐ живой корабль
//        ships & shots  - 1 & 1  - ☒ подбитый корабль
        String strShips = Long.toBinaryString(ships);
        String strShots = Long.toBinaryString(shots);
        StringBuilder bufZeros = new StringBuilder();
        if (strShots.length() < 64) {
            for (int i = 0; i < 64 - strShots.length(); i++)
                bufZeros.append("0");
            strShots = bufZeros.append(strShots).toString();
            bufZeros.delete(0, bufZeros.length());
        }
        if (strShips.length() < 64) {
            for (int i = 0; i < 64 - strShips.length(); i++)
                bufZeros.append("0");
            strShips = bufZeros.append(strShips).toString();
            bufZeros.delete(0, bufZeros.length());
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strShots.length(); i++) {
            if (i%8 == 0)
                result.append("\n");
            if (strShips.charAt(i) == '0' && strShots.charAt(i) == '0')
                result.append(".");
            if (strShips.charAt(i) == '0' && strShots.charAt(i) == '1')
                result.append("×");
            if (strShips.charAt(i) == '1' && strShots.charAt(i) == '0')
                result.append("☐");
            if (strShips.charAt(i) == '1' && strShots.charAt(i) == '1')
                result.append("☒");
        }
        return result.toString();
    }

//    public static void main(String[] args) {
//        Battleship8x8 battle = new Battleship8x8(0b11110000_00000111_00000000_00110000_00000010_01000000_00000000_00000000L);
////        battle.shoot("B2");
//        System.out.println(battle.shoot("F2"));
//        System.out.println(battle.state());
//    }
}
