package fh;

import java.util.Comparator;
import kotlin.jvm.internal.e;

/* loaded from: classes2.dex */
public final class a implements Comparator {

    /* renamed from: b, reason: collision with root package name */
    public static final a f13686b = new a(0);

    /* renamed from: c, reason: collision with root package name */
    public static final a f13687c = new a(1);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13688a;

    public /* synthetic */ a(int i3) {
        this.f13688a = i3;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f13688a) {
            case 0:
                Comparable a3 = (Comparable) obj;
                Comparable b3 = (Comparable) obj2;
                e.f(a3, "a");
                e.f(b3, "b");
                return a3.compareTo(b3);
            default:
                Comparable a10 = (Comparable) obj;
                Comparable b10 = (Comparable) obj2;
                e.f(a10, "a");
                e.f(b10, "b");
                return b10.compareTo(a10);
        }
    }

    @Override // java.util.Comparator
    public final Comparator reversed() {
        switch (this.f13688a) {
            case 0:
                return f13687c;
            default:
                return f13686b;
        }
    }
}
