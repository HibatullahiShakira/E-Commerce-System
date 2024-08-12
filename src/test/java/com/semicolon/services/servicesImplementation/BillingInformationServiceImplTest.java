package com.semicolon.services.servicesImplementation;

import com.semicolon.data.model.BillingInformation;
import com.semicolon.data.model.CreditCardInformation;
import com.semicolon.data.model.User;
import com.semicolon.data.model.UserRole;
import com.semicolon.dto.request.*;
import com.semicolon.dto.response.AddBillingInformationResponse;
import com.semicolon.dto.response.BillingInformationUpdateResponse;
import com.semicolon.repositories.BillingInformationRepository;
import com.semicolon.services.serviceInterface.BillingInformationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.semicolon.data.model.CardType.VERVE;
import static com.semicolon.data.model.UserRole.ADMINISTRATORS;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BillingInformationServiceImplTest {

    @Autowired
    private BillingInformationRepository billingInformationRepository;

    @Autowired
    private BillingInformationService billingInformationService;
    @BeforeEach
    void setUp() {
        billingInformationRepository.deleteAll();
    }



    @Test
    public void testAddBillingInformation() {
        User user = new User();
        user.setAddress("abuja");
        user.setGender("female");
        user.setEmailAddress("shakirah@gmail.com");
        user.setPhoneNumber("123456789");
        user.setPassword("password");
        user.setAge(9);
        user.setName("shakirah");
        user.setRole(ADMINISTRATORS);
        user.setUserId(user.getUserId());
        CreditCardInformation creditCardInformation = new CreditCardInformation();
        BillingInformation billingInformation = new BillingInformation();
        creditCardInformation.setCardNumber("123456789");
        creditCardInformation.setExpiryMonth("12");
        creditCardInformation.setExpiryYear("2020");
        creditCardInformation.setCvv("123");
        creditCardInformation.setCardType(VERVE);

        BillingInformationDtoRequest billingInformationDtoRequest = new BillingInformationDtoRequest();
        billingInformationDtoRequest.setCreditCardInformation(creditCardInformation);
        billingInformationDtoRequest.setDeliveryAddress("lagos");
        billingInformationDtoRequest.setEmail("lagos@gmail.com");
        billingInformationDtoRequest.setName("shakirah");
        billingInformationDtoRequest.setPhoneNumber("080123456789");
        billingInformationDtoRequest.setUser(user);

        billingInformation.setName(billingInformationDtoRequest.getName());
        billingInformation.setEmail(billingInformationDtoRequest.getEmail());
        billingInformation.setPhoneNumber(billingInformationDtoRequest.getPhoneNumber());
        billingInformation.setCreditCardInformation(billingInformationDtoRequest.getCreditCardInformation());
        billingInformation.setDeliveryAddress(billingInformationDtoRequest.getDeliveryAddress());
        billingInformation.setUser(billingInformationDtoRequest.getUser());
        billingInformationService.addBillingInformation(billingInformationDtoRequest);
        billingInformation.setUser(user);
        AddBillingInformationResponse addBillingInformationResponse = billingInformationService.addBillingInformation(billingInformationDtoRequest);
        assertEquals(addBillingInformationResponse.getMessage(), "Billing Information Added");
    }

    @Test
    public void testUpdateBillingInformation() {
        User user = new User();
        user.setAddress("abuja");
        user.setGender("female");
        user.setEmailAddress("shakirah@gmail.com");
        user.setPhoneNumber("123456789");
        user.setPassword("password");
        user.setAge(9);
        user.setName("shakirah");
        user.setRole(ADMINISTRATORS);
        user.setUserId(user.getUserId());

        CreditCardInformation creditCardInformation = new CreditCardInformation();
        BillingInformation billingInformation = new BillingInformation();
        creditCardInformation.setCardNumber("123456789");
        creditCardInformation.setExpiryMonth("12");
        creditCardInformation.setExpiryYear("2020");
        creditCardInformation.setCvv("123");
        creditCardInformation.setCardType(VERVE);
        creditCardInformation.setId(creditCardInformation.getId());
        BillingInformationDtoRequest billingInformationDtoRequest = new BillingInformationDtoRequest();
        billingInformationDtoRequest.setCreditCardInformation(creditCardInformation);
        billingInformationDtoRequest.setDeliveryAddress("lagos");
        billingInformationDtoRequest.setEmail("lagos@gmail.com");
        billingInformationDtoRequest.setName("shakirah");
        billingInformationDtoRequest.setPhoneNumber("080123456789");
        billingInformationDtoRequest.setUser(user);

        billingInformation.setUser(billingInformationDtoRequest.getUser());
        billingInformation.setName(billingInformationDtoRequest.getName());
        billingInformation.setEmail(billingInformationDtoRequest.getEmail());
        billingInformation.setPhoneNumber(billingInformationDtoRequest.getPhoneNumber());
        billingInformation.setCreditCardInformation(billingInformationDtoRequest.getCreditCardInformation());
        billingInformation.setDeliveryAddress(billingInformationDtoRequest.getDeliveryAddress());
        AddBillingInformationResponse addBillingInformationResponse = billingInformationService.addBillingInformation(billingInformationDtoRequest);

        String id = addBillingInformationResponse.getBillingId();
        BillingInformationUpdateRequest billingInformationUpdateRequest = new BillingInformationUpdateRequest();
        billingInformationUpdateRequest.setId(id);
        billingInformationUpdateRequest.setName("Okikiola");
        billingInformationUpdateRequest.setEmail("okikiola@gmail.com");
        billingInformationUpdateRequest.setUser(user);
        BillingInformationUpdateResponse billingInformationUpdateResponse = billingInformationService.updateBillingInformationByUser(billingInformationUpdateRequest);
        assertEquals(billingInformationUpdateResponse.getMessage(), "Billing Information updated successfully");
    }

    @Test
    public void testDeleteBillingInformation() {
        User user = new User();
        user.setAddress("abuja");
        user.setGender("female");
        user.setEmailAddress("shakirah@gmail.com");
        user.setPhoneNumber("123456789");
        user.setPassword("password");
        user.setAge(9);
        user.setName("shakirah");
        user.setRole(ADMINISTRATORS);
        user.setUserId(user.getUserId());

        CreditCardInformation creditCardInformation = new CreditCardInformation();
        BillingInformation billingInformation = new BillingInformation();
        creditCardInformation.setCardNumber("123456789");
        creditCardInformation.setExpiryMonth("12");
        creditCardInformation.setExpiryYear("2020");
        creditCardInformation.setCvv("123");
        creditCardInformation.setCardType(VERVE);

        BillingInformationDtoRequest billingInformationDtoRequest = new BillingInformationDtoRequest();
        billingInformationDtoRequest.setCreditCardInformation(creditCardInformation);
        billingInformationDtoRequest.setDeliveryAddress("lagos");
        billingInformationDtoRequest.setEmail("lagos@gmail.com");
        billingInformationDtoRequest.setName("shakirah");
        billingInformationDtoRequest.setPhoneNumber("080123456789");
        billingInformationDtoRequest.setUser(user);

        billingInformation.setUser(billingInformationDtoRequest.getUser());
        billingInformation.setName(billingInformationDtoRequest.getName());
        billingInformation.setEmail(billingInformationDtoRequest.getEmail());
        billingInformation.setPhoneNumber(billingInformationDtoRequest.getPhoneNumber());
        billingInformation.setCreditCardInformation(billingInformationDtoRequest.getCreditCardInformation());
        billingInformation.setDeliveryAddress(billingInformationDtoRequest.getDeliveryAddress());
        billingInformation.setUser(billingInformationDtoRequest.getUser());
        billingInformationService.addBillingInformation(billingInformationDtoRequest);

        DeleteBillingInformationRequest deleteBillingInformationRequest = new DeleteBillingInformationRequest();
        deleteBillingInformationRequest.setUser(user);
        String response = billingInformationService.deleteBillingInformation(deleteBillingInformationRequest);
        assertEquals(response, "Billing Information deleted successfully");
    }

    @Test
    public void testFindAllBillingInformation() {
        User user = new User();
        user.setAddress("abuja");
        user.setGender("female");
        user.setEmailAddress("shakirah@gmail.com");
        user.setPhoneNumber("123456789");
        user.setPassword("password");
        user.setAge(9);
        user.setName("shakirah");
        user.setRole(ADMINISTRATORS);
        user.setUserId(user.getUserId());
        CreditCardInformation creditCardInformation = new CreditCardInformation();
        BillingInformation billingInformation = new BillingInformation();
        creditCardInformation.setCardNumber("123456789");
        creditCardInformation.setExpiryMonth("12");
        creditCardInformation.setExpiryYear("2020");
        creditCardInformation.setCvv("123");
        creditCardInformation.setCardType(VERVE);

        BillingInformationDtoRequest billingInformationDtoRequest = new BillingInformationDtoRequest();
        billingInformationDtoRequest.setCreditCardInformation(creditCardInformation);
        billingInformationDtoRequest.setDeliveryAddress("lagos");
        billingInformationDtoRequest.setEmail("lagos@gmail.com");
        billingInformationDtoRequest.setName("shakirah");
        billingInformationDtoRequest.setPhoneNumber("080123456789");
        billingInformationDtoRequest.setUser(user);

        billingInformation.setName(billingInformationDtoRequest.getName());
        billingInformation.setEmail(billingInformationDtoRequest.getEmail());
        billingInformation.setPhoneNumber(billingInformationDtoRequest.getPhoneNumber());
        billingInformation.setCreditCardInformation(billingInformationDtoRequest.getCreditCardInformation());
        billingInformation.setDeliveryAddress(billingInformationDtoRequest.getDeliveryAddress());
        billingInformation.setUser(billingInformationDtoRequest.getUser());
        billingInformation.setUser(user);
        billingInformationService.addBillingInformation(billingInformationDtoRequest);

       GetListBillingInformation getListBillingInformation = new GetListBillingInformation();
       getListBillingInformation.setUserRole(ADMINISTRATORS);
       getListBillingInformation.setUser(user);
        List<BillingInformation> billingInformationList = billingInformationService.getAllBillingInformationByUserRole(getListBillingInformation);
        assertEquals(billingInformationList.size(), 1);
    }

}
