package com.example.noteapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.noteapp.dao.NoteDao
import com.example.noteapp.entities.Notes

@Database(entities = [Notes::class], version = 1, exportSchema = false)
abstract class NotesDataBase : RoomDatabase() {

    companion object {

        var notesDataBase: NotesDataBase? = null

        @Synchronized
        fun getDataBase(context: Context): NotesDataBase{

            if (notesDataBase == null) {
                notesDataBase = Room.databaseBuilder(context, NotesDataBase::class.java, "notes.db").build()
            }
            return notesDataBase!!
        }
    }

    abstract fun noteDao(): NoteDao
}