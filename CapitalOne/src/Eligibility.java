//public class Eligibility {
//
//    public static final int ELIGIBLE = 1;
//    public static final int NOT_ELIGIBLE = 0;
//
//    public static int runEligibility(boolean isActive,
//                                     boolean wasAcquired,
//                                     boolean hasRestrictions) {
//
//        // wasAcquire==false && isActive == true && hasRestrctions == true
//        if (!wasAcquired && hasRestrictions) {
//            // 1. condition
//            if (isActive) {
//                // 1.
//               // if (hasRestrictions) {
//                    return NOT_ELIGIBLE;
//                //}
//                // 2.
////                 else if (!isActive) {
////                     return ELIGIBLE;
////                 }
//                // 3.
//                else {
//                    return NOT_ELIGIBLE;
//                }
//
//                return NOT_ELIGIBLE;
//            }
//            // 2. any other
//            else {
//                return NOT_ELIGIBLE;
//            }
//        }
//        // wasAcquired == true && hasRestrictions == false
//        else {
//       else if (!hasRestrictions) {
//                if (!isActive) {
//                    return ELIGIBLE;
//                } else if (!wasAcquired) {
//                    return NOT_ELIGIBLE;
//                } else {
//                    return ELIGIBLE;
//                }
//            }
//            // hasRestrictions == true
//            else if (!isActive) {
//                return NOT_ELIGIBLE;
//            }
//
//            return NOT_ELIGIBLE;
//        }
//    }
//
//    public static void main(String[] args) {
//
//    }
//}