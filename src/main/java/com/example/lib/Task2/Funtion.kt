package com.example.lib_task.Task2
/*
    4. Hàm & Extension Function
        Hàm thông thường
        Hàm một dòng
        Default Parameter & Named Argument
        Extension Function
 */
fun main(){
    demoFunction()
    demoOneLineFunction()
    demoDefaultParameter()
    demoNamedArgument()
    demoExtensionFunction()
}

fun demoFunction(){
    //Hàm thông thường
    fun sum(a: Int, b: Int): Int {
        return a + b
    }
    val result = sum(10, 20)
    println("Sum = $result")
}

fun demoOneLineFunction(){
    //Hàm một dòng
    fun divide(a: Int, b: Int) = a.toDouble() / b
    val result = divide(15, 10)
    println("Divide = $result")
}

fun demoDefaultParameter(){
    //Default Parameter
    fun notification(name: String, message: String = " you have a new message.") {
        println("$name, $message!")
    }
    notification("My") //gọi bằng default parameter
}

fun demoNamedArgument(){
    //Named Argument
    fun greet(name: String, message: String = "Xin chào") {
        println("$message, $name!")
    }
    greet(message = "Chào mừng", name = "Hạnh") //gọi bằng named argument
}

fun demoExtensionFunction(){
    //Extension Function
    fun String.isPalindrome(): Boolean {
        val cleaned = this.lowercase().replace("\\s+".toRegex(), "")
        return cleaned == cleaned.reversed()
    }
    println("madam".isPalindrome()) //true
    println("hello".isPalindrome()) //false
}

