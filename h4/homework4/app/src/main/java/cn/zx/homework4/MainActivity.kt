package cn.zx.homework4
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        val ACTION_CUSTOM = "cn.zx.homework4.ACTION_CUSTOM"
    }

    val TAG = "@@MAIN"

    var mReceiver: BroadcastReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        btn_toggle.setOnClickListener {
            it as TextView
            val running = it.tag as Boolean?
            if (running == true) {
                stopBroadcastReceive(it)
            } else {
                startBroadcastReceive(it)
            }
        }
        btn_send.setOnClickListener {
            sendCustomBroadcast()
        }
        registerReceiver(object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                Log.d(TAG,"registerReceiver THREAD = " + Thread.currentThread().name)
            }

        }, IntentFilter(ACTION_CUSTOM))
    }

    private fun sendCustomBroadcast() {
        Log.d(TAG,"sendCustomBroadcast THREAD = " + Thread.currentThread().name)
        Thread{
            Log.d(TAG, "sendCustomBroadcast ...  THREAD = " +  Thread.currentThread().name)
            val cast = Intent(ACTION_CUSTOM)
            this.sendBroadcast(cast)
        }.start()
    }

    private fun startBroadcastReceive(it: TextView) {
        Log.d(TAG, "START ... ")
        val filter = IntentFilter("android.intent.action.TIME_TICK")
        val receiver = getReceiver()
        this.registerReceiver(receiver, filter)

        it.text = "停止接收"
        it.tag = true
    }

    private fun getReceiver(): BroadcastReceiver {
        return mReceiver ?: object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                Log.d(TAG, "time ticked .")
            }
        }.apply {
            mReceiver = this
        }
    }

    private fun stopBroadcastReceive(it: TextView) {
        Log.d(TAG, "STOP ... ")
        val receiver = getReceiver()
        unregisterReceiver(receiver)

        it.text = this.resources.getText(R.string.start)
        it.tag = false
    }
}