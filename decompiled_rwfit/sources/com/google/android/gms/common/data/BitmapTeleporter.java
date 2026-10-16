package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.util.Log;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.u;
import ha.d;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import q9.n;

/* loaded from: classes.dex */
public class BitmapTeleporter extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<BitmapTeleporter> CREATOR = new d(19);

    /* renamed from: a, reason: collision with root package name */
    public final int f9089a;

    /* renamed from: b, reason: collision with root package name */
    public ParcelFileDescriptor f9090b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9091c;
    private Bitmap zad = null;
    private boolean zae = false;
    private File zaf;

    public BitmapTeleporter(int i3, ParcelFileDescriptor parcelFileDescriptor, int i10) {
        this.f9089a = i3;
        this.f9090b = parcelFileDescriptor;
        this.f9091c = i10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        if (this.f9090b == null) {
            Bitmap bitmap = this.zad;
            n.e(bitmap);
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getHeight() * bitmap.getRowBytes());
            bitmap.copyPixelsToBuffer(allocate);
            byte[] array = allocate.array();
            File file = this.zaf;
            if (file == null) {
                throw new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
            }
            try {
                File createTempFile = File.createTempFile("teleporter", ".tmp", file);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                    this.f9090b = ParcelFileDescriptor.open(createTempFile, AMapEngineUtils.MAX_P20_WIDTH);
                    createTempFile.delete();
                    DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(fileOutputStream));
                    try {
                        try {
                            dataOutputStream.writeInt(array.length);
                            dataOutputStream.writeInt(bitmap.getWidth());
                            dataOutputStream.writeInt(bitmap.getHeight());
                            dataOutputStream.writeUTF(bitmap.getConfig().toString());
                            dataOutputStream.write(array);
                        } finally {
                            try {
                                dataOutputStream.close();
                            } catch (IOException e) {
                                Log.w("BitmapTeleporter", "Could not close stream", e);
                            }
                        }
                    } catch (IOException e10) {
                        throw new IllegalStateException("Could not write into unlinked file", e10);
                    }
                } catch (FileNotFoundException unused) {
                    throw new IllegalStateException("Temporary file is somehow already deleted");
                }
            } catch (IOException e11) {
                throw new IllegalStateException("Could not create temporary file", e11);
            }
        }
        int i10 = u.i(parcel, 20293);
        u.k(parcel, 1, 4);
        parcel.writeInt(this.f9089a);
        u.d(parcel, 2, this.f9090b, i3 | 1);
        u.k(parcel, 3, 4);
        parcel.writeInt(this.f9091c);
        u.j(parcel, i10);
        this.f9090b = null;
    }
}
