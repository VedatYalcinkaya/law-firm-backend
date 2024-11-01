package com.demirciyazilim.avukatrefwebsite.core.utilities.exceptions.problemDetails;

public class BusinessProblemDetails extends ProblemDetails{
    public BusinessProblemDetails(){
        setTitle("Business Rule Violation");
        setType("http://voyajeroyale.com/exceptions/business");
        setStatus("400");
    }
}
