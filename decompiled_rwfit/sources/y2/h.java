package y2;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final String f19955a = o2.m.i("ProcessUtils");

    public static boolean a(Context context, o2.b bVar) {
        String str;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (Build.VERSION.SDK_INT >= 28) {
            str = Application.getProcessName();
        } else {
            try {
                Method declaredMethod = Class.forName("android.app.ActivityThread", false, h.class.getClassLoader()).getDeclaredMethod("currentProcessName", null);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(null, null);
                if (invoke instanceof String) {
                    str = (String) invoke;
                }
            } catch (Throwable th2) {
                o2.m.g().d(f19955a, "Unable to check ActivityThread for processName", th2);
            }
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService(Const.STR_PROCESS_TAG);
            if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null && !runningAppProcesses.isEmpty()) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == myPid) {
                        str = runningAppProcessInfo.processName;
                        break;
                    }
                }
            }
            str = null;
        }
        bVar.getClass();
        return !TextUtils.isEmpty(null) ? TextUtils.equals(str, null) : TextUtils.equals(str, context.getApplicationInfo().processName);
    }
}
