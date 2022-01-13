import pt.isel.canvas.*

/**
 * Draw the elements of the Game.
 * @param canvas the [Canvas] to draw on.
 * @param game the [Game]'s elements used to draw
 */
fun drawGame(canvas: Canvas, game: Game){
    canvas.erase()
    createSpaceship(canvas, game)
    canvas.createAlienShots(game.alienShots)
    canvas.drawShipShot(game.ship.shot)
    canvas.drawAliens(game)

}

/**
 * Draw all the alienShots
 * @param alienShots is the list of [Shot] in Game.
 */
fun Canvas.createAlienShots(alienShots: List<Shot>){
    alienShots.forEach{Shot->
        drawRect(Shot.pos.x, Shot.pos.y,WIDTH_SHOT,HEIGHT_SHOT, RED)
    }
}

/**
 * Draw the spaceship
 * @param canvas the [Canvas] to draw on.
 * @param game used for the game's elements.
 */
fun createSpaceship(canvas: Canvas, game: Game){

    val xCenterCockpit = game.ship.cockpit.x - SHIP_WIDTH/2

    /*canvas.drawRect(xCenterCockpit, game.ship.cockpit.y, SHIP_WIDTH, SHIP_HEIGHT, GREEN)
    canvas.drawRect(xCenterGun, game.ship.gun.y, GUN_WIDTH, GUN_HEIGHT, YELLOW)*/
    canvas.drawImage("spaceship", xCenterCockpit, game.ship.cockpit.y, SHIP_WIDTH, SHIP_HEIGHT + GUN_HEIGHT)
}



/**
 * Draw the Ship's Shot.
 * @param gunShot [Shot] or null fired by gun.
 */
fun Canvas.drawShipShot(gunShot: Shot?) {

    if (gunShot != null) drawRect(gunShot.pos.x, gunShot.pos.y, WIDTH_SHOT, HEIGHT_SHOT, WHITE)
}