package com.google.android.exoplayer2;

import android.net.Uri;
import com.google.android.gms.internal.mlkit_vision_barcode.fa;
import com.google.android.gms.internal.mlkit_vision_barcode.ga;
import java.util.List;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f8864a;

    /* renamed from: b, reason: collision with root package name */
    public final List f8865b;

    /* renamed from: c, reason: collision with root package name */
    public final List f8866c;

    public j(Uri uri, ga gaVar, fa faVar, List list, List list2) {
        this.f8864a = uri;
        this.f8865b = list;
        this.f8866c = list2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (!this.f8864a.equals(jVar.f8864a)) {
            return false;
        }
        int i3 = i9.g.f14378a;
        return i9.g.a(null, null) && i9.g.a(null, null) && this.f8865b.equals(jVar.f8865b) && this.f8866c.equals(jVar.f8866c);
    }

    public final int hashCode() {
        return (this.f8866c.hashCode() + ((this.f8865b.hashCode() + (this.f8864a.hashCode() * 923521)) * 961)) * 31;
    }
}
