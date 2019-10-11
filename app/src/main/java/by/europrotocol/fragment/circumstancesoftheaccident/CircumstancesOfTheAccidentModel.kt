package by.europrotocol.fragment.circumstancesoftheaccident

class CircumstancesOfTheAccidentModel (
    // 1 не соблюдал боковую дистанцию
    var didNotMaintainSafeDistance: Boolean = false,
    // 2 не соблюдал необходимый боковой интервал
    var didNotComplyWithRequiredLateralIntervar: Boolean = false,
    // 3 перестраивался в другую полосу
    var rebuiltAnotherLane: Boolean = false,
    // 4 поворачивал направо
    var turnedRight: Boolean = false,
    // 5 поворачивал налево
    var turnedLeft:Boolean = false,
    // 6 Разворачивался
    var turnedAround: Boolean = false,
    // 7 Двигался задним ходом
    var backUp: Boolean = false,
    // 8 Съезжал с проезжей части
    var droveOffRoadway: Boolean = false,
    // 9 Выехал на перекрёсток на запрещающий сигнал светофора.
    var leftToTheIntersectionProhibitionSignal: Boolean = false,
    // 10 выехал на полосу встречного движения
    var droveIntoTheOncomingLane: Boolean = false,
    // 11 нарушил правила обгона
    var violatedTheRulesOfOvertaking: Boolean = false,
    // 12 Начинал движение после остановки, стоянки
    var startedMovingAfterStoppingOrParking: Boolean = false,
    // 13 Не выполнил требование знака приоритета
    var didNotComplyWithPriorityMarkRequirement: Boolean = false,
    // 14 Выезжал со второстепенной дороги, прилегающей территории
    var DepartedFromSecondaryRoadAdjacentToTheTerritory: Boolean = false,
    // 15 Двигался по прилегающей территории при наличии препятствия справа
    var movedAroundTheTerritoryInThePresenceOfAnObstacleToTheRight: Boolean = false,
    // 16 Двигался по перекрёстку с круговым движением
    var movedAroundTheRoundabout: Boolean = false,
    // 17 Совершил наезд на стоящее ТС
    var collidedWithaStandingVehicle: Boolean = false,
    // 18 Остановился, вынужденно остановился, стоял
    var stoppedOrForcedlyStoppedOrStood: Boolean = false,
    // 19 Иное нарушение, не указанное в пункте 1-18
    var otherViolationNotSpecifiedInParagraph1to18: Boolean = false
)