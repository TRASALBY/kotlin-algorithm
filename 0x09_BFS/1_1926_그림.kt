import java.util.*

private var n = 0
private var m = 0
private var maxSize = 0
private var cnt = 0
private val dx = listOf(0,0,1,-1)
private val dy = listOf(1,-1,0,0)


private lateinit var graph : Array<IntArray>
private lateinit var visited : Array<BooleanArray>

fun main(){
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    graph = Array(n) {IntArray(m) {0} }
    visited = Array(n) {BooleanArray(m) {false} }

    for (i in 0 until n){
        val line = readln().split(" ").map{it.toInt()}
        line.forEachIndexed{index,it ->
            graph[i][index] = if (it == 1) 1 else 0
        }
    }

    for (x in 0 until n){
        for (y in 0 until m){
            if(!visited[x][y] && graph[x][y] == 1){
                bfs(x,y)
                cnt += 1
            }
        }
    }

    println(cnt)
    println(maxSize)


}

private fun bfs(x:Int,y:Int){

    val q = LinkedList<Pair<Int,Int>>()
    q.offer(Pair(x,y))
    visited[x][y] = true
    var size = 1

    while (q.isNotEmpty()){
        val now = q.poll()

        for (i in 0 until 4){
            val nx = now.first + dx[i]
            val ny = now.second + dy[i]

            if (nx in 0 until n && ny in 0 until m){
                if (graph[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true
                    q.add(Pair(nx,ny))
                    size += 1
                }
            }
            if (maxSize < size) maxSize = size
        }
    }
}