import pt.isel.canvas.Canvas
import pt.isel.canvas.GREEN
import pt.isel.canvas.MouseEvent
import pt.isel.canvas.YELLOW

data class Spaceship(val cockpit: Cockpit, val gun: Gun, val shot: Shot?)
data class Cockpit(val x: Int, val y: Int)
data class Gun(val x: Int, val y: Int=DISPLACEMENT_BASE-GUN_HEIGHT)

const val DISPLACEMENT_BASE = 450
const val GUN_HEIGHT = 7
const val SHIP_WIDTH = 50
const val GUN_WIDTH = 4
const val SHIP_HEIGHT = 10
const val VELOCITY_SHOT_DY = -4



/**
 * Moves the spaceship.
 */
fun Game.moveSpaceship(it: MouseEvent) = when{
    it.x < SHIP_WIDTH/2 -> copy(ship = Spaceship (Cockpit(SHIP_WIDTH/2, DISPLACEMENT_BASE),
        gun = Gun(SHIP_WIDTH/2),
        shot = if (ship.shot != null) Shot(Position(ship.shot.pos.x, ship.shot.pos.y), Delta(0,VELOCITY_SHOT_DY))
        else null
    ))
    it.x >= CANVAS_WIDTH - SHIP_WIDTH/2 -> copy(ship = Spaceship(Cockpit(CANVAS_WIDTH - SHIP_WIDTH /2, DISPLACEMENT_BASE),
        gun = Gun(CANVAS_WIDTH - SHIP_WIDTH/2),
        shot = if (ship.shot != null) Shot(Position(ship.shot.pos.x, ship.shot.pos.y), Delta(0,VELOCITY_SHOT_DY))
        else null
    ))
    else -> copy(ship = Spaceship(Cockpit(it.x, DISPLACEMENT_BASE),
        gun = Gun(it.x),
        shot = if (ship.shot != null) Shot(Position(ship.shot.pos.x, ship.shot.pos.y), Delta(0,VELOCITY_SHOT_DY))
        else null
    ))
}