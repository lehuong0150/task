fun String.isPalindrome(): Boolean {
    val cleaned = this.lowercase().replace("\\s+".toRegex(), "")
    return cleaned == cleaned.reversed()
}