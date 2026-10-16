package k1;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f15452a;

    /* renamed from: b, reason: collision with root package name */
    public int f15453b;

    public d(int i3) {
        if (i3 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f15452a = new Object[i3];
    }

    public Object a() {
        int i3 = this.f15453b;
        if (i3 <= 0) {
            return null;
        }
        int i10 = i3 - 1;
        Object[] objArr = this.f15452a;
        Object obj = objArr[i10];
        objArr[i10] = null;
        this.f15453b = i3 - 1;
        return obj;
    }

    public void b(o0.b bVar) {
        int i3 = this.f15453b;
        Object[] objArr = this.f15452a;
        if (i3 < objArr.length) {
            objArr[i3] = bVar;
            this.f15453b = i3 + 1;
        }
    }

    public boolean c(Object obj) {
        int i3 = 0;
        while (true) {
            int i10 = this.f15453b;
            Object[] objArr = this.f15452a;
            if (i3 >= i10) {
                if (i10 >= objArr.length) {
                    return false;
                }
                objArr[i10] = obj;
                this.f15453b = i10 + 1;
                return true;
            }
            if (objArr[i3] == obj) {
                throw new IllegalStateException("Already in the pool!");
            }
            i3++;
        }
    }

    public d() {
        this.f15452a = new Object[256];
    }
}
