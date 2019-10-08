package by.europrotocol.fragment.physicaluser

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import by.europrotocol.R
import by.europrotocol.activity.registration.INextCallback

class PrivateInfoDriverFragment : Fragment() {

    private var nextCallback: INextCallback? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_private_driver_info_user, container, false)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is INextCallback) {
            nextCallback = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        nextCallback = null
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            PrivateInfoDriverFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
