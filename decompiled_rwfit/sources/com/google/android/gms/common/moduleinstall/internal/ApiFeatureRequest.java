package com.google.android.gms.common.moduleinstall.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.u;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import q9.n;
import u9.a;
import u9.b;

/* loaded from: classes.dex */
public class ApiFeatureRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ApiFeatureRequest> CREATOR = new b();
    private static final Comparator zaa = a.f19024a;
    private final List zab;
    private final boolean zac;
    private final String zad;
    private final String zae;

    public ApiFeatureRequest(ArrayList arrayList, boolean z5, String str, String str2) {
        n.e(arrayList);
        this.zab = arrayList;
        this.zac = z5;
        this.zad = str;
        this.zae = str2;
    }

    public static ApiFeatureRequest h(List list, boolean z5) {
        TreeSet treeSet = new TreeSet(zaa);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Collections.addAll(treeSet, ((j) it.next()).b());
        }
        return new ApiFeatureRequest(new ArrayList(treeSet), z5, null, null);
    }

    public final List b() {
        return this.zab;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ApiFeatureRequest)) {
            return false;
        }
        ApiFeatureRequest apiFeatureRequest = (ApiFeatureRequest) obj;
        return this.zac == apiFeatureRequest.zac && n.h(this.zab, apiFeatureRequest.zab) && n.h(this.zad, apiFeatureRequest.zad) && n.h(this.zae, apiFeatureRequest.zae);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.zac), this.zab, this.zad, this.zae});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = u.i(parcel, 20293);
        u.h(parcel, 1, this.zab);
        boolean z5 = this.zac;
        u.k(parcel, 2, 4);
        parcel.writeInt(z5 ? 1 : 0);
        u.e(parcel, 3, this.zad);
        u.e(parcel, 4, this.zae);
        u.j(parcel, i10);
    }
}
