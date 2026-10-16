package vh;

import com.google.android.gms.internal.mlkit_vision_barcode.wb;
import eh.g;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Result;
import kotlin.coroutines.EmptyCoroutineContext;

/* loaded from: classes2.dex */
public final class d extends e implements Iterator, gh.a, ph.a {

    /* renamed from: a, reason: collision with root package name */
    public int f19266a;

    /* renamed from: b, reason: collision with root package name */
    public String f19267b;

    /* renamed from: c, reason: collision with root package name */
    public gh.a f19268c;

    public final RuntimeException a() {
        int i3 = this.f19266a;
        if (i3 == 4) {
            return new NoSuchElementException();
        }
        if (i3 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f19266a);
    }

    @Override // gh.a
    public final gh.e getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i3;
        while (true) {
            i3 = this.f19266a;
            if (i3 != 0) {
                break;
            }
            this.f19266a = 5;
            gh.a aVar = this.f19268c;
            kotlin.jvm.internal.e.c(aVar);
            this.f19268c = null;
            aVar.resumeWith(Result.m75constructorimpl(g.f12633a));
        }
        if (i3 == 1) {
            kotlin.jvm.internal.e.c(null);
            throw null;
        }
        if (i3 == 2 || i3 == 3) {
            return true;
        }
        if (i3 == 4) {
            return false;
        }
        throw a();
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i3 = this.f19266a;
        if (i3 == 0 || i3 == 1) {
            if (hasNext()) {
                return next();
            }
            throw new NoSuchElementException();
        }
        if (i3 == 2) {
            this.f19266a = 1;
            kotlin.jvm.internal.e.c(null);
            throw null;
        }
        if (i3 != 3) {
            throw a();
        }
        this.f19266a = 0;
        String str = this.f19267b;
        this.f19267b = null;
        return str;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // gh.a
    public final void resumeWith(Object obj) {
        wb.a(obj);
        this.f19266a = 4;
    }
}
