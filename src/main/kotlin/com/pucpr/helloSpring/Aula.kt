package com.pucpr.helloSpring

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/exemplo")
class Aula{
    private val log = LoggerFactory.getLogger(Aula::class.java)
    //retorno simples
    @GetMapping
    fun hello(): String = "Olá"
    //retorno por Body
    @GetMapping("rest")
    @ResponseBody
    fun helloRest(): String = "Hello Rest"
    //pegar texto simples via GET
    @GetMapping("var/{text}")
    @ResponseBody
    fun getVar(@PathVariable text:String): String{
        return "Hello $text"
    }
    //pegar texto de quantas variavel for preciso
    @GetMapping("get")
    @ResponseBody
    fun helloGet(
        @RequestParam(name = "name", required = false, defaultValue = "get") name: String, idade:String
    ): String{
        return "Hello Get $name sua idade é $idade"
    }
    //pegar texto apenas com letras minusculas
    @RequestMapping("regex/{name:[a-z]+}")
    @ResponseBody
    fun handleString(@PathVariable name: String): String{
        return "Name $name"
    }
    //pegar apenas numeros
    @RequestMapping("regex/{number:[0-9]+}")
    @ResponseBody
    fun handleNumber(@PathVariable number: String): String{
        log.warn("é um número")
        return "Number $number"
    }
//    _____________________________________________________________
//    @ResponseStatus(HttpStatus.OK)
//    @RequestMapping(value = ["/html"], method =[RequestMethod.GET])
//    fun helloHtml(@RequestParam(
//        name = "name", required = false, defaultValue = "Get") name: String,
//                  model: Model) : String{
//        model.addAttribute("name", name)
//        return  "hello"
//    }
}