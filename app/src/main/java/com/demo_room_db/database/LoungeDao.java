package com.demo_room_db.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.demo_room_db.model.LoungeCustomer;

import java.util.List;

@Dao
public interface LoungeDao {
    @Query("SELECT * FROM loungecustomer WHERE email = :value OR city = :value OR number = :value " +
            "OR name like :value  ORDER BY ID")
    List<LoungeCustomer> loadLoungeCustomer(String value);

  @Query("SELECT * FROM loungecustomer  ORDER BY ID")
    List<LoungeCustomer> loadAllLoungeCustomer();

    @Insert
    void insertLoungeCustomer(LoungeCustomer person);

    @Update
    void updateLoungeCustomer(LoungeCustomer person);

    @Delete
    void delete(LoungeCustomer person);

    @Query("SELECT * FROM loungecustomer WHERE id = :id")
    LoungeCustomer loadLoungeById(int id);
}
