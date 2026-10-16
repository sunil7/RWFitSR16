package y0;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final Context f19878a;
    public CharSequence e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f19882f;

    /* renamed from: g, reason: collision with root package name */
    public PendingIntent f19883g;

    /* renamed from: h, reason: collision with root package name */
    public Bitmap f19884h;

    /* renamed from: i, reason: collision with root package name */
    public int f19885i;

    /* renamed from: k, reason: collision with root package name */
    public o4.c f19887k;

    /* renamed from: m, reason: collision with root package name */
    public Bundle f19889m;

    /* renamed from: o, reason: collision with root package name */
    public RemoteViews f19891o;

    /* renamed from: p, reason: collision with root package name */
    public String f19892p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f19893q;
    public final Notification r;

    /* renamed from: s, reason: collision with root package name */
    public final ArrayList f19894s;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f19879b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f19880c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f19881d = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    public final boolean f19886j = true;

    /* renamed from: l, reason: collision with root package name */
    public boolean f19888l = false;

    /* renamed from: n, reason: collision with root package name */
    public int f19890n = 0;

    public l(Context context, String str) {
        Notification notification = new Notification();
        this.r = notification;
        this.f19878a = context;
        this.f19892p = str;
        notification.when = System.currentTimeMillis();
        notification.audioStreamType = -1;
        this.f19885i = 0;
        this.f19894s = new ArrayList();
        this.f19893q = true;
    }

    public static CharSequence b(CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Notification a() {
        Bundle bundle;
        int i3;
        ArrayList arrayList;
        int i10;
        new ArrayList();
        Bundle bundle2 = new Bundle();
        Notification.Builder builder = new Notification.Builder(this.f19878a, this.f19892p);
        Notification notification = this.r;
        Context context = null;
        int i11 = 0;
        builder.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(this.e).setContentText(this.f19882f).setContentInfo(null).setContentIntent(this.f19883g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(null, (notification.flags & 128) != 0).setLargeIcon(this.f19884h).setNumber(0).setProgress(0, 0, false);
        builder.setSubText(null).setUsesChronometer(false).setPriority(this.f19885i);
        ArrayList arrayList2 = this.f19879b;
        int size = arrayList2.size();
        int i12 = 0;
        while (i12 < size) {
            Object obj = arrayList2.get(i12);
            i12++;
            k kVar = (k) obj;
            if (kVar.f19873b == null && (i10 = kVar.e) != 0) {
                kVar.f19873b = IconCompat.a(i10);
            }
            IconCompat iconCompat = kVar.f19873b;
            Notification.Action.Builder builder2 = new Notification.Action.Builder(iconCompat != null ? d1.d.c(iconCompat, context) : context, kVar.f19876f, kVar.f19877g);
            Bundle bundle3 = kVar.f19872a;
            Bundle bundle4 = bundle3 != null ? new Bundle(bundle3) : new Bundle();
            boolean z5 = kVar.f19874c;
            bundle4.putBoolean("android.support.allowGeneratedReplies", z5);
            int i13 = Build.VERSION.SDK_INT;
            builder2.setAllowGeneratedReplies(z5);
            bundle4.putInt("android.support.action.semanticAction", 0);
            if (i13 >= 28) {
                builder2.setSemanticAction(0);
            }
            if (i13 >= 29) {
                builder2.setContextual(false);
            }
            if (i13 >= 31) {
                builder2.setAuthenticationRequired(false);
            }
            bundle4.putBoolean("android.support.action.showsUserInterface", kVar.f19875d);
            builder2.addExtras(bundle4);
            builder.addAction(builder2.build());
            context = null;
        }
        Bundle bundle5 = this.f19889m;
        if (bundle5 != null) {
            bundle2.putAll(bundle5);
        }
        int i14 = Build.VERSION.SDK_INT;
        builder.setShowWhen(this.f19886j);
        builder.setLocalOnly(this.f19888l).setGroup(null).setGroupSummary(false).setSortKey(null);
        builder.setCategory(null).setColor(0).setVisibility(this.f19890n).setPublicVersion(null).setSound(notification.sound, notification.audioAttributes);
        ArrayList arrayList3 = this.f19894s;
        ArrayList arrayList4 = this.f19880c;
        if (i14 < 28) {
            if (arrayList4 == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(arrayList4.size());
                Iterator it = arrayList4.iterator();
                if (it.hasNext()) {
                    throw android.support.v4.media.session.e.d(it);
                }
            }
            if (arrayList != null) {
                if (arrayList3 == null) {
                    arrayList3 = arrayList;
                } else {
                    m0.c cVar = new m0.c(arrayList3.size() + arrayList.size());
                    cVar.addAll(arrayList);
                    cVar.addAll(arrayList3);
                    arrayList3 = new ArrayList(cVar);
                }
            }
        }
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            int size2 = arrayList3.size();
            int i15 = 0;
            while (i15 < size2) {
                Object obj2 = arrayList3.get(i15);
                i15++;
                builder.addPerson((String) obj2);
            }
        }
        ArrayList arrayList5 = this.f19881d;
        if (arrayList5.size() > 0) {
            if (this.f19889m == null) {
                this.f19889m = new Bundle();
            }
            Bundle bundle6 = this.f19889m.getBundle("android.car.EXTENSIONS");
            if (bundle6 == null) {
                bundle6 = new Bundle();
            }
            Bundle bundle7 = new Bundle(bundle6);
            Bundle bundle8 = new Bundle();
            int i16 = 0;
            while (i16 < arrayList5.size()) {
                String num = Integer.toString(i16);
                k kVar2 = (k) arrayList5.get(i16);
                Bundle bundle9 = new Bundle();
                if (kVar2.f19873b == null && (i3 = kVar2.e) != 0) {
                    kVar2.f19873b = IconCompat.a(i3);
                }
                IconCompat iconCompat2 = kVar2.f19873b;
                bundle9.putInt("icon", iconCompat2 != null ? iconCompat2.b() : i11);
                bundle9.putCharSequence("title", kVar2.f19876f);
                bundle9.putParcelable("actionIntent", kVar2.f19877g);
                Bundle bundle10 = kVar2.f19872a;
                Bundle bundle11 = bundle10 != null ? new Bundle(bundle10) : new Bundle();
                bundle11.putBoolean("android.support.allowGeneratedReplies", kVar2.f19874c);
                bundle9.putBundle("extras", bundle11);
                bundle9.putParcelableArray("remoteInputs", null);
                bundle9.putBoolean("showsUserInterface", kVar2.f19875d);
                bundle9.putInt("semanticAction", 0);
                bundle8.putBundle(num, bundle9);
                i16++;
                i11 = 0;
            }
            bundle6.putBundle("invisible_actions", bundle8);
            bundle7.putBundle("invisible_actions", bundle8);
            if (this.f19889m == null) {
                this.f19889m = new Bundle();
            }
            this.f19889m.putBundle("android.car.EXTENSIONS", bundle6);
            bundle2.putBundle("android.car.EXTENSIONS", bundle7);
        }
        int i17 = Build.VERSION.SDK_INT;
        builder.setExtras(this.f19889m).setRemoteInputHistory(null);
        RemoteViews remoteViews = this.f19891o;
        if (remoteViews != null) {
            builder.setCustomBigContentView(remoteViews);
        }
        builder.setBadgeIconType(0).setSettingsText(null).setShortcutId(null).setTimeoutAfter(0L).setGroupAlertBehavior(0);
        if (!TextUtils.isEmpty(this.f19892p)) {
            builder.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
        }
        if (i17 >= 28) {
            Iterator it2 = arrayList4.iterator();
            if (it2.hasNext()) {
                throw android.support.v4.media.session.e.d(it2);
            }
        }
        if (i17 >= 29) {
            builder.setAllowSystemGeneratedContextualActions(this.f19893q);
            builder.setBubbleMetadata(null);
        }
        o4.c cVar2 = this.f19887k;
        if (cVar2 != null) {
            new Notification.BigTextStyle(builder).setBigContentTitle(null).bigText((CharSequence) cVar2.f16733b);
        }
        Notification build = builder.build();
        if (cVar2 != null) {
            this.f19887k.getClass();
        }
        if (cVar2 != null && (bundle = build.extras) != null) {
            bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", "androidx.core.app.NotificationCompat$BigTextStyle");
        }
        return build;
    }

    public final void c(int i3, boolean z5) {
        Notification notification = this.r;
        if (z5) {
            notification.flags = i3 | notification.flags;
        } else {
            notification.flags = (~i3) & notification.flags;
        }
    }

    public final void d(o4.c cVar) {
        if (this.f19887k != cVar) {
            this.f19887k = cVar;
            if (((l) cVar.f16732a) != this) {
                cVar.f16732a = this;
                d(cVar);
            }
        }
    }
}
