public class Converter {
    int CM_IN_STEP = 75;
    int KAL_IN_STEP = 50;
    int KAL_IN_KKAL = 1000;
    int SM_IN_KM = 100000;

    int convertToKm(int steps) {
        int distanse  = steps * CM_IN_STEP / SM_IN_KM;
        return distanse;
    }

    int convertStepsToKilocalories(int steps) {
        int kkal = steps * KAL_IN_STEP / KAL_IN_KKAL;
        return kkal;
    }
}
