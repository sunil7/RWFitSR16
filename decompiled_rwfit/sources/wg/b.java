package wg;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.exceptions.CompositeException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes2.dex */
public final class b implements ug.b, a {

    /* renamed from: a, reason: collision with root package name */
    public LinkedList f19633a;

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f19634b;

    @Override // wg.a
    public final boolean a(ug.b bVar) {
        if (this.f19634b) {
            return false;
        }
        synchronized (this) {
            try {
                if (this.f19634b) {
                    return false;
                }
                LinkedList linkedList = this.f19633a;
                if (linkedList != null && linkedList.remove(bVar)) {
                    return true;
                }
                return false;
            } finally {
            }
        }
    }

    @Override // wg.a
    public final boolean b(ug.b bVar) {
        if (!a(bVar)) {
            return false;
        }
        bVar.dispose();
        return true;
    }

    @Override // wg.a
    public final boolean c(ug.b bVar) {
        if (!this.f19634b) {
            synchronized (this) {
                try {
                    if (!this.f19634b) {
                        LinkedList linkedList = this.f19633a;
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                            this.f19633a = linkedList;
                        }
                        linkedList.add(bVar);
                        return true;
                    }
                } finally {
                }
            }
        }
        bVar.dispose();
        return false;
    }

    @Override // ug.b
    public final void dispose() {
        if (this.f19634b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f19634b) {
                    return;
                }
                this.f19634b = true;
                LinkedList linkedList = this.f19633a;
                ArrayList arrayList = null;
                this.f19633a = null;
                if (linkedList == null) {
                    return;
                }
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    try {
                        ((ug.b) it.next()).dispose();
                    } catch (Throwable th2) {
                        ad.a(th2);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(th2);
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
        return this.f19634b;
    }
}
