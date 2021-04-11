package com.ilhomjon.navigationfragment

import Models.User
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_firs.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
lateinit var root:View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_firs, container, false)

        root.txt_third_fragment.setOnClickListener {

            val email = root.edt_email.text.toString()
            val password = root.edt_password.text.toString()

            val user = User(email, password)

            val bundle = bundleOf("user" to user)

//            val bundle = Bundle()
//
//            bundle.putSerializable("user", user)


            //animation
            val navOption = NavOptions.Builder()
            navOption.setEnterAnim(R.anim.exit_anim)
            navOption.setExitAnim(R.anim.pop_enter_anim)
            navOption.setPopEnterAnim(R.anim.enter_anim)
            navOption.setPopExitAnim(R.anim.pop_exit_anim)


            findNavController().navigate(R.id.thirdFragment, bundle, navOption.build())
        }

        return root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}