package com.tencent.open.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import androidx.core.content.FileProvider;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static String f12120a = "";

    /* renamed from: b, reason: collision with root package name */
    private static String f12121b = "";

    /* renamed from: c, reason: collision with root package name */
    private static String f12122c = "";

    /* renamed from: d, reason: collision with root package name */
    private static String f12123d = "";
    private static int e = -1;

    /* renamed from: f, reason: collision with root package name */
    private static String f12124f = "0123456789ABCDEF";

    private static char a(int i3) {
        int i10 = i3 & 15;
        return (char) (i10 < 10 ? i10 + 48 : i10 + 87);
    }

    public static Bundle b(String str) {
        try {
            URL url = new URL(str.replace("auth://", "http://"));
            Bundle a3 = a(url.getQuery());
            a3.putAll(a(url.getRef()));
            return a3;
        } catch (MalformedURLException unused) {
            return new Bundle();
        }
    }

    public static JSONObject c(String str) {
        try {
            URL url = new URL(str.replace("auth://", "http://"));
            JSONObject a3 = a((JSONObject) null, url.getQuery());
            a(a3, url.getRef());
            return a3;
        } catch (MalformedURLException unused) {
            return new JSONObject();
        }
    }

    public static JSONObject d(String str) throws JSONException {
        if (str.equals("false")) {
            str = "{value : false}";
        }
        if (str.equals("true")) {
            str = "{value : true}";
        }
        if (str.contains("allback(")) {
            str = str.replaceFirst("[\\s\\S]*allback\\(([\\s\\S]*)\\);[^\\)]*\\z", "$1").trim();
        }
        if (str.contains("online[0]=")) {
            str = "{online:" + str.charAt(str.length() - 2) + "}";
        }
        return new JSONObject(str);
    }

    public static boolean e(String str) {
        return str == null || str.length() == 0;
    }

    public static String f(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e10) {
            SLog.e("openSDK_LOG.Util", "urlEncode: UnsupportedEncodingException", e10);
            return "";
        }
    }

    private static boolean g(Context context) {
        Signature[] signatureArr;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.tencent.mtt", 64);
            String str = packageInfo.versionName;
            if (k.a(str, "4.3") >= 0 && !str.startsWith("4.4") && (signatureArr = packageInfo.signatures) != null) {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(signatureArr[0].toByteArray());
                    String a3 = a(messageDigest.digest());
                    messageDigest.reset();
                    if (a3.equals("d8391a394d4a179e6fe7bdb8a301258b")) {
                        return true;
                    }
                } catch (NoSuchAlgorithmException e10) {
                    SLog.e("openSDK_LOG.Util", "isQQBrowerAvailable has exception: " + e10.getMessage());
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static final boolean h(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith("http://") || str.startsWith("https://");
    }

    public static boolean i(String str) {
        return str != null && new File(str).exists();
    }

    public static byte[] j(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e10) {
            SLog.e("openSDK_LOG.Util", "getBytesUTF8: UnsupportedEncodingException", e10);
            return new byte[0];
        }
    }

    public static String k(String str) {
        return a(str, 2);
    }

    public static File l(String str) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            if (file.getParentFile() != null && !file.getParentFile().exists()) {
                if (file.getParentFile().mkdirs()) {
                    file.createNewFile();
                    return file;
                }
                SLog.d("openSDK_LOG.Util", "createFile failed" + str);
                return file;
            }
            file.createNewFile();
        }
        return file;
    }

    public static boolean m(String str) {
        String b3 = b();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(b3) || !str.contains(b3)) ? false : true;
    }

    public static Bundle a(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            try {
                for (String str2 : str.split(Const.STR_MART_ADD)) {
                    String[] a3 = a(str2, "=");
                    if (a3.length == 2) {
                        bundle.putString(URLDecoder.decode(a3[0]), URLDecoder.decode(a3[1]));
                    }
                }
            } catch (Exception unused) {
                return null;
            }
        }
        return bundle;
    }

    public static String e(Context context, String str) {
        if (context == null) {
            return "";
        }
        String d5 = d(context, str);
        f12122c = d5;
        return d5;
    }

    public static File h(Context context, String str) {
        File[] externalFilesDirs;
        if (context == null || (externalFilesDirs = context.getExternalFilesDirs(str)) == null || externalFilesDirs.length <= 0) {
            return null;
        }
        return externalFilesDirs[0];
    }

    private static boolean i(Context context, String str) {
        try {
            return context.checkSelfPermission(str) != 0;
        } catch (Exception e10) {
            SLog.e("openSDK_LOG.Util", "checkSelfPermission exception", e10);
            return false;
        }
    }

    public static boolean e(Context context) {
        return k.c(context, "8.1.8") >= 0;
    }

    public static boolean f(Context context, String str) {
        boolean z5 = !c(context) || k.a(context, Constants.PACKAGE_QQ_PAD) == null;
        if (z5 && k.a(context, Constants.PACKAGE_TIM) != null) {
            z5 = false;
        }
        return z5 ? k.c(context, str) < 0 : z5;
    }

    public static boolean b(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo[] networkInfoArr;
        if (context == null || i(context, "android.permission.ACCESS_NETWORK_STATE") || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return true;
        }
        try {
            networkInfoArr = connectivityManager.getAllNetworkInfo();
        } catch (Exception e10) {
            SLog.e("openSDK_LOG.Util", "Util.isNetWorkAvailable has exception: ", e10);
            networkInfoArr = null;
        }
        if (networkInfoArr != null && networkInfoArr.length != 0) {
            for (NetworkInfo networkInfo : networkInfoArr) {
                if (networkInfo.isConnectedOrConnecting()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String c(Context context, String str) {
        if (context == null) {
            return "";
        }
        b(context, str);
        return f12121b;
    }

    public static boolean f(Context context) {
        return k.c(context, "5.9.5") >= 0;
    }

    public static String[] a(String str, String str2) {
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            return new String[]{str};
        }
        return new String[]{str.substring(0, indexOf), str.substring(str2.length() + indexOf)};
    }

    public static boolean c(Context context) {
        double d5;
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            d5 = Math.sqrt(Math.pow(displayMetrics.widthPixels / displayMetrics.xdpi, 2.0d) + Math.pow(displayMetrics.heightPixels / displayMetrics.ydpi, 2.0d));
        } catch (Throwable unused) {
            d5 = 0.0d;
        }
        return d5 > 6.5d;
    }

    public static String d(Context context, String str) {
        if (context == null) {
            return "";
        }
        b(context, str);
        return f12120a;
    }

    public static JSONObject a(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (str != null) {
            for (String str2 : str.split(Const.STR_MART_ADD)) {
                String[] split = str2.split("=");
                if (split.length == 2) {
                    try {
                        split[0] = URLDecoder.decode(split[0]);
                        split[1] = URLDecoder.decode(split[1]);
                    } catch (Exception unused) {
                    }
                    try {
                        jSONObject.put(split[0], split[1]);
                    } catch (JSONException e10) {
                        SLog.e("openSDK_LOG.Util", "decodeUrlToJson has exception: " + e10.getMessage());
                    }
                }
            }
        }
        return jSONObject;
    }

    public static String g(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(j(str));
            byte[] digest = messageDigest.digest();
            if (digest != null) {
                StringBuilder sb2 = new StringBuilder();
                for (byte b3 : digest) {
                    sb2.append(a(b3 >>> 4));
                    sb2.append(a(b3));
                }
                return sb2.toString();
            }
        } catch (NoSuchAlgorithmException e10) {
            SLog.e("openSDK_LOG.Util", "encrypt has exception: " + e10.getMessage());
        }
        return str;
    }

    public static void b(Context context, String str) {
        if (context == null) {
            return;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            String str2 = packageInfo.versionName;
            f12121b = str2;
            f12120a = str2.substring(0, str2.lastIndexOf(46));
            String str3 = f12121b;
            f12123d = str3.substring(str3.lastIndexOf(46) + 1, f12121b.length());
            e = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e10) {
            SLog.e("openSDK_LOG.Util", "getPackageInfo has exception: " + e10.getMessage());
        } catch (Exception e11) {
            SLog.e("openSDK_LOG.Util", "getPackageInfo has exception: " + e11.getMessage());
        }
    }

    public static boolean d(Context context) {
        return k.c(context, "8.1.5") >= 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01f9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0069 A[Catch: all -> 0x00a1, Exception -> 0x00a8, TRY_LEAVE, TryCatch #23 {Exception -> 0x00a8, all -> 0x00a1, blocks: (B:26:0x0061, B:28:0x0069, B:40:0x00ae, B:42:0x00b4, B:43:0x00b7, B:45:0x00c6, B:46:0x00c9), top: B:25:0x0061 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ae A[Catch: all -> 0x00a1, Exception -> 0x00a8, TRY_ENTER, TryCatch #23 {Exception -> 0x00a8, all -> 0x00a1, blocks: (B:26:0x0061, B:28:0x0069, B:40:0x00ae, B:42:0x00b4, B:43:0x00b7, B:45:0x00c6, B:46:0x00c9), top: B:25:0x0061 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String c(android.content.Context r11, android.net.Uri r12) {
        /*
            Method dump skipped, instructions count: 531
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.m.c(android.content.Context, android.net.Uri):java.lang.String");
    }

    public static boolean a(Context context, String str) {
        boolean z5;
        try {
            z5 = g(context);
            try {
                if (z5) {
                    a(context, "com.tencent.mtt", "com.tencent.mtt.MainActivity", str);
                } else {
                    a(context, "com.android.browser", "com.android.browser.BrowserActivity", str);
                }
                return true;
            } catch (Exception unused) {
                if (z5) {
                    try {
                        try {
                            try {
                                a(context, "com.android.browser", "com.android.browser.BrowserActivity", str);
                                return true;
                            } catch (Exception unused2) {
                                return false;
                            }
                        } catch (Exception unused3) {
                            a(context, "com.android.chrome", "com.google.android.apps.chrome.Main", str);
                            return true;
                        }
                    } catch (Exception unused4) {
                        a(context, "com.google.android.browser", "com.android.browser.BrowserActivity", str);
                        return true;
                    }
                }
                try {
                    try {
                        a(context, "com.google.android.browser", "com.android.browser.BrowserActivity", str);
                        return true;
                    } catch (Exception unused5) {
                        return false;
                    }
                } catch (Exception unused6) {
                    a(context, "com.android.chrome", "com.google.android.apps.chrome.Main", str);
                    return true;
                }
            }
        } catch (Exception unused7) {
            z5 = false;
        }
    }

    @SuppressLint({"NewApi"})
    public static String b(Context context, Uri uri) {
        Uri uri2;
        if (uri == null) {
            return null;
        }
        if (DocumentsContract.isDocumentUri(context, uri)) {
            String authority = uri.getAuthority();
            if ("com.android.externalstorage.documents".equals(authority)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(":");
                String str = split[0];
                if ("primary".equals(str)) {
                    return Environment.getExternalStorageDirectory().getAbsolutePath().concat("/").concat(split[1]);
                }
                return "/storage/".concat(str).concat("/").concat(split[1]);
            }
            if ("com.android.providers.downloads.documents".equals(authority)) {
                String documentId = DocumentsContract.getDocumentId(uri);
                if (documentId.startsWith("raw:")) {
                    return documentId.replaceFirst("raw:", "");
                }
                return c(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.parseLong(documentId)));
            }
            if ("com.android.providers.media.documents".equals(authority)) {
                String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                String str2 = split2[0];
                if ("image".equals(str2)) {
                    uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(str2)) {
                    uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(str2)) {
                    uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                return c(context, ContentUris.withAppendedId(uri2, Long.parseLong(split2[1])));
            }
            return null;
        }
        String scheme = uri.getScheme();
        if ("content".equals(scheme)) {
            return c(context, uri);
        }
        if (Const.STR_FILE.equals(scheme)) {
            return uri.getPath();
        }
        return null;
    }

    public static boolean g(Context context, String str) {
        boolean z5 = !c(context) || k.a(context, Constants.PACKAGE_QQ_PAD) == null;
        return z5 ? k.c(context, str) < 0 : z5;
    }

    private static void a(Context context, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, str2));
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(1073741824);
        intent.addFlags(AMapEngineUtils.MAX_P20_WIDTH);
        intent.setData(Uri.parse(str3));
        context.startActivity(intent);
    }

    public static boolean a() {
        return (Environment.getExternalStorageState().equals("mounted") ? Environment.getExternalStorageDirectory() : null) != null;
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (byte b3 : bArr) {
            String num = Integer.toString(b3 & 255, 16);
            if (num.length() == 1) {
                num = "0".concat(num);
            }
            sb2.append(num);
        }
        return sb2.toString();
    }

    public static final String a(Context context) {
        CharSequence applicationLabel;
        if (context == null || (applicationLabel = context.getPackageManager().getApplicationLabel(context.getApplicationInfo())) == null) {
            return null;
        }
        return applicationLabel.toString();
    }

    public static final String a(String str, int i3, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "UTF-8";
        }
        try {
            if (str.getBytes(str2).length > i3) {
                int i10 = 0;
                int i11 = 0;
                while (i10 < str.length()) {
                    int i12 = i10 + 1;
                    i11 += str.substring(i10, i12).getBytes(str2).length;
                    if (i11 > i3) {
                        String substring = str.substring(0, i10);
                        if (TextUtils.isEmpty(str3)) {
                            return substring;
                        }
                        return substring + str3;
                    }
                    i10 = i12;
                }
            }
            return str;
        } catch (Exception e10) {
            SLog.e("openSDK_LOG.Util", "Util.subString has exception: " + e10.getMessage());
            return str;
        }
    }

    public static String b() {
        File e10 = g.e();
        if (e10 == null) {
            return null;
        }
        if (!e10.exists()) {
            e10.mkdirs();
        }
        return e10.toString();
    }

    public static boolean b(String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        try {
            return a(file, l(str2));
        } catch (IOException e10) {
            SLog.d("openSDK_LOG.Util", l0.q("copy fail from ", str, " to ", str2, " "), e10);
            return false;
        }
    }

    public static Bundle a(String str, String str2, String str3, String str4, String str5, String str6) {
        return a(str, str3, str4, str2, str5, str6, "", "", "", "", "", "");
    }

    public static Bundle a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        Bundle bundle = new Bundle();
        bundle.putString("openid", str);
        bundle.putString("report_type", str2);
        bundle.putString("act_type", str3);
        bundle.putString("via", str4);
        bundle.putString(Constants.JumpUrlConstants.URL_KEY_APPID, str5);
        bundle.putString("result", str6);
        bundle.putString("type", str7);
        bundle.putString("login_status", str8);
        bundle.putString("need_user_auth", str9);
        bundle.putString("to_uin", str10);
        bundle.putString("call_source", str11);
        bundle.putString("to_type", str12);
        bundle.putString(Constants.PARAM_PLATFORM, "1");
        return bundle;
    }

    public static boolean c() {
        Context a3 = g.a();
        return a3 != null && a3.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", a3.getPackageName()) == 0;
    }

    public static boolean a(Context context, boolean z5) {
        return (c(context) && k.a(context, Constants.PACKAGE_QQ_PAD) != null) || k.c(context, "4.1") >= 0 || k.a(context, Constants.PACKAGE_TIM) != null;
    }

    public static long a(Context context, Uri uri) {
        Cursor query = context.getContentResolver().query(uri, new String[]{"_size"}, null, null, null);
        if (query != null) {
            try {
                try {
                } finally {
                }
            } catch (Exception e10) {
                SLog.e("openSDK_LOG.Util", "cursor exception", e10);
            }
            if (query.getCount() != 0) {
                try {
                    r3 = query.moveToFirst() ? query.getLong(query.getColumnIndexOrThrow("_size")) : 0L;
                    query.close();
                } catch (Exception e11) {
                    SLog.e("openSDK_LOG.Util", "cursor exception", e11);
                    query.close();
                }
                return r3;
            }
        }
        return 0L;
    }

    public static String a(String str, int i3) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Base64.encodeToString(str.getBytes("UTF-8"), i3);
            } catch (UnsupportedEncodingException e10) {
                SLog.e("openSDK_LOG.Util", "convert2Base64String exception: " + e10.getMessage());
                return "";
            }
        }
        return "";
    }

    public static Drawable a(String str, Context context) {
        InputStream inputStream;
        StringBuilder sb2;
        InputStream inputStream2 = null;
        r2 = null;
        Drawable drawable = null;
        if (context == null) {
            SLog.e("openSDK_LOG.Util", "context null!");
            return null;
        }
        try {
            inputStream = context.getAssets().open(str);
            try {
                try {
                    drawable = Drawable.createFromStream(inputStream, str);
                    try {
                        inputStream.close();
                    } catch (Exception e10) {
                        e = e10;
                        sb2 = new StringBuilder("inputStream close exception: ");
                        sb2.append(e.getMessage());
                        SLog.e("openSDK_LOG.Util", sb2.toString());
                        return drawable;
                    }
                } catch (IOException e11) {
                    e = e11;
                    SLog.e("openSDK_LOG.Util", "getDrawable exception: " + e.getMessage());
                    try {
                        inputStream.close();
                    } catch (Exception e12) {
                        e = e12;
                        sb2 = new StringBuilder("inputStream close exception: ");
                        sb2.append(e.getMessage());
                        SLog.e("openSDK_LOG.Util", sb2.toString());
                        return drawable;
                    }
                    return drawable;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream2 = inputStream;
                try {
                    inputStream2.close();
                } catch (Exception e13) {
                    SLog.e("openSDK_LOG.Util", "inputStream close exception: " + e13.getMessage());
                }
                throw th;
            }
        } catch (IOException e14) {
            e = e14;
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            inputStream2.close();
            throw th;
        }
        return drawable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v9 */
    public static boolean a(File file, File file2) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                        file2.getParentFile().mkdirs();
                    }
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        file2 = new BufferedInputStream(new FileInputStream(file));
                    } catch (IOException e10) {
                        e = e10;
                        file2 = 0;
                    } catch (OutOfMemoryError e11) {
                        e = e11;
                        file2 = 0;
                    } catch (Throwable th2) {
                        th = th2;
                        file2 = 0;
                    }
                } catch (IOException e12) {
                    SLog.e("openSDK_LOG.Util", "copyFile error, ", e12);
                    return false;
                }
            } catch (IOException e13) {
                e = e13;
                file2 = 0;
            } catch (OutOfMemoryError e14) {
                e = e14;
                file2 = 0;
            } catch (Throwable th3) {
                th = th3;
                file2 = 0;
            }
        } catch (Throwable th4) {
            th = th4;
        }
        try {
            byte[] bArr = new byte[102400];
            while (true) {
                int read = file2.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                    fileOutputStream.flush();
                } else {
                    try {
                        break;
                    } catch (IOException e15) {
                        SLog.e("openSDK_LOG.Util", "copyFile error, ", e15);
                    }
                }
            }
            fileOutputStream.close();
            try {
                file2.close();
            } catch (IOException e16) {
                SLog.e("openSDK_LOG.Util", "copyFile error, ", e16);
            }
            return true;
        } catch (IOException e17) {
            e = e17;
            fileOutputStream2 = fileOutputStream;
            file2 = file2;
            SLog.e("openSDK_LOG.Util", "copyFile error, ", e);
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e18) {
                    SLog.e("openSDK_LOG.Util", "copyFile error, ", e18);
                }
            }
            if (file2 != 0) {
                file2.close();
                file2 = file2;
            }
            return false;
        } catch (OutOfMemoryError e19) {
            e = e19;
            fileOutputStream2 = fileOutputStream;
            file2 = file2;
            SLog.e("openSDK_LOG.Util", "copyFile error, ", e);
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e20) {
                    SLog.e("openSDK_LOG.Util", "copyFile error, ", e20);
                }
            }
            if (file2 != 0) {
                file2.close();
                file2 = file2;
            }
            return false;
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e21) {
                    SLog.e("openSDK_LOG.Util", "copyFile error, ", e21);
                }
            }
            if (file2 != 0) {
                try {
                    file2.close();
                    throw th;
                } catch (IOException e22) {
                    SLog.e("openSDK_LOG.Util", "copyFile error, ", e22);
                    throw th;
                }
            }
            throw th;
        }
    }

    public static boolean a(Context context, String str, String str2) {
        boolean b3 = b(str, str2);
        SLog.i("openSDK_LOG.Util", "copyFileByCheckPermission() copy success:" + b3);
        return b3;
    }

    public static String a(String str, Activity activity, String str2, IUiListener iUiListener) {
        String str3;
        try {
            boolean m10 = m(str2);
            SLog.i("openSDK_LOG.Util", "doPublishMood() check file: isAppSpecificDir=" + m10 + ",hasSDPermission=" + c());
            if (!m10) {
                File a3 = g.a("Images");
                if (a3 != null) {
                    str3 = a3.getAbsolutePath() + File.separator + Constants.QQ_SHARE_TEMP_DIR;
                } else {
                    File cacheDir = g.a().getCacheDir();
                    if (cacheDir == null) {
                        SLog.e("openSDK_LOG.Util", "getMediaFileUri error, cacheDir is null");
                        return null;
                    }
                    str3 = cacheDir.getAbsolutePath() + File.separator + Constants.QQ_SHARE_TEMP_DIR;
                }
                File file = new File(str2);
                String absolutePath = file.getAbsolutePath();
                String str4 = str3 + File.separator + file.getName();
                str2 = b(absolutePath, str4) ? str4 : null;
            }
            Uri a10 = a(activity, str, str2);
            if (a10 == null) {
                return null;
            }
            return a10.toString();
        } catch (Exception e10) {
            SLog.e("openSDK_LOG.Util", "getMediaFileUri error", e10);
            return null;
        }
    }

    public static boolean a(Map<String, Object> map, String str, boolean z5) {
        if (map == null) {
            SLog.e("openSDK_LOG.Util", "getBoolean error, params==null");
            return z5;
        }
        if (!map.containsKey(str)) {
            SLog.e("openSDK_LOG.Util", "getBoolean error, not comtain : " + str);
            return z5;
        }
        Object obj = map.get(str);
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z5;
    }

    public static String a(Map<String, Object> map, String str, String str2) {
        if (map == null) {
            SLog.e("openSDK_LOG.Util", "getString error, params==null");
            return str2;
        }
        if (!map.containsKey(str)) {
            SLog.e("openSDK_LOG.Util", "getString error, not comtain : " + str);
            return str2;
        }
        Object obj = map.get(str);
        return obj instanceof String ? (String) obj : str2;
    }

    public static Uri a(Activity activity, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            SLog.e("openSDK_LOG.Util", "grantUriPermissionToAllQQVersion -- stringForFileUri is empty");
            return null;
        }
        try {
            String authorities = Tencent.getAuthorities(str);
            if (TextUtils.isEmpty(authorities)) {
                return null;
            }
            Uri uriForFile = FileProvider.getUriForFile(activity, authorities, new File(str2));
            activity.grantUriPermission("com.tencent.mobileqq", uriForFile, 3);
            activity.grantUriPermission(Constants.PACKAGE_TIM, uriForFile, 3);
            activity.grantUriPermission(Constants.PACKAGE_QQ_PAD, uriForFile, 3);
            activity.grantUriPermission(Constants.PACKAGE_QQ_SPEED, uriForFile, 3);
            return uriForFile;
        } catch (Exception e10) {
            SLog.e("openSDK_LOG.Util", "grantUriPermissionToAllQQVersion exception:", e10);
            return null;
        }
    }
}
