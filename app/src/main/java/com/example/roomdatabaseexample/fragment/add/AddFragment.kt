package com.example.roomdatabaseexample.fragment.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.roomdatabaseexample.R
import com.example.roomdatabaseexample.model.User
import com.example.roomdatabaseexample.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {

private lateinit  var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_add, container, false)
        userViewModel=ViewModelProvider(this).get(UserViewModel::class.java)
        view.add_btn.setOnClickListener {
                  insertDataToDatabase()
        }
        return view
    }

    private fun insertDataToDatabase() {
        val firstName=firstName.text.toString()
        val lastName=secondName.text.toString()
        val age=age.text
        if(inputCheck(firstName,lastName,age)){
            val user= User(0,firstName,lastName,Integer.parseInt(age.toString()))
            userViewModel.addUser(user)
            Toast.makeText(requireContext(),"Successfully added",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }
        else
            Toast.makeText(requireContext(),"Please fill out all the fields",Toast.LENGTH_LONG).show()

    }

    private fun inputCheck(firstName: String, lastName: String, age: Editable): Boolean {
         return !(TextUtils.isEmpty(firstName)&&TextUtils.isEmpty(lastName)&&age.isEmpty())
    }


}