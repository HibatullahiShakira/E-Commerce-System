package com.semicolon.services.serviceImplementation;

import com.semicolon.data.model.BillingInformation;
import com.semicolon.data.repositories.BillingInformationRepository;
import com.semicolon.data.repositories.UserRepository;
import com.semicolon.dto.request.*;
import com.semicolon.dto.response.*;
import com.semicolon.services.serviceInterface.BillingInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.semicolon.data.model.UserRole.ADMINISTRATORS;


@Service
public class BillingInformationServiceImpl implements BillingInformationService {

    @Autowired
    private BillingInformationRepository billingInformationRepository;
    @Autowired
    private UserRepository userRepository;

    public BillingInformationServiceImpl(BillingInformationRepository billingInformationRepository){
        this.billingInformationRepository = billingInformationRepository;
    }


    @Override
    public List<BillingInformation> getAllBillingInformationByUserRole(GetListBillingInformation getListBillingInformation) {
            if(getListBillingInformation.getUser().getRole() == ADMINISTRATORS) {
                List<BillingInformation> listBillingInformation = billingInformationRepository.findAllByUser(getListBillingInformation.getUser());
                if (listBillingInformation == null) {
                    throw new NullPointerException("List of BillingInformation not found");
                }
                return listBillingInformation;
            }
            throw new NullPointerException("User is not admin");
    }

    @Override
    public AddBillingInformationResponse addBillingInformation(BillingInformationDtoRequest billingInformationDtoRequest) {
        if (billingInformationDtoRequest.getUser() != null) {
            BillingInformation billingInformation = getBillingInformation(billingInformationDtoRequest);
            billingInformationRepository.save(billingInformation);

            AddBillingInformationResponse addBillingInformationResponse = new AddBillingInformationResponse();
            addBillingInformationResponse.setBillingId(billingInformation.getId());
            addBillingInformationResponse.setMessage("Billing Information Added");
            return addBillingInformationResponse;
        }
        throw new NullPointerException("You are not logged in");

    }

    private static BillingInformation getBillingInformation(BillingInformationDtoRequest billingInformationDtoRequest) {
        BillingInformation billingInformation = new BillingInformation();
        billingInformation.setUser(billingInformationDtoRequest.getUser());
        billingInformation.setCreditCardInformation(billingInformationDtoRequest.getCreditCardInformation());
        billingInformation.setEmail(billingInformationDtoRequest.getEmail());
        billingInformation.setPhoneNumber(billingInformationDtoRequest.getPhoneNumber());
        billingInformation.setDeliveryAddress(billingInformationDtoRequest.getDeliveryAddress());
        billingInformation.setName(billingInformationDtoRequest.getName());
        return billingInformation;
    }

    @Override
    public BillingInformationUpdateResponse updateBillingInformationByUser(BillingInformationUpdateRequest billingInformationUpdateRequest) {
            BillingInformation foundBillingInformation = billingInformationRepository.findBillingInformationByUser(billingInformationUpdateRequest.getUser());
            BillingInformationUpdateResponse billingInformationUpdateResponse = new BillingInformationUpdateResponse();
            if (foundBillingInformation == null) {
                throw new NullPointerException("BillingInformation not found");
            } else {
                if (billingInformationUpdateRequest.getCreditCardInformation() != null) {
                    foundBillingInformation.setCreditCardInformation(billingInformationUpdateRequest.getCreditCardInformation());
                }
                if (billingInformationUpdateRequest.getEmail() != null) {
                    foundBillingInformation.setEmail(billingInformationUpdateRequest.getEmail());
                }
                if (billingInformationUpdateRequest.getPhoneNumber() != null) {
                    foundBillingInformation.setPhoneNumber(billingInformationUpdateRequest.getPhoneNumber());
                }
                if (billingInformationUpdateRequest.getDeliveryAddress() != null) {
                    foundBillingInformation.setDeliveryAddress(billingInformationUpdateRequest.getDeliveryAddress());
                }
                if (billingInformationUpdateRequest.getName() != null) {
                    foundBillingInformation.setName(billingInformationUpdateRequest.getName());
                }
                billingInformationRepository.save(foundBillingInformation);
            }

            billingInformationRepository.save(foundBillingInformation);
            billingInformationUpdateResponse.setMessage("Billing Information updated successfully");
            return billingInformationUpdateResponse;
    }


    @Override
    public String deleteBillingInformation(DeleteBillingInformationRequest billingInformationDeleteRequest) {
        BillingInformation foundBillingInformation = billingInformationRepository.findBillingInformationByUser(billingInformationDeleteRequest.getUser());
        if (foundBillingInformation == null) {
            throw new NullPointerException("Billing Information not found");
        } else {
            billingInformationRepository.delete(foundBillingInformation);
        }
        return "Billing Information deleted successfully";
    }

    @Override
    public BillingInformationDtoResponse getBillingInformationId(BillingInformationDtoRequest billingInformationDtoRequest) {
        BillingInformationDtoResponse billingInformationDtoResponse = new BillingInformationDtoResponse();
        BillingInformation billingInformation = billingInformationRepository.findById(billingInformationDtoResponse.getId()).orElse(null);
        if (billingInformation == null) {
            throw new NullPointerException("BillingInformation not found");
        } else {
            billingInformationDtoResponse.setId(billingInformation.getId());
            billingInformationDtoResponse.setPhoneNumber(billingInformation.getPhoneNumber());
            billingInformationDtoResponse.setCreditCardInformation(billingInformation.getCreditCardInformation());
            billingInformationDtoResponse.setEmail(billingInformation.getEmail());
            billingInformationDtoResponse.setDeliveryAddress(billingInformation.getDeliveryAddress());
        }
        return billingInformationDtoResponse;
    }

}
