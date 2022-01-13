import pt.isel.canvas.Canvas

import pt.isel.canvas.RED
import pt.isel.canvas.WHITE

data class Shot(val pos: Position, val delta: Delta)
const val WIDTH_SHOT = 4
const val HEIGHT_SHOT = 7
const val MAX_VELOCITY_DY_SHOT = 4
const val MIN_VELOCITY_DY_SHOT = 1


fun randomX() = (0..CANVAS_WIDTH-4).random()
fun randomDelta() = Delta(0,(MIN_VELOCITY_DY_SHOT..MAX_VELOCITY_DY_SHOT).random())



/**
 * Add shots to the alienShots list.
 * @return the Game with new shots.
 */
fun Game.addShots() :Game{
    val probability = (1..2).random()
    val newShots :List<Shot> = if (probability == 1) alienShots + Shot(Position(randomX(), 0), randomDelta())
    else alienShots

    return Game(area, newShots, ship, over, aliens)
}



