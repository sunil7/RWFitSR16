package com.tencent.open.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.tauth.IRequestListener;
import java.io.CharConversionException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.NotActiveException;
import java.io.NotSerializableException;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.io.SyncFailedException;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.io.WriteAbortedException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileLockInterruptionException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.UnmappableCharacterException;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.Map;
import java.util.zip.ZipException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class HttpUtils {

    public static class NetworkUnavailableException extends Exception {
        public static final String ERROR_INFO = "network unavailable";

        public NetworkUnavailableException(String str) {
            super(str);
        }
    }

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f12079a;

        /* renamed from: b, reason: collision with root package name */
        public final int f12080b;

        private a(String str, int i3) {
            this.f12079a = str;
            this.f12080b = i3;
        }
    }

    private HttpUtils() {
    }

    private static void a(Context context, QQToken qQToken, String str) {
        if (str.indexOf("add_share") > -1 || str.indexOf("upload_pic") > -1 || str.indexOf("add_topic") > -1 || str.indexOf("set_user_face") > -1 || str.indexOf("add_t") > -1 || str.indexOf("add_pic_t") > -1 || str.indexOf("add_pic_url") > -1 || str.indexOf("add_video") > -1) {
            com.tencent.connect.a.a.a(context, qQToken, "requireApi", str);
        }
    }

    private static Map<String, byte[]> b(Bundle bundle) {
        HashMap hashMap = new HashMap(0);
        if (bundle != null && bundle.size() != 0) {
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof byte[]) {
                    hashMap.put(str, (byte[]) obj);
                }
            }
        }
        return hashMap;
    }

    public static String encodeUrl(Bundle bundle) {
        return encodeUrl(a(bundle));
    }

    public static int getErrorCodeFromException(IOException iOException) {
        if (iOException instanceof CharConversionException) {
            return -20;
        }
        if (iOException instanceof MalformedInputException) {
            return -21;
        }
        if (iOException instanceof UnmappableCharacterException) {
            return -22;
        }
        if (iOException instanceof ClosedChannelException) {
            return -24;
        }
        if (iOException instanceof EOFException) {
            return -26;
        }
        if (iOException instanceof FileLockInterruptionException) {
            return -27;
        }
        if (iOException instanceof FileNotFoundException) {
            return -28;
        }
        if (iOException instanceof HttpRetryException) {
            return -29;
        }
        if (iOException instanceof SocketTimeoutException) {
            return -8;
        }
        if (iOException instanceof InvalidPropertiesFormatException) {
            return -30;
        }
        if (iOException instanceof MalformedURLException) {
            return -3;
        }
        if (iOException instanceof InvalidClassException) {
            return -33;
        }
        if (iOException instanceof InvalidObjectException) {
            return -34;
        }
        if (iOException instanceof NotActiveException) {
            return -35;
        }
        if (iOException instanceof NotSerializableException) {
            return -36;
        }
        if (iOException instanceof OptionalDataException) {
            return -37;
        }
        if (iOException instanceof StreamCorruptedException) {
            return -38;
        }
        if (iOException instanceof WriteAbortedException) {
            return -39;
        }
        if (iOException instanceof ProtocolException) {
            return -40;
        }
        if (iOException instanceof SSLHandshakeException) {
            return -41;
        }
        if (iOException instanceof SSLKeyException) {
            return -42;
        }
        if (iOException instanceof SSLPeerUnverifiedException) {
            return -43;
        }
        if (iOException instanceof SSLProtocolException) {
            return -44;
        }
        if (iOException instanceof BindException) {
            return -45;
        }
        if (iOException instanceof ConnectException) {
            return -46;
        }
        if (iOException instanceof NoRouteToHostException) {
            return -47;
        }
        if (iOException instanceof PortUnreachableException) {
            return -48;
        }
        if (iOException instanceof SyncFailedException) {
            return -49;
        }
        if (iOException instanceof UTFDataFormatException) {
            return -50;
        }
        if (iOException instanceof UnknownHostException) {
            return -51;
        }
        if (iOException instanceof UnknownServiceException) {
            return -52;
        }
        if (iOException instanceof UnsupportedEncodingException) {
            return -53;
        }
        return iOException instanceof ZipException ? -54 : -2;
    }

    public static a getProxy(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo networkInfo;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return null;
        }
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Exception unused) {
            networkInfo = null;
        }
        if (networkInfo != null && networkInfo.getType() == 0) {
            String b3 = b(context);
            int a3 = a(context);
            if (!TextUtils.isEmpty(b3) && a3 >= 0) {
                return new a(b3, a3);
            }
        }
        return null;
    }

    public static JSONObject request(QQToken qQToken, Context context, String str, Bundle bundle, String str2) throws IOException, JSONException, NetworkUnavailableException, HttpStatusException {
        String str3;
        String str4;
        int i3;
        long j4;
        long j10;
        int i10;
        SLog.i("openSDK_LOG.HttpUtils", "OpenApi request");
        if (!m.b(context)) {
            throw new NetworkUnavailableException(NetworkUnavailableException.ERROR_INFO);
        }
        if (str.toLowerCase().startsWith("http")) {
            str3 = str;
            str4 = str3;
        } else {
            str3 = j.a().a(context, "https://openmobile.qq.com/") + str;
            str4 = j.a().a(context, "https://openmobile.qq.com/") + str;
        }
        a(context, qQToken, str);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int a3 = i.a(context, qQToken.getAppId()).a("Common_HttpRetryCount");
        StringBuilder q5 = android.support.v4.media.session.e.q(a3, "config 1:Common_HttpRetryCount            config_value:", "   appid:");
        q5.append(qQToken.getAppId());
        q5.append("     url:");
        q5.append(str4);
        SLog.v("OpenConfig_test", q5.toString());
        if (a3 == 0) {
            a3 = 3;
        }
        int i11 = a3;
        StringBuilder q8 = android.support.v4.media.session.e.q(i11, "config 1:Common_HttpRetryCount            result_value:", "   appid:");
        q8.append(qQToken.getAppId());
        q8.append("     url:");
        q8.append(str4);
        SLog.v("OpenConfig_test", q8.toString());
        int i12 = 0;
        JSONObject jSONObject = null;
        while (true) {
            int i13 = i12 + 1;
            try {
                try {
                    try {
                        com.tencent.open.a.g a10 = a(str3, str2, bundle);
                        int d5 = a10.d();
                        SLog.i("openSDK_LOG.HttpUtils", "request statusCode " + d5);
                        if (d5 != 200) {
                            com.tencent.open.b.h.a().a(str4, elapsedRealtime, 0L, 0L, d5);
                            throw new HttpStatusException(d5);
                        }
                        JSONObject d8 = m.d(a10.a());
                        try {
                            try {
                                i10 = d8.getInt("ret");
                            } catch (JSONException unused) {
                                i10 = -4;
                            }
                            jSONObject = d8;
                            i3 = i10;
                            j4 = a10.c();
                            j10 = a10.b();
                            break;
                        } catch (SocketTimeoutException e) {
                            e = e;
                            jSONObject = d8;
                            e.printStackTrace();
                            i3 = -8;
                            j4 = 0;
                            j10 = 0;
                            if (i13 >= i11) {
                                com.tencent.open.b.h.a().a(str4, elapsedRealtime, 0L, 0L, -8);
                                throw e;
                            }
                            elapsedRealtime = SystemClock.elapsedRealtime();
                            if (i13 >= i11) {
                                com.tencent.open.b.h.a().a(str4, elapsedRealtime, j4, j10, i3);
                                return jSONObject;
                            }
                            i12 = i13;
                        }
                    } catch (JSONException e10) {
                        e10.printStackTrace();
                        com.tencent.open.b.h.a().a(str4, elapsedRealtime, 0L, 0L, -4);
                        throw e10;
                    }
                } catch (SocketTimeoutException e11) {
                    e = e11;
                }
                i12 = i13;
            } catch (MalformedURLException e12) {
                e12.printStackTrace();
                com.tencent.open.b.h.a().a(str4, elapsedRealtime, 0L, 0L, -3);
                throw e12;
            } catch (IOException e13) {
                e13.printStackTrace();
                com.tencent.open.b.h.a().a(str4, elapsedRealtime, 0L, 0L, getErrorCodeFromException(e13));
                throw e13;
            }
        }
        com.tencent.open.b.h.a().a(str4, elapsedRealtime, j4, j10, i3);
        return jSONObject;
    }

    public static void requestAsync(final QQToken qQToken, final Context context, final String str, final Bundle bundle, final String str2, final IRequestListener iRequestListener) {
        SLog.i("openSDK_LOG.HttpUtils", "OpenApi requestAsync");
        l.a(new Runnable() { // from class: com.tencent.open.utils.HttpUtils.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject request = HttpUtils.request(QQToken.this, context, str, bundle, str2);
                    IRequestListener iRequestListener2 = iRequestListener;
                    if (iRequestListener2 != null) {
                        iRequestListener2.onComplete(request);
                        SLog.i("openSDK_LOG.HttpUtils", "OpenApi onComplete");
                    }
                } catch (HttpStatusException e) {
                    IRequestListener iRequestListener3 = iRequestListener;
                    if (iRequestListener3 != null) {
                        iRequestListener3.onHttpStatusException(e);
                        SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync onHttpStatusException" + e.toString());
                    }
                } catch (NetworkUnavailableException e10) {
                    IRequestListener iRequestListener4 = iRequestListener;
                    if (iRequestListener4 != null) {
                        iRequestListener4.onNetworkUnavailableException(e10);
                        SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync onNetworkUnavailableException" + e10.toString());
                    }
                } catch (MalformedURLException e11) {
                    IRequestListener iRequestListener5 = iRequestListener;
                    if (iRequestListener5 != null) {
                        iRequestListener5.onMalformedURLException(e11);
                        SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync MalformedURLException" + e11.toString());
                    }
                } catch (SocketTimeoutException e12) {
                    IRequestListener iRequestListener6 = iRequestListener;
                    if (iRequestListener6 != null) {
                        iRequestListener6.onSocketTimeoutException(e12);
                        SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync onSocketTimeoutException" + e12.toString());
                    }
                } catch (IOException e13) {
                    IRequestListener iRequestListener7 = iRequestListener;
                    if (iRequestListener7 != null) {
                        iRequestListener7.onIOException(e13);
                        SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync IOException" + e13.toString());
                    }
                } catch (JSONException e14) {
                    IRequestListener iRequestListener8 = iRequestListener;
                    if (iRequestListener8 != null) {
                        iRequestListener8.onJSONException(e14);
                        SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync JSONException" + e14.toString());
                    }
                } catch (Exception e15) {
                    IRequestListener iRequestListener9 = iRequestListener;
                    if (iRequestListener9 != null) {
                        iRequestListener9.onUnknowException(e15);
                        SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync onUnknowException" + e15.toString());
                    }
                }
            }
        });
    }

    public static class HttpStatusException extends Exception {
        public static final String ERROR_INFO = "http status code error:";
        public final int statusCode;

        public HttpStatusException(String str) {
            super(str);
            this.statusCode = -1;
        }

        public HttpStatusException(int i3) {
            super(l0.j(i3, ERROR_INFO));
            this.statusCode = i3;
        }
    }

    public static String encodeUrl(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            StringBuilder sb2 = new StringBuilder();
            boolean z5 = true;
            for (String str : map.keySet()) {
                if (z5) {
                    z5 = false;
                } else {
                    sb2.append(Const.STR_MART_ADD);
                }
                sb2.append(URLEncoder.encode(str));
                sb2.append("=");
                sb2.append(URLEncoder.encode(map.get(str)));
            }
            return sb2.toString();
        }
        return "";
    }

    private static String b(Context context) {
        return System.getProperty("http.proxyHost");
    }

    private static com.tencent.open.a.g a(String str, String str2, Bundle bundle) throws IOException {
        Bundle bundle2;
        if (bundle != null) {
            bundle2 = new Bundle(bundle);
        } else {
            bundle2 = new Bundle();
        }
        if (str2.equalsIgnoreCase(Constants.HTTP_GET)) {
            Map<String, String> a3 = a(bundle2);
            Bundle b3 = com.tencent.open.log.d.b(bundle2);
            if (b3 != bundle2) {
                SLog.i("openSDK_LOG.HttpUtils", "-->openUrl encodedParam =" + b3.toString() + " -- url = " + str);
            } else {
                SLog.i("openSDK_LOG.HttpUtils", "-->openUrl encodedParam =" + a3.toString() + " -- url = " + str);
            }
            return com.tencent.open.a.f.a().a(str, a3);
        }
        if (str2.equalsIgnoreCase(Constants.HTTP_POST)) {
            Map<String, String> a10 = a(bundle2);
            Map<String, byte[]> b10 = b(bundle2);
            if (b10 != null && b10.size() != 0) {
                SLog.w("openSDK_LOG.HttpUtils", "openUrl: has binary " + b10.size());
                return com.tencent.open.a.f.a().a(str, a10, b10);
            }
            return com.tencent.open.a.f.a().b(str, a10);
        }
        SLog.e("openSDK_LOG.HttpUtils", "openUrl: http method " + str2 + " is not supported.");
        throw new IOException("http method is not supported.");
    }

    private static Map<String, String> a(Bundle bundle) {
        HashMap hashMap = new HashMap();
        if (bundle != null && bundle.size() != 0) {
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (!(obj instanceof String) && !(obj instanceof String[])) {
                    SLog.w("openSDK_LOG.HttpUtils", "parseBundleToMap: the type " + obj.getClass() + " is unsupported");
                } else if (obj instanceof String[]) {
                    String[] strArr = (String[]) obj;
                    StringBuilder sb2 = new StringBuilder();
                    for (int i3 = 0; i3 < strArr.length; i3++) {
                        if (i3 != 0) {
                            sb2.append(Const.STR_MART_COMMA);
                        }
                        sb2.append(strArr[i3]);
                    }
                    hashMap.put(str, sb2.toString());
                } else {
                    hashMap.put(str, (String) obj);
                }
            }
        }
        return hashMap;
    }

    private static int a(Context context) {
        String property = System.getProperty("http.proxyPort");
        if (TextUtils.isEmpty(property)) {
            return -1;
        }
        try {
            return Integer.parseInt(property);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }
}
