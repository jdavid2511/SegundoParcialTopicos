package com.segundoparcial.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.segundoparcial.R

/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    /* fun actualizarList () {
        val data = dataBaseHelper.selectAllName()
        nameList.clear()
        nameList.addAll(data)
        adapter.notifyDataSetChanged()
        rvNameList.scrollToPosition(nameList.count() - 1)
    }

    fun initUi(){
        actualizarList()
    }*/

}