package by.europrotocol.data.model

class AccidentCircumstances (
    // 1 не соблюдал боковую дистанцию
    val didNotMaintainSafeDistance: Boolean = false,
    // 2 не соблюдал необходимый боковой интервал
    val didNotComplyWithRequiredLateralInterval: Boolean = false,
    // 3 перестраивался в другую полосу
    val rebuiltAnotherLane: Boolean = false,
    // 4 поворачивал направо
    val turnedRight: Boolean = false,
    // 5 поворачивал налево
    val turnedLeft:Boolean = false,
    // 6 Разворачивался
    val turnedAround: Boolean = false,
    // 7 Двигался задним ходом
    val backUp: Boolean = false,
    // 8 Съезжал с проезжей части
    val droveOffRoadway: Boolean = false,
    // 9 Выехал на перекрёсток на запрещающий сигнал светофора.
    val leftToTheIntersectionProhibitionSignal: Boolean = false,
    // 10 выехал на полосу встречного движения
    val droveIntoTheOncomingLane: Boolean = false,
    // 11 нарушил правила обгона
    val violatedTheRulesOfOvertaking: Boolean = false,
    // 12 Начинал движение после остановки, стоянки
    val startedMovingAfterStoppingOrParking: Boolean = false,
    // 13 Не выполнил требование знака приоритета
    val didNotComplyWithPriorityMarkRequirement: Boolean = false,
    // 14 Выезжал со второстепенной дороги, прилегающей территории
    val DepartedFromSecondaryRoadAdjacentToTheTerritory: Boolean = false,
    // 15 Двигался по прилегающей территории при наличии препятствия справа
    val movedAroundTheTerritoryInThePresenceOfAnObstacleToTheRight: Boolean = false,
    // 16 Двигался по перекрёстку с круговым движением
    val movedAroundTheRoundabout: Boolean = false,
    // 17 Совершил наезд на стоящее ТС
    val collidedWithaStandingVehicle: Boolean = false,
    // 18 Остановился, вынужденно остановился, стоял
    val stoppedOrForcedlyStoppedOrStood: Boolean = false,
    // 19 Иное нарушение, не указанное в пункте 1-18
    val otherViolationNotSpecifiedInParagraph1to18: Boolean = false
)