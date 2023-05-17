package be.abis.courseadmin.repository;

import be.abis.courseadmin.exception.CompanyNotFoundException;
import be.abis.courseadmin.model.Company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileCompanyRepository implements CompanyRepository {

    ArrayList<Company> companyList = new ArrayList<Company>(10);
    static final String filePath = "C:\\temp\\javacourses\\CampanyList.txt";


    public FileCompanyRepository() {
        try {

            BufferedReader inReader = new BufferedReader(new FileReader(filePath));
            String Line;
            while ((Line=inReader.readLine()) != null){
                String [] partLine = Line.split(";");
                this.companyList.add(new Company(partLine[0],Integer.parseInt(partLine[1])));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
    }
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

    }

    @Override
    public void updateCompany(Company c) {

    }

    @Override
    public void deleteCompany(int id) {

    }

    @Override
    public ArrayList<Company> getCompanyList() {
        return companyList;
    }
}
