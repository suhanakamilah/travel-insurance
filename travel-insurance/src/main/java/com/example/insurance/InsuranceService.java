package com.example.insurance;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Service
public class InsuranceService {
    private final InsuranceContainer insuranceContainer;
    public boolean isValidNric(String nric) {

        if (nric == null || !nric.matches("\\d{12}")) {
            return false;
        }

        String datePart = nric.substring(0, 6);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");

        try {
            LocalDate.parse(datePart, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public String extractDOB(String nric) {

        String yy = nric.substring(0, 2);
        String mm = nric.substring(2, 4);
        String dd = nric.substring(4, 6);

        int year = Integer.parseInt(yy);
        int currentYear = LocalDate.now().getYear() % 100;

        int fullYear;

        if (year <= currentYear) {
            fullYear = 2000 + year;
        } else {
            fullYear = 1900 + year;
        }

        return LocalDate.of(fullYear, Integer.parseInt(mm), Integer.parseInt(dd)).toString();
    }

    public String getGender(String nric) {

        int lastDigit = Character.getNumericValue(nric.charAt(11));

        if (lastDigit % 2 == 0) {
            return "F";
        } else {
            return "M";
        }
    }
    public Insurance_policy validateData (Insurance_policy request){

        if (request.getName() == null || request.getName().trim().isEmpty())
            throw new IllegalArgumentException("Name is required");

        if (request.getNric() == null || request.getNric().trim().isEmpty())
            throw new IllegalArgumentException("NRIC is required");

        if (request.getEmail() == null || request.getEmail().trim().isEmpty())
            throw new IllegalArgumentException( "Email is required");

        if (request.getMobile_no() == null || request.getMobile_no().trim().isEmpty())
            throw new IllegalArgumentException( "Mobile No is required");

       if (request.getAddress_line1() == null || request.getAddress_line1().trim().isEmpty())
            throw new IllegalArgumentException( "Address line 1 is required");

        if (request.getPostcode() == null || request.getPostcode().trim().isEmpty())
            throw new IllegalArgumentException( "Postcode is required");

        if (request.getPlan() == null)
            throw new IllegalArgumentException("Plan is required");

        if (request.getArea() == null)
            throw new IllegalArgumentException("Area is required");

        if (request.getCoverage() == null)
            throw new IllegalArgumentException("Coverage is required");

        if (request.getStart_date() == null)
            throw new IllegalArgumentException("Start Date is required");

        if (request.getEnd_date() == null)
            throw new IllegalArgumentException("End Date is required");

        if (request.getCoverage() == Coverage.ANNUAL && request.getArea() == Area.Area_4)
            throw new IllegalArgumentException("Area 4 is not applicable for Annual Coverage");

        if (isValidNric(request.getNric())){
            String gender = getGender(request.getNric())          ;
            request.setGender(gender);

            String dob = extractDOB(request.getNric());
            request.setDob(dob);
        } else throw new IllegalArgumentException("NRIC need to be in yyMMdd format");

        LocalDate today = LocalDate.now();
        final LocalDate startDate = request.getStart_date();
        final LocalDate endDate = request.getEnd_date();

        // Start date must not exceed 1 year from today

        if (startDate.isAfter(today.plusYears(1))) {
            throw new IllegalArgumentException("Start date cannot exceed 1 year from today.");
        }

        // End date must be after start date
        if (endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("End date must be after start date.");
        }

        // End date must not exceed 180 days after start date for single trip
        if (request.getCoverage() == Coverage.SINGLE && endDate.isAfter(startDate.plusDays(180))) {
            throw new IllegalArgumentException("End date cannot exceed 180 days after start date.");
        }

        // End date will be default to 1 year after start date
        if (request.getCoverage() == Coverage.ANNUAL) {
            request.setEndDate(startDate.plusYears(1));
        }

        return request;
    }
    public InsuranceService(InsuranceContainer insuranceContainer) {
        this.insuranceContainer = insuranceContainer;
    }

    public Insurance_policy purchaseInsurance(Insurance_policy request) {
        return insuranceContainer.save(request);
    }


}

