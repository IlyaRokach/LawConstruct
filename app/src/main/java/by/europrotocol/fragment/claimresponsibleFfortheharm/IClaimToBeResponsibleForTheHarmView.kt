package by.europrotocol.fragment.claimresponsibleFfortheharm

import by.europrotocol.fragment.base.IView
import by.europrotocol.fragment.base.TypeDriver

interface IClaimToBeResponsibleForTheHarmView: IView {

    fun getTypeDriver(): TypeDriver

    fun approveNext(isApprove: Boolean)
}