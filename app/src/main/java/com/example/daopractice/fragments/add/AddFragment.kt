package com.example.daopractice.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.daopractice.R
import com.example.daopractice.data.User
import com.example.daopractice.data.UserViewModel


class AddFragment : Fragment() {

    private lateinit var mUserViweModel: UserViewModel
    lateinit var btn_add:Button
    lateinit var  addFirstName: EditText
    lateinit var  addLastName: EditText
    lateinit var editTextNumber: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_add, container, false)

        mUserViweModel= ViewModelProvider(this).get(UserViewModel::class.java)
        btn_add= view.findViewById(R.id.add_btn)
        addFirstName= view.findViewById(R.id.addFirstName_et)
        addLastName= view.findViewById(R.id.addLastName_et)
        editTextNumber= view.findViewById(R.id.editTextNumber)

        btn_add.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase(){
        val firstName= addFirstName.text.toString()
        val lastName= addLastName.text.toString()
        val age= editTextNumber.text

        if(inputCheck(firstName,lastName, age)){
            val user= User(0,firstName,lastName, Integer.parseInt(age.toString()))
            mUserViweModel.addUser(user)
            Toast.makeText(requireContext(), "Successfully added", Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT).show()

        }


    }
    private fun inputCheck(firstName:String, lastName:String, age:Editable): Boolean{
        return !(TextUtils.isEmpty(firstName)&& TextUtils.isEmpty(lastName)&& TextUtils.isEmpty(age))
    }


}