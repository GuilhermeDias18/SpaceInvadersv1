data class Position(val x:Int, val y:Int)
data class Delta(val dx: Int, val dy: Int)

operator fun Position.plus(delta: Delta) = Position(x + delta.dx, y + delta.dy)

/**
 * Move the alienShot.
 * @param maxHeight is the maximum height that alienShot may reach.
 * @returns Shot or null.
 */
fun Shot.moveAlienShot(maxHeight:Int) :Shot?{
    val newPosition = pos.y + delta.dy
    val newShot :Shot? = when{
        newPosition > maxHeight -> null
        else -> Shot(Position(pos.x, newPosition), Delta(delta.dx, delta.dy))
    }
    return newShot
}



/**
 * Move the Shot fired by Gun.
 * @param maxHeight is the maximum height that the shot may reach.
 * @returns Shot or null.
 */
fun Shot.shipShot(maxHeight: Int) :Shot?{

    val newPosition = pos.y + delta.dy

    val newGunShot :Shot? = when{
        newPosition - HEIGHT_SHOT < maxHeight -> null
        else -> Shot(Position(pos.x, newPosition), Delta(delta.dx, delta.dy))
    }
    return newGunShot
}
