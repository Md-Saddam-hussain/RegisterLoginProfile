package com.amier.modernloginregister.fragment

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.amier.modernloginregister.LoginActivity
import com.amier.modernloginregister.R
import com.google.firebase.auth.FirebaseAuth

class ExamFragment : Fragment() {

    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_exam, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()
    }

    //***** OPTION MENU  *****//

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu?.add(0,12,0,"Logout")
        super.onCreateOptionsMenu(menu, inflater)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when(id){
            12->{
                auth.signOut()
                val i = Intent(activity, LoginActivity::class.java)
                startActivity(i)
                activity?.finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}