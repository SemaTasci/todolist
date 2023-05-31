package com.example.todolist_.local

import androidx.room.*
import com.example.todolist_.local.entity.CategoryEntity
import com.example.todolist_.local.entity.NoteCardEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface IOnboardingDao {

    @Query("SELECT * FROM CategoryEntity")
    suspend fun getCategoryList(): List<CategoryEntity>

    @Query("SELECT FROM CategoryEntity WHERE id=:categoryId")
    fun getById(categoryId: Int): CategoryEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert( categoryEntity: CategoryEntity)
    @Delete
    fun delete(vararg categoryEntity: CategoryEntity)

    @Query
        ("SELECT c.,n.  FROM NoteEntity d JOIN CategoryEntity c ON n.ilIn=c.categoryId WHERE n.ilIn=:categoryId")
    suspend fun getNoteListByCategoryId(categoryId: Int): Map<CategoryEntity, List<NoteCardEntity>>

    fun getToDoListDB(): Flow<Map<CategoryEntity, List<NoteCardEntity>>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveNote(vararg noteCardEntity: NoteCardEntity)
}

