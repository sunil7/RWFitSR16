package androidx.media;

import android.media.AudioAttributes;
import l2.b;

/* loaded from: classes.dex */
public class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(b bVar) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.f2417a = (AudioAttributes) bVar.g(audioAttributesImplApi21.f2417a, 1);
        audioAttributesImplApi21.f2418b = bVar.f(audioAttributesImplApi21.f2418b, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, b bVar) {
        bVar.getClass();
        bVar.k(audioAttributesImplApi21.f2417a, 1);
        bVar.j(audioAttributesImplApi21.f2418b, 2);
    }
}
