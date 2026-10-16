package com.amap.api.col.p0003sl;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.model.BaseOptions;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.ArrayList;
import java.util.List;

@JBindingInclude
/* loaded from: classes.dex */
public class o5 extends BaseOptions implements Parcelable {

    @JBindingExclude
    public static final Parcelable.Creator<o5> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private float f4737a;

    /* renamed from: b, reason: collision with root package name */
    private float f4738b;

    /* renamed from: c, reason: collision with root package name */
    private float f4739c;

    /* renamed from: d, reason: collision with root package name */
    private float f4740d;
    private float e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f4741f;

    /* renamed from: g, reason: collision with root package name */
    private int f4742g;

    /* renamed from: h, reason: collision with root package name */
    private double f4743h;

    /* renamed from: i, reason: collision with root package name */
    private List<n5> f4744i;

    public static class a implements Parcelable.Creator<o5> {
        @Override // android.os.Parcelable.Creator
        public o5 createFromParcel(Parcel parcel) {
            return new o5(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public o5[] newArray(int i3) {
            return new o5[i3];
        }
    }

    @JBindingExclude
    public o5(Parcel parcel) {
        this.f4737a = 3.0f;
        this.f4738b = 20.0f;
        this.f4739c = Float.MIN_VALUE;
        this.f4740d = Float.MAX_VALUE;
        this.e = 200.0f;
        this.f4741f = true;
        this.f4742g = -3355444;
        this.f4743h = 3.0d;
        this.f4744i = new ArrayList();
        this.f4737a = parcel.readFloat();
        this.f4738b = parcel.readFloat();
        this.f4739c = parcel.readFloat();
        this.f4740d = parcel.readFloat();
        this.e = parcel.readFloat();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f4741f = zArr[0];
        this.f4742g = parcel.readInt();
        this.f4743h = parcel.readDouble();
        this.f4744i = parcel.readArrayList(n5.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeFloat(this.f4737a);
        parcel.writeFloat(this.f4738b);
        parcel.writeFloat(this.f4739c);
        parcel.writeFloat(this.f4740d);
        parcel.writeFloat(this.e);
        parcel.writeBooleanArray(new boolean[]{this.f4741f});
        parcel.writeInt(this.f4742g);
        parcel.writeDouble(this.f4743h);
        parcel.writeList(this.f4744i);
    }
}
