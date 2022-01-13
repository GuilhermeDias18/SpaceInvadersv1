import pt.isel.canvas.BLACK
import pt.isel.canvas.KeyEvent
import pt.isel.canvas.MouseEvent
import kotlin.math.abs

/**
 * Holds an instance of the Game.
 * @property area the [Area] in the game.
 * @property alienShots the list of [Shot]s fired by the aliens.
 * @property ship the Game's [Spaceship].
 * @property over whether the game is over.
 */
data class Game(val area: Area, val alienShots: List<Shot> = emptyList(), val ship: Spaceship, val over: Boolean=false, val aliens: Aliens)

/**
 * Build the initial state of the Game.
 * @param width the Width of the Game.
 * @param height the Height of the Game.
 * @return the initial Game.
 */
fun buildInitialGame(width: Int, height: Int) :Game{
    val area = Area(CANVAS_WIDTH, CANVAS_HEIGHT, BLACK)
    val ship = Spaceship(Cockpit(width/2 - SHIP_WIDTH/2, height - 50), Gun(width/2 - GUN_WIDTH/2, height - 50 - GUN_HEIGHT), null)
    val alienShots :List<Shot> = emptyList()
    val aliens = Aliens(octopusList(), crabList(), squidList(), Delta(56, 0))

    return Game(area, alienShots, ship, false, aliens)
}



/**
 *Fire the spaceship's shot.
 */
fun Game.shipShotFiredKeyboard(k:KeyEvent) :Game{

    val shotPosX = ship.gun.x - GUN_WIDTH/2
    val shotPosY = ship.gun.y - GUN_WIDTH/2

    val newShot = when{
        k.char == ' ' && ship.shot == null -> copy(ship = Spaceship(Cockpit(ship.cockpit.x, ship.cockpit.y), Gun(ship.gun.x,ship.gun.y), Shot(Position(shotPosX, shotPosY), Delta(0, -4))))
        else -> copy()
    }
    return newShot
}

/**
 *Fire the spaceship's shot.
 */
fun Game.shipShotFiredMouse(it:MouseEvent) :Game{

    val shotPosX = ship.gun.x - GUN_WIDTH/2
    val shotPosY = ship.gun.y - GUN_WIDTH/2

    val newShot = when{
        it.down  && ship.shot == null -> copy(ship = Spaceship(Cockpit(ship.cockpit.x, ship.cockpit.y), Gun(ship.gun.x,ship.gun.y), Shot(Position(shotPosX, shotPosY), Delta(0, -4))))
        else -> copy()
    }
    return newShot
}

/**
 *Calculates the next game iteration and returns it
 */
fun Game.step() :Game{

    val alienShotsMoved :List<Shot> = alienShots.mapNotNull { shot -> shot.moveAlienShot(CANVAS_HEIGHT) }
    val shotsInGame :List<Shot> = alienShotsMoved.filter{ !collisionWithShot(it) }

    val moveShot = Spaceship(ship.cockpit, ship.gun, ship.shot?.shipShot(0))
    //val gameOver = collision()

    return if (!over) Game(area, shotsInGame, moveShot, over, aliens) else copy()
}

/**
 * Calculates the alienShots collisions with the spaceship.
 */
fun Game.collision() :Game{
    alienShots.forEach {  if ( (it.pos.x in ((ship.cockpit.x - SHIP_WIDTH/2) .. (ship.cockpit.x + SHIP_WIDTH/2))) &&
        ((abs(it.pos.y - ship.cockpit.y ) < SHIP_HEIGHT/2))) {return copy(over = true) }
    }
    return copy(over = false)
}

fun Game.collisionWithShot(alienShot: Shot) :Boolean{

    return if (ship.shot != null) {
        ship.shot.pos.x in alienShot.pos.x - WIDTH_SHOT..alienShot.pos.x + WIDTH_SHOT && ship.shot.pos.y in alienShot.pos.y..alienShot.pos.y + HEIGHT_SHOT
    }
    else false

}