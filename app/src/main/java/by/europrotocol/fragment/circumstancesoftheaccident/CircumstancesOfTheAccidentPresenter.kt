package by.europrotocol.fragment.circumstancesoftheaccident

import by.europrotocol.fragment.base.BaseRegistrationPresenter

class CircumstancesOfTheAccidentPresenter(
    questionOfTheAccidentView: ICircumstancesOfTheAccidentView
) : BaseRegistrationPresenter<ICircumstancesOfTheAccidentView>(questionOfTheAccidentView),
    ICircumstancesOfTheAccidentPresenter {

    private val model: CircumstancesOfTheAccidentModel =
        CircumstancesOfTheAccidentModel()

    override fun onChangeItem1(isChecked: Boolean) {
        model.didNotMaintainSafeDistance = isChecked
    }

    override fun onChangeItem2(isChecked: Boolean) {
        model.didNotComplyWithRequiredLateralIntervar = isChecked
    }

    override fun onChangeItem3(isChecked: Boolean) {
        model.rebuiltAnotherLane = isChecked
    }

    override fun onChangeItem4(isChecked: Boolean) {
        model.turnedRight = isChecked

    }

    override fun onChangeItem5(isChecked: Boolean) {
        model.turnedLeft = isChecked

    }

    override fun onChangeItem6(isChecked: Boolean) {
        model.turnedAround = isChecked

    }

    override fun onChangeItem7(isChecked: Boolean) {
        model.backUp = isChecked

    }

    override fun onChangeItem8(isChecked: Boolean) {
        model.droveOffRoadway = isChecked

    }

    override fun onChangeItem9(isChecked: Boolean) {
        model.leftToTheIntersectionProhibitionSignal = isChecked
    }

    override fun onChangeItem10(isChecked: Boolean) {
        model.droveIntoTheOncomingLane = isChecked
    }

    override fun onChangeItem11(isChecked: Boolean) {
        model.violatedTheRulesOfOvertaking = isChecked
    }

    override fun onChangeItem12(isChecked: Boolean) {
        model.startedMovingAfterStoppingOrParking = isChecked
    }

    override fun onChangeItem13(isChecked: Boolean) {
        model.didNotComplyWithPriorityMarkRequirement = isChecked
    }

    override fun onChangeItem14(isChecked: Boolean) {
        model.DepartedFromSecondaryRoadAdjacentToTheTerritory = isChecked
    }

    override fun onChangeItem15(isChecked: Boolean) {
        model.movedAroundTheTerritoryInThePresenceOfAnObstacleToTheRight = isChecked
    }

    override fun onChangeItem16(isChecked: Boolean) {
        model.movedAroundTheRoundabout = isChecked
    }

    override fun onChangeItem17(isChecked: Boolean) {
        model.collidedWithaStandingVehicle = isChecked
    }

    override fun onChangeItem18(isChecked: Boolean) {
        model.stoppedOrForcedlyStoppedOrStood = isChecked
    }

    override fun onChangeItem19(isChecked: Boolean) {
        model.otherViolationNotSpecifiedInParagraph1to18 = isChecked
    }

    override fun onNextRequest() {
        val result = model.didNotMaintainSafeDistance ||
        model.didNotComplyWithRequiredLateralIntervar ||
        model.rebuiltAnotherLane ||
        model.turnedRight ||
        model.turnedLeft ||
        model.turnedAround ||
        model.backUp ||
        model.droveOffRoadway ||
        model.leftToTheIntersectionProhibitionSignal ||
        model.droveIntoTheOncomingLane ||
        model.violatedTheRulesOfOvertaking ||
        model.startedMovingAfterStoppingOrParking ||
        model.didNotComplyWithPriorityMarkRequirement ||
        model.DepartedFromSecondaryRoadAdjacentToTheTerritory ||
        model.movedAroundTheTerritoryInThePresenceOfAnObstacleToTheRight ||
        model.movedAroundTheRoundabout ||
        model.collidedWithaStandingVehicle ||
        model.stoppedOrForcedlyStoppedOrStood ||
        model.otherViolationNotSpecifiedInParagraph1to18

        getView()!!.approveNext(result)
    }
}