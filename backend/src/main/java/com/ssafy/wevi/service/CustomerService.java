package com.ssafy.wevi.service;

import com.ssafy.wevi.domain.Customer;
import com.ssafy.wevi.domain.User;
import com.ssafy.wevi.dto.Customer.CustomerCreateDto;
import com.ssafy.wevi.dto.Customer.CustomerResponseDto;
import com.ssafy.wevi.dto.Customer.CustomerSpouseResponseDto;
import com.ssafy.wevi.dto.Customer.CustomerUpdateDto;
import com.ssafy.wevi.enums.UserStatus;
import com.ssafy.wevi.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public CustomerResponseDto createCustomer(CustomerCreateDto customerCreateDto) {
        Customer customer = new Customer();
        customer.setEmail(customerCreateDto.getEmail());
        customer.setNickname(customerCreateDto.getNickname());
        customer.setName(customerCreateDto.getName());
        customer.setPassword(passwordEncoder.encode(customerCreateDto.getPassword()));
        customer.setPhone(customerCreateDto.getPhone());
        customer.setZonecode(customerCreateDto.getZonecode());
        customer.setAutoRoadAddress(customerCreateDto.getAutoRoadAddress());
        customer.setAddressDetail(customerCreateDto.getAddressDetail());
        customer.setStatus(UserStatus.ACTIVE.name());
        customer.setCreatedAt(LocalDateTime.now());

        customerRepository.save(customer);

        return toCustomerResponseDto(customer);
    }

    @Transactional(readOnly = true)
    public CustomerResponseDto findCustomerById(Integer id) {
        return customerRepository.findById(id).map(customer -> toCustomerResponseDto(customer)).orElseThrow();
    }

    @Transactional(readOnly = true)
    public CustomerSpouseResponseDto getSpouse(Integer customerId) {
        // 배우자 정보 조회
        return customerRepository.findById(customerId)
                .map(customer -> customer.getSpouse())
                .filter(Objects::nonNull)
                .map(spouse -> {
                    CustomerSpouseResponseDto customerSpouseResponseDto = new CustomerSpouseResponseDto();
                    customerSpouseResponseDto.setSpouseId(spouse.getUserId());
                    customerSpouseResponseDto.setNickname(spouse.getNickname());
                    customerSpouseResponseDto.setName(spouse.getName());

                    return customerSpouseResponseDto;
                })
                .orElse(null);
    }

    @Transactional
    public CustomerResponseDto updateCustomer(Integer customerId, CustomerUpdateDto customerUpdateDto) {
        return customerRepository.findById(customerId).map(customer -> {
            // 비밀번호가 변경된 경우만 암호화
            if (customerUpdateDto.getPassword() != null && !customerUpdateDto.getPassword().isBlank()) {
                customer.setPassword(passwordEncoder.encode(customerUpdateDto.getPassword()));
            }

            customer.setNickname(customerUpdateDto.getNickname());
            customer.setPhone(customerUpdateDto.getPhone());
            customer.setZonecode(customerUpdateDto.getZonecode());
            customer.setAutoRoadAddress(customerUpdateDto.getAutoRoadAddress());
            customer.setAddressDetail(customerUpdateDto.getAddressDetail());

            customerRepository.save(customer);

            return toCustomerResponseDto(customer);
        }).orElseThrow();
    }

    @Transactional
    public void deactivateCustomer(Integer customerId, HttpServletRequest request, HttpServletResponse response) {
        customerRepository.findById(customerId).ifPresentOrElse(customer -> {
            customer.setStatus(UserStatus.TERMINATED.name());
            customerRepository.save(customer);

            // 탈퇴 후 로그아웃 처리
            new SecurityContextLogoutHandler().logout(request, response, null);
        }, () -> {
            throw new EntityNotFoundException("Customer not found");
        });
    }

    // 배우자 추가 기능도 만들기!!

    // 내가 원하는 값만 내보내기 위해서
    // 예를 들어, 유저 정보를 조회할 때 굳이 계약까지 불러올 필요는 없음
    // 유저 -> 계약 -> 유저 무한루프 발생을 막음
    private CustomerResponseDto toCustomerResponseDto(Customer customer) {
        if (customer == null) return null;

        CustomerResponseDto customerResponseDto = new CustomerResponseDto();
        customerResponseDto.setUserId(customer.getUserId());
        customerResponseDto.setEmail(customer.getEmail());
        customerResponseDto.setNickname(customer.getNickname());
        customerResponseDto.setName(customer.getName());
        customerResponseDto.setPhone(customer.getPhone());
        customerResponseDto.setZonecode(customer.getZonecode());
        customerResponseDto.setAutoRoadAddress(customer.getAutoRoadAddress());
        customerResponseDto.setAddressDetail(customer.getAddressDetail());
        customerResponseDto.setCreatedAt(customer.getCreatedAt());
        customerResponseDto.setSpouseId(customer.getSpouse() != null ? customer.getSpouse().getUserId() : null);

        return customerResponseDto;
    }
}
