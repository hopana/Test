package io.byte_streams;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class ReadBytes {
    public static void main(String[] args) {
        FileInputStream is = null;
        BufferedReader br = null;
        ArrayList<String> lines = null;
        ArrayList<Card> cards = new ArrayList<Card>();
        ArrayList<Consume> consumes = new ArrayList<Consume>();
        try {
            //is = new FileInputStream("c://ftp//开卡明细_20121227_0（范例）.txt");
            is = new FileInputStream("c://ftp//ConsumeDetail_20080301_31231 .txt");
            br = new BufferedReader(new InputStreamReader(is, "gbk"));
            String line = br.readLine();
            lines = new ArrayList<String>();
            while (line != null) {
                if (line.length() == 0) {// 检查是否是空行
                    line += System.getProperty("line.separator");
                } else {
                    lines.add(line);
                }
                line = br.readLine();
            }
            br.close();
            if (is != null) {
                is.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < lines.size(); i++) {
            byte[] b = null;
            //Card card = new Card();
            Consume consume = new Consume();
            String encoding = "gbk";
            try {
                b = lines.get(i).getBytes(encoding);
//				card.setCardNO(new String(b, 0, 60, encoding).trim());
//				card.setCardHolderName(new String(b, 60, 120, encoding).trim());
//				card.setBudgetUnitCode(Long.parseLong(new String(b, 180, 20, encoding).trim()));
//				card.setBudgetUnitName(new String(b, 200, 120, encoding).trim());
//				card.setFinanceDivisionCode(new String(b, 320, 20, encoding).trim());
//				card.setCreditLimit((Double.parseDouble(new String(b, 340, 15, encoding).trim())));
//				card.setCardType((Integer.parseInt(new String(b, 355, 1, encoding).trim())));
//				card.setCertificateNO(Long.parseLong(new String(b, 356, 20, encoding).trim()));
//				card.setSex((Integer.parseInt(new String(b, 376, 1, encoding).trim())));
//				card.setCardValidPeriod(new String(b, 377, 4, encoding).trim());
//				card.setSignupDate((new String(b, 381, 8, encoding).trim()));
//				card.setOperationType((Long.parseLong((new String(b, 389, 1, encoding).trim()))));
//				card.setBillingDate((new String(b, 390, 2, encoding).trim()));
//				cards.add(card);

                consume.setCardNo(new String(b, 0, 60, encoding).trim());
                consume.setSerialNo(new String(b, 60, 60, encoding).trim());
                consume.setTerminalNo(new String(b, 120, 30, encoding).trim());
                consume.setTerminalSerialNo(new String(b, 150, 20, encoding).trim());
                consume.setTransactionAuthNo(new String(b, 170, 40, encoding).trim());
                consume.setSystemTrackingNo(new String(b, 210, 20, encoding).trim());
                consume.setRetrievalRefNo(new String(b, 230, 20, encoding).trim());
                consume.setTransactionsDate(new String(b, 250, 8, encoding).trim());
                consume.setTransactionsTime(new String(b, 258, 6, encoding).trim());
                consume.setRecordedDate(new String(b, 264, 8, encoding).trim());
                consume.setMerchantName(new String(b, 272, 60, encoding).trim());
                consume.setSummary(new String(b, 332, 120, encoding).trim());
                consume.setTransactionAmount(Double.parseDouble((new String(b, 452, 15, encoding).trim())));
                consume.setRecordedAmount(Double.parseDouble((new String(b, 467, 15, encoding).trim())));
                consume.setTransactionCode(new String(b, 482, 4, encoding).trim());
                consume.setTransactionType(Integer.parseInt(new String(b, 486, 1, encoding).trim()));
                consume.setMerchantNo(new String(b, 487, 30, encoding).trim());
                consume.setTransactionCurrency(new String(b, 517, 3, encoding).trim());
                consume.setClearingCurrency(new String(b, 520, 3, encoding).trim());
                consume.setAcceptingInstCode(new String(b, 523, 20, encoding).trim());
                consume.setForwardingInstCode(new String(b, 543, 20, encoding).trim());
                consume.setReceivingInstCode(new String(b, 563, 20, encoding).trim());
                consume.setIssuingBankCode(new String(b, 583, 20, encoding).trim());
                consume.setIsUnionpayTransit(Integer.parseInt((new String(b, 603, 1, encoding).trim())));
                consume.setIsTransactionComplete(Integer.parseInt((new String(b, 604, 1, encoding).trim())));
                consumes.add(consume);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < consumes.size(); i++) {
            System.out.println(consumes.get(i).toString());
        }

    }
}

class Card {

    private String cardNO;
    private String cardHolderName;
    private Long budgetUnitCode;
    private String budgetUnitName;
    private String financeDivisionCode;
    private Double creditLimit;
    private Integer cardType;
    private Long certificateNO;
    private Integer sex;
    private String cardValidPeriod;
    private String signupDate;
    private Long operationType;
    private String billingDate;

    // Constructors

    public Card() {

    }

    public Card(String cardNO, String cardHolderName, Long budgetUnitCode, String budgetUnitName, String financeDivisionCode,
                Double creditLimit, Integer cardType, Long certificateNO, Integer sex, String cardValidPeriod, String signupDate,
                Long operationType, String billingDate) {
        this.cardNO = cardNO;
        this.cardHolderName = cardHolderName;
        this.budgetUnitCode = budgetUnitCode;
        this.budgetUnitName = budgetUnitName;
        this.financeDivisionCode = financeDivisionCode;
        this.creditLimit = creditLimit;
        this.cardType = cardType;
        this.certificateNO = certificateNO;
        this.sex = sex;
        this.cardValidPeriod = cardValidPeriod;
        this.signupDate = signupDate;
        this.operationType = operationType;
        this.billingDate = billingDate;
    }

    public String toString() {
        String info = cardNO + "|" + cardHolderName + "|" + budgetUnitCode + "|" + budgetUnitName + "|" + financeDivisionCode + "|"
                + creditLimit + "|" + cardType + "|" + certificateNO + "|" + sex + "|" + cardValidPeriod + "|" + signupDate + "|"
                + operationType + "|" + billingDate;
        return info;
    }

    // getters and setters

    public String getCardNO() {
        return cardNO;
    }

    public void setCardNO(String cardNO) {
        this.cardNO = cardNO;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public Long getBudgetUnitCode() {
        return budgetUnitCode;
    }

    public void setBudgetUnitCode(Long budgetUnitCode) {
        this.budgetUnitCode = budgetUnitCode;
    }

    public String getBudgetUnitName() {
        return budgetUnitName;
    }

    public void setBudgetUnitName(String budgetUnitName) {
        this.budgetUnitName = budgetUnitName;
    }

    public String getFinanceDivisionCode() {
        return financeDivisionCode;
    }

    public void setFinanceDivisionCode(String financeDivisionCode) {
        this.financeDivisionCode = financeDivisionCode;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public Long getCertificateNO() {
        return certificateNO;
    }

    public void setCertificateNO(Long certificateNO) {
        this.certificateNO = certificateNO;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getCardValidPeriod() {
        return cardValidPeriod;
    }

    public void setCardValidPeriod(String cardValidPeriod) {
        this.cardValidPeriod = cardValidPeriod;
    }

    public String getSignupDate() {
        return signupDate;
    }

    public void setSignupDate(String signupDate) {
        this.signupDate = signupDate;
    }

    public Long getOperationType() {
        return operationType;
    }

    public void setOperationType(Long operationType) {
        this.operationType = operationType;
    }

    public String getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(String billingDate) {
        this.billingDate = billingDate;
    }

}

class Consume {
    private Long id;
    private String cardNo;
    private String serialNo;
    private String terminalNo;
    private String terminalSerialNo;
    private String transactionAuthNo;
    private String systemTrackingNo;
    private String retrievalRefNo;
    private String transactionsDate;
    private String transactionsTime;
    private String recordedDate;
    private String merchantName;
    private String summary;
    private Double transactionAmount;
    private Double recordedAmount;
    private String transactionCode;
    private Integer transactionType;
    private String merchantNo;
    private String transactionCurrency;
    private String clearingCurrency;
    private String acceptingInstCode;
    private String forwardingInstCode;
    private String receivingInstCode;
    private String issuingBankCode;
    private Integer isUnionpayTransit;
    private Integer isTransactionComplete;

    public Consume() {

    }

    public Consume(Long id, String cardNo, String serialNo, String terminalNo, String terminalSerialNo, String transactionAuthNo,
                   String systemTrackingNo, String retrievalRefNo, String transactionsDate, String transactionsTime, String recordedDate,
                   String merchantName, String summary, Double transactionAmount, Double recordedAmount, String transactionCode, Integer transactionType,
                   String merchantNo, String transactionCurrency, String clearingCurrency, String acceptingInstCode, String forwardingInstCode,
                   String receivingInstCode, String issuingBankCode, Integer isUnionpayTransit, Integer isTransactionComplete) {
        super();
        this.id = id;
        this.cardNo = cardNo;
        this.serialNo = serialNo;
        this.terminalNo = terminalNo;
        this.terminalSerialNo = terminalSerialNo;
        this.transactionAuthNo = transactionAuthNo;
        this.systemTrackingNo = systemTrackingNo;
        this.retrievalRefNo = retrievalRefNo;
        this.transactionsDate = transactionsDate;
        this.transactionsTime = transactionsTime;
        this.recordedDate = recordedDate;
        this.merchantName = merchantName;
        this.summary = summary;
        this.transactionAmount = transactionAmount;
        this.recordedAmount = recordedAmount;
        this.transactionCode = transactionCode;
        this.transactionType = transactionType;
        this.merchantNo = merchantNo;
        this.transactionCurrency = transactionCurrency;
        this.clearingCurrency = clearingCurrency;
        this.acceptingInstCode = acceptingInstCode;
        this.forwardingInstCode = forwardingInstCode;
        this.receivingInstCode = receivingInstCode;
        this.issuingBankCode = issuingBankCode;
        this.isUnionpayTransit = isUnionpayTransit;
        this.isTransactionComplete = isTransactionComplete;
    }

    public String toString() {
        String info = cardNo + "|" + serialNo + "|" + terminalNo + "|" + terminalSerialNo + "|" + transactionAuthNo + "|"
                + systemTrackingNo + "|" + retrievalRefNo + "|" + transactionsDate + "|" + transactionsTime + "|" + recordedDate + "|" + merchantName + "|"
                + summary + "|" + transactionAmount + "|" + recordedAmount + "|" + transactionCode + "|" + transactionType + "|" + merchantNo + "|"
                + transactionCurrency + "|" + clearingCurrency + "|" + acceptingInstCode + "|" + acceptingInstCode + "|" + forwardingInstCode + "|"
                + receivingInstCode + "|" + issuingBankCode + "|" + isUnionpayTransit + "|" + isTransactionComplete;
        return info;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getTerminalNo() {
        return terminalNo;
    }

    public void setTerminalNo(String terminalNo) {
        this.terminalNo = terminalNo;
    }

    public String getTerminalSerialNo() {
        return terminalSerialNo;
    }

    public void setTerminalSerialNo(String terminalSerialNo) {
        this.terminalSerialNo = terminalSerialNo;
    }

    public String getTransactionAuthNo() {
        return transactionAuthNo;
    }

    public void setTransactionAuthNo(String transactionAuthNo) {
        this.transactionAuthNo = transactionAuthNo;
    }

    public String getSystemTrackingNo() {
        return systemTrackingNo;
    }

    public void setSystemTrackingNo(String systemTrackingNo) {
        this.systemTrackingNo = systemTrackingNo;
    }

    public String getRetrievalRefNo() {
        return retrievalRefNo;
    }

    public void setRetrievalRefNo(String retrievalRefNo) {
        this.retrievalRefNo = retrievalRefNo;
    }

    public String getTransactionsDate() {
        return transactionsDate;
    }

    public void setTransactionsDate(String transactionsDate) {
        this.transactionsDate = transactionsDate;
    }

    public String getTransactionsTime() {
        return transactionsTime;
    }

    public void setTransactionsTime(String transactionsTime) {
        this.transactionsTime = transactionsTime;
    }

    public String getRecordedDate() {
        return recordedDate;
    }

    public void setRecordedDate(String recordedDate) {
        this.recordedDate = recordedDate;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Double getRecordedAmount() {
        return recordedAmount;
    }

    public void setRecordedAmount(Double recordedAmount) {
        this.recordedAmount = recordedAmount;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public Integer getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Integer transactionType) {
        this.transactionType = transactionType;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getTransactionCurrency() {
        return transactionCurrency;
    }

    public void setTransactionCurrency(String transactionCurrency) {
        this.transactionCurrency = transactionCurrency;
    }

    public String getClearingCurrency() {
        return clearingCurrency;
    }

    public void setClearingCurrency(String clearingCurrency) {
        this.clearingCurrency = clearingCurrency;
    }

    public String getAcceptingInstCode() {
        return acceptingInstCode;
    }

    public void setAcceptingInstCode(String acceptingInstCode) {
        this.acceptingInstCode = acceptingInstCode;
    }

    public String getForwardingInstCode() {
        return forwardingInstCode;
    }

    public void setForwardingInstCode(String forwardingInstCode) {
        this.forwardingInstCode = forwardingInstCode;
    }

    public String getReceivingInstCode() {
        return receivingInstCode;
    }

    public void setReceivingInstCode(String receivingInstCode) {
        this.receivingInstCode = receivingInstCode;
    }

    public String getIssuingBankCode() {
        return issuingBankCode;
    }

    public void setIssuingBankCode(String issuingBankCode) {
        this.issuingBankCode = issuingBankCode;
    }

    public Integer getIsUnionpayTransit() {
        return isUnionpayTransit;
    }

    public void setIsUnionpayTransit(Integer isUnionpayTransit) {
        this.isUnionpayTransit = isUnionpayTransit;
    }

    public Integer getIsTransactionComplete() {
        return isTransactionComplete;
    }

    public void setIsTransactionComplete(Integer isTransactionComplete) {
        this.isTransactionComplete = isTransactionComplete;
    }

}
