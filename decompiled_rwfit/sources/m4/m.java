package m4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class m implements g {

    /* renamed from: a, reason: collision with root package name */
    public final Set f15967a = Collections.newSetFromMap(new WeakHashMap());

    @Override // m4.g
    public final void i() {
        ArrayList d5 = t4.l.d(this.f15967a);
        int size = d5.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = d5.get(i3);
            i3++;
            ((q4.g) obj).i();
        }
    }

    @Override // m4.g
    public final void onDestroy() {
        ArrayList d5 = t4.l.d(this.f15967a);
        int size = d5.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = d5.get(i3);
            i3++;
            ((q4.g) obj).onDestroy();
        }
    }

    @Override // m4.g
    public final void onStop() {
        ArrayList d5 = t4.l.d(this.f15967a);
        int size = d5.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = d5.get(i3);
            i3++;
            ((q4.g) obj).onStop();
        }
    }
}
