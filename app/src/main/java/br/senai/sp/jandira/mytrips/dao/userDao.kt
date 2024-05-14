package br.senai.sp.jandira.mytrips.dao

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.senai.sp.jandira.mytrips.model.Usuario

@Dao
interface userDao {

    @Insert
    fun salvar(usuario: Usuario): Long

    @Query("SELECT * FROM tbl_usuarios ORDER BY nome ASC")
    fun listarTodosOsUsuarios(): List<Usuario>

    @Query("SELECT * FROM tbl_usuarios WHERE id = :id")
    fun  buscarUsuarioPeloId(id: Long): Usuario

    @Query("SELECT * FROM tbl_usuarios WHERE email = :email and senha = :senha")
    fun  logar(email: String, senha: String): Usuario

}