package be.abis.courseadmin.service;

import be.abis.courseadmin.model.Company;

import java.util.ArrayList;

public interface CompanyService {
     public ArrayList<Company> sortAllCompaniesByName();
     public ArrayList<Company> sortAllCompaniesByCompanyNumber();

}
