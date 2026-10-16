package eb;

import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.media.CamcorderProfile;
import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.bumptech.glide.load.EncodeStrategy;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig$Flag;
import com.google.gson.internal.LinkedTreeMap;
import g4.b0;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes.dex */
public class e implements a4.b, rd.a, com.google.gson.internal.i, pb.b, td.a, c8.b, b0, x3.h, m4.e, n.d, androidx.core.widget.l, vg.p {

    /* renamed from: b, reason: collision with root package name */
    public static e f12485b;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12486a;

    public /* synthetic */ e(int i3) {
        this.f12486a = i3;
    }

    @Override // a4.b
    public Bitmap a(int i3, int i10, Bitmap.Config config) {
        return Bitmap.createBitmap(i3, i10, config);
    }

    @Override // g4.b0
    public void b(MediaMetadataRetriever mediaMetadataRetriever, Object obj) {
        mediaMetadataRetriever.setDataSource(((ParcelFileDescriptor) obj).getFileDescriptor());
    }

    @Override // n.d
    public CamcorderProfile c(int i3, int i10) {
        return CamcorderProfile.get(i3, i10);
    }

    @Override // n.d
    public boolean d(int i3, int i10) {
        return CamcorderProfile.hasProfile(i3, i10);
    }

    @Override // x3.a
    public boolean e(Object obj, File file, x3.f fVar) {
        try {
            t4.b.b(((k4.h) ((k4.c) ((z3.s) obj).get()).f15470a.f15469b).f15486a.f19503d.asReadOnlyBuffer(), file);
            return true;
        } catch (IOException e) {
            if (!Log.isLoggable("GifEncoder", 5)) {
                return false;
            }
            Log.w("GifEncoder", "Failed to encode GIF drawable data", e);
            return false;
        }
    }

    @Override // a4.b
    public Bitmap f(int i3, int i10, Bitmap.Config config) {
        return Bitmap.createBitmap(i3, i10, config);
    }

    @Override // rd.a
    public void g(vd.b bVar) {
        Log.e("qob", "onCommandResponse " + bVar);
    }

    @Override // dh.a
    public Object get() {
        gc.b bVar = new gc.b(13);
        HashMap hashMap = new HashMap();
        Priority priority = Priority.DEFAULT;
        Set set = Collections.EMPTY_SET;
        if (set == null) {
            throw new NullPointerException("Null flags");
        }
        hashMap.put(priority, new f8.c(30000L, Const.DAY_IN_MILLIS, set));
        Priority priority2 = Priority.HIGHEST;
        if (set == null) {
            throw new NullPointerException("Null flags");
        }
        hashMap.put(priority2, new f8.c(1000L, Const.DAY_IN_MILLIS, set));
        Priority priority3 = Priority.VERY_LOW;
        if (set == null) {
            throw new NullPointerException("Null flags");
        }
        Set unmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(SchedulerConfig$Flag.NETWORK_UNMETERED, SchedulerConfig$Flag.DEVICE_IDLE)));
        if (unmodifiableSet == null) {
            throw new NullPointerException("Null flags");
        }
        hashMap.put(priority3, new f8.c(Const.DAY_IN_MILLIS, Const.DAY_IN_MILLIS, unmodifiableSet));
        if (hashMap.keySet().size() < Priority.values().length) {
            throw new IllegalStateException("Not all priorities have been configured");
        }
        new HashMap();
        return new f8.b(bVar, hashMap);
    }

    @Override // td.a
    public Object h(vd.b bVar) {
        if (!(bVar instanceof xd.l)) {
            return new ud.c(0, 0);
        }
        be.k kVar = (be.k) ((xd.l) bVar).f19230g;
        return new ud.c(kVar.f3257d, kVar.e);
    }

    @Override // pb.b
    public Object i(pb.p pVar) {
        switch (this.f12486a) {
            case 8:
                return new hc.a(0);
            default:
                synchronized (com.google.android.gms.internal.mlkit_common.m.class) {
                    byte b3 = (byte) (((byte) 1) | 2);
                    if (b3 != 3) {
                        StringBuilder sb2 = new StringBuilder();
                        if ((b3 & 1) == 0) {
                            sb2.append(" enableFirelog");
                        }
                        if ((b3 & 2) == 0) {
                            sb2.append(" firelogEventType");
                        }
                        throw new IllegalStateException("Missing required properties:".concat(sb2.toString()));
                    }
                    com.google.android.gms.internal.mlkit_common.h hVar = new com.google.android.gms.internal.mlkit_common.h();
                    synchronized (com.google.android.gms.internal.mlkit_common.m.class) {
                        try {
                            if (com.google.android.gms.internal.mlkit_common.m.f9181a == null) {
                                com.google.android.gms.internal.mlkit_common.m.f9181a = new com.google.android.gms.internal.mlkit_common.l(0);
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    return new ec.a(0);
                }
                return new ec.a(0);
        }
    }

    @Override // a4.b
    public void j(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // a4.b
    public void k(int i3) {
    }

    @Override // vg.p
    public boolean l(Object obj) {
        switch (this.f12486a) {
            case 23:
                throw null;
            default:
                return true;
        }
    }

    @Override // rd.a
    public void m(androidx.recyclerview.widget.x xVar) {
        Log.e("qob", "onErrCode " + xVar);
    }

    @Override // a4.b
    public void n() {
    }

    @Override // x3.h
    public EncodeStrategy o(x3.f fVar) {
        return EncodeStrategy.SOURCE;
    }

    public boolean p() {
        return this instanceof f;
    }

    public void q(float f2, float f10, float f11, w wVar) {
        wVar.d(f2, 0.0f);
    }

    public i6.f r() {
        i6.f fVar;
        i6.f fVar2 = i6.f.f14367g;
        if (fVar2 != null) {
            return fVar2;
        }
        synchronized (this) {
            fVar = i6.f.f14367g;
            if (fVar == null) {
                fVar = new i6.f();
                i6.f.f14367g = fVar;
            }
        }
        return fVar;
    }

    public Signature[] s(PackageManager packageManager, String str) {
        return packageManager.getPackageInfo(str, 64).signatures;
    }

    @Override // com.google.gson.internal.i
    public Object t() {
        return new LinkedTreeMap();
    }

    public String toString() {
        switch (this.f12486a) {
            case 22:
                int i3 = ye.e.f20123a;
                Locale locale = Locale.ENGLISH;
                return "component: database[null], maxNetworkCount[null], outputStream[null], connection[null], connectionCountAdapter[null]";
            default:
                return super.toString();
        }
    }

    public e(h9.b bVar) {
        this.f12486a = 26;
    }

    public e() {
        this.f12486a = 17;
        List list = Collections.EMPTY_LIST;
    }
}
