package nd;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.Display;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f16463a = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};

    public static boolean a(Activity activity, Intent intent) {
        return !activity.getPackageManager().queryIntentActivities(intent, WXMediaMessage.THUMB_LENGTH_LIMIT).isEmpty();
    }

    public static ArrayList b(Object... objArr) {
        ArrayList arrayList = new ArrayList(objArr.length);
        if (objArr.length != 0) {
            for (Object obj : objArr) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static void c(HashMap hashMap, String str, int i3) {
        String str2;
        if (!hashMap.containsKey(str)) {
            throw new IllegalStateException(l0.o("Please register permissions in the AndroidManifest.xml file <uses-permission android:name=\"", str, "\" />"));
        }
        Integer num = (Integer) hashMap.get(str);
        if (num != null && num.intValue() < i3) {
            StringBuilder sb2 = new StringBuilder("The AndroidManifest.xml file <uses-permission android:name=\"");
            sb2.append(str);
            sb2.append("\" android:maxSdkVersion=\"");
            sb2.append(num);
            sb2.append("\" /> does not meet the requirements, ");
            if (i3 != Integer.MAX_VALUE) {
                str2 = l0.j(i3, "the minimum requirement for maxSdkVersion is ");
            } else {
                str2 = "please delete the android:maxSdkVersion=\"" + num + "\" attribute";
            }
            sb2.append(str2);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public static Intent d(Activity activity) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(e(activity));
        return intent;
    }

    public static Uri e(Activity activity) {
        return Uri.parse("package:" + activity.getPackageName());
    }

    public static Intent f(Activity activity) {
        Intent intent;
        if (Build.VERSION.SDK_INT >= 30) {
            intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
            intent.setData(e(activity));
        } else {
            intent = null;
        }
        return (intent == null || !a(activity, intent)) ? d(activity) : intent;
    }

    public static boolean g(Activity activity) {
        int rotation;
        Display display;
        if (Build.VERSION.SDK_INT >= 30) {
            display = activity.getDisplay();
            rotation = display.getRotation();
        } else {
            rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        }
        return rotation == 2 || rotation == 3;
    }

    public static boolean h() {
        return Build.VERSION.SDK_INT >= 29;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00c7, code lost:
    
        if ("android.permission.BLUETOOTH_ADVERTISE".equals(r5) == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00f8, code lost:
    
        if ("android.permission.ACCESS_MEDIA_LOCATION".equals(r5) != false) goto L77;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0114 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0113 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean i(android.content.Context r4, java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: nd.c.i(android.content.Context, java.lang.String):boolean");
    }

    public static boolean j(Context context, ArrayList arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                if (!i(context, (String) obj)) {
                }
            }
            return true;
        }
        return false;
    }

    public static boolean k(String str) {
        return "android.permission.MANAGE_EXTERNAL_STORAGE".equals(str) || "android.permission.REQUEST_INSTALL_PACKAGES".equals(str) || "android.permission.SYSTEM_ALERT_WINDOW".equals(str) || "android.permission.WRITE_SETTINGS".equals(str) || "android.permission.NOTIFICATION_SERVICE".equals(str) || "android.permission.PACKAGE_USAGE_STATS".equals(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0040 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.content.res.XmlResourceParser l(android.content.Context r5) {
        /*
            android.content.res.AssetManager r0 = r5.getAssets()
            android.content.pm.ApplicationInfo r1 = r5.getApplicationInfo()
            java.lang.String r1 = r1.sourceDir
            java.lang.Class r2 = r0.getClass()     // Catch: java.lang.reflect.InvocationTargetException -> L2b java.lang.IllegalAccessException -> L2d java.lang.NoSuchMethodException -> L2f
            java.lang.String r3 = "addAssetPath"
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            java.lang.Class[] r4 = new java.lang.Class[]{r4}     // Catch: java.lang.reflect.InvocationTargetException -> L2b java.lang.IllegalAccessException -> L2d java.lang.NoSuchMethodException -> L2f
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r3, r4)     // Catch: java.lang.reflect.InvocationTargetException -> L2b java.lang.IllegalAccessException -> L2d java.lang.NoSuchMethodException -> L2f
            java.lang.Object[] r1 = new java.lang.Object[]{r1}     // Catch: java.lang.reflect.InvocationTargetException -> L2b java.lang.IllegalAccessException -> L2d java.lang.NoSuchMethodException -> L2f
            java.lang.Object r0 = r2.invoke(r0, r1)     // Catch: java.lang.reflect.InvocationTargetException -> L2b java.lang.IllegalAccessException -> L2d java.lang.NoSuchMethodException -> L2f
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.lang.reflect.InvocationTargetException -> L2b java.lang.IllegalAccessException -> L2d java.lang.NoSuchMethodException -> L2f
            if (r0 == 0) goto L3c
            int r0 = r0.intValue()     // Catch: java.lang.reflect.InvocationTargetException -> L2b java.lang.IllegalAccessException -> L2d java.lang.NoSuchMethodException -> L2f
            goto L3d
        L2b:
            r0 = move-exception
            goto L31
        L2d:
            r0 = move-exception
            goto L35
        L2f:
            r0 = move-exception
            goto L39
        L31:
            r0.printStackTrace()
            goto L3c
        L35:
            r0.printStackTrace()
            goto L3c
        L39:
            r0.printStackTrace()
        L3c:
            r0 = 0
        L3d:
            r1 = 0
            if (r0 != 0) goto L41
            return r1
        L41:
            android.content.res.AssetManager r2 = r5.getAssets()     // Catch: org.xmlpull.v1.XmlPullParserException -> L70 java.io.IOException -> L72
            java.lang.String r3 = "AndroidManifest.xml"
            android.content.res.XmlResourceParser r0 = r2.openXmlResourceParser(r0, r3)     // Catch: org.xmlpull.v1.XmlPullParserException -> L70 java.io.IOException -> L72
        L4b:
            int r2 = r0.getEventType()     // Catch: org.xmlpull.v1.XmlPullParserException -> L70 java.io.IOException -> L72
            r3 = 2
            if (r2 == r3) goto L53
            goto L74
        L53:
            java.lang.String r2 = "manifest"
            java.lang.String r3 = r0.getName()     // Catch: org.xmlpull.v1.XmlPullParserException -> L70 java.io.IOException -> L72
            boolean r2 = r2.equals(r3)     // Catch: org.xmlpull.v1.XmlPullParserException -> L70 java.io.IOException -> L72
            if (r2 == 0) goto L74
            java.lang.String r2 = r5.getPackageName()     // Catch: org.xmlpull.v1.XmlPullParserException -> L70 java.io.IOException -> L72
            java.lang.String r3 = "package"
            java.lang.String r3 = r0.getAttributeValue(r1, r3)     // Catch: org.xmlpull.v1.XmlPullParserException -> L70 java.io.IOException -> L72
            boolean r2 = android.text.TextUtils.equals(r2, r3)     // Catch: org.xmlpull.v1.XmlPullParserException -> L70 java.io.IOException -> L72
            if (r2 == 0) goto L74
            return r0
        L70:
            r5 = move-exception
            goto L7c
        L72:
            r5 = move-exception
            goto L80
        L74:
            int r2 = r0.next()     // Catch: org.xmlpull.v1.XmlPullParserException -> L70 java.io.IOException -> L72
            r3 = 1
            if (r2 != r3) goto L4b
            goto L83
        L7c:
            r5.printStackTrace()
            goto L83
        L80:
            r5.printStackTrace()
        L83:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: nd.c.l(android.content.Context):android.content.res.XmlResourceParser");
    }
}
