package br.senai.sp.jandira.mytrips.repository

import android.content.Context
import br.senai.sp.jandira.mytrips.dao.userDb
import br.senai.sp.jandira.mytrips.model.Usuario

class UserRepository(context: Context) {

    private val db = userDb.getBancoDeDados(context).userDao()

    fun salvar(usuario: Usuario): Long{
        return db.salvar(usuario)
    }

    fun buscarTodosOsUsuarios(): List<Usuario>{
        return db.listarTodosOsUsuarios()
    }

    fun buscarUsuarioPeloId(id: Long): Usuario{
        return db.buscarUsuarioPeloId(id)
    }
}