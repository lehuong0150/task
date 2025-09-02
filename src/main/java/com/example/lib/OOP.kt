package com.example.lib_task
fun main(){
    //OOP
    testCar()

    testConstructor()

    testExtend()

    testInterfaceAndAbstract()
    //Data Class
    testDataClass()

    //User Management
    val p1 = User2(1, "My", "daothimy@gmail.com")
    val p2 = User2(2," Hanh", "vuhonghanh@gmail.com" )
    UserManager.addUser(p1)
    UserManager.addUser(p2)
    // kiem tra email su dung extension function
    println("Email ${p2.email} hop le?:  ${p2.email.isValidEmail()}")
    println("Email 'abs@' hop le: "  + "@abs".isValidEmail())

    //test null
    val found = UserManager.findUserByEmail(
        "lehuong@gmail.com"
    )
    //safe call + Elvis
    println("Tim thay user: ${found?.name ?: "Khong tim thay"}")


}
//3. Lập trình hướng đối tượng (OOP)
//📌 Class & Object
class Car(val brand: String, val year: Int){
    fun getInfo(): String{
        return "$brand - $year"
    }
}

//Tạo object myCar và in thông tin.
fun testCar(){
    val myCar = Car("Toyota", 2020)
    println(myCar.getInfo())
}
//📌 Constructor (Primary & Secondary)
//Viết class Student có:
class student(val id: Int, var name: String){
    var grade: String = "N/A"
    //Secondary constructor
    constructor(id: Int, name: String, grade: String): this(id, name){
        this.grade = grade
    }

    fun getInfo(): String {
        return if (grade == "N/A") {
            "ID: $id, Name: $name"
        } else {
            "ID: $id, Name: $name, Grade: $grade"
        }
    }

}
// test testConstructor
fun testConstructor(){
    val student1 = student(1, "Dao Thi My")
    val student2 = student(2, "Vu Hong Hanh", "A")
    println(student1.getInfo())
    println(student2.getInfo())
}
//📌 Kế thừa (open class, override)
open class Animal{
    open fun speak(): String{
        return "Some sound"
    }
}
class Dog: Animal(){
    override fun speak(): String {
        return "Woof"
    }
}
//test extend class
fun testExtend(){
    val dog = Dog()
    println("Dog says: ${dog.speak()}")
}
//📌 Interface & Abstract Class
interface  Shape{
    fun area(): Double
}
//Tạo class Circle (có radius) implement Shape.
class Circle(val radius:Double): Shape{
    override fun area(): Double {
        return Math.PI * radius * radius
    }
}

//Tạo abstract class Polygon có property sides: Int, abstract fun perimeter().
abstract class Polygon(val sides: Int){
    abstract fun perimeter(): Double
}
//Tạo class Rectangle(width, height) kế thừa Polygon.
class Rectangle(val width: Double, val height: Double): Polygon(4){
    override fun perimeter(): Double {
        return 2 * (width + height)
    }
}
//test interface & abstract class
fun testInterfaceAndAbstract(){
    val circle = Circle(5.0)
    println("Circle area: ${circle.area()}")
    val rectangle = Rectangle(4.0, 6.0)
    println("Ractangle sides: ${rectangle.sides}")
    println("Rectangle perimeter: ${rectangle.perimeter()}")
}
//📌 Data Class
//Viết data class User(val id: Int, val name: String)
data class User(val id: Int, val name: String)
//Tạo object u1, clone ra u2 = u1.copy(name="Trang").
fun testDataClass(){
    val u1 = User(1, "My")
    val u2 = u1.copy(name="Trang")
    val u3 = u1.equals(u2)
    val u4 = u1.hashCode()
    val u5 = u1.toString()
    println(u1)
    println(u2)
    println("u1 equals u2: $u3")
    println("u1 hashcode: $u4")
    println("u1 toString: $u5")
}

