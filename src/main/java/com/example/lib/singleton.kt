package com.example.lib_task
fun main(){
    testSingleton()
}
//singleton voi companion object
class Singleton private constructor(){

    var data: String = "Dao Thi My"
    companion object{
        @Volatile
        private var instance: Singleton? = null
        fun getInstance(): Singleton {
            return instance ?: synchronized(this) {
                instance ?: Singleton().also { instance = it }
            }
        }
    }
    fun showData(){
        println("Singleton instance: $data")
    }
}
//lazy singleton
class lazySingleton private constructor()    {
    var data: String = "Dao Thi My"
    fun showData() {
        println("Name: $data")
    }
    companion object {
        val instance: lazySingleton by lazy { lazySingleton() }
    }
}


//double checked locking singleton
class DCLSingleton private constructor() {
    var data: String = "Dao Thi My"
    fun showData() {
        println("Name: $data")
    }
    companion object {
        @Volatile
        private var INSTANCE: DCLSingleton? = null
        fun getInstance(): DCLSingleton {
            return INSTANCE ?: synchronized(this) {
                val instance = DCLSingleton()
                INSTANCE = instance
                instance
            }
        }
    }
}
//eager singleton
object EagerSingleton {
    var data: String = "Dao Thi My"
    fun showData() {
        println("Name: $data")
    }
}
//test singleton
fun testSingleton() {
    //singleton
    val s1 = Singleton.getInstance()
    s1.data = "Dao Thi My"
    println("Singleton 1: ")
    s1.showData()
    val s2 = Singleton.getInstance()
    s2.data = "Nguyen Van Long"
    println("Singleton 2: ")
    s2.showData()
    println("Are s1 and s2 the same instance? ${s1 === s2}")
    //lazy singleton
    val lazy1 = lazySingleton.instance
    lazy1.data = "Vu Hong Hanh"
    println("Lazy Singleton 1: ")
    lazy1.showData()
    val lazy2 = lazySingleton.instance
    lazy2.data = "Nguyen Van Long"
    println("Lazy Singleton 2: ")
    lazy2.showData()
    println("Are lazy1 and lazy2 the same instance? ${lazy1 === lazy2}")

    //double checked locking singleton
    val dcl1 = DCLSingleton.getInstance()
    dcl1.data = "Le Huong"
    println("DCL Singleton 1: ")
    dcl1.showData()
    val dcl2 = DCLSingleton.getInstance()
    dcl2.data = "Pham Thi Dung"
    println("DCL Singleton 2: ")
    println("Are dcl1 and dcl2 the same instance? ${dcl1 === dcl2}")

    //eager singleton
    val eager1 = EagerSingleton
    eager1.data = "Pham Thi Dung"
    println("Eager Singleton1: ")
    eager1.showData()
    val eager2 = EagerSingleton
    eager2.data = "Tran Van Hung"
    println("Eager Singleton2: ")
    eager2.showData()
    println("Are eager1 and eager2 the same instance? ${eager1 === eager2}")
}

