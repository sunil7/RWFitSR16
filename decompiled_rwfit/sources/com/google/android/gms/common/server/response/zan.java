package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import q9.n;
import u8.b;

/* loaded from: classes.dex */
public final class zan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zan> CREATOR = new b(16);

    /* renamed from: a, reason: collision with root package name */
    public final int f9162a;
    private final HashMap zab;
    private final String zac;

    public zan(int i3, String str, ArrayList arrayList) {
        this.f9162a = i3;
        HashMap hashMap = new HashMap();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            zal zalVar = (zal) arrayList.get(i10);
            String str2 = zalVar.f9157b;
            HashMap hashMap2 = new HashMap();
            ArrayList arrayList2 = zalVar.f9158c;
            n.e(arrayList2);
            int size2 = arrayList2.size();
            for (int i11 = 0; i11 < size2; i11++) {
                zam zamVar = (zam) arrayList2.get(i11);
                hashMap2.put(zamVar.f9160b, zamVar.f9161c);
            }
            hashMap.put(str2, hashMap2);
        }
        this.zab = hashMap;
        n.e(str);
        this.zac = str;
        Iterator it = hashMap.keySet().iterator();
        while (it.hasNext()) {
            Map map = (Map) this.zab.get((String) it.next());
            Iterator it2 = map.keySet().iterator();
            while (it2.hasNext()) {
                ((FastJsonResponse$Field) map.get((String) it2.next())).j(this);
            }
        }
    }

    public final String b() {
        return this.zac;
    }

    public final Map h(String str) {
        return (Map) this.zab.get(str);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        for (String str : this.zab.keySet()) {
            sb2.append(str);
            sb2.append(":\n");
            Map map = (Map) this.zab.get(str);
            for (String str2 : map.keySet()) {
                sb2.append("  ");
                sb2.append(str2);
                sb2.append(": ");
                sb2.append(map.get(str2));
            }
        }
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = u.i(parcel, 20293);
        u.k(parcel, 1, 4);
        parcel.writeInt(this.f9162a);
        ArrayList arrayList = new ArrayList();
        for (String str : this.zab.keySet()) {
            arrayList.add(new zal(str, (Map) this.zab.get(str)));
        }
        u.h(parcel, 2, arrayList);
        u.e(parcel, 3, this.zac);
        u.j(parcel, i10);
    }
}
