package com.amap.api.col.p0003sl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.f;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.autonavi.aps.amapapi.utils.Utils;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    f f4159a;

    /* renamed from: b, reason: collision with root package name */
    Context f4160b;

    /* renamed from: c, reason: collision with root package name */
    Messenger f4161c = null;

    public g(Context context) {
        this.f4159a = null;
        this.f4160b = null;
        Context applicationContext = context.getApplicationContext();
        this.f4160b = applicationContext;
        this.f4159a = new f(applicationContext);
    }

    public IBinder a(Intent intent) {
        f.a aVar;
        f fVar = this.f4159a;
        fVar.getClass();
        String stringExtra = intent.getStringExtra(Const.INTENT_KEY_APIKEY);
        if (!TextUtils.isEmpty(stringExtra)) {
            c9.a(fVar.f4035i, stringExtra);
        }
        String stringExtra2 = intent.getStringExtra(Const.INTENT_KEY_PKGNAME);
        fVar.f4030c = stringExtra2;
        b9.c(stringExtra2);
        String stringExtra3 = intent.getStringExtra(Const.INTENT_KEY_UMID);
        if (!TextUtils.isEmpty(stringExtra3)) {
            f9.a(stringExtra3);
        }
        f fVar2 = this.f4159a;
        fVar2.getClass();
        if ("true".equals(intent.getStringExtra("as")) && (aVar = fVar2.f4034h) != null) {
            aVar.sendEmptyMessageDelayed(9, 100L);
        }
        Messenger messenger = new Messenger(this.f4159a.f4034h);
        this.f4161c = messenger;
        return messenger.getBinder();
    }

    public void b() {
        try {
            f fVar = this.f4159a;
            if (fVar != null) {
                fVar.f4034h.sendEmptyMessage(11);
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "ApsServiceCore", "onDestroy");
        }
    }

    public int c() {
        f fVar = this.f4159a;
        return (fVar == null || fVar.f4048w.isSelfStartServiceEnable()) ? 3 : 2;
    }

    public void a() {
        try {
            f.f4027x = false;
            this.f4159a.f4040n = Utils.getTimeBoot();
            this.f4159a.f4041o = Utils.getTime();
            this.f4159a.b();
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "ApsServiceCore", "onCreate");
        }
    }
}
