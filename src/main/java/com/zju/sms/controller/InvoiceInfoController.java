package com.zju.sms.controller;

import com.zju.sms.domain.InvoiceInfo;
import com.zju.sms.service.IInvoiceInfoService;
import com.zju.sms.shiro.PermissionName;
import com.zju.sms.util.UpdateUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiresPermissions("invoiceInfos")
@PermissionName("发票")
public class InvoiceInfoController {
    @Autowired
    private IInvoiceInfoService invoiceInfoService;

    @RequestMapping(value = "/invoiceInfos",method = RequestMethod.POST)
    public String saveInvoiceInfo(@RequestBody InvoiceInfo invoiceInfo){
        invoiceInfoService.save(invoiceInfo);
        return"success";
    }
    @RequestMapping(value = "/invoiceInfos",method = RequestMethod.PUT)
    public String updateInvoiceInfo(@RequestBody InvoiceInfo invoiceInfo){
        InvoiceInfo old = invoiceInfoService.get(invoiceInfo.getUserId());
        UpdateUtil.updateIfNotNull(old,invoiceInfo);
        invoiceInfoService.update(old);
        return"success";
    }
    @RequestMapping(value = "/invoiceInfos/{id}",method = RequestMethod.DELETE)
    public String deleteInvoiceInfo(@PathVariable("id") Integer id){
        invoiceInfoService.delete(id);
        return"success";
    }
    @RequestMapping(value = "/invoiceInfos/{id}",method = RequestMethod.GET)
    public InvoiceInfo getInvoiceInfo(@PathVariable("id") Integer id){
        return invoiceInfoService.get(id);
    }
    @RequestMapping(value = "/invoiceInfos",method = RequestMethod.GET)
    public List<InvoiceInfo> getAdvice(){
        return invoiceInfoService.getAll();
    }
}
