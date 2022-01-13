import pt.isel.canvas.*
import kotlin.math.roundToInt

data class Area(val width: Int, val height: Int, val color: Int)


const val CANVAS_WIDTH = 700
const val CANVAS_HEIGHT = 500
const val PERIOD = 70/1000.0

fun main(){
    onStart {
        val canvas = Canvas(CANVAS_WIDTH, CANVAS_HEIGHT, BLACK)

        var game = buildInitialGame(CANVAS_WIDTH, CANVAS_HEIGHT)




        createSpaceship(canvas, game)

        canvas.onTimeProgress(250) {

            game = game.addShots()
        }

        canvas.onTimeProgress(PERIOD.roundToInt()){

            if (!game.over){
                game = game.step()
                game = game.collision()
                drawGame(canvas,game)
            }
            else canvas.drawText(CANVAS_WIDTH/3, CANVAS_HEIGHT - 20, "GAME OVER", RED, 35)
        }

        canvas.onTimeProgress(300){

        }

        canvas.onMouseMove {
            game = game.moveSpaceship(it)

        }

        canvas.onKeyPressed {
            game = game.shipShotFiredKeyboard(it)

        }

        canvas.onMouseDown {
            game = game.shipShotFiredMouse(it)
        }


    }
    onFinish {  }
}
