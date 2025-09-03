package com.example.lib_task

//Viết một chương trình quản lý người dùng:
//data class User(id, name, email)
data class  User2(val id: Int, val name: String, val email: String)
//object UserManager lưu danh sách User (singleton).
object UserManager{
    private val users = mutableListOf<User2>()
    fun addUser(user: User2){
        if (findUserByEmail(user.email) == null){
            users.add(user)
            println("User added: $user")
        } else {
            println("User with email ${user.email} already exists.")
        }
    }
    fun findUserByEmail(email: String): User2?{
        return users.find { it.email == email }
    }
    fun displayUsers(){
        if (users.isEmpty()){
            println("No users available.")
        } else {
            users.forEach { println(it) }
        }
    }
}
// extension fuction kiem tra email hop le
fun String.isValidEmail(): Boolean{
    val emailRegex= "^[A-Za-z](.*)([@]{1})(.+)(\\.)(.+)".toRegex()
    return this.matches(emailRegex)
}
fun manageUser(){
    println("Nhap thong tin nguoi dung:")
    print("ID: ")
    val id = readLine()!!.toInt()
    print("Name: ")
    val name = readLine()!!
    print("Email: ")
    val email = readLine()!!
    print("Password (co the de trong): ")
    var password = readLine()!!
    val user = User2(id,name, email).apply{
        if(email.isValidEmail()){
            if(password.isNullOrBlank()){
                password = "default123"
            }
        } else {
            println("Email khong hop le. Vui long thu lai.")
            return
        }

    }.also { println("User created successfully.") }

    println("Thong tin nguoi dung vua tao: $user")

}



