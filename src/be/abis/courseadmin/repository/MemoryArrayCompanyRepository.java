package be.abis.courseadmin.repository;

import be.abis.courseadmin.exception.CompanyNotFoundException;
import be.abis.courseadmin.model.Company;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.nio.Buffer;
import java.util.ArrayList;

public class MemoryArrayCompanyRepository implements  CompanyRepository{

    private Company[] companyList = new Company[5];

    public MemoryArrayCompanyRepository() {

        companyList[0] = new Company("ABIS",1);
        companyList[1] = new Company("BNP",2);
        companyList[2] = new Company("FORTIS",3);
        companyList[3] = new Company("IBM",4);
        companyList[4] = new Company("U2U",5);
    }

    @Override
    public Company findCompany(int id) {
        return companyList[id];
    }

    @Override
    public Company findCompany(String name) throws CompanyNotFoundException {
        for (Company company:companyList){
           if (company.getName().equals(name)){
               return company;
           }else { throw new CompanyNotFoundException("Société pas trouvée");}

        }

        return null;
    }

    @Override
    public void addCompany(Company c) {

    }

    @Override
    public void updateCompany(Company c) {

    }

    @Override
    public void deleteCompany(int id) {

    }

    @Override
    public ArrayList<Company> getCompanyList() {
        return null;
    }
}
