package com.amap.api.col.p0003sl;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.support.v4.media.session.e;
import android.text.TextUtils;
import android.util.Base64;
import android.view.SurfaceHolder;
import com.amap.api.col.p0003sl.pc;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;
import com.davemorrissey.labs.subscaleview.BuildConfig;
import java.net.URLEncoder;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class x {
    public static qc a(int i3, int i10, BlockingQueue<Runnable> blockingQueue, String str) {
        return qc.a(new pc.a().a(i3).b(i10).a(blockingQueue).a(str).a());
    }

    public static qc b(String str) {
        return qc.a(new pc.a().a(str).a());
    }

    public static String c(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLEncoder.encode(str, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void b(Context context, String str, String str2, Object obj) {
        String simpleName = obj.getClass().getSimpleName();
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        if ("String".equals(simpleName)) {
            edit.putString(str2, (String) obj);
        } else if ("Integer".equals(simpleName)) {
            edit.putInt(str2, ((Integer) obj).intValue());
        } else if ("Boolean".equals(simpleName)) {
            edit.putBoolean(str2, ((Boolean) obj).booleanValue());
        } else if ("Float".equals(simpleName)) {
            edit.putFloat(str2, ((Float) obj).floatValue());
        } else if ("Long".equals(simpleName)) {
            edit.putLong(str2, ((Long) obj).longValue());
        }
        edit.commit();
    }

    public static void c(Context context, String str, String str2, Object obj) {
        String simpleName = obj.getClass().getSimpleName();
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        if ("String".equals(simpleName)) {
            edit.putString(str2, (String) obj);
        } else if ("Integer".equals(simpleName)) {
            edit.putInt(str2, ((Integer) obj).intValue());
        } else if ("Boolean".equals(simpleName)) {
            edit.putBoolean(str2, ((Boolean) obj).booleanValue());
        } else if ("Float".equals(simpleName)) {
            edit.putFloat(str2, ((Float) obj).floatValue());
        } else if ("Long".equals(simpleName)) {
            edit.putLong(str2, ((Long) obj).longValue());
        }
        edit.commit();
    }

    public static AbstractCameraUpdateMessage a() {
        l1 l1Var = new l1();
        l1Var.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
        l1Var.amount = -1.0f;
        return l1Var;
    }

    public static void a(IGLSurfaceView iGLSurfaceView, int i3, int i10, int i11, int i12, int i13, int i14) {
        SurfaceHolder holder;
        if (i12 > 0 && (holder = iGLSurfaceView.getHolder()) != null) {
            holder.setFormat(-3);
        }
        iGLSurfaceView.setEGLContextFactory(new k4());
        iGLSurfaceView.setEGLConfigChooser(new j4(i3, i10, i11, i12, i13, i14));
    }

    public static PublicKey a(String str) throws Exception {
        try {
            return KeyFactory.getInstance(n9.b("EUlNB")).generatePublic(new X509EncodedKeySpec(x9.a(str)));
        } catch (NullPointerException unused) {
            throw new Exception("公钥数据为空");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException unused3) {
            throw new Exception("公钥非法");
        }
    }

    public static String a(String str, String str2, String str3) throws Exception {
        byte[] bArr;
        String str4 = str.toUpperCase() + "&%2F&" + c(str2);
        String l3 = e.l(str3, Const.STR_MART_ADD);
        String str5 = null;
        if (TextUtils.isEmpty(l3) || TextUtils.isEmpty(str4)) {
            bArr = null;
        } else {
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(new SecretKeySpec(l3.getBytes("UTF-8"), "UTF-8"));
            bArr = mac.doFinal(str4.getBytes("UTF-8"));
        }
        if (bArr != null && bArr.length != 0) {
            str5 = Base64.encodeToString(bArr, 0);
        }
        return str5.replace("=", "%3D");
    }

    public static AbstractCameraUpdateMessage a(float f2, Point point) {
        l1 l1Var = new l1();
        l1Var.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
        l1Var.amount = f2;
        l1Var.focus = point;
        return l1Var;
    }

    public static Object a(Context context, String str, String str2, Object obj) {
        String simpleName = obj.getClass().getSimpleName();
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        if ("String".equals(simpleName)) {
            return sharedPreferences.getString(str2, (String) obj);
        }
        if ("Integer".equals(simpleName)) {
            return Integer.valueOf(sharedPreferences.getInt(str2, ((Integer) obj).intValue()));
        }
        if ("Boolean".equals(simpleName)) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str2, ((Boolean) obj).booleanValue()));
        }
        if ("Float".equals(simpleName)) {
            return Float.valueOf(sharedPreferences.getFloat(str2, ((Float) obj).floatValue()));
        }
        if ("Long".equals(simpleName)) {
            return Long.valueOf(sharedPreferences.getLong(str2, ((Long) obj).longValue()));
        }
        return null;
    }

    public static String a(Map<String, String> map, String str) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("AccessKeyId", str);
        treeMap.put("SignatureMethod", "HMAC-SHA1");
        treeMap.put("SignatureVersion", BuildConfig.VERSION_NAME);
        treeMap.put("SignatureNonce", UUID.randomUUID().toString());
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        treeMap.put("Timestamp", simpleDateFormat.format(date));
        treeMap.putAll(map);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : treeMap.entrySet()) {
            arrayList.add(((String) entry.getKey()) + "=" + c((String) entry.getValue()));
        }
        StringBuilder sb2 = new StringBuilder("");
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            sb2.append((String) obj);
            sb2.append(Const.STR_MART_ADD);
        }
        return sb2.toString().substring(0, r4.length() - 1);
    }

    public static AbstractCameraUpdateMessage a(CameraPosition cameraPosition) {
        LatLng latLng;
        j1 j1Var = new j1();
        j1Var.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        if (cameraPosition != null && (latLng = cameraPosition.target) != null) {
            DPoint latLongToPixelsDouble = VirtualEarthProjection.latLongToPixelsDouble(latLng.latitude, latLng.longitude, 20);
            j1Var.geoPoint = new DPoint(latLongToPixelsDouble.f6570x, latLongToPixelsDouble.f6571y);
            j1Var.zoom = cameraPosition.zoom;
            j1Var.bearing = cameraPosition.bearing;
            j1Var.tilt = cameraPosition.tilt;
            j1Var.cameraPosition = cameraPosition;
        }
        return j1Var;
    }

    public static AbstractCameraUpdateMessage a(Point point) {
        j1 j1Var = new j1();
        j1Var.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        j1Var.geoPoint = new DPoint(point.x, point.y);
        return j1Var;
    }

    public static AbstractCameraUpdateMessage a(float f2) {
        j1 j1Var = new j1();
        j1Var.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        j1Var.bearing = f2;
        return j1Var;
    }
}
