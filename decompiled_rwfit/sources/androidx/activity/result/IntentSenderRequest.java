package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class IntentSenderRequest implements Parcelable {
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new androidx.databinding.g(7);
    private final Intent mFillInIntent;
    private final int mFlagsMask;
    private final int mFlagsValues;
    private final IntentSender mIntentSender;

    public IntentSenderRequest(IntentSender intentSender, Intent intent, int i3, int i10) {
        this.mIntentSender = intentSender;
        this.mFillInIntent = intent;
        this.mFlagsMask = i3;
        this.mFlagsValues = i10;
    }

    public final Intent a() {
        return this.mFillInIntent;
    }

    public final int b() {
        return this.mFlagsMask;
    }

    public final int d() {
        return this.mFlagsValues;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final IntentSender h() {
        return this.mIntentSender;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.mIntentSender, i3);
        parcel.writeParcelable(this.mFillInIntent, i3);
        parcel.writeInt(this.mFlagsMask);
        parcel.writeInt(this.mFlagsValues);
    }

    public IntentSenderRequest(Parcel parcel) {
        this.mIntentSender = (IntentSender) parcel.readParcelable(IntentSender.class.getClassLoader());
        this.mFillInIntent = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.mFlagsMask = parcel.readInt();
        this.mFlagsValues = parcel.readInt();
    }
}
