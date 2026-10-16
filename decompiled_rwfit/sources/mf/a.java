package mf;

import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.controls.Hdr;
import com.otaliastudios.cameraview.controls.PictureFormat;
import com.otaliastudios.cameraview.controls.WhiteBalance;
import ef.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import wf.b;

/* loaded from: classes2.dex */
public final class a extends c {
    public a(Camera.Parameters parameters, int i3, boolean z5) {
        CamcorderProfile camcorderProfile;
        int i10;
        int i11;
        if (p001if.a.f14421a == null) {
            p001if.a.f14421a = new p001if.a();
        }
        p001if.a aVar = p001if.a.f14421a;
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i12 = 0; i12 < numberOfCameras; i12++) {
            Camera.getCameraInfo(i12, cameraInfo);
            int i13 = cameraInfo.facing;
            HashMap hashMap = p001if.a.f14424d;
            Integer valueOf = Integer.valueOf(i13);
            aVar.getClass();
            Facing facing = (Facing) p001if.a.a(hashMap, valueOf);
            if (facing != null) {
                this.f12601b.add(facing);
            }
        }
        List<String> supportedWhiteBalance = parameters.getSupportedWhiteBalance();
        if (supportedWhiteBalance != null) {
            for (String str : supportedWhiteBalance) {
                HashMap hashMap2 = p001if.a.f14423c;
                aVar.getClass();
                WhiteBalance whiteBalance = (WhiteBalance) p001if.a.a(hashMap2, str);
                if (whiteBalance != null) {
                    this.f12600a.add(whiteBalance);
                }
            }
        }
        this.f12602c.add(Flash.OFF);
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        if (supportedFlashModes != null) {
            for (String str2 : supportedFlashModes) {
                HashMap hashMap3 = p001if.a.f14422b;
                aVar.getClass();
                Flash flash = (Flash) p001if.a.a(hashMap3, str2);
                if (flash != null) {
                    this.f12602c.add(flash);
                }
            }
        }
        this.f12603d.add(Hdr.OFF);
        List<String> supportedSceneModes = parameters.getSupportedSceneModes();
        if (supportedSceneModes != null) {
            for (String str3 : supportedSceneModes) {
                HashMap hashMap4 = p001if.a.e;
                aVar.getClass();
                Hdr hdr = (Hdr) p001if.a.a(hashMap4, str3);
                if (hdr != null) {
                    this.f12603d.add(hdr);
                }
            }
        }
        this.f12609k = parameters.isZoomSupported();
        this.f12613o = parameters.getSupportedFocusModes().contains("auto");
        float exposureCompensationStep = parameters.getExposureCompensationStep();
        this.f12611m = parameters.getMinExposureCompensation() * exposureCompensationStep;
        this.f12612n = parameters.getMaxExposureCompensation() * exposureCompensationStep;
        this.f12610l = (parameters.getMinExposureCompensation() == 0 && parameters.getMaxExposureCompensation() == 0) ? false : true;
        for (Camera.Size size : parameters.getSupportedPictureSizes()) {
            int i14 = z5 ? size.height : size.width;
            int i15 = z5 ? size.width : size.height;
            this.e.add(new b(i14, i15));
            this.f12605g.add(wf.a.a(i14, i15));
        }
        long j4 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        HashMap hashMap5 = qf.b.f17937b;
        ArrayList arrayList = new ArrayList(hashMap5.keySet());
        Collections.sort(arrayList, new qf.a(j4 * j4));
        while (true) {
            if (arrayList.size() <= 0) {
                camcorderProfile = CamcorderProfile.get(i3, 0);
                break;
            }
            int intValue = ((Integer) hashMap5.get((b) arrayList.remove(0))).intValue();
            if (CamcorderProfile.hasProfile(i3, intValue)) {
                camcorderProfile = CamcorderProfile.get(i3, intValue);
                break;
            }
        }
        int i16 = camcorderProfile.videoFrameWidth;
        int i17 = camcorderProfile.videoFrameHeight;
        List<Camera.Size> supportedVideoSizes = parameters.getSupportedVideoSizes();
        if (supportedVideoSizes != null) {
            for (Camera.Size size2 : supportedVideoSizes) {
                int i18 = size2.width;
                if (i18 <= i16 && (i11 = size2.height) <= i17) {
                    int i19 = z5 ? i11 : i18;
                    i18 = z5 ? i18 : i11;
                    this.f12604f.add(new b(i19, i18));
                    this.f12606h.add(wf.a.a(i19, i18));
                }
            }
        } else {
            for (Camera.Size size3 : parameters.getSupportedPreviewSizes()) {
                int i20 = size3.width;
                if (i20 <= i16 && (i10 = size3.height) <= i17) {
                    int i21 = z5 ? i10 : i20;
                    i20 = z5 ? i20 : i10;
                    this.f12604f.add(new b(i21, i20));
                    this.f12606h.add(wf.a.a(i21, i20));
                }
            }
        }
        this.f12614p = Float.MAX_VALUE;
        this.f12615q = -3.4028235E38f;
        for (int[] iArr : parameters.getSupportedPreviewFpsRange()) {
            float f2 = iArr[0] / 1000.0f;
            this.f12614p = Math.min(this.f12614p, f2);
            this.f12615q = Math.max(this.f12615q, iArr[1] / 1000.0f);
        }
        this.f12607i.add(PictureFormat.JPEG);
        this.f12608j.add(17);
    }

    public a(CameraManager cameraManager, String str, boolean z5, int i3) {
        CamcorderProfile camcorderProfile;
        if (p001if.c.f14426a == null) {
            p001if.c.f14426a = new p001if.c();
        }
        p001if.c cVar = p001if.c.f14426a;
        CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
        for (String str2 : cameraManager.getCameraIdList()) {
            Integer num = (Integer) cameraManager.getCameraCharacteristics(str2).get(CameraCharacteristics.LENS_FACING);
            if (num != null) {
                HashMap hashMap = p001if.c.f14427b;
                cVar.getClass();
                Facing facing = (Facing) p001if.c.a(hashMap, num);
                if (facing != null) {
                    this.f12601b.add(facing);
                }
            }
        }
        for (int i10 : (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES)) {
            HashMap hashMap2 = p001if.c.f14428c;
            Integer valueOf = Integer.valueOf(i10);
            cVar.getClass();
            WhiteBalance whiteBalance = (WhiteBalance) p001if.c.a(hashMap2, valueOf);
            if (whiteBalance != null) {
                this.f12600a.add(whiteBalance);
            }
        }
        this.f12602c.add(Flash.OFF);
        Boolean bool = (Boolean) cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        if (bool != null && bool.booleanValue()) {
            for (int i11 : (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES)) {
                cVar.getClass();
                HashSet hashSet = new HashSet();
                if (i11 != 0 && i11 != 1) {
                    if (i11 != 2) {
                        if (i11 == 3) {
                            hashSet.add(Flash.ON);
                        } else if (i11 != 4) {
                        }
                    }
                    hashSet.add(Flash.AUTO);
                } else {
                    hashSet.add(Flash.OFF);
                    hashSet.add(Flash.TORCH);
                }
                this.f12602c.addAll(hashSet);
            }
        }
        this.f12603d.add(Hdr.OFF);
        for (int i12 : (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AVAILABLE_SCENE_MODES)) {
            HashMap hashMap3 = p001if.c.f14429d;
            Integer valueOf2 = Integer.valueOf(i12);
            cVar.getClass();
            Hdr hdr = (Hdr) p001if.c.a(hashMap3, valueOf2);
            if (hdr != null) {
                this.f12603d.add(hdr);
            }
        }
        Float f2 = (Float) cameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
        if (f2 != null) {
            this.f12609k = f2.floatValue() > 1.0f;
        }
        Integer num2 = (Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
        Integer num3 = (Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AE);
        Integer num4 = (Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AWB);
        this.f12613o = (num2 != null && num2.intValue() > 0) || (num3 != null && num3.intValue() > 0) || (num4 != null && num4.intValue() > 0);
        Range range = (Range) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
        Rational rational = (Rational) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP);
        if (range != null && rational != null && rational.floatValue() != 0.0f) {
            this.f12611m = ((Integer) range.getLower()).intValue() / rational.floatValue();
            this.f12612n = ((Integer) range.getUpper()).intValue() / rational.floatValue();
        }
        this.f12610l = (this.f12611m == 0.0f || this.f12612n == 0.0f) ? false : true;
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap != null) {
            for (int i13 : streamConfigurationMap.getOutputFormats()) {
                if (i13 == i3) {
                    for (Size size : streamConfigurationMap.getOutputSizes(i3)) {
                        int height = z5 ? size.getHeight() : size.getWidth();
                        int width = z5 ? size.getWidth() : size.getHeight();
                        this.e.add(new b(height, width));
                        this.f12605g.add(wf.a.a(height, width));
                    }
                    ef.b bVar = qf.b.f17936a;
                    try {
                        int parseInt = Integer.parseInt(str);
                        HashMap hashMap4 = qf.b.f17937b;
                        ArrayList arrayList = new ArrayList(hashMap4.keySet());
                        Collections.sort(arrayList, new qf.a(SubsamplingScaleImageView.TILE_SIZE_AUTO * SubsamplingScaleImageView.TILE_SIZE_AUTO));
                        while (true) {
                            if (arrayList.size() > 0) {
                                int intValue = ((Integer) hashMap4.get((b) arrayList.remove(0))).intValue();
                                if (CamcorderProfile.hasProfile(parseInt, intValue)) {
                                    camcorderProfile = CamcorderProfile.get(parseInt, intValue);
                                    break;
                                }
                            } else {
                                camcorderProfile = CamcorderProfile.get(parseInt, 0);
                                break;
                            }
                        }
                    } catch (NumberFormatException unused) {
                        qf.b.f17936a.b(2, "NumberFormatException for Camera2 id:", str);
                        camcorderProfile = CamcorderProfile.get(0);
                    }
                    int i14 = camcorderProfile.videoFrameWidth;
                    int i15 = camcorderProfile.videoFrameHeight;
                    for (Size size2 : streamConfigurationMap.getOutputSizes(MediaRecorder.class)) {
                        if (size2.getWidth() <= i14 && size2.getHeight() <= i15) {
                            int height2 = z5 ? size2.getHeight() : size2.getWidth();
                            int width2 = z5 ? size2.getWidth() : size2.getHeight();
                            this.f12604f.add(new b(height2, width2));
                            this.f12606h.add(wf.a.a(height2, width2));
                        }
                    }
                    Range[] rangeArr = (Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
                    if (rangeArr != null) {
                        this.f12614p = Float.MAX_VALUE;
                        this.f12615q = -3.4028235E38f;
                        for (Range range2 : rangeArr) {
                            this.f12614p = Math.min(this.f12614p, ((Integer) range2.getLower()).intValue());
                            this.f12615q = Math.max(this.f12615q, ((Integer) range2.getUpper()).intValue());
                        }
                    } else {
                        this.f12614p = 0.0f;
                        this.f12615q = 0.0f;
                    }
                    this.f12607i.add(PictureFormat.JPEG);
                    int[] iArr = (int[]) cameraCharacteristics.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
                    if (iArr != null) {
                        for (int i16 : iArr) {
                            if (i16 == 3) {
                                this.f12607i.add(PictureFormat.DNG);
                            }
                        }
                    }
                    this.f12608j.add(35);
                    for (int i17 : streamConfigurationMap.getOutputFormats()) {
                        if (ImageFormat.getBitsPerPixel(i17) > 0) {
                            this.f12608j.add(Integer.valueOf(i17));
                        }
                    }
                    return;
                }
            }
            throw new IllegalStateException(l0.j(i3, "Picture format not supported: "));
        }
        throw new RuntimeException("StreamConfigurationMap is null. Should not happen.");
    }
}
