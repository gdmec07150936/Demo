package qq.a792297773.com.demo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/6/11.
 */

public class HandlerActivity extends Activity{
    private Handler handler;
    private Handler handler2;
    private Runnable runnable;
    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.handledemo);
        textview = (TextView) this.findViewById(R.id.textview);
        handler = new Handler();
        handler2 = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what){
                    case 1:
                        textview.setText("1");
                        break;
                    case 2:
                        textview.setText("2");
                        break;
                }
            }
        };
        runnable = new Runnable() {
            @Override
            public void run() {
                textview.setText("asdfasdfasdf");
            }
        };
    }

    public void postHandler(View view){
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.post(runnable);
            }
        }.start();
    }

    public void sendHandler(View view){
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message message = new Message();
                message.what = 2;
                handler2.sendMessage(message);
            }
        }.start();
    }

    public void openAsycTask(View view){
        MAyncTask mAyncTask = new MAyncTask();
        mAyncTask.execute();
    }
}
