package w2;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.activity.f;
import androidx.emoji2.text.i;
import androidx.work.impl.foreground.SystemForegroundService;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import de.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import o2.g;
import o2.m;
import p2.l;
import t2.b;
import t2.c;
import x2.h;
import y2.j;

/* loaded from: classes.dex */
public final class a implements b, p2.a {

    /* renamed from: j, reason: collision with root package name */
    public static final String f19467j = m.i("SystemFgDispatcher");

    /* renamed from: a, reason: collision with root package name */
    public final l f19468a;

    /* renamed from: b, reason: collision with root package name */
    public final o f19469b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f19470c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public String f19471d;
    public final LinkedHashMap e;

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f19472f;

    /* renamed from: g, reason: collision with root package name */
    public final HashSet f19473g;

    /* renamed from: h, reason: collision with root package name */
    public final c f19474h;

    /* renamed from: i, reason: collision with root package name */
    public SystemForegroundService f19475i;

    public a(Context context) {
        l a3 = l.a(context);
        this.f19468a = a3;
        o oVar = a3.f17428d;
        this.f19469b = oVar;
        this.f19471d = null;
        this.e = new LinkedHashMap();
        this.f19473g = new HashSet();
        this.f19472f = new HashMap();
        this.f19474h = new c(context, oVar, this);
        a3.f17429f.b(this);
    }

    public static Intent b(Context context, String str, g gVar) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_NOTIFY");
        intent.putExtra("KEY_NOTIFICATION_ID", gVar.f16712a);
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", gVar.f16713b);
        intent.putExtra("KEY_NOTIFICATION", gVar.f16714c);
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent d(Context context, String str, g gVar) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_START_FOREGROUND");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NOTIFICATION_ID", gVar.f16712a);
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", gVar.f16713b);
        intent.putExtra("KEY_NOTIFICATION", gVar.f16714c);
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    @Override // p2.a
    public final void a(String str, boolean z5) {
        Map.Entry entry;
        synchronized (this.f19470c) {
            try {
                h hVar = (h) this.f19472f.remove(str);
                if (hVar != null ? this.f19473g.remove(hVar) : false) {
                    this.f19474h.b(this.f19473g);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        g gVar = (g) this.e.remove(str);
        if (str.equals(this.f19471d) && this.e.size() > 0) {
            Iterator it = this.e.entrySet().iterator();
            Object next = it.next();
            while (true) {
                entry = (Map.Entry) next;
                if (!it.hasNext()) {
                    break;
                } else {
                    next = it.next();
                }
            }
            this.f19471d = (String) entry.getKey();
            if (this.f19475i != null) {
                g gVar2 = (g) entry.getValue();
                SystemForegroundService systemForegroundService = this.f19475i;
                systemForegroundService.f3024b.post(new j7.l(systemForegroundService, gVar2.f16712a, gVar2.f16714c, gVar2.f16713b));
                SystemForegroundService systemForegroundService2 = this.f19475i;
                systemForegroundService2.f3024b.post(new i(gVar2.f16712a, 8, systemForegroundService2));
            }
        }
        SystemForegroundService systemForegroundService3 = this.f19475i;
        if (gVar == null || systemForegroundService3 == null) {
            return;
        }
        m g10 = m.g();
        String str2 = f19467j;
        int i3 = gVar.f16712a;
        int i10 = gVar.f16713b;
        StringBuilder sb2 = new StringBuilder("Removing Notification (id: ");
        sb2.append(i3);
        sb2.append(", workSpecId: ");
        sb2.append(str);
        sb2.append(" ,notificationType: ");
        g10.d(str2, r5.a.e(sb2, i10, ")"), new Throwable[0]);
        systemForegroundService3.f3024b.post(new i(gVar.f16712a, 8, systemForegroundService3));
    }

    @Override // t2.b
    public final void c(ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            return;
        }
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            String str = (String) obj;
            m.g().d(f19467j, l0.n("Constraints unmet for WorkSpec ", str), new Throwable[0]);
            l lVar = this.f19468a;
            lVar.f17428d.p(new j(lVar, str, true));
        }
    }

    @Override // t2.b
    public final void e(List list) {
    }

    public final void f(Intent intent) {
        int i3 = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        m g10 = m.g();
        StringBuilder sb2 = new StringBuilder("Notifying with (id: ");
        sb2.append(intExtra);
        sb2.append(", workSpecId: ");
        sb2.append(stringExtra);
        sb2.append(", notificationType: ");
        g10.d(f19467j, r5.a.e(sb2, intExtra2, ")"), new Throwable[0]);
        if (notification == null || this.f19475i == null) {
            return;
        }
        g gVar = new g(intExtra, notification, intExtra2);
        LinkedHashMap linkedHashMap = this.e;
        linkedHashMap.put(stringExtra, gVar);
        if (TextUtils.isEmpty(this.f19471d)) {
            this.f19471d = stringExtra;
            SystemForegroundService systemForegroundService = this.f19475i;
            systemForegroundService.f3024b.post(new j7.l(systemForegroundService, intExtra, notification, intExtra2));
            return;
        }
        SystemForegroundService systemForegroundService2 = this.f19475i;
        systemForegroundService2.f3024b.post(new f(systemForegroundService2, intExtra, notification, 7));
        if (intExtra2 == 0 || Build.VERSION.SDK_INT < 29) {
            return;
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            i3 |= ((g) ((Map.Entry) it.next()).getValue()).f16713b;
        }
        g gVar2 = (g) linkedHashMap.get(this.f19471d);
        if (gVar2 != null) {
            SystemForegroundService systemForegroundService3 = this.f19475i;
            systemForegroundService3.f3024b.post(new j7.l(systemForegroundService3, gVar2.f16712a, gVar2.f16714c, i3));
        }
    }

    public final void g() {
        this.f19475i = null;
        synchronized (this.f19470c) {
            this.f19474h.c();
        }
        this.f19468a.f17429f.e(this);
    }
}
