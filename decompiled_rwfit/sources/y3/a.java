package y3;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

/* loaded from: classes.dex */
public final class a implements b {

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f19985c = {"_data"};

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f19986d = {"_data"};

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19987a;

    /* renamed from: b, reason: collision with root package name */
    public final ContentResolver f19988b;

    public /* synthetic */ a(ContentResolver contentResolver, int i3) {
        this.f19987a = i3;
        this.f19988b = contentResolver;
    }

    @Override // y3.b
    public final Cursor a(Uri uri) {
        switch (this.f19987a) {
            case 0:
                String lastPathSegment = uri.getLastPathSegment();
                return this.f19988b.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f19985c, "kind = 1 AND image_id = ?", new String[]{lastPathSegment}, null);
            default:
                String lastPathSegment2 = uri.getLastPathSegment();
                return this.f19988b.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f19986d, "kind = 1 AND video_id = ?", new String[]{lastPathSegment2}, null);
        }
    }
}
