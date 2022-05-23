package com.polytech.kursova.dto.mapper;

import com.polytech.kursova.dto.CaseDto;
import com.polytech.kursova.dto.CommentDto;
import com.polytech.kursova.dto.CustomerDto;
import com.polytech.kursova.dto.EmployeeDto;
import com.polytech.kursova.entity.Case;
import com.polytech.kursova.entity.Comment;
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

    @Named("toEmployeesWithoutCases")
    default Set<EmployeeDto> toEmployeesWithoutCases(Set<Employee> employees){
        return employees.stream()
                .map(this::toEmployeeWithoutCase)
                .collect(Collectors.toSet());
    }

    @Named("toEmployeeWithoutCases")
    @Mapping(target = "employeeCases",ignore = true)
    EmployeeDto toEmployeeWithoutCase(Employee employee);

    @Named("toCustomerCase")
    @Mapping(target = "customer", ignore = true)
    @Mapping(target = "employees", qualifiedByName = "toEmployeesWithoutCases")
    @Mapping(target = "comments", qualifiedByName = "toCommentsWithoutEmployees")
    CaseDto toCustomerCase(Case caze);

    Customer fromCustomerDto(CustomerDto customerDto);

    @Named("toCommentsWithoutEmployees")
    default Set<CommentDto> toCommentsWithoutEmployees(Set<Comment> comments){
        return comments.stream()
                .map(this::toCommentWithoutEmployee)
                .collect(Collectors.toSet());
    }

    @Mapping(target = "employee",ignore = true)
    CommentDto toCommentWithoutEmployee(Comment comment);

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
    @Mapping(target = "comments", qualifiedByName = "toCommentsWithoutEmployees")
    CaseDto toEmployeeCase(Case caze);

    @Named("toCustomerWithoutCases")
    @Mapping(target = "cases", ignore = true)
    CustomerDto toCustomerWithoutCases(Customer customer);

    Employee fromEmployeeDto(EmployeeDto employeeDto);

    //-------------------------------------------------Case Mapping

    @Mapping(target = "employees",qualifiedByName = "toEmployeesWithoutCases")
    @Mapping(target = "customer",qualifiedByName = "toCustomerWithoutCases")
    @Mapping(target = "comments",qualifiedByName = "toCommentsWithoutEmployees")
    CaseDto toCaseDto(Case caze);

    Case fromCaseDto(CaseDto caze);

    //-------------------------------------------------Comment Mapping

    @Mapping(target = "employee",qualifiedByName = "toEmployeeDto")
    CommentDto toCommentDto(Comment comment);

}
