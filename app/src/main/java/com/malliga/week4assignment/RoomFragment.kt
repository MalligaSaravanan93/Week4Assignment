package com.malliga.week4assignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.malliga.week4assignment.adapter.RoomAdapter
import com.malliga.week4assignment.databinding.FragmentRoomBinding
import com.malliga.week4assignment.model.RoomsItem
import com.malliga.week4assignment.viewmodel.RoomViewModel
import java.util.prefs.Preferences

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RoomFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RoomFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentRoomBinding

//    private val viewModel: RoomViewModel by lazy {
//        ViewModelProvider(this)[RoomViewModel::class.java]
//    }

    private val viewModel: RoomViewModel by activityViewModels()

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
        binding = FragmentRoomBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment


        binding.roomList.layoutManager = GridLayoutManager(requireContext(),2)
        viewModel.roomdata.observe(viewLifecycleOwner,{roomsitem->
            binding.roomList.adapter = RoomAdapter(roomsitem)

        })

        viewModel.getRoomData()
       // viewModel.getPeopleData()
        return binding.root

        //binding.roomList.setLayoutManager(GridLayoutManager(this, 2))
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RoomFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RoomFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}