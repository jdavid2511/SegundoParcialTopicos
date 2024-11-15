package com.segundoparcial.view

import android.app.Activity
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.helpers.DataBaseHelper
import com.github.dhaval2404.imagepicker.ImagePicker
import com.segundoparcial.R

class RegisterFragment : Fragment() {


    private lateinit var etName : EditText
    private lateinit var btnLoad : ImageButton
    private lateinit var btnSave : Button
    private lateinit var rvNameList: RecyclerView
    private lateinit var dataBaseHelper: DataBaseHelper
    private var imageUri : Uri?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        etName = view.findViewById(R.id.etName)
        btnLoad = view.findViewById(R.id.btnLoad)
        btnSave = view.findViewById(R.id.btnSave)

        btnLoad.setOnClickListener {
            selecctionImg()
        }

        btnSave.setOnClickListener {

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

    private fun saveUser (view: View, name: String, description: String, tipe: String, img: String) {
        dataBaseHelper = DataBaseHelper(view.context)

        dataBaseHelper.insertName(name, description, tipe, img)
    }

}