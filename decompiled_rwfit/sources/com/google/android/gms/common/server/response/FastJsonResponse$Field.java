package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.internal.mlkit_vision_common.u;
import java.util.Map;
import org.joda.time.format.p;
import q9.n;
import x9.a;
import x9.b;

/* loaded from: classes.dex */
public class FastJsonResponse$Field<I, O> extends AbstractSafeParcelable {
    public static final b CREATOR = new b();

    /* renamed from: a, reason: collision with root package name */
    public final int f9149a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f9150b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9151c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f9152d;
    public final String e;

    /* renamed from: f, reason: collision with root package name */
    public final int f9153f;

    /* renamed from: g, reason: collision with root package name */
    public final Class f9154g;

    /* renamed from: h, reason: collision with root package name */
    public final String f9155h;
    private final int zai;
    private zan zaj;
    private final a zak;

    public FastJsonResponse$Field(int i3, int i10, boolean z5, int i11, boolean z6, String str, int i12, String str2, zaa zaaVar) {
        this.zai = i3;
        this.f9149a = i10;
        this.f9150b = z5;
        this.f9151c = i11;
        this.f9152d = z6;
        this.e = str;
        this.f9153f = i12;
        if (str2 == null) {
            this.f9154g = null;
            this.f9155h = null;
        } else {
            this.f9154g = SafeParcelResponse.class;
            this.f9155h = str2;
        }
        if (zaaVar == null) {
            this.zak = null;
        } else {
            this.zak = zaaVar.b();
        }
    }

    public final String h(Object obj) {
        n.e(this.zak);
        return ((StringToIntConverter) this.zak).b(obj);
    }

    public final Map i() {
        String str = this.f9155h;
        n.e(str);
        n.e(this.zaj);
        Map h4 = this.zaj.h(str);
        n.e(h4);
        return h4;
    }

    public final void j(zan zanVar) {
        this.zaj = zanVar;
    }

    public final boolean k() {
        return this.zak != null;
    }

    public final String toString() {
        p pVar = new p(this);
        pVar.a(Integer.valueOf(this.zai), "versionCode");
        pVar.a(Integer.valueOf(this.f9149a), "typeIn");
        pVar.a(Boolean.valueOf(this.f9150b), "typeInArray");
        pVar.a(Integer.valueOf(this.f9151c), "typeOut");
        pVar.a(Boolean.valueOf(this.f9152d), "typeOutArray");
        pVar.a(this.e, "outputFieldName");
        pVar.a(Integer.valueOf(this.f9153f), "safeParcelFieldId");
        String str = this.f9155h;
        if (str == null) {
            str = null;
        }
        pVar.a(str, "concreteTypeName");
        Class cls = this.f9154g;
        if (cls != null) {
            pVar.a(cls.getCanonicalName(), "concreteType.class");
        }
        a aVar = this.zak;
        if (aVar != null) {
            pVar.a(aVar.getClass().getCanonicalName(), "converterName");
        }
        return pVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = this.zai;
        int i11 = u.i(parcel, 20293);
        u.k(parcel, 1, 4);
        parcel.writeInt(i10);
        u.k(parcel, 2, 4);
        parcel.writeInt(this.f9149a);
        u.k(parcel, 3, 4);
        parcel.writeInt(this.f9150b ? 1 : 0);
        u.k(parcel, 4, 4);
        parcel.writeInt(this.f9151c);
        u.k(parcel, 5, 4);
        parcel.writeInt(this.f9152d ? 1 : 0);
        u.e(parcel, 6, this.e);
        u.k(parcel, 7, 4);
        parcel.writeInt(this.f9153f);
        zaa zaaVar = null;
        String str = this.f9155h;
        if (str == null) {
            str = null;
        }
        u.e(parcel, 8, str);
        a aVar = this.zak;
        if (aVar != null) {
            if (!(aVar instanceof StringToIntConverter)) {
                throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
            }
            zaaVar = new zaa((StringToIntConverter) aVar);
        }
        u.d(parcel, 9, zaaVar, i3);
        u.j(parcel, i11);
    }
}
