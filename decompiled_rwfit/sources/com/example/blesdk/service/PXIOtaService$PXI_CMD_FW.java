package com.example.blesdk.service;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class PXIOtaService$PXI_CMD_FW {
    public static final PXIOtaService$PXI_CMD_FW CMD_FW_CONNECTION_UPDATE;
    public static final PXIOtaService$PXI_CMD_FW CMD_FW_ERASE;
    public static final PXIOtaService$PXI_CMD_FW CMD_FW_EXECUTE;
    public static final PXIOtaService$PXI_CMD_FW CMD_FW_GET_ATT_MTU;
    public static final PXIOtaService$PXI_CMD_FW CMD_FW_INIT;
    public static final PXIOtaService$PXI_CMD_FW CMD_FW_MCU_RESET;
    public static final PXIOtaService$PXI_CMD_FW CMD_FW_OBJECT_CREATE;
    public static final PXIOtaService$PXI_CMD_FW CMD_FW_OTA_INIT_NEW;
    public static final PXIOtaService$PXI_CMD_FW CMD_FW_SECTOR_ERASE;
    public static final PXIOtaService$PXI_CMD_FW CMD_FW_SET_ADDRESS;
    public static final PXIOtaService$PXI_CMD_FW CMD_FW_UPGRADE;
    public static final PXIOtaService$PXI_CMD_FW CMD_FW_WRITE;
    public static final PXIOtaService$PXI_CMD_FW CMD_FW_WRITE_SET;
    public static final a Companion;
    public static final PXIOtaService$PXI_CMD_FW EVT_COMMAND_COMPLETE;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PXIOtaService$PXI_CMD_FW[] f7276a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ ih.a f7277b;
    private final int code;

    static {
        PXIOtaService$PXI_CMD_FW pXIOtaService$PXI_CMD_FW = new PXIOtaService$PXI_CMD_FW("CMD_FW_INIT", 0, 16);
        CMD_FW_INIT = pXIOtaService$PXI_CMD_FW;
        PXIOtaService$PXI_CMD_FW pXIOtaService$PXI_CMD_FW2 = new PXIOtaService$PXI_CMD_FW("CMD_FW_SET_ADDRESS", 1, 17);
        CMD_FW_SET_ADDRESS = pXIOtaService$PXI_CMD_FW2;
        PXIOtaService$PXI_CMD_FW pXIOtaService$PXI_CMD_FW3 = new PXIOtaService$PXI_CMD_FW("CMD_FW_ERASE", 2, 22);
        CMD_FW_ERASE = pXIOtaService$PXI_CMD_FW3;
        PXIOtaService$PXI_CMD_FW pXIOtaService$PXI_CMD_FW4 = new PXIOtaService$PXI_CMD_FW("CMD_FW_WRITE", 3, 23);
        CMD_FW_WRITE = pXIOtaService$PXI_CMD_FW4;
        PXIOtaService$PXI_CMD_FW pXIOtaService$PXI_CMD_FW5 = new PXIOtaService$PXI_CMD_FW("CMD_FW_UPGRADE", 4, 24);
        CMD_FW_UPGRADE = pXIOtaService$PXI_CMD_FW5;
        PXIOtaService$PXI_CMD_FW pXIOtaService$PXI_CMD_FW6 = new PXIOtaService$PXI_CMD_FW("CMD_FW_SECTOR_ERASE", 5, 25);
        CMD_FW_SECTOR_ERASE = pXIOtaService$PXI_CMD_FW6;
        PXIOtaService$PXI_CMD_FW pXIOtaService$PXI_CMD_FW7 = new PXIOtaService$PXI_CMD_FW("CMD_FW_WRITE_SET", 6, 32);
        CMD_FW_WRITE_SET = pXIOtaService$PXI_CMD_FW7;
        PXIOtaService$PXI_CMD_FW pXIOtaService$PXI_CMD_FW8 = new PXIOtaService$PXI_CMD_FW("CMD_FW_CONNECTION_UPDATE", 7, 33);
        CMD_FW_CONNECTION_UPDATE = pXIOtaService$PXI_CMD_FW8;
        PXIOtaService$PXI_CMD_FW pXIOtaService$PXI_CMD_FW9 = new PXIOtaService$PXI_CMD_FW("CMD_FW_MCU_RESET", 8, 34);
        CMD_FW_MCU_RESET = pXIOtaService$PXI_CMD_FW9;
        PXIOtaService$PXI_CMD_FW pXIOtaService$PXI_CMD_FW10 = new PXIOtaService$PXI_CMD_FW("CMD_FW_GET_ATT_MTU", 9, 36);
        CMD_FW_GET_ATT_MTU = pXIOtaService$PXI_CMD_FW10;
        PXIOtaService$PXI_CMD_FW pXIOtaService$PXI_CMD_FW11 = new PXIOtaService$PXI_CMD_FW("CMD_FW_OBJECT_CREATE", 10, 37);
        CMD_FW_OBJECT_CREATE = pXIOtaService$PXI_CMD_FW11;
        PXIOtaService$PXI_CMD_FW pXIOtaService$PXI_CMD_FW12 = new PXIOtaService$PXI_CMD_FW("CMD_FW_EXECUTE", 11, 38);
        CMD_FW_EXECUTE = pXIOtaService$PXI_CMD_FW12;
        PXIOtaService$PXI_CMD_FW pXIOtaService$PXI_CMD_FW13 = new PXIOtaService$PXI_CMD_FW("CMD_FW_OTA_INIT_NEW", 12, 39);
        CMD_FW_OTA_INIT_NEW = pXIOtaService$PXI_CMD_FW13;
        PXIOtaService$PXI_CMD_FW pXIOtaService$PXI_CMD_FW14 = new PXIOtaService$PXI_CMD_FW("EVT_COMMAND_COMPLETE", 13, 14);
        EVT_COMMAND_COMPLETE = pXIOtaService$PXI_CMD_FW14;
        PXIOtaService$PXI_CMD_FW[] pXIOtaService$PXI_CMD_FWArr = {pXIOtaService$PXI_CMD_FW, pXIOtaService$PXI_CMD_FW2, pXIOtaService$PXI_CMD_FW3, pXIOtaService$PXI_CMD_FW4, pXIOtaService$PXI_CMD_FW5, pXIOtaService$PXI_CMD_FW6, pXIOtaService$PXI_CMD_FW7, pXIOtaService$PXI_CMD_FW8, pXIOtaService$PXI_CMD_FW9, pXIOtaService$PXI_CMD_FW10, pXIOtaService$PXI_CMD_FW11, pXIOtaService$PXI_CMD_FW12, pXIOtaService$PXI_CMD_FW13, pXIOtaService$PXI_CMD_FW14};
        f7276a = pXIOtaService$PXI_CMD_FWArr;
        f7277b = kotlin.enums.a.a(pXIOtaService$PXI_CMD_FWArr);
        Companion = new a();
    }

    public PXIOtaService$PXI_CMD_FW(String str, int i3, int i10) {
        this.code = i10;
    }

    public static ih.a getEntries() {
        return f7277b;
    }

    public static PXIOtaService$PXI_CMD_FW valueOf(String str) {
        return (PXIOtaService$PXI_CMD_FW) Enum.valueOf(PXIOtaService$PXI_CMD_FW.class, str);
    }

    public static PXIOtaService$PXI_CMD_FW[] values() {
        return (PXIOtaService$PXI_CMD_FW[]) f7276a.clone();
    }

    public final int getCode() {
        return this.code;
    }
}
