package com.dh.keeplive.entity;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.dh.keeplive.R$raw;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class DefaultConfig implements Parcelable {
    private boolean backgroundMusicEnabled;
    private boolean crashRestartEnabled;
    private boolean debug;
    private boolean musicEnabled;
    private int musicId;
    private boolean onePixEnabled;
    private long repeatInterval;
    private Intent restartIntent;
    private boolean workOnMainThread;
    private boolean workerEnabled;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<DefaultConfig> CREATOR = new Parcelable.Creator<DefaultConfig>() { // from class: com.dh.keeplive.entity.DefaultConfig$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DefaultConfig createFromParcel(Parcel source) {
            e.f(source, "source");
            return new DefaultConfig(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DefaultConfig[] newArray(int i3) {
            return new DefaultConfig[i3];
        }
    };

    public static final class Companion {
        public /* synthetic */ Companion(c cVar) {
            this();
        }

        private Companion() {
        }
    }

    public DefaultConfig() {
        this(false, false, false, 0L, 0, false, false, false, false, null, 1023, null);
    }

    public static /* synthetic */ DefaultConfig copy$default(DefaultConfig defaultConfig, boolean z5, boolean z6, boolean z8, long j4, int i3, boolean z10, boolean z11, boolean z12, boolean z13, Intent intent, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z5 = defaultConfig.debug;
        }
        if ((i10 & 2) != 0) {
            z6 = defaultConfig.musicEnabled;
        }
        if ((i10 & 4) != 0) {
            z8 = defaultConfig.backgroundMusicEnabled;
        }
        if ((i10 & 8) != 0) {
            j4 = defaultConfig.repeatInterval;
        }
        if ((i10 & 16) != 0) {
            i3 = defaultConfig.musicId;
        }
        if ((i10 & 32) != 0) {
            z10 = defaultConfig.onePixEnabled;
        }
        if ((i10 & 64) != 0) {
            z11 = defaultConfig.workerEnabled;
        }
        if ((i10 & 128) != 0) {
            z12 = defaultConfig.crashRestartEnabled;
        }
        if ((i10 & 256) != 0) {
            z13 = defaultConfig.workOnMainThread;
        }
        if ((i10 & 512) != 0) {
            intent = defaultConfig.restartIntent;
        }
        boolean z14 = z13;
        Intent intent2 = intent;
        long j10 = j4;
        boolean z15 = z8;
        return defaultConfig.copy(z5, z6, z15, j10, i3, z10, z11, z12, z14, intent2);
    }

    public final boolean component1() {
        return this.debug;
    }

    public final Intent component10() {
        return this.restartIntent;
    }

    public final boolean component2() {
        return this.musicEnabled;
    }

    public final boolean component3() {
        return this.backgroundMusicEnabled;
    }

    public final long component4() {
        return this.repeatInterval;
    }

    public final int component5() {
        return this.musicId;
    }

    public final boolean component6() {
        return this.onePixEnabled;
    }

    public final boolean component7() {
        return this.workerEnabled;
    }

    public final boolean component8() {
        return this.crashRestartEnabled;
    }

    public final boolean component9() {
        return this.workOnMainThread;
    }

    public final DefaultConfig copy(boolean z5, boolean z6, boolean z8, long j4, int i3, boolean z10, boolean z11, boolean z12, boolean z13, Intent intent) {
        return new DefaultConfig(z5, z6, z8, j4, i3, z10, z11, z12, z13, intent);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DefaultConfig)) {
            return false;
        }
        DefaultConfig defaultConfig = (DefaultConfig) obj;
        return this.debug == defaultConfig.debug && this.musicEnabled == defaultConfig.musicEnabled && this.backgroundMusicEnabled == defaultConfig.backgroundMusicEnabled && this.repeatInterval == defaultConfig.repeatInterval && this.musicId == defaultConfig.musicId && this.onePixEnabled == defaultConfig.onePixEnabled && this.workerEnabled == defaultConfig.workerEnabled && this.crashRestartEnabled == defaultConfig.crashRestartEnabled && this.workOnMainThread == defaultConfig.workOnMainThread && e.a(this.restartIntent, defaultConfig.restartIntent);
    }

    public final boolean getBackgroundMusicEnabled() {
        return this.backgroundMusicEnabled;
    }

    public final boolean getCrashRestartEnabled() {
        return this.crashRestartEnabled;
    }

    public final boolean getDebug() {
        return this.debug;
    }

    public final boolean getMusicEnabled() {
        return this.musicEnabled;
    }

    public final int getMusicId() {
        return this.musicId;
    }

    public final boolean getOnePixEnabled() {
        return this.onePixEnabled;
    }

    public final long getRepeatInterval() {
        return this.repeatInterval;
    }

    public final Intent getRestartIntent() {
        return this.restartIntent;
    }

    public final boolean getWorkOnMainThread() {
        return this.workOnMainThread;
    }

    public final boolean getWorkerEnabled() {
        return this.workerEnabled;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v12, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v8, types: [boolean] */
    public int hashCode() {
        boolean z5 = this.debug;
        ?? r02 = z5;
        if (z5) {
            r02 = 1;
        }
        int i3 = r02 * 31;
        ?? r22 = this.musicEnabled;
        int i10 = r22;
        if (r22 != 0) {
            i10 = 1;
        }
        int i11 = (i3 + i10) * 31;
        ?? r23 = this.backgroundMusicEnabled;
        int i12 = r23;
        if (r23 != 0) {
            i12 = 1;
        }
        int hashCode = (Integer.hashCode(this.musicId) + ((Long.hashCode(this.repeatInterval) + ((i11 + i12) * 31)) * 31)) * 31;
        ?? r24 = this.onePixEnabled;
        int i13 = r24;
        if (r24 != 0) {
            i13 = 1;
        }
        int i14 = (hashCode + i13) * 31;
        ?? r25 = this.workerEnabled;
        int i15 = r25;
        if (r25 != 0) {
            i15 = 1;
        }
        int i16 = (i14 + i15) * 31;
        ?? r26 = this.crashRestartEnabled;
        int i17 = r26;
        if (r26 != 0) {
            i17 = 1;
        }
        int i18 = (i16 + i17) * 31;
        boolean z6 = this.workOnMainThread;
        int i19 = (i18 + (z6 ? 1 : z6 ? 1 : 0)) * 31;
        Intent intent = this.restartIntent;
        return i19 + (intent == null ? 0 : intent.hashCode());
    }

    public final void setBackgroundMusicEnabled(boolean z5) {
        this.backgroundMusicEnabled = z5;
    }

    public final void setCrashRestartEnabled(boolean z5) {
        this.crashRestartEnabled = z5;
    }

    public final void setDebug(boolean z5) {
        this.debug = z5;
    }

    public final void setMusicEnabled(boolean z5) {
        this.musicEnabled = z5;
    }

    public final void setMusicId(int i3) {
        this.musicId = i3;
    }

    public final void setOnePixEnabled(boolean z5) {
        this.onePixEnabled = z5;
    }

    public final void setRepeatInterval(long j4) {
        this.repeatInterval = j4;
    }

    public final void setRestartIntent(Intent intent) {
        this.restartIntent = intent;
    }

    public final void setWorkOnMainThread(boolean z5) {
        this.workOnMainThread = z5;
    }

    public final void setWorkerEnabled(boolean z5) {
        this.workerEnabled = z5;
    }

    public String toString() {
        return "DefaultConfig(debug=" + this.debug + ", musicEnabled=" + this.musicEnabled + ", backgroundMusicEnabled=" + this.backgroundMusicEnabled + ", repeatInterval=" + this.repeatInterval + ", musicId=" + this.musicId + ", onePixEnabled=" + this.onePixEnabled + ", workerEnabled=" + this.workerEnabled + ", crashRestartEnabled=" + this.crashRestartEnabled + ", workOnMainThread=" + this.workOnMainThread + ", restartIntent=" + this.restartIntent + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i3) {
        e.f(dest, "dest");
        dest.writeInt(this.debug ? 1 : 0);
        dest.writeInt(this.musicEnabled ? 1 : 0);
        dest.writeInt(this.backgroundMusicEnabled ? 1 : 0);
        dest.writeLong(this.repeatInterval);
        dest.writeInt(this.musicId);
        dest.writeInt(this.onePixEnabled ? 1 : 0);
        dest.writeInt(this.workerEnabled ? 1 : 0);
        dest.writeInt(this.crashRestartEnabled ? 1 : 0);
        dest.writeInt(this.workOnMainThread ? 1 : 0);
        dest.writeParcelable(this.restartIntent, 0);
    }

    public DefaultConfig(boolean z5, boolean z6, boolean z8, long j4, int i3, boolean z10, boolean z11, boolean z12, boolean z13, Intent intent) {
        this.debug = z5;
        this.musicEnabled = z6;
        this.backgroundMusicEnabled = z8;
        this.repeatInterval = j4;
        this.musicId = i3;
        this.onePixEnabled = z10;
        this.workerEnabled = z11;
        this.crashRestartEnabled = z12;
        this.workOnMainThread = z13;
        this.restartIntent = intent;
    }

    public /* synthetic */ DefaultConfig(boolean z5, boolean z6, boolean z8, long j4, int i3, boolean z10, boolean z11, boolean z12, boolean z13, Intent intent, int i10, c cVar) {
        this((i10 & 1) != 0 ? true : z5, (i10 & 2) != 0 ? false : z6, (i10 & 4) != 0 ? false : z8, (i10 & 8) != 0 ? 0L : j4, (i10 & 16) != 0 ? R$raw.nosound : i3, (i10 & 32) != 0 ? true : z10, (i10 & 64) != 0 ? true : z11, (i10 & 128) != 0 ? false : z12, (i10 & 256) != 0 ? false : z13, (i10 & 512) != 0 ? null : intent);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultConfig(Parcel source) {
        this(1 == source.readInt(), 1 == source.readInt(), 1 == source.readInt(), source.readLong(), source.readInt(), 1 == source.readInt(), 1 == source.readInt(), 1 == source.readInt(), 1 == source.readInt(), (Intent) source.readParcelable(Intent.class.getClassLoader()));
        e.f(source, "source");
    }
}
