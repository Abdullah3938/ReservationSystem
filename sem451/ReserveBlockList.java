package sem451;

import java.io.*;
import java.util.*;

public class ReserveBlockList implements Serializable {
    private List<ReserveBlock> reserveBlocks;

    public ReserveBlockList() {
        reserveBlocks = new ArrayList<>();
    }

    public int countReserveBlocks() {
        return reserveBlocks.size();
    }

    public void addReserveBlock(ReserveBlock block) {
        if (!reserveBlocks.contains(block)) {
            reserveBlocks.add(block);
        }
    }

    public boolean removeReserveBlock(ReserveBlock block) {
        return reserveBlocks.remove(block);
    }

    public ReserveBlock findReserveBlockByRoomAndTime(Room room, int clock) {
        for (ReserveBlock block : reserveBlocks) {
            if (block.getRoom().equals(room) && block.getClock() == clock) {
                return block;
            }
        }
        return null;
    }

    public void printAllReserveBlocks() {
        for (ReserveBlock block : reserveBlocks) {
            System.out.println(block);
        }
    }

    public void saveToFile(String filename) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
        out.writeObject(reserveBlocks);
        out.close();
    }

    public void loadFromFile(String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
        reserveBlocks = (List<ReserveBlock>) in.readObject();
        in.close();
    }
}
