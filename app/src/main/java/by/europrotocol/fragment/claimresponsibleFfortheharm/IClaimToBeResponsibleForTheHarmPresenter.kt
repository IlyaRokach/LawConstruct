package by.europrotocol.fragment.claimresponsibleFfortheharm

import by.europrotocol.fragment.base.IPresenter

interface IClaimToBeResponsibleForTheHarmPresenter: IPresenter {

    fun onChangeNotes(notes: String)
    fun onCheckedIm(checked: Boolean)

    fun onNextRequest()
}