package md;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.haibin.calendarview.Calendar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

/* loaded from: classes.dex */
public abstract class t {

    /* renamed from: c, reason: collision with root package name */
    public static String[] f16098c;

    /* renamed from: v, reason: collision with root package name */
    public static String[] f16115v;

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f16096a = {1887, 5780, 5802, 19157, 2742, 50359, 1198, 2646, 46378, 7466, 3412, 30122, 5482, 67949, 2396, 5294, 43597, 6732, 6954, 36181, 2772, 4954, 18781, 2396, 54427, 5274, 6730, 47781, 5800, 6868, 21210, 4790, 59703, 2350, 5270, 46667, 3402, 3496, 38325, 1388, 4782, 18735, 2350, 52374, 6804, 7498, 44457, 2906, 1388, 29294, 4700, 63789, 6442, 6804, 56138, 5802, 2772, 38235, 1210, 4698, 22827, 5418, 63125, 3476, 5802, 43701, 2484, 5302, 27223, 2646, 70954, 7466, 3412, 54698, 5482, 2412, 38062, 5294, 2636, 32038, 6954, 60245, 2772, 4826, 43357, 2394, 5274, 39501, 6730, 72357, 5800, 5844, 53978, 4790, 2358, 38039, 5270, 87627, 3402, 3496, 54708, 5484, 4782, 43311, 2350, 3222, 27978, 7498, 68965, 2904, 5484, 45677, 4700, 6444, 39573, 6804, 6986, 19285, 2772, 62811, 1210, 4698, 47403, 5418, 5780, 38570, 5546, 76469, 2420, 5302, 51799, 2646, 5414, 36501, 3412, 5546, 18869, 2412, 54446, 5276, 6732, 48422, 6822, 2900, 28010, 4826, 92509, 2394, 5274, 55883, 6730, 6820, 47956, 5812, 2778, 18779, 2358, 62615, 5270, 5450, 46757, 3492, 5556, 27318, 4718, 67887, 2350, 3222, 52554, 7498, 3428, 38252, 5468, 4700, 31022, 6444, 64149, 6804, 6986, 43861, 2772, 5338, 35421, 2650, 70955, 5418, 5780, 54954, 5546, 2740, 38074, 5302, 2646, 29991, 3366, 61011, 3412, 5546, 43445, 2412, 5294, 35406, 6732, 72998, 6820, 6996, 52586, 2778, 2396, 38045, 5274, 6698, 23333, 6820, 64338, 5812, 2746, 43355, 2358, 5270, 39499, 5450, 79525, 3492, 5548};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f16097b = {1887, 966732, 967231, 967733, 968265, 968766, 969297, 969798, 970298, 970829, 971330, 971830, 972362, 972863, 973395, 973896, 974397, 974928, 975428, 975929, 976461, 976962, 977462, 977994, 978494, 979026, 979526, 980026, 980558, 981059, 981559, 982091, 982593, 983124, 983624, 984124, 984656, 985157, 985656, 986189, 986690, 987191, 987722, 988222, 988753, 989254, 989754, 990286, 990788, 991288, 991819, 992319, 992851, 993352, 993851, 994383, 994885, 995385, 995917, 996418, 996918, 997450, 997949, 998481, 998982, 999483, 1000014, 1000515, 1001016, 1001548, 1002047, 1002578, 1003080, 1003580, 1004111, 1004613, 1005113, 1005645, 1006146, 1006645, 1007177, 1007678, 1008209, 1008710, 1009211, 1009743, 1010243, 1010743, 1011275, 1011775, 1012306, 1012807, 1013308, 1013840, 1014341, 1014841, 1015373, 1015874, 1016404, 1016905, 1017405, 1017937, 1018438, 1018939, 1019471, 1019972, 1020471, 1021002, 1021503, 1022035, 1022535, 1023036, 1023568, 1024069, 1024568, 1025100, 1025601, 1026102, 1026633, 1027133, 1027666, 1028167, 1028666, 1029198, 1029699, 1030199, 1030730, 1031231, 1031763, 1032264, 1032764, 1033296, 1033797, 1034297, 1034828, 1035329, 1035830, 1036362, 1036861, 1037393, 1037894, 1038394, 1038925, 1039427, 1039927, 1040459, 1040959, 1041491, 1041992, 1042492, 1043023, 1043524, 1044024, 1044556, 1045057, 1045558, 1046090, 1046590, 1047121, 1047622, 1048122, 1048654, 1049154, 1049655, 1050187, 1050689, 1051219, 1051720, 1052220, 1052751, 1053252, 1053752, 1054284, 1054786, 1055285, 1055817, 1056317, 1056849, 1057349, 1057850, 1058382, 1058883, 1059383, 1059915, 1060415, 1060947, 1061447, 1061947, 1062479, 1062981, 1063480, 1064012, 1064514, 1065014, 1065545, 1066045, 1066577, 1067078, 1067578, 1068110, 1068611, 1069112, 1069642, 1070142, 1070674, 1071175, 1071675, 1072207, 1072709, 1073209, 1073740, 1074241, 1074741, 1075273, 1075773, 1076305, 1076807, 1077308, 1077839, 1078340, 1078840, 1079372, 1079871, 1080403, 1080904};

    /* renamed from: d, reason: collision with root package name */
    public static final double[] f16099d = {-4000.0d, 108371.7d, -13036.8d, 392.0d, 0.0d, -500.0d, 17201.0d, -627.82d, 16.17d, -0.3413d, -150.0d, 12200.6d, -346.41d, 5.403d, -0.1593d, 150.0d, 9113.8d, -328.13d, -1.647d, 0.0377d, 500.0d, 5707.5d, -391.41d, 0.915d, 0.3145d, 900.0d, 2203.4d, -283.45d, 13.034d, -0.1778d, 1300.0d, 490.1d, -57.35d, 2.085d, -0.0072d, 1600.0d, 120.0d, -9.81d, -1.532d, 0.1403d, 1700.0d, 10.2d, -0.91d, 0.51d, -0.037d, 1800.0d, 13.4d, -0.72d, 0.202d, -0.0193d, 1830.0d, 7.8d, -1.81d, 0.416d, -0.0247d, 1860.0d, 8.3d, -0.13d, -0.406d, 0.0292d, 1880.0d, -5.4d, 0.32d, -0.183d, 0.0173d, 1900.0d, -2.3d, 2.06d, 0.169d, -0.0135d, 1920.0d, 21.2d, 1.69d, -0.304d, 0.0167d, 1940.0d, 24.2d, 1.22d, -0.064d, 0.0031d, 1960.0d, 33.2d, 0.51d, 0.231d, -0.0109d, 1980.0d, 51.0d, 1.29d, -0.026d, 0.0032d, 2000.0d, 64.7d, -1.66d, 5.224d, -0.2905d, 2150.0d, 279.4d, 732.95d, 429.579d, 0.0158d, 6000.0d};
    public static final double[] e = {0.016708634d, -4.2037E-5d, -1.267E-7d};

    /* renamed from: f, reason: collision with root package name */
    public static final double[] f16100f = {1.796595680777785d, 0.030010238356341697d, 8.028514559173916E-6d};

    /* renamed from: g, reason: collision with root package name */
    public static final double[] f16101g = {4.89506311081711d, 628.3319667475674d, 5.291887161265863E-6d, 0.0d, 0.0d};

    /* renamed from: h, reason: collision with root package name */
    public static final double[] f16102h = {2.1824391966d, -33.757045954d, 3.62262E-5d, 3.734E-8d, -2.8793E-10d, -171996.0d, -1742.0d, 92025.0d, 89.0d, 3.5069406862d, 1256.663930738d, 1.05845E-5d, 6.9813E-10d, -2.2815E-10d, -13187.0d, -16.0d, 5736.0d, -31.0d, 1.3375032491d, 16799.418221925d, -5.11866E-5d, 6.4626E-8d, -5.3543E-10d, -2274.0d, -2.0d, 977.0d, -5.0d, 4.3648783932d, -67.514091907d, 7.24525E-5d, 7.4681E-8d, -5.7586E-10d, 2062.0d, 2.0d, -895.0d, 5.0d, 0.0431251803d, -628.301955171d, 2.682E-6d, 6.5935E-10d, 5.5705E-11d, -1426.0d, 34.0d, 54.0d, -1.0d, 2.3555557435d, 8328.691425719d, 1.545547E-4d, 2.5033E-7d, -1.1863E-9d, 712.0d, 1.0d, -7.0d, 0.0d, 3.4638155059d, 1884.965885909d, 7.9025E-6d, 3.8785E-11d, -2.8386E-10d, -517.0d, 12.0d, 224.0d, -6.0d, 5.4382493597d, 16833.175267879d, -8.74129E-5d, 2.7285E-8d, -2.475E-10d, -386.0d, -4.0d, 200.0d, 0.0d, 3.6930589926d, 25128.109647645d, 1.033681E-4d, 3.1496E-7d, -1.7218E-9d, -301.0d, 0.0d, 129.0d, -1.0d, 3.5500658664d, 628.361975567d, 1.32664E-5d, 1.3575E-9d, -1.7245E-10d, 217.0d, -5.0d, -95.0d, 3.0d};

    /* renamed from: i, reason: collision with root package name */
    public static final double[] f16103i = {1.75347045673d, 0.0d, 0.0d, 0.03341656456d, 4.66925680417d, 6283.0758499914d, 3.4894275E-4d, 4.62610241759d, 12566.1516999828d, 3.417571E-5d, 2.82886579606d, 3.523118349d, 3.497056E-5d, 2.74411800971d, 5753.3848848968d, 3.135896E-5d, 3.62767041758d, 77713.7714681205d, 2.676218E-5d, 4.41808351397d, 7860.4193924392d, 2.342687E-5d, 6.13516237631d, 3930.2096962196d, 1.273166E-5d, 2.03709655772d, 529.6909650946d, 1.324292E-5d, 0.74246356352d, 11506.7697697936d, 9.01855E-6d, 2.04505443513d, 26.2983197998d, 1.199167E-5d, 1.10962944315d, 1577.3435424478d, 8.57223E-6d, 3.50849156957d, 398.1490034082d, 7.79786E-6d, 1.17882652114d, 5223.6939198022d, 9.9025E-6d, 5.23268129594d, 5884.9268465832d, 7.53141E-6d, 2.53339053818d, 5507.5532386674d, 5.05264E-6d, 4.58292563052d, 18849.2275499742d, 4.92379E-6d, 4.20506639861d, 775.522611324d, 3.56655E-6d, 2.91954116867d, 0.0673103028d, 2.84125E-6d, 1.89869034186d, 796.2980068164d, 2.4281E-6d, 0.34481140906d, 5486.777843175d, 3.17087E-6d, 5.84901952218d, 11790.6290886588d, 2.71039E-6d, 0.31488607649d, 10977.078804699d, 2.0616E-6d, 4.80646606059d, 2544.3144198834d, 2.05385E-6d, 1.86947813692d, 5573.1428014331d, 2.02261E-6d, 2.45767795458d, 6069.7767545534d, 1.26184E-6d, 1.0830263021d, 20.7753954924d, 1.55516E-6d, 0.83306073807d, 213.299095438d, 1.15132E-6d, 0.64544911683d, 0.9803210682d, 1.02851E-6d, 0.63599846727d, 4694.0029547076d, 1.01724E-6d, 4.26679821365d, 7.1135470008d, 9.9206E-7d, 6.20992940258d, 2146.1654164752d, 1.32212E-6d, 3.41118275555d, 2942.4634232916d, 9.7607E-7d, 0.6810127227d, 155.4203994342d, 8.5128E-7d, 1.29870743025d, 6275.9623029906d, 7.4651E-7d, 1.75508916159d, 5088.6288397668d, 1.01895E-6d, 0.97569221824d, 15720.8387848784d, 8.4711E-7d, 3.67080093025d, 71430.6956181291d, 7.3547E-7d, 4.67926565481d, 801.8209311238d, 7.3874E-7d, 3.50319443167d, 3154.6870848956d, 7.8756E-7d, 3.03698313141d, 12036.4607348882d, 7.9637E-7d, 1.807913307d, 17260.1546546904d, 8.5803E-7d, 5.98322631256d, 161000.6857376741d, 5.6963E-7d, 2.78430398043d, 6286.5989683404d, 6.1148E-7d, 1.81839811024d, 7084.8967811152d, 6.9627E-7d, 0.83297596966d, 9437.762934887d, 5.6116E-7d, 4.38694880779d, 14143.4952424306d, 6.2449E-7d, 3.97763880587d, 8827.3902698748d, 5.1145E-7d, 0.28306864501d, 5856.4776591154d, 5.5577E-7d, 3.47006009062d, 6279.5527316424d, 4.1036E-7d, 5.36817351402d, 8429.2412664666d, 5.1605E-7d, 1.33282746983d, 1748.016413067d, 5.1992E-7d, 0.18914945834d, 12139.5535091068d, 4.9E-7d, 0.48735065033d, 1194.4470102246d, 3.92E-7d, 6.16832995016d, 10447.3878396044d, 3.5566E-7d, 1.77597314691d, 6812.766815086d, 3.677E-7d, 6.04133859347d, 10213.285546211d, 3.6596E-7d, 2.56955238628d, 1059.3819301892d, 3.3291E-7d, 0.59309499459d, 17789.845619785d, 3.5954E-7d, 1.70876111898d, 2352.8661537718d};

    /* renamed from: j, reason: collision with root package name */
    public static final double[] f16104j = {6283.31966747491d, 0.0d, 0.0d, 0.00206058863d, 2.67823455584d, 6283.0758499914d, 4.30343E-5d, 2.63512650414d, 12566.1516999828d, 4.25264E-6d, 1.59046980729d, 3.523118349d, 1.08977E-6d, 2.96618001993d, 1577.3435424478d, 9.3478E-7d, 2.59212835365d, 18849.2275499742d, 1.19261E-6d, 5.79557487799d, 26.2983197998d, 7.2122E-7d, 1.13846158196d, 529.6909650946d, 6.7768E-7d, 1.87472304791d, 398.1490034082d, 6.7327E-7d, 4.40918235168d, 5507.5532386674d, 5.9027E-7d, 2.8879703846d, 5223.6939198022d, 5.5976E-7d, 2.17471680261d, 155.4203994342d, 4.5407E-7d, 0.39803079805d, 796.2980068164d, 3.6369E-7d, 0.46624739835d, 775.522611324d, 2.8958E-7d, 2.64707383882d, 7.1135470008d, 1.9097E-7d, 1.84628332577d, 5486.777843175d, 2.0844E-7d, 5.34138275149d, 0.9803210682d, 1.8508E-7d, 4.96855124577d, 213.299095438d, 1.6233E-7d, 0.03216483047d, 2544.3144198834d, 1.7293E-7d, 2.99116864949d, 6275.9623029906d};

    /* renamed from: k, reason: collision with root package name */
    public static final double[] f16105k = {5.291887E-4d, 0.0d, 0.0d, 8.719837E-5d, 1.07209665242d, 6283.0758499914d, 3.09125E-6d, 0.86728818832d, 12566.1516999828d, 2.7339E-7d, 0.05297871691d, 3.523118349d, 1.6334E-7d, 5.18826691036d, 26.2983197998d, 1.5752E-7d, 3.6845788943d, 155.4203994342d, 9.541E-8d, 0.75742297675d, 18849.2275499742d, 8.937E-8d, 2.05705419118d, 77713.7714681205d, 6.952E-8d, 0.8267330541d, 775.522611324d, 5.064E-8d, 4.66284525271d, 1577.3435424478d};

    /* renamed from: l, reason: collision with root package name */
    public static final double[] f16106l = {2.89226E-6d, 5.84384198723d, 6283.0758499914d, 3.4955E-7d, 0.0d, 0.0d, 1.6819E-7d, 5.48766912348d, 12566.1516999828d};

    /* renamed from: m, reason: collision with root package name */
    public static final double[] f16107m = {1.14084E-6d, 3.14159265359d, 0.0d, 7.717E-8d, 4.13446589358d, 6283.0758499914d, 7.65E-9d, 3.83803776214d, 12566.1516999828d};

    /* renamed from: n, reason: collision with root package name */
    public static final double[] f16108n = {8.78E-9d, 3.14159265359d, 0.0d};

    /* renamed from: o, reason: collision with root package name */
    public static final double[] f16109o = {2.7962E-6d, 3.19870156017d, 84334.6615813083d, 1.01643E-6d, 5.42248619256d, 5507.5532386674d, 8.0445E-7d, 3.88013204458d, 5223.6939198022d, 4.3806E-7d, 3.70444689758d, 2352.8661537718d, 3.1933E-7d, 4.00026369781d, 1577.3435424478d, 2.2724E-7d, 3.9847383156d, 1047.7473117547d, 1.6392E-7d, 3.56456119782d, 5856.4776591154d, 1.8141E-7d, 4.98367470263d, 6283.0758499914d, 1.4443E-7d, 3.70275614914d, 9437.762934887d, 1.4304E-7d, 3.41117857525d, 10213.285546211d};

    /* renamed from: p, reason: collision with root package name */
    public static final double[] f16110p = {9.03E-8d, 3.8972906189d, 5507.5532386674d, 6.177E-8d, 1.73038850355d, 5223.6939198022d};

    /* renamed from: q, reason: collision with root package name */
    public static final double[] f16111q = {1.00013988799d, 0.0d, 0.0d, 0.01670699626d, 3.09846350771d, 6283.0758499914d, 1.3956023E-4d, 3.0552460962d, 12566.1516999828d, 3.08372E-5d, 5.19846674381d, 77713.7714681205d, 1.628461E-5d, 1.17387749012d, 5753.3848848968d, 1.575568E-5d, 2.84685245825d, 7860.4193924392d, 9.24799E-6d, 5.45292234084d, 11506.7697697936d, 5.42444E-6d, 4.56409149777d, 3930.2096962196d};
    public static final double[] r = {0.00103018608d, 1.10748969588d, 6283.0758499914d, 1.721238E-5d, 1.06442301418d, 12566.1516999828d, 7.02215E-6d, 3.14159265359d, 0.0d};

    /* renamed from: s, reason: collision with root package name */
    public static final double[] f16112s = {4.359385E-5d, 5.78455133738d, 6283.0758499914d};

    /* renamed from: t, reason: collision with root package name */
    public static final double[] f16113t = {1.44595E-6d, 4.27319435148d, 6283.0758499914d};

    /* renamed from: u, reason: collision with root package name */
    public static double f16114u = 0.0d;

    public static v A(double d5) {
        double[] dArr;
        v vVar = new v();
        double d8 = ((d5 - 2451545.0d) / 365.2425d) + 2000.0d;
        int i3 = 0;
        while (true) {
            dArr = f16099d;
            if (i3 >= 100) {
                break;
            }
            int i10 = i3 + 5;
            if (d8 < dArr[i10] || i3 == 95) {
                break;
            }
            i3 = i10;
        }
        double d10 = dArr[i3];
        double d11 = ((d8 - d10) / (dArr[i3 + 5] - d10)) * 10.0d;
        double d12 = d11 * d11;
        double d13 = d12 * d11;
        double d14 = (d5 - (((dArr[i3 + 4] * d13) + ((dArr[i3 + 3] * d12) + ((dArr[i3 + 2] * d11) + dArr[i3 + 1]))) / 86400.0d)) + 0.5d;
        double f2 = f(d14);
        double d15 = d14 - f2;
        if (f2 > 2299161.0d) {
            double f10 = f((f2 - 1867216.25d) / 36524.25d);
            f2 += (f10 + 1.0d) - f(f10 / 4.0d);
        }
        double d16 = f2 + 1524.0d;
        double f11 = f((d16 - 122.1d) / 365.25d);
        vVar.f16118a = f11;
        double f12 = d16 - f(f11 * 365.25d);
        double f13 = f(f12 / 30.6001d);
        vVar.f16119b = f13;
        vVar.f16120c = f12 - f(f13 * 30.6001d);
        double d17 = vVar.f16118a - 4716.0d;
        vVar.f16118a = d17;
        double d18 = vVar.f16119b - 1.0d;
        vVar.f16119b = d18;
        if (d18 > 12.0d) {
            vVar.f16119b = d18 - 12.0d;
        }
        if (vVar.f16119b <= 2.0d) {
            vVar.f16118a = d17 + 1.0d;
        }
        double d19 = d15 * 24.0d;
        f((d19 - f(d19)) * 60.0d);
        return vVar;
    }

    public static long B(int i3, int i10, int i11) {
        int i12 = i3 - (((i10 + 9) % 12) / 10);
        return (i11 - 1) + (((r3 * 306) + 5) / 10) + (i12 / 400) + (((i12 / 4) + (i12 * 365)) - (i12 / 100));
    }

    public static String a(double d5) {
        int i3 = (int) d5;
        return d5 < 10.0d ? l0.j(i3, "0") : String.valueOf(i3);
    }

    public static double b(double[] dArr) {
        double d5 = 0.0d;
        for (int i3 = 0; i3 < dArr.length; i3 += 3) {
            d5 += Math.cos((f16114u * dArr[i3 + 2]) + dArr[i3 + 1]) * dArr[i3];
        }
        return d5;
    }

    public static double c(double d5, double d8) {
        double d10 = d5 / 365250.0d;
        f16114u = d10;
        double d11 = d10 * d10;
        double d12 = d11 * d10;
        double d13 = d12 * d10;
        double[] dArr = {(b(f16108n) * d13 * d10) + (b(f16107m) * d13) + (b(f16106l) * d12) + (b(f16105k) * d11) + (b(f16104j) * d10) + b(f16103i), (b(f16110p) * d10) + b(f16109o), (b(f16113t) * d12) + (b(f16112s) * d11) + (b(r) * d10) + b(f16111q)};
        double z5 = z(dArr[0]);
        dArr[0] = z5;
        double d14 = z5 + 3.141592653589793d;
        dArr[0] = d14;
        dArr[1] = -dArr[1];
        double d15 = d5 / 36525.0d;
        double d16 = d15 * d15;
        double d17 = d16 * d15;
        double d18 = d17 * d15;
        double[] dArr2 = f16101g;
        double d19 = (dArr2[4] * d18) + (dArr2[3] * d17) + (dArr2[2] * d16) + (dArr2[1] * d15) + dArr2[0];
        double[] dArr3 = f16100f;
        double d20 = (dArr3[2] * d16) + (dArr3[1] * d15) + dArr3[0];
        double[] dArr4 = e;
        double d21 = (dArr4[2] * d16) + (dArr4[1] * d15) + dArr4[0];
        double d22 = d19 - d14;
        double d23 = d20 - d14;
        dArr[0] = d14 - (((Math.cos(d22) - (Math.cos(d23) * d21)) * 9.936508497454117E-5d) / Math.cos(dArr[1]));
        double d24 = dArr[1];
        dArr[1] = d24 - ((Math.sin(d22) - (Math.sin(d23) * d21)) * (Math.sin(d24) * 9.936508497454117E-5d));
        dArr[0] = z(dArr[0]);
        double d25 = 0.0d;
        for (int i3 = 0; i3 < 90; i3 += 9) {
            double[] dArr5 = f16102h;
            double d26 = (dArr5[i3 + 4] * d18) + (dArr5[i3 + 3] * d17) + (dArr5[i3 + 2] * d16) + (dArr5[i3 + 1] * d15) + dArr5[i3];
            d25 = (Math.sin(d26) * (((dArr5[i3 + 6] * d15) / 10.0d) + dArr5[i3 + 5])) + d25;
            double d27 = dArr5[i3 + 7];
            double d28 = dArr5[i3 + 8];
            Math.cos(d26);
        }
        double d29 = dArr[0] + (d25 / 2.0626480624709637E9d);
        dArr[0] = d29;
        return z(d8 - d29);
    }

    public static int d(Calendar calendar, Calendar calendar2) {
        if (calendar2 == null) {
            return SubsamplingScaleImageView.TILE_SIZE_AUTO;
        }
        java.util.Calendar calendar3 = java.util.Calendar.getInstance();
        calendar3.set(calendar.getYear(), calendar.getMonth() - 1, calendar.getDay(), 12, 0, 0);
        long timeInMillis = calendar3.getTimeInMillis();
        calendar3.set(calendar2.getYear(), calendar2.getMonth() - 1, calendar2.getDay(), 12, 0, 0);
        return (int) ((timeInMillis - calendar3.getTimeInMillis()) / Const.DAY_IN_MILLIS);
    }

    public static int e(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static double f(double d5) {
        double floor = Math.floor(d5);
        return floor < 0.0d ? floor + 1.0d : floor;
    }

    public static int g(int i3, int i10, int i11) {
        return (i3 & (((1 << i10) - 1) << i11)) >> i11;
    }

    public static int h(String str, Date date) {
        return Integer.parseInt(new SimpleDateFormat(str).format(date));
    }

    public static Calendar i(int i3, int i10, int i11, int i12, int i13) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(i3, i10 - 1, i11, 12, 0);
        long timeInMillis = ((i12 - 1) * 7 * Const.DAY_IN_MILLIS) + calendar.getTimeInMillis();
        calendar.setTimeInMillis(timeInMillis);
        calendar.setTimeInMillis(timeInMillis - (v(calendar.get(1), calendar.get(2) + 1, calendar.get(5), i13) * Const.DAY_IN_MILLIS));
        Calendar calendar2 = new Calendar();
        calendar2.setYear(calendar.get(1));
        calendar2.setMonth(calendar.get(2) + 1);
        calendar2.setDay(calendar.get(5));
        return calendar2;
    }

    public static int j(int i3, int i10) {
        int i11 = (i10 == 1 || i10 == 3 || i10 == 5 || i10 == 7 || i10 == 8 || i10 == 10 || i10 == 12) ? 31 : 0;
        if (i10 == 4 || i10 == 6 || i10 == 9 || i10 == 11) {
            i11 = 30;
        }
        return i10 == 2 ? ((i3 % 4 != 0 || i3 % 100 == 0) && i3 % 400 != 0) ? 28 : 29 : i11;
    }

    public static int k(int i3, int i10, int i11, int i12) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(i3, i10 - 1, i11);
        int i13 = calendar.get(7);
        if (i12 == 1) {
            return 7 - i13;
        }
        if (i12 == 2) {
            if (i13 == 1) {
                return 0;
            }
            return 8 - i13;
        }
        if (i13 == 7) {
            return 6;
        }
        return 6 - i13;
    }

    public static int l(int i3, int i10, int i11, int i12) {
        java.util.Calendar.getInstance().set(i3, i10 - 1, 1, 12, 0, 0);
        int n4 = n(i3, i10, i12);
        int j4 = j(i3, i10);
        return (((n4 + j4) + k(i3, i10, j4, i12)) / 7) * i11;
    }

    public static int m(int i3, int i10, int i11, int i12, int i13) {
        return i13 == 0 ? i11 * 6 : l(i3, i10, i11, i12);
    }

    public static int n(int i3, int i10, int i11) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(i3, i10 - 1, 1, 12, 0, 0);
        int i12 = calendar.get(7);
        if (i11 == 1) {
            return i12 - 1;
        }
        if (i11 == 2) {
            if (i12 == 1) {
                return 6;
            }
            return i12 - i11;
        }
        if (i12 == 7) {
            return 0;
        }
        return i12;
    }

    public static int o(Calendar calendar, int i3) {
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        calendar2.set(calendar.getYear(), calendar.getMonth() - 1, 1, 12, 0, 0);
        int i10 = calendar2.get(7);
        if (i3 == 1) {
            return i10 - 1;
        }
        if (i3 == 2) {
            if (i10 == 1) {
                return 6;
            }
            return i10 - i3;
        }
        if (i10 == 7) {
            return 0;
        }
        return i10;
    }

    public static Calendar p(Calendar calendar) {
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        calendar2.set(calendar.getYear(), calendar.getMonth() - 1, calendar.getDay(), 12, 0, 0);
        calendar2.setTimeInMillis(calendar2.getTimeInMillis() + Const.DAY_IN_MILLIS);
        Calendar calendar3 = new Calendar();
        calendar3.setYear(calendar2.get(1));
        calendar3.setMonth(calendar2.get(2) + 1);
        calendar3.setDay(calendar2.get(5));
        return calendar3;
    }

    public static Calendar q(Calendar calendar) {
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        calendar2.set(calendar.getYear(), calendar.getMonth() - 1, calendar.getDay(), 12, 0, 0);
        calendar2.setTimeInMillis(calendar2.getTimeInMillis() - Const.DAY_IN_MILLIS);
        Calendar calendar3 = new Calendar();
        calendar3.setYear(calendar2.get(1));
        calendar3.setMonth(calendar2.get(2) + 1);
        calendar3.setDay(calendar2.get(5));
        return calendar3;
    }

    public static double r(double d5, double d8) {
        double d10 = d5;
        double d11 = 360.0d + d10;
        double d12 = 0.017453292519943295d * d8;
        double c9 = c(d10, d12);
        double c10 = c(d11, d12);
        if (c9 < c10) {
            c10 -= 6.283185307179586d;
        }
        double d13 = 0.0d;
        int i3 = 0;
        double d14 = c10;
        double d15 = c9;
        double d16 = d14;
        double d17 = 1.0d;
        while (i3 < 10) {
            double d18 = (d16 - d15) / (d11 - d10);
            if (Math.abs(d18) > 1.0E-15d) {
                d17 = d18;
            }
            double d19 = d10 - (d15 / d17);
            double c11 = c(d19, d12);
            if (c11 > 1.0d) {
                c11 -= 6.283185307179586d;
            }
            if (Math.abs(c11) < 1.0E-8d) {
                return d19;
            }
            i3++;
            double d20 = c11;
            d15 = d16;
            d16 = d20;
            d13 = d19;
            d10 = d11;
            d11 = d13;
        }
        return d13;
    }

    public static int s(int i3, int i10, int i11, int i12, int i13, int i14, int i15) {
        int i16;
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT-0:00"));
        calendar.set(i3, i10 - 1, i11);
        long timeInMillis = calendar.getTimeInMillis();
        int v6 = v(i3, i10, i11, i15);
        int i17 = i13 - 1;
        calendar.set(i12, i17, i14);
        long timeInMillis2 = calendar.getTimeInMillis();
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        calendar2.set(i12, i17, i14, 12, 0);
        int i18 = calendar2.get(7);
        if (i15 == 1) {
            i16 = 7 - i18;
        } else if (i15 == 2) {
            i16 = i18 == 1 ? 0 : 8 - i18;
        } else {
            i16 = 6;
            if (i18 != 7) {
                i16 = 6 - i18;
            }
        }
        return ((((int) ((timeInMillis2 - timeInMillis) / Const.DAY_IN_MILLIS)) + 1) + (v6 + i16)) / 7;
    }

    public static int t(Calendar calendar, int i3, int i10, int i11, int i12) {
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        calendar2.set(i3, i10 - 1, i11);
        long timeInMillis = calendar2.getTimeInMillis();
        int v6 = v(i3, i10, i11, i12);
        int v9 = v(calendar.getYear(), calendar.getMonth(), calendar.getDay(), i12);
        int year = calendar.getYear();
        int month = calendar.getMonth() - 1;
        int day = calendar.getDay();
        if (v9 == 0) {
            day++;
        }
        calendar2.set(year, month, day);
        return ((v6 + ((int) ((calendar2.getTimeInMillis() - timeInMillis) / Const.DAY_IN_MILLIS))) / 7) + 1;
    }

    public static int u(Calendar calendar, int i3) {
        java.util.Calendar.getInstance().set(calendar.getYear(), calendar.getMonth() - 1, 1, 12, 0, 0);
        return (((calendar.getDay() + o(calendar, i3)) - 1) / 7) + 1;
    }

    public static int v(int i3, int i10, int i11, int i12) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(i3, i10 - 1, i11, 12, 0);
        int i13 = calendar.get(7);
        if (i12 == 1) {
            return i13 - 1;
        }
        if (i12 == 2) {
            if (i13 == 1) {
                return 6;
            }
            return i13 - i12;
        }
        if (i13 == 7) {
            return 0;
        }
        return i13;
    }

    public static ArrayList w(int i3, int i10, Calendar calendar, int i11) {
        int j4;
        int i12;
        int i13;
        int i14;
        int i15 = i10 - 1;
        java.util.Calendar.getInstance().set(i3, i15, 1);
        int n4 = n(i3, i10, i11);
        int j10 = j(i3, i10);
        ArrayList arrayList = new ArrayList();
        int i16 = 12;
        if (i10 == 1) {
            i12 = i3 - 1;
            int i17 = i10 + 1;
            j4 = n4 == 0 ? 0 : j(i12, 12);
            i13 = i17;
            i14 = i3;
        } else if (i10 == 12) {
            i14 = i3 + 1;
            j4 = n4 == 0 ? 0 : j(i3, i15);
            i16 = i15;
            i13 = 1;
            i12 = i3;
        } else {
            int i18 = i10 + 1;
            i16 = i15;
            j4 = n4 == 0 ? 0 : j(i3, i15);
            i12 = i3;
            i13 = i18;
            i14 = i12;
        }
        int i19 = 1;
        for (int i20 = 0; i20 < 42; i20++) {
            Calendar calendar2 = new Calendar();
            if (i20 < n4) {
                calendar2.setYear(i12);
                calendar2.setMonth(i16);
                calendar2.setDay((j4 - n4) + i20 + 1);
            } else if (i20 >= j10 + n4) {
                calendar2.setYear(i14);
                calendar2.setMonth(i13);
                calendar2.setDay(i19);
                i19++;
            } else {
                calendar2.setYear(i3);
                calendar2.setMonth(i10);
                calendar2.setCurrentMonth(true);
                calendar2.setDay((i20 - n4) + 1);
            }
            if (calendar2.equals(calendar)) {
                calendar2.setCurrentDay(true);
            }
            s.c(calendar2);
            arrayList.add(calendar2);
        }
        return arrayList;
    }

    public static ArrayList x(Calendar calendar, r rVar) {
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        calendar2.set(calendar.getYear(), calendar.getMonth() - 1, calendar.getDay(), 12, 0);
        long timeInMillis = calendar2.getTimeInMillis();
        ArrayList arrayList = new ArrayList();
        calendar2.setTimeInMillis(timeInMillis);
        Calendar calendar3 = new Calendar();
        calendar3.setYear(calendar.getYear());
        calendar3.setMonth(calendar.getMonth());
        calendar3.setDay(calendar.getDay());
        if (calendar3.equals(rVar.f16056h0)) {
            calendar3.setCurrentDay(true);
        }
        s.c(calendar3);
        calendar3.setCurrentMonth(true);
        arrayList.add(calendar3);
        for (int i3 = 1; i3 <= 6; i3++) {
            calendar2.setTimeInMillis((i3 * Const.DAY_IN_MILLIS) + timeInMillis);
            Calendar calendar4 = new Calendar();
            calendar4.setYear(calendar2.get(1));
            calendar4.setMonth(calendar2.get(2) + 1);
            calendar4.setDay(calendar2.get(5));
            if (calendar4.equals(rVar.f16056h0)) {
                calendar4.setCurrentDay(true);
            }
            s.c(calendar4);
            calendar4.setCurrentMonth(true);
            arrayList.add(calendar4);
        }
        return arrayList;
    }

    public static boolean y(Calendar calendar, r rVar) {
        int i3 = rVar.W;
        int i10 = rVar.Y;
        int i11 = rVar.f16043a0;
        int i12 = rVar.X;
        int i13 = rVar.Z;
        int i14 = rVar.f16045b0;
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        calendar2.set(i3, i10 - 1, i11);
        long timeInMillis = calendar2.getTimeInMillis();
        calendar2.set(i12, i13 - 1, i14);
        long timeInMillis2 = calendar2.getTimeInMillis();
        calendar2.set(calendar.getYear(), calendar.getMonth() - 1, calendar.getDay());
        long timeInMillis3 = calendar2.getTimeInMillis();
        return timeInMillis3 >= timeInMillis && timeInMillis3 <= timeInMillis2;
    }

    public static double z(double d5) {
        double d8 = d5 % 6.283185307179586d;
        return d8 < 0.0d ? d8 + 6.283185307179586d : d8;
    }
}
