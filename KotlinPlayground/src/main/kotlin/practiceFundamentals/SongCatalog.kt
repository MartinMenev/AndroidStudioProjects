package practiceFundamentals

class Song(private val title: String,
           private val artist: String,
           private val yearPublished: String,
           private val playCount: Int = 0) {
    val isPopular: Boolean
        get() = playCount >= 1000 // false if below 1000


    fun printSong(): String {
        return "$title, performed by $artist, was released in $yearPublished."
    }
}
    fun main() {
        val mySong = Song("Wings", "Martin", "2018", 90)
        println(mySong.printSong())

        //testing if the Song is popular

        println(mySong.isPopular)
    }


