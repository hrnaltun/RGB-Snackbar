package com.harunaltun.RGBSnackbar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_blank3.*


// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SnackbarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SnackbarFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank3, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment3.
         */

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SnackbarFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val time=resources.getStringArray(R.array.time)
        if (spinner!=null){
            val adapter=ArrayAdapter(requireContext(),android.R.layout.simple_dropdown_item_1line,time)
            spinner.adapter=adapter
            spinner.onItemSelectedListener=object :
                AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    when(p2){
                        0->{

                        }
                        1->{

                                Snackbar.make(view,"${mesaj.text}",Snackbar.LENGTH_LONG).setDuration(2000).setAction("${action.text}"){
                                    Toast.makeText(requireContext(),"${action.text}",Toast.LENGTH_LONG).show()
                                }.show()



                        }
                        2->{

                                Snackbar.make(view,"${mesaj.text}",Snackbar.LENGTH_LONG).setDuration(2500).setAction("${action.text}"){
                                    Toast.makeText(requireContext(),"${action.text}",Toast.LENGTH_LONG).show()
                                }.show()

                        }
                        3->{

                                Snackbar.make(view,"${mesaj.text}",Snackbar.LENGTH_LONG).setDuration(3000).setAction("${action.text}"){
                                    Toast.makeText(requireContext(),"${action.text}",Toast.LENGTH_LONG).show()
                                }.show()

                        }
                        4->{

                                Snackbar.make(view,"${mesaj.text}",Snackbar.LENGTH_LONG).setDuration(3500).setAction("${action.text}"){
                                    Toast.makeText(requireContext(),"${action.text}",Toast.LENGTH_LONG).show()
                                }.show()

                        }
                        5->{

                                Snackbar.make(view,"${mesaj.text}",Snackbar.LENGTH_LONG).setDuration(4000).setAction("${action.text}"){
                                    Toast.makeText(requireContext(),"${action.text}",Toast.LENGTH_LONG).show()
                                }.show()

                        }
                    }
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }

            }
        }
        }
}