package com.example.lib_task

//2.Null Safety
//Khai báo biến name: String? → gán "Trang" hoặc null.
fun nullSafety(){
    var a:String?= "Trang"
    var b: String? = null
    // name = null //thử gán null xem lỗi gì
    //Dùng safe call (?.)
    println("Do dai chuoi cua a : ${a?.length}")
    //Dùng Elvis operator (?:) → nếu null thì in "Không có tên".
    println("Do dai chuoi cua b : ${b?.length ?: "Khong co ten"}")
    //Dùng not-null assertion (!!) → thử cố tình null xem lỗi gì.
    println("Do dai chuoi cua a : ${a!!.length}")
    //loi vi b null ( su dung!! chac chan bien phai khong null)
    //println("Do dai chuoi cua b : ${b!!.length}")
}
