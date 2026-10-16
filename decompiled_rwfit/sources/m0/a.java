package m0;

import ab.n;
import java.util.Map;

/* loaded from: classes.dex */
public final class a extends n {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f15882d;
    public final /* synthetic */ Object e;

    public /* synthetic */ a(Object obj, int i3) {
        this.f15882d = i3;
        this.e = obj;
    }

    @Override // ab.n
    public final void d() {
        switch (this.f15882d) {
            case 0:
                ((b) this.e).clear();
                break;
            default:
                ((c) this.e).clear();
                break;
        }
    }

    @Override // ab.n
    public final Object e(int i3, int i10) {
        switch (this.f15882d) {
            case 0:
                return ((b) this.e).f15918b[(i3 << 1) + i10];
            default:
                return ((c) this.e).f15890b[i3];
        }
    }

    @Override // ab.n
    public final Map f() {
        switch (this.f15882d) {
            case 0:
                return (b) this.e;
            default:
                throw new UnsupportedOperationException("not a map");
        }
    }

    @Override // ab.n
    public final int g() {
        switch (this.f15882d) {
            case 0:
                return ((b) this.e).f15919c;
            default:
                return ((c) this.e).f15891c;
        }
    }

    @Override // ab.n
    public final int h(Object obj) {
        switch (this.f15882d) {
            case 0:
                return ((b) this.e).e(obj);
            default:
                c cVar = (c) this.e;
                return obj == null ? cVar.e() : cVar.d(obj.hashCode(), obj);
        }
    }

    @Override // ab.n
    public final int i(Object obj) {
        switch (this.f15882d) {
            case 0:
                return ((b) this.e).g(obj);
            default:
                c cVar = (c) this.e;
                return obj == null ? cVar.e() : cVar.d(obj.hashCode(), obj);
        }
    }

    @Override // ab.n
    public final void j(Object obj, Object obj2) {
        switch (this.f15882d) {
            case 0:
                ((b) this.e).put(obj, obj2);
                break;
            default:
                ((c) this.e).add(obj);
                break;
        }
    }

    @Override // ab.n
    public final void k(int i3) {
        switch (this.f15882d) {
            case 0:
                ((b) this.e).j(i3);
                break;
            default:
                ((c) this.e).f(i3);
                break;
        }
    }

    @Override // ab.n
    public final Object l(int i3, Object obj) {
        switch (this.f15882d) {
            case 0:
                return ((b) this.e).k(i3, obj);
            default:
                throw new UnsupportedOperationException("not a map");
        }
    }
}
