package com.pucpr.helloSpring

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

// query params
@RestController
@RequestMapping("/api")
class Exercicio_01 {
    private val log = LoggerFactory.getLogger(Exercicio_01::class.java)

    @GetMapping("date")
    @ResponseBody
    fun dataExercicio(
        @RequestParam(name = "inicio", required = false, defaultValue = "get") inicio: String,
        fim: String
    ): String {
        //        return "data inicio: ${inicio.toString()} data do fim $fim"
        return date(inicio, fim)
    }

    private fun date(inicio: String, fim: String): String {
        val date = SimpleDateFormat("dd/MM/yyyy", Locale.forLanguageTag("pt-br"))

        val firstDate: Date = date.parse(inicio)
        val secondDate: Date = date.parse(fim)
        val dataformatada = secondDate.time - firstDate.time

        val time = TimeUnit.DAYS
        val dias = time.convert(dataformatada, TimeUnit.MILLISECONDS)

        val semana = (dias / 7).toInt()
        val mes = (dias / (365 / 12)).toInt()

        return "Diferença de Dias: $dias Semanas: $semana Meses: $mes"
    }
}
//Exercico1:
//
//Faça um form/serviço onde o usuário possa colocar duas datas (data inicio e data fim) e o servidor retorne;
//A diferença de dias entre as datas;
//
//A diferença de semana entre as datas;
//
//A diferença de messes entre as datas;
