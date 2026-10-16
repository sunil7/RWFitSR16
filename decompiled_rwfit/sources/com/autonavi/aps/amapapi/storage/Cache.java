package com.autonavi.aps.amapapi.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.h9;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.autonavi.aps.amapapi.restruct.Cgi;
import com.autonavi.aps.amapapi.security.Encrypt;
import com.autonavi.aps.amapapi.utils.AuthUtil;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.autonavi.aps.amapapi.utils.Utils;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Hashtable;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Cache {

    /* renamed from: a, reason: collision with root package name */
    Hashtable<String, ArrayList<Item>> f6734a = new Hashtable<>();

    /* renamed from: b, reason: collision with root package name */
    private long f6735b = 0;

    /* renamed from: c, reason: collision with root package name */
    private boolean f6736c = false;

    /* renamed from: d, reason: collision with root package name */
    private String f6737d = Const.STR_VER.replace(".", "");
    private String e = null;

    /* renamed from: f, reason: collision with root package name */
    boolean f6738f = true;

    /* renamed from: g, reason: collision with root package name */
    long f6739g = 0;

    /* renamed from: h, reason: collision with root package name */
    String f6740h = null;

    /* renamed from: i, reason: collision with root package name */
    Cgi f6741i = null;

    /* renamed from: j, reason: collision with root package name */
    private String f6742j = null;

    /* renamed from: k, reason: collision with root package name */
    private long f6743k = 0;

    /* renamed from: l, reason: collision with root package name */
    boolean f6744l = true;

    /* renamed from: m, reason: collision with root package name */
    boolean f6745m = true;

    /* renamed from: n, reason: collision with root package name */
    String f6746n = String.valueOf(AMapLocationClientOption.GeoLanguage.DEFAULT);

    /* renamed from: com.autonavi.aps.amapapi.storage.Cache$1, reason: invalid class name */
    class AnonymousClass1 implements Comparator<Object> {
        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            try {
                throw null;
            } catch (Throwable th2) {
                CoreUtil.reportError(th2, "Cache", "print");
                return 0;
            }
        }
    }

    public static class Item {

        /* renamed from: a, reason: collision with root package name */
        private AMapLocationServer f6747a = null;

        /* renamed from: b, reason: collision with root package name */
        private String f6748b = null;

        public AMapLocationServer getAmapLoc() {
            return this.f6747a;
        }

        public String getNb() {
            return this.f6748b;
        }

        public void setAmapLoc(AMapLocationServer aMapLocationServer) {
            this.f6747a = aMapLocationServer;
        }

        public void setNb(String str) {
            if (TextUtils.isEmpty(str)) {
                this.f6748b = null;
            } else {
                this.f6748b = str.replace("##", Const.STR_MART_WELL);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x008d A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x0012, B:10:0x001a, B:12:0x0022, B:14:0x0030, B:16:0x004a, B:18:0x0054, B:20:0x0066, B:23:0x0071, B:25:0x0075, B:27:0x007b, B:28:0x0087, B:30:0x008d, B:31:0x0091, B:36:0x0044), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.autonavi.aps.amapapi.model.AMapLocationServer a(java.lang.String r5, java.lang.StringBuilder r6, boolean r7) {
        /*
            r4 = this;
            r0 = 0
            java.lang.String r1 = "cgiwifi"
            boolean r1 = r5.contains(r1)     // Catch: java.lang.Throwable -> L40
            if (r1 != 0) goto L44
            java.lang.String r1 = "wifi"
            boolean r1 = r5.contains(r1)     // Catch: java.lang.Throwable -> L40
            if (r1 == 0) goto L12
            goto L44
        L12:
            java.lang.String r6 = "cgi"
            boolean r6 = r5.contains(r6)     // Catch: java.lang.Throwable -> L40
            if (r6 == 0) goto L42
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.autonavi.aps.amapapi.storage.Cache$Item>> r6 = r4.f6734a     // Catch: java.lang.Throwable -> L40
            boolean r6 = r6.containsKey(r5)     // Catch: java.lang.Throwable -> L40
            if (r6 == 0) goto L42
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.autonavi.aps.amapapi.storage.Cache$Item>> r6 = r4.f6734a     // Catch: java.lang.Throwable -> L40
            java.lang.Object r6 = r6.get(r5)     // Catch: java.lang.Throwable -> L40
            java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch: java.lang.Throwable -> L40
            int r6 = r6.size()     // Catch: java.lang.Throwable -> L40
            if (r6 <= 0) goto L42
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.autonavi.aps.amapapi.storage.Cache$Item>> r6 = r4.f6734a     // Catch: java.lang.Throwable -> L40
            java.lang.Object r6 = r6.get(r5)     // Catch: java.lang.Throwable -> L40
            java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch: java.lang.Throwable -> L40
            r1 = 0
            java.lang.Object r6 = r6.get(r1)     // Catch: java.lang.Throwable -> L40
            com.autonavi.aps.amapapi.storage.Cache$Item r6 = (com.autonavi.aps.amapapi.storage.Cache.Item) r6     // Catch: java.lang.Throwable -> L40
            goto L48
        L40:
            r5 = move-exception
            goto L96
        L42:
            r6 = r0
            goto L48
        L44:
            com.autonavi.aps.amapapi.storage.Cache$Item r6 = r4.a(r6, r5)     // Catch: java.lang.Throwable -> L40
        L48:
            if (r6 == 0) goto L9d
            com.autonavi.aps.amapapi.model.AMapLocationServer r1 = r6.getAmapLoc()     // Catch: java.lang.Throwable -> L40
            boolean r1 = com.autonavi.aps.amapapi.utils.Utils.locCorrect(r1)     // Catch: java.lang.Throwable -> L40
            if (r1 == 0) goto L9d
            com.autonavi.aps.amapapi.model.AMapLocationServer r1 = r6.getAmapLoc()     // Catch: java.lang.Throwable -> L40
            java.lang.String r2 = "mem"
            r1.setCacheType(r2)     // Catch: java.lang.Throwable -> L40
            java.lang.String r2 = r6.getNb()     // Catch: java.lang.Throwable -> L40
            r1.setNb(r2)     // Catch: java.lang.Throwable -> L40
            if (r7 != 0) goto L87
            long r2 = r1.getTime()     // Catch: java.lang.Throwable -> L40
            boolean r7 = com.autonavi.aps.amapapi.utils.AuthUtil.isCacheAble(r2)     // Catch: java.lang.Throwable -> L40
            if (r7 == 0) goto L71
            goto L87
        L71:
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.autonavi.aps.amapapi.storage.Cache$Item>> r7 = r4.f6734a     // Catch: java.lang.Throwable -> L40
            if (r7 == 0) goto L9d
            boolean r7 = r7.containsKey(r5)     // Catch: java.lang.Throwable -> L40
            if (r7 == 0) goto L9d
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.autonavi.aps.amapapi.storage.Cache$Item>> r7 = r4.f6734a     // Catch: java.lang.Throwable -> L40
            java.lang.Object r5 = r7.get(r5)     // Catch: java.lang.Throwable -> L40
            java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch: java.lang.Throwable -> L40
            r5.remove(r6)     // Catch: java.lang.Throwable -> L40
            goto L9d
        L87:
            boolean r5 = com.autonavi.aps.amapapi.utils.Utils.locCorrect(r1)     // Catch: java.lang.Throwable -> L40
            if (r5 == 0) goto L91
            r5 = 0
            r4.f6739g = r5     // Catch: java.lang.Throwable -> L40
        L91:
            r5 = 4
            r1.setLocationType(r5)     // Catch: java.lang.Throwable -> L40
            return r1
        L96:
            java.lang.String r6 = "Cache"
            java.lang.String r7 = "get1"
            com.autonavi.aps.amapapi.utils.CoreUtil.reportError(r5, r6, r7)
        L9d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.storage.Cache.a(java.lang.String, java.lang.StringBuilder, boolean):com.autonavi.aps.amapapi.model.AMapLocationServer");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a0 A[Catch: all -> 0x005e, TryCatch #1 {all -> 0x005e, blocks: (B:3:0x000e, B:8:0x0016, B:11:0x0049, B:14:0x0050, B:17:0x0057, B:21:0x0066, B:23:0x0072, B:25:0x007e, B:28:0x008e, B:32:0x009a, B:34:0x00a0, B:35:0x00a3, B:37:0x00ad, B:38:0x00b3, B:41:0x00bf, B:45:0x00c7, B:47:0x00d1, B:49:0x00de, B:51:0x00e6, B:53:0x00e8, B:60:0x00fd, B:62:0x0103, B:64:0x010d, B:66:0x011b, B:67:0x0146, B:69:0x0150, B:73:0x0160, B:76:0x017a, B:78:0x0185, B:86:0x01a7, B:90:0x0191, B:91:0x0176, B:92:0x00f1, B:96:0x0128, B:99:0x0130, B:104:0x013b, B:82:0x01a2), top: B:2:0x000e, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ad A[Catch: all -> 0x005e, TryCatch #1 {all -> 0x005e, blocks: (B:3:0x000e, B:8:0x0016, B:11:0x0049, B:14:0x0050, B:17:0x0057, B:21:0x0066, B:23:0x0072, B:25:0x007e, B:28:0x008e, B:32:0x009a, B:34:0x00a0, B:35:0x00a3, B:37:0x00ad, B:38:0x00b3, B:41:0x00bf, B:45:0x00c7, B:47:0x00d1, B:49:0x00de, B:51:0x00e6, B:53:0x00e8, B:60:0x00fd, B:62:0x0103, B:64:0x010d, B:66:0x011b, B:67:0x0146, B:69:0x0150, B:73:0x0160, B:76:0x017a, B:78:0x0185, B:86:0x01a7, B:90:0x0191, B:91:0x0176, B:92:0x00f1, B:96:0x0128, B:99:0x0130, B:104:0x013b, B:82:0x01a2), top: B:2:0x000e, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bf A[Catch: all -> 0x005e, TRY_ENTER, TryCatch #1 {all -> 0x005e, blocks: (B:3:0x000e, B:8:0x0016, B:11:0x0049, B:14:0x0050, B:17:0x0057, B:21:0x0066, B:23:0x0072, B:25:0x007e, B:28:0x008e, B:32:0x009a, B:34:0x00a0, B:35:0x00a3, B:37:0x00ad, B:38:0x00b3, B:41:0x00bf, B:45:0x00c7, B:47:0x00d1, B:49:0x00de, B:51:0x00e6, B:53:0x00e8, B:60:0x00fd, B:62:0x0103, B:64:0x010d, B:66:0x011b, B:67:0x0146, B:69:0x0150, B:73:0x0160, B:76:0x017a, B:78:0x0185, B:86:0x01a7, B:90:0x0191, B:91:0x0176, B:92:0x00f1, B:96:0x0128, B:99:0x0130, B:104:0x013b, B:82:0x01a2), top: B:2:0x000e, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0185 A[Catch: all -> 0x005e, TryCatch #1 {all -> 0x005e, blocks: (B:3:0x000e, B:8:0x0016, B:11:0x0049, B:14:0x0050, B:17:0x0057, B:21:0x0066, B:23:0x0072, B:25:0x007e, B:28:0x008e, B:32:0x009a, B:34:0x00a0, B:35:0x00a3, B:37:0x00ad, B:38:0x00b3, B:41:0x00bf, B:45:0x00c7, B:47:0x00d1, B:49:0x00de, B:51:0x00e6, B:53:0x00e8, B:60:0x00fd, B:62:0x0103, B:64:0x010d, B:66:0x011b, B:67:0x0146, B:69:0x0150, B:73:0x0160, B:76:0x017a, B:78:0x0185, B:86:0x01a7, B:90:0x0191, B:91:0x0176, B:92:0x00f1, B:96:0x0128, B:99:0x0130, B:104:0x013b, B:82:0x01a2), top: B:2:0x000e, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0191 A[Catch: all -> 0x005e, TRY_LEAVE, TryCatch #1 {all -> 0x005e, blocks: (B:3:0x000e, B:8:0x0016, B:11:0x0049, B:14:0x0050, B:17:0x0057, B:21:0x0066, B:23:0x0072, B:25:0x007e, B:28:0x008e, B:32:0x009a, B:34:0x00a0, B:35:0x00a3, B:37:0x00ad, B:38:0x00b3, B:41:0x00bf, B:45:0x00c7, B:47:0x00d1, B:49:0x00de, B:51:0x00e6, B:53:0x00e8, B:60:0x00fd, B:62:0x0103, B:64:0x010d, B:66:0x011b, B:67:0x0146, B:69:0x0150, B:73:0x0160, B:76:0x017a, B:78:0x0185, B:86:0x01a7, B:90:0x0191, B:91:0x0176, B:92:0x00f1, B:96:0x0128, B:99:0x0130, B:104:0x013b, B:82:0x01a2), top: B:2:0x000e, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0176 A[Catch: all -> 0x005e, TryCatch #1 {all -> 0x005e, blocks: (B:3:0x000e, B:8:0x0016, B:11:0x0049, B:14:0x0050, B:17:0x0057, B:21:0x0066, B:23:0x0072, B:25:0x007e, B:28:0x008e, B:32:0x009a, B:34:0x00a0, B:35:0x00a3, B:37:0x00ad, B:38:0x00b3, B:41:0x00bf, B:45:0x00c7, B:47:0x00d1, B:49:0x00de, B:51:0x00e6, B:53:0x00e8, B:60:0x00fd, B:62:0x0103, B:64:0x010d, B:66:0x011b, B:67:0x0146, B:69:0x0150, B:73:0x0160, B:76:0x017a, B:78:0x0185, B:86:0x01a7, B:90:0x0191, B:91:0x0176, B:92:0x00f1, B:96:0x0128, B:99:0x0130, B:104:0x013b, B:82:0x01a2), top: B:2:0x000e, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0128 A[Catch: all -> 0x005e, TryCatch #1 {all -> 0x005e, blocks: (B:3:0x000e, B:8:0x0016, B:11:0x0049, B:14:0x0050, B:17:0x0057, B:21:0x0066, B:23:0x0072, B:25:0x007e, B:28:0x008e, B:32:0x009a, B:34:0x00a0, B:35:0x00a3, B:37:0x00ad, B:38:0x00b3, B:41:0x00bf, B:45:0x00c7, B:47:0x00d1, B:49:0x00de, B:51:0x00e6, B:53:0x00e8, B:60:0x00fd, B:62:0x0103, B:64:0x010d, B:66:0x011b, B:67:0x0146, B:69:0x0150, B:73:0x0160, B:76:0x017a, B:78:0x0185, B:86:0x01a7, B:90:0x0191, B:91:0x0176, B:92:0x00f1, B:96:0x0128, B:99:0x0130, B:104:0x013b, B:82:0x01a2), top: B:2:0x000e, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void add(java.lang.String r15, java.lang.StringBuilder r16, com.autonavi.aps.amapapi.model.AMapLocationServer r17, android.content.Context r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 431
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.storage.Cache.add(java.lang.String, java.lang.StringBuilder, com.autonavi.aps.amapapi.model.AMapLocationServer, android.content.Context, boolean):void");
    }

    public void b() {
        this.f6735b = 0L;
        if (!this.f6734a.isEmpty()) {
            this.f6734a.clear();
        }
        this.f6736c = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0047 A[Catch: all -> 0x0108, TryCatch #0 {all -> 0x0108, blocks: (B:16:0x002b, B:18:0x0033, B:22:0x0047, B:29:0x0066, B:33:0x006e, B:35:0x007c, B:41:0x00a1, B:42:0x00aa, B:44:0x00ae, B:46:0x00b4, B:48:0x00bf, B:51:0x00e3, B:53:0x00f1, B:61:0x0101, B:66:0x00c3, B:67:0x00cc, B:69:0x00d0, B:70:0x00d9, B:71:0x00a8, B:72:0x008e, B:74:0x0094, B:79:0x0037, B:81:0x003b), top: B:15:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0066 A[Catch: all -> 0x0108, TryCatch #0 {all -> 0x0108, blocks: (B:16:0x002b, B:18:0x0033, B:22:0x0047, B:29:0x0066, B:33:0x006e, B:35:0x007c, B:41:0x00a1, B:42:0x00aa, B:44:0x00ae, B:46:0x00b4, B:48:0x00bf, B:51:0x00e3, B:53:0x00f1, B:61:0x0101, B:66:0x00c3, B:67:0x00cc, B:69:0x00d0, B:70:0x00d9, B:71:0x00a8, B:72:0x008e, B:74:0x0094, B:79:0x0037, B:81:0x003b), top: B:15:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a1 A[Catch: all -> 0x0108, TryCatch #0 {all -> 0x0108, blocks: (B:16:0x002b, B:18:0x0033, B:22:0x0047, B:29:0x0066, B:33:0x006e, B:35:0x007c, B:41:0x00a1, B:42:0x00aa, B:44:0x00ae, B:46:0x00b4, B:48:0x00bf, B:51:0x00e3, B:53:0x00f1, B:61:0x0101, B:66:0x00c3, B:67:0x00cc, B:69:0x00d0, B:70:0x00d9, B:71:0x00a8, B:72:0x008e, B:74:0x0094, B:79:0x0037, B:81:0x003b), top: B:15:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ae A[Catch: all -> 0x0108, TryCatch #0 {all -> 0x0108, blocks: (B:16:0x002b, B:18:0x0033, B:22:0x0047, B:29:0x0066, B:33:0x006e, B:35:0x007c, B:41:0x00a1, B:42:0x00aa, B:44:0x00ae, B:46:0x00b4, B:48:0x00bf, B:51:0x00e3, B:53:0x00f1, B:61:0x0101, B:66:0x00c3, B:67:0x00cc, B:69:0x00d0, B:70:0x00d9, B:71:0x00a8, B:72:0x008e, B:74:0x0094, B:79:0x0037, B:81:0x003b), top: B:15:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f1 A[Catch: all -> 0x0108, TryCatch #0 {all -> 0x0108, blocks: (B:16:0x002b, B:18:0x0033, B:22:0x0047, B:29:0x0066, B:33:0x006e, B:35:0x007c, B:41:0x00a1, B:42:0x00aa, B:44:0x00ae, B:46:0x00b4, B:48:0x00bf, B:51:0x00e3, B:53:0x00f1, B:61:0x0101, B:66:0x00c3, B:67:0x00cc, B:69:0x00d0, B:70:0x00d9, B:71:0x00a8, B:72:0x008e, B:74:0x0094, B:79:0x0037, B:81:0x003b), top: B:15:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00fb A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d0 A[Catch: all -> 0x0108, TryCatch #0 {all -> 0x0108, blocks: (B:16:0x002b, B:18:0x0033, B:22:0x0047, B:29:0x0066, B:33:0x006e, B:35:0x007c, B:41:0x00a1, B:42:0x00aa, B:44:0x00ae, B:46:0x00b4, B:48:0x00bf, B:51:0x00e3, B:53:0x00f1, B:61:0x0101, B:66:0x00c3, B:67:0x00cc, B:69:0x00d0, B:70:0x00d9, B:71:0x00a8, B:72:0x008e, B:74:0x0094, B:79:0x0037, B:81:0x003b), top: B:15:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d9 A[Catch: all -> 0x0108, TryCatch #0 {all -> 0x0108, blocks: (B:16:0x002b, B:18:0x0033, B:22:0x0047, B:29:0x0066, B:33:0x006e, B:35:0x007c, B:41:0x00a1, B:42:0x00aa, B:44:0x00ae, B:46:0x00b4, B:48:0x00bf, B:51:0x00e3, B:53:0x00f1, B:61:0x0101, B:66:0x00c3, B:67:0x00cc, B:69:0x00d0, B:70:0x00d9, B:71:0x00a8, B:72:0x008e, B:74:0x0094, B:79:0x0037, B:81:0x003b), top: B:15:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00a8 A[Catch: all -> 0x0108, TryCatch #0 {all -> 0x0108, blocks: (B:16:0x002b, B:18:0x0033, B:22:0x0047, B:29:0x0066, B:33:0x006e, B:35:0x007c, B:41:0x00a1, B:42:0x00aa, B:44:0x00ae, B:46:0x00b4, B:48:0x00bf, B:51:0x00e3, B:53:0x00f1, B:61:0x0101, B:66:0x00c3, B:67:0x00cc, B:69:0x00d0, B:70:0x00d9, B:71:0x00a8, B:72:0x008e, B:74:0x0094, B:79:0x0037, B:81:0x003b), top: B:15:0x002b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.autonavi.aps.amapapi.model.AMapLocationServer checkCache(com.autonavi.aps.amapapi.restruct.CgiManager r17, boolean r18, com.autonavi.aps.amapapi.model.AMapLocationServer r19, com.autonavi.aps.amapapi.restruct.WifiManagerWrapper r20, java.lang.StringBuilder r21, java.lang.String r22, android.content.Context r23, boolean r24) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.storage.Cache.checkCache(com.autonavi.aps.amapapi.restruct.CgiManager, boolean, com.autonavi.aps.amapapi.model.AMapLocationServer, com.autonavi.aps.amapapi.restruct.WifiManagerWrapper, java.lang.StringBuilder, java.lang.String, android.content.Context, boolean):com.autonavi.aps.amapapi.model.AMapLocationServer");
    }

    public void cleanLastNb() {
        this.f6739g = 0L;
        this.f6740h = null;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:17|(2:19|(6:21|22|23|(1:29)|27|28)(1:36))(2:38|39)|37|22|23|(2:25|29)(1:30)) */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0058, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0059, code lost:
    
        com.autonavi.aps.amapapi.utils.CoreUtil.reportError(r9, "DB", "clearHist");
        r9 = r9.getMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0066, code lost:
    
        if (android.text.TextUtils.isEmpty(r9) == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0068, code lost:
    
        r9.contains("no such table");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void clearHist(android.content.Context r8, int r9) throws java.lang.Exception {
        /*
            r7 = this;
            java.lang.String r0 = "DB"
            java.lang.String r1 = "hist"
            if (r8 != 0) goto L8
            goto L88
        L8:
            r2 = 0
            java.lang.String r3 = "hmdb"
            r4 = 0
            android.database.sqlite.SQLiteDatabase r8 = r8.openOrCreateDatabase(r3, r4, r2)     // Catch: java.lang.Throwable -> L76
            boolean r3 = com.autonavi.aps.amapapi.utils.Utils.tableExisted(r8, r1)     // Catch: java.lang.Throwable -> L22
            if (r3 != 0) goto L25
            if (r8 == 0) goto L88
            boolean r9 = r8.isOpen()     // Catch: java.lang.Throwable -> L22
            if (r9 == 0) goto L88
            r8.close()     // Catch: java.lang.Throwable -> L22
            return
        L22:
            r9 = move-exception
            r2 = r8
            goto L77
        L25:
            r3 = 1
            if (r9 == r3) goto L33
            r3 = 2
            if (r9 == r3) goto L2d
            r9 = r2
            goto L46
        L2d:
            java.lang.String r9 = "1"
        L2f:
            r6 = r2
            r2 = r9
            r9 = r6
            goto L46
        L33:
            long r2 = com.autonavi.aps.amapapi.utils.Utils.getTime()     // Catch: java.lang.Throwable -> L22
            r4 = 172800000(0xa4cb800, double:8.53745436E-316)
            long r2 = r2 - r4
            java.lang.String r9 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> L22
            java.lang.String[] r2 = new java.lang.String[]{r9}     // Catch: java.lang.Throwable -> L22
            java.lang.String r9 = "time<?"
            goto L2f
        L46:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L58
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L58
            java.lang.String r1 = r7.f6737d     // Catch: java.lang.Throwable -> L58
            r3.append(r1)     // Catch: java.lang.Throwable -> L58
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> L58
            r8.delete(r1, r2, r9)     // Catch: java.lang.Throwable -> L58
            goto L6d
        L58:
            r9 = move-exception
            java.lang.String r1 = "clearHist"
            com.autonavi.aps.amapapi.utils.CoreUtil.reportError(r9, r0, r1)     // Catch: java.lang.Throwable -> L22
            java.lang.String r9 = r9.getMessage()     // Catch: java.lang.Throwable -> L22
            boolean r1 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Throwable -> L22
            if (r1 != 0) goto L6d
            java.lang.String r1 = "no such table"
            r9.contains(r1)     // Catch: java.lang.Throwable -> L22
        L6d:
            if (r8 == 0) goto L88
            boolean r9 = r8.isOpen()
            if (r9 == 0) goto L88
            goto L85
        L76:
            r9 = move-exception
        L77:
            java.lang.String r8 = "clearHist p2"
            com.autonavi.aps.amapapi.utils.CoreUtil.reportError(r9, r0, r8)     // Catch: java.lang.Throwable -> L89
            if (r2 == 0) goto L88
            boolean r8 = r2.isOpen()
            if (r8 == 0) goto L88
            r8 = r2
        L85:
            r8.close()
        L88:
            return
        L89:
            r8 = move-exception
            if (r2 == 0) goto L95
            boolean r9 = r2.isOpen()
            if (r9 == 0) goto L95
            r2.close()
        L95:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.storage.Cache.clearHist(android.content.Context, int):void");
    }

    public void destroy(Context context) {
        try {
            b();
            clearHist(context, 1);
            this.f6736c = false;
            this.f6740h = null;
            this.f6743k = 0L;
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "Cache", "destroy part");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0261 A[LOOP:0: B:32:0x00b9->B:53:0x0261, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0251 A[EDGE_INSN: B:54:0x0251->B:55:0x0251 BREAK  A[LOOP:0: B:32:0x00b9->B:53:0x0261], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void fetchHistWhereArgs(android.content.Context r20, java.lang.String r21, boolean r22) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 674
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.storage.Cache.fetchHistWhereArgs(android.content.Context, java.lang.String, boolean):void");
    }

    public AMapLocationServer get(Context context, String str, StringBuilder sb2, boolean z5, boolean z6) {
        if (TextUtils.isEmpty(str) || !AuthUtil.getCacheAble()) {
            return null;
        }
        StringBuilder u10 = l0.u(str, Const.STR_MART_ADD);
        u10.append(this.f6744l);
        u10.append(Const.STR_MART_ADD);
        u10.append(this.f6745m);
        u10.append(Const.STR_MART_ADD);
        u10.append(this.f6746n);
        String sb3 = u10.toString();
        if (sb3.contains("gps") || !AuthUtil.getCacheAble() || sb2 == null) {
            return null;
        }
        if (a()) {
            b();
            return null;
        }
        if (z5 && !this.f6736c) {
            try {
                String a3 = a(sb3, sb2, context);
                b();
                fetchHistWhereArgs(context, a3, z6);
            } catch (Throwable unused) {
            }
        }
        if (this.f6734a.isEmpty()) {
            return null;
        }
        return a(sb3, sb2, z6);
    }

    public void loadDB(Context context) {
        if (this.f6736c) {
            return;
        }
        try {
            b();
            fetchHistWhereArgs(context, null, false);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "Cache", "loadDB");
        }
        this.f6736c = true;
    }

    public void setLastCgi(Cgi cgi) {
        this.f6741i = cgi;
    }

    public void setLastNb(String str) {
        this.f6740h = str;
    }

    public void setOption(AMapLocationClientOption aMapLocationClientOption) {
        this.f6745m = aMapLocationClientOption.isNeedAddress();
        this.f6744l = aMapLocationClientOption.isOffset();
        this.f6738f = aMapLocationClientOption.isLocationCacheEnable();
        this.f6746n = String.valueOf(aMapLocationClientOption.getGeoLanguage());
    }

    public void updateHist(String str, AMapLocation aMapLocation, StringBuilder sb2, Context context) throws Exception {
        if (context == null) {
            return;
        }
        if (this.e == null) {
            this.e = Utils.getPackageNameMD5(context);
        }
        String a3 = a(str, sb2, context);
        StringBuilder sb3 = new StringBuilder();
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = context.openOrCreateDatabase(Const.STR_DB, 0, null);
            sb3.append("CREATE TABLE IF NOT EXISTS ");
            sb3.append(Const.STR_TAB_HIST);
            sb3.append(this.f6737d);
            sb3.append(" (feature VARCHAR PRIMARY KEY, nb VARCHAR, loc VARCHAR, time VARCHAR);");
            sQLiteDatabase.execSQL(sb3.toString());
            sb3.delete(0, sb3.length());
            sb3.append("REPLACE INTO ");
            sb3.append(Const.STR_TAB_HIST);
            sb3.append(this.f6737d);
            sb3.append(" VALUES (?, ?, ?, ?)");
            Object[] objArr = new Object[4];
            objArr[0] = a3;
            byte[] aesEncrypt = Encrypt.aesEncrypt(sb2.toString().getBytes("UTF-8"), this.e);
            objArr[1] = aesEncrypt;
            objArr[2] = Encrypt.aesEncrypt(aMapLocation.toStr().getBytes("UTF-8"), this.e);
            objArr[3] = Long.valueOf(aMapLocation.getTime());
            for (int i3 = 1; i3 < 3; i3++) {
                objArr[i3] = h9.c((byte[]) objArr[i3]);
            }
            sQLiteDatabase.execSQL(sb3.toString(), objArr);
            sb3.delete(0, sb3.length());
            if (!sQLiteDatabase.isOpen()) {
                return;
            }
        } catch (Throwable th2) {
            try {
                CoreUtil.reportError(th2, "DB", "updateHist");
                sb3.delete(0, sb3.length());
                if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                    return;
                }
            } finally {
                sb3.delete(0, sb3.length());
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
            }
        }
        sQLiteDatabase.close();
    }

    private boolean a() {
        long timeBoot = Utils.getTimeBoot();
        long j4 = this.f6735b;
        long j10 = timeBoot - j4;
        if (j4 == 0) {
            return false;
        }
        return this.f6734a.size() > 360 || j10 > 172800000;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ee A[LOOP:1: B:35:0x00e6->B:37:0x00ee, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0106 A[LOOP:2: B:40:0x0100->B:42:0x0106, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01e2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.autonavi.aps.amapapi.storage.Cache.Item a(java.lang.StringBuilder r33, java.lang.String r34) {
        /*
            Method dump skipped, instructions count: 508
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.storage.Cache.a(java.lang.StringBuilder, java.lang.String):com.autonavi.aps.amapapi.storage.Cache$Item");
    }

    private void a(String str, Hashtable<String, String> hashtable) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        hashtable.clear();
        for (String str2 : str.split(Const.STR_MART_WELL)) {
            if (!TextUtils.isEmpty(str2) && !str2.contains("|")) {
                hashtable.put(str2, "");
            }
        }
    }

    public String a(String str, StringBuilder sb2, Context context) {
        String str2;
        if (context == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            this.e = Utils.getPackageNameMD5(context);
            if (str.contains(Const.STR_MART_ADD)) {
                str = str.substring(0, str.indexOf(Const.STR_MART_ADD));
            }
            String substring = str.substring(str.lastIndexOf(Const.STR_MART_WELL) + 1);
            if (substring.equals("cgi")) {
                jSONObject.put("cgi", str.substring(0, str.length() - 12));
            } else if (!TextUtils.isEmpty(sb2) && sb2.indexOf(",access") != -1) {
                jSONObject.put("cgi", str.substring(0, str.length() - (substring.length() + 9)));
                String[] split = sb2.toString().split(",access");
                if (split[0].contains(Const.STR_MART_WELL)) {
                    String str3 = split[0];
                    str2 = str3.substring(str3.lastIndexOf(Const.STR_MART_WELL) + 1);
                } else {
                    str2 = split[0];
                }
                jSONObject.put(Const.JSON_KEY_MMAC, str2);
            }
            return h9.c(Encrypt.aesEncrypt(jSONObject.toString().getBytes("UTF-8"), this.e));
        } catch (Throwable unused) {
            return null;
        }
    }
}
