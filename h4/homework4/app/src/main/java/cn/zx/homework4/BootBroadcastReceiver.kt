package cn.zx.homework4

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class BootBroadcastReceiver : BroadcastReceiver() {
    val TAG = "@@BootBroadcastReceiver"
    override fun onReceive(context: Context, intent: Intent?) {
        Log.i(TAG,"BOOTED .... ")
        Toast.makeText(context,"启动",Toast.LENGTH_LONG).show()
    }
}