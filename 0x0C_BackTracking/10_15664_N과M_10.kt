private lateinit var arr: List<Int>
private lateinit var answer: ArrayList<Int>
private lateinit var visited: BooleanArray
private val sb =  StringBuilder()

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    arr = readln().split(" ").map { it.toInt() }.sorted()
    answer = ArrayList()
    visited = BooleanArray(n)

    backtrack(0, n,m)
    println(sb.toString())
}

private fun backtrack(k: Int, n:Int, m: Int) {
    if (answer.size == m) {
        answer.forEach { sb.append("$it ") }
        sb.append("\n")
        return
    }
    var lNum = 0
    for (i in k until n) {
        if (!visited[i] && lNum != arr[i]){
            visited[i] = true
            answer.add(arr[i])
            lNum = arr[i]
            backtrack(i+1,n,m)
            visited[i] = false
            answer.removeLast()
        }
    }
}