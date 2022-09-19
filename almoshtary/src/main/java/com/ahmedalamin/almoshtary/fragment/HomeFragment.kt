package com.ahmedalamin.almoshtary.fragment


import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ahmedalamin.almoshtary.R
import com.ahmedalamin.almoshtary.adapters.HomeFragmentAdapter
import com.ahmedalamin.almoshtary.model.OrderData
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        recycler_view.layoutManager = LinearLayoutManager(context)

        var data = mutableListOf<OrderData>()

        var data1 = OrderData("qq","ahmed")
//        data[0].titleOfOrder = "this is the title"
//        data[0].idOfUser = "id of user"
//        data[0].locationOfUser = "this is the location of user"
//        data[0].nameOfDelivery = "this is the name of delivery"
//        data[0].nameOfUser = "this is the name of the user"
//        data[0].statusImageOfOrder = "image of stutus"
//        data[0].statusTextOfOrder = "this is the text of order"

        data.add(data1)

        var adapter = HomeFragmentAdapter()
        adapter.submitList(data)
        recycler_view.adapter = adapter









    }



}