package com.google.zxing.qrcode.detector;

import java.io.Serializable;
import java.util.Comparator;
import kd.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class FinderPatternFinder$EstimatedModuleComparator implements Comparator<c>, Serializable {
    private FinderPatternFinder$EstimatedModuleComparator() {
    }

    @Override // java.util.Comparator
    public int compare(c cVar, c cVar2) {
        return Float.compare(cVar.f15611c, cVar2.f15611c);
    }
}
