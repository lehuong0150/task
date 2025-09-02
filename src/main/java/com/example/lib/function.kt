package com.example.lib_task

//1. Ham & Extension function
//Viết một hàm sum(a: Int, b: Int) trả về tổng 2 số.
fun sum(a: Int, b: Int): Int{
    return a + b
}
//Viết lại sum theo hàm một dòng.
fun divide(a: Int, b: Int) = a.toDouble()/b
//Tạo hàm greet demo default parameter và named argument.
fun greet(name : String, message: String = "Xin chào"){
    println("$message, $name!")
}
//Viết extension function cho String tên là isPalindrome(): kiểm tra chuỗi có đối xứng không.
fun String.isPalindrome():Boolean{
    val cleaned = this.lowercase().replace("\\s+".toRegex(), "")
    return cleaned == cleaned.reversed()
}
//test function
fun testFunction(){
    println("Tong 2 so = ${sum(5, 10)}")
    println("Chia 2 so = ${divide(15, 10)}")
    greet("My") //goi bang default parameter
    greet(message = "Chao mung", name = "Hanh") //goi bang named argument
    println("madam".isPalindrome())//true
    println("hello".isPalindrome())//false
}
