package qq.a792297773.com.demo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2017/6/11.
 */

public class StartService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("service","开启广播");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("service","广播运行");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("service","广播关闭");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
