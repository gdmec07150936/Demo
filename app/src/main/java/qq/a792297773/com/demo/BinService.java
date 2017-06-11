package qq.a792297773.com.demo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2017/6/11.
 */

public class BinService extends Service{
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("service","bin服务");
    }

    public class MBinService extends Binder{
        public MBinService getMBinService(){
            return this;
        }

        public void startService(){
            Log.d("binService","播放音乐");
        }
        public void stopService(){
            Log.d("binService","停止音乐");
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MBinService().getMBinService();
    }
}
