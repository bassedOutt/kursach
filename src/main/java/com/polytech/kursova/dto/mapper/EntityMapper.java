package com.polytech.kursova.dto.mapper;

import com.polytech.kursova.dto.CaseDto;
import com.polytech.kursova.dto.CustomerDto;
import com.polytech.kursova.dto.EmployeeDto;
import com.polytech.kursova.entity.Case;
import com.polytech.kursova.entity.Customer;
import com.polytech.kursova.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface EntityMapper {
    EntityMapper INSTANCE = Mappers.getMapper(EntityMapper.class);


    //-------------------------------------------------Customer Mapping

    @Named("toCustomerDto")
    @Mapping(target = "cases", qualifiedByName = "toCustomerCases")
    CustomerDto toCustomerDto(Customer customer);

    @Named("toCustomerCases")
    default Set<CaseDto> toCustomerCases(Set<Case> cases){
        return cases.stream()
                .map(this::toCustomerCase)
                .collect(Collectors.toSet());
    }

    @Named("toCustomerCase")
    @Mapping(target = "customer", ignore = true)
    @Mapping(target = "employees",ignore = true)
    CaseDto toCustomerCase(Case caze);

    Customer fromCustomerDto(CustomerDto customerDto);

    //-------------------------------------------------Employee Mapping

    @Named("toEmployeeDto")
    @Mapping(target = "employeeCases", qualifiedByName = "toEmployeeCases")
    EmployeeDto toEmployeeDto(Employee employee);

    @Named("toEmployeeCases")
    default Set<CaseDto> toEmployeeCases(Set<Case> cases){
        return cases.stream()
                .map(this::toEmployeeCase)
                .collect(Collectors.toSet());
    }

    @Named("toEmployeeCase")
    @Mapping(target = "customer", qualifiedByName = "toCustomerWithoutCases")
    @Mapping(target = "employees",ignore = true)
    CaseDto toEmployeeCase(Case caze);

    @Named("toCustomerWithoutCases")
    @Mapping(target = "cases", ignore = true)
    CustomerDto toCustomerWithoutCases(Customer customer);

    Employee fromEmployeeDto(EmployeeDto employeeDto);
}
