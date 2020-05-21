package vn.mrlongg71.vnchat.src.ui

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.google.android.material.bottomnavigation.BottomNavigationView
import vn.mrlongg71.vnchat.R
import vn.mrlongg71.vnchat.src.module.diary.view.DiaryFragment
import vn.mrlongg71.vnchat.src.module.menu.view.ContactFragment
import vn.mrlongg71.vnchat.src.module.menu.view.MenuFragment
import vn.mrlongg71.vnchat.src.module.menu.view.MessageFragment
import java.util.*


class BottomNavigationActivity : AppCompatActivity() {
    private lateinit var prevMenuItem: MenuItem
    private lateinit var viewPager: ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)
        val window: Window = getWindow()


        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)


        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)


        window.statusBarColor = ContextCompat.getColor(applicationContext, R.color.color_dark)

        viewPager = findViewById(R.id.viewNavigation)
        var navigation: BottomNavigationView = findViewById(R.id.navigation)


        navigation.setOnNavigationItemSelectedListener(
            mOnNavigationItemSelectedListener
        )
        viewPager.setOffscreenPageLimit(3)

        viewPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                Log.d("LONgKUTE", "onPageSelected: $position")
//                prevMenuItem.setChecked(false)
                navigation.getMenu().getItem(position)
                    .setChecked(true)
                prevMenuItem =
                    navigation.getMenu().getItem(position)
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
        setupViewPager(viewPager)
    }


    private fun setupViewPager(viewPager: ViewPager) {
        val adapter =
            ViewPagerNavigationAdapter(supportFragmentManager)
        val messageFragment = MessageFragment()
        val contactFragment = ContactFragment()
        val diaryFragment = DiaryFragment()
        val menuFragment = MenuFragment()
        adapter.addFragment(messageFragment)
        adapter.addFragment(contactFragment)
        adapter.addFragment(diaryFragment)
        adapter.addFragment(menuFragment)
        viewPager.adapter = adapter
    }

    private val mOnNavigationItemSelectedListener =
        label@ BottomNavigationView.OnNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.navigation_explore -> {
                    viewPager.currentItem = 0
                }
                R.id.navigation_my_order -> {
                    viewPager.currentItem = 1

                }
                R.id.navigation_favourite -> {
                    Log.d("dsds", "sd")
                    viewPager.currentItem = 2

                }
                R.id.navigation_profile -> {
                    viewPager.currentItem = 3
                }
            }
            false
        }


}

class ViewPagerNavigationAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    private val mFragmentList: MutableList<Fragment> = ArrayList()


    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    fun addFragment(fragment: Fragment) {
        mFragmentList.add(fragment)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        return super.instantiateItem(container, position)
    }


}
