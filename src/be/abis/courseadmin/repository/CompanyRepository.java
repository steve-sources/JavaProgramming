package be.abis.courseadmin.repository;

import be.abis.courseadmin.exception.CompanyNotFoundException;
import be.abis.courseadmin.model.Company;

import java.util.ArrayList;

public interface CompanyRepository {
    Company findCompany(int id);
    Company findCompany(String name) throws CompanyNotFoundException;
    void addCompany(Company c);
    void updateCompany(Company c);
    void deleteCompany(int id);

    public ArrayList<Company> getCompanyList();
}
