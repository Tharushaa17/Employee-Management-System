package com.example.employeems.services;

import com.example.employeems.dto.EmployeeDTO;
import com.example.employeems.entity.Employee;
import com.example.employeems.repo.EmplyeeRepo;
import com.example.employeems.util.VarList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmplyeeRepo emplyeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    public String saveEmployee(EmployeeDTO employeeDTO){
        if(emplyeeRepo.existsById(employeeDTO.getEmpID())){
            return VarList.RSP_DUPLICATE;
        }else {
            emplyeeRepo.save(modelMapper.map(employeeDTO, Employee.class));
            return VarList.RSP_SUCCESS;
        }
    }
    public String updateEmployee(EmployeeDTO employeeDTO){
        if(emplyeeRepo.existsById(employeeDTO.getEmpID())){
            emplyeeRepo.save(modelMapper.map(employeeDTO, Employee.class));
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public List<EmployeeDTO> getAllEmployee(){
        List<Employee> employeeList = emplyeeRepo.findAll();
        return modelMapper.map(employeeList, new TypeToken<ArrayList<EmployeeDTO>>(){
        }.getType());
    }
}
