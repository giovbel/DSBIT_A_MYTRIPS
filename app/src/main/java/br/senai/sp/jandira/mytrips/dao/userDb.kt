package br.senai.sp.jandira.mytrips.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.mytrips.model.Usuario

@Database(entities = [Usuario::class], version = 1)
abstract class userDb : RoomDatabase() {

    abstract fun userDao(): userDao

    companion object{
        private lateinit var instancia: userDb

        fun getBancoDeDados(context: Context): userDb{
            instancia = Room
                .databaseBuilder(
                    context,
                    userDb::class.java,
                    "db_usuarios"
                )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()

            return instancia
        }
    }

}