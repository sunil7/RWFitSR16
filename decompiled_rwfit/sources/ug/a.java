package ug;

import androidx.recyclerview.widget.x;
import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.exceptions.CompositeException;
import java.util.ArrayList;
import xg.c;

/* loaded from: classes2.dex */
public final class a implements b, wg.a {

    /* renamed from: a, reason: collision with root package name */
    public x f19102a;

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f19103b;

    @Override // wg.a
    public final boolean a(b bVar) {
        Object obj;
        c.b(bVar, "Disposable item is null");
        if (this.f19103b) {
            return false;
        }
        synchronized (this) {
            try {
                if (this.f19103b) {
                    return false;
                }
                x xVar = this.f19102a;
                if (xVar != null) {
                    Object[] objArr = (Object[]) xVar.e;
                    int i3 = xVar.f2798b;
                    int hashCode = bVar.hashCode() * (-1640531527);
                    int i10 = (hashCode ^ (hashCode >>> 16)) & i3;
                    Object obj2 = objArr[i10];
                    if (obj2 != null) {
                        if (obj2.equals(bVar)) {
                            xVar.d(objArr, i10, i3);
                        } else {
                            do {
                                i10 = (i10 + 1) & i3;
                                obj = objArr[i10];
                                if (obj == null) {
                                }
                            } while (!obj.equals(bVar));
                            xVar.d(objArr, i10, i3);
                        }
                        return true;
                    }
                }
                return false;
            } finally {
            }
        }
    }

    @Override // wg.a
    public final boolean b(b bVar) {
        if (!a(bVar)) {
            return false;
        }
        bVar.dispose();
        return true;
    }

    @Override // wg.a
    public final boolean c(b bVar) {
        c.b(bVar, "d is null");
        if (!this.f19103b) {
            synchronized (this) {
                try {
                    if (!this.f19103b) {
                        x xVar = this.f19102a;
                        if (xVar == null) {
                            xVar = new x(1);
                            int numberOfLeadingZeros = 1 << (32 - Integer.numberOfLeadingZeros(15));
                            xVar.f2798b = numberOfLeadingZeros - 1;
                            xVar.f2800d = (int) (0.75f * numberOfLeadingZeros);
                            xVar.e = new Object[numberOfLeadingZeros];
                            this.f19102a = xVar;
                        }
                        xVar.a(bVar);
                        return true;
                    }
                } finally {
                }
            }
        }
        bVar.dispose();
        return false;
    }

    public final int d() {
        if (this.f19103b) {
            return 0;
        }
        synchronized (this) {
            try {
                if (this.f19103b) {
                    return 0;
                }
                x xVar = this.f19102a;
                return xVar != null ? xVar.f2799c : 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // ug.b
    public final void dispose() {
        if (this.f19103b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f19103b) {
                    return;
                }
                this.f19103b = true;
                x xVar = this.f19102a;
                ArrayList arrayList = null;
                this.f19102a = null;
                if (xVar == null) {
                    return;
                }
                for (Object obj : (Object[]) xVar.e) {
                    if (obj instanceof b) {
                        try {
                            ((b) obj).dispose();
                        } catch (Throwable th2) {
                            ad.a(th2);
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(th2);
                        }
                    }
                }
                if (arrayList != null) {
                    if (arrayList.size() != 1) {
                        throw new CompositeException(arrayList);
                    }
                    throw io.reactivex.internal.util.b.b((Throwable) arrayList.get(0));
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.f19103b;
    }
}
