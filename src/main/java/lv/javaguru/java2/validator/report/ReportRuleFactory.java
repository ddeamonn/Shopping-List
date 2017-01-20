package lv.javaguru.java2.validator.report;

import lv.javaguru.java2.validator.report.rule.ReportInputDataRule;
import lv.javaguru.java2.validator.shoplist.rule.ShoplistInputDataRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by DMC on 11/30/2016.
 */

@Component
public class ReportRuleFactory {

    @Autowired
    private List<ReportInputDataRule> rules;

    public List<ReportInputDataRule> getReportRules() {
        return rules;
    }
}
