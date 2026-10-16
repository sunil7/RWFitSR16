package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class CompositeDateValidator implements CalendarConstraints.DateValidator {
    private static final int COMPARATOR_ALL_ID = 2;
    private static final int COMPARATOR_ANY_ID = 1;
    private final g operator;
    private final List<CalendarConstraints.DateValidator> validators;
    private static final g ANY_OPERATOR = new d();
    private static final g ALL_OPERATOR = new e();
    public static final Parcelable.Creator<CompositeDateValidator> CREATOR = new f();

    public CompositeDateValidator(ArrayList arrayList, g gVar) {
        this.validators = arrayList;
        this.operator = gVar;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompositeDateValidator)) {
            return false;
        }
        CompositeDateValidator compositeDateValidator = (CompositeDateValidator) obj;
        return this.validators.equals(compositeDateValidator.validators) && this.operator.getId() == compositeDateValidator.operator.getId();
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public final boolean g(long j4) {
        return this.operator.a(this.validators, j4);
    }

    public final int hashCode() {
        return this.validators.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeList(this.validators);
        parcel.writeInt(this.operator.getId());
    }
}
