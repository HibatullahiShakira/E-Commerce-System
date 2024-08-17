package com.semicolon.controller;

import com.semicolon.data.model.BillingInformation;
import com.semicolon.dto.request.*;
import com.semicolon.dto.response.*;
import com.semicolon.services.serviceInterface.BillingInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Service
@RestController
@RequestMapping("/billingInformation-api/")
public class BillingInformationController {

    private final BillingInformationService billingInformationService;

    @Autowired
    public BillingInformationController(BillingInformationService billingInformationService) {
        this.billingInformationService = billingInformationService;
    }

    @GetMapping("billing-Informations")
    public ResponseEntity<List<BillingInformation>> getAllBillingInformation(@RequestBody GetListBillingInformation getListBillingInformation) {
        return new ResponseEntity<>(billingInformationService.getAllBillingInformationByUserRole(getListBillingInformation), HttpStatus.OK);
    }

    @GetMapping("billing-Information/id")
    public ResponseEntity<BillingInformationDtoResponse> getBillingInformationById(@RequestBody BillingInformationDtoRequest billingInformationDtoRequest) {
        return ResponseEntity.ok(billingInformationService.getBillingInformationId(billingInformationDtoRequest));
    }

    @PostMapping("billing-Information/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AddBillingInformationResponse> createBillingInformation(@RequestBody BillingInformationDtoRequest billingInformationDtoRequest) {
        return ResponseEntity.ok(billingInformationService.addBillingInformation(billingInformationDtoRequest));
    }

    @PatchMapping("billing-Information/update")
    public ResponseEntity<BillingInformationUpdateResponse> updateBillingInformation(@RequestBody BillingInformationUpdateRequest billingInformationUpdateRequest) {
        BillingInformationUpdateResponse response = billingInformationService.updateBillingInformationByUser(billingInformationUpdateRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("billing-Information/delete")
    public ResponseEntity<String> deleteBillingInformation(@RequestBody DeleteBillingInformationRequest deleteBillingInformationRequest) {
        billingInformationService.deleteBillingInformation(deleteBillingInformationRequest);
        return new ResponseEntity<>("Contact deleted sucessfully", HttpStatus.OK);
    }

}
