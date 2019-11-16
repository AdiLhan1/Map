package com.marveltravel.map.data.entity.currency;

import java.util.ArrayList;
import java.util.List;

public class CurrencyExchange {

    /**
     * success : true
     * timestamp : 1573472046
     * base : EUR
     * date : 2019-11-11
     * rates : {"AED":4.051089,"AFN":86.376181,"ALL":123.083056,"AMD":527.013492,"ANG":1.913858,"AOA":508.508929,"ARS":65.630129,"AUD":1.608196,"AWG":1.985178,"AZN":1.876276,"BAM":1.956196,"BBD":2.227317,"BDT":93.482809,"BGN":1.956544,"BHD":0.415759,"BIF":2069.397591,"BMD":1.102877,"BND":1.499581,"BOB":7.628098,"BRL":4.592151,"BSD":1.103107,"BTC":1.27E-4,"BTN":78.671242,"BWP":12.029753,"BYN":2.252822,"BYR":21616.381078,"BZD":2.223516,"CAD":1.458494,"CDF":1836.289448,"CHF":1.097451,"CLF":0.030229,"CLP":834.102679,"CNY":7.729731,"COP":3661.21896,"CRC":645.630934,"CUC":1.102877,"CUP":29.22623,"CVE":110.286654,"CZK":25.510648,"DJF":196.003843,"DKK":7.472286,"DOP":58.287918,"DZD":132.466639,"EGP":17.846091,"ERN":16.543414,"ETB":32.67602,"EUR":1,"FJD":2.407603,"FKP":0.896506,"GBP":0.859891,"GEL":3.264389,"GGP":0.859815,"GHS":6.094697,"GIP":0.896506,"GMD":56.489936,"GNF":10031.67943,"GTQ":8.493967,"GYD":230.785319,"HKD":8.634663,"HNL":27.158087,"HRK":7.433272,"HTG":107.563145,"HUF":334.496951,"IDR":15525.745134,"ILS":3.8602,"IMP":0.859815,"INR":78.8943,"IQD":1316.90258,"IRR":46436.619,"ISK":137.694362,"JEP":0.859815,"JMD":155.196065,"JOD":0.781897,"JPY":120.146253,"KES":112.931204,"KGS":77.02777,"KHR":4484.139924,"KMF":492.930803,"KPW":992.646059,"KRW":1285.127107,"KWD":0.335087,"KYD":0.919276,"KZT":428.832274,"LAK":9764.728095,"LBP":1667.912466,"LKR":199.193507,"LRD":233.120533,"LSL":16.344819,"LTL":3.256508,"LVL":0.667119,"LYD":1.55009,"MAD":10.677496,"MDL":19.2216,"MGA":4131.133826,"MKD":61.482858,"MMK":1673.964279,"MNT":2985.397836,"MOP":8.895107,"MRO":393.727322,"MUR":40.203679,"MVR":17.039583,"MWK":810.496723,"MXN":21.098459,"MYR":4.569766,"MZN":69.563972,"NAD":16.344928,"NGN":399.241567,"NIO":37.212971,"NOK":10.094166,"NPR":125.872573,"NZD":1.733369,"OMR":0.424613,"PAB":1.103107,"PEN":3.688791,"PGK":3.755203,"PHP":56.092315,"PKR":172.34388,"PLN":4.274974,"PYG":7111.632107,"QAR":4.015552,"RON":4.762,"RSD":117.582107,"RUB":70.518482,"RWF":1028.09251,"SAR":4.136133,"SBD":9.118575,"SCR":15.109624,"SDG":49.75692,"SEK":10.714832,"SGD":1.50157,"SHP":1.456787,"SLL":10659.301975,"SOS":640.770933,"SRD":8.225265,"STD":23778.890459,"SVC":9.651851,"SYP":567.981438,"SZL":16.346962,"THB":33.458358,"TJS":10.6947,"TMT":3.860068,"TND":3.148162,"TOP":2.558949,"TRY":6.375625,"TTD":7.474735,"TWD":33.557253,"TZS":2542.656271,"UAH":27.035464,"UGX":4078.200934,"USD":1.102877,"UYU":41.339118,"UZS":10457.495665,"VEF":11.014976,"VND":25590.793167,"VUV":129.327899,"WST":2.940489,"XAF":656.079896,"XAG":0.06525,"XAU":7.53E-4,"XCD":2.980579,"XDR":0.802839,"XOF":656.079896,"XPF":119.283426,"YER":276.105443,"ZAR":16.41356,"ZMK":9927.21526,"ZMW":15.040817,"ZWL":355.126262}
     */

    private boolean success;
    private int timestamp;
    private String base;
    private String date;
    private RatesBean rates;

    public List<Currency> getCurrencyList() {
        List<Currency> currencyList = new ArrayList<>();
        currencyList.add(new Currency("AED", rates.getAED()));
        currencyList.add(new Currency("AFN", rates.getAFN()));
        currencyList.add(new Currency("ALL", rates.getALL()));
        currencyList.add(new Currency("AMD", rates.getAMD()));
        currencyList.add(new Currency("ANG", rates.getANG()));
        currencyList.add(new Currency("AOA", rates.getAOA()));
        currencyList.add(new Currency("ARS", rates.getARS()));
        currencyList.add(new Currency("AUD", rates.getAUD()));
        currencyList.add(new Currency("AWG", rates.getAWG()));
        currencyList.add(new Currency("AZN", rates.getAZN()));
        currencyList.add(new Currency("BAM", rates.getBAM()));
        currencyList.add(new Currency("BBD", rates.getBBD()));
        currencyList.add(new Currency("BDT", rates.getBDT()));
        currencyList.add(new Currency("BGN", rates.getBGN()));
        currencyList.add(new Currency("BHD", rates.getBHD()));
        currencyList.add(new Currency("BIF", rates.getBIF()));
        currencyList.add(new Currency("BMD", rates.getBMD()));
        currencyList.add(new Currency("BND", rates.getBND()));
        currencyList.add(new Currency("BOB", rates.getBOB()));
        currencyList.add(new Currency("BRL", rates.getBRL()));
        currencyList.add(new Currency("BSD", rates.getBSD()));
        currencyList.add(new Currency("BTC", rates.getBTC()));
        currencyList.add(new Currency("BTN", rates.getBTN()));
        currencyList.add(new Currency("BWP", rates.getBWP()));
        currencyList.add(new Currency("BYN", rates.getBYN()));
        currencyList.add(new Currency("BYR", rates.getBYR()));
        currencyList.add(new Currency("BZD", rates.getBZD()));
        currencyList.add(new Currency("CAD", rates.getCAD()));
        currencyList.add(new Currency("CDF", rates.getCDF()));
        currencyList.add(new Currency("CHF", rates.getCHF()));
        currencyList.add(new Currency("CLF", rates.getCLF()));
        currencyList.add(new Currency("CLP", rates.getCLP()));
        currencyList.add(new Currency("CNY", rates.getCNY()));
        currencyList.add(new Currency("COP", rates.getCOP()));
        currencyList.add(new Currency("CRC", rates.getCRC()));
        currencyList.add(new Currency("CUC", rates.getCUC()));
        currencyList.add(new Currency("CUP", rates.getCUP()));
        currencyList.add(new Currency("CVE", rates.getCVE()));
        currencyList.add(new Currency("CZK", rates.getCZK()));
        currencyList.add(new Currency("DJF", rates.getDJF()));
        currencyList.add(new Currency("DKK", rates.getDKK()));
        currencyList.add(new Currency("DOP", rates.getDOP()));
        currencyList.add(new Currency("DZD", rates.getDZD()));
        currencyList.add(new Currency("EGP", rates.getEGP()));
        currencyList.add(new Currency("ERN", rates.getERN()));
        currencyList.add(new Currency("ETB", rates.getETB()));
        currencyList.add(new Currency("EUR", rates.getEUR()));
        currencyList.add(new Currency("FJD", rates.getFJD()));
        currencyList.add(new Currency("FKP", rates.getFKP()));
        currencyList.add(new Currency("GCN", rates.getGCN()));
        currencyList.add(new Currency("GBP", rates.getGBP()));
        currencyList.add(new Currency("GEL", rates.getGEL()));
        currencyList.add(new Currency("GGP", rates.getGGP()));
        currencyList.add(new Currency("GHS", rates.getGHS()));
        currencyList.add(new Currency("GIP", rates.getGIP()));
        currencyList.add(new Currency("GMD", rates.getGMD()));
        currencyList.add(new Currency("GNF", rates.getGNF()));
        currencyList.add(new Currency("GTQ", rates.getGTQ()));
        currencyList.add(new Currency("GYD", rates.getGYD()));
        currencyList.add(new Currency("HKD", rates.getHKD()));
        currencyList.add(new Currency("HNL", rates.getHNL()));
        currencyList.add(new Currency("HRK", rates.getHRK()));
        currencyList.add(new Currency("HTG", rates.getHTG()));
        currencyList.add(new Currency("HUF", rates.getHUF()));
        currencyList.add(new Currency("IDR", rates.getIDR()));
        currencyList.add(new Currency("ILS", rates.getILS()));
        currencyList.add(new Currency("IMP", rates.getIMP()));
        currencyList.add(new Currency("INR", rates.getINR()));
        currencyList.add(new Currency("IQD", rates.getIQD()));
        currencyList.add(new Currency("IRR", rates.getIRR()));
        currencyList.add(new Currency("ISK", rates.getISK()));
        currencyList.add(new Currency("JEP", rates.getJEP()));
        currencyList.add(new Currency("JMD", rates.getJMD()));
        currencyList.add(new Currency("JOD", rates.getJOD()));
        currencyList.add(new Currency("JPY", rates.getJPY()));
        currencyList.add(new Currency("KES", rates.getKES()));
        currencyList.add(new Currency("KGS", rates.getKGS()));
        currencyList.add(new Currency("KHR", rates.getKHR()));
        currencyList.add(new Currency("KMF", rates.getKMF()));
        currencyList.add(new Currency("KPW", rates.getKPW()));
        currencyList.add(new Currency("KRW", rates.getKRW()));
        currencyList.add(new Currency("KWD", rates.getKWD()));
        currencyList.add(new Currency("KYD", rates.getKYD()));
        currencyList.add(new Currency("KZT", rates.getKZT()));
        currencyList.add(new Currency("LAK", rates.getLAK()));
        currencyList.add(new Currency("LBP", rates.getLBP()));
        currencyList.add(new Currency("LKR", rates.getLKR()));
        currencyList.add(new Currency("LRD", rates.getLRD()));
        currencyList.add(new Currency("LSL", rates.getLSL()));
        currencyList.add(new Currency("LTL", rates.getLTL()));
        currencyList.add(new Currency("LVL", rates.getLVL()));
        currencyList.add(new Currency("LYD", rates.getLYD()));
        currencyList.add(new Currency("MAD", rates.getMAD()));
        currencyList.add(new Currency("MDL", rates.getMDL()));
        currencyList.add(new Currency("MGA", rates.getMGA()));
        currencyList.add(new Currency("MKD", rates.getMKD()));
        currencyList.add(new Currency("MMK", rates.getMMK()));
        currencyList.add(new Currency("MNT", rates.getMNT()));
        currencyList.add(new Currency("MOP", rates.getMOP()));
        currencyList.add(new Currency("MRO", rates.getMRO()));
        currencyList.add(new Currency("MUR", rates.getMUR()));
        currencyList.add(new Currency("MVR", rates.getMVR()));
        currencyList.add(new Currency("MWK", rates.getMWK()));
        currencyList.add(new Currency("MXN", rates.getMXN()));
        currencyList.add(new Currency("MYR", rates.getMYR()));
        currencyList.add(new Currency("MZN", rates.getMZN()));
        currencyList.add(new Currency("NAD", rates.getNAD()));
        currencyList.add(new Currency("NGN", rates.getNGN()));
        currencyList.add(new Currency("NIO", rates.getNIO()));
        currencyList.add(new Currency("NOK", rates.getNOK()));
        currencyList.add(new Currency("NPR", rates.getNPR()));
        currencyList.add(new Currency("NZD", rates.getNZD()));
        currencyList.add(new Currency("OMR", rates.getOMR()));
        currencyList.add(new Currency("PAB", rates.getPAB()));
        currencyList.add(new Currency("PEN", rates.getPEN()));
        currencyList.add(new Currency("PGK", rates.getPGK()));
        currencyList.add(new Currency("PHP", rates.getPHP()));
        currencyList.add(new Currency("QAR", rates.getQAR()));
        currencyList.add(new Currency("RON", rates.getRON()));
        currencyList.add(new Currency("RSD", rates.getRSD()));
        currencyList.add(new Currency("RUB", rates.getRUB()));
        currencyList.add(new Currency("RWF", rates.getRWF()));
        currencyList.add(new Currency("SOM", rates.getSOM()));
        currencyList.add(new Currency("SAR", rates.getSAR()));
        currencyList.add(new Currency("SBD", rates.getSBD()));
        currencyList.add(new Currency("SCR", rates.getSCR()));
        currencyList.add(new Currency("SDG", rates.getSDG()));
        currencyList.add(new Currency("SEK", rates.getSEK()));
        currencyList.add(new Currency("SGD", rates.getSGD()));
        currencyList.add(new Currency("SHP", rates.getSHP()));
        currencyList.add(new Currency("SLL", rates.getSLL()));
        currencyList.add(new Currency("THB", rates.getTHB()));
        currencyList.add(new Currency("TJS", rates.getTJS()));
        currencyList.add(new Currency("TMT", rates.getTMT()));
        currencyList.add(new Currency("TND", rates.getTND()));
        currencyList.add(new Currency("TOP", rates.getTOP()));
        currencyList.add(new Currency("TRY", rates.getTRY()));
        currencyList.add(new Currency("TTD", rates.getTTD()));
        currencyList.add(new Currency("UGX", rates.getUGX()));
        currencyList.add(new Currency("USD", rates.getUSD()));
        currencyList.add(new Currency("UYU", rates.getUYU()));
        currencyList.add(new Currency("UZS", rates.getUZS()));
        currencyList.add(new Currency("VEF", rates.getVEF()));
        currencyList.add(new Currency("VUV", rates.getVUV()));
        currencyList.add(new Currency("WST", rates.getWST()));
        currencyList.add(new Currency("XAF", rates.getXAF()));
        currencyList.add(new Currency("XAU", rates.getXAU()));
        currencyList.add(new Currency("XPF", rates.getXPF()));
        currencyList.add(new Currency("YER", rates.getYER()));
        currencyList.add(new Currency("ZMK", rates.getZMK()));
        currencyList.add(new Currency("ZMW", rates.getZMW()));
        currencyList.add(new Currency("ZWL", rates.getZWL()));
        return currencyList;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public RatesBean getRates() {
        return rates;
    }

    public void setRates(RatesBean rates) {
        this.rates = rates;
    }

    public static class RatesBean {
        /**
         * AED : 4.051089
         * AFN : 86.376181
         * ALL : 123.083056
         * AMD : 527.013492
         * ANG : 1.913858
         * AOA : 508.508929
         * ARS : 65.630129
         * AUD : 1.608196
         * AWG : 1.985178
         * AZN : 1.876276
         * BAM : 1.956196
         * BBD : 2.227317
         * BDT : 93.482809
         * BGN : 1.956544
         * BHD : 0.415759
         * BIF : 2069.397591
         * BMD : 1.102877
         * BND : 1.499581
         * BOB : 7.628098
         * BRL : 4.592151
         * BSD : 1.103107
         * BTC : 1.27E-4
         * BTN : 78.671242
         * BWP : 12.029753
         * BYN : 2.252822
         * BYR : 21616.381078
         * BZD : 2.223516
         * CAD : 1.458494
         * CDF : 1836.289448
         * CHF : 1.097451
         * CLF : 0.030229
         * CLP : 834.102679
         * CNY : 7.729731
         * COP : 3661.21896
         * CRC : 645.630934
         * CUC : 1.102877
         * CUP : 29.22623
         * CVE : 110.286654
         * CZK : 25.510648
         * DJF : 196.003843
         * DKK : 7.472286
         * DOP : 58.287918
         * DZD : 132.466639
         * EGP : 17.846091
         * ERN : 16.543414
         * ETB : 32.67602
         * EUR : 1
         * FJD : 2.407603
         * FKP : 0.896506
         * GBP : 0.859891
         * GEL : 3.264389
         * GGP : 0.859815
         * GHS : 6.094697
         * GIP : 0.896506
         * GMD : 56.489936
         * GNF : 10031.67943
         * GTQ : 8.493967
         * GYD : 230.785319
         * HKD : 8.634663
         * HNL : 27.158087
         * HRK : 7.433272
         * HTG : 107.563145
         * HUF : 334.496951
         * IDR : 15525.745134
         * ILS : 3.8602
         * IMP : 0.859815
         * INR : 78.8943
         * IQD : 1316.90258
         * IRR : 46436.619
         * ISK : 137.694362
         * JEP : 0.859815
         * JMD : 155.196065
         * JOD : 0.781897
         * JPY : 120.146253
         * KES : 112.931204
         * KGS : 77.02777
         * KHR : 4484.139924
         * KMF : 492.930803
         * KPW : 992.646059
         * KRW : 1285.127107
         * KWD : 0.335087
         * KYD : 0.919276
         * KZT : 428.832274
         * LAK : 9764.728095
         * LBP : 1667.912466
         * LKR : 199.193507
         * LRD : 233.120533
         * LSL : 16.344819
         * LTL : 3.256508
         * LVL : 0.667119
         * LYD : 1.55009
         * MAD : 10.677496
         * MDL : 19.2216
         * MGA : 4131.133826
         * MKD : 61.482858
         * MMK : 1673.964279
         * MNT : 2985.397836
         * MOP : 8.895107
         * MRO : 393.727322
         * MUR : 40.203679
         * MVR : 17.039583
         * MWK : 810.496723
         * MXN : 21.098459
         * MYR : 4.569766
         * MZN : 69.563972
         * NAD : 16.344928
         * NGN : 399.241567
         * NIO : 37.212971
         * NOK : 10.094166
         * NPR : 125.872573
         * NZD : 1.733369
         * OMR : 0.424613
         * PAB : 1.103107
         * PEN : 3.688791
         * PGK : 3.755203
         * PHP : 56.092315
         * PKR : 172.34388
         * PLN : 4.274974
         * PYG : 7111.632107
         * QAR : 4.015552
         * RON : 4.762
         * RSD : 117.582107
         * RUB : 70.518482
         * RWF : 1028.09251
         * SAR : 4.136133
         * SBD : 9.118575
         * SCR : 15.109624
         * SDG : 49.75692
         * SEK : 10.714832
         * SGD : 1.50157
         * SHP : 1.456787
         * SLL : 10659.301975
         * SOS : 640.770933
         * SRD : 8.225265
         * STD : 23778.890459
         * SVC : 9.651851
         * SYP : 567.981438
         * SZL : 16.346962
         * THB : 33.458358
         * TJS : 10.6947
         * TMT : 3.860068
         * TND : 3.148162
         * TOP : 2.558949
         * TRY : 6.375625
         * TTD : 7.474735
         * TWD : 33.557253
         * TZS : 2542.656271
         * UAH : 27.035464
         * UGX : 4078.200934
         * USD : 1.102877
         * UYU : 41.339118
         * UZS : 10457.495665
         * VEF : 11.014976
         * VND : 25590.793167
         * VUV : 129.327899
         * WST : 2.940489
         * XAF : 656.079896
         * XAG : 0.06525
         * XAU : 7.53E-4
         * XCD : 2.980579
         * XDR : 0.802839
         * XOF : 656.079896
         * XPF : 119.283426
         * YER : 276.105443
         * ZAR : 16.41356
         * ZMK : 9927.21526
         * ZMW : 15.040817
         * ZWL : 355.126262
         */

        private double AED;
        private double AFN;
        private double ALL;
        private double AMD;
        private double ANG;
        private double AOA;
        private double ARS;
        private double AUD;
        private double AWG;
        private double AZN;
        private double BAM;
        private double BBD;
        private double BDT;
        private double BGN;
        private double BHD;
        private double BIF;
        private double BMD;
        private double BND;
        private double BOB;
        private double BRL;
        private double BSD;
        private double BTC;
        private double BTN;
        private double BWP;
        private double BYN;
        private double BYR;
        private double BZD;
        private double CAD;
        private double CDF;
        private double CHF;
        private double CLF;
        private double CLP;
        private double CNY;
        private double COP;
        private double CRC;
        private double CUC;
        private double CUP;
        private double CVE;
        private double CZK;
        private double DJF;
        private double DKK;
        private double DOP;
        private double DZD;
        private double EGP;
        private double ERN;
        private double ETB;
        private int EUR;
        private double FJD;
        private double FKP;
        private double GCN=150;
        private double GBP;
        private double GEL;
        private double GGP;
        private double GHS;
        private double GIP;
        private double GMD;
        private double GNF;
        private double GTQ;
        private double GYD;
        private double HKD;
        private double HNL;
        private double HRK;
        private double HTG;
        private double HUF;
        private double IDR;
        private double ILS;
        private double IMP;
        private double INR;
        private double IQD;
        private double IRR;
        private double ISK;
        private double JEP;
        private double JMD;
        private double JOD;
        private double JPY;
        private double KES;
        private double KGS;
        private double KHR;
        private double KMF;
        private double KPW;
        private double KRW;
        private double KWD;
        private double KYD;
        private double KZT;
        private double LAK;
        private double LBP;
        private double LKR;
        private double LRD;
        private double LSL;
        private double LTL;
        private double LVL;
        private double LYD;
        private double MAD;
        private double MDL;
        private double MGA;
        private double MKD;
        private double MMK;
        private double MNT;
        private double MOP;
        private double MRO;
        private double MUR;
        private double MVR;
        private double MWK;
        private double MXN;
        private double MYR;
        private double MZN;
        private double NAD;
        private double NGN;
        private double NIO;
        private double NOK;
        private double NPR;
        private double NZD;
        private double OMR;
        private double PAB;
        private double PEN;
        private double PGK;
        private double PHP;
        private double QAR;
        private double RON;
        private double RSD;
        private double RUB;
        private double RWF;
        private double SOM = 76.91;
        private double SAR;
        private double SBD;
        private double SCR;
        private double SDG;
        private double SEK;
        private double SGD;
        private double SHP;
        private double SLL;
        private double THB;
        private double TJS;
        private double TMT;
        private double TND;
        private double TOP;
        private double TRY;
        private double TTD;
        private double UGX;
        private double USD;
        private double UYU;
        private double UZS;
        private double VEF;
        private double VUV;
        private double WST;
        private double XAF;
        private double XAU;
        private double XPF;
        private double YER;
        private double ZMK;
        private double ZMW;
        private double ZWL;

        public double getAED() {
            return AED;
        }

        public void setAED(double AED) {
            this.AED = AED;
        }

        public double getAFN() {
            return AFN;
        }

        public void setAFN(double AFN) {
            this.AFN = AFN;
        }

        public double getALL() {
            return ALL;
        }

        public void setALL(double ALL) {
            this.ALL = ALL;
        }

        public double getAMD() {
            return AMD;
        }

        public void setAMD(double AMD) {
            this.AMD = AMD;
        }

        public double getANG() {
            return ANG;
        }

        public void setANG(double ANG) {
            this.ANG = ANG;
        }

        public double getAOA() {
            return AOA;
        }

        public void setAOA(double AOA) {
            this.AOA = AOA;
        }

        public double getARS() {
            return ARS;
        }

        public void setARS(double ARS) {
            this.ARS = ARS;
        }

        public double getAUD() {
            return AUD;
        }

        public void setAUD(double AUD) {
            this.AUD = AUD;
        }

        public double getAWG() {
            return AWG;
        }

        public void setAWG(double AWG) {
            this.AWG = AWG;
        }

        public double getAZN() {
            return AZN;
        }

        public void setAZN(double AZN) {
            this.AZN = AZN;
        }

        public double getBAM() {
            return BAM;
        }

        public void setBAM(double BAM) {
            this.BAM = BAM;
        }

        public double getBBD() {
            return BBD;
        }

        public void setBBD(double BBD) {
            this.BBD = BBD;
        }

        public double getBDT() {
            return BDT;
        }

        public void setBDT(double BDT) {
            this.BDT = BDT;
        }

        public double getBGN() {
            return BGN;
        }

        public void setBGN(double BGN) {
            this.BGN = BGN;
        }

        public double getBHD() {
            return BHD;
        }

        public void setBHD(double BHD) {
            this.BHD = BHD;
        }

        public double getGCN() {
            return GCN;
        }

        public void setGCN(double GCN) {
            this.GCN = GCN;
        }

        public double getBIF() {
            return BIF;
        }

        public void setBIF(double BIF) {
            this.BIF = BIF;
        }

        public double getBMD() {
            return BMD;
        }

        public void setBMD(double BMD) {
            this.BMD = BMD;
        }

        public double getBND() {
            return BND;
        }

        public void setBND(double BND) {
            this.BND = BND;
        }

        public double getBOB() {
            return BOB;
        }

        public void setBOB(double BOB) {
            this.BOB = BOB;
        }

        public double getBRL() {
            return BRL;
        }

        public void setBRL(double BRL) {
            this.BRL = BRL;
        }

        public double getBSD() {
            return BSD;
        }

        public void setBSD(double BSD) {
            this.BSD = BSD;
        }

        public double getBTC() {
            return BTC;
        }

        public void setBTC(double BTC) {
            this.BTC = BTC;
        }

        public double getBTN() {
            return BTN;
        }

        public void setBTN(double BTN) {
            this.BTN = BTN;
        }

        public double getBWP() {
            return BWP;
        }

        public void setBWP(double BWP) {
            this.BWP = BWP;
        }

        public double getBYN() {
            return BYN;
        }

        public void setBYN(double BYN) {
            this.BYN = BYN;
        }

        public double getBYR() {
            return BYR;
        }

        public void setBYR(double BYR) {
            this.BYR = BYR;
        }

        public double getBZD() {
            return BZD;
        }

        public void setBZD(double BZD) {
            this.BZD = BZD;
        }

        public double getCAD() {
            return CAD;
        }

        public void setCAD(double CAD) {
            this.CAD = CAD;
        }

        public double getCDF() {
            return CDF;
        }

        public void setCDF(double CDF) {
            this.CDF = CDF;
        }

        public double getCHF() {
            return CHF;
        }

        public void setCHF(double CHF) {
            this.CHF = CHF;
        }

        public double getCLF() {
            return CLF;
        }

        public void setCLF(double CLF) {
            this.CLF = CLF;
        }

        public double getCLP() {
            return CLP;
        }

        public void setCLP(double CLP) {
            this.CLP = CLP;
        }

        public double getCNY() {
            return CNY;
        }

        public void setCNY(double CNY) {
            this.CNY = CNY;
        }

        public double getCOP() {
            return COP;
        }

        public void setCOP(double COP) {
            this.COP = COP;
        }

        public double getCRC() {
            return CRC;
        }

        public void setCRC(double CRC) {
            this.CRC = CRC;
        }

        public double getCUC() {
            return CUC;
        }

        public void setCUC(double CUC) {
            this.CUC = CUC;
        }

        public double getCUP() {
            return CUP;
        }

        public void setCUP(double CUP) {
            this.CUP = CUP;
        }

        public double getCVE() {
            return CVE;
        }

        public void setCVE(double CVE) {
            this.CVE = CVE;
        }

        public double getCZK() {
            return CZK;
        }

        public void setCZK(double CZK) {
            this.CZK = CZK;
        }

        public double getDJF() {
            return DJF;
        }

        public void setDJF(double DJF) {
            this.DJF = DJF;
        }

        public double getDKK() {
            return DKK;
        }

        public void setDKK(double DKK) {
            this.DKK = DKK;
        }

        public double getDOP() {
            return DOP;
        }

        public void setDOP(double DOP) {
            this.DOP = DOP;
        }

        public double getDZD() {
            return DZD;
        }

        public void setDZD(double DZD) {
            this.DZD = DZD;
        }

        public double getEGP() {
            return EGP;
        }

        public void setEGP(double EGP) {
            this.EGP = EGP;
        }

        public double getERN() {
            return ERN;
        }

        public void setERN(double ERN) {
            this.ERN = ERN;
        }

        public double getETB() {
            return ETB;
        }

        public void setETB(double ETB) {
            this.ETB = ETB;
        }

        public int getEUR() {
            return EUR;
        }

        public void setEUR(int EUR) {
            this.EUR = EUR;
        }

        public double getFJD() {
            return FJD;
        }

        public void setFJD(double FJD) {
            this.FJD = FJD;
        }

        public double getFKP() {
            return FKP;
        }

        public void setFKP(double FKP) {
            this.FKP = FKP;
        }

        public double getGBP() {
            return GBP;
        }

        public void setGBP(double GBP) {
            this.GBP = GBP;
        }

        public double getGEL() {
            return GEL;
        }

        public void setGEL(double GEL) {
            this.GEL = GEL;
        }

        public double getGGP() {
            return GGP;
        }

        public void setGGP(double GGP) {
            this.GGP = GGP;
        }

        public double getGHS() {
            return GHS;
        }

        public void setGHS(double GHS) {
            this.GHS = GHS;
        }

        public double getGIP() {
            return GIP;
        }

        public void setGIP(double GIP) {
            this.GIP = GIP;
        }

        public double getGMD() {
            return GMD;
        }

        public void setGMD(double GMD) {
            this.GMD = GMD;
        }

        public double getGNF() {
            return GNF;
        }

        public void setGNF(double GNF) {
            this.GNF = GNF;
        }

        public double getGTQ() {
            return GTQ;
        }

        public void setGTQ(double GTQ) {
            this.GTQ = GTQ;
        }

        public double getGYD() {
            return GYD;
        }

        public void setGYD(double GYD) {
            this.GYD = GYD;
        }

        public double getHKD() {
            return HKD;
        }

        public void setHKD(double HKD) {
            this.HKD = HKD;
        }

        public double getHNL() {
            return HNL;
        }

        public void setHNL(double HNL) {
            this.HNL = HNL;
        }

        public double getHRK() {
            return HRK;
        }

        public void setHRK(double HRK) {
            this.HRK = HRK;
        }

        public double getHTG() {
            return HTG;
        }

        public void setHTG(double HTG) {
            this.HTG = HTG;
        }

        public double getHUF() {
            return HUF;
        }

        public void setHUF(double HUF) {
            this.HUF = HUF;
        }

        public double getIDR() {
            return IDR;
        }

        public void setIDR(double IDR) {
            this.IDR = IDR;
        }

        public double getILS() {
            return ILS;
        }

        public void setILS(double ILS) {
            this.ILS = ILS;
        }

        public double getIMP() {
            return IMP;
        }

        public void setIMP(double IMP) {
            this.IMP = IMP;
        }

        public double getINR() {
            return INR;
        }

        public void setINR(double INR) {
            this.INR = INR;
        }

        public double getIQD() {
            return IQD;
        }

        public void setIQD(double IQD) {
            this.IQD = IQD;
        }

        public double getIRR() {
            return IRR;
        }

        public void setIRR(double IRR) {
            this.IRR = IRR;
        }

        public double getISK() {
            return ISK;
        }

        public void setISK(double ISK) {
            this.ISK = ISK;
        }

        public double getJEP() {
            return JEP;
        }

        public void setJEP(double JEP) {
            this.JEP = JEP;
        }

        public double getJMD() {
            return JMD;
        }

        public void setJMD(double JMD) {
            this.JMD = JMD;
        }

        public double getJOD() {
            return JOD;
        }

        public void setJOD(double JOD) {
            this.JOD = JOD;
        }

        public double getJPY() {
            return JPY;
        }

        public void setJPY(double JPY) {
            this.JPY = JPY;
        }

        public double getKES() {
            return KES;
        }

        public void setKES(double KES) {
            this.KES = KES;
        }

        public double getKGS() {
            return KGS;
        }

        public void setKGS(double KGS) {
            this.KGS = KGS;
        }

        public double getKHR() {
            return KHR;
        }

        public void setKHR(double KHR) {
            this.KHR = KHR;
        }

        public double getKMF() {
            return KMF;
        }

        public void setKMF(double KMF) {
            this.KMF = KMF;
        }

        public double getKPW() {
            return KPW;
        }

        public void setKPW(double KPW) {
            this.KPW = KPW;
        }

        public double getKRW() {
            return KRW;
        }

        public void setKRW(double KRW) {
            this.KRW = KRW;
        }

        public double getKWD() {
            return KWD;
        }

        public void setKWD(double KWD) {
            this.KWD = KWD;
        }

        public double getKYD() {
            return KYD;
        }

        public void setKYD(double KYD) {
            this.KYD = KYD;
        }

        public double getKZT() {
            return KZT;
        }

        public void setKZT(double KZT) {
            this.KZT = KZT;
        }

        public double getLAK() {
            return LAK;
        }

        public void setLAK(double LAK) {
            this.LAK = LAK;
        }

        public double getLBP() {
            return LBP;
        }

        public void setLBP(double LBP) {
            this.LBP = LBP;
        }

        public double getLKR() {
            return LKR;
        }

        public void setLKR(double LKR) {
            this.LKR = LKR;
        }

        public double getLRD() {
            return LRD;
        }

        public void setLRD(double LRD) {
            this.LRD = LRD;
        }

        public double getLSL() {
            return LSL;
        }

        public void setLSL(double LSL) {
            this.LSL = LSL;
        }

        public double getLTL() {
            return LTL;
        }

        public void setLTL(double LTL) {
            this.LTL = LTL;
        }

        public double getLVL() {
            return LVL;
        }

        public void setLVL(double LVL) {
            this.LVL = LVL;
        }

        public double getLYD() {
            return LYD;
        }

        public void setLYD(double LYD) {
            this.LYD = LYD;
        }

        public double getMAD() {
            return MAD;
        }

        public void setMAD(double MAD) {
            this.MAD = MAD;
        }

        public double getMDL() {
            return MDL;
        }

        public void setMDL(double MDL) {
            this.MDL = MDL;
        }

        public double getMGA() {
            return MGA;
        }

        public void setMGA(double MGA) {
            this.MGA = MGA;
        }

        public double getMKD() {
            return MKD;
        }

        public void setMKD(double MKD) {
            this.MKD = MKD;
        }

        public double getMMK() {
            return MMK;
        }

        public void setMMK(double MMK) {
            this.MMK = MMK;
        }

        public double getMNT() {
            return MNT;
        }

        public void setMNT(double MNT) {
            this.MNT = MNT;
        }

        public double getMOP() {
            return MOP;
        }

        public void setMOP(double MOP) {
            this.MOP = MOP;
        }

        public double getMRO() {
            return MRO;
        }

        public void setMRO(double MRO) {
            this.MRO = MRO;
        }

        public double getMUR() {
            return MUR;
        }

        public void setMUR(double MUR) {
            this.MUR = MUR;
        }

        public double getMVR() {
            return MVR;
        }

        public void setMVR(double MVR) {
            this.MVR = MVR;
        }

        public double getMWK() {
            return MWK;
        }

        public void setMWK(double MWK) {
            this.MWK = MWK;
        }

        public double getMXN() {
            return MXN;
        }

        public void setMXN(double MXN) {
            this.MXN = MXN;
        }

        public double getMYR() {
            return MYR;
        }

        public void setMYR(double MYR) {
            this.MYR = MYR;
        }

        public double getMZN() {
            return MZN;
        }

        public void setMZN(double MZN) {
            this.MZN = MZN;
        }

        public double getNAD() {
            return NAD;
        }

        public void setNAD(double NAD) {
            this.NAD = NAD;
        }

        public double getNGN() {
            return NGN;
        }

        public void setNGN(double NGN) {
            this.NGN = NGN;
        }

        public double getNIO() {
            return NIO;
        }

        public void setNIO(double NIO) {
            this.NIO = NIO;
        }

        public double getNOK() {
            return NOK;
        }

        public void setNOK(double NOK) {
            this.NOK = NOK;
        }

        public double getNPR() {
            return NPR;
        }

        public void setNPR(double NPR) {
            this.NPR = NPR;
        }

        public double getNZD() {
            return NZD;
        }

        public void setNZD(double NZD) {
            this.NZD = NZD;
        }

        public double getOMR() {
            return OMR;
        }

        public void setOMR(double OMR) {
            this.OMR = OMR;
        }

        public double getPAB() {
            return PAB;
        }

        public void setPAB(double PAB) {
            this.PAB = PAB;
        }

        public double getPEN() {
            return PEN;
        }

        public void setPEN(double PEN) {
            this.PEN = PEN;
        }

        public double getPGK() {
            return PGK;
        }

        public void setPGK(double PGK) {
            this.PGK = PGK;
        }

        public double getPHP() {
            return PHP;
        }

        public void setPHP(double PHP) {
            this.PHP = PHP;
        }

        public double getQAR() {
            return QAR;
        }

        public void setQAR(double QAR) {
            this.QAR = QAR;
        }

        public double getRON() {
            return RON;
        }

        public void setRON(double RON) {
            this.RON = RON;
        }

        public double getRSD() {
            return RSD;
        }

        public void setRSD(double RSD) {
            this.RSD = RSD;
        }

        public double getRUB() {
            return RUB;
        }

        public void setRUB(double RUB) {
            this.RUB = RUB;
        }

        public double getRWF() {
            return RWF;
        }

        public void setRWF(double RWF) {
            this.RWF = RWF;
        }

        public double getSOM() {
            return SOM;
        }

        public void setSOM(double SOM) {
            this.SOM = SOM;
        }

        public double getSAR() {
            return SAR;
        }

        public void setSAR(double SAR) {
            this.SAR = SAR;
        }

        public double getSBD() {
            return SBD;
        }

        public void setSBD(double SBD) {
            this.SBD = SBD;
        }

        public double getSCR() {
            return SCR;
        }

        public void setSCR(double SCR) {
            this.SCR = SCR;
        }

        public double getSDG() {
            return SDG;
        }

        public void setSDG(double SDG) {
            this.SDG = SDG;
        }

        public double getSEK() {
            return SEK;
        }

        public void setSEK(double SEK) {
            this.SEK = SEK;
        }

        public double getSGD() {
            return SGD;
        }

        public void setSGD(double SGD) {
            this.SGD = SGD;
        }

        public double getSHP() {
            return SHP;
        }

        public void setSHP(double SHP) {
            this.SHP = SHP;
        }

        public double getSLL() {
            return SLL;
        }

        public void setSLL(double SLL) {
            this.SLL = SLL;
        }

        public double getTHB() {
            return THB;
        }

        public void setTHB(double THB) {
            this.THB = THB;
        }

        public double getTJS() {
            return TJS;
        }

        public void setTJS(double TJS) {
            this.TJS = TJS;
        }

        public double getTMT() {
            return TMT;
        }

        public void setTMT(double TMT) {
            this.TMT = TMT;
        }

        public double getTND() {
            return TND;
        }

        public void setTND(double TND) {
            this.TND = TND;
        }

        public double getTOP() {
            return TOP;
        }

        public void setTOP(double TOP) {
            this.TOP = TOP;
        }

        public double getTRY() {
            return TRY;
        }

        public void setTRY(double TRY) {
            this.TRY = TRY;
        }

        public double getTTD() {
            return TTD;
        }

        public void setTTD(double TTD) {
            this.TTD = TTD;
        }

        public double getUGX() {
            return UGX;
        }

        public void setUGX(double UGX) {
            this.UGX = UGX;
        }

        public double getUSD() {
            return USD;
        }

        public void setUSD(double USD) {
            this.USD = USD;
        }

        public double getUYU() {
            return UYU;
        }

        public void setUYU(double UYU) {
            this.UYU = UYU;
        }

        public double getUZS() {
            return UZS;
        }

        public void setUZS(double UZS) {
            this.UZS = UZS;
        }

        public double getVEF() {
            return VEF;
        }

        public void setVEF(double VEF) {
            this.VEF = VEF;
        }

        public double getVUV() {
            return VUV;
        }

        public void setVUV(double VUV) {
            this.VUV = VUV;
        }

        public double getWST() {
            return WST;
        }

        public void setWST(double WST) {
            this.WST = WST;
        }

        public double getXAF() {
            return XAF;
        }

        public void setXAF(double XAF) {
            this.XAF = XAF;
        }

        public double getXAU() {
            return XAU;
        }

        public void setXAU(double XAU) {
            this.XAU = XAU;
        }

        public double getXPF() {
            return XPF;
        }

        public void setXPF(double XPF) {
            this.XPF = XPF;
        }

        public double getYER() {
            return YER;
        }

        public void setYER(double YER) {
            this.YER = YER;
        }


        public double getZMK() {
            return ZMK;
        }

        public void setZMK(double ZMK) {
            this.ZMK = ZMK;
        }

        public double getZMW() {
            return ZMW;
        }

        public void setZMW(double ZMW) {
            this.ZMW = ZMW;
        }

        public double getZWL() {
            return ZWL;
        }

        public void setZWL(double ZWL) {
            this.ZWL = ZWL;
        }
    }
}
