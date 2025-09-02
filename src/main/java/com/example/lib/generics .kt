package com.example.lib_task

fun main() {
    val car1: car<Int> = car(2020) // Int type
    val car2 : car<String> = car("2021") // String type
    val car3 : car<Double> = car(2022.5) // Double type
}
//generic class for task plus
class car<T>( year :T){
    var year: T = year
    init {
        this.year = year
        println(year)
    }
}

