package br.senai.sp.jandira.mytrips.ui.theme

import java.time.LocalDate

fun simplificarData(dataExtenso: LocalDate): String{
    val dia = dataExtenso.dayOfMonth.toString()
    val mes = dataExtenso.month.toString().substring(0..2)
    return "$dia - $mes"
}