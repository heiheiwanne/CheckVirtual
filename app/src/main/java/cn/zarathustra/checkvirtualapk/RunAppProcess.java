package cn.zarathustra.checkvirtualapk;

import android.app.ActivityManager;
import android.content.Context;

import com.jaredrummler.android.processes.AndroidProcesses;

import java.util.List;

/**
 * Created by ear on 18-4-12.
 */

public class RunAppProcess {



   public void doapp (Context context){
       List<ActivityManager.RunningAppProcessInfo> runningAppProcessInfo = AndroidProcesses.getRunningAppProcessInfo(context);
       ActivityManager mActivityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
       for(int i = 0; i < runningAppProcessInfo.size(); i++){
           mActivityManager.restartPackage(runningAppProcessInfo.get(i).processName);
       }
       for(int i = 0; i < runningAppProcessInfo.size(); i++) {
           mActivityManager.killBackgroundProcesses(runningAppProcessInfo.get(i).processName);
       }


   }


}

