class Dog(name: String) : Animal(name) {
    override fun sound() {
        println("$name barks")
    }
}