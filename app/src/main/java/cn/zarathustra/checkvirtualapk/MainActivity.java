package cn.zarathustra.checkvirtualapk;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.jaredrummler.android.processes.AndroidProcesses;
import com.jaredrummler.android.processes.models.AndroidAppProcess;

import java.util.List;

import static cn.zarathustra.checkvirtualapk.CheckVirtual.exec;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView viewById = (TextView) findViewById(R.id.tv_info);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                viewById .setText("is run in virtual "  +   "\n");
                for (String s : CheckVirtual.isRunInVirtual()) {
                    viewById.append(s +   "\n");
                }
                viewById .append("checkPipes= " + AntiEmulator.checkPipes() + "\n");
                viewById .append("checkQEmuDriverFile= " + AntiEmulator.checkQEmuDriverFile() + "\n");
                viewById .append("CheckEmulatorFiles= " + AntiEmulator.CheckEmulatorFiles() + "\n");
                viewById .append("CheckPhoneNumber= " + AntiEmulator.CheckPhoneNumber(MainActivity.this) + "\n");
                viewById .append("CheckDeviceIDS= " + AntiEmulator.CheckDeviceIDS(MainActivity.this) + "\n");
                viewById .append("CheckImsiIDS= " + AntiEmulator.CheckImsiIDS(MainActivity.this) + "\n");
                viewById .append("CheckEmulatorBuild= " + AntiEmulator.CheckEmulatorBuild(MainActivity.this) + "\n");
                viewById .append("CheckOperatorNameAndroid= " + AntiEmulator.CheckOperatorNameAndroid(MainActivity.this) + "\n");

                List<AndroidAppProcess> runningAppProcesses = AndroidProcesses.getRunningAppProcesses();
                for (AndroidAppProcess runningAppProcess : runningAppProcesses) {
                    viewById.append(runningAppProcess.getPackageName());
                    viewById.append(runningAppProcess.uid+"\n");
                }
            }
        },5*1000);
    }
}
