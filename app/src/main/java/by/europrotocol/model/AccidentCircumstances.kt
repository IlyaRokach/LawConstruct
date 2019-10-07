package by.europrotocol.model

class AccidentCircumstances (
    // 1 не соблюдал боковую дистанцию
    val didNotMaintainSafeDistance: Boolean,
    // 2 не соблюдал необходимый боковой интервал
    val didNotComplyWithRequiredLateralInterval: Boolean,
    // 3 перестраивался в другую полосу
    val rebuiltAnotherLane: Boolean,
    // 4 поворачивал направо
    val turnedRight: Boolean,
    // 5 поворачивал налево
    val turnedLeft:Boolean,
    // 6 Разворачивался
    val turnedAround: Boolean,
    // 7 Двигался задним ходом
    val backUp: Boolean,
    // 8 Съезжал с проезжей части
    val droveOffRoadway: Boolean,
    // 9 Выехал на перекрёсток на запрещающий сигнал светофора.
    val leftToTheIntersectionProhibitionSignal: Boolean,
    // 10 выехал на полосу встречного движения
    val droveIntoTheOncomingLane: Boolean,
    // 11 нарушил правила обгона
    val violatedTheRulesOfOvertaking: Boolean,
    // 12 Начинал движение после остановки, стоянки
    val startedMovingAfterStoppingOrParking: Boolean,
    // 13 Не выполнил требование знака приоритета
    val didNotComplyWithPriorityMarkRequirement: Boolean,
    // 14 Выезжал со второстепенной дороги, прилегающей территории
    val DepartedFromSecondaryRoadAdjacentToTheTerritory: Boolean,
    // 15 Двигался по прилегающей территории при наличии препятствия справа
    val movedAroundTheTerritoryInThePresenceOfAnObstacleToTheRight: Boolean,
    // 16 Двигался по перекрёстку с круговым движением
    val movedAroundTheRoundabout: Boolean,
    // 17 Совершил наезд на стоящее ТС
    val collidedWithaStandingVehicle: Boolean,
    // 18 Остановился, вынужденно остановился, стоял
    val stoppedOrForcedlyStoppedOrStood: Boolean,
    // 19 Иное нарушение, не указанное в пункте 1-18
    val otherViolationNotSpecifiedInParagraph1to18: Boolean
)