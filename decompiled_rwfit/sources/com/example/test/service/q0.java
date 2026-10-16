package com.example.test.service;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemClock;
import android.provider.ContactsContract;
import android.util.Log;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.impl.CameraValidator$CameraIdListIncorrectException;
import com.example.blesdk.bean.function.CallRemindBean;
import com.example.blesdk.bean.function.SupportMenuBean;
import com.example.test.XXApplication;
import com.google.android.gms.internal.mlkit_vision_barcode.d2;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import java.io.Serializable;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes.dex */
public final class q0 {

    /* renamed from: d, reason: collision with root package name */
    public static q0 f7749d;

    /* renamed from: a, reason: collision with root package name */
    public int f7750a;

    /* renamed from: b, reason: collision with root package name */
    public long f7751b;

    /* renamed from: c, reason: collision with root package name */
    public Serializable f7752c;

    public q0(long j4, Exception exc) {
        this.f7751b = SystemClock.elapsedRealtime() - j4;
        if (exc instanceof CameraValidator$CameraIdListIncorrectException) {
            this.f7750a = 2;
            this.f7752c = exc;
            return;
        }
        if (!(exc instanceof InitializationException)) {
            this.f7750a = 0;
            this.f7752c = exc;
            return;
        }
        Throwable cause = exc.getCause();
        exc = cause != null ? cause : exc;
        this.f7752c = exc;
        if (exc instanceof CameraUnavailableException) {
            this.f7750a = 2;
        } else if (exc instanceof IllegalArgumentException) {
            this.f7750a = 1;
        } else {
            this.f7750a = 0;
        }
    }

    public static q0 a() {
        if (f7749d == null) {
            synchronized (q0.class) {
                q0 q0Var = new q0();
                q0Var.f7750a = -1;
                f7749d = q0Var;
            }
        }
        return f7749d;
    }

    public synchronized void b(int i3, String str) {
        if (str != null) {
            if (str.length() != 0 && !"null".equalsIgnoreCase(str) && str.equals((String) this.f7752c) && System.currentTimeMillis() - this.f7751b < 1000 && i3 == this.f7750a) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "PhoneCallService", "1000ms内收到同样的来电通知，不提醒");
                return;
            }
        }
        this.f7751b = System.currentTimeMillis();
        this.f7752c = str;
        this.f7750a = i3;
        if (str != null && str.length() != 0 && !"null".equalsIgnoreCase(str)) {
            c();
        }
    }

    public void c() {
        String str = (String) this.f7752c;
        String str2 = "";
        try {
            XXApplication xXApplication = XXApplication.f7400h;
            com.google.android.gms.internal.mlkit_vision_barcode.j1.a();
            ContentResolver contentResolver = com.google.android.gms.internal.mlkit_vision_barcode.j1.a().getContentResolver();
            Cursor query = contentResolver.query(Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(str)), new String[]{"display_name", FileDownloadModel.ID}, null, null, null);
            if (query != null) {
                while (query.moveToNext()) {
                    try {
                        str2 = query.getString(query.getColumnIndexOrThrow("display_name"));
                    } finally {
                    }
                }
                query.close();
            }
            if (str2.isEmpty()) {
                query = contentResolver.query(Uri.parse("content://com.android.contacts/data/phones/filter/" + str), new String[]{"display_name"}, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            str2 = query.getString(0);
                        }
                        query.close();
                    } finally {
                    }
                }
            }
        } catch (SecurityException e) {
            e.printStackTrace();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "PhoneCallService", e.getMessage());
        }
        if (str2.trim().replace(" ", "").equals((String) this.f7752c)) {
            str2 = "";
        }
        if (!y5.d.f20005b) {
            StringBuilder sb2 = new StringBuilder("发送来电提醒：");
            android.support.v4.media.session.e.z(sb2, (String) this.f7752c, " name ", str2, " status ");
            sb2.append(this.f7750a);
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "PhoneCallService", sb2.toString());
            CallRemindBean callRemindBean = new CallRemindBean();
            callRemindBean.setRemindType(this.f7750a);
            callRemindBean.setPhoneNum((String) this.f7752c);
            callRemindBean.setPhoneName(str2);
            Calendar calendar = Calendar.getInstance();
            TimeZone.getDefault().useDaylightTime();
            calendar.add(14, TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().useDaylightTime() ? 3600000 : 0));
            callRemindBean.setTimeMill(calendar.getTimeInMillis());
            if (!r5.b.k().f18054c) {
                x5.b.I0().F0((byte) 71);
                return;
            }
            x5.d c9 = x5.d.c();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getControlRemindCallCmd " + callRemindBean);
            byte[] n4 = y5.b.n(callRemindBean.getPhoneNum());
            byte[] n8 = y5.b.n(callRemindBean.getPhoneName());
            byte[] bArr = new byte[n4.length + 6 + n8.length];
            bArr[0] = (byte) (callRemindBean.getRemindType() & 255);
            byte[] r = y5.b.r(callRemindBean.getTimeMill() / 1000);
            bArr[1] = r[0];
            bArr[2] = r[1];
            bArr[3] = r[2];
            bArr[4] = r[3];
            bArr[5] = (byte) (n4.length & 255);
            System.arraycopy(n4, 0, bArr, 6, n4.length);
            System.arraycopy(n8, 0, bArr, n4.length + 6, n8.length);
            c9.j((byte) 71, bArr);
            return;
        }
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar != null) {
            if (!kVar.I(e.h().g().f18212c)) {
                StringBuilder sb3 = new StringBuilder("来电提醒开关没开，不发送来电提醒：");
                android.support.v4.media.session.e.z(sb3, (String) this.f7752c, " name ", str2, " status ");
                sb3.append(this.f7750a);
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "PhoneCallService", sb3.toString());
                return;
            }
            StringBuilder sb4 = new StringBuilder("发送来电提醒：");
            android.support.v4.media.session.e.z(sb4, (String) this.f7752c, " name ", str2, " status ");
            sb4.append(this.f7750a);
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "PhoneCallService", sb4.toString());
            int i3 = this.f7750a;
            if (i3 != 0) {
                if (i3 == 1 || i3 == 2) {
                    int i10 = i3 - 1;
                    if (!r5.b.k().f18054c) {
                        x5.b.I0().F0((byte) -89);
                        return;
                    }
                    x5.c b3 = x5.c.b();
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i10, "getPhoneStateCmdJL "));
                    char[] cArr = y5.b.f20001a;
                    b3.g((byte) -89, new byte[]{6, 3, 0, (byte) (i10 & 255)}, new boolean[0]);
                    return;
                }
                return;
            }
            CallRemindBean callRemindBean2 = new CallRemindBean();
            callRemindBean2.setRemindType(this.f7750a);
            callRemindBean2.setPhoneNum((String) this.f7752c);
            callRemindBean2.setPhoneName(str2);
            Calendar calendar2 = Calendar.getInstance();
            TimeZone.getDefault().useDaylightTime();
            calendar2.add(14, TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().useDaylightTime() ? 3600000 : 0));
            callRemindBean2.setTimeMill(calendar2.getTimeInMillis());
            Object obj = com.example.test.utils.m.f8734b;
            SupportMenuBean supportMenuBean = d2.a().f8735a;
            if (supportMenuBean != null ? supportMenuBean.isMsgNotification() : true) {
                if (d2.a().c()) {
                    callRemindBean2.setPhoneName("");
                }
                if (!r5.b.k().f18054c) {
                    x5.b.I0().F0((byte) -88);
                    return;
                }
                x5.c b10 = x5.c.b();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getControlRemindCallCmdJL " + callRemindBean2);
                byte[] n10 = y5.b.n("com.android.mobilephone");
                String phoneName = callRemindBean2.getPhoneName();
                byte[] n11 = (phoneName == null || phoneName.length() == 0) ? y5.b.n(callRemindBean2.getPhoneNum()) : y5.b.n(callRemindBean2.getPhoneName());
                Log.e("qob", "callRemindBean " + callRemindBean2.getPhoneName() + " phoneNum " + callRemindBean2.getPhoneNum());
                byte[] n12 = y5.b.n(callRemindBean2.getPhoneNum());
                byte[] bArr2 = new byte[n11.length + 106];
                Calendar calendar3 = Calendar.getInstance();
                calendar3.setTimeInMillis(callRemindBean2.getTimeMill());
                String format = new SimpleDateFormat("yy", Locale.getDefault()).format(Long.valueOf(calendar3.getTimeInMillis()));
                kotlin.jvm.internal.e.e(format, "format(...)");
                int parseInt = Integer.parseInt(format);
                int i11 = calendar3.get(2) + 1;
                int i12 = calendar3.get(5);
                int i13 = calendar3.get(11);
                int i14 = calendar3.get(12);
                int i15 = calendar3.get(13);
                bArr2[0] = 4;
                bArr2[1] = 10;
                bArr2[2] = 0;
                bArr2[3] = 1;
                bArr2[4] = (byte) parseInt;
                bArr2[5] = (byte) i11;
                bArr2[6] = (byte) i12;
                bArr2[7] = (byte) i13;
                bArr2[8] = (byte) i14;
                bArr2[9] = (byte) i15;
                System.arraycopy(n10, 0, bArr2, 10, n10.length <= 32 ? n10.length : 32);
                System.arraycopy(n11, 0, bArr2, 42, n11.length);
                System.arraycopy(n12, 0, bArr2, 74, n12.length);
                System.arraycopy(n11, 0, bArr2, 106, n11.length);
                b10.g((byte) -88, bArr2, new boolean[0]);
            }
        }
    }

    public q0(int i3, URL url, long j4) {
        this.f7750a = i3;
        this.f7752c = url;
        this.f7751b = j4;
    }
}
