package fr.ailgor.ailgorremote;


import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.webkit.WebView;
import android.widget.TextView;

/**
 * Created by Ailgor on 14/05/2015.
 */
public class AilgorRemoteService extends Service {

    public final String TAG = "AilgorRemoteService";

    private IBinder mIBinder = new AilgorRemoteServiceBinder();


    public void onCreate() {
        super.onCreate();


    }

    public void  startWebView(WebView webView, String url){
        webView.loadUrl(url);
        webView.setRotation(270);
        webView.setTranslationX(200);
        webView.setBackgroundColor(0);
    }

    public void  stopWebView(WebView webView){
        webView.stopLoading();
    }


    public void onDestroy() {
        super.onDestroy();
    }

    public IBinder onBind(Intent intent) {
        return mIBinder;
    }


    public void  setCommandText(TextView t, String c){
        t.setText(c);
    }

    public class AilgorRemoteServiceBinder extends Binder {
        AilgorRemoteService getService(){
            return AilgorRemoteService.this;
        }
    }
}
