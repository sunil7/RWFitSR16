package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.autonavi.aps.amapapi.config.Const;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class x2 {
    public static long a() {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return 0L;
        }
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return statFs.getFreeBlocks() * statFs.getBlockSize();
    }

    public static OfflineMapProvince b(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        OfflineMapProvince offlineMapProvince = new OfflineMapProvince();
        offlineMapProvince.setUrl(a(jSONObject, "url"));
        offlineMapProvince.setProvinceName(a(jSONObject, "name"));
        offlineMapProvince.setJianpin(a(jSONObject, "jianpin"));
        offlineMapProvince.setPinyin(a(jSONObject, "pinyin"));
        String a3 = a(jSONObject, Const.JSON_KEY_ADCODE);
        if ("000001".equals(a3)) {
            a3 = "100000";
        }
        offlineMapProvince.setProvinceCode(a3);
        offlineMapProvince.setVersion(a(jSONObject, "version"));
        offlineMapProvince.setSize(Long.parseLong(a(jSONObject, "size")));
        JSONArray optJSONArray = jSONObject.optJSONArray("cities");
        ArrayList<OfflineMapCity> arrayList = new ArrayList<>();
        if (optJSONArray != null) {
            if (optJSONArray.length() == 0) {
                arrayList.add(a(jSONObject));
            }
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    arrayList.add(a(optJSONObject));
                }
            }
        }
        offlineMapProvince.setCityList(arrayList);
        return offlineMapProvince;
    }

    public static List<OfflineMapProvince> a(JSONObject jSONObject, Context context) throws JSONException {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        ArrayList arrayList = new ArrayList();
        if (!jSONObject.has("result")) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("result", new JSONObject().put("offlinemap_with_province_vfour", jSONObject));
                b(jSONObject2.toString(), context);
                optJSONObject = jSONObject2.optJSONObject("result");
            } catch (JSONException e) {
                JSONObject optJSONObject3 = jSONObject.optJSONObject("result");
                ka.a(e, "Utility", "parseJson");
                e.printStackTrace();
                optJSONObject = optJSONObject3;
            }
        } else {
            optJSONObject = jSONObject.optJSONObject("result");
        }
        if (optJSONObject != null) {
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("offlinemap_with_province_vfour");
            if (optJSONObject4 != null) {
                optJSONObject2 = optJSONObject4.optJSONObject("offlinemapinfo_with_province");
            }
            return arrayList;
        }
        optJSONObject2 = jSONObject.optJSONObject("offlinemapinfo_with_province");
        if (optJSONObject2 != null) {
            if (optJSONObject2.has("version")) {
                a2.f3571q = a(optJSONObject2, "version");
            }
            JSONArray optJSONArray = optJSONObject2.optJSONArray("provinces");
            if (optJSONArray != null) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject optJSONObject5 = optJSONArray.optJSONObject(i3);
                    if (optJSONObject5 != null) {
                        arrayList.add(b(optJSONObject5));
                    }
                }
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("others");
                JSONObject jSONObject3 = (optJSONArray2 == null || optJSONArray2.length() <= 0) ? null : optJSONArray2.getJSONObject(0);
                if (jSONObject3 != null) {
                    arrayList.add(b(jSONObject3));
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    public static long b(File file) {
        long length;
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        long j4 = 0;
        if (listFiles == null) {
            return 0L;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                length = b(file2);
            } else {
                length = file2.length();
            }
            j4 = length + j4;
        }
        return j4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v19, types: [java.lang.String] */
    public static void b(String str, Context context) {
        FileOutputStream fileOutputStream;
        if ("".equals(v4.a(context))) {
            return;
        }
        File file = new File(v4.a(context) + "offlinemapv4.png");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                ka.a(e, "OfflineUpdateCityHandlerAbstract", "writeSD dirCreate");
                e.printStackTrace();
            }
        }
        if (a() > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            FileOutputStream fileOutputStream2 = null;
            fileOutputStream2 = null;
            fileOutputStream2 = null;
            fileOutputStream2 = null;
            try {
                try {
                    try {
                        fileOutputStream = new FileOutputStream(file);
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                } catch (FileNotFoundException e11) {
                    e = e11;
                } catch (IOException e12) {
                    e = e12;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                ?? r72 = "utf-8";
                fileOutputStream.write(str.getBytes("utf-8"));
                fileOutputStream.close();
                fileOutputStream2 = r72;
            } catch (FileNotFoundException e13) {
                e = e13;
                fileOutputStream2 = fileOutputStream;
                ka.a(e, "OfflineUpdateCityHandlerAbstract", "writeSD filenotfound");
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                    fileOutputStream2 = fileOutputStream2;
                }
            } catch (IOException e14) {
                e = e14;
                fileOutputStream2 = fileOutputStream;
                ka.a(e, "OfflineUpdateCityHandlerAbstract", "writeSD io");
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                    fileOutputStream2 = fileOutputStream2;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e15) {
                        e15.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }

    public static OfflineMapCity a(JSONObject jSONObject) throws JSONException {
        OfflineMapCity offlineMapCity = new OfflineMapCity();
        String a3 = a(jSONObject, Const.JSON_KEY_ADCODE);
        if ("000001".equals(a3)) {
            a3 = "100000";
        }
        offlineMapCity.setAdcode(a3);
        offlineMapCity.setUrl(a(jSONObject, "url"));
        offlineMapCity.setCity(a(jSONObject, "name"));
        offlineMapCity.setCode(a(jSONObject, Const.JSON_KEY_CITYCODE));
        offlineMapCity.setPinyin(a(jSONObject, "pinyin"));
        offlineMapCity.setJianpin(a(jSONObject, "jianpin"));
        offlineMapCity.setVersion(a(jSONObject, "version"));
        offlineMapCity.setSize(Long.parseLong(a(jSONObject, "size")));
        return offlineMapCity;
    }

    public static boolean a(File file) throws IOException, Exception {
        if (file == null || !file.exists()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (int i3 = 0; i3 < listFiles.length; i3++) {
                if (listFiles[i3].isFile()) {
                    if (!listFiles[i3].delete()) {
                        return false;
                    }
                } else if (!a(listFiles[i3])) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static String b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return str.substring(str.lastIndexOf("/") + 1, str.indexOf(".zip"));
        } catch (Throwable th2) {
            ka.a(th2, "Utility", "getZipFileNameFromUrl");
            return null;
        }
    }

    public static void a(String str, Context context) throws IOException, Exception {
        File[] listFiles = new File(v4.a(context)).listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            if (file.exists() && file.getName().contains(str)) {
                a(file);
            }
        }
        a(v4.a(context));
    }

    public static void a(String str) {
        File[] listFiles;
        File file = new File(str);
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.exists() && file2.isDirectory()) {
                    String[] list = file2.list();
                    if (list == null) {
                        file2.delete();
                    } else if (list.length == 0) {
                        file2.delete();
                    }
                }
            }
        }
    }

    public static String a(JSONObject jSONObject, String str) throws JSONException {
        return (jSONObject == null || !jSONObject.has(str) || HttpUrl.PATH_SEGMENT_ENCODE_SET_URI.equals(jSONObject.getString(str))) ? "" : jSONObject.optString(str).trim();
    }
}
