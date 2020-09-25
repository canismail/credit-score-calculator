package com.kocsistem.krediBasvuru.service;

import java.util.HashMap;

import com.kocsistem.krediBasvuru.constant.CreditLimitConst;
import com.kocsistem.krediBasvuru.constant.CreditScoreStatus;
import com.kocsistem.krediBasvuru.dao.Persister;
import com.kocsistem.krediBasvuru.model.PersonInfo;
import com.kocsistem.krediBasvuru.model.ResultInfo;

import org.jboss.logging.Logger;

public class CreditProcess {

    public static Logger logger = Logger.getLogger(CreditProcess.class);

    public static ResultInfo process(HashMap<Object, Object> map) {
        ResultInfo result = null;
        PersonInfo info = null;
        try {
            info = new PersonInfo();
            info.setId(String.valueOf(map.get("id")));
            info.setName(String.valueOf(map.get("name")));
            info.setPhoneNumber(String.valueOf(map.get("phoneNumber")));
            info.setSalary(Integer.valueOf(String.valueOf(map.get("salary"))));

            result = new ResultInfo();

            String error = checkPersonInfo(info);
            int creditScore = getCreditScore(info);

            /**
             * NOT!! kredi notu 500 olma durumunda mevcut kurallara göre bir case'e
             * girmiyor.
             * 
             * Yine 500 ve 1000 arasında olup aylık kazancı 5000 den büyük olan case'ler
             * içinde bu koşullar yetersizdir.
             */
            if (!"".equals(error)) {
                result.setError(error);
                result.setCreditLimit(0);
                result.setCreditScore(CreditScoreStatus.RED.toString());
            } else if (creditScore < 500) {
                result.setCreditLimit(0);
                result.setCreditScore(CreditScoreStatus.RED.toString());
            } else if (creditScore > 500 && creditScore < 1000 && info.getSalary() < 5000) {
                result.setCreditLimit(1000);
                result.setCreditScore(CreditScoreStatus.ONAY.toString());
            } else if (creditScore >= 1000) {
                result.setCreditLimit(info.getSalary() * CreditLimitConst.CREDIT_LIMIT_MULTIPLIER);
                result.setCreditScore(CreditScoreStatus.ONAY.toString());
            }

            info.setLimit(result.getCreditLimit());
            info.setScore(result.getCreditScore());

            Persister persister = new Persister();
            persister.save(info, result.getError());

            sendSms(info);

            return result;
        } catch (Exception e) {
            logger.fatal(e);
            result.setError("Beklenmeyen Bir Hata Oluştu. Lütfen Sonra Tekrar Deneyin.");
            result.setCreditLimit(0);
            result.setCreditScore(CreditScoreStatus.RED.toString());
            return result;
        }

    }

    /**
     * ayrı servisler halinde de yazılıp farklı servislerin kullanımı sağlanabilir.
     * 
     */

    public static String checkPersonInfo(PersonInfo info) {
        // TODO check info like TCK or vkn. If ok return null
        return "";
    }

    /**
     * ayrı servisler halinde de yazılıp farklı servislerin kullanımı sağlanabilir.
     * 
     */

    public static int getCreditScore(PersonInfo info) {
        // TODO calculate credit score
        return 499;
    }
    /**
     * ayrı servisler halinde de yazılıp farklı servislerin kullanımı sağlanabilir.
     * 
     */
    public static void sendSms(PersonInfo info) {
        // TODO send sms if Credit Score  ONAY
    }

}