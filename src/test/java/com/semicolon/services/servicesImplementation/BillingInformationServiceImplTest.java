package com.semicolon.services.servicesImplementation;

import com.semicolon.data.model.BillingInformation;
import com.semicolon.data.model.CreditCardInformation;
import com.semicolon.data.model.User;
import com.semicolon.data.repositories.BillingInformationRepository;
import com.semicolon.data.repositories.CreditCardInformationRepository;
import com.semicolon.data.repositories.UserRepository;
import com.semicolon.dto.request.*;
import com.semicolon.dto.response.AddBillingInformationResponse;
import com.semicolon.dto.response.AddCreditCardInformationResponse;
import com.semicolon.dto.response.AddUserResponse;
import com.semicolon.dto.response.BillingInformationUpdateResponse;
import com.semicolon.services.serviceInterface.BillingInformationService;

import com.semicolon.services.serviceInterface.CreditCardInformationService;
import com.semicolon.services.serviceInterface.UserService;
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
    private CreditCardInformationService creditCardInformationService;
    @Autowired
    private BillingInformationRepository billingInformationRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private BillingInformationService billingInformationService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CreditCardInformationRepository creditCardInformationRepository;

    @BeforeEach
    void setUp() {
        billingInformationRepository.deleteAll();
    }


    @Test
    public void testAddBillingInformation() {
        UserDtoRequest userDtoRequest = new UserDtoRequest();
        userDtoRequest.setAddress("abuja");
        userDtoRequest.setGender("female");
        userDtoRequest.setEmailAddress("shakirah@gmail.com");
        userDtoRequest.setPhoneNumber("123456789");
        userDtoRequest.setPassword("password");
        userDtoRequest.setAge(9);
        userDtoRequest.setName("shakirah");
        userDtoRequest.setRole(ADMINISTRATORS);
        AddUserResponse addUserResponse = userService.addUser(userDtoRequest);


        User user = userRepository.findUserByUserId(addUserResponse.getId());
        CreditCardInformationDtoRequest creditCardInformationDtoRequest = getCreditCardInformationDtoRequest(user);
        AddCreditCardInformationResponse addCreditCardInformationResponse = creditCardInformationService.addCreditCardInformation(creditCardInformationDtoRequest);

        BillingInformationDtoRequest billingInformationDtoRequest = new BillingInformationDtoRequest();

        CreditCardInformation creditCardInformation = creditCardInformationRepository.findCreditCardInformationById(addUserResponse.getId());
        billingInformationDtoRequest.setCreditCardInformation(creditCardInformation);
        billingInformationDtoRequest.setEmail("lagos@gmail.com");
        billingInformationDtoRequest.setName("shakirah");
        billingInformationDtoRequest.setPhoneNumber("080123456789");
        billingInformationDtoRequest.setUser(user);


        billingInformationService.addBillingInformation(billingInformationDtoRequest);
        AddBillingInformationResponse addBillingInformationResponse = billingInformationService.addBillingInformation(billingInformationDtoRequest);
        assertEquals(addBillingInformationResponse.getMessage(), "Billing Information Added");
    }


    @Test
    public void testUpdateBillingInformation() {
        UserDtoRequest userDtoRequest = new UserDtoRequest();
        userDtoRequest.setAddress("abuja");
        userDtoRequest.setGender("female");
        userDtoRequest.setEmailAddress("shakirah@gmail.com");
        userDtoRequest.setPhoneNumber("123456789");
        userDtoRequest.setPassword("password");
        userDtoRequest.setAge(9);
        userDtoRequest.setName("shakirah");
        userDtoRequest.setRole(ADMINISTRATORS);
        AddUserResponse addUserResponse = userService.addUser(userDtoRequest);


        User user = userRepository.findUserByUserId(addUserResponse.getId());
        CreditCardInformationDtoRequest creditCardInformationDtoRequest = getCreditCardInformationDtoRequest(user);
        AddCreditCardInformationResponse addCreditCardInformationResponse = creditCardInformationService.addCreditCardInformation(creditCardInformationDtoRequest);

        BillingInformationDtoRequest billingInformationDtoRequest = new BillingInformationDtoRequest();

        CreditCardInformation creditCardInformation = creditCardInformationRepository.findCreditCardInformationById(addUserResponse.getId());
        billingInformationDtoRequest.setCreditCardInformation(creditCardInformation);
        billingInformationDtoRequest.setEmail("lagos@gmail.com");
        billingInformationDtoRequest.setName("shakirah");
        billingInformationDtoRequest.setPhoneNumber("080123456789");
        billingInformationDtoRequest.setUser(user);


        AddBillingInformationResponse addBillingInformationResponse = billingInformationService.addBillingInformation(billingInformationDtoRequest);
        assertEquals(addBillingInformationResponse.getMessage(), "Billing Information Added");
        BillingInformationUpdateRequest billingInformationUpdateRequest = new BillingInformationUpdateRequest();

        billingInformationUpdateRequest.setName("Okikiola");
        billingInformationUpdateRequest.setEmail("okikiola@gmail.com");
        billingInformationUpdateRequest.setUser(user);
        BillingInformationUpdateResponse billingInformationUpdateResponse = billingInformationService.updateBillingInformationByUser(billingInformationUpdateRequest);
        assertEquals(billingInformationUpdateResponse.getMessage(), "Billing Information updated successfully");
    }

    @Test
    public void testDeleteBillingInformation() {
        UserDtoRequest userDtoRequest = new UserDtoRequest();
        userDtoRequest.setAddress("abuja");
        userDtoRequest.setGender("female");
        userDtoRequest.setEmailAddress("shakirah@gmail.com");
        userDtoRequest.setPhoneNumber("123456789");
        userDtoRequest.setPassword("password");
        userDtoRequest.setAge(9);
        userDtoRequest.setName("shakirah");
        userDtoRequest.setRole(ADMINISTRATORS);
        AddUserResponse addUserResponse = userService.addUser(userDtoRequest);


        User user = userRepository.findUserByUserId(addUserResponse.getId());
        CreditCardInformationDtoRequest creditCardInformationDtoRequest = getCreditCardInformationDtoRequest(user);
        AddCreditCardInformationResponse addCreditCardInformationResponse = creditCardInformationService.addCreditCardInformation(creditCardInformationDtoRequest);

        BillingInformationDtoRequest billingInformationDtoRequest = new BillingInformationDtoRequest();

        CreditCardInformation creditCardInformation = creditCardInformationRepository.findCreditCardInformationById(addUserResponse.getId());
        billingInformationDtoRequest.setCreditCardInformation(creditCardInformation);
        billingInformationDtoRequest.setEmail("lagos@gmail.com");
        billingInformationDtoRequest.setName("shakirah");
        billingInformationDtoRequest.setPhoneNumber("080123456789");
        billingInformationDtoRequest.setUser(user);


        AddBillingInformationResponse addBillingInformationResponse = billingInformationService.addBillingInformation(billingInformationDtoRequest);
        DeleteBillingInformationRequest deleteBillingInformationRequest = new DeleteBillingInformationRequest();
        deleteBillingInformationRequest.setUser(user);
        String response = billingInformationService.deleteBillingInformation(deleteBillingInformationRequest);
        assertEquals(response, "Billing Information deleted successfully");
    }

    @Test
    public void testFindAllBillingInformation() {
        UserDtoRequest userDtoRequest = new UserDtoRequest();
        userDtoRequest.setAddress("abuja");
        userDtoRequest.setGender("female");
        userDtoRequest.setEmailAddress("shakirah@gmail.com");
        userDtoRequest.setPhoneNumber("123456789");
        userDtoRequest.setPassword("password");
        userDtoRequest.setAge(9);
        userDtoRequest.setName("shakirah");
        userDtoRequest.setRole(ADMINISTRATORS);
        AddUserResponse addUserResponse = userService.addUser(userDtoRequest);


        User user = userRepository.findUserByUserId(addUserResponse.getId());
        CreditCardInformationDtoRequest creditCardInformationDtoRequest = getCreditCardInformationDtoRequest(user);
        AddCreditCardInformationResponse addCreditCardInformationResponse = creditCardInformationService.addCreditCardInformation(creditCardInformationDtoRequest);

        BillingInformationDtoRequest billingInformationDtoRequest = new BillingInformationDtoRequest();

        CreditCardInformation creditCardInformation = creditCardInformationRepository.findCreditCardInformationById(addUserResponse.getId());
        billingInformationDtoRequest.setCreditCardInformation(creditCardInformation);
        billingInformationDtoRequest.setEmail("lagos@gmail.com");
        billingInformationDtoRequest.setName("shakirah");
        billingInformationDtoRequest.setPhoneNumber("080123456789");
        billingInformationDtoRequest.setUser(user);


        AddBillingInformationResponse addBillingInformationResponse = billingInformationService.addBillingInformation(billingInformationDtoRequest);
        GetListBillingInformation getListBillingInformation = new GetListBillingInformation();
        getListBillingInformation.setUser(user);
        List<BillingInformation> billingInformationList = billingInformationService.getAllBillingInformationByUserRole(getListBillingInformation);
        assertEquals(billingInformationList.size(), 1);
    }


    private static CreditCardInformationDtoRequest getCreditCardInformationDtoRequest(User user) {
        CreditCardInformationDtoRequest creditCardInformationDtoRequest = new CreditCardInformationDtoRequest();
        creditCardInformationDtoRequest.setCardNumber("123456789");
        creditCardInformationDtoRequest.setExpiryMonth("12");
        creditCardInformationDtoRequest.setExpiryYear("2020");
        creditCardInformationDtoRequest.setCardType(VERVE);
        creditCardInformationDtoRequest.setCvv("123");
        creditCardInformationDtoRequest.setCardHolderName("okiki");
        creditCardInformationDtoRequest.setUser(user);
        return creditCardInformationDtoRequest;
    }
}
