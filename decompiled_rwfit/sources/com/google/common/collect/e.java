package com.google.common.collect;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class e extends x0 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f11059b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f11060c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(f fVar, int i3) {
        super(1);
        this.f11059b = i3;
        this.f11060c = fVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f11059b) {
            case 0:
                this.f11060c.clear();
                break;
            default:
                this.f11060c.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.f11059b) {
            case 0:
                return this.f11060c.contains(obj);
            default:
                if (!(obj instanceof r1)) {
                    return false;
                }
                r1 r1Var = (r1) obj;
                if (r1Var.getCount() <= 0) {
                    return false;
                }
                return this.f11060c.count(r1Var.getElement()) == r1Var.getCount();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        switch (this.f11059b) {
            case 0:
                return this.f11060c.containsAll(collection);
            default:
                return super.containsAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        switch (this.f11059b) {
            case 0:
                return this.f11060c.isEmpty();
            default:
                return super.isEmpty();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f11059b) {
            case 0:
                return this.f11060c.elementIterator();
            default:
                return this.f11060c.entryIterator();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        switch (this.f11059b) {
            case 0:
                return this.f11060c.remove(obj, SubsamplingScaleImageView.TILE_SIZE_AUTO) > 0;
            default:
                if (!(obj instanceof r1)) {
                    return false;
                }
                r1 r1Var = (r1) obj;
                Object element = r1Var.getElement();
                int count = r1Var.getCount();
                if (count != 0) {
                    return this.f11060c.setCount(element, count, 0);
                }
                return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.f11059b) {
            case 0:
                return this.f11060c.entrySet().size();
            default:
                return this.f11060c.distinctElements();
        }
    }
}
