package br.senai.sp.jandira.mytrips.repository

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.mytrips.R
import br.senai.sp.jandira.mytrips.model.Trips
import java.time.LocalDate

class TripsRepository {
    @Composable
    fun listarTodasAsViagens(context: Context): List<Trips> {

        val viagemLondres = Trips()
        viagemLondres.id = 1
        viagemLondres.destino = "London"
        viagemLondres.descricao =
            "London is the capital and largest city of  the United Kingdom, with a population of just under 9 million."
        viagemLondres.dataChegada = LocalDate.of(
            2019,
            2,
            18
        )
        viagemLondres.dataPartida = LocalDate.of(
            2019,
            2,
            21
        )
        viagemLondres.imagem = painterResource(R.drawable.londres)

        val viagemPorto = Trips()
        viagemPorto.id = 2
        viagemPorto.destino = "Porto"
        viagemPorto.descricao =
            "Porto is the second city in Portugal, the capital of the Oporto District, and one of the Iberian Peninsula's major urban areas."
        viagemPorto.dataChegada = LocalDate.of(
            2022,
            3,
            18
        )
        viagemPorto.dataPartida = LocalDate.of(
            2022,
            3,
            21
        )
        viagemPorto.imagem = painterResource(R.drawable.porto)

        val viagens = listOf(
            viagemLondres,
            viagemPorto
        )

        return viagens
    }
}