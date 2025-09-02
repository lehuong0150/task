package com.example.lib_task



fun main(){
    val students = mutableListOf<Student>(
        Student(1, "Nguyen Van Xuan", 20, 8.5),
        Student(2, "Tran Thi Bich", 21, 9.2),
        Student(3, "Le Van Canh", 19, 6.8),
        Student(4, "Pham Thi Dung", 22, 5.5),
        Student(5, "Hoang Van Hung", 20, 4.3)
    )
    addStudent(students)
    demoLoop(students)
    demoOperator(students)
    demoCollection(students)
    demoScopeFunction(students[0])
}
