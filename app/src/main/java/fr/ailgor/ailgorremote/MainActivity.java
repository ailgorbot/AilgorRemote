package fr.ailgor.ailgorremote;


import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class MainActivity extends ActionBarActivity {

    private ToggleButton toggleButtonCamera;
    private WebView webView;
    String url = "http://192.168.0.22:8080";
    String serverAddress = "192.168.0.22";
    int serverPort = 8090;

    private TextView textClient;
    private TextView textServer;
    private String serverCommand = "STOP";


    private Button buttonLed;
    private ImageButton buttonUp;
    private ImageButton buttonDown;
    private ImageButton buttonLeft;
    private ImageButton buttonRight;
    private ImageButton buttonHeadUp;
    private ImageButton buttonHeadDown;
    private ImageButton buttonHeadLeft;
    private ImageButton buttonHeadRight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Section Camera IOIO

        toggleButtonCamera = (ToggleButton)findViewById(R.id.toggleButtonCamera);
        webView = (WebView) findViewById(R.id.webView);
        webView.setRotation(270);
        webView.setTranslationX(270);
        webView.setTranslationY(-80);
        webView.setBackgroundColor(0);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        toggleButtonCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toggleButtonCamera.isChecked()) {
                    webView.resumeTimers();
                    webView.loadUrl(url);

                    toggleButtonCamera.setChecked(true);
                } else {
                    webView.pauseTimers();
                    webView.loadUrl(url);
                    toggleButtonCamera.setChecked(false);
                }
            }
        });




        // Section Client-Server

        textClient = (TextView) findViewById(R.id.textClient);
        textServer = (TextView) findViewById(R.id.textServer);

        buttonLed = (Button) findViewById(R.id.buttonLed);
        buttonLed.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    serverCommand="IOIOLed";
                    textClient.setText(serverCommand);
                    MyClientTask myClientTask = new MyClientTask(serverAddress, serverPort);
                    myClientTask.execute();
                }
                if (event.getAction() == MotionEvent.ACTION_UP)
                {
                    serverCommand="STOP";
                    textClient.setText(serverCommand);
                    MyClientTask myClientTask = new MyClientTask(serverAddress, serverPort);
                    myClientTask.execute();
                }

                return false;
            }
        });



        buttonUp = (ImageButton) findViewById(R.id.buttonUp);
        buttonUp.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    serverCommand="RCUP";
                    textClient.setText(serverCommand);
                    MyClientTask myClientTask = new MyClientTask(serverAddress, serverPort);
                    myClientTask.execute();
                }
                if (event.getAction() == MotionEvent.ACTION_UP)
                {
                    serverCommand="STOP";
                    textClient.setText(serverCommand);
                    MyClientTask myClientTask = new MyClientTask(serverAddress, serverPort);
                    myClientTask.execute();
                }

                return false;
            }
        });


        buttonDown = (ImageButton) findViewById(R.id.buttonDown);
        buttonDown.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    serverCommand="RCDOWN";
                    textClient.setText(serverCommand);
                    MyClientTask myClientTask = new MyClientTask(serverAddress, serverPort);
                    myClientTask.execute();
                }
                if (event.getAction() == MotionEvent.ACTION_UP)
                {
                    serverCommand="STOP";
                    textClient.setText(serverCommand);
                    MyClientTask myClientTask = new MyClientTask(serverAddress, serverPort);
                    myClientTask.execute();
                }

                return false;
            }
        });


        buttonLeft= (ImageButton) findViewById(R.id.buttonLeft);
        buttonLeft.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    serverCommand="RCLEFT";
                    textClient.setText(serverCommand);
                    MyClientTask myClientTask = new MyClientTask(serverAddress, serverPort);
                    myClientTask.execute();
                }
                if (event.getAction() == MotionEvent.ACTION_UP)
                {
                    serverCommand="STOP";
                    textClient.setText(serverCommand);
                    MyClientTask myClientTask = new MyClientTask(serverAddress, serverPort);
                    myClientTask.execute();
                }

                return false;
            }
        });

        buttonRight = (ImageButton) findViewById(R.id.buttonRight);
        buttonRight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    serverCommand="RCRIGHT";
                    textClient.setText(serverCommand);
                    MyClientTask myClientTask = new MyClientTask(serverAddress, serverPort);
                    myClientTask.execute();
                }
                if (event.getAction() == MotionEvent.ACTION_UP)
                {
                    serverCommand="STOP";
                    textClient.setText(serverCommand);
                    MyClientTask myClientTask = new MyClientTask(serverAddress, serverPort);
                    myClientTask.execute();
                }

                return false;
            }
        });


        buttonHeadRight = (ImageButton) findViewById(R.id.buttonHeadRight);
        buttonHeadRight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    serverCommand="HDRIGHT";
                    textClient.setText(serverCommand);
                    MyClientTask myClientTask = new MyClientTask(serverAddress, serverPort);
                    myClientTask.execute();
                }
                if (event.getAction() == MotionEvent.ACTION_UP)
                {
                    serverCommand="STOP";
                    textClient.setText(serverCommand);
                    MyClientTask myClientTask = new MyClientTask(serverAddress, serverPort);
                    myClientTask.execute();
                }

                return false;
            }
        });

        buttonHeadLeft = (ImageButton) findViewById(R.id.buttonHeadLeft);
        buttonHeadLeft.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    serverCommand="HDLEFT";
                    textClient.setText(serverCommand);
                    MyClientTask myClientTask = new MyClientTask(serverAddress, serverPort);
                    myClientTask.execute();
                }
                if (event.getAction() == MotionEvent.ACTION_UP)
                {
                    serverCommand="STOP";
                    textClient.setText(serverCommand);
                    MyClientTask myClientTask = new MyClientTask(serverAddress, serverPort);
                    myClientTask.execute();
                }

                return false;
            }
        });


        buttonHeadUp = (ImageButton) findViewById(R.id.buttonHeadUp);
        buttonHeadUp.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    serverCommand="HDUP";
                    textClient.setText(serverCommand);
                    MyClientTask myClientTask = new MyClientTask(serverAddress, serverPort);
                    myClientTask.execute();
                }
                if (event.getAction() == MotionEvent.ACTION_UP)
                {
                    serverCommand="STOP";
                    textClient.setText(serverCommand);
                    MyClientTask myClientTask = new MyClientTask(serverAddress, serverPort);
                    myClientTask.execute();
                }

                return false;
            }
        });

        buttonHeadDown = (ImageButton) findViewById(R.id.buttonHeadDown);
        buttonHeadDown.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    serverCommand="HDDOWN";
                    textClient.setText(serverCommand);
                    MyClientTask myClientTask = new MyClientTask(serverAddress, serverPort);
                    myClientTask.execute();
                }
                if (event.getAction() == MotionEvent.ACTION_UP)
                {
                    serverCommand="STOP";
                    textClient.setText(serverCommand);
                    MyClientTask myClientTask = new MyClientTask(serverAddress, serverPort);
                    myClientTask.execute();
                }

                return false;
            }
        });




    }



    public class MyClientTask extends AsyncTask<Void, Void, Void> {

        String dstAddress;
        int dstPort;
        String response = "";

        MyClientTask(String addr, int port){
            dstAddress = addr;
            dstPort = port;
        }

        @Override
        protected Void doInBackground(Void... arg0) {

            Socket socket = null;

            try {
                socket = new Socket(dstAddress, dstPort);

                OutputStream outputStream = socket.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                dataOutputStream.writeUTF(serverCommand);

                InputStream inputStream = socket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(inputStream);
                response = dataInputStream.readUTF();



            } catch (UnknownHostException e) {
                e.printStackTrace();
                response = "UnknownHostException: " + e.toString();
            } catch (IOException e) {
                e.printStackTrace();
                response = "IOException: " + e.toString();
            }finally{
                if(socket != null){
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }

        protected void onPostExecute(Void result) {
            textServer.setText(response);
            super.onPostExecute(result);
        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
