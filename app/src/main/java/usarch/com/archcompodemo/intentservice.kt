package usarch.com.archcompodemo

import android.content.Context
import android.content.Intent
import android.support.v4.app.JobIntentService
import android.util.Log


class intentservice : JobIntentService() {

        fun startServiceCommand(context: Context) {
            val intent = Intent(context, intentservice::class.java)
            enqueueWork(context, intentservice::class.java, 1001, intent)
        }

        fun enqueueWork(context: Context, work: Intent) {
            enqueueWork(context, intentservice::class.java, 1001, work)
        }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onCreate() {
        super.onCreate()
//        var mView = TextView(this);
//        mView.setText("over the other apps")
//        val params = WindowManager.LayoutParams(
//                WindowManager.LayoutParams.WRAP_CONTENT,
//                WindowManager.LayoutParams.WRAP_CONTENT,
//                WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY,
//                0,
//                //              WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
//                //                      | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
//                PixelFormat.TRANSLUCENT)
//        params.gravity = Gravity.RIGHT or Gravity.TOP
//        params.title = "Load Average"
//        val wm = getSystemService(Context.WINDOW_SERVICE) as WindowManager
//        wm.addView(mView, params)

    }


    override fun onHandleWork(p0: Intent) {
        var x  = 0;


            while (true) {
                Thread.sleep(1000);
                Log.d("anurag", " intent service :: " + x++);
            }

    }



}