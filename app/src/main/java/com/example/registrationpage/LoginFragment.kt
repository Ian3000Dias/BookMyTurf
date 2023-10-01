package com.example.registrationpage

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var fAuth: FirebaseAuth
    private val button = view?.findViewById<Button>(R.id.login_button)
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
        var view = inflater.inflate(R.layout.fragment_login,container,false)

        email = view.findViewById(R.id.email)
        password = view.findViewById(R.id.password)
        fAuth = Firebase.auth

        view.findViewById<Button>(R.id.btn_register).setOnClickListener {
            var navRegister = activity as FragmentNavigation
            navRegister.navigateFrag(RegisterFragment(),false)
        }

        view.findViewById<Button>(R.id.login_button).setOnClickListener {
            validateForm()
        }


        view.findViewById<Button>(R.id.forgot_password).setOnClickListener {
//            val intent = Intent(context, ForgotPassword::class.java)
//            startActivity(intent)
            if ( email.text.toString().isEmpty()) {
                Toast.makeText(
                     context, "Please enter email address.", Toast.LENGTH_SHORT). show()
            }else(
                    FirebaseAuth.getInstance().sendPasswordResetEmail( email.text.toString())
                        .addOnCompleteListener{task ->
                            if(task.isSuccessful) {
                                Toast.makeText(
                                    context, "Email sent successfully to reset your passwordI", Toast.LENGTH_LONG
                                ).show()
                            }}
                    )
        }

        return view
    }

    private fun firebaseSignIn(){
        button?.isEnabled = false
        button?.alpha = 0.5f
        fAuth.signInWithEmailAndPassword(email.text.toString(),
            password.text.toString()).addOnCompleteListener{
                task->
            if (task.isSuccessful){
                Toast.makeText(context, "Login Successful",Toast.LENGTH_SHORT).show()
                moveToNewActivity()
            }else{
                button?.isEnabled = true
                button?.alpha = 1.0f
                Toast.makeText(context,task.exception?.message,Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun validateForm(){
        when{
            TextUtils.isEmpty(email.text.toString().trim())->{
                email.setError("Please Enter email")
            }
            TextUtils.isEmpty(password.text.toString().trim())->{
                password.setError("Please Enter password")
            }

            email.text.toString().isNotEmpty() &&
                    password.text.toString().isNotEmpty() ->
            {
                if (email.text.toString().matches(Regex("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"))) {

                    firebaseSignIn()


                }else{
                    email.setError("Please Enter Valid Email Id")
                }
            }
        }
    }
    private fun moveToNewActivity() {
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
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}