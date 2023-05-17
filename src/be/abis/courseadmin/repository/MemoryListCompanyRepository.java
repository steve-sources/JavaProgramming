package be.abis.courseadmin.repository;

import be.abis.courseadmin.exception.CompanyNotFoundException;
import be.abis.courseadmin.model.Company;

import java.util.ArrayList;

public class MemoryListCompanyRepository implements  CompanyRepository{

    ArrayList<Company> companyList = new ArrayList<Company>(10);

    public MemoryListCompanyRepository() {
        this.companyList.add(new Company("ABIS",1));
        this.companyList.add(new Company("BNP",2));
        this.companyList.add(new Company("FORTIS",3));
        this.companyList.add(new Company("IBM",4));
        this.companyList.add(new Company("U2U",5));

    }

    public ArrayList<Company> getCompanyList() {
        return companyList;
    }

    @Override
    public Company findCompany(int id) {
        for (Company s:companyList){
            if (s.getCompanyNumber()==id){return s;}
        }
        return null;
    }

    @Override
    public Company findCompany(String name) throws CompanyNotFoundException {
        for (Company s:companyList){
            if (s.getName()==name){return s;}
        }
        return null;
    }

    @Override
    public void addCompany(Company c) {
        this.companyList.add(c);

    }

    @Override
    public void updateCompany(Company c) {
        for (Company company:companyList){
            if (company.getName()==c.getName()){
                System.out.println("update de la compagnie :" + c.getName());}
        }
    }

    @Override
    public void deleteCompany(int id) {
        for (Company s:companyList){
            if (s.getCompanyNumber()==id){companyList.remove(s);}
        }
    }


}
