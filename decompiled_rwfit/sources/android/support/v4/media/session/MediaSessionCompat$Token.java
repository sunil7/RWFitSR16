package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class MediaSessionCompat$Token implements Parcelable {
    public static final Parcelable.Creator<MediaSessionCompat$Token> CREATOR = new f(2);
    private c mExtraBinder;
    private final Object mInner;
    private final Object mLock = new Object();
    private l2.d mSession2Token = null;

    public MediaSessionCompat$Token(Parcelable parcelable, c cVar) {
        this.mInner = parcelable;
        this.mExtraBinder = cVar;
    }

    public final c a() {
        c cVar;
        synchronized (this.mLock) {
            cVar = this.mExtraBinder;
        }
        return cVar;
    }

    public final Object b() {
        return this.mInner;
    }

    public final void d(c cVar) {
        synchronized (this.mLock) {
            this.mExtraBinder = cVar;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaSessionCompat$Token)) {
            return false;
        }
        MediaSessionCompat$Token mediaSessionCompat$Token = (MediaSessionCompat$Token) obj;
        Object obj2 = this.mInner;
        if (obj2 == null) {
            return mediaSessionCompat$Token.mInner == null;
        }
        Object obj3 = mediaSessionCompat$Token.mInner;
        if (obj3 == null) {
            return false;
        }
        return obj2.equals(obj3);
    }

    public final void h(l2.d dVar) {
        synchronized (this.mLock) {
            this.mSession2Token = dVar;
        }
    }

    public final int hashCode() {
        Object obj = this.mInner;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable((Parcelable) this.mInner, i3);
    }
}
