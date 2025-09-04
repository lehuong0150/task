package com.example.lib_task
data class Person(var name: String = "", var age: Int = 0)
fun main(){
    demoLet()
    demoRun()
    demoWith()
    demoApply()
    demoAlso()
}

fun demoLet(){
    //let
    val name: String? = "Dao Thi My"
    name?.let {
        println("Length of name using let : ${it.length}")
    }

    val nullName: String? = null
    nullName?.let {
        println("NULL")
    }
}
fun demoRun(){
    //run
    val name: String? = "Dao Thi My"
    val length = name?.run {
        this.length
    }
    println("Length of name using run: $length")

    val nullName: String? = null
    val nullLength = nullName?.run {
        println("NULL")
        this.length
    }
    println("Length of nullName using run: $nullLength")
}

fun demoWith(){
    //with
    val name = "Dao Thi My"
    val length = with(name) {
        this.length
    }
    println("Length of name using with: $length")
}

fun demoApply(){
    //apply
    val person = Person().apply {
        name = "Dao Thi My"
        age = 20
    }
    println("Person using apply: Name=${person.name}, Age=${person.age}")
}

fun demoAlso(){
    //also
    val person = Person().also {
        it.name = "Dao Thi My"
        it.age = 20
    }
    println("Person using also: Name=${person.name}, Age=${person.age}")
}