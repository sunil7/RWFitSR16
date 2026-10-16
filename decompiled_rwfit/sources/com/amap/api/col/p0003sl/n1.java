package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class n1 {

    /* renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<String, String> f4673a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f4674b = false;

    /* renamed from: c, reason: collision with root package name */
    private static Context f4675c;

    private static void a() {
        String str;
        int b3 = b9.b();
        if (b3 != 0) {
            switch (b3) {
                case 3:
                    str = "es";
                    break;
                case 4:
                    str = "pt";
                    break;
                case 5:
                    str = Const.SP_KEY_FIRSTLOC_RELOC;
                    break;
                case 6:
                    str = "de";
                    break;
                case 7:
                    str = "th";
                    break;
                case 8:
                    str = "ja";
                    break;
                case 9:
                    str = "ko";
                    break;
                case 10:
                    str = "ar";
                    break;
                case 11:
                    str = "tr";
                    break;
                case 12:
                    str = "he";
                    break;
                case 13:
                    str = "it";
                    break;
                case 14:
                    str = "ru";
                    break;
                case 15:
                    str = Const.SP_KEY_GSM_UPLOAD_MXSIZE;
                    break;
                case 16:
                    str = "id";
                    break;
                case 17:
                    str = "vi";
                    break;
                case 18:
                    str = "pl";
                    break;
                case 19:
                    str = "cs";
                    break;
                case 20:
                    str = "uk";
                    break;
                case 21:
                    str = "az";
                    break;
                default:
                    str = "en";
                    break;
            }
        } else {
            str = "zh-Hans";
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (n1.class) {
            try {
                if (f4674b) {
                    return;
                }
                f4673a.clear();
                try {
                } catch (Exception e) {
                    ka.a(e, "DynamicStringManager", "Initialization error)");
                }
                if (a(str)) {
                    f4674b = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static String a(int i3) {
        if (f4675c == null) {
            return null;
        }
        String string = a6.a().getString(i3);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        if (!f4674b) {
            a();
        }
        String str = f4673a.get(string);
        return (TextUtils.isEmpty(str) || !str.contains("\\n")) ? str : str.replace("\\n", "\n");
    }

    public static void a(Context context) {
        f4675c = context;
        if (f4674b) {
            return;
        }
        a();
    }

    private static boolean a(String str) {
        String str2;
        try {
            try {
                InputStream open = f4675c.getAssets().open("Localizable/strings/" + str + "/Localizable_map.strings");
                byte[] bArr = new byte[open.available()];
                open.read(bArr);
                str2 = new String(bArr, "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
                str2 = null;
            }
            for (String str3 : str2.split("\";")) {
                if (!str3.isEmpty()) {
                    int indexOf = str3.indexOf("\"");
                    int indexOf2 = str3.indexOf("\"=\"");
                    if (indexOf >= 0 && indexOf2 >= 0) {
                        String substring = str3.substring(indexOf + 1, indexOf2);
                        String substring2 = str3.substring(indexOf2 + 3);
                        if (!TextUtils.isEmpty(substring) && !TextUtils.isEmpty(substring2)) {
                            f4673a.put(substring, substring2);
                        }
                    }
                }
            }
            return true;
        } catch (Exception e10) {
            ka.a(e10, "DynamicStringManager", "loadLanguageFile error)");
            return false;
        }
    }
}
