//package com.example.lib_task
/*
    6. OOP (Lập trình hướng đối tượng)
        Class & Object
        Constructor (Primary & Secondary)
        Kế thừa (open class, override)
        Interface & Abstract Class
        Data Class
        Singleton (object)
 */
fun main(){
    demoClassObject()
    demoConstructor()
    demoInheritance()
    demoInterfaceAbstractClass()
    demoDataClass()
}
// Class & Object
class Car(var brand: String, var model: String, var year: Int) {
    fun displayInfo() {
        println("Car Info: $brand $model, Year: $year")
    }
}
fun demoClassObject(){
    val car1 = Car("Toyota", "Camry", 2020)
    car1.displayInfo()
}

// Constructor (Primary & Secondary)
class Person(var name: String, var age: Int) {
    //Primary Constructor
    init {
        println("Person Created: $name, Age: $age")
    }

    //Secondary Constructor
    constructor(name: String) : this(name, 0) {
        println("Secondary Constructor Called")
    }
}
fun demoConstructor(){
    val person1 = Person("Alice", 25)
    val person2 = Person("Bob")
    println("Person1: ${person1.name}, Age: ${person1.age}")
    println("Person2: ${person2.name}, Age: ${person2.age}")
}

// Kế thừa (open class, override)
open class Animal(var name: String) {
    open fun sound() {
        println("$name makes a sound")
    }
}
class Dog(name: String) : Animal(name) {
    override fun sound() {
        println("$name barks")
    }
}
fun demoInheritance(){
    val animal = Animal("Generic Animal")
    animal.sound()
    val dog = Dog("Buddy")
    dog.sound()
}

// Interface & Abstract Class
interface Drivable {
    fun drive()
}
abstract class Vehicle(var brand: String) {
    abstract fun start()
}
class Bike(brand: String) : Vehicle(brand), Drivable {
    override fun start() {
        println("$brand bike started")
    }
    override fun drive() {
        println("Driving the $brand bike")
    }
}
fun demoInterfaceAbstractClass(){
    val bike = Bike("Yamaha")
    bike.start()
    bike.drive()
}

// Data Class
data class Book(var title: String, var author: String, var year: Int)
fun demoDataClass(){
    val book1 = Book("1984", "George Orwell", 1949)
    val book2 = Book("1984", "George Orwell", 1949)

    println("Book1: $book1")
    println("Book2: $book2")
    println("Are book1 and book2 equal? ${book1 == book2}")

    val book3 = book1.copy(year = 1950)
    println("Book3 (copied from Book1 with new year): $book3")
}

// Singleton (object)

