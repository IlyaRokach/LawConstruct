package by.europrotocol.fragment.claimresponsibleFfortheharm

import by.europrotocol.data.model.NotesDriver
import by.europrotocol.fragment.base.BaseRegistrationPresenter
import by.europrotocol.fragment.base.TypeDriver

class ClaimToBeResponsibleForTheHarmPresenter (
    view: IClaimToBeResponsibleForTheHarmView
): BaseRegistrationPresenter<IClaimToBeResponsibleForTheHarmView>(view), IClaimToBeResponsibleForTheHarmPresenter {

    private val claimToBeResponsibleForTheHarm: ClaimToBeResponsibleForTheHarm = ClaimToBeResponsibleForTheHarm()

    override fun onChangeNotes(notes: String) {
        claimToBeResponsibleForTheHarm.notes = notes
    }

    override fun onCheckedIm(checked: Boolean) {
        claimToBeResponsibleForTheHarm.iClaimToBeResponsibleForTheHarm = checked
    }

    override fun onNextRequest() {
        val notes = NotesDriver(claimToBeResponsibleForTheHarm.notes,
            claimToBeResponsibleForTheHarm.iClaimToBeResponsibleForTheHarm)


        when (getView()!!.getTypeDriver().type){
            TypeDriver.ONE -> getView()!!.getApplication().getEuroProtocolRepository().saveDriverOne(
                notes
            )
            TypeDriver.TWO -> getView()!!.getApplication().getEuroProtocolRepository().saveDriverTwo(
                notes
            )
        }

        getView()!!.approveNext(true)
    }
}