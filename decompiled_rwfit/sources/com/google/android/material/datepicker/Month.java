package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateUtils;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* loaded from: classes.dex */
final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new u(0);

    /* renamed from: a, reason: collision with root package name */
    public final int f10405a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10406b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10407c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10408d;
    public final long e;
    private final Calendar firstOfMonth;
    private String longName;

    public Month(Calendar calendar) {
        calendar.set(5, 1);
        Calendar b3 = e0.b(calendar);
        this.firstOfMonth = b3;
        this.f10405a = b3.get(2);
        this.f10406b = b3.get(1);
        this.f10407c = b3.getMaximum(7);
        this.f10408d = b3.getActualMaximum(5);
        this.e = b3.getTimeInMillis();
    }

    public static Month b(int i3, int i10) {
        Calendar f2 = e0.f(null);
        f2.set(1, i3);
        f2.set(2, i10);
        return new Month(f2);
    }

    public static Month d(long j4) {
        Calendar f2 = e0.f(null);
        f2.setTimeInMillis(j4);
        return new Month(f2);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(Month month) {
        return this.firstOfMonth.compareTo(month.firstOfMonth);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month = (Month) obj;
        return this.f10405a == month.f10405a && this.f10406b == month.f10406b;
    }

    public final int h() {
        int firstDayOfWeek = this.firstOfMonth.get(7) - this.firstOfMonth.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.f10407c : firstDayOfWeek;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f10405a), Integer.valueOf(this.f10406b)});
    }

    public final long i(int i3) {
        Calendar b3 = e0.b(this.firstOfMonth);
        b3.set(5, i3);
        return b3.getTimeInMillis();
    }

    public final int j(long j4) {
        Calendar b3 = e0.b(this.firstOfMonth);
        b3.setTimeInMillis(j4);
        return b3.get(5);
    }

    public final String k(Context context) {
        if (this.longName == null) {
            this.longName = DateUtils.formatDateTime(context, this.firstOfMonth.getTimeInMillis() - TimeZone.getDefault().getOffset(r0), 36);
        }
        return this.longName;
    }

    public final long l() {
        return this.firstOfMonth.getTimeInMillis();
    }

    public final Month m(int i3) {
        Calendar b3 = e0.b(this.firstOfMonth);
        b3.add(2, i3);
        return new Month(b3);
    }

    public final int n(Month month) {
        if (!(this.firstOfMonth instanceof GregorianCalendar)) {
            throw new IllegalArgumentException("Only Gregorian calendars are supported.");
        }
        return (month.f10405a - this.f10405a) + ((month.f10406b - this.f10406b) * 12);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f10406b);
        parcel.writeInt(this.f10405a);
    }
}
