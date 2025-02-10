package com.ssafy.wevi.service;

import com.ssafy.wevi.domain.CoupleRequest;
import com.ssafy.wevi.domain.user.Customer;
import com.ssafy.wevi.enums.CoupleRequestStatus;
import com.ssafy.wevi.repository.CoupleRequestRepository;
import com.ssafy.wevi.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CoupleRequestService {

    private final CustomerRepository customerRepository;
    private final CoupleRequestRepository coupleRequestRepository;

    // 커플 요청 보내기
    // 알림도 보내야함
    @Transactional
    public CoupleRequest createCoupleRequest(Integer customerId, String spouseEmail) {
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        Customer spouse = customerRepository.findByEmail(spouseEmail).orElseThrow();

        CoupleRequest coupleRequest = CoupleRequest.builder()
                        .sender(customer)
                        .receiver(spouse)
                        .status(CoupleRequestStatus.PENDING.name())
                        .build();

        coupleRequestRepository.save(coupleRequest);
        return coupleRequest;
    }

}
