package qq.a792297773.com.demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Administrator on 2017/6/11.
 */

public class StandardTowBroadcase extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Broadcase","第二条广播");
    }
}
