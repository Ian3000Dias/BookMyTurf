package com.example.registrationpage

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.HomePage
import com.example.splashscreen.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var cnfpassword: EditText
    private lateinit var fAuth: FirebaseAuth
    private val button = view?.findViewById<Button>(R.id.btn_register_reg)

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
        var view = inflater.inflate(R.layout.fragment_register, container, false)

        email = view.findViewById(R.id.email_reg)
        password = view.findViewById(R.id.password_reg)
        cnfpassword = view.findViewById(R.id.confirm_password)
        fAuth = Firebase.auth

        view.findViewById<Button>(R.id.login_button_reg).setOnClickListener {
            val navRegister = activity as FragmentNavigation
            navRegister.navigateFrag(LoginFragment(),false)
        }
        view.findViewById<Button>(R.id.btn_register_reg).setOnClickListener {
            validateEmptyForm()
        }
        return view
    }

    private fun firebaseSignup(){
        button?.isEnabled = false
        button?.alpha = 0.5f
        fAuth.createUserWithEmailAndPassword(email.text.toString(),
            password.text.toString()).addOnCompleteListener{
                task ->
            if (task.isSuccessful){
                Toast.makeText(context, "Register Successful",Toast.LENGTH_SHORT).show()
                moveToNewActivity()
            }else{
                button?.isEnabled=true
                button?.alpha=1.0f
                Toast.makeText(context,task.exception?.message,Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateEmptyForm(){

        when{
            TextUtils.isEmpty(email.text.toString().trim())->{
                email.setError("Please Enter email")
            }
            TextUtils.isEmpty(password.text.toString().trim())->{
                password.setError("Please Enter password")
            }
            TextUtils.isEmpty(cnfpassword.text.toString().trim())->{
                cnfpassword.setError("Please confirm password")
            }
            email.text.toString().isNotEmpty() &&
                    password.text.toString().isNotEmpty() &&
                    cnfpassword.text.toString().isNotEmpty()->
            {
                if (email.text.toString().matches(Regex("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"))) {
                    if(password.text.toString().length>=5){

                        if(password.text.toString() == cnfpassword.text.toString()){

                            firebaseSignup()
//                            Toast.makeText(context, "Register Successful",Toast.LENGTH_SHORT).show()
                        }
                        else{
                            cnfpassword.setError("Password does not match.")
                        }
                    }
                    else{
                        password.setError("Please enter password of at least 5 characters")
                    }
                }else{
                    email.setError("Please Enter Valid Email Id")
                }
            }
        }
    }
    private fun moveToNewActivity(){
        val intent = Intent(context, HomePage::class.java)
        startActivity(intent)
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegisterFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegisterFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}