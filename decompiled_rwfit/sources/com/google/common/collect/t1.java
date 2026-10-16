package com.google.common.collect;

import com.google.android.gms.internal.mlkit_vision_barcode.jb;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
public abstract class t1 implements r1 {
    public boolean equals(@NullableDecl Object obj) {
        if (obj instanceof r1) {
            r1 r1Var = (r1) obj;
            if (getCount() == r1Var.getCount() && jb.a(getElement(), r1Var.getElement())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        Object element = getElement();
        return (element == null ? 0 : element.hashCode()) ^ getCount();
    }

    public String toString() {
        String valueOf = String.valueOf(getElement());
        int count = getCount();
        if (count == 1) {
            return valueOf;
        }
        return valueOf + " x " + count;
    }
}
