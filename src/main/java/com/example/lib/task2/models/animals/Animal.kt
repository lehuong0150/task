// Kế thừa (open class, override)
open class Animal(var name: String) {
    open fun sound() {
        println("$name makes a sound")
    }
}