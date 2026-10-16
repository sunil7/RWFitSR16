package ef;

import com.otaliastudios.cameraview.controls.Audio;
import com.otaliastudios.cameraview.controls.AudioCodec;
import com.otaliastudios.cameraview.controls.Engine;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.controls.Grid;
import com.otaliastudios.cameraview.controls.Hdr;
import com.otaliastudios.cameraview.controls.Mode;
import com.otaliastudios.cameraview.controls.PictureFormat;
import com.otaliastudios.cameraview.controls.Preview;
import com.otaliastudios.cameraview.controls.VideoCodec;
import com.otaliastudios.cameraview.controls.WhiteBalance;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/* loaded from: classes2.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public final HashSet f12600a = new HashSet(5);

    /* renamed from: b, reason: collision with root package name */
    public final HashSet f12601b = new HashSet(2);

    /* renamed from: c, reason: collision with root package name */
    public final HashSet f12602c = new HashSet(4);

    /* renamed from: d, reason: collision with root package name */
    public final HashSet f12603d = new HashSet(2);
    public final HashSet e = new HashSet(15);

    /* renamed from: f, reason: collision with root package name */
    public final HashSet f12604f = new HashSet(5);

    /* renamed from: g, reason: collision with root package name */
    public final HashSet f12605g = new HashSet(4);

    /* renamed from: h, reason: collision with root package name */
    public final HashSet f12606h = new HashSet(3);

    /* renamed from: i, reason: collision with root package name */
    public final HashSet f12607i = new HashSet(2);

    /* renamed from: j, reason: collision with root package name */
    public final HashSet f12608j = new HashSet(2);

    /* renamed from: k, reason: collision with root package name */
    public boolean f12609k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f12610l;

    /* renamed from: m, reason: collision with root package name */
    public float f12611m;

    /* renamed from: n, reason: collision with root package name */
    public float f12612n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f12613o;

    /* renamed from: p, reason: collision with root package name */
    public float f12614p;

    /* renamed from: q, reason: collision with root package name */
    public float f12615q;

    public final boolean a(com.otaliastudios.cameraview.controls.a aVar) {
        Class<?> cls = aVar.getClass();
        return (cls.equals(Audio.class) ? Arrays.asList(Audio.values()) : cls.equals(Facing.class) ? Collections.unmodifiableSet(this.f12601b) : cls.equals(Flash.class) ? Collections.unmodifiableSet(this.f12602c) : cls.equals(Grid.class) ? Arrays.asList(Grid.values()) : cls.equals(Hdr.class) ? Collections.unmodifiableSet(this.f12603d) : cls.equals(Mode.class) ? Arrays.asList(Mode.values()) : cls.equals(VideoCodec.class) ? Arrays.asList(VideoCodec.values()) : cls.equals(AudioCodec.class) ? Arrays.asList(AudioCodec.values()) : cls.equals(WhiteBalance.class) ? Collections.unmodifiableSet(this.f12600a) : cls.equals(Engine.class) ? Arrays.asList(Engine.values()) : cls.equals(Preview.class) ? Arrays.asList(Preview.values()) : cls.equals(PictureFormat.class) ? Collections.unmodifiableSet(this.f12607i) : Collections.EMPTY_LIST).contains(aVar);
    }
}
