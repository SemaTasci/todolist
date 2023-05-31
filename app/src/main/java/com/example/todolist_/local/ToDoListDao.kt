package com.example.todolist_.local

import androidx.room.*
import com.example.todolist_.local.entity.NoteCardEntity
import com.example.todolist_.local.entity.NoteDescriptionEntity

@Dao
interface ToDoListDao {

    @Query("SELECT * FROM notes")
    fun getAllNoteCards(): List<NoteCardEntity>

    @Query("SELECT * FROM  notedescription")
    fun getDescriptionList():List<NoteDescriptionEntity>


    @Insert(onConflict = OnConflictStrategy.REPLACE) //dbde aynı kayıt varsa güncellemeyi buna göre yapar.eskinin yerine yenisini yazar her sekilde
    fun insert(vararg noteCard: NoteCardEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveNoteDescription (vararg noteDescriptionEntity: NoteDescriptionEntity)

    @Delete
    fun delete(noteCard: NoteCardEntity)

    @Query("SELECT FROM NoteCard WHERE id=:noteId ")
     fun getByNoteId(noteId: Int): NoteCardEntity

     @Update
     fun update(noteCard: NoteCardEntity)
}


