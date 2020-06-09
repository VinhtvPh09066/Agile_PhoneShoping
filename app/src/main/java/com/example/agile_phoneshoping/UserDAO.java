package com.example.agile_phoneshoping;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDAO {
 @Insert
    void insert(user... users);

 @Delete
    void delete(user user);

@Update
    void update(user user);

    @Query("SELECT * FROM user")
   List<user> getAll();

@Query("SELECT * FROM user WHERE name =:name ")
    List<user> getUserByName(String name);


}
