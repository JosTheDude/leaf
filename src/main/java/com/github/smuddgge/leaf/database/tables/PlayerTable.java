package com.github.smuddgge.leaf.database.tables;

import com.github.smuddgge.leaf.database.Record;
import com.github.smuddgge.leaf.database.records.PlayerRecord;
import com.github.smuddgge.leaf.database.sqlite.SQLiteDatabase;
import com.github.smuddgge.leaf.database.sqlite.SQLiteTable;
import com.github.smuddgge.leaf.datatype.User;

import java.util.ArrayList;

/**
 * Represents the player table in the database.
 */
public class PlayerTable extends SQLiteTable {

    /**
     * Used to register the table with a database.
     *
     * @param database The instance of the database.
     */
    public PlayerTable(SQLiteDatabase database) {
        super(database);
    }

    @Override
    public String getName() {
        return "Player";
    }

    @Override
    public Record getRecord() {
        return new PlayerRecord();
    }

    /**
     * Used to update a user in the database.
     *
     * @param user User to update.
     */
    public void updatePlayer(User user) {
        ArrayList<Record> playerRecords = this.getRecord("uuid", user.getUniqueId().toString());
        PlayerRecord playerRecord = new PlayerRecord();

        if (playerRecords.isEmpty()) {
            playerRecord.uuid = user.getUniqueId().toString();
            playerRecord.name = user.getName();
        } else {
            playerRecord = (PlayerRecord) playerRecords.get(0);
        }

        this.insertRecord(playerRecord);
    }

    /**
     * Used to get a player record given there uuid.
     *
     * @param uuid The players uuid.
     * @return The requested record.
     */
    public PlayerRecord getPlayer(String uuid) {
        ArrayList<Record> result = this.getRecord("uuid", uuid);
        if (result.isEmpty()) return null;
        return (PlayerRecord) result.get(0);
    }

    /**
     * Used to check if the player table contains a player name.
     *
     * @param playerName The players name to check for.
     * @return True if the player exists in the database.
     */
    public boolean contains(String playerName) {
        ArrayList<Record> result = this.getRecord("name", playerName);
        return !result.isEmpty();
    }
}
