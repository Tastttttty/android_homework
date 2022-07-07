package cn.swu.cs.lessonfive

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.zx.homework1.Human
import cn.zx.homework1.HumanAdapter

class ListActivity : AppCompatActivity() {

    val human = arrayListOf<Human>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        initData()
        val recycler = findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = HumanAdapter(human)

    }

    private fun initData() {
        for( i in 0..10) {
            human.add(Human().apply {
                name = "王也"
                description =
                    "平平无奇一个小道士"
                avatar = R.mipmap.tou1
            })
            human.add(Human().apply {
                name = "折木奉太郎"
                description = "冰菓"
                avatar = R.mipmap.tou2
            })
            human.add(Human().apply {
                name = "我也不认识"
                description = "震惊.jpg"
                avatar = R.mipmap.tou3
            })
        }

    }
}