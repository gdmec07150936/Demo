package qq.a792297773.com.demo;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private IntentFilter intentFilter;
    private StandardTowBroadcase standardTowBroadcase;
    private LocalBroadcastManager localBroadcastManager;
    private Intent intent;
    private Intent intent2;
    private BinService binService;
    private ServiceConnection serviceConnection;
    private BinService.MBinService mBinService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter intentFilter =  new IntentFilter("myBroadcase");
        standardTowBroadcase = new StandardTowBroadcase();
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        localBroadcastManager.registerReceiver(standardTowBroadcase,intentFilter);

    }

    public void sendBroadcase(View view){
        Intent intent = new Intent();
        intent.putExtra("data","广播");
        intent.setAction("myBroadcase");
        /*sendOrderedBroadcast(intent,null);*/
        localBroadcastManager.sendBroadcast(intent);
    }

    public void startService(View view){
        intent = new Intent(MainActivity.this,StartService.class);
        startService(intent);
    }

    public void stopService(View view){
        stopService(intent);
    }

    public void binService(View view){
        intent2 = new Intent(MainActivity.this,StartService.class);
        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                mBinService = ((BinService.MBinService)iBinder).getMBinService();
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        };
        bindService(intent2,serviceConnection,Service.BIND_AUTO_CREATE);
    }

    public void startMiuse(View view){
        mBinService.startService();
    }

    public void stopMiuse(View view){
        mBinService.stopService();
    }

    public void canBin(View view){
        unbindService(serviceConnection);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(standardTowBroadcase);
        if (intent != null){
            stopService(intent);
        }
        if (serviceConnection != null){
            unbindService(serviceConnection);
        }
    }
}
