package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new a();
    private final Month end;
    private final int monthSpan;
    private Month openAt;
    private final Month start;
    private final DateValidator validator;
    private final int yearSpan;

    public interface DateValidator extends Parcelable {
        boolean g(long j4);
    }

    public CalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3) {
        this.start = month;
        this.end = month2;
        this.openAt = month3;
        this.validator = dateValidator;
        if (month3 != null && month.compareTo(month3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (month3 != null && month3.compareTo(month2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        this.monthSpan = month.n(month2) + 1;
        this.yearSpan = (month2.f10406b - month.f10406b) + 1;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        return this.start.equals(calendarConstraints.start) && this.end.equals(calendarConstraints.end) && k1.b.a(this.openAt, calendarConstraints.openAt) && this.validator.equals(calendarConstraints.validator);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.start, this.end, this.openAt, this.validator});
    }

    public final Month i(Month month) {
        return month.compareTo(this.start) < 0 ? this.start : month.compareTo(this.end) > 0 ? this.end : month;
    }

    public final DateValidator j() {
        return this.validator;
    }

    public final Month k() {
        return this.end;
    }

    public final int l() {
        return this.monthSpan;
    }

    public final Month m() {
        return this.openAt;
    }

    public final Month n() {
        return this.start;
    }

    public final int o() {
        return this.yearSpan;
    }

    public final boolean p(long j4) {
        if (this.start.i(1) > j4) {
            return false;
        }
        Month month = this.end;
        return j4 <= month.i(month.f10408d);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.start, 0);
        parcel.writeParcelable(this.end, 0);
        parcel.writeParcelable(this.openAt, 0);
        parcel.writeParcelable(this.validator, 0);
    }
}
