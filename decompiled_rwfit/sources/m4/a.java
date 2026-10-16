package m4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class a implements f {

    /* renamed from: a, reason: collision with root package name */
    public final Set f15946a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b, reason: collision with root package name */
    public boolean f15947b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f15948c;

    public final void a() {
        this.f15948c = true;
        ArrayList d5 = t4.l.d(this.f15946a);
        int size = d5.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = d5.get(i3);
            i3++;
            ((g) obj).onDestroy();
        }
    }

    @Override // m4.f
    public final void b(g gVar) {
        this.f15946a.remove(gVar);
    }

    public final void c() {
        this.f15947b = true;
        ArrayList d5 = t4.l.d(this.f15946a);
        int size = d5.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = d5.get(i3);
            i3++;
            ((g) obj).i();
        }
    }

    public final void d() {
        int i3 = 0;
        this.f15947b = false;
        ArrayList d5 = t4.l.d(this.f15946a);
        int size = d5.size();
        while (i3 < size) {
            Object obj = d5.get(i3);
            i3++;
            ((g) obj).onStop();
        }
    }

    @Override // m4.f
    public final void g(g gVar) {
        this.f15946a.add(gVar);
        if (this.f15948c) {
            gVar.onDestroy();
        } else if (this.f15947b) {
            gVar.i();
        } else {
            gVar.onStop();
        }
    }
}
