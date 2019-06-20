package com.decta.homework.cardissue.corporateindividual;

import com.decta.homework.cardissue.idcard.IdCardDTO;
import com.decta.homework.cardissue.registeredaddress.RegisteredAddressDTO;
import com.decta.homework.cardissue.status.CardIssueStatusDTO;
import com.decta.homework.cardissue.status.InquiryStatusDTO;
import com.decta.homework.cardissue.status.RegistrationStatusDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/corporate")
public class CorporateClientController {

    CorporateClientRegistrationService corporateIndividualRegistrationService;
    CorporateClientCardService corporateIndividualCardService;

    @Autowired
    public CorporateClientController(CorporateClientRegistrationService corporateIndividualRegistrationService,
                                     CorporateClientCardService corporateIndividualCardService) {
        this.corporateIndividualRegistrationService = corporateIndividualRegistrationService;
        this.corporateIndividualCardService = corporateIndividualCardService;
    }

    @PostMapping("/registrations")
    public RegistrationStatusDTO register(@RequestBody ExtractFromEnterpriseRegisterDTO extractFromEnterpriseRegisterDTO) {
        return corporateIndividualRegistrationService.register(extractFromEnterpriseRegisterDTO);
    }

    @PostMapping("/cards")
    public CardIssueStatusDTO cardIssue(@RequestBody IdCardDTO idCardDTO,
                                        ExtractFromEnterpriseRegisterDTO extractFromEnterpriseRegisterDTO) {
        return corporateIndividualCardService.cardIssue(idCardDTO, extractFromEnterpriseRegisterDTO);
    }

    @GetMapping("/inquiry")
    public InquiryStatusDTO getInquiry(@RequestBody ExtractFromEnterpriseRegisterDTO extractFromEnterpriseRegisterDTO,
                                       RegisteredAddressDTO registeredAddressDTO) {
        return corporateIndividualCardService.getInquiry(extractFromEnterpriseRegisterDTO, registeredAddressDTO);
    }
}
