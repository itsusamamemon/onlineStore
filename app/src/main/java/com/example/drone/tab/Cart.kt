package com.example.drone.tab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.drone.R
import com.ishaquehassan.recyclerviewgeneraladapter.RecyclerViewGeneralAdapter

import kotlinx.android.synthetic.main.products.*

class Cart : BaseTabFargment(){

    override fun getIcon(): Int  = R.mipmap.cart
    override fun getSelectedIcon(): Int  = R.drawable.cart

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.cart,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        data class prod_data(val Images:String,val title:String,val price:String,val del:Int)


        product_rec.adapter = RecyclerViewGeneralAdapter(
            arrayListOf(
                prod_data("https://images.unsplash.com/photo-1527441385177-3dad16222699?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1041&q=80","Lorem Ipsum is simply dummy text ..","Rs 50,000",R.mipmap.trash),
                prod_data("https://images.unsplash.com/photo-1514505213055-b456c4420f67?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1534&q=80","Lorem Ipsum is simply dummy text ..","Rs 65,000",R.mipmap.trash),
                prod_data("https://images.unsplash.com/photo-1534798270584-a695c8a977e9?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1052&q=80","Lorem Ipsum is simply dummy text ..","Rs 66,000",R.mipmap.trash),
                prod_data("https://images.unsplash.com/photo-1499808624579-3471e371ce50?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80","Lorem Ipsum is simply dummy text ..","Rs 1,0000",R.mipmap.trash),
                prod_data("https://images.unsplash.com/photo-1485849708108-3bb5576aca9f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1149&q=80","Lorem Ipsum is simply dummy text ..","Rs 95,000",R.mipmap.trash),
                prod_data("https://images.unsplash.com/photo-1480434945668-94be06bbd507?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1052&q=80","Lorem Ipsum is simply dummy text ..","Rs 30,000",R.mipmap.trash),
                prod_data("https://images.unsplash.com/photo-1491738785019-dd6647a54f24?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=700&q=80","Lorem Ipsum is simply dummy text ..","Rs 80,000",R.mipmap.trash)

            ),
            R.layout.single_cart
        ) { itemData, viewHolder->
            val itemView = viewHolder.itemView
            val img = itemView.findViewById<ImageView>(R.id.image)

            Glide.with(this).load(itemData.Images).into(img);
            itemView.findViewById<TextView>(R.id.title).text = itemData.title
            itemView.findViewById<TextView>(R.id.price).text = itemData.price
            itemView.findViewById<ImageView>(R.id.del_image).setImageResource(itemData.del)
        }
        product_rec.layoutManager = LinearLayoutManager(context)


    }


}