package ye;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_common.n6;
import com.google.android.gms.internal.mlkit_vision_common.o6;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import n.l;

/* loaded from: classes2.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static int f20123a = 65536;

    /* renamed from: b, reason: collision with root package name */
    public static long f20124b = 2000;

    /* renamed from: c, reason: collision with root package name */
    public static Boolean f20125c;

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f20126d = Pattern.compile("attachment;\\s*filename\\*\\s*=\\s*\"*([^\"]*)'\\S*'([^\"]*)\"*");
    public static final Pattern e = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"*([^\"\\n]*)\"*");

    public static l a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("found invalid internal destination path, empty");
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            throw new RuntimeException(String.format(Locale.ENGLISH, "found invalid internal destination path[%s], & path is directory[%B]", str, Boolean.valueOf(file.isDirectory())));
        }
        if (file.exists() || file.createNewFile()) {
            com.liulishuo.filedownloader.download.c.f11405a.h().getClass();
            return new l(file);
        }
        String absolutePath = file.getAbsolutePath();
        Locale locale = Locale.ENGLISH;
        throw new IOException(l0.n("create new file error  ", absolutePath));
    }

    public static void b(String str, String str2) {
        if (str2 != null) {
            File file = new File(str2);
            if (file.exists()) {
                file.delete();
            }
        }
        if (str != null) {
            File file2 = new File(str);
            if (file2.exists()) {
                file2.delete();
            }
        }
    }

    public static String c(String str, String str2) {
        if (str2 == null) {
            throw new IllegalStateException("can't generate real path, the file name is null");
        }
        if (str == null) {
            throw new IllegalStateException("can't generate real path, the directory is null");
        }
        String str3 = File.separator;
        Locale locale = Locale.ENGLISH;
        return r5.a.c(str, str3, str2);
    }

    public static String d(String str) {
        int length = str.length();
        char c9 = File.separatorChar;
        int i3 = (c9 == '\\' && length > 2 && str.charAt(1) == ':') ? 2 : 0;
        int lastIndexOf = str.lastIndexOf(c9);
        int i10 = (lastIndexOf != -1 || i3 <= 0) ? lastIndexOf : 2;
        if (i10 == -1 || str.charAt(length - 1) == c9) {
            return null;
        }
        return (str.indexOf(c9) == i10 && str.charAt(i3) == c9) ? str.substring(0, i10 + 1) : str.substring(0, i10);
    }

    public static boolean e(FileDownloadModel fileDownloadModel, String str) {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        boolean exists = file.exists();
        boolean isDirectory = file.isDirectory();
        if (!exists || isDirectory) {
            return false;
        }
        long length = file.length();
        long j4 = fileDownloadModel.j();
        if (fileDownloadModel.a() <= 1 && j4 == 0) {
            return false;
        }
        long n4 = fileDownloadModel.n();
        if (length >= j4) {
            return n4 == -1 || (length <= n4 && j4 < n4);
        }
        return false;
    }

    public static boolean f(Context context) {
        boolean z5;
        Boolean bool = f20125c;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (!c.f20115a.f20119d) {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService(Const.STR_PROCESS_TAG);
            if (activityManager != null) {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
                    Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z5 = false;
                            break;
                        }
                        ActivityManager.RunningAppProcessInfo next = it.next();
                        if (next.pid == myPid) {
                            z5 = next.processName.endsWith(":filedownloader");
                            break;
                        }
                    }
                } else {
                    o6.b(e.class, "The running app process info list from ActivityManager is null or empty, maybe current App is not running.", new Object[0]);
                    return false;
                }
            } else {
                o6.b(e.class, "fail to get the activity manager!", new Object[0]);
                return false;
            }
        } else {
            z5 = true;
        }
        f20125c = Boolean.valueOf(z5);
        return z5;
    }

    public static boolean g() {
        ConnectivityManager connectivityManager = (ConnectivityManager) n6.f10047a.getSystemService("connectivity");
        if (connectivityManager == null) {
            o6.b(e.class, "failed to get connectivity manager!", new Object[0]);
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo == null || activeNetworkInfo.getType() != 1;
    }

    public static void h(Context context) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(context.getFilesDir().getAbsolutePath());
        File file = new File(r5.a.f(sb2, File.separator, "filedownloader"), ".old_file_converted");
        try {
            file.getParentFile().mkdirs();
            file.createNewFile();
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    public static String i(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb2 = new StringBuilder(digest.length * 2);
            for (byte b3 : digest) {
                int i3 = b3 & 255;
                if (i3 < 16) {
                    sb2.append("0");
                }
                sb2.append(Integer.toHexString(i3));
            }
            return sb2.toString();
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e10);
        } catch (NoSuchAlgorithmException e11) {
            throw new RuntimeException("Huh, MD5 should be supported?", e11);
        }
    }

    public static boolean j(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        PowerManager powerManager;
        ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService(Const.STR_PROCESS_TAG);
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null || (powerManager = (PowerManager) context.getSystemService("power")) == null || !powerManager.isInteractive()) {
            return true;
        }
        String packageName = context.getApplicationContext().getPackageName();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(packageName) && runningAppProcessInfo.importance == 100) {
                return false;
            }
        }
        return true;
    }
}
