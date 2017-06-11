package qq.a792297773.com.demo;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by Administrator on 2017/6/11.
 */

public class MAyncTask extends AsyncTask<Intent,Intent,String>{
    @Override
    protected String doInBackground(Intent... intents) {
        Log.d("asyncTask","doInBackground");
        publishProgress();
        return "aaaaa";
    }

    @Override
    protected void onProgressUpdate(Intent... values) {
        super.onProgressUpdate(values);
        Log.d("asyncTask","onProgressUpdate");
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.d("asyncTask","onPostExecute"+s);
    }
}
