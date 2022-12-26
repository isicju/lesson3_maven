package org.example.taxcalc;

import java.util.HashMap;
import java.util.Map;

public class TaxService {

    private final Map<Region, Float> regionMaps;
    private final static int MONTH_IN_YEAR = 12;

    public TaxService() {
        regionMaps = new HashMap<>();
        for (Region region : Region.values()) {
            regionMaps.put(region, region.taxRate);
        }
    }

    public float calculateYearIncome(User user) {
        validateUser(user);
        float beforeTaxIncome = (float) user.getMonthOfWork() / MONTH_IN_YEAR * user.getYearIncome();
        float taxRate = regionMaps.get(user.getRegion());
        return beforeTaxIncome * taxRate;
    }

    private void validateUser(User user) {
        if (user == null) throw new UserValidationException(" user is empty!", null);
        if (!regionMaps.containsKey(user.getRegion())) {
            throw new UserValidationException("region is not available! ", user);
        }
        if (user.getRegion() == null) throw new UserValidationException(" region is empty!", user);
        if (user.getMonthOfWork() == null) throw new UserValidationException(" work duration is empty!", user);
        if (user.getYearIncome() == null) throw new UserValidationException(" year income is empty!", user);
        if (user.getFullName() == null) throw new UserValidationException(" full name is empty!", user);
        if (user.getYearIncome() < 0) throw new UserValidationException(" income can not be negative!", user);
        if (user.getMonthOfWork() < 0) throw new UserValidationException(" months of work can not be negative!", user);
    }

}
