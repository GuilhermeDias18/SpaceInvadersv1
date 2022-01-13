import pt.isel.canvas.Canvas
import pt.isel.canvas.RED

data class Aliens(val octopus : List<Position>, val crab: List<Position>, val squid: List<Position>, val delta: Delta)

enum class Score (value: Int) {SHOT(1), OCTOPUS(10), CRAB(20), SQUID(30)}

const val ALIEN_WIDTH = 56
const val ALIEN_HEIGHT = 50

fun Canvas.drawAliens(game: Game){

    game.aliens.squid.forEach{it -> drawImage("invaders|0,0,112,80", it.x, it.y, ALIEN_WIDTH, ALIEN_HEIGHT)}
    game.aliens.crab.forEach { it -> drawImage("invaders|0,80,112,80", it.x, it.y, ALIEN_WIDTH, ALIEN_HEIGHT) }
    game.aliens.octopus.forEach { it -> drawImage("invaders|0,160,112,80", it.x, it.y, ALIEN_WIDTH, ALIEN_HEIGHT) }
}


fun octopusList() :List<Position> {
    val pos :List<Position> = listOf(Position(0, 250), Position(56, 250),Position(112, 250),Position(168, 250),Position(224, 250),Position(280, 250),Position(336, 250),Position(392, 250),Position(448, 250),Position(504, 250),Position(560, 250))

    return pos
}

fun squidList() :List<Position>{

    val pos :List<Position> =  listOf(Position(0, 50), Position(56, 50),Position(112, 50),Position(168, 50),Position(224, 50),Position(280, 50),Position(336, 50),Position(392, 50),Position(448, 50),Position(504, 50),Position(560, 50),
        Position(0, 100), Position(56, 100),Position(112, 100),Position(168, 100),Position(224, 100),Position(280, 100),Position(336, 100),Position(392, 100),Position(448, 100),Position(504, 100),Position(560, 100)
    )

    return pos
}

fun crabList() :List<Position>{

    val pos :List<Position> =  listOf(Position(0, 150), Position(56, 150),Position(112, 150),Position(168, 150),Position(224, 150),Position(280, 150),Position(336, 150),Position(392, 150),Position(448, 150),Position(504, 150),Position(560, 150),
        Position(0, 200), Position(56, 200),Position(112, 200),Position(168, 200),Position(224, 200),Position(280, 200),Position(336, 200),Position(392, 200),Position(448, 200),Position(504, 200),Position(560, 200)
    )

    return pos
}


/*
fun Canvas.makeSquids(squidList: List<Position>){

    squidList.forEach{it -> drawImage("invaders|0,0,112,80", it.x, it.y, ALIEN_WIDTH, ALIEN_HEIGHT)}
}

fun Canvas.makeCrabs(crabList: List<Position>){

    crabList.forEach { it -> drawImage("invaders|0,80,112,80", it.x, it.y, ALIEN_WIDTH, ALIEN_HEIGHT) }
}

fun Canvas.makeOctopus(octopusList: List<Position>){

    octopusList.forEach { it -> drawImage("invaders|0,160,112,80", it.x, it.y, ALIEN_WIDTH, ALIEN_HEIGHT) }
}
*/