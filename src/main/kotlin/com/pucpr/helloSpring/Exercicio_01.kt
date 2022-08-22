package com.pucpr.helloSpring

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*
import java.text.SimpleDateFormat
import java.util.*

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
        val date = SimpleDateFormat("dd/MM/yyyy")

        val firstDate: Date = date.parse(inicio)
        val secondDate: Date = date.parse(fim)

        val cmp = firstDate.compareTo(secondDate)
        when {
            cmp > 0 -> {
                System.out.printf("%s is after %s", inicio, fim)
            }
            cmp < 0 -> {
                System.out.printf("%s is before %s", inicio, fim)
            }
            else -> {
                print("Both dates are equal")
            }
        }

//        val dias:Int
//        val semanas:Int
//        val anos:Int
//        val diaInicio = inicio.nextToken("/").toInt()
//        val mesInicio = inicio.nextToken("/").toInt()
//        val anoInicio = inicio.nextToken("/").toInt()
//        val diaFim = fim.nextToken("/").toInt()
//        val mesFim = fim.nextToken("/").toInt()
//        val anoFim= fim.nextToken("/").toInt()
//        if (anoInicio>anoFim){
//            return "error: data de inicio maior que a data final"
//        }else {
//            if (anoInicio==anoFim)
//            {
//                anos = 0
//            }else{
//                anos = anoFim - anoInicio
//            }
//        }
        return ""
    }

//Exercico1:
//
//Faça um form/serviço onde o usuário possa colocar duas datas (data inicio e data fim) e o servidor retorne;
//
//
//
//A diferença de dias entre as datas;
//
//A diferença de semana entre as datas;
//
//A diferença de messes entre as datas;


}