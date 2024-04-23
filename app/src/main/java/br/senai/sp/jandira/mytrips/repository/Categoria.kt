package br.senai.sp.jandira.mytrips.repository

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.mytrips.R
import br.senai.sp.jandira.mytrips.model.Categories

class Categoria {
    @Composable
    fun listarTodasAsCategorias(context: Context): List<Categories> {

        val montainCateg = Categories()
        montainCateg.id = 1
        montainCateg.nome = "Montain"
        montainCateg.imagem = painterResource(R.drawable.montain)

        val snowCateg = Categories()
        snowCateg.id = 2
        snowCateg.nome = "Snow"
        snowCateg.imagem = painterResource(R.drawable.snow)

        val beachCateg = Categories()
        beachCateg.id = 3
        beachCateg.nome = "Beach"
        beachCateg.imagem = painterResource(R.drawable.beach)

        val categorias = listOf(
            montainCateg,
            snowCateg,
            beachCateg
        )

        return categorias
    }
}