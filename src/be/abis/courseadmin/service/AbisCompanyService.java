package be.abis.courseadmin.service;

import be.abis.courseadmin.exception.CompanyNotFoundException;
import be.abis.courseadmin.model.Company;
import be.abis.courseadmin.repository.CompanyRepository;
import be.abis.courseadmin.repository.MemoryListCompanyRepository;

import java.util.ArrayList;

public class AbisCompanyService implements CompanyService{

    public AbisCompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;

    }

    CompanyRepository companyRepository;


    public CompanyRepository getCompanyRepository() {
        return companyRepository;
    }

    public void setCompanyRepository(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    @Override
    public ArrayList<Company> sortAllCompaniesByName() {
        this.companyRepository.getCompanyList().sort(null);
        ArrayList<Company> companyList = this.companyRepository.getCompanyList();
        return companyList;
    }

    @Override
    public ArrayList<Company> sortAllCompaniesByCompanyNumber() {
        this.companyRepository.getCompanyList().sort(new Company.SortAllByCompanyNumbers());
        ArrayList<Company> companyList = this.companyRepository.getCompanyList();
        return companyList;
    }
}
