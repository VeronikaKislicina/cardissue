package com.decta.homework.cardissue.privateindividual;


import com.decta.homework.cardissue.idcard.IdCardDTO;
import com.decta.homework.cardissue.registeredaddress.RegisteredAddressDTO;
import com.decta.homework.cardissue.status.CardIssueStatusDTO;
import com.decta.homework.cardissue.status.InquiryStatusDTO;
import com.decta.homework.cardissue.status.RegistrationStatusDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/private")
public class PrivateClientController {

    private PrivateClientRegistrationService privateIndividualRegistrationService;
    private PrivateClientCardService privateIndividualCardService;

    @Autowired
    public PrivateClientController(PrivateClientRegistrationService privateIndividualRegistrationService,
                                   PrivateClientCardService privateIndividualCardService) {
        this.privateIndividualRegistrationService = privateIndividualRegistrationService;
        this.privateIndividualCardService = privateIndividualCardService;
    }

    @PostMapping("/registrations")
    public RegistrationStatusDTO register(@RequestBody IdCardDTO idCardDTO, RegisteredAddressDTO registeredAddressDTO) {
        return privateIndividualRegistrationService.register(idCardDTO, registeredAddressDTO);
    }

    @PostMapping("/cards")
    public CardIssueStatusDTO cardIssue(@RequestBody IdCardDTO idCardDTO) {
        return privateIndividualCardService.cardIssue(idCardDTO);
    }

    @GetMapping("/inquiry")
    public InquiryStatusDTO getInquiry(@RequestBody IdCardDTO idCardDTO, RegisteredAddressDTO registeredAddressDTO) {
        return privateIndividualCardService.getInquiry(idCardDTO, registeredAddressDTO);
    }
}
