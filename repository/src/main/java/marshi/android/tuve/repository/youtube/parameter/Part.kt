package marshi.android.tuve.repository.youtube.parameter

enum class Part {
    Snippet,
    Player,
    ContentDetails
    ;

    val label = name.toLowerCase()
}