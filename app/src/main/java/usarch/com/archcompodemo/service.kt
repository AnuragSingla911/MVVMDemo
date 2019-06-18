package usarch.com.archcompodemo

import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.PixelFormat
import android.os.Handler
import android.os.IBinder
import android.util.Log
import android.view.Gravity
import android.view.WindowManager
import android.widget.TextView
import java.util.*
import kotlin.math.log

class service : Service() {

    var x : Int = 0;

    lateinit var mView : TextView;
    lateinit var wm :WindowManager

    override fun onBind(p0: Intent?): IBinder? {


        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate() {
        super.onCreate()
        mView = TextView(this);
        mView.setOnClickListener { wm.removeView(mView) }
        wm = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        mView.setText("over the other apps")
        val params = WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,
                //              WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                //                      | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                PixelFormat.TRANSLUCENT)
        params.gravity = Gravity.RIGHT or Gravity.TOP
        params.title = "Load Average"
        wm.addView(mView, params)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId);
        Log.d("anurag"," on start command")
        startTimer();

        return START_STICKY
    }

    lateinit var timerTask: TimerTask
    lateinit var timer : Timer
    var counter : Int = 0;

    fun startTimer() {
        //set a new Timer
        timer = Timer()

        //initialize the TimerTask's job
        initializeTimerTask()

        //schedule the timer, to wake up every 1 second
        timer.schedule(timerTask, 1000, 1000) //
    }

    fun initializeTimerTask() {
        timerTask = object : TimerTask() {
            override fun run() {
                Log.i("in timer", "in timer ++++  " + counter++)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("anurag"," service :: ondestroy");
        wm.removeView(mView);
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.d("anurag"," service :: unbind");
        return super.onUnbind(intent)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        Log.d("anurag"," service :: onlowmemory");

    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        Log.d("anurag"," service :: ontrimmemory");

    }

    override fun onTaskRemoved(rootIntent: Intent?) {
        super.onTaskRemoved(rootIntent)
        Log.d("anurag"," service :: ontaskremoved");
    }
}