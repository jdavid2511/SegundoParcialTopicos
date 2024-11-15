package com.segundoparcial

import android.app.Activity
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.NombreAdapter
import com.example.myapplication.helpers.DataBaseHelper
import com.github.dhaval2404.imagepicker.ImagePicker

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    private lateinit var etName : EditText
    private lateinit var btnLoad : ImageButton
    private lateinit var btnSave : Button
    private lateinit var rvNameList: RecyclerView
    private var imageUri : Uri?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        etName = view.findViewById(R.id.etName)
        btnLoad = view.findViewById(R.id.btnLoad)

        btnLoad.setOnClickListener {
            selecctionImg()
        }
        return view
    }


    private fun selecctionImg(){
        ImagePicker.with(this)
            .crop()
            .compress(1024)
            .maxResultSize(1080, 1080)
            .createIntent { intent ->
                resultImg.launch(intent)
            }
    }

    private val resultImg = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            resultado ->
        if(resultado.resultCode == Activity.RESULT_OK) {
            val data = resultado.data
            imageUri = data!!.data
            btnLoad.setImageURI(imageUri)
        } else {

        }
    }

}