package by.europrotocol.data.model.drawing

import by.europrotocol.data.model.PlaceOfImpact

class CoordinatesProvider(
    type: Int,
    isPolicy: Boolean = false,
    isVoluntaryInsurance: Boolean = true,
    hit: PlaceOfImpact = PlaceOfImpact.FRONT_BUMPER
) {
    //common information
    val date = Point(29f, 152f)
    val time = Point(143f, 151f)
    val placeCountry = Point(262f, 150f)
    val place = Point(347f, 150f)
    val anotherVehicles = Cross(Point(63f, 205f))
    val anotherObjects = Cross(Point(187f, 205f))
    val injuredPersons = Cross(Point(639f, 139f))
    val witnesses = Point(272f, 205f)
    val scheme = Point(167f, 810f)

    // policy holder information
    val holderName = if (type == 1) Point(106f, 299f) else Point(614f, 299f)
    val holderSurname = if (type == 1) Point(74f, 287f) else Point(578f, 287f)
    val holderPatronymic = if (type == 1) Point(153f, 310f) else Point(657f, 310f)
    val holderCompany = if (type == 1) Point(30f, 333f) else Point(535f, 333f)
    val holderAddress = if (type == 1) Point(31f, 369f) else Point(535f, 369f)
    val holderCountry = if (type == 1) Point(164f, 381f) else Point(670f, 381f)
    val holderPostalCode = if (type == 1) Point(64f, 382f) else Point(670f, 381f)
    val holderPhoneOrEmail = if (type == 1) Point(103f, 393f) else Point(608f, 393f)

    // insurer information
    val insurerCompany = if (type == 1) Point(104f, 527f) else Point(610f, 527f)
    val voluntary = if (type == 1) {
        if (isVoluntaryInsurance) Cross(Point(224f, 613f)) else Cross(Point(181f, 613f))
    } else {
        if (isVoluntaryInsurance) Cross(Point(731f, 613f)) else Cross(Point(687f, 613f))
    }
    val insurerCertificate = if (type == 1) {
        if (isPolicy) Line(Point(173f, 539f), Point(222f, 539f))
        else Line(Point(141f, 539f), Point(166f, 539f))
    } else {
        if (isPolicy) Line(Point(679f, 539f), Point(729f, 539f))
        else Line(Point(646f, 539f), Point(671f, 539f))
    }
    val insurerSeries = if (type == 1) Point(84f, 561f) else Point(590f, 561f)
    val insurerNumber = if (type == 1) Point(145f, 561f) else Point(651f, 561f)
    val insurerCountry = if (type == 1) Point(63f, 584f) else Point(568f, 584f)
    val insurerStartDate = if (type == 1) Point(103f, 572f) else Point(608f, 572f)
    val insurerFinishDate = if (type == 1) Point(195f, 572f) else Point(701f, 572f)

    //driver info
    val driverName = if (type == 1) Point(111f, 665f) else Point(616f, 665f)
    val driverSurname = if (type == 1) Point(75f, 655f) else Point(580f, 655f)
    val driverPatronymic = if (type == 1) Point(158f, 676f) else Point(662f, 676f)
    val driverAddress = if (type == 1) Point(26f, 709f) else Point(531f, 709f)
    val driverBirthDay = if (type == 1) Point(100f, 688f) else Point(604f, 688f)
    val driverCountry = if (type == 1) Point(178f, 719f) else Point(614f, 719f)
    val driverPhoneOrEmail = if (type == 1) Point(100f, 730f) else Point(606f, 730f)
    val driverSeries = if (type == 1) Point(85f, 752f) else Point(590f, 752f)
    val driverNumber = if (type == 1) Point(141f, 752f) else Point(647f, 752f)
    val driverCategory = if (type == 1) Point(121f, 763f) else Point(626f, 763f)
    val driverFinishDate = if (type == 1) Point(178f, 773f) else Point(683f, 773f)

    //auto info
    val model = if (type == 1) Point(26f, 435f) else Point(532f, 435f)
    val registartionNumber = if (type == 1) Point(26f, 459f) else Point(532f, 459f)
    val registrationCountry = if (type == 1) Point(26f, 482f) else Point(532f, 482f)
    val trailerNumber = if (type == 1) Point(156f, 459f) else Point(663f, 459f)
    val trailerRegistrationCountry = if (type == 1) Point(157f, 482f) else Point(663f, 482f)

    //accident circumstances
    val safeDistance  = if (type == 1) Cross(Point(290f, 272f)) else Cross(Point(507f, 272f))
    val lateralInterval = if (type == 1) Cross(Point(290f, 290f)) else Cross(Point(507f, 290f))
    val anotherLane = if (type == 1) Cross(Point(290f, 317f)) else Cross(Point(507f, 317f))
    val turnRight = if (type == 1) Cross(Point(290f, 335f)) else Cross(Point(507f, 335f))
    val turnLeft = if (type == 1) Cross(Point(290f, 353f)) else Cross(Point(507f, 353f))
    val turnAround = if (type == 1) Cross(Point(290f, 371f)) else Cross(Point(507f, 371f))
    val backUp = if (type == 1) Cross(Point(290f, 389f)) else Cross(Point(507f, 389f))
    val droveOff = if (type == 1) Cross(Point(290f, 406f)) else Cross(Point(507f, 406f))
    val redCrossroad = if (type == 1) Cross(Point(290f, 424f)) else Cross(Point(507f, 424f))
    val oncomingLane = if (type == 1) Cross(Point(290f, 453f)) else Cross(Point(507f, 453f))
    val overtaking = if (type == 1) Cross(Point(290f, 481f)) else Cross(Point(507f, 481f))
    val moveAfterStop = if (type == 1) Cross(Point(290f, 499f)) else Cross(Point(507f, 499f))
    val priorityMark = if (type == 1) Cross(Point(290f, 528f)) else Cross(Point(507f, 528f))
    val secondaryRoad = if (type == 1) Cross(Point(290f, 556f)) else Cross(Point(507f, 556f))
    val aroundTerritory = if (type == 1) Cross(Point(290f, 584f)) else Cross(Point(507f, 584f))
    val roundRoad = if (type == 1) Cross(Point(290f, 624f)) else Cross(Point(507f, 624f))
    val standVehicle = if (type == 1) Cross(Point(290f, 651f)) else Cross(Point(507f, 651f))
    val forceStop = if (type == 1) Cross(Point(290f, 671f)) else Cross(Point(507f, 671f))
    val anotherViolation = if (type == 1) Cross(Point(290f, 698f)) else Cross(Point(507f, 698f))
    val count = if (type == 1) Point(295f, 744f) else Point(512f, 744f)

    // hit place
    val hitPlace = if (type == 1) {
       when(hit) {
           PlaceOfImpact.FRONT_BUMPER -> Cross(Point(84f, 839f))
           PlaceOfImpact.BACK_BUMPER -> Cross(Point(84f, 892f))
           PlaceOfImpact.FRONT_LEFT_WING -> Cross(Point(74f, 847f))
           PlaceOfImpact.FRONT_RIGHT_WING -> Cross(Point(93f,847f))
           PlaceOfImpact.BACK_LEFT_WING -> Cross(Point(75f, 885f))
           PlaceOfImpact.BACK_RIGHT_WING -> Cross(Point(93f, 885f))
           PlaceOfImpact.LEFT_DOOR -> Cross(Point(74f, 865f))
           PlaceOfImpact.RIGHT_DOOT -> Cross(Point(94f, 865f))
       }
    } else {
        when(hit) {
            PlaceOfImpact.FRONT_BUMPER -> Cross(Point(713f,839f))
            PlaceOfImpact.BACK_BUMPER -> Cross(Point(713f,892f))
            PlaceOfImpact.FRONT_LEFT_WING -> Cross(Point(704f,847f))
            PlaceOfImpact.FRONT_RIGHT_WING -> Cross(Point(722f, 847f))
            PlaceOfImpact.BACK_LEFT_WING -> Cross(Point(704f, 885f))
            PlaceOfImpact.BACK_RIGHT_WING -> Cross(Point(722f, 885f))
            PlaceOfImpact.LEFT_DOOR -> Cross(Point(704f, 865f))
            PlaceOfImpact.RIGHT_DOOT -> Cross(Point(722f, 865f))
        }
    }

    val signature = if(type == 1) Point(320f, 1045f) else Point(435f, 1045f)
    val responsibleSignature = if(type == 1) Point(182f, 1100f) else Point(694f,1100f)
}