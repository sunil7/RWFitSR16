package wh;

import java.util.RandomAccess;
import okio.ByteString;

/* loaded from: classes2.dex */
public final class u extends kotlin.collections.e implements RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    public final ByteString[] f19668a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f19669b;

    public u(ByteString[] byteStringArr, int[] iArr) {
        this.f19668a = byteStringArr;
        this.f19669b = iArr;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return super.contains((ByteString) obj);
        }
        return false;
    }

    @Override // java.util.List
    public final Object get(int i3) {
        return this.f19668a[i3];
    }

    @Override // kotlin.collections.AbstractCollection
    public final int getSize() {
        return this.f19668a.length;
    }

    @Override // kotlin.collections.e, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return super.indexOf((ByteString) obj);
        }
        return -1;
    }

    @Override // kotlin.collections.e, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return super.lastIndexOf((ByteString) obj);
        }
        return -1;
    }
}
