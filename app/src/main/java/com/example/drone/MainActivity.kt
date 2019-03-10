package com.example.drone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.core.graphics.toColor
import androidx.viewpager.widget.ViewPager
import com.example.drone.tab.*
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pagerTabs = arrayListOf<BaseTabFargment>(
            Profile(),
            Home(),
            Products(),
            Cart()

        )
        viewPager.adapter = PageViewAdapter(supportFragmentManager,pagerTabs)
        viewPager.setCurrentItem(1);
        tab.setupWithViewPager(viewPager)
        tab.setIcons(pagerTabs)
        for (i in 0 until tab.tabCount) {
            val tabitemLayout = LayoutInflater.from(this).inflate(R.layout.tab_icon,tab.getTabAt(i)?.view,false)
            val imageView = tabitemLayout.findViewById<ImageView>(R.id.image)
            imageView.setImageResource(pagerTabs[i].getIcon())
            tab.getTabAt(i)?.customView = imageView
        }
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                tab.setIcons(pagerTabs,position)
            }

        })
    }

    /*var TabLayout.Tab.customLayout:View
        set(value) {
            this.setCustomView(value)
        }
        get() =this.customLayout

*/

    fun TabLayout.setIcons(arrayList: ArrayList<BaseTabFargment>, selectedIndex:Int = 0){
        for ((tabIndex,tab) in arrayList.withIndex()){
            if (tabIndex == selectedIndex){
               // getTabAt(tabIndex)?.customLayout?.findViewById<ImageView>(R.id.image)?.setImageResource(tab.getSelectedIcon())
                getTabAt(tabIndex)?.setIcon(tab.getSelectedIcon())
            }else{
                getTabAt(tabIndex)?.setIcon(tab.getIcon())
            }
        }
    }
}
