package androidx.media;

import android.media.AudioAttributes;

/* loaded from: classes.dex */
public class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* renamed from: a, reason: collision with root package name */
    public AudioAttributes f2417a;

    /* renamed from: b, reason: collision with root package name */
    public int f2418b = -1;

    public final boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplApi21) {
            return this.f2417a.equals(((AudioAttributesImplApi21) obj).f2417a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f2417a.hashCode();
    }

    public final String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f2417a;
    }
}
