package com.semicolon.services.serviceInterface;

import com.semicolon.data.model.BillingInformation;
import com.semicolon.dto.request.*;
import com.semicolon.dto.response.*;

import java.util.List;

public interface BillingInformationService {
    List<BillingInformation> getAllBillingInformationByUserRole(GetListBillingInformation getListBillingInformation);
    AddBillingInformationResponse addBillingInformation(BillingInformationDtoRequest billingInformationDtoRequest);
    BillingInformationUpdateResponse updateBillingInformationByUser(BillingInformationUpdateRequest billingInformationDtoRequest);
    String deleteBillingInformation(DeleteBillingInformationRequest billingInformationDeleteRequest);
    BillingInformationDtoResponse getBillingInformationId(BillingInformationDtoRequest billingInformationDtoRequest);

}
