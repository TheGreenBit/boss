package com.bs.einvoice.errorrecords.controller;

import com.bs.einvoice.errorrecords.model.ErrorRecord;
import com.bs.einvoice.errorrecords.model.QueryParameter;
import com.bs.einvoice.errorrecords.utils.Formatters;
import com.bs.einvoice.rpc.domain.EInvoiceErrorRecord;
import com.bs.einvoice.rpc.service.EInvoiceErrorService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/records", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ErrorRecordsController {

    @Autowired
    private EInvoiceErrorService eInvoiceErrorService;

    @PostMapping("/list")
    public List<EInvoiceErrorRecord> records(@RequestBody QueryParameter parameter) throws ParseException {
        Date beginDate = parameter.getBeginDate();
        Date endDate = parameter.getEndDate();
        List<EInvoiceErrorRecord> eInvoiceErrorRecords = eInvoiceErrorService.queryErrorRecordsByRange(beginDate, endDate);
        return eInvoiceErrorRecords;
    }

    private ErrorRecord createErrorRecord() {
        ErrorRecord errorRecord = new ErrorRecord();
        errorRecord.setCause(RandomStringUtils.random(8, true, true));
        errorRecord.seteInvoiceCode(RandomStringUtils.random(8, true, true));
        errorRecord.seteInvoiceNumber(RandomStringUtils.random(8, true, true));
        errorRecord.setErrorTime(new Date().toString());
        errorRecord.setErrorType(RandomStringUtils.random(8, true, true));
        errorRecord.seteInvoiceContent(RandomStringUtils.random(8, true, true));
        errorRecord.setId(RandomStringUtils.random(21, true, true));
        errorRecord.setInvoicingPartyNoNeedSign("setInvoicingPartyNoNeedSign");
        errorRecord.setInvoicingPartySignature("setInvoicingPartySignature");
        return errorRecord;
    }
}
