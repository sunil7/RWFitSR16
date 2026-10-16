package androidx.media;

import l2.b;
import l2.d;

/* loaded from: classes.dex */
public class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(b bVar) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        d dVar = audioAttributesCompat.f2416a;
        if (bVar.e(1)) {
            dVar = bVar.h();
        }
        audioAttributesCompat.f2416a = (AudioAttributesImpl) dVar;
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, b bVar) {
        bVar.getClass();
        AudioAttributesImpl audioAttributesImpl = audioAttributesCompat.f2416a;
        bVar.i(1);
        bVar.l(audioAttributesImpl);
    }
}
