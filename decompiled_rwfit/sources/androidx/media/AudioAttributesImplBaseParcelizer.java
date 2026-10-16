package androidx.media;

import l2.b;

/* loaded from: classes.dex */
public class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(b bVar) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f2419a = bVar.f(audioAttributesImplBase.f2419a, 1);
        audioAttributesImplBase.f2420b = bVar.f(audioAttributesImplBase.f2420b, 2);
        audioAttributesImplBase.f2421c = bVar.f(audioAttributesImplBase.f2421c, 3);
        audioAttributesImplBase.f2422d = bVar.f(audioAttributesImplBase.f2422d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, b bVar) {
        bVar.getClass();
        bVar.j(audioAttributesImplBase.f2419a, 1);
        bVar.j(audioAttributesImplBase.f2420b, 2);
        bVar.j(audioAttributesImplBase.f2421c, 3);
        bVar.j(audioAttributesImplBase.f2422d, 4);
    }
}
