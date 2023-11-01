package study.racing.domain

import study.racing.strategy.MoveStrategy
import study.racing.strategy.RandomMoveStrategy

class Car(
    private val strategy: MoveStrategy = RandomMoveStrategy(),
    val carName: CarName,
    val distance: Distance = Distance()
) {

    fun getCarDistance(): Int {
        return this.distance.moveDistance
    }

    fun tryMoveTheCar() {
        if (strategy.isMoving()) {
            move()
        }
    }

    fun tryMoveTheCar(
        carIndex: Int,
        roundIndex: Int,
    ) {
        if (strategy.isMoving(carIndex, roundIndex)) {
            move()
        }
    }

    private fun move() {
        this.distance.moveForward()
    }

    fun getCarName(): String {
        return this.carName.name
    }

    fun copy(): Car {
        return Car(
            strategy = this.strategy,
            carName = this.carName,
            distance = Distance(this.getCarDistance())
        )
    }
}
