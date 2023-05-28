package com.example.myapplication.ui.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentAccountBinding
import de.hdodenhof.circleimageview.CircleImageView

class AccountFragment : Fragment() {

    private var _binding: FragmentAccountBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val accountViewModel =
//            ViewModelProvider(this).get(AccountViewModel::class.java)

        _binding = FragmentAccountBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textNotifications
//        accountViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        val circleImageView: CircleImageView = binding.circleImageView
        circleImageView.borderWidth = 2
        circleImageView.borderColor = activity?.let { ContextCompat.getColor(it, R.color.black) }!!
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}