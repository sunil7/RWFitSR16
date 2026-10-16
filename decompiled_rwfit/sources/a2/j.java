package a2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: c, reason: collision with root package name */
    public static final j f48c = new j(Collections.EMPTY_LIST);

    /* renamed from: a, reason: collision with root package name */
    public final List f49a;

    /* renamed from: b, reason: collision with root package name */
    public final int f50b;

    public j(int i3, ArrayList arrayList) {
        this.f49a = arrayList;
        this.f50b = i3;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Result 0, ");
        sb2.append(this.f49a);
        sb2.append(", ");
        return r5.a.e(sb2, this.f50b, ", offset 0");
    }

    public j(List list) {
        this.f49a = list;
        this.f50b = 0;
    }
}
