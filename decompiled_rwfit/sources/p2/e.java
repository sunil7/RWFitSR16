package p2;

import android.text.TextUtils;
import androidx.work.ExistingWorkPolicy;
import com.google.android.gms.internal.mlkit_vision_barcode.hf;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import o2.s;
import o2.u;

/* loaded from: classes.dex */
public final class e extends hf {

    /* renamed from: i, reason: collision with root package name */
    public static final String f17402i = o2.m.i("WorkContinuationImpl");

    /* renamed from: a, reason: collision with root package name */
    public final l f17403a;

    /* renamed from: b, reason: collision with root package name */
    public final String f17404b;

    /* renamed from: c, reason: collision with root package name */
    public final ExistingWorkPolicy f17405c;

    /* renamed from: d, reason: collision with root package name */
    public final List f17406d;
    public final ArrayList e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f17407f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public boolean f17408g;

    /* renamed from: h, reason: collision with root package name */
    public o4.c f17409h;

    public e(l lVar, String str, ExistingWorkPolicy existingWorkPolicy, List list) {
        this.f17403a = lVar;
        this.f17404b = str;
        this.f17405c = existingWorkPolicy;
        this.f17406d = list;
        this.e = new ArrayList(list.size());
        for (int i3 = 0; i3 < list.size(); i3++) {
            String uuid = ((u) list.get(i3)).f16723a.toString();
            this.e.add(uuid);
            this.f17407f.add(uuid);
        }
    }

    public static HashSet b(e eVar) {
        HashSet hashSet = new HashSet();
        eVar.getClass();
        return hashSet;
    }

    public final s a() {
        if (this.f17408g) {
            o2.m.g().k(f17402i, l0.o("Already enqueued work ids (", TextUtils.join(", ", this.e), ")"), new Throwable[0]);
        } else {
            y2.d dVar = new y2.d(this);
            this.f17403a.f17428d.p(dVar);
            this.f17409h = dVar.f19947b;
        }
        return this.f17409h;
    }
}
