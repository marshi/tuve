package marshi.android.tuve.repository.api.youtube.parameter

enum class Part {
    Snippet,
    Player,
    ContentDetails
    ;

    val label = name.toLowerCase()
}